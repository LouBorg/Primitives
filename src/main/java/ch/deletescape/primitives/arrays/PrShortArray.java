package ch.deletescape.primitives.arrays;

import java.util.Random;

import ch.deletescape.primitives.PrShort;

public final class PrShortArray {
  /**
   * Private Constructor to prevent initialization
   */
  private PrShortArray() {}

  /**
   * Converts a long array to a short array using {@link PrShort#from(long)}
   * 
   * @param lngArr
   *          the long array to convert
   * @return the resulting short array.
   * @see PrShort#from(long)
   */
  public static short[] from(long[] lngArr) {
    short[] tmp = new short[lngArr.length];
    for (int i = 0; i < lngArr.length; i++) {
      tmp[i] = PrShort.from(lngArr[i]);
    }
    return tmp;
  }

  /**
   * Converts a char array to a short array using {@link PrShort#from(char)}
   * 
   * @param cArr
   *          the char array to convert
   * @return the resulting short array.
   * @see PrShort#from(char)
   */
  public static short[] from(char[] cArr) {
    short[] tmp = new short[cArr.length];
    for (int i = 0; i < cArr.length; i++) {
      tmp[i] = PrShort.from(cArr[i]);
    }
    return tmp;
  }

  /**
   * Converts a byte array to a short array
   * 
   * @param bArr
   *          the byte array to convert
   * @return the resulting short array.
   */
  public static short[] from(byte[] bArr) {
    short[] tmp = new short[bArr.length];
    for (int i = 0; i < bArr.length; i++) {
      tmp[i] = bArr[i];
    }
    return tmp;
  }

  /**
   * Converts a int array to a short array using {@link PrShort#from(int)}
   * 
   * @param iArr
   *          the int array to convert
   * @return the resulting short array.
   * @see PrShort#from(int)
   */
  public static short[] from(int[] iArr) {
    short[] tmp = new short[iArr.length];
    for (int i = 0; i < iArr.length; i++) {
      tmp[i] = PrShort.from(iArr[i]);
    }
    return tmp;
  }

  /**
   * Converts a double array to a short array using {@link PrShort#from(double)}
   * 
   * @param dblArr
   *          the double array to convert
   * @return the resulting short array.
   * @see PrShort#from(double)
   */
  public static short[] from(double[] dblArr) {
    short[] tmp = new short[dblArr.length];
    for (int i = 0; i < dblArr.length; i++) {
      tmp[i] = PrShort.from(dblArr[i]);
    }
    return tmp;
  }

  /**
   * Converts a float array to a short array using {@link PrShort#from(float)}
   * 
   * @param fltArr
   *          the float array to convert
   * @return the resulting short array.
   * @see PrShort#from(float)
   */
  public static short[] from(float[] fltArr) {
    short[] tmp = new short[fltArr.length];
    for (int i = 0; i < fltArr.length; i++) {
      tmp[i] = PrShort.from(fltArr[i]);
    }
    return tmp;
  }

  /**
   * Converts a boolean array to a short array using {@link PrShort#from(boolean)}
   * 
   * @param boolArr
   *          the boolean array to convert
   * @return the resulting short array.
   * @see PrShort#from(boolean)
   */
  public static short[] from(boolean[] boolArr) {
    short[] tmp = new short[boolArr.length];
    for (int i = 0; i < boolArr.length; i++) {
      tmp[i] = PrShort.from(boolArr[i]);
    }
    return tmp;
  }

  /**
   * Creates an array of random short values using {@link PrShort#random()}
   * 
   * @param size
   *          the amount of random values
   * @return an array pseudorandom short values.
   * @see Random
   * @see PrShort#random()
   */
  public static short[] random(int size) {
    short[] tmp = new short[size];
    for (int i = 0; i < size; i++) {
      tmp[i] = PrShort.random();
    }
    return tmp;
  }

  /**
   * See {@link String#join(CharSequence, CharSequence...)}
   * 
   * @param delimiter
   *          the delimiter that separates each element
   * @param elements
   *          the elements to join together.
   * @return a new {@code String} that is composed of the {@code elements} separated by the
   *         {@code delimiter}
   * @see String#join(CharSequence, CharSequence...)
   */
  public static String join(CharSequence delimiter, short... elements) {
    String[] tmp = new String[elements.length];
    for (int i = 0; i < tmp.length; i++) {
      tmp[i] = Short.toString(elements[i]);
    }
    return String.join(delimiter, tmp);
  }

  /**
   * Concatenate any number of short arrays
   * 
   * @param arrays
   *          the {@code short} arrays to concatenate
   * @return an {@code short} array cotaining the values of all {@code arrays}
   */
  public static short[] concatAll(short[]... arrays) {
    int totalLength = 0;
    for (short[] array : arrays) {
      totalLength += array.length;
    }
    short[] result = new short[totalLength];
    int offset = 0;
    for (short[] array : arrays) {
      System.arraycopy(array, 0, result, offset, array.length);
      offset += array.length;
    }
    return result;
  }

  /**
   * Returns true if the array contains the specified value
   * 
   * @param array
   *          the array to search for {@code value}
   * @param value
   *          the value to check for
   * @return whether or not {@code array} contains {@code value}
   */
  public static boolean contains(short[] array, short value) {
    for (short item : array) {
      if (item == value) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns a new array containing only the unique values of the original array
   * 
   * @param array
   *          the array to search
   * @return only the distinct values in {@code array}
   */
  public static short[] distinct(short[] array) {
    short[] tmp = new short[array.length];
    int i = 0;
    for (short item : array) {
      if (!contains(tmp, item)) {
        tmp[i] = item;
        i++;
      }
    }
    short[] distincts = new short[i];
    System.arraycopy(tmp, 0, distincts, 0, i);
    return distincts;
  }
}