/*
 * generated by Xtext 2.12.0
 */
package mcgill.xtext.turn

import org.xtext.example.mydsl.TURNStandaloneSetupGenerated

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class TURNStandaloneSetup extends TURNStandaloneSetupGenerated {

	def static void doSetup() {
		new TURNStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}
