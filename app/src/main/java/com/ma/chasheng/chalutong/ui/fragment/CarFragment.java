package com.ma.chasheng.chalutong.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.base.BaseFragment;
import com.ma.chasheng.chalutong.base.IBasePresenter;
import com.ma.chasheng.chalutong.base.IBaseView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class CarFragment extends BaseFragment<IBasePresenter> implements IBaseView {


    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.rv_car)
    RecyclerView mRecyclerView;
    Unbinder unbinder;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_car;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {
        initToolBar(mToolBar,true,"购物车");
    }

    @Override
    protected void updateViews(boolean isRefresh) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
