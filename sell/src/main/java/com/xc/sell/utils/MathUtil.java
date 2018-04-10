package com.xc.sell.utils;

/**
 * create by 姜 sir
 * 2018/4/10 21:29
 */
public class MathUtil {
    private static final Double Money_Range = 0.01;

    /**
     * 比较两个金额是否相等
     * @param d1
     * @param d2
     * @return
     */
    public static boolean equals(Double d1,Double d2){
        double result = Math.abs(d1 - d2);
        if(result>Money_Range){
            return true;
        }else{
            return false;
        }
    }
}
