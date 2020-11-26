package com.hl.springcloud.service;

import com.hl.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: zy
 * @Date: 2020/11/12 22:46
 */
public interface PaymentService {

    int save(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
