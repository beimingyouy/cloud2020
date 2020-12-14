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


}
