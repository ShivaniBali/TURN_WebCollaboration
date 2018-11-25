package mcgill.xtext.turn.utils;

import java.util.regex.Pattern;
import org.eclipse.xtext.conversion.ValueConverterException;

@SuppressWarnings("all")
public class YangStringUtils {
  private static Pattern ID_MATCH = Pattern.compile("[\\s\'\";\\{\\}]");
  
  private static Pattern SINGLE_QUTOTE_MATCH = Pattern.compile("\'");
  
  private static Pattern DOUBLE_QUTOTE_MATCH = Pattern.compile("\"");
  
  public static String addQuotesIfNecessary(final String value) throws ValueConverterException {
    boolean _isEmpty = value.isEmpty();
    if (_isEmpty) {
      return "\"\"";
    }
    boolean _find = YangStringUtils.ID_MATCH.matcher(value).find();
    if (_find) {
      final boolean hasSingleQuotes = YangStringUtils.SINGLE_QUTOTE_MATCH.matcher(value).find();
      final boolean hasDoubleQuotes = YangStringUtils.DOUBLE_QUTOTE_MATCH.matcher(value).find();
      if (hasSingleQuotes) {
        if (hasDoubleQuotes) {
          return YangStringUtils.addQuotesAndBackslashes(value);
        } else {
          return (("\"" + value) + "\"");
        }
      } else {
        return (("\'" + value) + "\'");
      }
    }
    return value;
  }
  
  private static String addQuotesAndBackslashes(final String value) {
    final StringBuilder b = new StringBuilder();
    b.append("\"");
    char lastChar = ((char) 0);
    for (int i = 0; (i < value.length()); i++) {
      {
        final char ch = value.charAt(i);
        if (((ch == 34) && (lastChar != 92))) {
          b.append("\\");
        }
        b.append(ch);
        lastChar = ch;
      }
    }
    b.append("\"");
    return b.toString();
  }
}
