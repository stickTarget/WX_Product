package com.xc.sell.controller;

import com.xc.sell.dataobject.ProductInfo;
import com.xc.sell.service.ProductInfoService;
import com.xc.sell.service.impl.ProductInfoServiceImpl;
import com.xc.sell.vo.CategoryVO;
import com.xc.sell.vo.ProductVO;
import com.xc.sell.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * 买家商品
 * create by 姜 sir
 * 2018/3/30 22:42
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService service = new ProductInfoServiceImpl();

    @GetMapping("/list")
    public ResultVO<CategoryVO> list(){
        ResultVO resultVO =new ResultVO();
        CategoryVO categoryVO =new CategoryVO();
        ProductVO product =new ProductVO();
        categoryVO.setProductVOList(Arrays.asList(product));
        /*categoryVO.setCategoryName("热销");*/
        resultVO.setData(Arrays.asList(categoryVO));
        resultVO.setCode(200);
        resultVO.setMsg("成功");
        return resultVO;
    };





}
