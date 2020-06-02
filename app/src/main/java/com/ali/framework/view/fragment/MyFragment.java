package com.ali.framework.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ali.framework.R;
import com.ali.framework.base.BaseFragment;
import com.ali.framework.base.BasePresenter;
import com.ali.framework.view.activity.EditorActivity;
import com.ali.framework.view.activity.FeedbackActivity;
import com.ali.framework.view.activity.MemberActivity;
import com.ali.framework.view.activity.MyMessageActivity;
import com.ali.framework.view.activity.Orderctivity;
import com.ali.framework.view.activity.TopicActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的fragment
 */


public class MyFragment extends BaseFragment {
    @BindView(R.id.my_name)
    TextView my_name;
    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.my_fragment;

    }

    @Override
    protected void initData() {
        super.initData();


    }

    @OnClick({R.id.login_myMessage, R.id.my_feedback, R.id.my_messages, R.id.my_members, R.id.my_order, R.id.my_topic})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.login_myMessage:
                String my_name = this.my_name.getText().toString();
                Log.d("my_name", "onClick: my_name"+my_name);
                SharedPreferences data = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = data.edit();
                edit.putString("name",my_name);
                edit.commit();
                //当用户点击我的条目时，跳转到修改的页面
                Intent intent = new Intent(getActivity(), EditorActivity.class);

                startActivity(intent);
                break;
            case R.id.my_members:
                //当用户点击会员中心跳转到会员页面
                Intent my_members = new Intent(getActivity(), MemberActivity.class);
                startActivity(my_members);
                break;
            case R.id.my_order:
                //当用户点击我的订单时候查询订单
                Intent my_order = new Intent(getActivity(), Orderctivity.class);
                startActivity(my_order);
                break;
            case R.id.my_topic:
                //当用户点击我的错题时候查询错题
                Intent my_topic = new Intent(getActivity(), TopicActivity.class);
                startActivity(my_topic);
                break;
            case R.id.my_feedback:
                //当用户点击意见反馈进行反馈
                Intent my_feedback = new Intent(getActivity(), FeedbackActivity.class);
                startActivity(my_feedback);
                break;
            case R.id.my_messages:
                //当用户点击意见反馈进行反馈
                Intent my_messages = new Intent(getActivity(), MyMessageActivity.class);
                startActivity(my_messages);
                break;
        }
    }
}
