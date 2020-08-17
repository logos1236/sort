package com.company.Algorithms;

public abstract class Algorithm implements AlgorithmInterface {
    private int[] test_array;

    public Algorithm(int[] test_array) {
        this.test_array = test_array;
    }

    @Override
    public int start() {
        return 0;
    }

    @Override
    public String getInfo() {
        return null;
    }

    public int[] getArray() {
        return test_array;
    }

    public void setArray(int[] new_array) {
        test_array = new_array;
    }
}
