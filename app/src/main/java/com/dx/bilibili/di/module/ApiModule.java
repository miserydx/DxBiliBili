package com.dx.bilibili.di.module;

import com.dx.bilibili.di.scope.WeChatApi;
import com.dx.bilibili.di.scope.ZhihuApi;
import com.dx.bilibili.model.api.ZhihuApis;
import com.dx.bilibili.model.api.WeChatApis;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jiayiyang on 17/3/25.
 */

@Module
public class ApiModule {

    @Singleton
    @Provides
    ZhihuApis provideZhihuService(@ZhihuApi Retrofit retrofit) {
        return retrofit.create(ZhihuApis.class);
    }

    @Singleton
    @Provides
    WeChatApis provideWeChatService(@WeChatApi Retrofit retrofit) {
        return retrofit.create(WeChatApis.class);
    }

    @Singleton
    @Provides
    @ZhihuApi
    Retrofit provideZhihuRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ZhihuApis.HOST);
    }

    @Singleton
    @Provides
    @WeChatApi
    Retrofit provideWechatRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, WeChatApis.HOST);
    }

    Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient okHttpClient, String url) {
        return builder.baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }

}
