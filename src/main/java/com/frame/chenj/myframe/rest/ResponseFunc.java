package com.frame.chenj.myframe.rest;

import com.frame.chenj.myframe.mode.BaseResponse;

import rx.functions.Func1;

/**
 * Created by ${ChenJ} on 2016/9/13.
 */
public class ResponseFunc<T> implements Func1<BaseResponse<T>,T>{
    @Override
    public T call(BaseResponse<T> tBaseResponse) {
//        if(TextUtils.isEmpty){
//
//        }
        return null;
    }
}
