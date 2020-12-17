package com.hl.springcloud.hystrix.controller;

import com.hl.springcloud.core.common.CommonResult;
import com.hl.springcloud.hystrix.service.UserHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zy
 * @Date: 2020/12/14 16:50
 */
@RestController
@RequestMapping("/hystrix/user")
public class UserHystrixController {

    @Autowired
    private UserHystrixService userHystrixService;

    @GetMapping("/testFallback/{id}")
    public CommonResult testFallback(@PathVariable Long id) {
        return userHystrixService.getUser(id);
    }


    @GetMapping("/testException/{id}")
    public CommonResult testException(@PathVariable Long id) {
        return userHystrixService.getUserException(id);
    }


    @GetMapping("/testCache/{id}")
    public CommonResult testCache(@PathVariable Long id) {
        userHystrixService.getUserCache(id);
        userHystrixService.getUserCache(id);
        userHystrixService.getUserCache(id);
        return new CommonResult(200, "testCache");
    }

    @GetMapping("/testRemoveCache/{id}")
    public CommonResult testRemoveCache(@PathVariable Long id) {
        userHystrixService.getUserCache(id);
        userHystrixService.removeCache(id);
        userHystrixService.getUserCache(id);
        return new CommonResult(200, "testRemoveCache");
    }


}
