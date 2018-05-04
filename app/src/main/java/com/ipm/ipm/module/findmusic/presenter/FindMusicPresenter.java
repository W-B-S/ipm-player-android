package com.ipm.ipm.module.findmusic.presenter;

import com.google.gson.Gson;
import com.ipm.ipm.IPMConfig;
import com.ipm.ipm.base.mvp.factory.BasePresenter;
import com.ipm.ipm.bean.HomeInfoResponse;

/**
 * Created by fanqilong on 2018/5/4.
 */

public class FindMusicPresenter extends BasePresenter<FindMusicContract.View> implements FindMusicContract.Presenter<FindMusicContract.View>{
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
