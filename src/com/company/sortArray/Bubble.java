package com.company.sortArray;

public class Bubble extends SortArray {
    public Bubble(int[] test_array) {
        super(test_array);
    }

    @Override
    public void sort() {
        boolean proceed = true;

        while (proceed) {
            proceed = false;

            for(int i = 1; i < this.getArray().length; i++) {
                if (this.getArray()[i] < this.getArray()[i-1]) {
                    SortArray.swap(this.getArray(), i, i-1);
                    proceed = true;
                }
            }
        }
    }

    @Override
    public String getInfo() {
        int n = this.getArray().length;

        return "Best:"+n+"; Average:"+Math.pow(n,2)+"; Worst:"+Math.pow(n,2)+";";
    }
}
