package mcgill.xtext.turn.utils

import com.google.common.base.Preconditions
import com.google.common.cache.CacheBuilder

import org.eclipse.emf.ecore.EClass
import org.eclipse.xtend.lib.annotations.Data

import static com.google.common.base.CaseFormat.*
import static com.google.common.base.CharMatcher.*
import org.xtext.example.mydsl.tURN.TURNPackage

/**
 * Utility class for getting the YANG name from EObject instances and EClasses.
 * 
 * <p>
 * For instance {@code YangVersion} will return with {@code turn-version}.
 * 
 * @author akos.kitta
 */
abstract class YangNameUtils {

	static val NAME_TO_ECLASS_CACHE = CacheBuilder.newBuilder.<String, EClassWrapper>build([
		val simpleName = LOWER_HYPHEN.converterTo(UPPER_CAMEL).convert(it);
		val classifier = TURNPackage.eINSTANCE.getEClassifier(simpleName);
		if (classifier instanceof EClass) {
			return new EClassWrapper(classifier);
		}
		return EClassWrapper.MISSING;
	]);

	/**
	 * Returns with the human readable statement of the YANG statement. 
	 */

	/**
	 * Returns with the YANG name of the class argument. 
	 */
	static def dispatch String getYangName(Class<?> clazz) {
		Preconditions.checkNotNull(clazz, 'clazz');
		return UPPER_CAMEL.converterTo(LOWER_HYPHEN).convert(clazz.simpleName).toFirstLower;
	}

	/**
	 * Returns with the EClass for the YANG name or {@code null} if the EClass cannot be resolved.
	 * <p>
	 * For instance returns with {@link BelongsTo} for {@code belongs-to}.
	 */
	static def EClass getEClassForName(String turnName) {
		return if(turnName.nullOrEmpty) null else NAME_TO_ECLASS_CACHE.getUnchecked(turnName).orNull;
	}

	/**
	 * Replaces all whitespace (and invisible) characters with a hyphen (@code {-}) character in the 
	 * argument and returns with it. Consecutive whitespace character will be replaced with one single
	 * hyphen. Trailing and leading whitespace characters will not be replaces but just trimmed. 
	 */	
	static def String escapeModuleName(String it) {
		return WHITESPACE.or(BREAKING_WHITESPACE).or(INVISIBLE).trimAndCollapseFrom(trim, '-');
	}

	private new() {
	}

	/**
	 * Wraps an EClass because the loading cache must not return with {@code null}.
	 */
	@Data
	static final class EClassWrapper {

		static val MISSING = new EClassWrapper(null);

		val EClass clazz;

		def private orNull() {
			return if(clazz === null || this === MISSING) null else clazz;
		}

	}

}
