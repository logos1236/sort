package com.company.Algorithms.Sort;

import com.company.Algorithms.AlgorithmSort;

public class Shell extends AlgorithmSort {
    public Shell(int[] test_array) {
        super(test_array);
    }

    @Override
    public int start() {
        int h = this.getArray().length;

        while (h != 1) {
            h = (int)Math.floor(h/2);

            for (int i = 0; i < h; i++) {
                for (int j = i+h; j < this.getArray().length; j = j+h)
                    if (this.getArray()[j] < this.getArray()[j - h]) {
                        boolean proceed = true;
                        int k = j;
                        while (proceed) {
                            if (this.getArray()[k] < this.getArray()[k-h]) {
                                swap(this.getArray(), k, k - h);
                                k = k - h;

                                if (k - h < 0) {
                                    proceed = false;
                                }
                            } else {
                                proceed = false;
                            }
                        }
                    }
            }
        }

        return 1;
    }

    @Override
    public String getInfo() {
        int n = this.getArray().length;

        return "Best:"+n+"; Average:"+Math.pow(n,2)+"; Worst:"+Math.pow(n,2)+";";
    }
}
