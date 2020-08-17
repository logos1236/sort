package com.company.Supp;

import java.util.Arrays;

public class Heap {
    private int[] heap_list = new int[10];
    private int heap_list_size = 0;

    public int getSize() {
        return heap_list_size;
    }

    public int getValue(int index) {
        return heap_list[index];
    }


    public static int getLeftСhildIndex(int index) {
        return index*2+1;
    }

    public static int getRightСhildIndex(int index) {
        return index*2+2;
    }

    public static int getParentIndex(int index) {
        return (int)Math.floor(((index-1)/2));
    }

    public void heapfy(int index) {
        int parent_index = getParentIndex(index);
        int left_child_index = getLeftСhildIndex(index);
        int right_child_index = getRightСhildIndex(index);

        if ((index < heap_list_size) && (heap_list[parent_index] < heap_list[index])) {
            int start_val = heap_list[parent_index];
            heap_list[parent_index] = heap_list[index];
            heap_list[index] = start_val;

            heapfy(parent_index);
        }

        /*if ((left_child_index < heap_list_size) && (heap_list[parent_index] < heap_list[left_child_index])) {
            heapfy(left_child_index);
        }
        if ((right_child_index < heap_list_size) && (heap_list[parent_index] < heap_list[right_child_index])) {
            heapfy(right_child_index);
        }*/
    }

    public void add(int value) {
        if (heap_list_size + 3 >= heap_list.length) {
            heap_list = Arrays.copyOf(heap_list, heap_list.length*2);
        }

        heap_list[heap_list_size] = value;
        heap_list_size++;

        if (heap_list_size > 0) {
            heapfy(heap_list_size-1);
        }
    }

    public void delete(int index) {
        for (int i = index; i < (heap_list_size-1); i++) {
            heap_list[i] = heap_list[i+1];
        }

        heap_list_size--;

        //=== Last leaf

    }

    public void print() {
        int last_pow = 1;

        System.out.println("=================");
        for (int i=0; i < heap_list_size; i++) {
            if (i == (Math.pow(2, last_pow)-1)) {
                System.out.println("");
                last_pow++;
                System.out.print(heap_list[i]+" ");
            } else {
                System.out.print(heap_list[i]+" ");
                if (i % 2 == 0) {
                    System.out.print(" ");
                }
            }
        }
        System.out.println("");
        System.out.println("=================");
    }
}
