package ch.deletescape.primitives;

import ch.deletescape.primitives.arrays.CharArrays;

/**
 * Technically String isn't a primitive type, but it is used almost the same way.
 * 
 * @author deletescape
 */
public final class Strings {
  private static final String ELEMENT_COUNT_MISSMATCH_ERROR = "Number of elements ({}) and tokens ({}) doesn't match.";
  private static final char[] FORMAT_TOKEN = { '{', '}' };
  private static final int TOKEN_LENGTH = FORMAT_TOKEN.length;
  private static final char[] FORMAT_NULL_REPLACEMENT = { 'n', 'u', 'l', 'l' };

  /**
   * Private Constructor to prevent initialization
   */
  private Strings() {}

  /**
   * Reverses all chars in a String. For example reversing {@code "Test"} would result in
   * {@code "tseT"}.
   * 
   * @param str
   *          the String to be reversed
   * @return the reversed version of {@code str} or {@code null} if {@code str} is {@code null}.
   */
  public static String reverse(String str) {
    if (str == null || str.isEmpty()) {
      return str;
    }
    char[] ca = str.toCharArray();
    int maxIdx = ca.length - 1;
    for (int i = 0; i <= maxIdx / 2; i++) {
      char c = ca[i];
      ca[i] = ca[maxIdx - i];
      ca[maxIdx - i] = c;
    }
    return new String(ca);
  }

  /**
   * This is a simple and fast alternative to {@link String#format(String, Object...)}, formatting
   * works by replacing "{}" tokens with the supplied elements. "Hello {}!" and a element "World"
   * would result in "Hello World!". Elements with null values are replaced by the String "null"
   * 
   * @param format
   *          a formatting string following the described syntax
   * @param elements
   *          the elements to be used as replacements for formatting tokens by invoking
   *          {@code toString()} on them.
   * @return a formatted String.
   * @throws SimpleFormatException
   *           if there are either too many or not enough elements for the number of formatting
   *           tokens
   */
  public static String simpleFormat(String format, Object... elements) {
    // Working with a char array is better for performance than working with a String
    char[] str = format.toCharArray();
    // --- Preparation and validation: ---
    int elementCount = elements == null ? 0 : elements.length;
    int tokenCount = CharArrays.countSequence(str, FORMAT_TOKEN);
    if (elementCount != tokenCount) {
      throw new SimpleFormatException(simpleFormat(ELEMENT_COUNT_MISSMATCH_ERROR, elementCount, tokenCount));
    }
    if (elementCount == 0) { // tokenCount is 0 too in this case
      return format;
    }
    // --- The formatting algorithm itself starts here: ---
    int lastIndex = 0;
    for (Object element : elements) {
      int idx = CharArrays.findSequence(lastIndex, str, FORMAT_TOKEN);
      // Replace null values with the string "null" which is a char[] for performance reasons
      char[] eStr = element != null ? element.toString().toCharArray() : FORMAT_NULL_REPLACEMENT;
      // We want to trim away the {} token, so we subtract it from the format strings total length
      int lenArr = str.length - TOKEN_LENGTH;
      int lenIns = eStr.length;
      // A Temporary array of the required size is created
      char[] arr = new char[lenArr + lenIns];
      // Here we take the first part of our original format string and place it in the temp array
      System.arraycopy(str, 0, arr, 0, idx);
      // Placing the replacement at the index of our token
      System.arraycopy(eStr, 0, arr, idx, lenIns);
      // Adding the end of the format string back to our new string, trimming away the {} sequence
      System.arraycopy(str, idx + TOKEN_LENGTH, arr, idx + lenIns, lenArr - idx);
      // Reassigning the value of our temp array to our original array
      str = arr;
      // We need a way to save how much of the string we have processed already
      lastIndex = idx + lenIns;
    }
    return new String(str);
  }

  /**
   * Repeats the String {@code str} {@code times} number of times. A value of {@code 2} for
   * {@code times} and {@code "tst"} for {@code str} would thus result in {@code "tsttst"}
   * 
   * @param times
   *          the number of times to repeat the supplied string
   * @param str
   *          the string to repeat
   * @return a string consisting of {@code str} repeated {@code times} times
   * @see #repeat(int, char...)
   */
  public static String repeat(int times, String str) {
    return repeat(times, str.toCharArray());
  }

  /**
   * Repeats the characters {@code chars} {@code times} number of times. A value of {@code 2} for
   * {@code times} and {@code 'a',' ','b'} for {@code chars} would thus result in {@code "a ba b"}
   * 
   * @param times
   *          the number of times to repeat the supplied chars
   * @param chars
   *          the chars to repeat
   * @return a string consisting of {@code chars} repeated {@code times} times
   */
  public static String repeat(int times, char... chars) {
    int len = chars.length;
    int resLen = times * len;
    char[] res = new char[resLen];
    for (int i = 0; i < resLen; i += len) {
      for (int j = 0; j < len; j++) {
        res[i + j] = chars[j];
      }
    }
    return new String(res);
  }
}
