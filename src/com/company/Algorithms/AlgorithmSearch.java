package com.company.Algorithms;

public abstract class AlgorithmSearch extends Algorithm {
    private int search_value;

    public AlgorithmSearch(int[] test_array, int search_value) {
        super(test_array);

        this.search_value = search_value;
    }

    public int getSearchValue() {
        return search_value;
    }
}
