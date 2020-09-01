package com.company.Algorithms.Search;

import com.company.Algorithms.Algorithm;
import com.company.Algorithms.AlgorithmSearch;
import com.company.Algorithms.Sort.Quick;

public class Jump extends AlgorithmSearch {
    public Jump(int[] test_array, int search_value) {
        super(test_array, search_value);
    }

    @Override
    public int start() {
        int array_length = getArray().length;
        int step = (int)Math.sqrt(array_length);
        int step_position = 0;
        int result = -1;

        boolean stop = false;
        while(!stop) {
            step_position += step;
            if (getSearchValue() <= getArray()[step_position]) {
                stop = true;
            }
        }

        for (int i = step_position - step; i <= step_position; i++) {
            if (getSearchValue() == getArray()[i]) {
                result = 1;
            }
        }

        return result;
    }

    @Override
    public String getInfo() {
        return null;
    }
}
