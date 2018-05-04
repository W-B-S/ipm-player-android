package com.ipm.ipm.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ipm.ipm.R;

/**
 * Created by fanqilong on 2018/5/4.
 */

public class HomeSelectView extends LinearLayout{

    private Context mContext;
    private TextView tv_music;
    private TextView tv_cp;

    private HomeSelectListener homeSelectListener;

    public void setHomeSelectListener(HomeSelectListener homeSelectListener) {
        this.homeSelectListener = homeSelectListener;
    }

    public HomeSelectView(Context context) {
        this(context,null);
    }

    public HomeSelectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public HomeSelectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;

        initView();
    }

    private void initView() {

        LayoutInflater.from(mContext).inflate(R.layout.view_home_select,this);

        tv_music = ((TextView) findViewById(R.id.tv_music));
        tv_cp = ((TextView) findViewById(R.id.tv_cp));

        tv_music.setOnClickListener(view -> {

            tv_cp.setTextSize(16);
            tv_cp.setTextColor(Color.parseColor("#A9B1BD"));
            tv_music.setTextSize(24);
            tv_music.setTextColor(Color.parseColor("#000000"));

            if (homeSelectListener!=null){
                homeSelectListener.select(0);
            }

        });

        tv_cp.setOnClickListener(view -> {

            tv_cp.setTextSize(24);
            tv_cp.setTextColor(Color.parseColor("#000000"));
            tv_music.setTextSize(16);
            tv_music.setTextColor(Color.parseColor("#A9B1BD"));
            if (homeSelectListener!=null){
                homeSelectListener.select(1);
            }
        });

    }

    public interface HomeSelectListener{
        void select(int type);
    }
}
