package com.company;

import com.company.Algorithms.Algorithm;

import java.util.concurrent.ThreadLocalRandom;

public class TestArray {
    private int[] test_arr;
    private static int[] test_arr_static = {32,95,16,82,24,66,35,19,75,54,40,43,93,68};
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

    public int[] getArray() {
        return test_arr;
    }

    public static int[] getTestArray() {
        return test_arr_static;
    }

    public static void printArray(int[] test_arr) {
        System.out.println("===============");
        for (int i = 0; i < test_arr.length; i++) {
            System.out.println(test_arr[i]);
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
