package com.ma.chasheng.chalutong.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.base.BaseFragment;
import com.ma.chasheng.chalutong.base.IBasePresenter;
import com.ma.chasheng.chalutong.base.IBaseView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<IBasePresenter> implements IBaseView {

    @BindView(R.id.textView7)
    TextView mTextView;
    @BindView(R.id.imageView2)
    ImageView mImageView;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.textView8)
    TextView textView8;
    @BindView(R.id.textView9)
    TextView textView9;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    Unbinder unbinder;

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

    @OnClick({R.id.imageView2, R.id.button, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageView2:
                break;
            case R.id.button:
                break;
            case R.id.button2:
                break;
        }
    }
}
