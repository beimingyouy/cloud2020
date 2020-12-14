package com.hl.springcloud.hystrix.service;

import com.hl.springcloud.core.common.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zy
 * @Date: 2020/12/14 17:17
 */
@Service
@Slf4j
public class UserHystrixService {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @HystrixCommand(fallbackMethod = "getDefaultUser")
    public CommonResult getUser(Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", CommonResult.class, id);
    }

    public CommonResult getDefaultUser(Long id) {

        log.info("fallbackMethod, id ={}", id);
        return new CommonResult(200, "getDefaultUser");
    }
}
