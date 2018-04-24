package com.ipm.ipm;

import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ipm.ipm.utils.FormatUtil;
import com.lzx.musiclibrary.aidl.listener.OnPlayerEventListener;
import com.lzx.musiclibrary.aidl.model.SongInfo;
import com.lzx.musiclibrary.manager.MusicManager;
import com.lzx.musiclibrary.manager.TimerTaskManager;

public class PlayActivity extends AppCompatActivity implements OnPlayerEventListener {

    private SeekBar mSeekBar;
    private ImageView mBtnPlayPause;
    private TextView mStartTime, mTotalTime;
    private TimerTaskManager mTimerTaskManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        mBtnPlayPause = findViewById(R.id.btn_play_pause);
        mSeekBar = findViewById(R.id.seekBar);
        mStartTime = findViewById(R.id.start_time);
        mTotalTime = findViewById(R.id.total_time);


        mTimerTaskManager = new TimerTaskManager();
        mTimerTaskManager.setUpdateProgressTask(this::updateProgress);


        MusicManager.get().addPlayerEventListener(this);



        mBtnPlayPause.setOnClickListener(v -> {
            if (MusicManager.isPlaying()) {
                MusicManager.get().pauseMusic();
            } else {
                SongInfo info = new SongInfo();
                info.setSongUrl("http://47.91.208.29:8080/ipfs/Qmd4o2RcvBJjUP7fffqNkwXa1NiBYJgzWN682AnSGyV1EB");
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


    }


    @Override
    public void onMusicSwitch(SongInfo songInfo) {

    }

    @Override
    public void onPlayerStart() {
        mBtnPlayPause.setImageResource(R.mipmap.ic_pause);

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
        mBtnPlayPause.setImageResource(R.mipmap.ic_play);
        mTimerTaskManager.stopSeekBarUpdate();
    }

    @Override
    public void onPlayCompletion() {
        mBtnPlayPause.setImageResource(R.mipmap.ic_play);
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
