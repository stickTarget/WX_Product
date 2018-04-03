package com.xc.sell.controller;

import com.xc.sell.dataobject.ProductCategory;
import com.xc.sell.dataobject.ProductInfo;
import com.xc.sell.repository.ProductCategoryRepository;
import com.xc.sell.service.CategoryService;
import com.xc.sell.service.ProductInfoService;
import com.xc.sell.service.impl.CategoryServiceImpl;
import com.xc.sell.service.impl.ProductInfoServiceImpl;
import com.xc.sell.utils.ResultVOUtil;
import com.xc.sell.vo.CategoryVO;
import com.xc.sell.vo.ProductVO;
import com.xc.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * create by 姜 sir
 * 2018/3/30 22:42
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoservice = new ProductInfoServiceImpl();

    @Autowired
    private CategoryService categoryservice = new CategoryServiceImpl();

    @GetMapping("/list")
    public ResultVO<CategoryVO> list() {
        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoservice.findUpAll();

        //2.查询类目(一次性查询)
        /** No.1 */
       /* List<Integer> productCateTypeList = new ArrayList();*/
       /* for (ProductInfo productInfo : productInfoList) {
            productCateTypeList.add(productInfo.getCategoryType());
        }*/
        /** No.2 Java8 lambda */
        List<Integer> productCateTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryservice.findByCategoryTypeIn(productCateTypeList);
        System.out.println(productCategoryList);
        //3.数据拼装
        List<CategoryVO> categoryVOList = new ArrayList<>();
        for (ProductCategory productCategory:productCategoryList){
            CategoryVO categoryVO = new CategoryVO();
            categoryVO.setCategoryName(productCategory.getCategoryName());
            categoryVO.setCategoryType(productCategory.getCategoryType());
            List<ProductVO> productVOSList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductVO productVO = new ProductVO();
                    BeanUtils.copyProperties(productInfo,productVO);
                    productVOSList.add(productVO);
                }
            }
            categoryVO.setProductVOList(productVOSList);
            categoryVOList.add(categoryVO);
        }
        return ResultVOUtil.success(categoryVOList);
    }
    ;


}
