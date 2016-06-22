package com.vwdss.edu.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author vwdss (Aleksandr Melnikov)
 * @since 11-Mar-2015.
 */


public abstract class BaseSortingAlgorithmTest {
    protected abstract SortingAlgorithm getSortingAlgorithm();

    private <T extends Comparable<T>> void sortAndValidate(T[] array) {
        T[] sorted = Arrays.copyOf(array, array.length);
        Arrays.sort(sorted);

        T[] test = getSortingAlgorithm().sort(array);
        Assert.assertArrayEquals("Sorting failed", sorted, test);
    }

    @Test
    public void testEvenSizedArray() throws Exception {
        sortAndValidate(new Integer[]{6, 8, 1, 3, 0, 9, 2, 4, 7, 5});
    }

    @Test
    public void testOddSizedArray() throws Exception {
        sortAndValidate(new Integer[]{6, 8, 1, 0, 9, 2, 4, 7, 5});
    }

    @Test
    public void testAlreadySortedArray() throws Exception {
        sortAndValidate(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    @Test
    public void testReverseSortedArray() throws Exception {
        sortAndValidate(new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});
    }

    @Test
    public void testEmptyArray() throws Exception {
        sortAndValidate(new Integer[]{});
    }

    @Test
    public void testSingleValueArray() throws Exception {
        sortAndValidate(new Integer[]{42});
    }

    @Test
    public void testSameValueArray() throws Exception {
        sortAndValidate(new Integer[]{42, 42, 42, 42, 42, 42, 42, 42, 42, 42});
    }

    // TODO Add stable sorting tests
}
