package com.xc.sell.controller;

import com.xc.sell.dataobject.ProductCategory;
import com.xc.sell.dataobject.ProductInfo;
import com.xc.sell.dto.OrderDTO;
import com.xc.sell.exception.SellException;
import com.xc.sell.form.ProductForm;
import com.xc.sell.service.CategoryService;
import com.xc.sell.service.ProductInfoService;
import com.xc.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 卖家端商品
 * create by 姜 sir
 * 2018/4/12 8:04
 */
@Controller
@RequestMapping("/seller/product")
public class SellerPorductController {

    @Autowired
    ProductInfoService productInfoService;

    @Autowired
    CategoryService categoryService;
    @GetMapping("list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String,Object> map){
        PageRequest pageRequest =new PageRequest(page-1 ,size);
        Page<ProductInfo> productInfoPage= productInfoService.findAll(pageRequest);
        map.put("productInfoPage",productInfoPage );
        map.put("currentPage", page);
        map.put("size",size );
        return new ModelAndView("product/list",map);
    }

    /**
     * 商品上架
     * @param productId
     * @param map
     * @return
     */
    @GetMapping("/product/on_sale")
    public ModelAndView on_sale(@RequestParam("productId")String productId,
                                Map<String,Object> map){
        try{
            productInfoService.onSale(productId);
        }catch (SellException e){
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/product/list" );
            return new ModelAndView("common/error",map);
        }
        map.put("url","/sell/seller/product/list" );
        return new ModelAndView("common/success",map);
    }

    /**
     * 商品下架
     * @param productId
     * @param map
     * @return
     */
    @GetMapping("/product/off_sale")
    public ModelAndView off_sale(@RequestParam("productId")String productId,
                                Map<String,Object> map){
        try{
            productInfoService.offSale(productId);
        }catch (SellException e){
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/product/list" );
            return new ModelAndView("common/error",map);
        }
        map.put("url","/sell/seller/product/list" );
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId",required = false)String productId,
                      Map<String,Object> map){
        if(!StringUtils.isEmpty(productId)){
            ProductInfo productInfo = productInfoService.findOne(productId);
            map.put("productInfo", productInfo);
        }

        //查询所有的类目
        List<ProductCategory> productCategoryList = categoryService.findAll();
        map.put("productCategoryList", productCategoryList);
        return new ModelAndView("product/index",map);
    }

    /**
     * 保存/更新
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult bindingResult,
                             Map<String,Object> map){
        if(bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage() );
            map.put("url","/sell/seller/product/index" );
            return new ModelAndView("common/error",map);
        }
        ProductInfo productInfo =new ProductInfo();
        try{
            //如果productId为空，说明是新增
            if(!StringUtils.isEmpty(form.getProductId())){
                productInfo = productInfoService.findOne(form.getProductId());
            }else{
                form.setProductId(KeyUtil.genUniqueKey());
            }

            BeanUtils.copyProperties(form,productInfo );
        }catch (SellException e){
            map.put("msg", e.getMessage() );
            map.put("url","/sell/seller/product/index" );
            return new ModelAndView("common/error",map);
        }

        try{
            productInfoService.save(productInfo);
        }catch (SellException e){
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/product/index" );
            return new ModelAndView("common/error",map);
        }
        map.put("productInfo",productInfo );
        return new ModelAndView("common/success",map);
    }

}
