package com.qiqi.edmond.qishop.models;

import com.qiqi.edmond.qishop.interfaces.mvp.models.MineModelInterface;
import com.qiqi.edmond.qishop.models.base.BaseModel;
import com.qiqi.edmond.qishop.presenters.MinePresenter;
import com.qiqi.edmond.qishop.utils.MineData;

/**
 * Created by edmond on 17-2-20.
 */

public class MineModel extends BaseModel<MineData> implements MineModelInterface {
    @Override
    public void init(MinePresenter presenter) {
        getData().setLevel(1);
        getData().setLevelNumber(50);
        getData().setName("Edmond");
        getData().setOrderNumber(1);
        getData().setWriteNumber(3);
        getData().setTransitNumber(1);
        getData().setLivingNumber(1);
        getData().setLogoUrl("http://www.qqpk.cn/Article/UploadFiles/201212/20121207103308720.jpg");
        presenter.inited(getData());
    }

    @Override
    public void refresh(MinePresenter presenter) {
        presenter.refreshed(getData());
    }
}
