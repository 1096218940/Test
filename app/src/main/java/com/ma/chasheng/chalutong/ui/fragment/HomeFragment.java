package com.ma.chasheng.chalutong.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class HomeFragment extends BaseFragment <IBasePresenter> implements IBaseView {

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_home;
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
