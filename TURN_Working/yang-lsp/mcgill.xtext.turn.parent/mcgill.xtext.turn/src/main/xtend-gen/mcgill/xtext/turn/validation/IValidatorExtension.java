package mcgill.xtext.turn.validation;

import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.xtext.example.mydsl.tURN.URNspec;

@SuppressWarnings("all")
public interface IValidatorExtension {
  public abstract void validate(final URNspec module, final IAcceptor<Issue> issueAcceptor, final CancelIndicator cancelIndicator);
}
