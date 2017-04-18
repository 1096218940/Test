package com.ma.chasheng.chalutong.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.base.BaseFragment;
import com.ma.chasheng.chalutong.base.IBasePresenter;
import com.ma.chasheng.chalutong.base.IBaseView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends BaseFragment<IBasePresenter> implements IBaseView {


    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void updateViews(boolean isRefresh) {

    }
}
