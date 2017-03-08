package com.qiqi.edmond.qishop.interfaces.mvp.views;

import com.qiqi.edmond.qishop.utils.AroundNowInfo;
import com.qiqi.edmond.qishop.utils.AroundNowData;

import java.util.List;

/**
 * Created by edmond on 17-2-21.
 */

public interface AroundNowViewInterface {
    void initing();
    void inited(AroundNowData result);

    void refreshing();
    void refreshed(AroundNowData result);

    void loadMoring();
    void loadMored(List<AroundNowInfo> result);
}
