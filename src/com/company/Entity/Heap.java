package com.company.Entity;

import com.company.TestArray;
import com.company.Window.Draw;
import com.company.Window.DrawElement.Circle;
import com.company.Window.DrawElement.Line;
import com.company.Window.Window;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Heap implements Cloneable {
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

    public void heapify(int index) {
        if ((index >= 0) && (index < heap_list_size)) {
            int left_child_index = getLeftСhildIndex(index);
            int right_child_index = getRightСhildIndex(index);
            int max_child_index = index;

            if ((left_child_index < heap_list_size) && (heap_list[left_child_index] > heap_list[max_child_index])) {
                max_child_index = left_child_index;
            }

            if ((right_child_index < heap_list_size) && (heap_list[right_child_index] > heap_list[max_child_index])) {
                max_child_index = right_child_index;
            }

            if (max_child_index != index) {
                int start_val = heap_list[max_child_index];
                heap_list[max_child_index] = heap_list[index];
                heap_list[index] = start_val;

                heapify(max_child_index);
            }
        }
    }

    public void heapShiftAdd(int index) {
        if (index > 0) {
            int parent_index = getParentIndex(index);

            while (heap_list[index] > heap_list[parent_index]) {
                int start_val = heap_list[parent_index];
                heap_list[parent_index] = heap_list[index];
                heap_list[index] = start_val;

                index = parent_index;
                parent_index = getParentIndex(index);
            }
        }
    }

    public void add(int value) {
        if (heap_list_size + 3 >= heap_list.length) {
            heap_list = Arrays.copyOf(heap_list, (int)(heap_list.length*1.5));
        }

        heap_list[heap_list_size] = value;
        heap_list_size++;

        if (heap_list_size > 0) {
            heapShiftAdd(heap_list_size-1);
        }
    }

    public void delete(int index) {
        heap_list[index] = heap_list[heap_list_size-1];
        heap_list_size--;

        heapify(index);
    }

    public int getDepth() {
        return (int)Math.floor(Math.log(heap_list_size)/Math.log(2))+1;
    }

    public void drawNodeRegular(Draw draw, int node_index, int start_x, int start_y, int space_between_circles) {
        if (node_index >= 0) {
            space_between_circles--;

            int offset_x_circle = (int)(Circle.getRadius()*(space_between_circles-0.5));
            int offset_x_line = (int)(Circle.getRadius()*(space_between_circles-0.5));

            draw.addDrawElement(new Circle(start_x, start_y, Color.BLUE, String.valueOf(heap_list[node_index])));

            if (getLeftСhildIndex(node_index) < heap_list_size) {
                draw.addDrawElement(new Line(start_x+Circle.getRadius()/2, start_y+Circle.getRadius(), Color.BLUE, start_x-offset_x_line+Circle.getRadius()/2,start_y + Circle.getRadius()*2));
                drawNodeRegular(draw, getLeftСhildIndex(node_index), start_x-offset_x_circle,start_y + Circle.getRadius()*2, space_between_circles);
            }
            if (getRightСhildIndex(node_index) < heap_list_size) {
                draw.addDrawElement(new Line(start_x+Circle.getRadius()/2, start_y+Circle.getRadius(), Color.BLUE, start_x+offset_x_line+Circle.getRadius()/2,start_y + Circle.getRadius()*2));
                drawNodeRegular(draw, getRightСhildIndex(node_index), start_x+offset_x_circle,start_y + Circle.getRadius()*2, space_between_circles);
            }
        }
    }

    public void print() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Draw draw = new Draw();
                int space_between_circles = getDepth();
                drawNodeRegular(draw, 0, 300, 0, space_between_circles);

                new Window(draw);
            }
        });
    }

    public static Heap heapUnion(Heap h1, Heap h2) {
        while (h2.getSize() >0) {
            h1.add(h2.getValue(0));
            h2.delete(0);
        }

        return h1;
    }

    public boolean isTrueHeap() {
        boolean result = true;

        for (int i=0; i < heap_list_size; i++) {
            int left_child_index = getLeftСhildIndex(i);
            int right_child_index = getRightСhildIndex(i);

            if ((left_child_index < heap_list_size && heap_list[i] < heap_list[left_child_index]) ||
                    (right_child_index < heap_list_size && heap_list[i] < heap_list[right_child_index])
            ) {
                result = false;
                break;
            }
        }

        return result;
    }

    public static void test() {
        /*int array_size = 10;
        int[] unsorted_array = new TestArray(array_size).getArray();
        int[] unsorted_array_1 = new TestArray(array_size).getArray();

        Heap test_heap = new Heap();
        for (int i=0; i < unsorted_array.length; i++) {
            test_heap.add(unsorted_array[i]);
        }
        test_heap.print();

        Heap test_heap_2 = new Heap();
        for (int i=0; i < unsorted_array_1.length; i++) {
            test_heap_2.add(unsorted_array_1[i]);
        }
        test_heap_2.print();

        Heap test_heap_3 = heapUnion(test_heap, test_heap_2);
        test_heap_3.print();*/

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

        /*test_heap.delete(0);
        test_heap.print();

        test_heap.delete(0);
        test_heap.print();

        test_heap.delete(0);
        test_heap.print();*/


    }
}
