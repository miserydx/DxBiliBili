package com.dx.bilibili.base;

import com.dx.bilibili.di.component.ActivityComponent;

/**
 * Created by jiayiyang on 17/5/8.
 */

public interface IBaseActivity {

    /**
     * 获取布局id
     * @return
     */
    int getLayoutId();

    /**
     * 初始化dagger注入
     */
    void initInject(ActivityComponent activityComponent);

    void initViewAndEvent();

    void initData();

}
