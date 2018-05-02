package com.ipm.ipm.module.main.find;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ipm.ipm.R;
import com.ipm.ipm.adapter.banner.BannerInfo;
import com.ipm.ipm.adapter.banner.BannerItemViewBinder;
import com.ipm.ipm.adapter.category.Category;
import com.ipm.ipm.adapter.category.CategoryItemViewBinder;
import com.ipm.ipm.adapter.home.HomeInfo;
import com.ipm.ipm.adapter.home.HomeInfoItemViewBinder;
import com.ipm.ipm.base.BaseMvpFragment;
import com.ipm.ipm.base.mvp.factory.CreatePresenter;
import com.ipm.ipm.bean.HomeInfoResponse;
import com.ipm.ipm.module.main.find.presenter.HomeContract;
import com.ipm.ipm.module.main.find.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * 主界面  发现
 */
@CreatePresenter(HomePresenter.class)
public class FindFragment extends BaseMvpFragment<HomeContract.View, HomePresenter> implements HomeContract.View {
    private static final int SPAN_COUNT = 3;

    private RecyclerView recyclerView;
    private MultiTypeAdapter adapter;
    private List<Object> items;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find;
    }

    @Override
    protected void init() {
        recyclerView = ((RecyclerView) mRootView.findViewById(R.id.recyclerView));


        adapter = new MultiTypeAdapter();
        adapter.register(Category.class, new CategoryItemViewBinder());
        adapter.register(BannerInfo.class,new BannerItemViewBinder());
        adapter.register(HomeInfo.class,new HomeInfoItemViewBinder());

        GridLayoutManager layout = new GridLayoutManager(mContext, SPAN_COUNT);
        layout.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return items.get(position) instanceof Category || items.get(position) instanceof BannerInfo ? SPAN_COUNT : 1;
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
        items.add(new Category("最热歌单", true));
        items.addAll(data);
        items.add(new Category("推荐单曲", true));
        items.addAll(data);
        items.add(new Category("最热歌曲", true));
        items.addAll(data);
        items.add(new Category("有声读物", true));
        items.addAll(data);
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBannerSuccess() {

    }
}
