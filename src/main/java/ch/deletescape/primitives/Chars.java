package ch.deletescape.primitives;

import java.util.Random;

public final class Chars {
  /**
   * Private Constructor to prevent initialization
   */
  private Chars() {}

  /**
   * Converts a byte value to char by simply casting it
   * 
   * @param b
   *          the byte value to convert
   * @return the resulting char.
   */
  public static char from(byte b) {
    return (char) b;
  }

  /**
   * Converts a short value to char by simply casting it
   * 
   * @param shrt
   *          the short value to convert
   * @return the resulting char.
   */
  public static char from(short shrt) {
    return (char) shrt;
  }

  /**
   * Converts a long value to char by simply casting it
   * 
   * @param lng
   *          the long value to convert
   * @return the resulting char.
   */
  public static char from(long lng) {
    return (char) lng;
  }

  /**
   * Converts a int value to char by simply casting it
   * 
   * @param i
   *          the int value to convert
   * @return the resulting char.
   */
  public static char from(int i) {
    return (char) i;
  }

  /**
   * Converts a double value to char by simply casting it
   * 
   * @param dbl
   *          the double value to convert
   * @return the resulting char.
   */
  public static char from(double dbl) {
    return (char) dbl;
  }

  /**
   * Converts a float value to char by simply casting it
   * 
   * @param flt
   *          the float value to convert
   * @return the resulting char.
   */
  public static char from(float flt) {
    return (char) flt;
  }

  /**
   * Converts a boolean value to char, {@code true} resulting in {@code 1} and {@code false}
   * resulting in {@code 0}
   * 
   * @param bool
   *          the boolean value to convert
   * @return the resulting char.
   * @see Ints#from(boolean)
   */
  public static char from(boolean bool) {
    return from(Ints.from(bool));
  }

  /**
   * calls {@link Ints#random()} and casts the result to {@code char}
   * 
   * @return a pseudorandom char value.
   * @see Random
   * @see Ints#random()
   */
  public static char random() {
    return from(Ints.random());
  }
}
