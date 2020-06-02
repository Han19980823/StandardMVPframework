package com.ali.framework.view.fragment;

import android.support.v4.app.Fragment;

import com.ali.framework.R;
import com.ali.framework.base.BaseFragment;
import com.ali.framework.base.BasePresenter;

/**
 * 主页面fragment
 */
public class HomeFragment extends BaseFragment {


    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.home_fragment;
    }
}
