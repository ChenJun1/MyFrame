package com.frame.chenj.myframe.Fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.frame.chenj.myframe.R;
import com.frame.chenj.myframe.utils.LogUtil;

/**
 * 版权所有 势航网络
 * Created by ${ChenJ} on 2016/11/4.
 */



public class FrescoTest extends Activity{

    private SimpleDraweeView mDraweeView;
    private ZoomableDraweeView mZoomableDraweeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int a=100;
        int b=100;
        int c=200;
        int d=200;
        Boolean ab=a==b;
        Boolean cd=c==d;
        LogUtil.d("------------------------------>>"+ab+cd);
        setContentView(R.layout.fresco_test);
        mDraweeView= (SimpleDraweeView) findViewById(R.id.image);
        mZoomableDraweeView= (ZoomableDraweeView) findViewById(R.id.image1);
        DraweeController mDraweeController = Fresco.newDraweeControllerBuilder()
                .setAutoPlayAnimations(true)
                .setUri(Uri.parse("http://zhuangbi.idagou.com/i/2016-07-23-325dd85b02ce2215b224224e07a18971.gif"))
                .build();
        DraweeController mDraweeController1 = Fresco.newDraweeControllerBuilder()
                .setAutoPlayAnimations(true)
                .setUri(Uri.parse("http://zhuangbi.idagou.com/i/2016-07-23-325dd85b02ce2215b224224e07a18971.gif"))
                .build();
//        Uri uri=uri
        mDraweeView.setController(mDraweeController);
        mZoomableDraweeView.setController(mDraweeController1);
    }
}
