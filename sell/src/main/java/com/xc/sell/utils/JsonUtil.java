package com.xc.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * create by 姜 sir
 * 2018/4/10 11:27
 */
public class JsonUtil {

    public static String toJson(Object object){
        GsonBuilder gsonBuilder =new GsonBuilder();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
