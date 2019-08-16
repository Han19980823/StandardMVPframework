package com.ali.framework.contract;

import com.ali.framework.base.IBaseView;
import com.ali.framework.model.bean.LoginBean;

import java.util.Map;

/**
 * 契约类，方便统一管理相关接口
 */
public interface ILoginContract {
    /**
     * view层
     */
    interface IView extends IBaseView {
        void onLoginSuccess(LoginBean loginBean);

        void onLoginFailure(Throwable e);
    }

    /**
     * presenter层
     */
    interface IPresenter {
        void login(Map<String, Object> paramsMap);
    }

    /**
     * model层
     */
    interface IModel {
        void login(Map<String, Object> paramsMap, IModelCallback callback);

        /**
         * model层中的接口回调
         */
        interface IModelCallback {
            void onLoginSuccess(LoginBean loginBean);

            void onLoginFailure(Throwable e);
        }
    }
}