package com.hl.springcloud.user.controller;

import com.hl.springcloud.user.entity.CommonResult;
import com.hl.springcloud.user.service.PaymentService;
import com.hl.springcloud.user.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zy
 * @Date: 2020/11/12 22:52
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/save")
    public CommonResult save(Payment payment) {
        int result = paymentService.save(payment);

        if (result > 0) {
            return new CommonResult(200, "插入成功");
        } else {
            return new CommonResult(501, "插入失败", null);

        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);

        if (null != result) {
            return new CommonResult(200, "查询成功", result);
        } else {
            return new CommonResult(500, "没有对应记录,id=" + id, null);

        }
    }
}
