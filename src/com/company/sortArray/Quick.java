package com.company.sortArray;

import java.util.Arrays;

public class Quick extends SortArray {
    public Quick(int[] test_array) {
        super(test_array);
    }

    @Override
    public void sort() {
        splitArray(this.getArray());
    }

    public static int[] splitArray(int[] test_array) {
        int result_array_size = test_array.length;
        if (result_array_size > 1) {
            int index_position = (int) Math.floor(result_array_size/2);
            int index_val = test_array[index_position];

            int[] result_array = new int[result_array_size];
            int result_array_fill_size = 0;

            int[] result_array_left_row = new int[result_array_size];
            int result_array_left_fill_size = 0;

            int[] result_array_right_row = new int[result_array_size];
            int result_array_right_fill_size = 0;

            //=== Split array
                for (int i = 0; i<result_array_size; i++) {
                    if (i != index_position) {
                        if (test_array[i] < index_val) {
                            result_array_left_row[result_array_left_fill_size] = test_array[i];
                            result_array_left_fill_size++;
                        } else {
                            result_array_right_row[result_array_right_fill_size] = test_array[i];
                            result_array_right_fill_size++;
                        }
                    }
                }

            //=== Recurse
                int[] result_array_left = splitArray(Arrays.copyOfRange(result_array_left_row, 0, result_array_left_fill_size));
                int[] result_array_right = splitArray(Arrays.copyOfRange(result_array_right_row, 0, result_array_right_fill_size));

            //=== Result merge array
                for (int i = 0; i<result_array_left.length; i++) {
                    result_array[result_array_fill_size] = result_array_left[i];
                    result_array_fill_size++;
                }

                result_array[result_array_fill_size] = index_val;
                result_array_fill_size++;

                for (int i = 0; i<result_array_right.length; i++) {
                    result_array[result_array_fill_size] = result_array_right[i];
                    result_array_fill_size++;
                }

            return result_array;
        } else {
            return test_array;
        }
    }

    @Override
    public String getInfo() {
        int n = this.getArray().length;

        return "Best:"+n*Math.log(n)+"; Average:"+n*Math.log(n)+"; Worst:"+Math.pow(n,2)+";";
    }
}
