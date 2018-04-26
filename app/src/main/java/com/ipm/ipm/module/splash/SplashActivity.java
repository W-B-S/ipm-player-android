package com.ipm.ipm.module.splash;

import android.content.Intent;
import android.os.Bundle;

import com.ipm.ipm.R;
import com.ipm.ipm.base.BaseMvpActivity;
import com.ipm.ipm.base.mvp.factory.CreatePresenter;
import com.ipm.ipm.module.main.MainActivity;
import com.ipm.ipm.module.splash.presenter.SplashContract;
import com.ipm.ipm.module.splash.presenter.SplashPresenter;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

@CreatePresenter(SplashPresenter.class)
public class SplashActivity extends BaseMvpActivity<SplashContract.View,SplashPresenter> implements SplashContract.View {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        Observable.timer(3000, TimeUnit.MILLISECONDS)
                .compose(bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> finishTask());
    }


    private void finishTask() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }



}
