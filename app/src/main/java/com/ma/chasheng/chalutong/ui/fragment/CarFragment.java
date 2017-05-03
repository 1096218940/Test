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


public class CarFragment extends BaseFragment implements IBaseView {


    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showNetError(String msg) {

    }

    @Override
    public void showNetError(String msg, View.OnClickListener onClickListener) {

    }
}
