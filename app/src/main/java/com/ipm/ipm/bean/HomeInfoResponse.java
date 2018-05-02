package com.ipm.ipm.bean;

import com.ipm.ipm.adapter.home.HomeInfo;

import java.util.List;

/**
 * Created by fanqilong on 2018/5/2.
 */

public class HomeInfoResponse {


    private List<HomeInfo> data;

    public List<HomeInfo> getData() {
        return data;
    }

    public void setData(List<HomeInfo> data) {
        this.data = data;
    }

}
