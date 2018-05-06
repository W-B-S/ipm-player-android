package com.ipm.ipm.module.main.mine;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ipm.ipm.R;
import com.ipm.ipm.base.BaseMvpFragment;
import com.ipm.ipm.widget.dialog.ShareDialog;

/**
 * 主界面  账号
 */
public class MineFragment extends BaseMvpFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void init() {
        mRootView.findViewById(R.id.rl_share).setOnClickListener(view -> {
            ShareDialog shareDialog = new ShareDialog(mContext);
            shareDialog.show();
        });

        mRootView.findViewById(R.id.rl_jifen).setOnClickListener(view -> {

        });

        mRootView.findViewById(R.id.rl_setting).setOnClickListener(view -> {

        });
        mRootView.findViewById(R.id.rl_about).setOnClickListener(view -> {

        });
    }

}
