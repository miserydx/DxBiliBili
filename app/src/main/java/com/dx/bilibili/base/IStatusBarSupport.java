package com.dx.bilibili.base;

import android.view.View;

/**
 * Created by jiayiyang on 17/5/15.
 */

public interface IStatusBarSupport {

    /**
     * 获取需要设置padding的view,padding值为默认构造statusBar的高度
     * @return 非DrawerLayout页面返回null即可
     */
    View getPaddingNeedView();

    /**
     * 设置是否自定义statusbar
     * @return true自定义,false按照默认封装的状态栏样式
     */
    boolean setCustomStatusBar();

}
