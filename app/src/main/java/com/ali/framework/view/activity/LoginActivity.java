package com.ali.framework.view.activity;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ali.framework.R;
import com.ali.framework.base.BaseActivity;
import com.ali.framework.contract.ILoginContract;
import com.ali.framework.model.bean.LoginBean;
import com.ali.framework.presenter.LoginPresenter;

import java.util.HashMap;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 声明规范：
 * 1、命名规范为 "${业务模块}Activity"  如：登录模块 Activity 命名为 "LoginActivity"
 * 2、必须指定泛型 P 的具体类型
 * 3、必须 implements 对应锲约中的 IView 接口  如: {@link ILoginContract.IView}
 * <p>
 * <p>
 * 使用规范：
 * 1、必须在 {@link #provideLayoutId()} 方法中返回对应的 laytoutId
 * 2、必须在 {@link #providePresenter()} 方法中返回对应的 Presenter 对象
 * 3、在{@link #initData()}中联网请求
 * 4、在重写的成功、失败方法中，更新UI
 * 登录页面
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginContract.IView {


    @BindView(R.id.edText_phone)
    EditText editText_phone;
    @BindView(R.id.edText_password)
    EditText edText_password;
    @BindView(R.id.button_login)
    Button button_login;
    @BindView(R.id.registered)
    TextView registered;
    private CharSequence temp;//监听前的文本
    @Override
    protected LoginPresenter providePresenter() {
        return new LoginPresenter();
    }


    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
    }

    @Override
    protected void initData() {
        super.initData();
        initFoucus();

    }


    //EditText获取焦点提示文字消失，失去焦点有提示文字
    private void initFoucus() {
        final String phone = editText_phone.getHint().toString();
        final String password = edText_password.getHint().toString();
        editText_phone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    editText_phone.setHint(null);
                } else {
                    editText_phone.setHint(phone);
                }
            }
        });
        edText_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    edText_password.setHint(null);
                } else {
                    edText_password.setHint(password);
                }
            }
        });
    }

    /**
     * 正则表达式匹配判断
     *
     * @param input 需要做匹配操作的字符串
     * @return true if matched, else false
     */
    public static boolean isPhoneNumber(String input) {// 判断手机号码是否规则
        String regex = "(1[0-9][0-9]|15[0-9]|18[0-9])\\d{8}";
        Pattern p = Pattern.compile(regex);
        return p.matches(regex, input);//如果不是号码，则返回false，是号码则返回true

    }

    /**
     * 判断给定字符串是否空白串。 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
     *
     * @param input
     * @return boolean
     */
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input))
            return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }

    @OnClick({R.id.edText_phone, R.id.edText_password, R.id.button_login, R.id.registered})
    public void setOnClick(View view) {
        switch (view.getId()) {
            case R.id.registered:
                Intent intent = new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(intent);
                break;
            case R.id.button_login:
                mPresenter.login("c82a0d76488dff2f6085695a063634200aa19f386b549c8ee2e6853dbb28b2fb170d87eaddb8fd94ffc248e7cde431f52b0df428103e97b7bde719a702672a5245cacf3c349e2836fb849fbc22d7092f63190524c6b0f54c16beedbb898248cf1a1119b947091ff07d388e8d640b42ace51e5e4e5becbf89e3cd72943dcedd2f",
                        "c82a0d76488dff2f6085695a063634200aa19f386b549c8ee2e6853dbb28b2fb170d87eaddb8fd94ffc248e7cde431f52b0df428103e97b7bde719a702672a5245cacf3c349e2836fb849fbc22d7092f63190524c6b0f54c16beedbb898248cf1a1119b947091ff07d388e8d640b42ace51e5e4e5becbf89e3cd72943dcedd2f",
                        "53b46f467e30942b9958ca55cd531e514f7229958cdea91e1f1595528fb5a0231193e85ee0d7f3a3d14913d554fa7d295a65c63b089106e6f40409ce71a15f11fa57aa74dde781929efb6e2747bce81c20d289344870dea91ada93ecf5d39ff9ece728514af4aa59eda89f766806440b425500fd147b19df75e1a0510d018a62");
//                String phone = editText_phone.getText().toString().trim();
//                String password = editText_phone.getText().toString().trim();
//                //判断用户是否输入的是空字符
//                if (isEmpty(phone)) {
//                    Toast.makeText(this, "您输入的手机号为空" + phone, Toast.LENGTH_SHORT).show();
//                } else {
//                    //用正则表达式判断是否输入的是正确的手机号,如果输入的是正确的 那么跳转页面
//                    if (isPhoneNumber(phone)) {
//                        Intent intentPhone = new Intent(this, HomeActivity.class);
//                        startActivity(intentPhone);
//                    } else {
//                        Toast.makeText(this, "您输入的手机号有误", Toast.LENGTH_SHORT).show();
//                    }
//                }
//                editText_phone.addTextChangedListener(new TextWatcher() {
//                    @Override
//                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                        temp = charSequence;
//                    }
//
//                    @Override
//                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//                    }
//
//                    @Override
//                    public void afterTextChanged(Editable editable) {
//                        if (temp.length() >5) {//长度大于5,改变按钮背景
//                            Toast.makeText(LoginActivity.this, "长度大于5", Toast.LENGTH_SHORT).show();
//                        }else {
//
//                        }
//                    }
//                });
        }
    }

    //成功
    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        Toast.makeText(this, loginBean.getAccess_token(), Toast.LENGTH_SHORT).show();
        Log.e("登录成功", "onLoginSuccess: aa");
    }

    //失敗
    @Override
    public void onLoginFailure(Throwable e) {
        Log.i("TAG", "登录失败: " + e.toString());
        Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
    }


}
