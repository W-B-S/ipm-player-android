package com.ipm.ipm.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ipm.ipm.R;
import com.ipm.uilibrary.DeviceUtils;
import com.ipm.uilibrary.ToastUtil;

/**
 * Created by fanqilong on 2018/5/4.
 *
 */

public class ShareDialog extends LinearLayout implements View.OnClickListener {

    private Context mContext;
    private LinearLayout ll_root;
    private LinearLayout ll_copy_link;
    private TextView tv_cancel;
    private LinearLayout ll_qq;
    private LinearLayout ll_qzone;
    private LinearLayout ll_weibo;
    private LinearLayout ll_friend;
    private LinearLayout ll_weChat;
    private Dialog dialog;

    public ShareDialog(Context context) {
        this(context,null);
    }

    public ShareDialog(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ShareDialog(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;

        initView();
    }

    private void initView() {
        LayoutInflater.from(mContext).inflate(R.layout.dialog_share,this);

        ll_root = ((LinearLayout) findViewById(R.id.ll_root));
        ll_weChat = ((LinearLayout) findViewById(R.id.ll_weChat));
        ll_friend = ((LinearLayout) findViewById(R.id.ll_friend));
        ll_weibo = ((LinearLayout) findViewById(R.id.ll_weibo));
        ll_qzone = ((LinearLayout) findViewById(R.id.ll_qzone));
        ll_qq = ((LinearLayout) findViewById(R.id.ll_qq));
        ll_copy_link = ((LinearLayout) findViewById(R.id.ll_copy_link));
        tv_cancel = ((TextView) findViewById(R.id.tv_cancel));

        dialog = new Dialog(mContext, R.style.ActionSheetDialogStyle);
        dialog.setContentView(this);

        Window dialogWindow = dialog.getWindow();
        assert dialogWindow != null;
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.x = 0;
        lp.y = 0;
        dialogWindow.setAttributes(lp);

        ll_root.setMinimumWidth(DeviceUtils.getScreenWidth(mContext));




        ll_weChat.setOnClickListener(this);
        ll_friend.setOnClickListener(this);
        ll_qq.setOnClickListener(this);
        ll_qzone.setOnClickListener(this);
        ll_weibo.setOnClickListener(this);
        tv_cancel.setOnClickListener(this);
    }

    public void show() {
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_weChat:
                ToastUtil.showShort(mContext, "分享到微信");
                break;
            case R.id.ll_friend:
                ToastUtil.showShort(mContext, "分享到朋友圈");
                break;
            case R.id.ll_qq:
                ToastUtil.showShort(mContext, "分享到QQ");
                break;
            case R.id.ll_qzone:
                ToastUtil.showShort(mContext, "分享到QQ空间");
                break;
            case R.id.ll_weibo:
                ToastUtil.showShort(mContext, "分享到微博");
                break;
            case R.id.tv_cancel:
                //dialog.dismiss();
                break;
        }

        dialog.dismiss();
    }
}
