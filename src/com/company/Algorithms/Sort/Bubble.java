package com.company.Algorithms.Sort;

import com.company.Algorithms.AlgorithmSort;

public class Bubble extends AlgorithmSort {
    public Bubble(int[] test_array) {
        super(test_array);
    }

    @Override
    public int start() {
        boolean proceed = true;

        while (proceed) {
            proceed = false;

            for(int i = 1; i < this.getArray().length; i++) {
                if (this.getArray()[i] < this.getArray()[i-1]) {
                    AlgorithmSort.swap(this.getArray(), i, i-1);
                    proceed = true;
                }
            }
        }

        return 1;
    }

    @Override
    public String getInfo() {
        int n = this.getArray().length;

        return "Best:"+n+"; Average:"+Math.pow(n,2)+"; Worst:"+Math.pow(n,2)+";";
    }
}
