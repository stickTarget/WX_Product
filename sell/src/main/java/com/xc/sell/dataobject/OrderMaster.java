package com.xc.sell.dataobject;

import com.xc.sell.enums.OrderStatusEnum;
import com.xc.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Transient;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单
 * create by 姜 sir
 * 2018/4/1 16:36
 */
@Entity
@DynamicUpdate
@Data
public class OrderMaster {

    @Id
    private String orderId;

    /** 买家名称. */
    private String buyerName;

    /** 买家电话. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态默认0新订单. */
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();

    /** 支付状态默认0,未支付. */
    private Integer payStatus= PayStatusEnum.WAIT.getCode();
    /** 创建时间. */
    private Date createTime;

    /** 更新时间. */
    private  Date updateTime;


}
