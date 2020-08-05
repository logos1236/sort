package com.company;

import com.company.sortArray.Bubble;
import com.company.sortArray.Insertion;
import com.company.sortArray.SortArray;

public class Main {

    public static void main(String[] args) {
        TimeExecute timer = new TimeExecute();

        /*Bubble sortBubble = new Bubble(TestArray.getInstance(20000).getArray().clone());
        timer.startTimer();
        sortBubble.sort();
        timer.stopTimer();
        timer.getTimeExecute();*/

        Insertion sortInsertion = new Insertion(TestArray.getInstance(200000).getArray().clone());
        timer.startTimer();
        sortInsertion.sort();
        timer.stopTimer();
        timer.getTimeExecute();

        //TestArray.printArray(sortInsertion.getArray());
    }
}
