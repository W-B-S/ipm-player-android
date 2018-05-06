package com.ipm.ipm.widget;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ipm.ipm.R;

/**
 * Created by fanqilong on 2018/5/7.
 */

public class CommTitleBar extends LinearLayout{

    private Context mContext;
    private RelativeLayout rl_left;
    private RelativeLayout rl_right;

    public CommTitleBar(Context context) {
        this(context,null);
    }

    public CommTitleBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CommTitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(mContext).inflate(R.layout.view_title_bar,this);

        rl_left = ((RelativeLayout) findViewById(R.id.rl_left));
        rl_right = ((RelativeLayout) findViewById(R.id.rl_right));


        rl_left.setOnClickListener(view -> {
            ((Activity) mContext).finish();
        });
    }
}
