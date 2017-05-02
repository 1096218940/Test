package com.ma.chasheng.chalutong.base;

/**
 * Created by Administrator on 2017/5/2 0002.
 */

public interface Presenter<V extends IBaseView>  {
    void attachView(V ibaseView);

    void detachView();
}
