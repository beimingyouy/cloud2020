package com.hl.springcloud.dao;

import com.hl.springcloud.entity.Payment;
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
