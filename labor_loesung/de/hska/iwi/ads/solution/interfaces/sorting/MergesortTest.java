package de.hska.iwi.ads.solution.sorting;

import de.hska.iwi.ads.sorting.AbstractMergesort;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MergesortTest {
    @Test
    public void testMergesort() {
        AbstractMergesort<Integer> test = new Mergesort<>();
        Integer[] testSequence = {2, 76, 34, 987, 23, 56, 24, 76};
        test.sort(testSequence);
        Integer[] correctSequence = {2, 23, 24, 34, 56, 76, 76, 987};

        Assert.assertEquals(correctSequence, testSequence);
    }

    @Test
    public void testSortedSequence() {
        AbstractMergesort<Integer> test = new Mergesort<>();
        Integer[] testSequence = {2, 23, 24, 34, 56, 76, 76, 987};
        test.sort(testSequence);
        Integer[] correctSequence = {2, 23, 24, 34, 56, 76, 76, 987};

        Assert.assertEquals(correctSequence, testSequence);
    }

    @Test
    public void testReversedSortedSequence() {
        AbstractMergesort<Integer> test = new Mergesort<>();
        Integer[] testSequence = {987, 76, 76, 56, 34, 24, 23, 2};
        test.sort(testSequence);
        Integer[] correctSequence = {2, 23, 24, 34, 56, 76, 76, 987};

        Assert.assertEquals(correctSequence, testSequence);
    }

    @Test
    public void testEmptySequence() {
        AbstractMergesort<Integer> test = new Mergesort<>();
        Integer[] testSequence = {};
        test.sort(testSequence);
        Integer[] correctSequence = {};

        Assert.assertEquals(correctSequence, testSequence);
    }

    @Test
    public void testSequenceString() {
        AbstractMergesort<String> test = new Mergesort<>();
        String[] testSequence = {"Monkey", "Apple", "Banana", "Worm", "Giraffe"};
        test.sort(testSequence);
        String[] correctSequence = {"Apple", "Banana", "Giraffe", "Monkey", "Worm"};

        Assert.assertEquals(correctSequence, testSequence);
    }
}
