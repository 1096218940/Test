package com.ma.chasheng.chalutong.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.api.ApiService;
import com.ma.chasheng.chalutong.api.bean.Course;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GoodsCarActivity extends AppCompatActivity {

    private ApiService api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_car);


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        api=retrofit.create(ApiService.class);






    }



    private void mergeData(){
        //merge 合并多个Observable的发射物

        Observable.zip(Obre)
        Observable.merge(getDataFromLocal(),getDataFromNet())
                .subscribe(new Consumer<List<Course>>() {
                    @Override
                    public void accept(List<Course> courses) throws Exception {

                        //显示在recyclerView上
                    }
                });

    }


    //从本地拿数据，快
    private Observable<List<Course>> getDataFromLocal(){
        List<Course> list=new ArrayList<>();
        list.add(new Course());


        return Observable.just(list);

    }

    //从网络拿数据，慢
    private Observable<List<Course>> getDataFromNet(){
        return api.getCar().subscribeOn(Schedulers.io());
    }
}
