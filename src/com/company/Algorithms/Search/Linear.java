package com.company.Algorithms.Search;

import com.company.Algorithms.AlgorithmSearch;

public class Linear extends AlgorithmSearch {
    public Linear(int[] test_array, int search_value) {
        super(test_array, search_value);
    }

    @Override
    public int start() {
        for (int i=0; i<this.getArray().length; i++) {
            if (this.getArray()[i] == this.getSearchValue()) {
                return 1;
            }
        }

        return -1;
    }

    @Override
    public String getInfo() {
        return null;
    }
}
