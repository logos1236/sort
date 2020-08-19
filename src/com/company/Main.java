package com.company;

import com.company.Algorithms.Algorithm;
import com.company.Algorithms.Sort.*;
import com.company.Supp.Heap;

public class Main {

    public static void main(String[] args) {
        int array_size = 10000;
        int[] unsorted_array = TestArray.getInstance(array_size).getArray();

        Algorithm sortBubble = new Bubble(unsorted_array.clone());
        TestArray.testSpeed(sortBubble);

        Algorithm sortInsertion = new Insertion(unsorted_array.clone());
        TestArray.testSpeed(sortInsertion);

        Algorithm sortSelect = new Select(unsorted_array.clone());
        TestArray.testSpeed(sortSelect);

        Algorithm sortMerge = new Merge(unsorted_array.clone());
        TestArray.testSpeed(sortMerge);

        Algorithm sortQuick = new Quick(unsorted_array.clone());
        TestArray.testSpeed(sortQuick);

        Algorithm sortShell = new Shell(unsorted_array.clone());
        TestArray.testSpeed(sortShell);

        Algorithm sortHeap = new HeapSort(unsorted_array.clone());
        TestArray.testSpeed(sortHeap);

        /*Algorithm serachLinear = new Linear(unsorted_array.clone(), 25);
        TestArray.testSpeed(serachLinear);*/
    }
}
