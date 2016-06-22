package com.vwdss.edu.utils;

/**
 * @author amelnikov (Aleksandr Melnikov)
 * @since 22-Jun-2016.
 */
public class ArrayUtils {
    private ArrayUtils() {
    }

    public static void reverse(int[] arr) {
        for(int i = 0; i < arr.length / 2; i++)
        {
            int pos = arr.length - i - 1;
            int temp = arr[i];
            arr[i] = arr[pos];
            arr[pos] = temp;
        }
    }
}
