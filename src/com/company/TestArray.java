package com.company;

import com.company.Algorithms.Algorithm;
import com.company.Algorithms.Sort.Quick;

import java.util.concurrent.ThreadLocalRandom;

public class TestArray {
    private int[] test_arr;
    private int[] test_arr_sort;
    private static int[] test_arr_static = {32,95,16,82,24,66,35,19,75,54,40,43,93,68};
    private static int[] test_arr_static_sort;
    private static int array_default_size = 10000;

    private void setArray(int array_size) {
        test_arr = new int[array_size];

        for (int i = 0; i < array_size; i++) {
            test_arr[i] = ThreadLocalRandom.current().nextInt(0, 1000000);
        }
    }

    public TestArray(int array_size) {
        setArray(array_size);
    }

    public TestArray() {
        setArray(array_default_size);
    }

    public int[] getArray(boolean is_sort) {
        if (is_sort == false) {
            return test_arr;
        } else {
            if (test_arr_sort == null) {
                Algorithm sortQuick = new Quick(this.test_arr);
                sortQuick.start();
                test_arr_sort = sortQuick.getArray();
            }

            return test_arr_sort;
        }
    }


    public static int[] getTestArray(boolean is_sort) {
        if (is_sort == false) {
            return test_arr_static;
        } else {
            if (test_arr_static_sort == null) {
                Algorithm sortQuick = new Quick(test_arr_static);
                sortQuick.start();
                test_arr_static_sort = sortQuick.getArray();
            }

            return test_arr_static_sort;
        }
    }

    public static void printArray(int[] test_arr) {
        System.out.println("===============");
        for (int i = 0; i < test_arr.length; i++) {
            System.out.println(i+": "+test_arr[i]);
        }
        System.out.println("===============");
    }

    public static void printArray(int[][] test_arr) {
        System.out.println("===============");
        for (int i = 0; i < test_arr.length; i++) {
            if (test_arr[i] != null) {
                for (int j = 0; j < test_arr[i].length; j++) {
                    System.out.print(test_arr[i][j] + " ");
                }
            }
            System.out.println("");
        }
        System.out.println("===============");
    }

    public static void testSpeed(Algorithm obj) {
        TimeExecute timer = new TimeExecute();
        timer.startTimer();
        int result = obj.start();
        timer.stopTimer();

        System.out.println(obj.getClass().getSimpleName()+": "+timer.getTimeExecute()+ "; Result: "+result);
    }
}
