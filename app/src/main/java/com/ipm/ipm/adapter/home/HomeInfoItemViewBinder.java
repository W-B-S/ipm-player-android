package com.ipm.ipm.adapter.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ipm.ipm.IPMApp;
import com.ipm.ipm.R;
import com.ipm.ipm.module.play.PlayActivity;

import java.util.HashMap;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by fanqilong on 2018/5/2.
 */

public class HomeInfoItemViewBinder extends ItemViewBinder<HomeInfo, HomeInfoItemViewBinder.ViewHolder> {


    @Override
    protected void onViewAttachedToWindow(@NonNull ViewHolder holder) {
        super.onViewAttachedToWindow(holder);

    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ViewHolder(inflater.inflate(R.layout.item_home_info, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull HomeInfo item) {
        //holder.image
        Context context = holder.image.getContext();
        Glide.with(context).load(IPMApp.map.get(item.getCover())).into(holder.image);

        holder.image.setOnClickListener(view -> {
            Intent intent = new Intent(context, PlayActivity.class);
            intent.putExtra("info", item);
            context.startActivity(intent);
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView image;

        ViewHolder(View itemView) {
            super(itemView);
            image = ((ImageView) itemView.findViewById(R.id.image));

        }
    }
}
