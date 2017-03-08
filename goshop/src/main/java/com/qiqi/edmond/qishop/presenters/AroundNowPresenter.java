package com.qiqi.edmond.qishop.presenters;

import com.qiqi.edmond.qishop.fragments.AroundNowFragment;
import com.qiqi.edmond.qishop.models.AroundNowModel;
import com.qiqi.edmond.qishop.presenters.base.BasePresenter;
import com.qiqi.edmond.qishop.interfaces.mvp.presenters.AroundNowPresenterInterface;
import com.qiqi.edmond.qishop.utils.AroundNowInfo;
import com.qiqi.edmond.qishop.utils.AroundNowData;

import java.util.List;

/**
 * Created by edmond on 17-2-21.
 */

public class AroundNowPresenter extends BasePresenter<AroundNowFragment,AroundNowModel> implements AroundNowPresenterInterface {
    public AroundNowPresenter(AroundNowFragment view) {
        super(view);
    }

    @Override
    public void initing() {
        getView().initing();
        getModel().init(this);
    }

    @Override
    public void inited(AroundNowData result) {
        getView().inited(result);
    }

    @Override
    public void refreshing() {
        getView().refreshing();
        getModel().refresh(this);
    }

    @Override
    public void refreshed(AroundNowData result) {
        getView().refreshed(result);
    }

    @Override
    public void loadMoring() {
        getView().loadMoring();
        getModel().loadMore(this);
    }

    @Override
    public void loadMored(List<AroundNowInfo> result) {
        getView().loadMored(result);
    }
}
