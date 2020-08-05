package com.company.sortArray;

public abstract class SortArray implements SortArrayInterface {
    private int[] test_array;

    public SortArray(int[] test_array) {
        this.test_array = test_array;
    }

    public static void swap(int[] test_array, int start_index, int end_index) {
        int start_val = test_array[start_index];
        test_array[start_index] = test_array[end_index];
        test_array[end_index] = start_val;
    }

    public int[] getArray() {
        return test_array;
    }
}
