package com.vwdss.edu.sorting;

/**
 * @author vwdss (Aleksandr Melnikov)
 * @since 11-Mar-2015.
 */
public class MergeSortTest extends BaseSortingAlgorithmTest {
    private final static SortingAlgorithm SORTING_ALGORITHM = new MergeSort();

    @Override
    protected SortingAlgorithm getSortingAlgorithm() {
        return SORTING_ALGORITHM;
    }
}
