package com.ipm.ipm.adapter.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ipm.ipm.R;

import java.util.Collections;
import java.util.HashMap;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by fanqilong on 2018/5/2.
 */

public class HomeInfoItemViewBinder extends ItemViewBinder<HomeInfo,HomeInfoItemViewBinder.ViewHolder> {

    private static HashMap<String,Integer> map = new HashMap<>();

    @Override
    protected void onViewAttachedToWindow(@NonNull ViewHolder holder) {
        super.onViewAttachedToWindow(holder);

    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        map.put("jiangdangbafang.jpg",R.drawable.z_jiangdangbafang);
        map.put("huawu_cover.jpg",R.drawable.z_huawu);
        map.put("bygbrdccfzj.jpg",R.drawable.z_bygbrdccfzj);
        map.put("jncjydhj.jpg",R.drawable.z_jncjydhj);
        map.put("qipa.jp",R.drawable.z_qipa);
        map.put("tjps.jpg",R.drawable.z_tjps);

        return new ViewHolder(inflater.inflate(R.layout.item_home_info,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull HomeInfo item) {
        //holder.image
        Context context = holder.image.getContext();
        Glide.with(context).load(map.get(item.getCover())).into(holder.image);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            image = ((ImageView) itemView.findViewById(R.id.image));
        }
    }
}
