package com.ali.framework.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ali.framework.R;
import com.ali.framework.base.BaseActivity;
import com.ali.framework.base.BasePresenter;

/**
 * 我的订单
 */

public class Orderctivity extends BaseActivity {



    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_orderctivity;
    }
}
