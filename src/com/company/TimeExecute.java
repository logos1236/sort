package com.company;

public class TimeExecute {
    private long start_time;
    private long stop_time;

    public TimeExecute() {
        startTimer();
    }

    public void startTimer() {
        start_time = System.currentTimeMillis();
    }

    public void stopTimer() {
        stop_time = System.currentTimeMillis();
    }

    public long getTimeExecute() {
        return stop_time - start_time;
    }
}
