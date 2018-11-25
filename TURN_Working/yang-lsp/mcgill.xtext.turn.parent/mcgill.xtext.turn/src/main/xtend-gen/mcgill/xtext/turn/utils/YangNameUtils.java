package mcgill.xtext.turn.utils;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.xtext.example.mydsl.tURN.TURNPackage;

/**
 * Utility class for getting the YANG name from EObject instances and EClasses.
 * 
 * <p>
 * For instance {@code YangVersion} will return with {@code turn-version}.
 * 
 * @author akos.kitta
 */
@SuppressWarnings("all")
public abstract class YangNameUtils {
  /**
   * Wraps an EClass because the loading cache must not return with {@code null}.
   */
  @Data
  public static final class EClassWrapper {
    private static final YangNameUtils.EClassWrapper MISSING = new YangNameUtils.EClassWrapper(null);
    
    private final EClass clazz;
    
    private EClass orNull() {
      EClass _xifexpression = null;
      if (((this.clazz == null) || (this == YangNameUtils.EClassWrapper.MISSING))) {
        _xifexpression = null;
      } else {
        _xifexpression = this.clazz;
      }
      return _xifexpression;
    }
    
    public EClassWrapper(final EClass clazz) {
      super();
      this.clazz = clazz;
    }
    
    @Override
    @Pure
    public int hashCode() {
      return 31 * 1 + ((this.clazz== null) ? 0 : this.clazz.hashCode());
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      YangNameUtils.EClassWrapper other = (YangNameUtils.EClassWrapper) obj;
      if (this.clazz == null) {
        if (other.clazz != null)
          return false;
      } else if (!this.clazz.equals(other.clazz))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("clazz", this.clazz);
      return b.toString();
    }
    
    @Pure
    public EClass getClazz() {
      return this.clazz;
    }
  }
  
  private static final LoadingCache<String, YangNameUtils.EClassWrapper> NAME_TO_ECLASS_CACHE = CacheBuilder.newBuilder().<String, YangNameUtils.EClassWrapper>build(
    new CacheLoader<String, YangNameUtils.EClassWrapper>() {
      @Override
      public YangNameUtils.EClassWrapper load(final String it) throws Exception {
        final String simpleName = CaseFormat.LOWER_HYPHEN.converterTo(CaseFormat.UPPER_CAMEL).convert(it);
        final EClassifier classifier = TURNPackage.eINSTANCE.getEClassifier(simpleName);
        if ((classifier instanceof EClass)) {
          return new YangNameUtils.EClassWrapper(((EClass)classifier));
        }
        return YangNameUtils.EClassWrapper.MISSING;
      }
    });
  
  /**
   * Returns with the YANG name of the class argument.
   */
  protected static String _getYangName(final Class<?> clazz) {
    Preconditions.<Class<?>>checkNotNull(clazz, "clazz");
    return StringExtensions.toFirstLower(CaseFormat.UPPER_CAMEL.converterTo(CaseFormat.LOWER_HYPHEN).convert(clazz.getSimpleName()));
  }
  
  /**
   * Returns with the EClass for the YANG name or {@code null} if the EClass cannot be resolved.
   * <p>
   * For instance returns with {@link BelongsTo} for {@code belongs-to}.
   */
  public static EClass getEClassForName(final String turnName) {
    EClass _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(turnName);
    if (_isNullOrEmpty) {
      _xifexpression = null;
    } else {
      _xifexpression = YangNameUtils.NAME_TO_ECLASS_CACHE.getUnchecked(turnName).orNull();
    }
    return _xifexpression;
  }
  
  /**
   * Replaces all whitespace (and invisible) characters with a hyphen (@code {-}) character in the
   * argument and returns with it. Consecutive whitespace character will be replaced with one single
   * hyphen. Trailing and leading whitespace characters will not be replaces but just trimmed.
   */
  public static String escapeModuleName(final String it) {
    return CharMatcher.WHITESPACE.or(CharMatcher.BREAKING_WHITESPACE).or(CharMatcher.INVISIBLE).trimAndCollapseFrom(it.trim(), '-');
  }
  
  private YangNameUtils() {
  }
  
  public static String getYangName(final Class<?> clazz) {
    return _getYangName(clazz);
  }
}
