package mcgill.xtext.turn.validation;

import com.google.inject.Inject;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;
import org.eclipse.xtext.validation.IssueSeverities;
import org.eclipse.xtext.validation.IssueSeveritiesProvider;
import org.eclipse.xtext.validation.SeverityConverter;
import org.eclipse.xtext.xbase.lib.Exceptions;

@Log
@SuppressWarnings("all")
public class YangIssueSeverityProvider extends IssueSeveritiesProvider {
  @Inject
  private ConfigurableIssueCodesProvider issueCodesProvider;
  
  @Inject
  private SeverityConverter severityConverter;
  
  @Override
  public IssueSeverities getIssueSeverities(final Resource context) {
    final IPreferenceValues preferenceValues = this.getValuesProvider().getPreferenceValues(context);
    final Map<String, PreferenceKey> configurableIssueCodes = this.issueCodesProvider.getConfigurableIssueCodes();
    Map<String, PreferenceKey> _configurableIssueCodes = this.issueCodesProvider.getConfigurableIssueCodes();
    return new IssueSeverities(preferenceValues, _configurableIssueCodes, 
      this.severityConverter) {
      @Override
      public Severity getSeverity(final String code) {
        final PreferenceKey key = configurableIssueCodes.get(code);
        String _elvis = null;
        String _defaultValue = null;
        if (key!=null) {
          _defaultValue=key.getDefaultValue();
        }
        if (_defaultValue != null) {
          _elvis = _defaultValue;
        } else {
          _elvis = "error";
        }
        PreferenceKey _preferenceKey = new PreferenceKey(("diagnostic." + code), _elvis);
        final String value = preferenceValues.getPreference(_preferenceKey);
        try {
          return YangIssueSeverityProvider.this.severityConverter.stringToSeverity(value);
        } catch (final Throwable _t) {
          if (_t instanceof IllegalArgumentException) {
            final IllegalArgumentException e = (IllegalArgumentException)_t;
            YangIssueSeverityProvider.LOG.error(e.getMessage(), e);
            return Severity.ERROR;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    };
  }
  
  private static final Logger LOG = Logger.getLogger(YangIssueSeverityProvider.class);
}
