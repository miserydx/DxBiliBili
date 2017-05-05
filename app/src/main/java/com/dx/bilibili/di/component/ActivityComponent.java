package com.dx.bilibili.di.component;

import com.dx.bilibili.di.module.ActivityModule;
import com.dx.bilibili.ui.activity.NewsActivity;
import com.dx.bilibili.ui.activity.TestApiActivity;
import com.dx.bilibili.ui.activity.ToolbarBehaviorActivity;
import com.dx.bilibili.di.module.PageModule;
import com.dx.bilibili.di.scope.PerActivity;
import com.dx.bilibili.ui.activity.ScrollGradientActivity;
import com.dx.bilibili.ui.activity.StatusWithPictureActivity;

import dagger.Component;

/**
 * Created by jiayiyang on 17/3/23.
 */

@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, PageModule.class})
@PerActivity
public interface ActivityComponent {

    void inject(NewsActivity newsActivity);

    void inject(ToolbarBehaviorActivity toolbarBehaviorActivity);

    void inject(StatusWithPictureActivity statusWithPictureActivity);

    void inject(ScrollGradientActivity scrollGradientActivity);

    void inject(TestApiActivity testApiActivity);

}
