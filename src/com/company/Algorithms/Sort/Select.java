package com.company.Algorithms.Sort;

import com.company.Algorithms.AlgorithmSort;

public class Select extends AlgorithmSort {
    public Select(int[] test_array) {
        super(test_array);
    }

    @Override
    public int start() {
        boolean proceed = true;
        int smallest_index = 0;
        int smallest_val = 0;
        int start_i = 0;

        while (proceed) {
            smallest_index = start_i;
            smallest_val = this.getArray()[smallest_index];

            for(int i = start_i; i < this.getArray().length; i++) {
                if (this.getArray()[i] < smallest_val) {
                    smallest_index = i;
                    smallest_val = this.getArray()[i];
                }
            }

            AlgorithmSort.swap(this.getArray(), start_i, smallest_index);
            start_i++;

            if (start_i == this.getArray().length -1) {
                proceed = false;
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
