package com.ipm.ipm.module.main.find.presenter;

import com.google.gson.Gson;
import com.ipm.ipm.IPMConfig;
import com.ipm.ipm.base.mvp.factory.BasePresenter;
import com.ipm.ipm.bean.HomeInfoResponse;

/**
 * Created by fanqilong on 2018/5/2.
 */

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter<HomeContract.View> {

    /**
     * 获取主页的数据
     */
    @Override
    public void requestHomeList() {
        Gson gson = new Gson();
        HomeInfoResponse homeInfo = gson.fromJson(IPMConfig.HOME_DATA, HomeInfoResponse.class);
        mView.onHomeListSuccess(homeInfo);

    }

    @Override
    public void requestBanner() {

    }
}
