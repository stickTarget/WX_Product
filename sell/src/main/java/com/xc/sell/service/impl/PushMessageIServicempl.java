package com.xc.sell.service.impl;

import com.xc.sell.config.WechatAccountConfig;
import com.xc.sell.dto.OrderDTO;
import com.xc.sell.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplate;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * create by 姜 sir
 * 2018/4/12 21:30
 */
@Slf4j
@Service
public class PushMessageIServicempl implements PushMessageService{

    @Autowired
    private WechatAccountConfig accountConfig;

    @Autowired
    private WxMpService wxMpService;

    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage wxMpTemplateMessage =new WxMpTemplateMessage();
            wxMpTemplateMessage.setTemplateId(accountConfig.getTemplateId().get("orderStatus"));
            wxMpTemplateMessage.setToUser(orderDTO.getBuyerOpenid());
            List<WxMpTemplateData> data = Arrays.asList(
                    new WxMpTemplateData("first","亲，请记得收货。"),
                    new WxMpTemplateData("keyword1","微信点餐"),
                    new WxMpTemplateData("keyword2","15001310976"),
                    new WxMpTemplateData("keyword3",orderDTO.getOrderId()),
                    new WxMpTemplateData("keyword4",orderDTO.getOrderStatusEnum().getMag()),
                    new WxMpTemplateData("keyword5","￥"+orderDTO.getOrderAmount()),
                    new WxMpTemplateData("remark","欢迎再次光临！")
            );
            wxMpTemplateMessage.setData(data);
        try {
            wxMpService.getTemplateMsgService().sendTemplateMsg(wxMpTemplateMessage);
        } catch (WxErrorException e) {
            log.error("【微信模板消息】 发送失败,{}",e );
        }
    }
}
