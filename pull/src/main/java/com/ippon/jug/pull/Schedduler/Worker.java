package com.ippon.jug.pull.Schedduler;

import com.ippon.jug.pull.Counter.QueryCounter;

/**
 * Created by jmonsinjon on 13/11/16.
 */
public class Worker implements Runnable {

    private QueryCounter queryCounter;
    private SleepClient sleepClient;

    public Worker(QueryCounter queryCounter, SleepClient sleepClient) {
        this.queryCounter = queryCounter;
        this.sleepClient = sleepClient;
    }

    @Override
    public void run() {
        // Do http call here
        String s = sleepClient.getRequest();
        if (s != null) {
            queryCounter.addQuery();
        }
    }
}
