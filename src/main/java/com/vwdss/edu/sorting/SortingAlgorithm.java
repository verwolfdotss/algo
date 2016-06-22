package com.vwdss.edu.sorting;

/**
 * @author vwdss (Aleksandr Melnikov)
 * @since 11-Mar-2015.
 */
public interface SortingAlgorithm {
    public <T extends Comparable<T>> T[] sort(T[] data);
}
