package com.ma.chasheng.chalutong.ui.fragment.message;

import com.ma.chasheng.chalutong.base.IBaseView;
import com.ma.chasheng.chalutong.model.GirlsEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/5/3 0003.
 */

public interface MessageView extends IBaseView {
    void refresh(List<GirlsEntity.ResultsBean> data);

    void loadMore(List<GirlsEntity.ResultsBean> data);
}
