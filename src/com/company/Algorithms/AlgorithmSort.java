package com.company.Algorithms;

public abstract class AlgorithmSort extends Algorithm {
    public AlgorithmSort(int[] test_array) {
        super(test_array);
    }

    public static void swap(int[] test_array, int start_index, int end_index) {
        int start_val = test_array[start_index];
        test_array[start_index] = test_array[end_index];
        test_array[end_index] = start_val;
    }
}
