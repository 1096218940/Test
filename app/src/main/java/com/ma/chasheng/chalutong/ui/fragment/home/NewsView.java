package com.ma.chasheng.chalutong.ui.fragment.home;

import com.ma.chasheng.chalutong.base.IBaseView;
import com.ma.chasheng.chalutong.model.News;

import java.util.List;

/**
 * Created by Administrator on 2017/5/2 0002.
 */

public interface NewsView extends IBaseView{

    void refresh(List<News.NewslistBean> data);

    void loadMore(List<News.NewslistBean> data);

}
