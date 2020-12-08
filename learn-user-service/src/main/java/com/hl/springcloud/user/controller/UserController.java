package com.hl.springcloud.user.controller;

import com.hl.springcloud.user.common.CommonResult;
import com.hl.springcloud.user.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zy
 * @Date: 2020/12/4 16:55
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {


    @PostMapping("/create")
    public CommonResult create() {
        log.info("进入create");
        return new CommonResult(200, "操作成功");
    }

    @GetMapping("/{id}")
    public CommonResult<User> getUser(@PathVariable Long id) {
        return new CommonResult(200, "操作成功");
    }


}