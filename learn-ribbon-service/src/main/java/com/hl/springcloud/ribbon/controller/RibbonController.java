package com.hl.springcloud.ribbon.controller;

import com.hl.springcloud.ribbon.common.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zy
 * @Date: 2020/12/7 17:21
 */
@RestController
@RequestMapping("/user")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @PostMapping("/create")
    public CommonResult create() {
        CommonResult result = restTemplate.postForObject(userServiceUrl + "/user/create", "", CommonResult.class);
        return result;
    }


}
