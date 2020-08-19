package com.company.Algorithms.Sort;

import com.company.Algorithms.AlgorithmSort;

import java.util.Arrays;

public class Quick extends AlgorithmSort {
    public Quick(int[] test_array) {
        super(test_array);
    }

    @Override
    public int start() {
        swapElement(0, this.getArray().length-1);

        return 1;
    }

    public void swapElement(int start_index, int end_index) {
        int result_array_size = end_index - start_index;
        if (result_array_size > 1) {
            int index_position = start_index + (int) Math.floor(result_array_size/2);
            int index_val = this.getArray()[index_position];

            int i = start_index;
            int j = end_index;
            while (i < index_position || j > index_position) {
                if (i < index_position) {
                    if (this.getArray()[i] > index_val) {
                        AlgorithmSort.swap(this.getArray(), index_position - 1, i);
                        AlgorithmSort.swap(this.getArray(), index_position, index_position - 1);
                        index_position--;
                    } else {
                        i++;
                    }
                }

                if (j > index_position) {
                    if (this.getArray()[j] < index_val) {
                        AlgorithmSort.swap(this.getArray(), index_position + 1, j);
                        AlgorithmSort.swap(this.getArray(), index_position, index_position + 1);
                        index_position++;
                    } else {
                        j--;
                    }
                }
            }

            swapElement(start_index , index_position);
            swapElement(index_position, end_index);
        }
    }

    @Override
    public String getInfo() {
        int n = this.getArray().length;

        return "Best:"+n*Math.log(n)+"; Average:"+n*Math.log(n)+"; Worst:"+Math.pow(n,2)+";";
    }
}
