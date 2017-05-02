package com.ma.chasheng.chalutong.base;


import android.view.View;

import com.ma.chasheng.chalutong.widget.EmptyLayout;

/**
 * Created by long on 2016/8/23.
 * 基础 BaseView 接口
 */
public interface IBaseView {

    /**
     * 显示加载动画
     */
    void showLoading(String msg);

    /**
     * 隐藏加载
     */
    void hideLoading();

    /**
     * 显示网络错误
     *
     */
    void showNetError(String msg);


    void showNetError(String msg, View.OnClickListener onClickListener);

    /**
     * 绑定生命周期
     * @param <T>
     * @return
     */
   // <T> LifecycleTransformer<T> bindToLife();


}
