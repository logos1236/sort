package com.company.sortArray;

import com.company.TestArray;

public class Merge extends SortArray  {
    public Merge(int[] test_array) {
        super(test_array);
    }

    @Override
    public void sort() {
        int[][][] result = new int[(int)Math.ceil(this.getArray().length/2)][][];
        result[0] = new int[this.getArray().length][];
        for(int i=0; i<this.getArray().length; i++) {
            result[0][i] = new int[1];
            result[0][i][0] = this.getArray()[i];
        }

        int j = 1;
        int array_size = 0;
        int subarray_i = 0;
        int subarray_size = 0;

        while (result[j-1].length != 1) {
            array_size = (result[j-1].length%2)>0 ? (result[j-1].length+1)/2 : result[j-1].length/2;
            subarray_size = (int)Math.pow(2,j);
            result[j] = new int[array_size][];
            subarray_i = 0;

            for(int i=0; i<result[j-1].length; i=i+2) {
                result[j][subarray_i] = new int[subarray_size];

                if ((i+1 < result[j-1].length) && (result[j-1][i+1] != null)) {
                    result[j][subarray_i] = mergeArray(result[j-1][i],result[j-1][i+1]);
                } else {
                    result[j][subarray_i] = result[j-1][i];
                }
                subarray_i++;
            }

            j++;
        }
    }

    public static int[] processingArray() {
        return null;
    }

    public static int[] mergeArray(int[] array_one, int[] array_two) {
        int array_one_i = 0;
        int array_two_i = 0;

        int result_array_size = array_one.length+array_two.length;
        int[] result_array = new int[result_array_size];

        for (int i=0; i < result_array_size; i++) {
            if (array_one_i >= array_one.length) {
                result_array[i] = array_two[array_two_i];
                array_two_i++;

                continue;
            }
            if (array_two_i >= array_two.length) {
                result_array[i] = array_one[array_one_i];
                array_one_i++;

                continue;
            }

            if (array_one[array_one_i] < array_two[array_two_i]) {
                result_array[i] = array_one[array_one_i];
                array_one_i++;
            } else {
                result_array[i] = array_two[array_two_i];
                array_two_i++;
            }
        }

        return result_array;
    }

    @Override
    public String getInfo() {
        int n = this.getArray().length;

        return "Best:"+n*Math.log(n)+"; Average:"+n*Math.log(n)+"; Worst:"+n*Math.log(n)+";";
    }
}
