package com.frame.chenj.myframe;

import android.os.Bundle;
import android.widget.TextView;

import com.frame.chenj.myframe.mode.Preson;
import com.frame.chenj.myframe.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        List<Preson> list=new ArrayList<>();

      String str=JsonUtils.toJsonData(list,Preson.class);
    }

    @OnClick(R.id.text)
    public void onClick() {
    }
}
