package mcgill.xtext.turn.utils;

import com.google.common.base.Splitter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.function.Consumer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import mcgill.xtext.turn.settings.PreferenceValuesProvider;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@Log
@Singleton
@SuppressWarnings("all")
public class YangPathProvider {
  public static final PreferenceKey TURN_PATH = new PreferenceKey("turnPath", "");
  
  @Inject
  private PreferenceValuesProvider preferenceProvider;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  @Extension
  private IResourceDescription.Manager _manager;
  
  private List<IResourceDescription> turnPathDescriptions;
  
  public List<IResourceDescription> getYangPath(final Resource resource) {
    List<IResourceDescription> _elvis = null;
    if (this.turnPathDescriptions != null) {
      _elvis = this.turnPathDescriptions;
    } else {
      _elvis = (this.turnPathDescriptions = this.createTURNPathDescriptions(resource));
    }
    return _elvis;
  }
  
  private List<IResourceDescription> createTURNPathDescriptions(final Resource resource) {
    final Procedure2<IPreferenceValues, Resource> _function = (IPreferenceValues $0, Resource $1) -> {
      this.turnPathDescriptions = null;
    };
    this.preferenceProvider.registerChangeListener(_function);
    final IPreferenceValues prefs = this.preferenceProvider.getPreferenceValues(resource);
    final String turnpath = prefs.getPreference(YangPathProvider.TURN_PATH);
    final ArrayList<IResourceDescription> resourceDescriptions = CollectionLiterals.<IResourceDescription>newArrayList();
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(turnpath);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      final Consumer<String> _function_1 = (String it) -> {
        final File file = new File(it);
        this.process(file, resourceSet);
      };
      Splitter.on(File.pathSeparator).split(turnpath).forEach(_function_1);
      final Consumer<Resource> _function_2 = (Resource it) -> {
        try {
          URI _uRI = it.getURI();
          String _plus = ("Indexing TURNPath element: " + _uRI);
          YangPathProvider.LOG.info(_plus);
          IResourceDescription _resourceDescription = this._manager.getResourceDescription(it);
          resourceDescriptions.add(_resourceDescription);
        } catch (final Throwable _t) {
          if (_t instanceof Throwable) {
            final Throwable e = (Throwable)_t;
            String _string = it.getURI().toString();
            String _plus_1 = ("Error indexing turnPath resource " + _string);
            YangPathProvider.LOG.error(_plus_1, e);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      };
      resourceSet.getResources().forEach(_function_2);
    }
    return resourceDescriptions;
  }
  
  private void process(final File file, final ResourceSet resourceSet) {
    try {
      boolean _canRead = file.canRead();
      boolean _not = (!_canRead);
      if (_not) {
        return;
      } else {
        boolean _isDirectory = file.isDirectory();
        if (_isDirectory) {
          final Consumer<File> _function = (File it) -> {
            this.process(it, resourceSet);
          };
          ((List<File>)Conversions.doWrapArray(file.listFiles())).forEach(_function);
        } else {
          boolean _endsWith = file.getName().endsWith(".turn");
          if (_endsWith) {
            resourceSet.getResource(URI.createFileURI(file.getAbsolutePath()), true);
          } else {
            boolean _endsWith_1 = file.getName().endsWith(".zip");
            if (_endsWith_1) {
              final ZipFile zipFile = new ZipFile(file);
              final Enumeration<? extends ZipEntry> entries = zipFile.entries();
              final String zipFileUri = URI.createFileURI(file.getAbsolutePath()).toString();
              while (entries.hasMoreElements()) {
                {
                  final ZipEntry entry = entries.nextElement();
                  if (((!entry.isDirectory()) && entry.getName().endsWith(".turn"))) {
                    String _name = entry.getName();
                    String _plus = ((("archive:" + zipFileUri) + "!/") + _name);
                    final URI zipEntryUri = URI.createURI(_plus);
                    final Resource resource = resourceSet.createResource(zipEntryUri);
                    resource.load(zipFile.getInputStream(entry), null);
                  }
                }
              }
            }
          }
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof Throwable) {
        final Throwable e = (Throwable)_t;
        String _string = URI.class.toString();
        String _plus = ("Error loading turnPath resource " + _string);
        YangPathProvider.LOG.error(_plus, e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  private static final Logger LOG = Logger.getLogger(YangPathProvider.class);
}
