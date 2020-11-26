package com.hl.cloud.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: zy
 * @Date: 2020/11/12 15:22
 */
@SpringBootApplication(scanBasePackages = {"com.hl"})
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }
}
