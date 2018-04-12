package com.xc.sell.controller;

import com.xc.sell.dataobject.ProductCategory;
import com.xc.sell.exception.SellException;
import com.xc.sell.form.CategoryForm;
import com.xc.sell.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 卖家类目
 * create by 姜 sir
 * 2018/4/12 10:23
 */
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 类目列表
     *
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("category/list", map);
    }

    /**
     * 展示
     *
     * @param categoryId
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                              Map<String, Object> map) {
        if (categoryId != null) {
            ProductCategory productCategory = categoryService.findOne(categoryId);
            map.put("productCategory", productCategory);
        }
        return new ModelAndView("category/index", map);

    }

    /**
     * 保存/更新
     *
     * @param map
     * @return
     */
    @GetMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if(bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage() );
            map.put("url","/sell/seller/category/index" );
            return new ModelAndView("common/error",map);
        }
        ProductCategory category =new ProductCategory();
        try {
            if(form.getCategoryId()!= null){
                category = categoryService.findOne(form.getCategoryId());
            }
            BeanUtils.copyProperties(form,category );
            categoryService.save(category);
        }catch (SellException e){
            map.put("msg", e.getMessage());
            map.put("url","/sell/seller/category/index" );
            return new ModelAndView("common/error",map);
        }
        map.put("category", category);
        map.put("url","/sell/seller/category/list" );
        return new ModelAndView("category/success", map);

    }
}
