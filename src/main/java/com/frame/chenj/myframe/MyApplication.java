package com.frame.chenj.myframe;

import com.antfortune.freeline.FreelineCore;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.frame.chenj.myframe.utils.LogUtil;

import org.litepal.LitePalApplication;

/**
 * Created by ${ChenJ} on 2016/8/22.
 */
public class MyApplication extends LitePalApplication {
    private static MyApplication ms_MyApplication;

    public static synchronized MyApplication getInstance(){
        return ms_MyApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        FreelineCore.init(this);
        ms_MyApplication=this;
        Fresco.initialize(this);
        LogUtil.setDebug(false);
    }
}
