package com.ipm.ipm.module.findmusic.presenter;

import com.ipm.ipm.base.mvp.BaseContract;
import com.ipm.ipm.bean.HomeInfoResponse;

/**
 * Created by fanqilong on 2018/5/4.
 */

public interface FindMusicContract {
    interface View extends BaseContract.BaseView{
        void onHomeListSuccess(HomeInfoResponse homeInfoList);

        void onBannerSuccess();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T>{
        void requestHomeList();

        void requestBanner();
    }
}
