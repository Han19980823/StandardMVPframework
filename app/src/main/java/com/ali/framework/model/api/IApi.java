package com.ali.framework.model.api;


import com.ali.framework.model.bean.LoginBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Retrofit默认只使用这一个IApi
 * <p>
 * <p>
 * 使用规范：
 * 一个http请求对应该接口中一个方法
 */
public interface IApi {
    @POST("sso/oauth/service/token?grant_type=password")
    @Multipart
    Observable<LoginBean> login(@Header("authorization") String authorization, @Part("inputname") String name, @Part("username") String username, @Part("password")String password);
}
