package com.ipm.ipm.module.findcp.presenter;

import com.google.gson.Gson;
import com.ipm.ipm.IPMConfig;
import com.ipm.ipm.base.mvp.factory.BasePresenter;
import com.ipm.ipm.bean.CpInfoResponse;
import com.ipm.ipm.module.findmusic.presenter.FindMusicContract;

/**
 * Created by fanqilong on 2018/5/4.
 */

public class FindCpPresenter extends BasePresenter<FindCpContract.View> implements FindMusicContract.Presenter<FindCpContract.View> {


    @Override
    public void requestHomeList() {
        Gson gson = new Gson();
        CpInfoResponse cpInfoResponse = gson.fromJson(IPMConfig.CP_DATA, CpInfoResponse.class);
        mView.onHomeListSuccess(cpInfoResponse);
    }

    @Override
    public void requestBanner() {

    }
}
