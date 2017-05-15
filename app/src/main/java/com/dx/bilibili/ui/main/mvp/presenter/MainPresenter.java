package com.dx.bilibili.ui.main.mvp.presenter;

import com.dx.bilibili.base.AbsBasePresenter;
import com.dx.bilibili.model.api.WeChatApis;
import com.dx.bilibili.ui.main.mvp.contract.MainContract;

import javax.inject.Inject;

/**
 * Created by jiayiyang on 17/3/25.
 */

public class MainPresenter extends AbsBasePresenter<MainContract.View> implements MainContract.Presenter {

    private static final String TAG = MainPresenter.class.getSimpleName();

    @Inject
    public MainPresenter() {

    }


}
