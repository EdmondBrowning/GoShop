package com.qiqi.edmond.qishop.presenters;

import com.qiqi.edmond.qishop.fragments.ShoppingCartFragment;
import com.qiqi.edmond.qishop.models.ShoppingCartModel;
import com.qiqi.edmond.qishop.presenters.base.BasePresenter;
import com.qiqi.edmond.qishop.interfaces.mvp.presenters.ShoppingCartPresenterInterface;
import com.qiqi.edmond.qishop.utils.ShoppingCartData;

/**
 * Created by edmond on 17-2-25.
 */

public class ShoppingCartPresenter extends BasePresenter<ShoppingCartFragment,ShoppingCartModel> implements ShoppingCartPresenterInterface {
    public ShoppingCartPresenter(ShoppingCartFragment view) {
        super(view);
    }

    @Override
    public void initing() {
        getView().initing();
        getModel().init(this);
    }

    @Override
    public void inited(ShoppingCartData result) {
        getView().inited(result);
    }

    @Override
    public void refreshing() {
        getView().refreshing();
        getModel().refresh(this);
    }

    @Override
    public void refreshed(ShoppingCartData result) {
        getView().refreshed(result);
    }
}
