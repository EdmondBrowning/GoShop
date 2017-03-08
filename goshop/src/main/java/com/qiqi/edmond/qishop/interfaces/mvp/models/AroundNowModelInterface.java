package com.qiqi.edmond.qishop.interfaces.mvp.models;

import com.qiqi.edmond.qishop.presenters.AroundNowPresenter;
import com.qiqi.edmond.qishop.presenters.HomePresenter;

/**
 * Created by edmond on 17-2-21.
 */

public interface AroundNowModelInterface {
    void init(AroundNowPresenter presenter);
    void refresh(AroundNowPresenter presenter);
    void loadMore(AroundNowPresenter presenter);
}
