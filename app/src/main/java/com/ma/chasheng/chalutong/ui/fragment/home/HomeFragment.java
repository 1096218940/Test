package com.ma.chasheng.chalutong.ui.fragment.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.base.BaseFragment;
import com.ma.chasheng.chalutong.base.IBaseView;
import com.ma.chasheng.chalutong.model.News;
import com.ma.chasheng.chalutong.ui.adapter.NewsAdapter;
import com.ma.chasheng.chalutong.utils.SnackbarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements NewsView {


    @BindView(R.id.rv)
    RecyclerView rv;


    private int page = 1;
    private NewsAdapter adapter;

    public static final String APIKEY = "bc880d0a8dd61c0c8af01647c1c97684";
    private View view;
    private NewsPresent mNewsPresenter;
    private List<News.NewslistBean> data=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_home, container, false);
            ButterKnife.bind(this, view);
            initView();
        }
        ButterKnife.bind(this, view);
        return view;

    }

    private void initView() {
        mNewsPresenter = new NewsPresent();
        mNewsPresenter.attachView(this);
        mNewsPresenter.getNewsData(page);

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter=new NewsAdapter(R.layout.adapter_item,data);
        rv.setAdapter(adapter);


    }


    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showNetError(String msg) {

        SnackbarUtil.showLong(getView(),msg);
    }

    @Override
    public void showNetError(String msg, View.OnClickListener onClickListener) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mNewsPresenter.detachView();
    }

    @Override
    public void refresh(List<News.NewslistBean> data) {

    }

    @Override
    public void loadMore(List<News.NewslistBean> data) {

    }
}
