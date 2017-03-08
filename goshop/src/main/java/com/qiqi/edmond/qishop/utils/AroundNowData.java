package com.qiqi.edmond.qishop.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edmond on 17-1-25.
 */

public class AroundNowData {
    private String lastId;
    private List<AroundNowInfo> aroundNowInfos = new ArrayList<>();

    public void setAroundNowInfos(List<AroundNowInfo> aroundNowInfos) {
        this.aroundNowInfos = aroundNowInfos;
    }

    public void setLastId(String lastId) {
        this.lastId = lastId;
    }

    public List<AroundNowInfo> getAroundNowInfos() {
        return aroundNowInfos;
    }

    public String getLastId() {
        return lastId;
    }
}
