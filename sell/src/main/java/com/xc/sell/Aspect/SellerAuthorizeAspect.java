package com.xc.sell.Aspect;

import com.xc.sell.constant.CookieConstant;
import com.xc.sell.constant.RedisConstant;
import com.xc.sell.exception.SellException;
import com.xc.sell.exception.SellerAuthorizeException;
import com.xc.sell.utils.Cookieutil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * create by 姜 sir
 * 2018/4/12 18:09
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution(public * com.xc.sell.controller.Seller*.*(..))"+
    "&& !execution(public * com.xc.sell.controller.SellerUserController.*(..))")
    public void verify(){};

    @Before("verify()")
    public void doVerify(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //查询cookie
        Cookie cookie = Cookieutil.get(request, CookieConstant.TOKEN);
        if (cookie == null){
            log.info("【登陆校验】 cookie中查不到token" );
            throw new SellerAuthorizeException();
        }
        //去redis里查询
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie));
        if (StringUtils.isEmpty(tokenValue)){
            log.warn("【登陆效验】Redis中查不到token");
            throw new SellerAuthorizeException();
        }
    };
}
























