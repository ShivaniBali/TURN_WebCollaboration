/**
 * Copyright (C) 2017 TypeFox and others.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 */
package mcgill.xtext.turn.diagram;

import com.google.inject.Singleton;
import io.typefox.sprotty.api.IDiagramServer;
import io.typefox.sprotty.server.xtext.DiagramLanguageServerExtension;
import io.typefox.sprotty.server.xtext.LanguageAwareDiagramServer;
import io.typefox.sprotty.server.xtext.ide.IdeLanguageServerExtension;

@Singleton
@SuppressWarnings("all")
public class TURNLanguageServerExtension extends IdeLanguageServerExtension {
  @Override
  protected void initializeDiagramServer(final IDiagramServer server) {
    super.initializeDiagramServer(server);
    final LanguageAwareDiagramServer languageAware = ((LanguageAwareDiagramServer) server);
    languageAware.setNeedsServerLayout(true);
    String _clientId = server.getClientId();
    String _plus = ("Created diagram server for " + _clientId);
    DiagramLanguageServerExtension.LOG.info(_plus);
  }
  
  @Override
  public void didClose(final String clientId) {
    super.didClose(clientId);
    DiagramLanguageServerExtension.LOG.info(("Removed diagram server for " + clientId));
  }
}
