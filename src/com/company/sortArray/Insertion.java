package com.company.sortArray;

public class Insertion extends SortArray {
    public Insertion(int[] test_array) {
        super(test_array);
    }

    public void findTruePlace(int insert_val, int end_sort_array_index) {
        for(int i = 0; i <= end_sort_array_index; i++) {
            if (this.getArray()[i] > insert_val) {
                int tmp = this.getArray()[i];
                for(int j = end_sort_array_index-1; j >= i; j--) {
                    this.getArray()[j+1] = this.getArray()[j];
                }
                this.getArray()[i] = insert_val;
                break;
            }
        }
    }

    @Override
    public void sort() {
        for(int i = 1; i < this.getArray().length; i++) {
            if (this.getArray()[i] < this.getArray()[i-1]) {
                findTruePlace(this.getArray()[i], i);
            }
        }
    }

    @Override
    public String getInfo() {
        int n = this.getArray().length;

        return "Best:"+n+"; Average:"+Math.pow(n,2)+"; Worst:"+Math.pow(n,2)+";";
    }
}
