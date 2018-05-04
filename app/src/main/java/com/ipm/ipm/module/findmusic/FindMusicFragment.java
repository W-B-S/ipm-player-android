package com.ipm.ipm.module.findmusic;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import com.ipm.ipm.base.mvp.factory.CreatePresenter;
import com.ipm.ipm.bean.HomeInfoResponse;
import com.ipm.ipm.module.findmusic.presenter.FindMusicContract;
import com.ipm.ipm.module.findmusic.presenter.FindMusicPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * 发现 music
 */
@CreatePresenter(FindMusicPresenter.class)
public class FindMusicFragment extends BaseMvpFragment<FindMusicContract.View,FindMusicPresenter> implements FindMusicContract.View {
    private static final int SPAN_COUNT = 3;

    private RecyclerView recyclerView;
    private MultiTypeAdapter adapter;
    private List<Object> items;
    private int x32;
    private int x5;
    private int y20;

    List<Integer> lefts = Arrays.asList(2,5,10,13,18,21,26,29,34,37);
    List<Integer> rights = Arrays.asList(4,7,12,15,20,23,28,31,36,39);
    List<Integer> mids = Arrays.asList(3,6,11,14,19,22,27,30,35,38);

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find_music;
    }

    @Override
    protected void init() {
        recyclerView = ((RecyclerView) mRootView.findViewById(R.id.recyclerView));


        adapter = new MultiTypeAdapter();
        adapter.register(Category.class, new CategoryItemViewBinder());
        adapter.register(BannerInfo.class,new BannerItemViewBinder());
        adapter.register(HomeInfo.class,new HomeInfoItemViewBinder());
        adapter.register(HomeBanner.class,new HomeBannerItemViewBinder());

        GridLayoutManager layout = new GridLayoutManager(mContext, SPAN_COUNT);
        layout.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return items.get(position) instanceof Category || items.get(position) instanceof BannerInfo || items.get(position) instanceof HomeBanner ? SPAN_COUNT : 1;
            }
        });
        x32 = (int) getResources().getDimension(R.dimen.x32);
        x5 = (int) getResources().getDimension(R.dimen.x5);
        y20 = (int) getResources().getDimension(R.dimen.y20);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                if (lefts.contains(childAdapterPosition)){
                    outRect.left = x32;
                    outRect.right = x5;
                    outRect.top = y20;
                }
                if (rights.contains(childAdapterPosition)){
                    outRect.right = x32;
                    outRect.left = x5;
                    outRect.top = y20;
                }
                if (mids.contains(childAdapterPosition)){
                    outRect.right = x5;
                    outRect.left = x5;
                    outRect.top = y20;
                }

            }
        });
        recyclerView.setLayoutManager(layout);

        recyclerView.setAdapter(adapter);


        getPresenter().requestHomeList();
        getPresenter().requestBanner();
    }

    @Override
    public void onHomeListSuccess(HomeInfoResponse homeInfoList) {
        List<HomeInfo> data = homeInfoList.getData();

        items = new ArrayList<>();
        items.add(new BannerInfo());
        items.add(new Category("推荐歌单", false));
        items.addAll(data);
        items.add(new HomeBanner());
        items.add(new Category("最热歌单", true));
        items.addAll(data);
        items.add(new HomeBanner());
        items.add(new Category("推荐单曲", true));
        items.addAll(data);
        items.add(new HomeBanner());
        items.add(new Category("最热歌曲", true));
        items.addAll(data);
        items.add(new HomeBanner());
        items.add(new Category("有声读物", true));
        items.addAll(data);
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBannerSuccess() {

    }
}
