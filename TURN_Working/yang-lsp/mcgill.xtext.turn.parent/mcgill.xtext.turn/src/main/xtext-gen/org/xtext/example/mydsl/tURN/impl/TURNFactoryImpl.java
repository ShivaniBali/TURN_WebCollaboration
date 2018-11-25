/**
 * generated by Xtext 2.15.0-SNAPSHOT
 */
package org.xtext.example.mydsl.tURN.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.xtext.example.mydsl.tURN.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TURNFactoryImpl extends EFactoryImpl implements TURNFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TURNFactory init()
  {
    try
    {
      TURNFactory theTURNFactory = (TURNFactory)EPackage.Registry.INSTANCE.getEFactory(TURNPackage.eNS_URI);
      if (theTURNFactory != null)
      {
        return theTURNFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TURNFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TURNFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case TURNPackage.UR_NSPEC: return createURNspec();
      case TURNPackage.CONCRETE_UR_NSPEC: return createConcreteURNspec();
      case TURNPackage.CONCERN: return createConcern();
      case TURNPackage.LONG_NAME: return createLongName();
      case TURNPackage.CONDITION: return createCondition();
      case TURNPackage.CONCRETE_CONDITION: return createConcreteCondition();
      case TURNPackage.UR_NLINK: return createURNlink();
      case TURNPackage.METADATA: return createMetadata();
      case TURNPackage.UR_NMODEL_ELEMENT: return createURNmodelElement();
      case TURNPackage.ACTOR: return createActor();
      case TURNPackage.INTENTIONAL_ELEMENT: return createIntentionalElement();
      case TURNPackage.ELEMENT_LINK: return createElementLink();
      case TURNPackage.CONTRIBUTION: return createContribution();
      case TURNPackage.DECOMPOSITION: return createDecomposition();
      case TURNPackage.DEPENDENCY: return createDependency();
      case TURNPackage.ARTIFICIAL_RULE: return createArtificialRule();
      case TURNPackage.STRATEGIES_GROUP: return createStrategiesGroup();
      case TURNPackage.EVALUATION_STRATEGY: return createEvaluationStrategy();
      case TURNPackage.CONCRETE_STRATEGY: return createConcreteStrategy();
      case TURNPackage.EVALUATION: return createEvaluation();
      case TURNPackage.INDICATOR_EVALUATION: return createIndicatorEvaluation();
      case TURNPackage.INDICATOR_CONVERSION: return createIndicatorConversion();
      case TURNPackage.LINEAR_CONVERSION: return createLinearConversion();
      case TURNPackage.QUAL_TO_QMAPPINGS: return createQualToQMappings();
      case TURNPackage.QUAL_TO_QMAPPING: return createQualToQMapping();
      case TURNPackage.CONTRIBUTION_CONTEXT_GROUP: return createContributionContextGroup();
      case TURNPackage.CONTRIBUTION_CONTEXT: return createContributionContext();
      case TURNPackage.CONTRIBUTION_CHANGE: return createContributionChange();
      case TURNPackage.UC_MMAP: return createUCMmap();
      case TURNPackage.PATH: return createPath();
      case TURNPackage.START_POINT: return createStartPoint();
      case TURNPackage.PATH_BODY: return createPathBody();
      case TURNPackage.PATH_BODY_NODE: return createPathBodyNode();
      case TURNPackage.REGULAR_END: return createRegularEnd();
      case TURNPackage.ENDPOINT_WITH_CONNECT: return createEndpointWithConnect();
      case TURNPackage.REFERENCED_END: return createReferencedEnd();
      case TURNPackage.RESP_REF: return createRespRef();
      case TURNPackage.OR_JOIN: return createOrJoin();
      case TURNPackage.AND_JOIN: return createAndJoin();
      case TURNPackage.WAITING_PLACE: return createWaitingPlace();
      case TURNPackage.TIMER: return createTimer();
      case TURNPackage.CONNECT: return createConnect();
      case TURNPackage.CONNECT_ELEMENT: return createConnectElement();
      case TURNPackage.FAILURE_POINT: return createFailurePoint();
      case TURNPackage.END_POINT: return createEndPoint();
      case TURNPackage.OR_FORK: return createOrFork();
      case TURNPackage.OR_BODY: return createOrBody();
      case TURNPackage.REGULAR_OR_FORK: return createRegularOrFork();
      case TURNPackage.AND_FORK: return createAndFork();
      case TURNPackage.STUB: return createStub();
      case TURNPackage.STUB_PARAMETERS: return createStubParameters();
      case TURNPackage.STUB_DECLARATION: return createStubDeclaration();
      case TURNPackage.STUB_OUT_PATH: return createStubOutPath();
      case TURNPackage.PLUGIN_BINDING: return createPluginBinding();
      case TURNPackage.COMPONENT_REF: return createComponentRef();
      case TURNPackage.BOUND_OPTION: return createBoundOption();
      case TURNPackage.BOUND_ELEMENT: return createBoundElement();
      case TURNPackage.REFERENCED_BOUND_ELEMENT: return createReferencedBoundElement();
      case TURNPackage.LONG_BOUND_ELEMENT: return createLongBoundElement();
      case TURNPackage.BINDING: return createBinding();
      case TURNPackage.IN_BINDING: return createInBinding();
      case TURNPackage.OUT_BINDING: return createOutBinding();
      case TURNPackage.COMPONENT_BINDING: return createComponentBinding();
      case TURNPackage.FAILURE_LABEL: return createFailureLabel();
      case TURNPackage.TEXT: return createText();
      case TURNPackage.PATH_BODY_NODES: return createPathBodyNodes();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case TURNPackage.QUALITATIVE_LABEL:
        return createQualitativeLabelFromString(eDataType, initialValue);
      case TURNPackage.INTENTIONAL_ELEMENT_TYPE:
        return createIntentionalElementTypeFromString(eDataType, initialValue);
      case TURNPackage.CONTRIBUTION_TYPE:
        return createContributionTypeFromString(eDataType, initialValue);
      case TURNPackage.IMPORTANCE_TYPE:
        return createImportanceTypeFromString(eDataType, initialValue);
      case TURNPackage.DECOMPOSITION_TYPE:
        return createDecompositionTypeFromString(eDataType, initialValue);
      case TURNPackage.WAITKIND:
        return createWAITKINDFromString(eDataType, initialValue);
      case TURNPackage.STUBTYPE:
        return createSTUBTYPEFromString(eDataType, initialValue);
      case TURNPackage.COMPONENTKIND:
        return createCOMPONENTKINDFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case TURNPackage.QUALITATIVE_LABEL:
        return convertQualitativeLabelToString(eDataType, instanceValue);
      case TURNPackage.INTENTIONAL_ELEMENT_TYPE:
        return convertIntentionalElementTypeToString(eDataType, instanceValue);
      case TURNPackage.CONTRIBUTION_TYPE:
        return convertContributionTypeToString(eDataType, instanceValue);
      case TURNPackage.IMPORTANCE_TYPE:
        return convertImportanceTypeToString(eDataType, instanceValue);
      case TURNPackage.DECOMPOSITION_TYPE:
        return convertDecompositionTypeToString(eDataType, instanceValue);
      case TURNPackage.WAITKIND:
        return convertWAITKINDToString(eDataType, instanceValue);
      case TURNPackage.STUBTYPE:
        return convertSTUBTYPEToString(eDataType, instanceValue);
      case TURNPackage.COMPONENTKIND:
        return convertCOMPONENTKINDToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public URNspec createURNspec()
  {
    URNspecImpl urNspec = new URNspecImpl();
    return urNspec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConcreteURNspec createConcreteURNspec()
  {
    ConcreteURNspecImpl concreteURNspec = new ConcreteURNspecImpl();
    return concreteURNspec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Concern createConcern()
  {
    ConcernImpl concern = new ConcernImpl();
    return concern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LongName createLongName()
  {
    LongNameImpl longName = new LongNameImpl();
    return longName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Condition createCondition()
  {
    ConditionImpl condition = new ConditionImpl();
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConcreteCondition createConcreteCondition()
  {
    ConcreteConditionImpl concreteCondition = new ConcreteConditionImpl();
    return concreteCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public URNlink createURNlink()
  {
    URNlinkImpl urNlink = new URNlinkImpl();
    return urNlink;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Metadata createMetadata()
  {
    MetadataImpl metadata = new MetadataImpl();
    return metadata;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public URNmodelElement createURNmodelElement()
  {
    URNmodelElementImpl urNmodelElement = new URNmodelElementImpl();
    return urNmodelElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Actor createActor()
  {
    ActorImpl actor = new ActorImpl();
    return actor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntentionalElement createIntentionalElement()
  {
    IntentionalElementImpl intentionalElement = new IntentionalElementImpl();
    return intentionalElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElementLink createElementLink()
  {
    ElementLinkImpl elementLink = new ElementLinkImpl();
    return elementLink;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Contribution createContribution()
  {
    ContributionImpl contribution = new ContributionImpl();
    return contribution;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Decomposition createDecomposition()
  {
    DecompositionImpl decomposition = new DecompositionImpl();
    return decomposition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Dependency createDependency()
  {
    DependencyImpl dependency = new DependencyImpl();
    return dependency;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArtificialRule createArtificialRule()
  {
    ArtificialRuleImpl artificialRule = new ArtificialRuleImpl();
    return artificialRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StrategiesGroup createStrategiesGroup()
  {
    StrategiesGroupImpl strategiesGroup = new StrategiesGroupImpl();
    return strategiesGroup;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EvaluationStrategy createEvaluationStrategy()
  {
    EvaluationStrategyImpl evaluationStrategy = new EvaluationStrategyImpl();
    return evaluationStrategy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConcreteStrategy createConcreteStrategy()
  {
    ConcreteStrategyImpl concreteStrategy = new ConcreteStrategyImpl();
    return concreteStrategy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Evaluation createEvaluation()
  {
    EvaluationImpl evaluation = new EvaluationImpl();
    return evaluation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndicatorEvaluation createIndicatorEvaluation()
  {
    IndicatorEvaluationImpl indicatorEvaluation = new IndicatorEvaluationImpl();
    return indicatorEvaluation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndicatorConversion createIndicatorConversion()
  {
    IndicatorConversionImpl indicatorConversion = new IndicatorConversionImpl();
    return indicatorConversion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LinearConversion createLinearConversion()
  {
    LinearConversionImpl linearConversion = new LinearConversionImpl();
    return linearConversion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualToQMappings createQualToQMappings()
  {
    QualToQMappingsImpl qualToQMappings = new QualToQMappingsImpl();
    return qualToQMappings;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualToQMapping createQualToQMapping()
  {
    QualToQMappingImpl qualToQMapping = new QualToQMappingImpl();
    return qualToQMapping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContributionContextGroup createContributionContextGroup()
  {
    ContributionContextGroupImpl contributionContextGroup = new ContributionContextGroupImpl();
    return contributionContextGroup;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContributionContext createContributionContext()
  {
    ContributionContextImpl contributionContext = new ContributionContextImpl();
    return contributionContext;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContributionChange createContributionChange()
  {
    ContributionChangeImpl contributionChange = new ContributionChangeImpl();
    return contributionChange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UCMmap createUCMmap()
  {
    UCMmapImpl ucMmap = new UCMmapImpl();
    return ucMmap;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Path createPath()
  {
    PathImpl path = new PathImpl();
    return path;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StartPoint createStartPoint()
  {
    StartPointImpl startPoint = new StartPointImpl();
    return startPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PathBody createPathBody()
  {
    PathBodyImpl pathBody = new PathBodyImpl();
    return pathBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PathBodyNode createPathBodyNode()
  {
    PathBodyNodeImpl pathBodyNode = new PathBodyNodeImpl();
    return pathBodyNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RegularEnd createRegularEnd()
  {
    RegularEndImpl regularEnd = new RegularEndImpl();
    return regularEnd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EndpointWithConnect createEndpointWithConnect()
  {
    EndpointWithConnectImpl endpointWithConnect = new EndpointWithConnectImpl();
    return endpointWithConnect;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferencedEnd createReferencedEnd()
  {
    ReferencedEndImpl referencedEnd = new ReferencedEndImpl();
    return referencedEnd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RespRef createRespRef()
  {
    RespRefImpl respRef = new RespRefImpl();
    return respRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrJoin createOrJoin()
  {
    OrJoinImpl orJoin = new OrJoinImpl();
    return orJoin;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndJoin createAndJoin()
  {
    AndJoinImpl andJoin = new AndJoinImpl();
    return andJoin;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WaitingPlace createWaitingPlace()
  {
    WaitingPlaceImpl waitingPlace = new WaitingPlaceImpl();
    return waitingPlace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Timer createTimer()
  {
    TimerImpl timer = new TimerImpl();
    return timer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Connect createConnect()
  {
    ConnectImpl connect = new ConnectImpl();
    return connect;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConnectElement createConnectElement()
  {
    ConnectElementImpl connectElement = new ConnectElementImpl();
    return connectElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FailurePoint createFailurePoint()
  {
    FailurePointImpl failurePoint = new FailurePointImpl();
    return failurePoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EndPoint createEndPoint()
  {
    EndPointImpl endPoint = new EndPointImpl();
    return endPoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrFork createOrFork()
  {
    OrForkImpl orFork = new OrForkImpl();
    return orFork;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrBody createOrBody()
  {
    OrBodyImpl orBody = new OrBodyImpl();
    return orBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RegularOrFork createRegularOrFork()
  {
    RegularOrForkImpl regularOrFork = new RegularOrForkImpl();
    return regularOrFork;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AndFork createAndFork()
  {
    AndForkImpl andFork = new AndForkImpl();
    return andFork;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Stub createStub()
  {
    StubImpl stub = new StubImpl();
    return stub;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StubParameters createStubParameters()
  {
    StubParametersImpl stubParameters = new StubParametersImpl();
    return stubParameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StubDeclaration createStubDeclaration()
  {
    StubDeclarationImpl stubDeclaration = new StubDeclarationImpl();
    return stubDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StubOutPath createStubOutPath()
  {
    StubOutPathImpl stubOutPath = new StubOutPathImpl();
    return stubOutPath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PluginBinding createPluginBinding()
  {
    PluginBindingImpl pluginBinding = new PluginBindingImpl();
    return pluginBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentRef createComponentRef()
  {
    ComponentRefImpl componentRef = new ComponentRefImpl();
    return componentRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoundOption createBoundOption()
  {
    BoundOptionImpl boundOption = new BoundOptionImpl();
    return boundOption;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoundElement createBoundElement()
  {
    BoundElementImpl boundElement = new BoundElementImpl();
    return boundElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferencedBoundElement createReferencedBoundElement()
  {
    ReferencedBoundElementImpl referencedBoundElement = new ReferencedBoundElementImpl();
    return referencedBoundElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LongBoundElement createLongBoundElement()
  {
    LongBoundElementImpl longBoundElement = new LongBoundElementImpl();
    return longBoundElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Binding createBinding()
  {
    BindingImpl binding = new BindingImpl();
    return binding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InBinding createInBinding()
  {
    InBindingImpl inBinding = new InBindingImpl();
    return inBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutBinding createOutBinding()
  {
    OutBindingImpl outBinding = new OutBindingImpl();
    return outBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentBinding createComponentBinding()
  {
    ComponentBindingImpl componentBinding = new ComponentBindingImpl();
    return componentBinding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FailureLabel createFailureLabel()
  {
    FailureLabelImpl failureLabel = new FailureLabelImpl();
    return failureLabel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Text createText()
  {
    TextImpl text = new TextImpl();
    return text;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PathBodyNodes createPathBodyNodes()
  {
    PathBodyNodesImpl pathBodyNodes = new PathBodyNodesImpl();
    return pathBodyNodes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualitativeLabel createQualitativeLabelFromString(EDataType eDataType, String initialValue)
  {
    QualitativeLabel result = QualitativeLabel.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertQualitativeLabelToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntentionalElementType createIntentionalElementTypeFromString(EDataType eDataType, String initialValue)
  {
    IntentionalElementType result = IntentionalElementType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertIntentionalElementTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContributionType createContributionTypeFromString(EDataType eDataType, String initialValue)
  {
    ContributionType result = ContributionType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertContributionTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImportanceType createImportanceTypeFromString(EDataType eDataType, String initialValue)
  {
    ImportanceType result = ImportanceType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertImportanceTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DecompositionType createDecompositionTypeFromString(EDataType eDataType, String initialValue)
  {
    DecompositionType result = DecompositionType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDecompositionTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WAITKIND createWAITKINDFromString(EDataType eDataType, String initialValue)
  {
    WAITKIND result = WAITKIND.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertWAITKINDToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public STUBTYPE createSTUBTYPEFromString(EDataType eDataType, String initialValue)
  {
    STUBTYPE result = STUBTYPE.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertSTUBTYPEToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public COMPONENTKIND createCOMPONENTKINDFromString(EDataType eDataType, String initialValue)
  {
    COMPONENTKIND result = COMPONENTKIND.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCOMPONENTKINDToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TURNPackage getTURNPackage()
  {
    return (TURNPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TURNPackage getPackage()
  {
    return TURNPackage.eINSTANCE;
  }

} //TURNFactoryImpl
