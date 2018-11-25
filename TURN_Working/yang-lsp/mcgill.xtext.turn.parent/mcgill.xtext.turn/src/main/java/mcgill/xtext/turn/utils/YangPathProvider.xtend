package mcgill.xtext.turn.utils

import com.google.common.base.Splitter
import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton

import java.io.File
import java.util.List
import java.util.zip.ZipFile
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.preferences.PreferenceKey
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.util.internal.Log

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import mcgill.xtext.turn.settings.PreferenceValuesProvider

@Log
@Singleton
class YangPathProvider {

	public static val TURN_PATH = new PreferenceKey("turnPath", "")

	@Inject PreferenceValuesProvider preferenceProvider
	@Inject Provider<XtextResourceSet> resourceSetProvider
	@Inject extension IResourceDescription.Manager

	List<IResourceDescription> turnPathDescriptions

	def List<IResourceDescription> getYangPath(Resource resource) {
		turnPathDescriptions ?: (turnPathDescriptions = createTURNPathDescriptions(resource))
	}

	private def List<IResourceDescription> createTURNPathDescriptions(Resource resource) {
		preferenceProvider.registerChangeListener [
			turnPathDescriptions = null
		]
		val prefs = preferenceProvider.getPreferenceValues(resource)
		val turnpath = prefs.getPreference(TURN_PATH)
		val resourceDescriptions = newArrayList
		if (!turnpath.isNullOrEmpty) {
			val resourceSet = resourceSetProvider.get();
			Splitter.on(File.pathSeparator).split(turnpath).forEach [
				val file = new File(it)
				file.process(resourceSet)
			]
			resourceSet.resources.forEach [
				try {
					LOG.info('Indexing TURNPath element: ' + it.URI)
					resourceDescriptions += resourceDescription
				} catch (Throwable e) {
					LOG.error('Error indexing turnPath resource ' + it.URI.toString, e)
				}
			]
		}
		return resourceDescriptions
	}

	private def void process(File file, ResourceSet resourceSet) {
		try {
			if (!file.canRead)
				return
			else if (file.isDirectory)
				file.listFiles.forEach[process(resourceSet)]
			else if (file.name.endsWith('.turn'))
				resourceSet.getResource(URI.createFileURI(file.absolutePath), true)
			else if (file.name.endsWith('.zip')) {
				val zipFile = new ZipFile(file)
				val entries = zipFile.entries
				val zipFileUri = URI.createFileURI(file.absolutePath).toString
				while (entries.hasMoreElements) {
					val entry = entries.nextElement
					if (!entry.directory && entry.name.endsWith('.turn')) {
						val zipEntryUri = URI.createURI('archive:' + zipFileUri + '!/' + entry.name)
						val resource = resourceSet.createResource(zipEntryUri)
						resource.load(zipFile.getInputStream(entry), null)
					}
				}
			}
			} catch (Throwable e) {
				LOG.error('Error loading turnPath resource ' + URI.toString, e)
			}
	}
}
