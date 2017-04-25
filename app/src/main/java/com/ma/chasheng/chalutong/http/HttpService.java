package com.ma.chasheng.chalutong.http;

import com.ma.chasheng.chalutong.MyApp;
import com.ma.chasheng.chalutong.api.ApiService;
import com.ma.chasheng.chalutong.api.Constant;
import com.ma.chasheng.chalutong.servrce.Http;
import com.ma.chasheng.chalutong.utils.NetworkUtil;
import com.ma.chasheng.chalutong.utils.SpUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mapingan
 * on 2017/4/25 0025.
 */

public class HttpService {

    private static OkHttpClient client;
    private static ApiService apiService;
    private static volatile Retrofit retrofit;


    //retro
    public static ApiService getApiService(){
        if (apiService==null){
            apiService=getRetrofit().create(ApiService.class);
        }
        return apiService;
    }


    /**
     * 设置公共参数
     */
    private static Interceptor addQueryParameterInterceptor() {
        Interceptor addQueryParameterInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request request;
                HttpUrl modifiedUrl = originalRequest.url().newBuilder()
                        // Provide your custom parameter here
                        .addQueryParameter("phoneSystem", "")
                        .addQueryParameter("phoneModel", "")
                        .build();
                request = originalRequest.newBuilder().url(modifiedUrl).build();
                return chain.proceed(request);
            }
        };
        return addQueryParameterInterceptor;
    }

    /**
     * 设置头
     */
    private static Interceptor addHeaderInterceptor() {
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder requestBuilder = originalRequest.newBuilder()
                        // Provide your custom header here
                        .header("token", (String) SpUtils.get("token", ""))
                        .method(originalRequest.method(), originalRequest.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
        return headerInterceptor;
    }

    /**
     * 设置缓存
     */
    private static Interceptor addCacheInterceptor() {
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!NetworkUtil.isNetworkAvailable(MyApp.getmContext())) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (NetworkUtil.isNetworkAvailable(MyApp.getmContext())) {
                    int maxAge = 0;
                    // 有网络时 设置缓存超时时间0个小时 ,意思就是不读取缓存数据,只对get有用,post没有缓冲
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Retrofit")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .build();
                } else {
                    // 无网络时，设置超时为4周  只对get有用,post没有缓冲
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" +
                                    maxStale)
                            .removeHeader("nyn")
                            .build();
                }
                return response;
            }
        };
        return cacheInterceptor;
    }

    public static Retrofit getRetrofit(){
        if (retrofit==null){
            synchronized (Http.class){
                if (retrofit==null){
                    //log拦截器，打印所有的log
                    HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
                    //可以设置请求过滤的水平，body,basic,headers
                    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

                    //设置请求缓存的大小跟位置
                    File cacheFile=new File(MyApp.getmContext().getCacheDir(),"cache");
                    //一个50MB大小的缓存
                    Cache cache=new Cache(cacheFile,1024*1024*50);

                    client=new OkHttpClient
                            .Builder()
//                            .addInterceptor(addQueryParameterInterceptor())
//                            .addInterceptor(addHeaderInterceptor())
//                            .addInterceptor(httpLoggingInterceptor)
                            .cache(cache)
                            .connectTimeout(601, TimeUnit.SECONDS)
                            .readTimeout(601,TimeUnit.SECONDS)
                            .writeTimeout(601,TimeUnit.SECONDS)
                            .build();

                    //获取retrofit的实例
                    retrofit=new Retrofit
                            .Builder()
                            .baseUrl("")
                            .client(client)
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                }
            }
        }
        return retrofit;
    }
}
