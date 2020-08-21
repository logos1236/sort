package com.company.Algorithms.Sort;

import com.company.Algorithms.AlgorithmSort;

public class HeapSort extends AlgorithmSort {
    public HeapSort(int[] test_array) {
        super(test_array);
    }

    @Override
    public int start() {
        com.company.Entity.Heap test_heap = new com.company.Entity.Heap();
        int[] result = new int[this.getArray().length];

        for (int i=0; i < this.getArray().length; i++) {
            test_heap.add(this.getArray()[i]);
        }

        int i=this.getArray().length-1;
        while (test_heap.getSize() > 0) {
            result[i] = test_heap.getValue(0);
            test_heap.delete(0);
            i--;
        }

        this.setArray(result);

        return 1;
    }

    @Override
    public String getInfo() {
        return null;
    }
}
