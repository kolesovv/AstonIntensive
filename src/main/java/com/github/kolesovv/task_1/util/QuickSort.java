package com.github.kolesovv.task_1.util;

import java.util.Comparator;

public class QuickSort {

    private QuickSort() {
    }

    public static <E> void sort(E[] array, int low, int high, Comparator<E> comparator) {
        if (array.length == 0 || low >= high) return;

        int middle = low + (high - low) / 2;
        E border = array[middle];

        int i = low;
        int j = high;
        while (i <= j) {
            while (comparator.compare(array[i], border) < 0) i++;
            while (comparator.compare(array[j], border) > 0) j--;
            if (i <= j) {
                E swap = array[i];
                array[i] = array[j];
                array[j] = swap;
                i++;
                j--;
            }
        }

        if (low < j) sort(array, low, j, comparator);
        if (high > i) sort(array, i, high, comparator);
    }
}
