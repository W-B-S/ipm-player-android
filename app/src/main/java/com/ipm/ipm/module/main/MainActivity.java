package com.ipm.ipm.module.main;

import android.os.Bundle;

import com.ipm.ipm.R;
import com.ipm.ipm.base.BaseMvpActivity;
import com.ipm.ipm.base.BaseMvpFragment;
import com.ipm.ipm.base.adapter.CommonPagerAdapter;
import com.ipm.ipm.base.mvp.BaseContract;
import com.ipm.ipm.base.mvp.factory.CreatePresenter;
import com.ipm.ipm.module.main.find.FindFragment;
import com.ipm.ipm.module.main.mine.MineFragment;
import com.ipm.ipm.module.main.music.MusicFragment;
import com.ipm.ipm.widget.MainTabView;
import com.ipm.uilibrary.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends BaseMvpActivity {

    private NoScrollViewPager viewPage;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        MainTabView mainTab = findViewById(R.id.mainTab);
        viewPage = findViewById(R.id.viewPage);

        List<BaseMvpFragment> fragments = new ArrayList<>();
        fragments.add(new FindFragment());
        fragments.add(new MusicFragment());
        fragments.add(new MineFragment());

        viewPage.setAdapter(new CommonPagerAdapter(getSupportFragmentManager(), fragments));

        viewPage.setOffscreenPageLimit(3);
        mainTab.setOnTabClickListener(pos -> viewPage.setCurrentItem(pos));
        mainTab.click(0);




    }


}
