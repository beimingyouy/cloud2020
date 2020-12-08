package com.hl.springcloud.user.service.impl;

import com.hl.springcloud.user.dao.PaymentDao;
import com.hl.springcloud.user.service.PaymentService;
import com.hl.springcloud.user.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zy
 * @Date: 2020/11/12 22:47
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;


    @Override
    public int save(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
