package com.hl.springcloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @Author: zy
 * @Date: 2020/12/14 16:49
 */
@SpringCloudApplication
public class HystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }

}
