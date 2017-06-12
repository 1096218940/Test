package com.ma.chasheng.chalutong.rxjava;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.utils.ToastUtils;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.Subject;

/**
 * 获取验证码
 */
public class VerificationActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.editText)
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {

        ToastUtils.showToast("哈士奇爱吃苹果");
        final int count=10;
        Observable.interval(0,1, TimeUnit.SECONDS)
                .take(count+1)
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return count-aLong;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        button.setEnabled(false);
                        button.setTextColor(Color.BLACK);
                    }
                }).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long num) {

                button.setText("剩余"+num+"秒");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

                button.setEnabled(true);
              //  button.setTextColor(Color.WHITE);
                button.setText("发送验证码");
            }
        });


        }

}
