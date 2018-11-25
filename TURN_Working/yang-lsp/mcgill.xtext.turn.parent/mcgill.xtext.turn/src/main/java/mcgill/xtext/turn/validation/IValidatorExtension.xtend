package mcgill.xtext.turn.validation


import org.xtext.example.mydsl.tURN.URNspec
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.validation.Issue

interface IValidatorExtension {
	
	def void validate(URNspec module, IAcceptor<Issue> issueAcceptor, CancelIndicator cancelIndicator);
}