package com.ipm.ipm.adapter.cp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ipm.ipm.IPMApp;
import com.ipm.ipm.R;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by fanqilong on 2018/5/4.
 */

public class CpInfoItemViewBinder extends ItemViewBinder<CpInfo,CpInfoItemViewBinder.ViewHolder> {

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ViewHolder(inflater.inflate(R.layout.item_cp_info,parent,false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull CpInfo item) {
        Glide.with(holder.image.getContext()).load(IPMApp.map.get(item.getCover())).into(holder.image);
        holder.title.setText(item.getMusicName());
        holder.dec.setText(item.getDec());

    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView image;
        private final TextView title;
        private final TextView dec;

        public ViewHolder(View itemView) {
            super(itemView);

            image = ((ImageView) itemView.findViewById(R.id.image));
            title = ((TextView) itemView.findViewById(R.id.title));
            dec = ((TextView) itemView.findViewById(R.id.dec));
        }
    }
}
