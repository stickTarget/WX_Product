package com.xc.sell.service;

import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.xc.sell.dto.OrderDTO;

/**
 * create by 姜 sir
 * 2018/4/10 10:55
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundRequest refund(OrderDTO orderDTO);
}
