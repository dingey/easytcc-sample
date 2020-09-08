package com.d;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EasyTccServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyTccServerApplication.class, args);
    }
}
