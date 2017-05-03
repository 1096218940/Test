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
public class MineFragment extends BaseFragment  implements IBaseView {


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
