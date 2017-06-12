package com.ma.chasheng.chalutong.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.api.ApiService;
import com.ma.chasheng.chalutong.api.bean.Kr36Bean;
import com.ma.chasheng.chalutong.ui.adapter.BannerHolderView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Kr_36Activity extends AppCompatActivity {


    @BindView(R.id.rv_top10)
    RecyclerView rvTop10;
    @BindView(R.id.rv_)
    RecyclerView rvZhuanti;
    @BindView(R.id.rv_author)
    RecyclerView rvAuthor;
    @BindView(R.id.convenientBanner)
    ConvenientBanner convenientBanner;


    public static final String BASE_URL = "https://36kr.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kr_36);
        ButterKnife.bind(this);
        initData();

    }


    private void initData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getData()
                .subscribeOn(Schedulers.io())
                .map(new Function<Kr36Bean, Kr36Bean.DataBean>() {


                    @Override
                    public Kr36Bean.DataBean apply(Kr36Bean kr36Bean) throws Exception {
                        return kr36Bean.getData();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Kr36Bean.DataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Kr36Bean.DataBean dataBean) {
                        convenientBanner.setPages(new CBViewHolderCreator<BannerHolderView>() {
                            @Override
                            public BannerHolderView createHolder() {
                                return new BannerHolderView();
                            }
                        },dataBean.getColumns())
                                //.setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                                //设置指示器的方向
                                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });



    }
}
