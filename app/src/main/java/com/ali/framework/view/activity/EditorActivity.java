package com.ali.framework.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ali.framework.R;
import com.ali.framework.base.BaseActivity;
import com.ali.framework.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * MyMessage:用户编辑名称activity
 */

public class EditorActivity extends BaseActivity {

    @BindView(R.id.namea)
    TextView namea;


    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_editor;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences data = getSharedPreferences("data", Context.MODE_PRIVATE);
        String name = data.getString("name", "");
        if (namea!=null){
            namea.setText(name);
        }

    }

    @OnClick({R.id.nickname, R.id.sex, R.id.address})
    public void onClickLisenter(View view) {
        switch (view.getId()) {
            case R.id.nickname:
                //去修改昵称
                Intent nickname = new Intent(EditorActivity.this, NickNameActivity.class);
                startActivity(nickname);
                break;
            case R.id.sex:
                //去修改性别
                Intent sex = new Intent(EditorActivity.this, SexActivity.class);
                startActivity(sex);
                break;
            case R.id.address:
                //去修改地址
                Intent address = new Intent(EditorActivity.this, MyAddressActivity.class);
                startActivity(address);
                break;
        }

    }
}
