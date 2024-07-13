package com.yobelbackend.yobelbackend.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class JsonUtil {

    public static Map<String, Object> parseJsonToMap(String json){
        Map<String, Object> respuesta = new HashMap<String, Object>();
        try{
            Gson gson = new Gson();

            Type type = new TypeToken<Map<String, Object>>(){}.getType();

            return gson.fromJson(json, type);
        } catch (Exception e){
            return null;
        }
    }


}
