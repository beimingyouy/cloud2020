package com.hl.springcloud.controller;

import com.hl.springcloud.common.CommonResult;
import com.hl.springcloud.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: zy
 * @Date: 2020/12/4 16:55
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {


    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        return new CommonResult(200, "操作成功");
    }

    @GetMapping("/{id}")
    public CommonResult<User> getUser(@PathVariable Long id) {
        return new CommonResult(200, "操作成功");
    }


}
