package com.ma.chasheng.chalutong.ui.fragment.message;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.base.BaseFragment;
import com.ma.chasheng.chalutong.model.GirlsEntity;
import com.ma.chasheng.chalutong.ui.adapter.PictureRecyclerAdapter;
import com.ma.chasheng.chalutong.utils.SnackbarUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends BaseFragment implements MessageView, SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.rv_message_list)
    EasyRecyclerView mRv;

    private PictureRecyclerAdapter adapter;

    private View view;

    private MessagePresent mMessagePresent;
    private int page = 1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_message, container, false);
            ButterKnife.bind(this, view);
            initView();
        }

        return view;
    }

    private void initView() {
        mMessagePresent = new MessagePresent();
        mMessagePresent.attachView(this);
        mMessagePresent.getMeizhiPic(page);

        mRv.setRefreshing(true);
        mRv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        adapter=new PictureRecyclerAdapter(getActivity());
        mRv.setAdapter(adapter);
        mRv.setRefreshListener(this);
        //上拉加载更多
        adapter.setMore(R.layout.progress_wheel, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                page++;
                mMessagePresent.getMeizhiPic(page);
            }

            @Override
            public void onMoreClick() {

            }
        });


    }

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

        SnackbarUtil.showLong(getView(),msg);
    }

    @Override
    public void refresh(List<GirlsEntity.ResultsBean> data) {

        mRv.setRefreshing(false);
        adapter.addAll(data);
    }

    @Override
    public void loadMore(List<GirlsEntity.ResultsBean> data) {

        adapter.addAll(data);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
      mMessagePresent.detachView();
    }


    @Override
    public void onRefresh() {
        mRv.setRefreshing(true);
        adapter.clear();
        page=1;
        mMessagePresent.getMeizhiPic(page);
    }
}
