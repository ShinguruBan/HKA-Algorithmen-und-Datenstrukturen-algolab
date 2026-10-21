package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.Reverse;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseArrayTest {
    @Test
    public void testReverseArray() {
        Reverse<Integer> test = new ReverseArray<>();
        Integer[] testSequence = {2, 76, 34, 987, 23, 56, 24, 76};
        test.reverse(testSequence, 0, testSequence.length - 1);
        Integer[] correctSequence = {76, 24, 56, 23, 987, 34, 76, 2};

        Assert.assertEquals(correctSequence, testSequence);
    }

    @Test
    public void testReverseArrayUneven() {
        Reverse<Integer> test = new ReverseArray<>();
        Integer[] testSequence = {2, 76, 34, 23, 56, 24, 76};
        test.reverse(testSequence, 0, testSequence.length - 1);
        Integer[] correctSequence = {76, 24, 56, 23, 34, 76, 2};

        Assert.assertEquals(correctSequence, testSequence);
    }

    @Test
    public void testReverseArrayUpperHalf() {
        Reverse<Integer> test = new ReverseArray<>();
        Integer[] testSequence = {2, 76, 34, 987, 23, 56, 24, 76};
        test.reverse(testSequence, 4, testSequence.length - 1);
        Integer[] correctSequence = {2, 76, 34, 987, 76, 24, 56, 23};

        Assert.assertEquals(correctSequence, testSequence);
    }

    @Test
    public void testReverseArrayLowerHalf() {
        Reverse<Integer> test = new ReverseArray<>();
        Integer[] testSequence = {2, 76, 34, 987, 23, 56, 24, 76};
        test.reverse(testSequence, 0, (testSequence.length - 1) / 2);
        Integer[] correctSequence = {987, 34, 76, 2, 23, 56, 24, 76};

        Assert.assertEquals(correctSequence, testSequence);
    }

    @Test
    public void testReverseArrayMiddlePart() {
        Reverse<Integer> test = new ReverseArray<>();
        Integer[] testSequence = {2, 76, 34, 987, 23, 56, 24, 76};
        test.reverse(testSequence, 3, 5);
        Integer[] correctSequence = {2, 76, 34, 56, 23, 987, 24, 76};

        Assert.assertEquals(correctSequence, testSequence);
    }

    @Test
    public void testReverseArrayOutOfBounds() {
        Reverse<Integer> test = new ReverseArray<>();
        Integer[] testSequence = {2, 76, 34, 987, 23, 56, 24, 76};

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> test.reverse(testSequence, -1, testSequence.length - 1));
    }

    @Test
    public void testReverseArrayOutOfBounds2() {
        Reverse<Integer> test = new ReverseArray<>();
        Integer[] testSequence = {2, 76, 34, 987, 23, 56, 24, 76};

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> test.reverse(testSequence, 0, testSequence.length));
    }
}
