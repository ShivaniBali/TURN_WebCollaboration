package mcgill.xtext.turn.diagram.test;

import com.google.common.base.Preconditions;
import com.google.inject.AbstractModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import javax.inject.Inject;
import javax.inject.Provider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.FormatterTestHelper;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.testing.util.ResourceHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.xtext.example.mydsl.tests.TURNInjectorProvider;

@RunWith(XtextRunner.class)
@InjectWith(TURNInjectorProvider.class)
@SuppressWarnings("all")
public abstract class AbstractTURNTest {
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  private ResourceHelper resourceHelper;
  
  @Inject
  protected IResourceDescription.Manager mnr;
  
  @Inject
  protected ValidationTestHelper validator;
  
  @Inject
  @Extension
  protected FormatterTestHelper _formatterTestHelper;
  
  protected XtextResourceSet resourceSet;
  
  @Before
  public void setup() {
    this.resourceSet = this.resourceSetProvider.get();
  }
  
  protected void assertError(final EObject obj, final String code) {
    this.validator.assertError(obj, obj.eClass(), code);
  }
  
  protected void assertError(final EObject obj, final String code, final String searchTerm, final String... messageParts) {
    Resource _eResource = obj.eResource();
    IParseResult _parseResult = ((XtextResource) _eResource).getParseResult();
    ICompositeNode _rootNode = null;
    if (_parseResult!=null) {
      _rootNode=_parseResult.getRootNode();
    }
    String _text = null;
    if (_rootNode!=null) {
      _text=_rootNode.getText();
    }
    final String parsedText = _text;
    final int offset = parsedText.indexOf(searchTerm);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("The \'");
    _builder.append(searchTerm);
    _builder.append("\' is not conatined in \'");
    _builder.append(parsedText);
    _builder.append("\'.");
    Preconditions.checkArgument((offset >= 0), _builder);
    this.validator.assertError(obj, obj.eClass(), code, offset, searchTerm.length(), messageParts);
  }
  
  protected void assertWarning(final EObject obj, final String code) {
    this.validator.assertWarning(obj, obj.eClass(), code);
  }
  
  protected void assertWarning(final EObject obj, final String code, final String searchTerm, final String... messageParts) {
    Resource _eResource = obj.eResource();
    IParseResult _parseResult = ((XtextResource) _eResource).getParseResult();
    ICompositeNode _rootNode = null;
    if (_parseResult!=null) {
      _rootNode=_parseResult.getRootNode();
    }
    String _text = null;
    if (_rootNode!=null) {
      _text=_rootNode.getText();
    }
    final String parsedText = _text;
    final int offset = parsedText.indexOf(searchTerm);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("The \'");
    _builder.append(searchTerm);
    _builder.append("\' is not conatined in \'");
    _builder.append(parsedText);
    _builder.append("\'.");
    Preconditions.checkArgument((offset >= 0), _builder);
    this.validator.assertWarning(obj, obj.eClass(), code, offset, searchTerm.length(), messageParts);
  }
  
  protected void assertNoErrors(final EObject object, final String code) {
    this.validator.assertNoErrors(object, code);
  }
  
  protected void assertNoErrors(final Resource resource) {
    this.validator.assertNoErrors(resource);
  }
  
  protected void assertNoErrors(final EObject eObject) {
    final List<Issue> issues = this.validator.validate(eObject);
    final Function1<Issue, CharSequence> _function = (Issue it) -> {
      String _message = it.getMessage();
      String _plus = (_message + " : ");
      Integer _lineNumber = it.getLineNumber();
      return (_plus + _lineNumber);
    };
    Assert.assertEquals("", IterableExtensions.<Issue>join(issues, "\n", _function));
  }
  
  protected void assertNoIssues(final Resource resource) {
    this.validator.assertNoIssues(resource);
  }
  
  protected void assertNoIssues(final EObject eObject) {
    this.validator.assertNoIssues(eObject);
  }
  
  protected Resource loadWithSyntaxErrors(final CharSequence contents) {
    return this.load(contents, true);
  }
  
  protected Resource load(final CharSequence contents) {
    return this.load(contents, false);
  }
  
  protected Resource load(final CharSequence contents, final boolean allowErrors) {
    try {
      int _size = this.resourceSet.getResources().size();
      String _plus = ("synthetic:///__synthetic" + Integer.valueOf(_size));
      String _plus_1 = (_plus + ".turn");
      final URI uri = URI.createURI(_plus_1);
      final Resource resource = this.resourceHelper.resource(contents.toString(), uri, this.resourceSet);
      resource.load(CollectionLiterals.<Object, Object>emptyMap());
      if ((!allowErrors)) {
        final Function1<Resource.Diagnostic, CharSequence> _function = (Resource.Diagnostic it) -> {
          return it.getMessage();
        };
        Assert.assertTrue(IterableExtensions.<Resource.Diagnostic>join(resource.getErrors(), "\n", _function), resource.getErrors().isEmpty());
      }
      return resource;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected AbstractModule root(final Resource r) {
    this.fullyResolve();
    EObject _head = IterableExtensions.<EObject>head(r.getContents());
    return ((AbstractModule) _head);
  }
  
  private boolean isFullyResolved = false;
  
  private void fullyResolve() {
    if (this.isFullyResolved) {
      return;
    }
    this.isFullyResolved = true;
    this.installIndex();
    final Consumer<Resource> _function = (Resource it) -> {
      this.validator.validate(it);
    };
    this.resourceSet.getResources().forEach(_function);
  }
  
  private void installIndex() {
    List<IResourceDescription> _emptyList = Collections.<IResourceDescription>emptyList();
    final ResourceDescriptionsData index = new ResourceDescriptionsData(_emptyList);
    EList<Resource> _resources = this.resourceSet.getResources();
    final ArrayList<Resource> resources = new ArrayList<Resource>(_resources);
    for (final Resource resource : resources) {
      this.index(resource, resource.getURI(), index);
    }
    ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(this.resourceSet, index);
  }
  
  private void index(final Resource resource, final URI uri, final ResourceDescriptionsData index) {
    final IResourceDescription resourceDescription = this.mnr.getResourceDescription(resource);
    if ((resourceDescription != null)) {
      index.addDescription(uri, resourceDescription);
    }
  }
  
  protected void assertFormattedWithoutSerialization(final Procedure1<? super FormatterTestRequest> init) {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      init.apply(it);
      it.setUseSerializer(false);
    };
    this._formatterTestHelper.assertFormatted(_function);
  }
}
