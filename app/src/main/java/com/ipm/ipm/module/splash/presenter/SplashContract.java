package com.ipm.ipm.module.splash.presenter;

import com.ipm.ipm.base.mvp.BaseContract;

/**
 * Created by fanqilong on 2018/4/24.
 */

public interface SplashContract {
    interface View extends BaseContract.BaseView{
//        void requestMainDataSuccess(boolean hasCache);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T>{
//        void requestMusicList();
    }
}
