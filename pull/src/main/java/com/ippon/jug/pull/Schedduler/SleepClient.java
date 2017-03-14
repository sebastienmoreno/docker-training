package com.ippon.jug.pull.Schedduler;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "sleep", url = "http://sleep:8080")
interface SleepClient {

    @RequestMapping(value = "/request", method = RequestMethod.GET)
    String getRequest();
}