package com.ali.framework.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ali.framework.R;
import com.ali.framework.base.BaseActivity;
import com.ali.framework.base.BasePresenter;
import com.ali.framework.view.fragment.HomeFragment;
import com.ali.framework.view.fragment.MyFragment;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    private TabLayout.Tab tab_one;
    private TabLayout.Tab tab_two;
    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData();
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            private String[] mTitles = new String[]{"首页", "我的"};

            @Override
            public Fragment getItem(int position) {//为fragment pager adapter 分配 fragment
                if (position == 0)
                    return new HomeFragment();
                else
                    return new MyFragment();

            }

            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {//显示title
                return mTitles[position];
            }
        });
        tabLayout.setupWithViewPager(viewPager);//将tablayout和viewpager绑定
        tab_one = tabLayout.getTabAt(0);
        tab_two = tabLayout.getTabAt(1);
        tab_one.setIcon(getResources().getDrawable(R.drawable.tabhome,null));
        tab_two.setIcon(getResources().getDrawable(R.drawable.taba,null));
        initEvents();
    }

    private void initEvents(){
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {//viewpager跟着tab
                if(tab==tabLayout.getTabAt(0)){
                    viewPager.setCurrentItem(0);
                    tab_one.setIcon(getResources().getDrawable(R.drawable.homec,null));
                    tab_two.setIcon(getResources().getDrawable(R.drawable.taba,null));
                    tab_one.setIcon(getResources().getDrawable(R.drawable.tabhome,null));
                }
                if(tab==tabLayout.getTabAt(1)){
                    viewPager.setCurrentItem(1);
                    tab_two.setIcon(getResources().getDrawable(R.drawable.tabmy,null));
                    tab_one.setIcon(getResources().getDrawable(R.drawable.homec,null));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_home;
    }
}
