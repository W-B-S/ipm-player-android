package com.ipm.ipm.module.findcp.presenter;

import com.ipm.ipm.base.mvp.BaseContract;
import com.ipm.ipm.bean.CpInfoResponse;
import com.ipm.ipm.bean.HomeInfoResponse;

/**
 * Created by fanqilong on 2018/5/4.
 */

public interface FindCpContract {
    interface View extends BaseContract.BaseView{
        void onHomeListSuccess(CpInfoResponse cpInfoResponse);

        void onBannerSuccess();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T>{
        void requestHomeList();

        void requestBanner();
    }

}
