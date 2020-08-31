package com.company;

import com.company.Algorithms.Algorithm;
import com.company.Algorithms.Search.Linear;
import com.company.Algorithms.Search.Tree;
import com.company.Entity.BinaryTree;
import com.company.Entity.Heap;

public class Main {

    public static void main(String[] args) {
        int array_size = 100000;
        int[] unsorted_array = new TestArray(array_size).getArray();

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

        Algorithm serachLinear = new Linear(unsorted_array.clone(), 25);
        TestArray.testSpeed(serachLinear);

        Algorithm searchTree = new Tree(unsorted_array.clone(), 25);
        TestArray.testSpeed(searchTree);

        //Heap.test();
        //BinaryTree.test();
    }
}
