package com.hl.springcloud.user.dao;

import com.hl.springcloud.user.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: zy
 * @Date: 2020/11/12 22:36
 */
@Mapper
public interface PaymentDao {

    int save(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
