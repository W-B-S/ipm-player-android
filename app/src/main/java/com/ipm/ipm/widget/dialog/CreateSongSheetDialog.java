package com.ipm.ipm.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.ipm.ipm.R;
import com.ipm.uilibrary.DeviceUtils;

/**
 * Created by fanqilong on 2018/5/7.
 */

public class CreateSongSheetDialog extends LinearLayout {

    private Context mContext;
    private Dialog dialog;
    private LinearLayout ll_root;

    public CreateSongSheetDialog(Context context) {
        this(context,null);
    }

    public CreateSongSheetDialog(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CreateSongSheetDialog(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;
        initView();
    }

    private void initView() {

        LayoutInflater.from(mContext).inflate(R.layout.dialog_create_song_sheet,this);

        ll_root = ((LinearLayout) findViewById(R.id.ll_root));
        ll_root.setLayoutParams(new LinearLayout.LayoutParams((int) (DeviceUtils.getScreenWidth(mContext) * 0.88f), LinearLayout.LayoutParams.WRAP_CONTENT));

        dialog = new Dialog(mContext, R.style.AlertDialogStyle);
        dialog.setContentView(this);

        findViewById(R.id.cancel).setOnClickListener(view -> dialog.dismiss());
        findViewById(R.id.confirm).setOnClickListener(view -> dialog.dismiss());
    }


    public void show() {
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }
}
