package com.xc.sell.service;

import com.xc.sell.dto.OrderDTO;

/**
 * 买家
 * create by 姜 sir
 * 2018/4/10 7:18
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
