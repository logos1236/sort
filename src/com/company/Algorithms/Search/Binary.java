package com.company.Algorithms.Search;

import com.company.Algorithms.Algorithm;
import com.company.Algorithms.AlgorithmSearch;
import com.company.Algorithms.Sort.Quick;
import com.company.TestArray;

public class Binary extends AlgorithmSearch {
    public Binary(int[] test_array, int search_value) {
        super(test_array, search_value);
    }

    @Override
    public int start() {
        return (searchRecurse(0, getArray().length-1) >= 0) ? 1 : -1;
    }

    private int searchRecurse(int start, int end) {
        int center = (int)(Math.floor((end-start)/2))+start;

        if (center == start || center == end) {
            if (getArray()[start] == getSearchValue()) {
                return start;
            } else if (getArray()[end] == getSearchValue()) {
                return end;
            } else {
                return -1;
            }
        }

        if (getArray()[center] == getSearchValue()) {
            return center;
        } else if (getSearchValue() < getArray()[center]) {
            return searchRecurse(start, center);
        } else {
            return searchRecurse(center, end);
        }
    }

    @Override
    public String getInfo() {
        return null;
    }
}
