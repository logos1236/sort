package com.company;

import com.company.sortArray.*;

public class Main {

    public static void main(String[] args) {
        TimeExecute timer = new TimeExecute();
        int array_size = 2000;
        int[] unsorted_array = TestArray.getInstance(array_size).getArray();

        Bubble sortBubble = new Bubble(unsorted_array.clone());
        TestArray.testSpeedSort(sortBubble);

        Insertion sortInsertion = new Insertion(unsorted_array.clone());
        TestArray.testSpeedSort(sortInsertion);

        Select sortSelect = new Select(unsorted_array.clone());
        TestArray.testSpeedSort(sortSelect);

        Quick sortQuick = new Quick(unsorted_array.clone());
        TestArray.testSpeedSort(sortQuick);
    }
}
