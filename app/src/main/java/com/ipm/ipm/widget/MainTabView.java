package com.ipm.ipm.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ipm.ipm.R;

/**
 * Created by fanqilong on 2018/4/24.
 */

public class MainTabView extends LinearLayout implements View.OnClickListener {

    private Context mContext;
    private LinearLayout ll_find;
    private TextView tv_find;
    private ImageView iv_find;

    private LinearLayout ll_music;
    private ImageView iv_music;
    private TextView tv_music;

    private LinearLayout ll_mine;
    private ImageView iv_mine;
    private TextView tv_mine;
    int tempPos = -1;

    OnTabClickListener onTabClickListener;

    public OnTabClickListener getOnTabClickListener() {
        return onTabClickListener;
    }

    public void setOnTabClickListener(OnTabClickListener onTabClickListener) {
        this.onTabClickListener = onTabClickListener;
    }

    public MainTabView(Context context) {
        this(context,null);
    }

    public MainTabView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MainTabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    private void initView() {

        LayoutInflater.from(mContext).inflate(R.layout.view_main_tab,this);

        ll_find = findViewById(R.id.ll_find);
        iv_find = findViewById(R.id.iv_find);
        tv_find = findViewById(R.id.tv_find);

        ll_music = findViewById(R.id.ll_music);
        iv_music = findViewById(R.id.iv_music);
        tv_music = findViewById(R.id.tv_music);

        ll_mine = findViewById(R.id.ll_mine);
        iv_mine = findViewById(R.id.iv_mine);
        tv_mine = findViewById(R.id.tv_mine);

        ll_find.setOnClickListener(this);
        ll_music.setOnClickListener(this);
        ll_mine.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int tag = Integer.valueOf(((String) view.getTag()));
        if (tag==tempPos){
            return;
        }
        tempPos = tag;

        if (onTabClickListener!=null) {
            onTabClickListener.click(tag);
        }

        switch (view.getId()) {
            case R.id.ll_find:
                updateFind(true);
                updateMusic(false);
                updateMine(false);
                break;
            case R.id.ll_music:
                updateFind(false);
                updateMusic(true);
                updateMine(false);
                break;
            case R.id.ll_mine:
                updateFind(false);
                updateMusic(false);
                updateMine(true);
                break;
        }
    }

    private void updateMine(boolean b) {
        tv_mine.setSelected(b);
        iv_mine.setSelected(b);
    }

    private void updateMusic(boolean b) {
        tv_music.setSelected(b);
        iv_music.setSelected(b);
    }

    private void updateFind(boolean b) {
        tv_find.setSelected(b);
        iv_find.setSelected(b);
    }

    public void click(int pos){
        switch (pos) {
            case 0:
                onClick(ll_find);
                break;
            case 1:
                onClick(ll_music);
                break;
            case 2:
                onClick(ll_mine);
                break;
        }
    }


    public interface OnTabClickListener{
        void click(int pos);
    }


}
