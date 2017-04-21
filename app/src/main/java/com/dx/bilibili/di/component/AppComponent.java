package com.dx.bilibili.di.component;

import com.dx.bilibili.di.module.ApiModule;
import com.dx.bilibili.di.module.AppModule;
import com.dx.bilibili.model.api.ZhihuApis;
import com.dx.bilibili.model.api.WeChatApis;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jiayiyang on 17/3/25.
 */

@Component(modules = {AppModule.class, ApiModule.class})
@Singleton
public interface AppComponent {

    ZhihuApis zhihuApis();

    WeChatApis weChatApis();

}
