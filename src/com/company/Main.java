package com.company;

import com.company.Algorithms.Algorithm;
import com.company.Algorithms.Search.*;
import com.company.Entity.BinaryTree;
import com.company.Entity.Heap;

public class Main {

    public static void main(String[] args) {
        int array_size = 50000000;
        TestArray test_array = new TestArray(array_size);

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

        //Heap.testHeap();

        /*Algorithm searchTree = new Tree(unsorted_array.clone(), 25);
        TestArray.testSpeed(searchTree);*/

        Algorithm serachLinear = new Linear(test_array.getArray(false).clone(), 25);
        TestArray.testSpeed(serachLinear);

        Algorithm searchBinary = new Binary(test_array.getArray(true).clone(), 25);
        TestArray.testSpeed(searchBinary);

        Algorithm searchJump = new Jump(test_array.getArray(true).clone(), 25);
        TestArray.testSpeed(searchJump);

        Algorithm searchInterpolation = new Interpolation(test_array.getArray(true).clone(), 25);
        TestArray.testSpeed(searchInterpolation);

        Algorithm searchExponential = new Exponential(test_array.getArray(true).clone(), 25);
        TestArray.testSpeed(searchExponential);

        //Heap.test();
        //BinaryTree.test();
    }
}
