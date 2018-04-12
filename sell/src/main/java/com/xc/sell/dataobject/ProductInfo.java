package com.xc.sell.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xc.sell.enums.ProductStatusEnum;
import com.xc.sell.form.ProductForm;
import com.xc.sell.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 * create by 姜 sir
 * 2018/3/30 22:08
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    /** 商品id*/
    @Id
    private String productId;

    /** 商品名称*/
    private String productName;

    /** 商品价格*/
    private BigDecimal productPrice;

    /** 商品库存*/
    private Integer productStock;

    /** 商品描述*/
    private String productDescription;

    /** 商品图片*/
    private String productIcon;

    /** 商品状态 0.上架 1.下架*/
    private Integer productStatus= ProductStatusEnum.UP.getCode();

    /** 商品类型*/
    private Integer categoryType;

    /** 创建时间. */
    private Date createTime;

    /** 更新时间. */
    private  Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus , ProductStatusEnum.class);
    }

}
