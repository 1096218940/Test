package com.ma.chasheng.chalutong.ui.fragment.message;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/5/3 0003.
 */

public class MessageService {


    private static final String BASETESTURL = "http://gank.io/api/";

    private static OkHttpClient client=new OkHttpClient.Builder()
            .addInterceptor(new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(601, TimeUnit.SECONDS)
            .readTimeout(601,TimeUnit.SECONDS)
            .writeTimeout(601,TimeUnit.SECONDS)
            .build();

    private static Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(BASETESTURL)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();




    private MessageService(){}

    public static <T> T createApi(Class<T> clazz){
        return retrofit.create(clazz);
    }

}
