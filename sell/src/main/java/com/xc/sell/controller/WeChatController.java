package com.xc.sell.controller;

import com.xc.sell.config.ProjectUrlConfig;
import com.xc.sell.enums.ResultEnum;
import com.xc.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;

/**
 * create by 姜 sir
 * 2018/4/10 9:15
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WeChatController {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl) {
        //1.配置
        //2.调用方法
        String url = projectUrlConfig.getWeChatMpAuthorize()+"/sell/wechat/userInfo";
        String resultUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_BASE, URLEncoder.encode(returnUrl));
        log.info("【微信网页授权】获取code ，result={}", resultUrl);
        return "redirect:" + resultUrl;
    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                         @RequestParam("state") String returnUrl) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【为你网页授权】 {}", e);
            throw new SellException(ResultEnum.WX_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }
        String openid = wxMpOAuth2AccessToken.getOpenId();
        return "redirect:"+returnUrl+"?openid="+openid;
    }

    @GetMapping("/qrAuthorize")
    public String qrAuthorize(@RequestParam("returnUrl") String returnUrl) {
        //1.配置
        //2.调用方法
        String url = projectUrlConfig.getWechatOpenAuthorize()+"sell/wechat/qrUserInfo";
        String resultUrl = wxMpService.buildQrConnectUrl(url,WxConsts.QRCONNECT_SCOPE_SNSAPI_LOGIN , URLEncoder.encode(returnUrl));
        return "redirect:" + resultUrl;
    }

    @GetMapping("/qrUserInfo")
    public String qrUserInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【为你网页授权】 {}", e);
            throw new SellException(ResultEnum.WX_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }
        String openid = wxMpOAuth2AccessToken.getOpenId();
        return "redirect:"+returnUrl+"?openid="+openid;
    }
}
