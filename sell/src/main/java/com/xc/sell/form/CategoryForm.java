package com.xc.sell.form;

import lombok.Data;

/**
 * create by 姜 sir
 * 2018/4/12 10:46
 */
@Data
public class CategoryForm {
    /** 类目id*/
    private Integer categoryId;

    /** 类目名字*/
    private String categoryName;

    /** 类目编号*/
    private Integer categoryType;
}
