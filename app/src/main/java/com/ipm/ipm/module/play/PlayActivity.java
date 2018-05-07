package com.ipm.ipm.module.play;

import android.os.RemoteException;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.ipm.ipm.IPMApp;
import com.ipm.ipm.R;
import com.ipm.ipm.adapter.home.HomeInfo;
import com.ipm.ipm.base.BaseMvpActivity;
import com.ipm.ipm.utils.FormatUtil;
import com.ipm.ipm.widget.CircleImageView;
import com.ipm.ipm.widget.dialog.CreateSongSheetDialog;
import com.ipm.ipm.widget.dialog.DaBangDialog;
import com.ipm.ipm.widget.dialog.ShareDialog;
import com.lzx.musiclibrary.aidl.listener.OnPlayerEventListener;
import com.lzx.musiclibrary.aidl.model.SongInfo;
import com.lzx.musiclibrary.manager.MusicManager;
import com.lzx.musiclibrary.manager.TimerTaskManager;


public class PlayActivity extends BaseMvpActivity implements OnPlayerEventListener {

    private SeekBar mSeekBar;
    private ImageView mBtnPlayPause;
    private TextView mStartTime, mTotalTime;
    private TimerTaskManager mTimerTaskManager;
    private HomeInfo homeInfo;
    private CircleImageView music_cover;
    private TextView song_name;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_player;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        mBtnPlayPause = findViewById(R.id.btn_play_pause);
        mSeekBar = findViewById(R.id.seekBar);
        mStartTime = findViewById(R.id.start_time);
        mTotalTime = findViewById(R.id.total_time);
        music_cover = ((CircleImageView) findViewById(R.id.music_cover));
        song_name = ((TextView) findViewById(R.id.song_name));


        mTimerTaskManager = new TimerTaskManager();
        mTimerTaskManager.setUpdateProgressTask(this::updateProgress);


        MusicManager.get().addPlayerEventListener(this);

        homeInfo = (HomeInfo) getIntent().getSerializableExtra("info");
        Glide.with(mContext).load(IPMApp.map.get(homeInfo.getCover())).into(music_cover);
        song_name.setText(homeInfo.getSinger());

        mBtnPlayPause.setOnClickListener(v -> {
            if (MusicManager.isPlaying()) {
                MusicManager.get().pauseMusic();
            } else {
                SongInfo info = new SongInfo();
                info.setSongUrl("http://47.91.208.29:8080/ipfs/" + homeInfo.getUrl());
                MusicManager.get().playMusicByInfo(info);
            }
        });

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                MusicManager.get().seekTo(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        SongInfo info = new SongInfo();
        info.setSongId(homeInfo.getUrl());
        info.setSongUrl("http://47.91.208.29:8080/ipfs/" + homeInfo.getUrl());
        MusicManager.get().playMusicByInfo(info);

        findViewById(R.id.iv_share).setOnClickListener(view -> {
            ShareDialog shareDialog = new ShareDialog(mContext);
            shareDialog.show();
        });

        findViewById(R.id.iv_dabang).setOnClickListener(view -> {
            DaBangDialog daBangDialog = new DaBangDialog(mContext);
            daBangDialog.show();
        });

        findViewById(R.id.iv_create_song_sheet).setOnClickListener(view -> {
            CreateSongSheetDialog createSongSheetDialog = new CreateSongSheetDialog(mContext);
            createSongSheetDialog.show();
        });
    }


    @Override
    public void onMusicSwitch(SongInfo songInfo) {

    }

    @Override
    public void onPlayerStart() {
        mBtnPlayPause.setImageResource(R.drawable.pause_ic);

        mTimerTaskManager.scheduleSeekBarUpdate();
        try {
            int duration = MusicManager.get().getDuration();
            mSeekBar.setMax(duration);
            mTotalTime.setText(FormatUtil.formatMusicTime(duration));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPlayerPause() {
        mBtnPlayPause.setImageResource(R.drawable.play_ic);
        mTimerTaskManager.stopSeekBarUpdate();
    }

    @Override
    public void onPlayCompletion() {
        mBtnPlayPause.setImageResource(R.drawable.play_ic);
        mSeekBar.setProgress(0);
        mStartTime.setText("00:00");
    }

    @Override
    public void onError(String s) {
        Toast.makeText(PlayActivity.this, "播放失败", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBuffering(boolean b) {

    }


    /**
     * 更新进度
     */
    private void updateProgress() {
        long progress = MusicManager.get().getProgress();
        mSeekBar.setProgress((int) progress);
        mStartTime.setText(FormatUtil.formatMusicTime(progress));
//        if (lrcList != null && lrcList.size() > 0) {
//            mTextLyrics.setText(getLrc(progress));
//        }
    }
}
