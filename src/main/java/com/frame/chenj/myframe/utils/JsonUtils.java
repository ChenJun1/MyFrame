package com.frame.chenj.myframe.utils;

import com.bluelinelabs.logansquare.LoganSquare;

import java.util.List;

/**
 * Created by ${ChenJ} on 2016/8/24.
 */
public class JsonUtils {
    /**
     *
     * @param jsonStr
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T parseData(String jsonStr,Class<?> cls){
        try {
            return (T) LoganSquare.parse(jsonStr,cls);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param jsonStr
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T parseDataList(String jsonStr,Class<?> cls){
        try {
            return (T) LoganSquare.parseList(jsonStr,cls);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param object
     * @return
     */
    public static String toJsonData(Object object){
        try {
            return LoganSquare.serialize(object);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param list
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> String toJsonData(List<T> list,Class<T> cls){
        try {
            return LoganSquare.serialize(list,cls);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
