package com.company;

import com.company.Algorithms.Algorithm;
import com.company.Algorithms.Sort.*;
import com.company.Supp.Heap;

public class Main {

    public static void main(String[] args) {
        int array_size = 10000;
        int[] unsorted_array = TestArray.getInstance(array_size).getArray();

        /*Algorithm sortBubble = new Bubble(unsorted_array.clone());
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
        TestArray.testSpeed(sortHeap);*/

        /*Algorithm serachLinear = new Linear(unsorted_array.clone(), 25);
        TestArray.testSpeed(serachLinear);*/

        //System.out.println(Heap.getParentIndex(2));

        Heap test_heap = new Heap();

        test_heap.add(6);
        test_heap.add(15);
        test_heap.add(11);
        test_heap.add(6);
        test_heap.add(9);
        test_heap.add(20);
        test_heap.add(7);
        test_heap.add(8);
        test_heap.add(6);
        test_heap.add(1);
        test_heap.add(3);
        test_heap.add(5);
        test_heap.add(17);

        test_heap.print();

        test_heap.delete(0);
        test_heap.print();

        test_heap.delete(0);
        test_heap.print();

        test_heap.delete(0);
        test_heap.print();
    }
}
