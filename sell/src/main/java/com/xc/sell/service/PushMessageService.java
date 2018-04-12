package com.xc.sell.service;

import com.xc.sell.dto.OrderDTO;

/**
 * 推送消息
 * create by 姜 sir
 * 2018/4/12 21:28
 */
public interface PushMessageService {

    /**
     *
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
