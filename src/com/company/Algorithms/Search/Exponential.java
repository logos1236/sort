package com.company.Algorithms.Search;

import com.company.Algorithms.Algorithm;
import com.company.Algorithms.AlgorithmSearch;
import com.company.TestArray;

public class Exponential  extends AlgorithmSearch {
    public Exponential(int[] test_array, int search_value) {
        super(test_array, search_value);
    }

    @Override
    public int start() {
        int array_length = getArray().length;
        int step = (int)Math.sqrt(array_length);
        int step_position = 1;
        int result = -1;

        boolean stop = false;
        while(!stop) {
            step_position *= 2;
            if (step_position > array_length || getSearchValue() <= getArray()[step_position]) {
                stop = true;
            }
        }

        int[] array_slice = java.util.Arrays.copyOfRange(getArray(), step_position/2, step_position+1);

        Algorithm searchBinary = new Binary(array_slice, getSearchValue());

        return searchBinary.start();
    }
}
