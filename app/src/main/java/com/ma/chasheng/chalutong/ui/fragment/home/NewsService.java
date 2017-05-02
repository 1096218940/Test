package com.ma.chasheng.chalutong.ui.fragment.home;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/5/2 0002.
 */

public class NewsService {


    public static final String BASE_URL = "http://api.tianapi.com/";
    public static final String APIKEY = "bc880d0a8dd61c0c8af01647c1c97684";


    private static final String BASETESTURL  = "http://api.tianapi.com/";


    private static OkHttpClient client=new OkHttpClient.Builder()
                    .addInterceptor(new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY))
                            .connectTimeout(601,TimeUnit.SECONDS)
                            .readTimeout(601,TimeUnit.SECONDS)
                            .writeTimeout(601,TimeUnit.SECONDS)
                            .build();

    private static Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(BASETESTURL)
            .client(client)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();




    private NewsService(){}

    public static <T> T createApi(Class<T> clazz){
        return retrofit.create(clazz);
    }


}
