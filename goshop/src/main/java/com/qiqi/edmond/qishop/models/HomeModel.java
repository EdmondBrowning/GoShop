package com.qiqi.edmond.qishop.models;

import com.qiqi.edmond.qishop.models.base.BaseModel;
import com.qiqi.edmond.qishop.interfaces.mvp.models.HomeModelInterface;
import com.qiqi.edmond.qishop.presenters.HomePresenter;
import com.qiqi.edmond.qishop.utils.HomeInfo;
import com.qiqi.edmond.qishop.utils.HomeData;
import com.qiqi.xznview.layout.XZBannerLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edmond on 17-1-15.
 */

public class HomeModel extends BaseModel<HomeData> implements HomeModelInterface {

    @Override
    public void init(HomePresenter presenter) {
        List<XZBannerLayout.Banner> banners = new ArrayList<>();
        getData().getBannerList().add(new XZBannerLayout.Banner("http://tupian.enterdesk.com/2013/xll/012/04/8/6.jpg","1"));
        getData().getBannerList().add(new XZBannerLayout.Banner("http://pic6.wed114.cn/20151223/2015122318595259952168.jpg","2"));
        getData().getBannerList().add(new XZBannerLayout.Banner("http://img1.3lian.com/2015/a1/124/d/178.jpg","3"));
        getData().getBannerList().add(new XZBannerLayout.Banner("http://g.hiphotos.baidu.com/zhidao/pic/item/79f0f736afc37931748bca84e9c4b74542a911bf.jpg","4"));
        getData().getBannerList().add(new XZBannerLayout.Banner("http://pic1.5442.com/2015/0624/16/02.jpg","5"));

        getData().getInfoList().add(new HomeInfo("不知道叫什么",0,"http://tupian.enterdesk.com/2013/xll/012/04/8/6.jpg","我要有"));
        getData().getInfoList().add(new HomeInfo("随便取一个",0,"http://i0.hdslb.com/bfs/archive/0a12c4acc4f510a5d1a1fa2fd2d620dba134e747.jpg","瀑布流的效果所以着一个要长一点"));
        getData().getInfoList().add(new HomeInfo("啦啦",0,"http://pic6.wed114.cn/20151223/2015122318595259952168.jpg","这个"));
        getData().getInfoList().add(new HomeInfo("哈哈",0,"http://tupian.enterdesk.com/2013/xll/012/04/8/6.jpg","端一点"));
        getData().getInfoList().add(new HomeInfo("可怜",0,"http://img34.ddimg.cn/imgother1/16/27/23325604_1255096.jpg","没有什么大的关系反正只要有换行就好"));
        getData().getInfoList().add(new HomeInfo("要死要死要死",0,"http://file.cbda.cn/uploadfile/2015/1019/20151019110236512.jpg","哈哈"));
        getData().getInfoList().add(new HomeInfo("阿阿阿",0,"http://p5.yokacdn.com/pic/digital/visual/2014/U461P41T8D377090F231DT20141028165028_maxw808.jpg","我想这样应该没有什么太大的"));
        getData().getInfoList().add(new HomeInfo("去吧皮卡秋",0,"http://tupian.enterdesk.com/2013/xll/012/04/8/6.jpg","问题了把"));
        getData().getInfoList().add(new HomeInfo("想不出来了",0,"http://img4.duitang.com/uploads/blog/201311/06/20131106120932_L3FGY.jpeg","还有最后几个坚持以下"));
        getData().getInfoList().add(new HomeInfo("好痛苦",0,"http://g.hiphotos.baidu.com/zhidao/pic/item/79f0f736afc37931748bca84e9c4b74542a911bf.jpg","造造完"));
        getData().getInfoList().add(new HomeInfo("谁来帮帮我",0,"http://pic1.5442.com/2015/0624/16/02.jpg","好的"));

        getData().setContentUImageUrl("http://img4.duitang.com/uploads/blog/201311/06/20131106120932_L3FGY.jpeg");

        presenter.inited(getData());
    }

    @Override
    public void refresh(HomePresenter presenter) {
        presenter.refreshed(getData());
    }

    @Override
    public void loadMore(HomePresenter presenter) {
        List<HomeInfo>homeInfos = new ArrayList<>();
        homeInfos.add(new HomeInfo());
        homeInfos.add(new HomeInfo());
        homeInfos.add(new HomeInfo());
        homeInfos.add(new HomeInfo());
        homeInfos.add(new HomeInfo());
        homeInfos.add(new HomeInfo());
        getData().getInfoList().addAll(homeInfos);
        presenter.loadMored(homeInfos);
    }
}
