/*
 * Copyright (C) 2017 TypeFox and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */
package mcgill.xtext.turn.diagram

import com.google.inject.Inject
import io.typefox.sprotty.api.IDiagramState
import io.typefox.sprotty.api.LayoutOptions
import io.typefox.sprotty.api.SButton
import io.typefox.sprotty.api.SCompartment
import io.typefox.sprotty.api.SEdge
import io.typefox.sprotty.api.SGraph
import io.typefox.sprotty.api.SLabel
import io.typefox.sprotty.api.SModelElement
import io.typefox.sprotty.api.SModelRoot
import io.typefox.sprotty.api.SNode
import io.typefox.sprotty.server.xtext.IDiagramGenerator
import io.typefox.sprotty.server.xtext.tracing.ITraceProvider
import io.typefox.sprotty.server.xtext.tracing.Traceable
import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.parser.IParseResult
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator
import org.xtext.example.mydsl.tURN.Actor
import org.xtext.example.mydsl.tURN.Contribution
import org.xtext.example.mydsl.tURN.Decomposition
import org.xtext.example.mydsl.tURN.Dependency
import org.xtext.example.mydsl.tURN.ElementLink
import org.xtext.example.mydsl.tURN.Evaluation
import org.xtext.example.mydsl.tURN.EvaluationStrategy
import org.xtext.example.mydsl.tURN.IntentionalElement
import org.xtext.example.mydsl.tURN.LongName
import org.xtext.example.mydsl.tURN.impl.ActorImpl
import org.xtext.example.mydsl.tURN.impl.ElementLinkImpl
import org.xtext.example.mydsl.tURN.impl.IntentionalElementImpl
import org.xtext.example.mydsl.tURN.URNspec

class TURNDiagramGenerator implements IDiagramGenerator {
	static val LOG = Logger.getLogger(TURNDiagramGenerator)
	static val CONTRIBUTE_EDGE_TYPE = 'contribute'
	static val CORRELATION_EDGE_TYPE = 'correlated'
	static val DECOMPOSITION_EDGE_TYPE = 'decomposition'
	static val DEPENDENCY_EDGE_TYPE = 'dependency'

	var Map<Actor, SModelElement> actorIndex = new HashMap

	var Map<IntentionalElement, SModelElement> elementIE = new HashMap

	var Map<ElementLink, SModelElement> elementEL = new HashMap

	var Map<Evaluation, SModelElement> elementEV = new HashMap

	var List<()=>void> postProcesses
	var SGraph diagramRoot

	@Inject ITraceProvider traceProvider
	IDiagramState state
	Map<String, TURNNode> id2modules = newHashMap

	Actor diagramModule
	XtextResource xtresource
	ICompositeNode rootNode
	IParseResult parseResult

	override generate(Resource resource, IDiagramState state, CancelIndicator cancelIndicator) {
		val content = resource.contents.head
		this.state = state
		xtresource = resource as XtextResource
		if (xtresource !== null) {
			parseResult = xtresource.getParseResult();

			if (parseResult !== null) {
				rootNode = parseResult.getRootNode();
				for (abstractNode : rootNode.getChildren()) {
					val content1 = abstractNode.semanticElement.eClass.name
					val content2 = abstractNode.semanticElement
					if (content2 instanceof Actor) {
						println('generating actors')
						return generateDiagram(content2, cancelIndicator)
					}
				}
			}
			return null
		}
	}

	def SModelRoot generateDiagram(Actor module, CancelIndicator cancelIndicator) {
		diagramModule = module
		LOG.info("reached generate Diagram '" + "module" + module + "cancel" + cancelIndicator)
		actorIndex = new HashMap
		postProcesses = new ArrayList
		diagramRoot = new SGraph => [
			type = 'graph'
			id = 'turn'
			children = new ArrayList<SModelElement>
			layoutOptions = new LayoutOptions [
				HAlign = 'left'
				HGap = 10.0
				VGap = 0.0
				paddingLeft = 0.0
				paddingRight = 0.0
				paddingTop = 0.0
				paddingBottom = 0.0
			]
		]
		val rootChildren = createChildElements(diagramRoot, diagramRoot, module)
		LOG.info("rootChildren" + rootChildren)
		diagramRoot.children.addAll(rootChildren)
		postProcessing()
		return diagramRoot
	}

	protected def List<SModelElement> createChildElements(SModelElement viewParentElement,
		SModelElement modelParentElement, Actor actor) {
		val rootChildren = new ArrayList()
		var SModelElement element3 = null
		var strategies = (actor.eContainer as URNspec).strategies

		for (ie : actor.elems) {
			var ieType = ie.type.toString
			if (ieType.contains('softgoal')) {
				for (strategy : strategies) {
					for (eval : strategy.evaluations) {
						LOG.info('CrossReference Value =' + eval.eCrossReferences)
						if (eval.eCrossReferences.contains(ie)) {
							element3 = findEvaluation(viewParentElement, modelParentElement, strategies, ie)
						// elementEV.put(eval, element3)
						} else {
							element3 = generateSoftGoal(ie, viewParentElement, modelParentElement)
						}
					}
				}

			} else if (ieType.contains('goal')) {
				element3 = generateGoal(ie, viewParentElement, modelParentElement)
			} else if (ieType.contains('belief')) {
				element3 = generateBelief(ie, viewParentElement, modelParentElement)
			} else if (ieType.contains('task')) {
				element3 = generateTask(ie, viewParentElement, modelParentElement)
			} else if (ieType.contains('resource')) {
				element3 = generateResource(ie, viewParentElement, modelParentElement)
			} else {
				element3 = generateIndicator(ie, viewParentElement, modelParentElement)
			}
			rootChildren.add(element3)
			// element3.trace(ie)
			elementIE.put(ie, element3)
			LOG.info("GOAL HASH MAP = " + elementIE)
		}
		for (elemLink : actor.elems) {
			for (link : elemLink.linksSrc) {
				val element4 = createLinks(viewParentElement, modelParentElement, #[link])
				rootChildren.addAll(element4)
			}
		}
		return rootChildren
	}

	protected def SModelElement findEvaluation(SModelElement viewParentElement, SModelElement modelParentElement,
		List<EvaluationStrategy> strategies, IntentionalElement elem) {
		var SModelElement element = null
		var impQualitative = (elem.importance).toString
		var impQuantitative = elem.importanceQuantitative
		for (strategy : strategies)
			for (firstEval : strategy.evaluations) {
				var qualitative = (firstEval.qualitativeEvaluation).toString
				var quantitative = (firstEval.evaluation).toString
				if (firstEval.exceeds) {
					LOG.info('Entered Goal =' + elem);
					element = generateSoftGoalTry(elem, viewParentElement, modelParentElement)
					val SCompartment moduleHeadingCompartment = configSElement(SCompartment, element.id + '-heading',
						'comp')
					moduleHeadingCompartment.layout = 'hbox'
					element.children.add(moduleHeadingCompartment)

					if (elem.importance.value == 'none' || elem.importanceQuantitative == 0) {
						if (firstEval.qualitativeEvaluation.value == 'none' || firstEval.evaluation == 0) {
							val SLabel moduleLabel = configSElement(SLabel, element.id + '-label', 'heading')
							moduleLabel.text = element.id + ' ' + '(' + impQualitative + ') ' + ' ' + '[' +
								qualitative + ']'
							moduleHeadingCompartment.children.add(moduleLabel)
							return element
						} else {
							val SLabel moduleLabel = configSElement(SLabel, element.id + '-label', 'heading')
							moduleLabel.text = element.id + ' ' + '(' + impQualitative + ') ' + ' ' + '[' +
								quantitative + ']'
							moduleHeadingCompartment.children.add(moduleLabel)
							return element
						}
					} else {
						if (firstEval.qualitativeEvaluation.value == 'none' || firstEval.evaluation == 0) {
							val SLabel moduleLabel = configSElement(SLabel, element.id + '-label', 'heading')
							moduleLabel.text = element.id + ' ' + '(' + impQuantitative + ') ' + ' ' + '[' +
								qualitative + ']'
							moduleHeadingCompartment.children.add(moduleLabel)
							return element
						} else {
							val SLabel moduleLabel = configSElement(SLabel, element.id + '-label', 'heading')
							moduleLabel.text = element.id + ' ' + '(' + impQuantitative + ') ' + ' ' + '[' +
								quantitative + ']'
							moduleHeadingCompartment.children.add(moduleLabel)
							return element
						}

					}

				}
			}
	}

	protected def List<SModelElement> createLinks(SModelElement viewParentElement, SModelElement modelParentElement,
		List<ElementLink> links) {
		val rootChildren = new ArrayList()
		for (link : links) {
			var SModelElement element = null
			element = generateElement(link, viewParentElement, modelParentElement)
			elementEL.put(link, element)
			LOG.info("Link Hash Map" + elementEL)
			if (!rootChildren.contains(element)) {
				rootChildren.add(element)
				element.trace(link)
			}
		}
		return rootChildren
	}

	protected def dispatch SModelElement generateElementActor(Actor actor, SModelElement viewParentElement,
		SModelElement modelParentElement) {
		var SModelElement elementActor = null
		elementActor = generateActorModule(actor, viewParentElement, modelParentElement)
		elementActor.trace(actor)
		actorIndex.put(actor, elementActor)
		LOG.info("Actor HASH MAP = " + actorIndex)
		elementActor.children.addAll(createChildElements(viewParentElement, modelParentElement, actor))
		return elementActor
	}

	protected def dispatch SModelElement generateElement1(Actor moduleStmt, SModelElement viewParentElement,
		SModelElement modelParentElement) {
		return generateElementActor(moduleStmt, viewParentElement, modelParentElement)
	}

	protected def void trace(SModelElement element, Actor actor) {
		if (element instanceof Traceable)
			traceProvider.trace(element, actor)
	}

	protected def void trace(SModelElement element, IntentionalElement elem) {
		if (element instanceof Traceable)
			traceProvider.trace(element, elem)
	}

	protected def void trace(SModelElement element, ElementLink linksrc) {
		if (element instanceof Traceable)
			traceProvider.trace(element, linksrc)
	}

	protected def dispatch SModelElement generateElement(Contribution contribution, SModelElement viewParentElement,
		SModelElement modelParentElement) {
		var contributeValue = contribution.contribution.getName
		var quantativeValue = (contribution.quantitativeContribution).toString
		val sourceGoal = elementIE.get(contribution.eContainer)
		LOG.info("sourceGoal = " + sourceGoal.id)
		val destinationGoal = elementIE.get(contribution.dest)
		LOG.info("destinationGoal = " + destinationGoal.id)

		if (sourceGoal !== null || destinationGoal !== null) {
			if (contribution.correlation) {
				val SEdge edge = createEdge(destinationGoal, sourceGoal, CORRELATION_EDGE_TYPE)
				LOG.info("SEDGE = " + edge)
				elementEL.put(contribution, edge)
				if (contribution.contribution.value == 'undefined' || contribution.quantitativeContribution == 0) {
					val SLabel edgeLabel = configSElement(SLabel, edge.id + '-label', 'heading')
					edgeLabel.text = contributeValue
					edge.children.add(edgeLabel)
					return edge
				} else {
					val SLabel edgeLabel = configSElement(SLabel, edge.id + '-label', 'heading')
					edgeLabel.text = quantativeValue
					edge.children.add(edgeLabel)
					return edge
				}
			} else {
				val SEdge edge = createEdge(destinationGoal, sourceGoal, CONTRIBUTE_EDGE_TYPE)
				LOG.info("SEDGE = " + edge)
				elementEL.put(contribution, edge)
				if (contribution.contribution.value == 'undefined' || contribution.quantitativeContribution == 0) {
					val SLabel edgeLabel = configSElement(SLabel, edge.id + '-label', 'heading')
					edgeLabel.text = contributeValue
					edge.children.add(edgeLabel)
					return edge
				} else {
					val SLabel edgeLabel = configSElement(SLabel, edge.id + '-label', 'heading')
					edgeLabel.text = quantativeValue
					edge.children.add(edgeLabel)
					return edge
				}
			}
		}
	}

	protected def dispatch SModelElement generateElement(Decomposition decomposition, SModelElement viewParentElement,
		SModelElement modelParentElement) {
		var decompose = decomposition.decompositionType.getName
		val sourceGoal = elementIE.get(decomposition.eContainer)
		LOG.info("sourceGoal = " + sourceGoal.id)
		val destinationGoal = elementIE.get(decomposition.dest)
		LOG.info("destinationGoal = " + destinationGoal.id)
		if (sourceGoal !== null || destinationGoal !== null) {
			val SEdge edge = createEdge(destinationGoal, sourceGoal, DECOMPOSITION_EDGE_TYPE)
			LOG.info("SEDGE = " + edge)
			elementEL.put(decomposition, edge)
			val SLabel edgeLabel = configSElement(SLabel, edge.id + '-label', 'heading')
			edgeLabel.text = decompose
			edge.children.add(edgeLabel)
			return edge
		}
	}

	protected def dispatch SModelElement generateElement(Dependency dependency, SModelElement viewParentElement,
		SModelElement modelParentElement) {
		var sourceGoal = elementIE.get(dependency.eContainer)
		var destinationGoal = elementIE.get(dependency.dest)
		if (dependency.eContainer.eContainer == dependency.dest.eContainer) {
			LOG.info("destGoal info =" + dependency.dest.eContainer)
			if (sourceGoal !== null || destinationGoal !== null) {
				val SEdge edge = createEdge(sourceGoal, destinationGoal, DEPENDENCY_EDGE_TYPE)
				LOG.info("SEDGE = " + edge)
				elementEL.put(dependency, edge)
				return edge
			}
		} else {
			if (!actorIndex.values.contains(dependency.dest.eContainer)) {
				var actObj = dependency.dest.eContainer
				val createActor = generateElement(actObj, viewParentElement, modelParentElement)
				modelParentElement.children.add(createActor)
				return generateElementDependencyLink(dependency, viewParentElement, modelParentElement)
			}
		}
	}

	protected def dispatch SModelElement generateElementDependencyLink(Dependency dependency,
		SModelElement viewParentElement, SModelElement modelParentElement) {
		var sourceGoal = elementIE.get(dependency.eContainer)
		var destinationGoal = elementIE.get(dependency.dest)
		LOG.info("destGoal info =" + dependency.dest.eContainer)
		if (sourceGoal !== null || destinationGoal !== null) {
			val SEdge edge = createEdge(sourceGoal, destinationGoal, DEPENDENCY_EDGE_TYPE)
			LOG.info("SEDGE = " + edge)
			elementEL.put(dependency, edge)
			return edge
		}
	}

	protected def SEdge createEdge(SModelElement fromElement, SModelElement toElement, String edgeType) {
		val SEdge edge = configSElement(SEdge, fromElement.id + '2' + toElement.id + 'importance', edgeType)
		edge.sourceId = fromElement.id
		edge.targetId = toElement.id
		return edge
	}

	protected def TURNNode createNodeWithHeadingLabel(String id, String name, String type) {
		val classElement = configSElement(TURNNode, id + '-' + name + '-' + type, type)
		classElement.layout = 'hbox'

		val headingContainer = configSElement(SCompartment, classElement.id + '-heading', 'importance')
		headingContainer.layout = 'hbox'
		headingContainer.layoutOptions = new LayoutOptions [
			paddingFactor = 10.0
			paddingLeft = 10.0
			paddingRight = 10.0
			paddingTop = 10.0
			paddingBottom = 10.0
		]

		val heading = configSElement(SLabel, headingContainer.id + '-label', 'description')
		// changed ln = id
		heading.text = name
		headingContainer.children.add(heading)
		classElement.children.add(headingContainer)
		return classElement
	}

	protected def SCompartment createClassMemberCompartment(String id) {
		val compartment = configSElement(SCompartment, id + '-compartment', 'comp')
		compartment.layout = 'hbox'
		compartment.layoutOptions = new LayoutOptions [
			paddingFactor = 1.0
			paddingLeft = 0.0
			paddingRight = 0.0
			paddingTop = 0.0
			paddingBottom = 0.0
		]
		return compartment
	}

	protected def <E extends SModelElement> E configSElement(Class<E> elementClass, String idStr, String typeStr) {
		elementClass.constructor.newInstance => [
			id = idStr
			type = findType(it) + ':' + typeStr
			children = new ArrayList<SModelElement>
		]
	}

	protected def TURNNode createModule2(String longName, IntentionalElement moduleStmt) {
		val moduleElement = configSElement(TURNNode, longName, 'goal')
		var impQualitative = (moduleStmt.importance).toString
		var impQuantitative = moduleStmt.importanceQuantitative

		moduleElement.layout = 'hbox'
		moduleElement.layoutOptions = new LayoutOptions [
			paddingTop = 10.0
			paddingBottom = 10.0
			paddingLeft = 10.0
			paddingRight = 10.0
			resizeContainer = true
		]

		val SCompartment moduleHeadingCompartment = configSElement(SCompartment, moduleElement.id + '-heading', 'comp')
		moduleHeadingCompartment.layout = 'hbox'
		moduleElement.children.add(moduleHeadingCompartment)

		if (moduleStmt.importance.value == 'none' || moduleStmt.importanceQuantitative == 0) {
			val SLabel moduleLabel = configSElement(SLabel, moduleElement.id + '-label', 'heading')
			moduleLabel.text = longName + ' ' + '(' + impQualitative + ')'
			moduleHeadingCompartment.children.add(moduleLabel)
			return moduleElement
		} else {
			LOG.info('moduleStmt =' + moduleStmt.eContainer.eContents)
			val SLabel moduleLabel = configSElement(SLabel, moduleElement.id + '-label', 'heading')
			moduleLabel.text = longName + ' ' + '(' + impQuantitative + ')'
			moduleHeadingCompartment.children.add(moduleLabel)
			return moduleElement
		}
	}

	protected def TURNNode createModule2SG(String longName, IntentionalElement moduleStmt) {
		val moduleElement = configSElement(TURNNode, longName, 'softgoal')
		var impQualitative = moduleStmt.importance
		var impQuantitative = moduleStmt.importanceQuantitative
		moduleElement.layout = 'hbox'
		moduleElement.layoutOptions = new LayoutOptions [
			paddingTop = 10.0
			paddingBottom = 10.0
			paddingLeft = 10.0
			paddingRight = 10.0
			resizeContainer = true
		]

		val SCompartment moduleHeadingCompartment = configSElement(SCompartment, moduleElement.id + '-heading', 'comp')
		moduleHeadingCompartment.layout = 'hbox'
		moduleElement.children.add(moduleHeadingCompartment)

		if (moduleStmt.importance.value == 'none' || moduleStmt.importanceQuantitative == 0) {
			val SLabel moduleLabel = configSElement(SLabel, moduleElement.id + '-label', 'heading')
			moduleLabel.text = longName + ' ' + '(' + impQualitative + ')'
			moduleHeadingCompartment.children.add(moduleLabel)
			return moduleElement
		} else {
			LOG.info('moduleStmt =' + moduleStmt.eContainer.eContents)
			val SLabel moduleLabel = configSElement(SLabel, moduleElement.id + '-label', 'heading')
			moduleLabel.text = longName + ' ' + '(' + impQuantitative + ')'
			moduleHeadingCompartment.children.add(moduleLabel)
			return moduleElement
		}
	}

	// SOFTGOAL TRY
	protected def TURNNode createModule2SGTry(String longName) {
		val moduleElement = configSElement(TURNNode, longName, 'softgoaltry')
		moduleElement.layout = 'hbox'
		moduleElement.layoutOptions = new LayoutOptions [
			paddingTop = 10.0
			paddingBottom = 10.0
			paddingLeft = 10.0
			paddingRight = 10.0
			resizeContainer = true
		]
		return moduleElement
	}

	protected def TURNNode createBelief(String longName, IntentionalElement moduleStmt) {
		val moduleElement = configSElement(TURNNode, longName, 'belief')
		var impQualitative = moduleStmt.importance
		var impQuantitative = moduleStmt.importanceQuantitative
		moduleElement.layout = 'hbox'
		moduleElement.layoutOptions = new LayoutOptions [
			paddingTop = 10.0
			paddingBottom = 10.0
			paddingLeft = 10.0
			paddingRight = 10.0
			resizeContainer = true
		]

		val SCompartment moduleHeadingCompartment = configSElement(SCompartment, moduleElement.id + '-heading', 'comp')
		moduleHeadingCompartment.layout = 'hbox'
		moduleElement.children.add(moduleHeadingCompartment)

		if (moduleStmt.importance.value == 'none' || moduleStmt.importanceQuantitative == 0) {
			val SLabel moduleLabel = configSElement(SLabel, moduleElement.id + '-label', 'heading')
			moduleLabel.text = longName + ' ' + '(' + impQualitative + ')'
			moduleHeadingCompartment.children.add(moduleLabel)
			return moduleElement
		} else {
			LOG.info('moduleStmt =' + moduleStmt.eContainer.eContents)
			val SLabel moduleLabel = configSElement(SLabel, moduleElement.id + '-label', 'heading')
			moduleLabel.text = longName + ' ' + '(' + impQuantitative + ')'
			moduleHeadingCompartment.children.add(moduleLabel)
			return moduleElement
		}
	}

	protected def TURNNode createTask(String longName, IntentionalElement moduleStmt) {
		val moduleElement = configSElement(TURNNode, longName, 'task')
		var impQualitative = (moduleStmt.importance).toString
		var impQuantitative = moduleStmt.importanceQuantitative
		moduleElement.layout = 'hbox'
		moduleElement.layoutOptions = new LayoutOptions [
			paddingTop = 10.0
			paddingBottom = 10.0
			paddingLeft = 10.0
			paddingRight = 10.0
			resizeContainer = true
		]

		val SCompartment moduleHeadingCompartment = configSElement(SCompartment, moduleElement.id + '-heading', 'comp')
		moduleHeadingCompartment.layout = 'hbox'
		moduleElement.children.add(moduleHeadingCompartment)

		if (moduleStmt.importance.value == 'none' || moduleStmt.importanceQuantitative == 0) {
			val SLabel moduleLabel = configSElement(SLabel, moduleElement.id + '-label', 'heading')
			moduleLabel.text = longName + ' ' + '(' + impQualitative + ')'
			moduleHeadingCompartment.children.add(moduleLabel)
			return moduleElement
		} else {
			LOG.info('moduleStmt =' + moduleStmt.eContainer.eContents)
			val SLabel moduleLabel = configSElement(SLabel, moduleElement.id + '-label', 'heading')
			moduleLabel.text = longName + ' ' + '(' + impQuantitative + ')'
			moduleHeadingCompartment.children.add(moduleLabel)
			return moduleElement
		}
	}

	protected def TURNNode createResource(String longName, IntentionalElement moduleStmt) {
		val moduleElement = configSElement(TURNNode, longName, 'resource')
		var impQualitative = (moduleStmt.importance).toString
		var impQuantitative = moduleStmt.importanceQuantitative

		moduleElement.layout = 'hbox'
		moduleElement.layoutOptions = new LayoutOptions [
			paddingTop = 10.0
			paddingBottom = 10.0
			paddingLeft = 10.0
			paddingRight = 10.0
			resizeContainer = true
		]

		val SCompartment moduleHeadingCompartment = configSElement(SCompartment, moduleElement.id + '-heading', 'comp')
		moduleHeadingCompartment.layout = 'hbox'
		moduleElement.children.add(moduleHeadingCompartment)

		if (moduleStmt.importance.value == 'none' || moduleStmt.importanceQuantitative == 0) {
			val SLabel moduleLabel = configSElement(SLabel, moduleElement.id + '-label', 'heading')
			moduleLabel.text = longName + ' ' + '(' + impQualitative + ')'
			moduleHeadingCompartment.children.add(moduleLabel)
			return moduleElement
		} else {
			LOG.info('moduleStmt =' + moduleStmt.eContainer.eContents)
			val SLabel moduleLabel = configSElement(SLabel, moduleElement.id + '-label', 'heading')
			moduleLabel.text = longName + ' ' + '(' + impQuantitative + ')'
			moduleHeadingCompartment.children.add(moduleLabel)
			return moduleElement
		}
	}

	protected def TURNNode createIndicator(String longName, IntentionalElement moduleStmt) {
		val moduleElement = configSElement(TURNNode, longName, 'indicator')
		var impQualitative = (moduleStmt.importance).toString
		var impQuantitative = moduleStmt.importanceQuantitative

		moduleElement.layout = 'hbox'
		moduleElement.layoutOptions = new LayoutOptions [
			paddingTop = 10.0
			paddingBottom = 10.0
			paddingLeft = 10.0
			paddingRight = 10.0
			resizeContainer = true
		]

		val SCompartment moduleHeadingCompartment = configSElement(SCompartment, moduleElement.id + '-heading', 'comp')
		moduleHeadingCompartment.layout = 'hbox'
		moduleElement.children.add(moduleHeadingCompartment)

		if (moduleStmt.importance.value == 'none' || moduleStmt.importanceQuantitative == 0) {
			val SLabel moduleLabel = configSElement(SLabel, moduleElement.id + '-label', 'heading')
			moduleLabel.text = longName + ' ' + '(' + impQualitative + ')'
			moduleHeadingCompartment.children.add(moduleLabel)
			return moduleElement
		} else {
			LOG.info('moduleStmt =' + moduleStmt.eContainer.eContents)
			val SLabel moduleLabel = configSElement(SLabel, moduleElement.id + '-label', 'heading')
			moduleLabel.text = longName + ' ' + '(' + impQuantitative + ')'
			moduleHeadingCompartment.children.add(moduleLabel)
			return moduleElement
		}
	}

	protected def SNode initModule(TURNNode moduleElement, IntentionalElement moduleStmt) {
		if ((moduleStmt == diagramModule)) {
			val moduleNode = configSElement(TURNNode, moduleElement.id + '-example', 'class')
			moduleNode.layout = 'hbox'
			moduleNode.layoutOptions = new LayoutOptions [
				paddingLeft = 10.0
				paddingRight = 10.0
				paddingTop = 10.0
				paddingBottom = 10.0
			]
			moduleNode.cssClass = 'example'
			moduleNode.children.add(createClassHeader(moduleNode.id, findTag(moduleStmt), moduleStmt.longName))
			moduleElement.children.add(moduleNode)
		}
		return moduleElement
	}

	protected def TURNHeaderNode createClassHeader(String id, String tag, LongName longName) {
		val classHeader = configSElement(TURNHeaderNode, id + '-header', 'classHeader')
		classHeader.layout = 'hbox'
		classHeader.layoutOptions = new LayoutOptions [
			paddingLeft = 8.0
			paddingRight = 8.0
			paddingTop = 8.0
			paddingBottom = 8.0
		]
		classHeader.children = #[
			new TURNTag [ t |
				t.id = classHeader.id + '-tag'
				t.type = 'tag'
				t.layout = 'stack'
				t.layoutOptions = new LayoutOptions [
					resizeContainer = false
					HAlign = 'center'
					VAlign = 'center'
					paddingLeft = 0.0
					paddingRight = 0.0
					paddingTop = 0.0
					paddingBottom = 0.0
				]
				t.children = #[
					new SLabel [ l |
						l.type = "label:tag"
						l.id = classHeader.id + '-tag-text'
						l.text = tag
					]
				]
			],
			new SLabel [ l |
				l.type = "label:classHeader"
				l.id = classHeader.id + '-header-label'
			// l.text = name
			]
		]
		return classHeader
	}

	protected def dispatch SModelElement generateElement(ElementLink moduleStmt, SModelElement viewParentElement,
		SModelElement modelParentElement) {
	}

	protected def dispatch SModelElement generateElement(Actor moduleStmt, SModelElement viewParentElement,
		SModelElement modelParentElement) {
		return generateElementActor(moduleStmt, viewParentElement, modelParentElement)
	}

	protected def dispatch SModelElement generateActorModule(Actor moduleStmt, SModelElement viewParentElement,
		SModelElement modelParentElement) {
		return createModule(moduleStmt)
	}

	protected def SModelElement generateGoal(IntentionalElement moduleStmt, SModelElement viewParentElement,
		SModelElement modelParentElement) {
		return createModule(moduleStmt)
	}

	protected def SModelElement generateSoftGoal(IntentionalElement moduleStmt, SModelElement viewParentElement,
		SModelElement modelParentElement) {
		return createModuleSoftGoal(moduleStmt)
	}

	protected def SModelElement generateSoftGoalTry(IntentionalElement moduleStmt, SModelElement viewParentElement,
		SModelElement modelParentElement) {
		return createModuleSoftGoalTry(moduleStmt)
	}

	protected def SModelElement generateBelief(IntentionalElement moduleStmt, SModelElement viewParentElement,
		SModelElement modelParentElement) {
		return createModuleBelief(moduleStmt)
	}

	protected def SModelElement generateTask(IntentionalElement moduleStmt, SModelElement viewParentElement,
		SModelElement modelParentElement) {
		return createModuleTask(moduleStmt)
	}

	protected def SModelElement generateResource(IntentionalElement moduleStmt, SModelElement viewParentElement,
		SModelElement modelParentElement) {
		return createModuleResource(moduleStmt)
	}

	protected def SModelElement generateIndicator(IntentionalElement moduleStmt, SModelElement viewParentElement,
		SModelElement modelParentElement) {
		return createModuleIndicator(moduleStmt)
	}

	protected def createModule(Actor moduleStmt) {
		val id = moduleStmt.longName.longname
		val existingModule = id2modules.get(id)
		if (existingModule !== null)
			return existingModule
		val moduleElement = createModule(id)
		id2modules.put(id, moduleElement)
		return moduleElement
	}

	protected def TURNNode createModule(String longName) {
		val moduleElement = configSElement(TURNNode, longName, 'actor')
		moduleElement.layout = 'vbox'
		moduleElement.layoutOptions = new LayoutOptions [
			paddingTop = 0.0
			paddingBottom = 0.0
			paddingLeft = 0.0
			paddingRight = 0.0
			resizeContainer = true
		]

		val SCompartment moduleHeadingCompartment = configSElement(SCompartment, moduleElement.id + '-heading', 'comp')
		moduleHeadingCompartment.layout = 'hbox'
		moduleElement.children.add(moduleHeadingCompartment)
		val SLabel moduleLabel = configSElement(SLabel, moduleElement.id + '-label', 'heading')
		moduleLabel.text = longName
		moduleHeadingCompartment.children.add(moduleLabel)
		return moduleElement
	}

	protected def SNode initModule(TURNNode moduleElement, Actor actor) {
		if ((state.currentModel.type == 'NONE' && actor == diagramModule) ||
			state.expandedElements.contains(moduleElement.id)) {

			val moduleNode = configSElement(TURNNode, moduleElement.id + '-node', 'class')
			moduleNode.layout = 'hbox'
			moduleNode.layoutOptions = new LayoutOptions [
				paddingLeft = 0.0
				paddingRight = 0.0
				paddingTop = 0.0
				paddingBottom = 0.0
			]
			moduleNode.cssClass = 'moduleNode'

			moduleNode.children.add(createClassHeader(moduleNode.id, findTag(actor), actor.longName))
			moduleElement.children.add(moduleNode)
			moduleElement.children.addAll(createChildElements(moduleNode, moduleElement, actor))
			moduleElement.expanded = true
			state.expandedElements.add(moduleElement.id)
		} else {
			moduleElement.expanded = false
		}
		return moduleElement
	}

	protected def SModelElement createChildElements2(SModelElement viewParentElement, SModelElement modelParentElement,
		Actor actor) {
		var SModelElement element = null

		for (goal : actor.elems) {
			element = generateElement(goal, viewParentElement, modelParentElement)
			element.trace(goal)
			elementIE.put(goal, element)
			LOG.info("Goals HASH MAP" + elementIE)
			return element
		}
	}

	protected def createModule(IntentionalElement moduleStmt) {
		val id = moduleStmt.longName.longname
		val existingModule = id2modules.get(id)
		if (existingModule !== null)
			return existingModule
		val moduleElement = createModule2(id, moduleStmt)
		id2modules.put(id, moduleElement)
		initModule(moduleElement, moduleStmt)
		return moduleElement
	}

	protected def createModuleBelief(IntentionalElement moduleStmt) {
		val id = moduleStmt.longName.longname
		val existingModule = id2modules.get(id)
		if (existingModule !== null)
			return existingModule
		val moduleElement = createBelief(id, moduleStmt)
		id2modules.put(id, moduleElement)
		initModule(moduleElement, moduleStmt)
		return moduleElement
	}

	protected def createModuleTask(IntentionalElement moduleStmt) {
		val id = moduleStmt.longName.longname
		val existingModule = id2modules.get(id)
		if (existingModule !== null)
			return existingModule
		val moduleElement = createTask(id, moduleStmt)
		id2modules.put(id, moduleElement)
		initModule(moduleElement, moduleStmt)
		return moduleElement
	}

	protected def createModuleResource(IntentionalElement moduleStmt) {
		val id = moduleStmt.longName.longname
		val existingModule = id2modules.get(id)
		if (existingModule !== null)
			return existingModule
		val moduleElement = createResource(id, moduleStmt)
		id2modules.put(id, moduleElement)
		initModule(moduleElement, moduleStmt)
		return moduleElement
	}

	protected def createModuleIndicator(IntentionalElement moduleStmt) {
		val id = moduleStmt.longName.longname
		val existingModule = id2modules.get(id)
		if (existingModule !== null)
			return existingModule
		val moduleElement = createIndicator(id, moduleStmt)
		id2modules.put(id, moduleElement)
		initModule(moduleElement, moduleStmt)
		return moduleElement
	}

	protected def createModuleSoftGoalTry(IntentionalElement moduleStmt) {
		val id = moduleStmt.longName.longname
		val existingModule = id2modules.get(id)
		if (existingModule !== null)
			return existingModule
		val moduleElement = createModule2SGTry(id)
		id2modules.put(id, moduleElement)
		initModule(moduleElement, moduleStmt)
		return moduleElement
	}

	// SOFTGOAL TRY
	protected def createModuleSoftGoal(IntentionalElement moduleStmt) {
		val id = moduleStmt.longName.longname
		val existingModule = id2modules.get(id)
		if (existingModule !== null)
			return existingModule
		val moduleElement = createModule2SG(id, moduleStmt)
		id2modules.put(id, moduleElement)
		initModule(moduleElement, moduleStmt)
		return moduleElement
	}

	protected def String findType(SModelElement element) {
		switch element {
			SNode: 'node'
			TURNLabel: 'ylabel'
			SLabel: 'label'
			SCompartment: 'comp'
			SEdge: 'edge'
			SButton: 'button'
			default: 'dontknow'
		}
	}

	protected def String findClass(IntentionalElement statement) {
		switch statement {
			IntentionalElementImpl: 'goal'
			ActorImpl: 'actor'
			default: ''
		}
	}

	protected def String findTag(IntentionalElement statement) {
		switch statement {
			IntentionalElementImpl: 'I'
			ElementLinkImpl: 'E'
			default: ''
		}
	}

	protected def String findTag(Actor statement) {
		switch statement {
			ActorImpl: 'A'
			IntentionalElementImpl: 'I'
			ElementLinkImpl: 'E'
			default: ''
		}
	}

	protected def void postProcessing() {
		postProcesses.forEach[process|process.apply]
	}

}
