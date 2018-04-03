package com.xc.sell.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.xc.sell.dataobject.OrderDetail;
import com.xc.sell.dataobject.OrderMaster;
import com.xc.sell.dataobject.ProductInfo;
import com.xc.sell.dto.CatDTO;
import com.xc.sell.dto.OrderDTO;
import com.xc.sell.enums.OrderStatusEnum;
import com.xc.sell.enums.PayStatusEnum;
import com.xc.sell.enums.ResultEnum;
import com.xc.sell.exception.SellException;
import com.xc.sell.repository.OrderDetailRepository;
import com.xc.sell.repository.OrderMasterRepository;
import com.xc.sell.service.OrderService;
import com.xc.sell.service.ProductInfoService;
import com.xc.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * create by 姜 sir
 * 2018/4/3 9:41
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniqueKey();

        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        /*List<CatDTO> catDTOList=new ArrayList<>();*/

        //1.查询商品(数量,价格)
        for(OrderDetail orderDetail:orderDTO.getOrderDetailList())
        {
            ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
            if (productInfo == null){
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            //2.计算总价
            orderAmount=productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);

            //订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailRepository.save(orderDetail);
            /*catDTOList.add(new CatDTO(orderDetail.getProductId(),orderDetail.getProductQuantity()));*/

        }
        //3.写入订单数据库(OrderMaster,OrderDetail)
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        //4.扣库存
        List<CatDTO> catDTOList=orderDTO.getOrderDetailList().stream().map(e ->
            new CatDTO(e.getProductId(),e.getProductQuantity())
        ).collect(Collectors.toList());

        productInfoService.decreaseStock(catDTOList);

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderIds) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
