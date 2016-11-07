package com.frame.chenj.myframe.base;

import android.content.Context;

/**
 * Created by ${ChenJ} on 2016/9/13.
 */
public interface IView {
    /**
     * 网络错误
     */
    int ERROR_NETWORK = 2111;
    /**
     * 数据错误
     */
    int ERROR_DATA = 2112;
    /**
     * 未知错误
     */
    int ERROR_UNKNOW = 2113;
    /**
     * 未登陆
     */
    int ERROR_UN_LOGIN = 2114;

    /**
     * @return 获取context
     */
    Context getContext();

    /**
     * 显示进度条
     */
    void showProgress();

    /**
     * 隐藏进度条
     */
    void hidePregress();

    /**
     * 显示错误信息
     *
     * @param type 错误类型
     * @param notice 错误信息
     */
    void showNotice(int type, String notice);

    /**
     *
     * 网络请求成功后的回调
     * @param typr
     * @param data
     */
    void onReultSuccess(int typr,Object data);


}
