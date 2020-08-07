package com.company.sortArray;

public class Select extends SortArray {
    public Select(int[] test_array) {
        super(test_array);
    }

    @Override
    public void sort() {
        boolean proceed = true;
        int smallest_index = 0;
        int smallest_val = 0;
        int start_i = 0;

        while (proceed) {
            smallest_index = start_i;
            smallest_val = this.getArray()[smallest_index];

            for(int i = start_i; i < this.getArray().length; i++) {
                if (this.getArray()[i] < smallest_val) {
                    smallest_index = i;
                    smallest_val = this.getArray()[i];
                }
            }

            SortArray.swap(this.getArray(), start_i, smallest_index);
            start_i++;

            if (start_i == this.getArray().length -1) {
                proceed = false;
            }
        }
    }
}