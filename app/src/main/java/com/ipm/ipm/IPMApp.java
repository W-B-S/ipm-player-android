package com.ipm.ipm;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;

import com.lzx.musiclibrary.manager.MusicManager;
import com.lzx.musiclibrary.notification.NotificationCreater;
import com.lzx.musiclibrary.utils.BaseUtil;

import java.util.HashMap;

/**
 * Created by fanqilong on 2018/4/1.
 */

public class IPMApp extends Application {

    public static HashMap<String,Integer> map = new HashMap<>();

    @Override
    public void onCreate() {
        super.onCreate();

        if (!BaseUtil.getCurProcessName(this).contains(":musicLibrary")) {
            MusicManager.get()
                    .setContext(this)
                    .init();
        }


        map.put("jiangdangbafang.jpg",R.drawable.z_jiangdangbafang);
        map.put("huawu_cover.jpg",R.drawable.z_huawu);
        map.put("bygbrdccfzj.jpg",R.drawable.z_bygbrdccfzj);
        map.put("jncjydhj.jpg",R.drawable.z_jncjydhj);
        map.put("qipa.jpg",R.drawable.z_qipa);
        map.put("tjps.jpg",R.drawable.z_tjps);
    }

}
