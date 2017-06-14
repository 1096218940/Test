package com.ma.chasheng.chalutong.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.jakewharton.rxbinding2.view.RxView;
import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.utils.ToastUtils;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

//防止按钮重复点击
public class ButtonActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        ButterKnife.bind(this);


        /**
         * throttleFirst
         * 允许设置一个时间长度，之后它会发送固定时间长度内的第一个事件，而屏蔽其他事件
         * 在间隔达到设置的时间后，可以在发送下一个事件。
         *
         * */

        RxView.clicks(button)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        ToastUtils.showToast("哈哈");
                    }
                });
    }




  /*  private long lastTime=0;
    @OnClick(R.id.button)
    public void onViewClicked() {

        //常规方式
        long currTime=System.currentTimeMillis();
        if (lastTime-currTime>500){
            //
        }
        lastTime=currTime;

    }*/
}
