package com.ma.chasheng.chalutong;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.ma.chasheng.chalutong.base.BaseActivity;
import com.ma.chasheng.chalutong.ui.fragment.CarFragment;
import com.ma.chasheng.chalutong.ui.fragment.MessageFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rb_1)
    RadioButton rb1;
    @BindView(R.id.rb_2)
    RadioButton rb2;
    @BindView(R.id.rb_3)
    RadioButton rb3;
    @BindView(R.id.rb_4)
    RadioButton rb4;
    @BindView(R.id.fl_container)
    FrameLayout mFlContainer;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {
        initState();

    }

    @Override
    protected void updateViews(boolean isRefresh) {

        rb1.setChecked(true);
        addFragment(R.id.fl_container,new MessageFragment(),"Msg");
    }

    /**
     * 沉浸式状态栏
     */
    private void initState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    @OnClick({R.id.rb_1, R.id.rb_2, R.id.rb_3, R.id.rb_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_1:
                replaceFragment(R.id.fl_container,new MessageFragment(),"Msg");
                break;
            case R.id.rb_2:
                replaceFragment(R.id.fl_container,new CarFragment(),"Car");
                break;
            case R.id.rb_3:
                replaceFragment(R.id.fl_container,new MessageFragment(),"Msg2");
                break;
            case R.id.rb_4:
                replaceFragment(R.id.fl_container,new CarFragment(),"Car2");
                break;
        }
    }
}
