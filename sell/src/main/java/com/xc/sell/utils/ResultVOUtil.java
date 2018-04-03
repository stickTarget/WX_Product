package com.xc.sell.utils;

import com.xc.sell.vo.CategoryVO;
import com.xc.sell.vo.ResultVO;

import java.util.List;

/**
 * create by 姜 sir
 * 2018/3/31 9:24
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO =new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(){
        return null;
    }

    public static ResultVO error (Integer code,String msg){
        ResultVO resultVO =new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
