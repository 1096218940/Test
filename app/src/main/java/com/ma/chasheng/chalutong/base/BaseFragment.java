package com.ma.chasheng.chalutong.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.utils.SwipeRefreshHelper;
import com.ma.chasheng.chalutong.widget.EmptyLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/4/17 0017.
 */

public  class BaseFragment extends Fragment {

    protected <T extends View> T $(View view, int id) {
        return (T) view.findViewById(id);
    }

}
