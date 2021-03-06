package ch.deletescape.primitives.arrays;

import java.util.Random;

import ch.deletescape.primitives.Floats;

public final class FloatArrays {
  private static final float DELTA = 0.001f;

  /**
   * Private Constructor to prevent initialization
   */
  private FloatArrays() {}

  /**
   * Converts a int array to a float array
   * 
   * @param iArr
   *          the int array to convert
   * @return the resulting float array.
   */
  public static float[] from(int[] iArr) {
    float[] tmp = new float[iArr.length];
    for (int i = 0; i < iArr.length; i++) {
      tmp[i] = iArr[i];
    }
    return tmp;
  }

  /**
   * Converts a char array to a float array
   * 
   * @param cArr
   *          the char array to convert
   * @return the resulting float array.
   */
  public static float[] from(char[] cArr) {
    float[] tmp = new float[cArr.length];
    for (int i = 0; i < cArr.length; i++) {
      tmp[i] = cArr[i];
    }
    return tmp;
  }

  /**
   * Converts a byte array to a float array
   * 
   * @param bArr
   *          the byte array to convert
   * @return the resulting float array.
   */
  public static float[] from(byte[] bArr) {
    float[] tmp = new float[bArr.length];
    for (int i = 0; i < bArr.length; i++) {
      tmp[i] = bArr[i];
    }
    return tmp;
  }

  /**
   * Converts a short array to a float array
   * 
   * @param shrtArr
   *          the short array to convert
   * @return the resulting float array.
   */
  public static float[] from(short[] shrtArr) {
    float[] tmp = new float[shrtArr.length];
    for (int i = 0; i < shrtArr.length; i++) {
      tmp[i] = shrtArr[i];
    }
    return tmp;
  }

  /**
   * Converts a double array to a float array using {@link Floats#from(double)}
   * 
   * @param dblArr
   *          the double array to convert
   * @return the resulting float array.
   * @see Floats#from(double)
   */
  public static float[] from(double[] dblArr) {
    float[] tmp = new float[dblArr.length];
    for (int i = 0; i < dblArr.length; i++) {
      tmp[i] = Floats.from(dblArr[i]);
    }
    return tmp;
  }

  /**
   * Converts a long array to a float array
   * 
   * @param lngArr
   *          the long array to convert
   * @return the resulting float array.
   */
  public static float[] from(long[] lngArr) {
    float[] tmp = new float[lngArr.length];
    for (int i = 0; i < lngArr.length; i++) {
      tmp[i] = lngArr[i];
    }
    return tmp;
  }

  /**
   * Converts a boolean array to a float array using {@link Floats#from(boolean)}
   * 
   * @param boolArr
   *          the boolean array to convert
   * @return the resulting float array.
   * @see Floats#from(boolean)
   */
  public static float[] from(boolean[] boolArr) {
    float[] tmp = new float[boolArr.length];
    for (int i = 0; i < boolArr.length; i++) {
      tmp[i] = Floats.from(boolArr[i]);
    }
    return tmp;
  }

  /**
   * Creates an array of random float values using {@link Floats#random()}
   * 
   * @param size
   *          the amount of random values
   * @return an array pseudorandom float values.
   * @see Random
   * @see Floats#random()
   */
  public static float[] random(int size) {
    float[] tmp = new float[size];
    for (int i = 0; i < size; i++) {
      tmp[i] = Floats.random();
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
  public static String join(CharSequence delimiter, float... elements) {
    String[] tmp = new String[elements.length];
    for (int i = 0; i < tmp.length; i++) {
      tmp[i] = Float.toString(elements[i]);
    }
    return String.join(delimiter, tmp);
  }

  /**
   * Concatenate any number of float arrays
   * 
   * @param arrays
   *          the {@code float} arrays to concatenate
   * @return an {@code float} array cotaining the values of all {@code arrays}
   */
  public static float[] concatAll(float[]... arrays) {
    int totalLength = 0;
    for (float[] array : arrays) {
      totalLength += array.length;
    }
    float[] result = new float[totalLength];
    int offset = 0;
    for (float[] array : arrays) {
      System.arraycopy(array, 0, result, offset, array.length);
      offset += array.length;
    }
    return result;
  }

  /**
   * Returns true if the array contains the specified value, a delta of
   * {@code 0.001} is used for equality checks
   * 
   * @param array
   *          the array to search for {@code value}
   * @param value
   *          the value to check for
   * @return whether or not {@code array} contains {@code value}
   */
  public static boolean contains(float[] array, float value) {
    for (float item : array) {
      if (Floats.equality(item, value, DELTA)) {
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
  public static float[] distinct(float[] array) {
    float[] tmp = new float[array.length];
    int i = 0;
    for (float item : array) {
      if (!contains(tmp, item)) {
        tmp[i++] = item;
      }
    }
    float[] distincts = new float[i];
    System.arraycopy(tmp, 0, distincts, 0, i);
    return distincts;
  }

  /**
   * Finds the first occurrence of a sequence of values in an array, a delta of
   * {@code 0.001} is used for equality checks
   * 
   * @param array
   *          the array to search
   * @param sequence
   *          the sequence to search for
   * @return the index of the first sequence occurrence inside {@code array} or {@code -1} if the
   *         sequence isn't found
   */
  public static int findSequence(float[] array, float... sequence) {
    return findSequence(0, array, sequence);
  }

  /**
   * Finds the first occurrence starting from {@code fromIndex} of a sequence of values in an array
   * 
   * @param fromIndex
   *          the index from where to start searching
   * @param array
   *          the array to search
   * @param sequence
   *          the sequence to search for
   * @return the index of the first sequence occurrence inside {@code array} or {@code -1} if the
   *         sequence isn't found
   */
  public static int findSequence(int fromIndex, float[] array, float... sequence) {
    int seqLen = sequence.length;
    int maxIdx = array.length - seqLen;
    for (int i = Math.min(fromIndex, maxIdx); i <= maxIdx; i++) {
      for (int j = 0; Floats.equality(array[i + j], sequence[j], DELTA); j++) {
        if (j == seqLen - 1) {
          return i;
        }
      }
    }
    return -1;
  }

  /**
   * Counts the number of times {@code sequence} can be found inside {@code array}
   * 
   * @param array
   *          the array to search
   * @param sequence
   *          the sequence to search for
   * @return the number of occurrences of {@code sequence} inside {@code array}
   * @see #findSequence(float[], float...)
   */
  public static int countSequence(float[] array, float... sequence) {
    return countSequence(0, array, sequence);
  }

  /**
   * Counts the number of times {@code sequence} can be found inside {@code array}, starting from
   * {@code from index}
   * 
   * @param fromIndex
   *          the index from where to start searching
   * @param array
   *          the array to search
   * @param sequence
   *          the sequence to search for
   * @return the number of occurrences of {@code sequence} inside {@code array}
   * @see #findSequence(int, float[], float...)
   */
  public static int countSequence(int fromIndex, float[] array, float... sequence) {
    int count = 0;
    int idx = fromIndex;
    int len = sequence.length;
    int maxIdx = array.length - 1;
    while (idx < maxIdx && (idx = findSequence(idx, array, sequence)) != -1) {
      count++;
      idx += len;
    }
    return count;
  }

  /**
   * Insert an array into another one starting at the specified {@code index}
   * 
   * @param array
   *          the array where you want to insert the values
   * @param insert
   *          the array to insert into {@code array}
   * @param index
   *          the index from where to start inserting the values
   * @return a new array, based on a copy of {@code array} with {@code insert} inserted into it
   */
  public static float[] insert(float[] array, float[] insert, int index) {
    int lenArr = array.length;
    int lenIns = insert.length;
    int idx = Math.max(0, Math.min(lenArr, index));
    int offset = Math.min(idx + 1, lenArr);
    float[] arr = new float[lenArr + lenIns];
    System.arraycopy(array, 0, arr, 0, offset);
    System.arraycopy(insert, 0, arr, idx, lenIns);
    System.arraycopy(array, idx, arr, idx + lenIns, lenArr - idx);
    return arr;
  }

  /**
   * Append values to the end of a float array
   * 
   * @param array
   *          the array to append the values to
   * @param values
   *          the values to append
   * @return a new array consisting of all values of {@code array} and {@code values}.
   * @see #insert(float[], float[], int)
   */
  public static float[] append(float[] array, float... values) {
    return insert(array, values, array.length);
  }

  /**
   * Returns the greater of any number values.
   * 
   * @param values
   *          the values to compare
   * @return the biggest value from {@code values}
   */
  public static float max(float... values) {
    if (values.length == 0) {
      throw new InvalidArrayException("Can't get max value from empty array");
    }
    float max = values[0];
    for (float i : values) {
      if (i > max) {
        max = i;
      }
    }
    return max;
  }

  /**
   * Returns the smaller of any number of values.
   * 
   * @param values
   *          the values to compare
   * @return the smallest value from {@code values}
   */
  public static float min(float... values) {
    if (values.length == 0) {
      throw new InvalidArrayException("Can't get min value from empty array");
    }
    float min = values[0];
    for (float i : values) {
      if (i < min) {
        min = i;
      }
    }
    return min;
  }

  /**
   * Returns the average of any number of values.
   * 
   * @param values
   *          the values to compare
   * @return the average value of {@code values}
   */
  public static float avg(float... values) {
    int len = values.length;
    if (len == 0) {
      throw new InvalidArrayException("Can't get average value from empty array");
    }
    return sum(values) / len;
  }

  /**
   * Returns the sum of any number of values.
   * 
   * @param values
   *          the values to sum up
   * @return the sum of {@code values}
   */
  public static float sum(float... values) {
    float total = 0;
    for (float i : values) {
      total += i;
    }
    return total;
  }
}
