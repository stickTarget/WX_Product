package com.xc.sell.service;

import com.xc.sell.dataobject.SellerInfo;
import org.springframework.stereotype.Service;

/**
 * 卖家端
 * create by 姜 sir
 * 2018/4/12 14:09
 */
public interface SellerService {
    /**
     * 通过openid查询卖家端的信息
      * @return
     */
    SellerInfo findSellerInfoByOnpenid(String openid);
}
