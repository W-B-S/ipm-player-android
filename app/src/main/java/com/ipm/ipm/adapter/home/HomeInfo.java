package com.ipm.ipm.adapter.home;

import java.io.Serializable;

/**
 * Created by fanqilong on 2018/5/2.
 */

public class HomeInfo implements Serializable {

    private String musicName;
    private String singer;
    private String cover;
    private String url;

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
