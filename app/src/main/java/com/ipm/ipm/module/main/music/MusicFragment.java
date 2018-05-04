package com.ipm.ipm.module.main.music;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ipm.ipm.R;
import com.ipm.ipm.base.BaseMvpFragment;
import com.ipm.ipm.base.adapter.CommonPagerAdapter;
import com.ipm.ipm.module.minecreate.MineCreateFragment;
import com.ipm.ipm.module.minefollow.MineFollowFragment;
import com.ipm.uilibrary.widget.NoScrollViewPager;

import java.util.ArrayList;

/**
 * 主界面 音乐
 */
public class MusicFragment extends BaseMvpFragment {


    private NoScrollViewPager viewPage;
    private TextView tv_mine_follow;
    private TextView tv_mine_create;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_music;
    }

    @Override
    protected void init() {
        viewPage = ((NoScrollViewPager) mRootView.findViewById(R.id.viewPage));
        tv_mine_create = ((TextView) mRootView.findViewById(R.id.tv_mine_create));
        tv_mine_follow = ((TextView) mRootView.findViewById(R.id.tv_mine_follow));

        ArrayList<BaseMvpFragment> fragments = new ArrayList<>();
        fragments.add(new MineCreateFragment());
        fragments.add(new MineFollowFragment());
        CommonPagerAdapter commonPagerAdapter = new CommonPagerAdapter(getChildFragmentManager(), fragments);
        viewPage.setAdapter(commonPagerAdapter);


        tv_mine_create.setOnClickListener(view -> {
            tv_mine_create.setTextColor(Color.parseColor("#212832"));
            tv_mine_follow.setTextColor(Color.parseColor("#A9B1BD"));
            viewPage.setCurrentItem(0);
        });

        tv_mine_follow.setOnClickListener(view -> {
            tv_mine_create.setTextColor(Color.parseColor("#A9B1BD"));
            tv_mine_follow.setTextColor(Color.parseColor("#212832"));
            viewPage.setCurrentItem(1);

        });
    }

}
