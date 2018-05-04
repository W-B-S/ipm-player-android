package com.ipm.ipm.bean;

import com.ipm.ipm.adapter.cp.CpInfo;
import com.ipm.ipm.adapter.home.HomeInfo;

import java.util.List;

/**
 * Created by fanqilong on 2018/5/4.
 */

public class CpInfoResponse {

    private List<CpInfo> data;

    public List<CpInfo> getData() {
        return data;
    }

    public void setData(List<CpInfo> data) {
        this.data = data;
    }
}
