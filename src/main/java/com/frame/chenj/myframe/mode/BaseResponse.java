package com.frame.chenj.myframe.mode;

/**
 * 返回数据的基础类型
 * Created by dazhuanjia_rx on 16/8/31.
 */
public class BaseResponse<T> {

    /**
     * code : null
     * message : null
     * data : {}
     */
    public String code;
    public String message;
    public T data;
}
