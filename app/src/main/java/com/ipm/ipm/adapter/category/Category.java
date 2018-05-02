package com.ipm.ipm.adapter.category;

import android.support.annotation.NonNull;

/**
 * Created by fanqilong on 2018/5/2.
 */

public class Category {
    private String title;

    private boolean showMore;

    public Category(@NonNull String title, boolean showMore) {
        this.title = title;
        this.showMore = showMore;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isShowMore() {
        return showMore;
    }

    public void setShowMore(boolean showMore) {
        this.showMore = showMore;
    }
}
