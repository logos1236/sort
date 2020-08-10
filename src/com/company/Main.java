package com.company;

import com.company.sortArray.*;

public class Main {

    public static void main(String[] args) {
        int array_size = 100;
        int[] unsorted_array = TestArray.getInstance(array_size).getArray();

        Bubble sortBubble = new Bubble(unsorted_array.clone());
        TestArray.testSpeedSort(sortBubble);

        Insertion sortInsertion = new Insertion(unsorted_array.clone());
        TestArray.testSpeedSort(sortInsertion);

        Select sortSelect = new Select(unsorted_array.clone());
        TestArray.testSpeedSort(sortSelect);

        Merge sortMerge = new Merge(unsorted_array.clone());
        TestArray.testSpeedSort(sortMerge);

        Quick sortQuick = new Quick(unsorted_array.clone());
        TestArray.testSpeedSort(sortQuick);
    }
}
