package com.dx.bilibili.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.dx.bilibili.R;
import com.dx.bilibili.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.news_btn)
    Button btnNews;
    @BindView(R.id.toolbar_behavior_mvp_btn)
    Button btnToolbarBehavior;
    @BindView(R.id.status_picture_mvp_btn)
    Button btnStatusWithPicture;
    @BindView(R.id.scroll_gradient_mvp_btn)
    Button btnScrollGradient;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInject() {

    }

    @Override
    protected void initViewAndEvent() {
        //关闭右滑返回
        setSwipeBackEnable(false);
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.toolbar_behavior_mvp_btn, R.id.news_btn, R.id.status_picture_mvp_btn, R.id.scroll_gradient_mvp_btn})
    public void jumpToPage(View view){
        switch (view.getId()){
            case R.id.toolbar_behavior_mvp_btn:
                startActivity(new Intent(mContext, ToolbarBehaviorActivity.class));
                break;
            case R.id.news_btn:
                startActivity(new Intent(mContext, NewsActivity.class));
                break;
            case R.id.status_picture_mvp_btn:
                startActivity(new Intent(mContext, StatusWithPictureActivity.class));
                break;
            case R.id.scroll_gradient_mvp_btn:
                startActivity(new Intent(mContext, ScrollGradientActivity.class));
                break;
        }
    }

}
