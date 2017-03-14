package com.ippon.jug.sleep;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class SleepController {


    private static final int SLEEP_MILLIS = 100;

    @RequestMapping(value = "/request")
    public String getRequest() throws InterruptedException, UnknownHostException {
        this.doSleep();
        return "Hello I'm " + InetAddress.getLocalHost().getHostName();
    }

    private synchronized void doSleep() throws InterruptedException {
        Thread.sleep(SLEEP_MILLIS);
    }
}
