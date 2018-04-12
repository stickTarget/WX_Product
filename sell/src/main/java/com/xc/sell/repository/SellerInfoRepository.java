package com.xc.sell.repository;

import com.xc.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * create by 姜 sir
 * 2018/4/12 13:12
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String>{
    SellerInfo findByOpenid(String openid);
}
