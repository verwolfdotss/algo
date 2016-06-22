package com.vwdss.edu.sorting;

import java.util.Arrays;

/**
 * Merge sort algorithm implementation.
 * <p>
 * Complexity:
 * best O(n log n), worst O(n log n), avg O(n log n)
 * <p>
 * Memory:
 * O(n)
 *
 * @author vwdss (Aleksandr Melnikov)
 * @since 11-Mar-2015.
 */
public class MergeSort implements SortingAlgorithm {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] data) {
        T[] array = Arrays.copyOf(data, data.length);
        sort(array, 0, array.length - 1);
        return array;
    }

    private static <T extends Comparable<T>> void sort(T[] arr, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            sort(arr, p, q);
            sort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] arr, int p, int q, int r) {
        T[] t1 = Arrays.copyOfRange(arr, p, q + 1);
        T[] t2 = Arrays.copyOfRange(arr, q + 1, r + 1);

        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if ((i < t1.length) && ((j == t2.length) || (t1[i].compareTo(t2[j]) <= 0))) {
                arr[k] = t1[i];
                i++;
            } else {
                arr[k] = t2[j];
                j++;
            }
        }
    }
}
