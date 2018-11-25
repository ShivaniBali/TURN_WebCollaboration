package mcgill.xtext.turn.diagram;

import io.typefox.sprotty.api.Action;
import io.typefox.sprotty.api.IDiagramExpansionListener;
import io.typefox.sprotty.api.IDiagramServer;
import io.typefox.sprotty.server.xtext.DiagramLanguageServerExtension;
import io.typefox.sprotty.server.xtext.LanguageAwareDiagramServer;

@SuppressWarnings("all")
public class TURNDiagramExpansionListener implements IDiagramExpansionListener {
  @Override
  public void expansionChanged(final Action action, final IDiagramServer server) {
    if ((server instanceof LanguageAwareDiagramServer)) {
      final DiagramLanguageServerExtension languageServerExtension = ((LanguageAwareDiagramServer)server).getLanguageServerExtension();
      languageServerExtension.updateDiagram(((LanguageAwareDiagramServer)server));
    }
  }
}
