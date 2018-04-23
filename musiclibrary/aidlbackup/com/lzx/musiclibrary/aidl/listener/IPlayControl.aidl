// IPlayControl.aidl
package com.lzx.musiclibrary.aidl.listener;

import com.lzx.musiclibrary.aidl.model.SongInfo;
import com.lzx.musiclibrary.notification.NotificationCreater;
import com.lzx.musiclibrary.aidl.listener.IOnPlayerEventListener;
import com.lzx.musiclibrary.aidl.listener.IOnTimerTaskListener;

interface IPlayControl {

    //播放，并设置播放列表
     void playMusic(in List<SongInfo> list, int index ,boolean isJustPlay);

    //根据音乐信息播放
     void playMusicByInfo(in SongInfo info,boolean isJustPlay);

    //根据索引播放
    void playMusicByIndex(int index,boolean isJustPlay);

    //设置定时时间
    void pausePlayInMillis(long time);

    //得到当前播放索引
    int getCurrPlayingIndex();

    //暂停
    void pauseMusic();

    //继续
    void resumeMusic();

    //停止音乐
    void stopMusic();

    //设置播放列表
    void setPlayList(in List<SongInfo> list);

    //设置播放列表
    void setPlayListWithIndex(in List<SongInfo> list,int index);

    //得到播放列表
    List<SongInfo> getPlayList();

    //从播放列表中删除一条信息
    void deleteSongInfoOnPlayList(in SongInfo info,boolean isNeedToPlayNext);

    //获取播放状态
    int getStatus();

    //播放下一首
    void playNext();

    //播放上一首
    void playPre();

    //是否有上一首
    boolean hasPre();

    //是否有下一首
    boolean hasNext();

    //得到上一首信息
    SongInfo getPreMusic();

    //得到下一首信息
    SongInfo getNextMusic();

    //得到当前播放信息
    SongInfo getCurrPlayingMusic();

    //设置当前音乐信息
    void setCurrMusic(int index);

    //设置播放模式
    void setPlayMode(int mode,boolean isSaveLocal);

    //得到播放模式
    int getPlayMode(boolean isGetLocal);

    //获取当前进度
    long getProgress();

    //定位到指定位置
    void seekTo(int position);

    //初始化
    void reset();

    //更新通知栏
    void updateNotificationCreater(in NotificationCreater creater);

    //更新通知栏喜欢/收藏按钮选中状态
    void updateNotificationFavorite(boolean isFavorite);

    //更新通知栏桌面歌词按钮选中状态
    void updateNotificationLyrics(boolean isChecked);

    //更新通知栏ContentIntent
    void updateNotificationContentIntent(in Bundle bundle, String targetClass);

    //注册一个播放状态监听器
    void registerPlayerEventListener(IOnPlayerEventListener listener);

    //解注册一个播放状态监听器
    void unregisterPlayerEventListener(IOnPlayerEventListener listener);

    //注册一个定时播放监听器
    void registerTimerTaskListener(IOnTimerTaskListener listener);

    //解注册一个定时播放监听器
    void unregisterTimerTaskListener(IOnTimerTaskListener listener);

}
