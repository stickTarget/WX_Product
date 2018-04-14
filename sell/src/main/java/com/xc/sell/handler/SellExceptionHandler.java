package com.xc.sell.handler;

import com.xc.sell.config.ProjectUrlConfig;
import com.xc.sell.exception.ResponseBankException;
import com.xc.sell.exception.SellException;
import com.xc.sell.exception.SellerAuthorizeException;
import com.xc.sell.utils.ResultVOUtil;
import com.xc.sell.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * create by 姜 sir
 * 2018/4/12 18:32
 */
@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;
    //拦截登陆异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerSellerAuthorizeException(){
        return new ModelAndView("redirect:"
                .concat(projectUrlConfig.getWechatOpenAuthorize())
        .concat("/sell/wechat/qrAuthorize")
        .concat("?returnUrl=")
        .concat("/sell/seller/login"));
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResultVO handlerSellerException(SellException e){
        return ResultVOUtil.error(e.getCode(),e.getMessage() );
    }

    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleResponseBankException(){

    }
}
