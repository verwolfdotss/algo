package com.vwdss.edu.sorting;

import java.util.Arrays;

/**
 * Quick sort algorithm implementation.
 * <p>
 * Complexity:
 * best O(n log n), worst O(n<sup>2</sup>), avg O(n log n)
 * <p>
 * Memory:
 * avg O(log n), worst O(n)
 *
 * @author vwdss (Aleksandr Melnikov)
 * @since 11-Mar-2015.
 */
public class QuickSort implements SortingAlgorithm {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] data) {
        T[] array = Arrays.copyOf(data, data.length);
        sort(array, 0, array.length - 1);
        return array;
    }

    private static <T extends Comparable<T>> void sort(T[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            sort(arr, p, q - 1);
            sort(arr, q + 1, r);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int p, int r) {
        T x = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j].compareTo(x) <= 0) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    private static <T extends Comparable<T>> void swap(T[] arr, int a, int b) {
        if (a == b) {
            return;
        }
        T t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;

    }
}
