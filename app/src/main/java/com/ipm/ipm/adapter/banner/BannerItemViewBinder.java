package com.ipm.ipm.adapter.banner;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ipm.ipm.R;
import com.ipm.ipm.widget.banner.BannerLayout;

import java.util.ArrayList;
import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by fanqilong on 2018/5/2.
 */

public class BannerItemViewBinder extends ItemViewBinder<BannerInfo,BannerItemViewBinder.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ViewHolder(inflater.inflate(R.layout.item_banner,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull BannerInfo item) {
        List<String> list = new ArrayList<>();
        list.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2295583836,996934370&fm=27&gp=0.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1518587106405&di=8fee364fdd8871d7153fbfed61d236cc&imgtype=0&src=http%3A%2F%2Fimg1.gamersky.com%2Fimage2011%2F12%2F20111215m_2%2F07.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1518586528124&di=e72fda209f90417ff1d97943bc9b975c&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fe4dde71190ef76c63d4029ff9716fdfaae516750.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1518586548211&di=02a1d29c756e05e3f66f99b53c7a944c&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F908fa0ec08fa513da483f08a3b6d55fbb2fbd9bd.jpg");
        holder.bannerLayout.initBannerImageView(list);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private final BannerLayout bannerLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            bannerLayout = ((BannerLayout) itemView.findViewById(R.id.banner_layout));
        }
    }
}
