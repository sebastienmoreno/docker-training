package com.ippon.jug.pull.Schedduler;

import com.ippon.jug.pull.Counter.QueryCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by jmonsinjon on 13/11/16.
 */
@Component
@EnableScheduling
public class Schedduler {

    private static final int THREAD_POOL_SIZE = 10;

    private ThreadPoolExecutor threadPoolExecutor;
    private QueryCounter queryCounter;
    private SleepClient sleepClient;

    @Autowired
    public Schedduler(QueryCounter queryCounter, SleepClient sleepClient) {
        this.queryCounter = queryCounter;
        this.sleepClient = sleepClient;
        threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }

    @Scheduled(fixedDelay = 100)
    public void fillQueue(){
        while (threadPoolExecutor.getActiveCount() < THREAD_POOL_SIZE){
            threadPoolExecutor.execute(new Worker(queryCounter, sleepClient));
        }
    }

    @PreDestroy
    public void killExecutor() {
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }
}
