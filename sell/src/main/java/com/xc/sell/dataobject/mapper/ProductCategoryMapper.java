package com.xc.sell.dataobject.mapper;

import com.xc.sell.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * create by 姜 sir
 * 2018/4/13 21:05
 */

public interface ProductCategoryMapper {
    /*通过mapper写入*/
    @Insert("insert into product category(category_name,category_type) values(#{categoryName,jdbcType=VARCHAR},#{category_type,jdbcType=INTEGER})")
    int insertByMap(Map<String,Object> map);

    /*通过对象写入*/
    @Insert("insert into product category(category_name,category_type) values(#{categoryName,jdbcType=VARCHAR},#{categoryType,jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory);

    @Select("select * from product_category where category_type = #{categoryType}")
    @Results({
            @Result(column = "category_type",property = "categoryType"),
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_id",property = "categoryId")
    })
    ProductCategory findByCategoryType(Integer categoryType);

    @Select("select * from product_category where category_type = #{categoryName}")
    @Results({
            @Result(column = "category_type",property = "categoryType"),
            @Result(column = "category_name",property = "categoryName"),
            @Result(column = "category_id",property = "categoryId")
    })
    List<ProductCategory> findByCategoryName(String categoryName);

    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByCategoryType(@Param("categoryType") Integer categoryType,
                             @Param("categoryName") String categoryName);

    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType}")
    int updateByObject(ProductCategory productCategory);

    @Delete("delete from product_category where category_type = #{categoryType}")
    int deleteByCategoryType(Integer categoryType);

    ProductCategory selectByCategoryType(Integer categoryType);
}
