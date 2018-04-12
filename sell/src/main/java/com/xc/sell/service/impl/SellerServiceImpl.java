package com.xc.sell.service.impl;

import com.xc.sell.dataobject.SellerInfo;
import com.xc.sell.repository.SellerInfoRepository;
import com.xc.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * create by 姜 sir
 * 2018/4/12 14:10
 */
@Service
public class SellerServiceImpl  implements SellerService{

    @Autowired
    private SellerInfoRepository repository;
    @Override
    public SellerInfo findSellerInfoByOnpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
