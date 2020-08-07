package com.company;

import com.company.sortArray.SortArray;

import java.util.concurrent.ThreadLocalRandom;

public class TestArray {
    private static TestArray instance;
    private int[] test_arr;
    public static int[] test_arr_static = {1,22,4,38,147,6,25,5,9,10};
    private static int test_array_size = 10000;

    private void setArray(int array_size) {
        test_arr = new int[array_size];

        for (int i = 0; i < array_size; i++) {
            test_arr[i] = ThreadLocalRandom.current().nextInt(0, 10000);
        }
    }

    private TestArray(int test_array_size) {
        setArray(test_array_size);
    }

    public static TestArray getInstance(int test_array_size) {
        if (instance == null) {
            instance = new TestArray(test_array_size);
        }

        return instance;
    }

    public static TestArray getInstance() {
        if (instance == null) {
            instance = new TestArray(test_array_size);
        }

        return instance;
    }

    public int[] getArray() {
        return test_arr;
    }

    public static void printArray(int[] test_arr) {
        System.out.println("===============");
        for (int i = 0; i < test_arr.length; i++) {
            System.out.println(test_arr[i]);
        }
        System.out.println("===============");
    }

    public static void testSpeedSort(SortArray obj) {
        TimeExecute timer = new TimeExecute();
        timer.startTimer();
        obj.sort();
        timer.stopTimer();

        System.out.println(obj.getClass().getSimpleName()+": "+timer.getTimeExecute());
    }
}