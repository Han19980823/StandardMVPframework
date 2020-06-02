package com.ali.framework.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ali.framework.R;
import com.ali.framework.base.BaseActivity;
import com.ali.framework.base.BasePresenter;
import com.ali.framework.view.fragment.MyFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class NickNameActivity extends BaseActivity {

    @BindView(R.id.update_name)
    EditText updata_name;
    @BindView(R.id.canle_img)
    ImageView canle_img;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_nick_name;
    }

    @Override
    protected void initData() {
        super.initData();
        SharedPreferences data = getSharedPreferences("data", Context.MODE_PRIVATE);
        String name = data.getString("name", "");
        if (updata_name != null) {
            updata_name.setHint(name);
        }


    }


    @OnClick({R.id.complete,R.id.canle_img})
    public void complete(View view) {
        switch (view.getId()) {
            case R.id.canle_img:
                if (updata_name != null) {
                    updata_name.setHint("");
                }
                break;
            case R.id.complete:
                 if (updata_name.getHint().toString() == null){
                     Toast.makeText(this, "taihaol", Toast.LENGTH_SHORT).show();
                 }
                break;



        }
    }
}
