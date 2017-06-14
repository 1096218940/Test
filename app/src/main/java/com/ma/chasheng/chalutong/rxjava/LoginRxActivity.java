package com.ma.chasheng.chalutong.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.api.ApiService;
import com.ma.chasheng.chalutong.api.bean.BaseBean;
import com.ma.chasheng.chalutong.api.bean.Kr36Bean;
import com.ma.chasheng.chalutong.api.bean.UserBean;
import com.ma.chasheng.chalutong.api.bean.UserParam;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class LoginRxActivity extends AppCompatActivity {

    @BindView(R.id.login)
    Button login;
    @BindView(R.id.textview)
    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_rx);
        ButterKnife.bind(this);



    }

    @OnClick({R.id.login, R.id.textview})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login:
                login();
                break;
            case R.id.textview:
                break;
        }
    }


    //登录--》获取用户信息
    private int login(String username){

        int user_id=1;
        return user_id;
    }

    //获取用户信息
    private UserBean getUserInfo(int user_id){
        return null;
    }




    private UserParam getUserParam(){
        UserParam param=new UserParam();

        return param;
    }





    /**
     * flatmap  将一个发射数据的Observable 变换为多个Observables,然后将它们发射的数据合并后放进一个单独的Observable
     * */
    private void login() {
        Observable.just(getUserParam())
                .flatMap(new Function<UserParam, ObservableSource<BaseBean>>() {

                    @Override
                    public ObservableSource<BaseBean> apply(UserParam param) throws Exception {

                        BaseBean result=null;//调用网络

                        return Observable.just(result);
                    }
                }).flatMap(new Function<BaseBean, ObservableSource<UserBean>>() {

            @Override
            public ObservableSource<UserBean> apply(BaseBean baseBean) throws Exception {
                UserBean user=null;//调用网络

                return Observable.just(user);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserBean>() {
            @Override
            public void accept(UserBean userBean) throws Exception {
                textview.setText(userBean.getName()+userBean.getAge());
            }
        });

    }
}
