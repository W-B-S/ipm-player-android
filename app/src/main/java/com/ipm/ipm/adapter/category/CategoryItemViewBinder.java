package com.ipm.ipm.adapter.category;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ipm.ipm.R;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by fanqilong on 2018/5/2.
 */

public class CategoryItemViewBinder extends ItemViewBinder<Category,CategoryItemViewBinder.ViewHolder> {


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ViewHolder(inflater.inflate(R.layout.item_category, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Category item) {
        holder.title.setText(item.getTitle());
        holder.more.setVisibility(item.isShowMore()?View.VISIBLE:View.INVISIBLE);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private @NonNull final TextView title;
        private final TextView more;


        ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            more = itemView.findViewById(R.id.more);
        }
    }
}
