package ch.deletescape.primitives.arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PrIntArrayTest {
  @Test
  public void fromLong() {
    assertThat(PrIntArray.from(new long[] { 1L, Long.MAX_VALUE, Long.MAX_VALUE - 1 }), is(new int[] { 1, -1, -2 }));
  }

  @Test
  public void fromShort() {
    assertThat(PrIntArray.from(new short[] { 1, Short.MAX_VALUE }), is(new int[] { 1, 32767 }));
  }

  @Test
  public void fromByte() {
    assertThat(PrIntArray.from(new byte[] { 1, Byte.MAX_VALUE }), is(new int[] { 1, 127 }));
  }

  @Test
  public void fromChar() {
    assertThat(PrIntArray.from(new char[] { '\0', Character.MAX_VALUE, 1 }), is(new int[] { 0, 65535, 1 }));
  }

  @Test
  public void fromDouble() {
    assertThat(PrIntArray.from(new double[] { 1.0, 1.3, Double.MAX_VALUE }), is(new int[] { 1, 1, 2147483647 }));
  }

  @Test
  public void fromFloat() {
    assertThat(PrIntArray.from(new float[] { 1f, 1.3f, Float.MAX_VALUE }), is(new int[] { 1, 1, 2147483647 }));
  }

  @Test
  public void fromBoolean() {
    assertThat(PrIntArray.from(new boolean[] { true, false }), is(new int[] { 1, 0 }));
  }

  @Test
  public void join() {
    assertThat(PrIntArray.join(";", 1, -20, 3), is("1;-20;3"));
  }

  @Test
  public void concat() {
    assertThat(PrIntArray.concatAll(new int[] { 1, 3 }, new int[] { -2, 5 }), is(new int[] { 1, 3, -2, 5 }));
  }

  @Test
  public void contains() {
    assertThat(PrIntArray.contains(new int[] { 1, 3 }, 3), is(true));
    assertThat(PrIntArray.contains(new int[] { 1, 3 }, 5), is(false));
  }

  @Test
  public void distinct() {
    assertThat(PrIntArray.distinct(new int[] { 1, 2, 1, 3 }), is(new int[] { 1, 2, 3 }));
    assertThat(PrIntArray.distinct(new int[0]), is(new int[0]));
  }

  @Test
  public void findSequence() {
    assertThat(PrIntArray.findSequence(2, new int[] { 1, 2, 1, 3 }, 2, 1), is(-1));
    assertThat(PrIntArray.findSequence(2, new int[] { 1, 2, 1, 2 }, 1, 2), is(2));

    assertThat(PrIntArray.findSequence(new int[] { 1, 2, 1, 3 }, 2, 1), is(1));
    assertThat(PrIntArray.findSequence(new int[] { 1, 2, 1, 3 }, 1, 3), is(2));
    assertThat(PrIntArray.findSequence(new int[] { 1, 2, 1, 3 }, 1, 1), is(-1));
    assertThat(PrIntArray.findSequence(new int[] { 1, 2, 1, 3 }, 3), is(3));
    assertThat(PrIntArray.findSequence(new int[] { 1, 2, 1, 3 }, 4), is(-1));
  }

  @Test
  public void countSequence() {
    assertThat(PrIntArray.countSequence(2, new int[] { 1, 2, 1, 3 }, 2, 1), is(0));
    assertThat(PrIntArray.countSequence(1, new int[] { 1, 2, 1, 3 }, 1), is(1));

    assertThat(PrIntArray.countSequence(new int[] { 1, 2, 1, 3 }, 2, 1), is(1));
    assertThat(PrIntArray.countSequence(new int[] { 1, 2, 1, 3 }, 1), is(2));
    assertThat(PrIntArray.countSequence(new int[] { 1, 2, 1, 3 }, 4), is(0));
  }

  @Test
  public void insert() {
    assertThat(PrIntArray.insert(new int[] { 1, 2, 3, 4 }, new int[] { 10, 11 }, 2),
        is(new int[] { 1, 2, 10, 11, 3, 4 }));
    assertThat(PrIntArray.insert(new int[] { 1, 2, 3, 4 }, new int[0], 0), is(new int[] { 1, 2, 3, 4 }));
    assertThat(PrIntArray.insert(new int[] { 1, 2, 3, 4 }, new int[] { 10, 11 }, 5),
        is(new int[] { 1, 2, 3, 4, 10, 11 }));
    assertThat(PrIntArray.insert(new int[] { 1, 2, 3, 4 }, new int[] { 10, 11 }, -4),
        is(new int[] { 10, 11, 1, 2, 3, 4 }));
  }

  @Test
  public void append() {
    assertThat(PrIntArray.append(new int[] { 1, 2, 3, 4 }, 10, 11), is(new int[] { 1, 2, 3, 4, 10, 11 }));
    assertThat(PrIntArray.append(new int[] { 1, 2, 3, 4 }), is(new int[] { 1, 2, 3, 4 }));
  }

  // Calls the #random(int) method for coverage reasons
  @Test
  public void random() {
    PrIntArray.random(1);
  }
}