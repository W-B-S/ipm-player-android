package com.ipm.ipm.adapter.homebanner;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ipm.ipm.R;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by fanqilong on 2018/5/4.
 */

public class HomeBannerItemViewBinder extends ItemViewBinder<HomeBanner,HomeBannerItemViewBinder.ViewHolder> {



    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ViewHolder(inflater.inflate(R.layout.item_home_banner,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull HomeBanner item) {
        Glide.with(holder.image.getContext()).load(R.drawable.homebannerpic).into(holder.image);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private final ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            image = ((ImageView) itemView.findViewById(R.id.image));
        }
    }
}
