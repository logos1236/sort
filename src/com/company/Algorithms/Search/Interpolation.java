package com.company.Algorithms.Search;

import com.company.Algorithms.AlgorithmSearch;

public class Interpolation extends AlgorithmSearch {
    public Interpolation(int[] test_array, int search_value) {
        super(test_array, search_value);
    }

    @Override
    public int start() {
        return (searchRecurse(0, getArray().length-1) > 0) ? 1 : -1;
    }

    private int searchRecurse(int start, int end) {
        int center = start + ((getSearchValue() - getArray()[start])*(end - start))/(getArray()[end] - getArray()[start]);

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
