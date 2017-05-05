package com.dx.bilibili.ui.activity;

import android.util.Log;

import com.dx.bilibili.R;
import com.dx.bilibili.app.ApiHelper;
import com.dx.bilibili.base.BaseActivity;
import com.dx.bilibili.model.api.AppApis;
import com.dx.bilibili.model.api.BangumiApis;
import com.dx.bilibili.model.api.LiveApis;
import com.dx.bilibili.model.bean.SearchHotResponse;
import com.dx.bilibili.model.bean.BangumiIndexPageResponse;
import com.dx.bilibili.model.bean.IndexResponse;
import com.dx.bilibili.model.bean.LiveAreasResponse;
import com.dx.bilibili.model.bean.LiveCommonResponse;
import com.dx.bilibili.model.bean.LiveRecommendResponse;
import com.dx.bilibili.model.bean.RegionResponse;
import com.dx.bilibili.model.bean.RegionShowResponse;
import com.dx.bilibili.model.bean.ResultList;
import com.dx.bilibili.model.bean.ResultObject;
import com.dx.bilibili.model.bean.SplashResponse;
import com.dx.bilibili.util.DateUtil;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class TestApiActivity extends BaseActivity {

    @Inject
    AppApis appApis;
    @Inject
    BangumiApis bangumiApis;
    @Inject
    LiveApis liveApis;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test_api;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void initViewAndEvent() {

    }

    @Override
    protected void initData() {
        appApis.getRegionShow(ApiHelper.getAppKey(),ApiHelper.getBUILD(),ApiHelper.getMobiApp(), ApiHelper.getPLATFORM(), DateUtil.getSystemTime())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResultList<RegionShowResponse>>() {
                    @Override
                    public void call(ResultList<RegionShowResponse> regionShowResponseResultList) {
                        Log.d("misery", "regionShowResponseResultList="+ regionShowResponseResultList);
                    }
                });

        appApis.getRegion(ApiHelper.getBUILD())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResultList<RegionResponse>>() {
                    @Override
                    public void call(ResultList<RegionResponse> regionResponseResultList) {
                        Log.d("misery", "regionResponseResultList="+ regionResponseResultList);
                    }
                });

        appApis.getIndex(ApiHelper.getAppKey(), ApiHelper.getBUILD(), "1493277505", ApiHelper.getMobiApp(), "wifi", ApiHelper.getPLATFORM(), "true", DateUtil.getSystemTime())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResultList<IndexResponse>>() {
                    @Override
                    public void call(ResultList<IndexResponse> indexResponseResultList) {
                        Log.d("misery", "indexResponseResultList="+ indexResponseResultList);
                    }
                });

        appApis.getSplash(ApiHelper.getMobiApp(), ApiHelper.getBUILD(), AppApis.CHANNEL, 1080, 1920, AppApis.VER)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResultList<SplashResponse>>() {
                    @Override
                    public void call(ResultList<SplashResponse> splashResponseResultList) {
                        Log.d("misery", "splashResponseResultList="+ splashResponseResultList);
                    }
                });

        liveApis.getCommon(ApiHelper.getDevice(), ApiHelper.getAppKey(), ApiHelper.getBUILD(), ApiHelper.getMobiApp(), ApiHelper.getPLATFORM(), ApiHelper.getScale(), DateUtil.getSystemTime())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResultObject<LiveCommonResponse>>() {
                    @Override
                    public void call(ResultObject<LiveCommonResponse> liveCommonResultList) {
                        Log.d("misery", "liveCommonResultList="+ liveCommonResultList);
                    }
                });

        liveApis.getRecommend(ApiHelper.getDevice(), ApiHelper.getAppKey(), ApiHelper.getBUILD(), ApiHelper.getMobiApp(), ApiHelper.getPLATFORM(), ApiHelper.getScale(), DateUtil.getSystemTime())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResultObject<LiveRecommendResponse>>() {
                    @Override
                    public void call(ResultObject<LiveRecommendResponse> liveRecommendResponseResultList) {
                        Log.d("misery", "liveRecommendResponseResultList="+ liveRecommendResponseResultList);
                    }
                });

        liveApis.getAreas(ApiHelper.getDevice(), ApiHelper.getAppKey(), ApiHelper.getBUILD(), ApiHelper.getMobiApp(), ApiHelper.getPLATFORM(), ApiHelper.getScale(), DateUtil.getSystemTime())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResultList<LiveAreasResponse>>() {
                    @Override
                    public void call(ResultList<LiveAreasResponse> liveAreasResponseResultList) {
                        Log.d("misery", "liveAreasResponseResultList="+ liveAreasResponseResultList);
                    }
                });

        bangumiApis.getIndexPage(ApiHelper.getAppKey(),ApiHelper.getBUILD(), ApiHelper.getMobiApp(), ApiHelper.getPLATFORM(), DateUtil.getSystemTime())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResultObject<BangumiIndexPageResponse>>() {
                    @Override
                    public void call(ResultObject<BangumiIndexPageResponse> bangumiIndexPageResponseResultObject) {
                        Log.d("misery", "bangumiIndexPageResponseResultObject="+bangumiIndexPageResponseResultObject);
                    }
                });

        appApis.getSerchHot(ApiHelper.getMobiApp(), ApiHelper.getBUILD(), 50, ApiHelper.getMobiApp(), ApiHelper.getPLATFORM(), DateUtil.getSystemTime())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResultObject<SearchHotResponse>>() {
                    @Override
                    public void call(ResultObject<SearchHotResponse> appSerchHotResponseResultObject) {
                        Log.d("misery", "appSerchHotResponseResultObject="+ appSerchHotResponseResultObject);
                    }
                });
    }
}
