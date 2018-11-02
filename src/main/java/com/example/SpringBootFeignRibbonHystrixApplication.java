package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 在springboot里使用feign ribbon hystrix组合
 */
@SpringBootApplication
@EnableFeignClients
public class SpringBootFeignRibbonHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootFeignRibbonHystrixApplication.class, args);
    }
}
