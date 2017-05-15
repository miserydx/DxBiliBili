package com.dx.bilibili.base;

import android.view.View;

/**
 * Created by jiayiyang on 17/5/8.
 */

public interface IBaseMvpActivity<T extends AbsBasePresenter> extends IBaseActivity {

    /**
     * 获取需要设置padding的view,padding值为默认构造statusBar的高度
     * @return 非DrawerLayout页面返回null即可
     */
    View getPaddingNeedView();

    T getPresenter();

}
