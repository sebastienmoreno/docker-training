package com.ippon.jug.pull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PullApplication {

    public static void main(String[] args) {
		System.setProperty("http.keepAlive", "false");
        SpringApplication.run(PullApplication.class, args);
    }
}
