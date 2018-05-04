package com.ipm.ipm.module.main.find;


import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ipm.ipm.R;
import com.ipm.ipm.adapter.banner.BannerInfo;
import com.ipm.ipm.adapter.banner.BannerItemViewBinder;
import com.ipm.ipm.adapter.category.Category;
import com.ipm.ipm.adapter.category.CategoryItemViewBinder;
import com.ipm.ipm.adapter.home.HomeInfo;
import com.ipm.ipm.adapter.home.HomeInfoItemViewBinder;
import com.ipm.ipm.adapter.homebanner.HomeBanner;
import com.ipm.ipm.adapter.homebanner.HomeBannerItemViewBinder;
import com.ipm.ipm.base.BaseMvpFragment;
import com.ipm.ipm.base.adapter.CommonPagerAdapter;
import com.ipm.ipm.base.mvp.factory.CreatePresenter;
import com.ipm.ipm.bean.HomeInfoResponse;
import com.ipm.ipm.module.findcp.FindCpFragment;
import com.ipm.ipm.module.findmusic.FindMusicFragment;
import com.ipm.ipm.module.main.find.presenter.HomeContract;
import com.ipm.ipm.module.main.find.presenter.HomePresenter;
import com.ipm.ipm.widget.HomeSelectView;
import com.ipm.uilibrary.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * 主界面  发现
 */

public class FindFragment extends BaseMvpFragment {


    private HomeSelectView homeSelectView;
    private NoScrollViewPager viewPage;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find;
    }

    @Override
    protected void init() {

        homeSelectView = ((HomeSelectView) mRootView.findViewById(R.id.homeSelectView));
        viewPage = ((NoScrollViewPager) mRootView.findViewById(R.id.viewPage));


        ArrayList<BaseMvpFragment> fragments = new ArrayList<>();
        fragments.add(new FindMusicFragment());
        fragments.add(new FindCpFragment());
        CommonPagerAdapter commonPagerAdapter = new CommonPagerAdapter(getChildFragmentManager(), fragments);
        viewPage.setAdapter(commonPagerAdapter);


        homeSelectView.setHomeSelectListener(type -> viewPage.setCurrentItem(type));
    }
}
