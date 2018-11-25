package mcgill.xtext.turn.diagram

import io.typefox.sprotty.api.Action
import io.typefox.sprotty.api.IDiagramExpansionListener
import io.typefox.sprotty.api.IDiagramServer
import io.typefox.sprotty.server.xtext.LanguageAwareDiagramServer

class TURNDiagramExpansionListener implements IDiagramExpansionListener {
	
	override expansionChanged(Action action, IDiagramServer server) {
		if (server instanceof LanguageAwareDiagramServer) {
			val languageServerExtension = server.languageServerExtension
			languageServerExtension.updateDiagram(server)
		}
	}
}