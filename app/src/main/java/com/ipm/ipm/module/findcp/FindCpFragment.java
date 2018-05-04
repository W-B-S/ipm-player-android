package com.ipm.ipm.module.findcp;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ipm.ipm.R;
import com.ipm.ipm.adapter.banner.BannerInfo;
import com.ipm.ipm.adapter.banner.BannerItemViewBinder;
import com.ipm.ipm.adapter.cp.CpInfo;
import com.ipm.ipm.adapter.cp.CpInfoItemViewBinder;
import com.ipm.ipm.base.BaseMvpFragment;
import com.ipm.ipm.base.mvp.BaseContract;
import com.ipm.ipm.base.mvp.factory.CreatePresenter;
import com.ipm.ipm.bean.CpInfoResponse;
import com.ipm.ipm.module.findcp.presenter.FindCpContract;
import com.ipm.ipm.module.findcp.presenter.FindCpPresenter;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.MultiTypeAdapter;

/**
 * 发现厂牌
 */
@CreatePresenter(FindCpPresenter.class)
public class FindCpFragment extends BaseMvpFragment<FindCpContract.View,FindCpPresenter> implements FindCpContract.View {


    private RecyclerView recyclerView;
    private MultiTypeAdapter adapter;
    private List<Object> items;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find_cp;
    }

    @Override
    protected void init() {
        recyclerView = ((RecyclerView) mRootView.findViewById(R.id.recyclerView));

        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        adapter = new MultiTypeAdapter();

        adapter.register(BannerInfo.class,new BannerItemViewBinder());
        adapter.register(CpInfo.class,new CpInfoItemViewBinder());

        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                if (childAdapterPosition != 0){
                    if (childAdapterPosition == 1){
                        outRect.top = (int) mContext.getResources().getDimension(R.dimen.y26);
                    }
                    outRect.bottom = (int) mContext.getResources().getDimension(R.dimen.y26);
                    outRect.left = (int) mContext.getResources().getDimension(R.dimen.x32);
                    outRect.right = (int) mContext.getResources().getDimension(R.dimen.x32);
                }
            }
        });

        getPresenter().requestHomeList();

    }

    @Override
    public void onHomeListSuccess(CpInfoResponse cpInfoResponse) {
        items = new ArrayList<>();
        items.add(new BannerInfo());
        items.addAll(cpInfoResponse.getData());
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBannerSuccess() {

    }
}
