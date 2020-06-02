package com.ali.framework.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.ali.framework.R;
import com.ali.framework.base.BaseActivity;
import com.ali.framework.base.BasePresenter;
import com.ali.framework.utils.IdentifyingCodeUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 注册页面
 */
public class RegistActivity extends BaseActivity {
    @BindView(R.id.identifyingcode_image)
    ImageView identifyingcode_image;
    @BindView(R.id.btn_rev)
    ImageView btn_rev;
    private String realCode;
    private RotateAnimation myAlphaAnimation;
    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData();
        identifyingcode_image.setImageBitmap(IdentifyingCodeUtils.getInstance().createBitmap());
        realCode=IdentifyingCodeUtils.getInstance().getCode().toLowerCase();

    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_regist;
    }
    @OnClick({R.id.btn_rev,R.id.identifyingcode_image})
    public void setOnImage(View view){
        switch (view.getId()) {
            case R.id.btn_rev:
                identifyingcode_image.setImageBitmap(IdentifyingCodeUtils.getInstance().createBitmap());
                realCode=IdentifyingCodeUtils.getInstance().getCode().toLowerCase();
             }

        }
    }

