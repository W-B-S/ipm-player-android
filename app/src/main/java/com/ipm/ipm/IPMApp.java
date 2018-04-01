package com.ipm.ipm;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;

import com.lzx.musiclibrary.manager.MusicManager;
import com.lzx.musiclibrary.notification.NotificationCreater;
import com.lzx.musiclibrary.utils.BaseUtil;

/**
 * Created by fanqilong on 2018/4/1.
 */

public class IPMApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (!BaseUtil.getCurProcessName(this).contains(":musicLibrary")) {
            MusicManager.get()
                    .setContext(this)
                    .init();
        }

    }

}
