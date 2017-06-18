package com.ma.chasheng.chalutong.api;

import com.ma.chasheng.chalutong.api.bean.BaseBean;
import com.ma.chasheng.chalutong.api.bean.Course;
import com.ma.chasheng.chalutong.api.bean.Kr36Bean;
import com.ma.chasheng.chalutong.api.bean.RecommendListBean;
import com.ma.chasheng.chalutong.api.bean.UserBean;
import com.ma.chasheng.chalutong.api.bean.UserParam;
import com.ma.chasheng.chalutong.base.BaseHttpResult;
import com.ma.chasheng.chalutong.model.GirlsEntity;
import com.ma.chasheng.chalutong.model.News;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by mapingan
 * on 2017/4/25 0025.
 */

public interface ApiService {

    @GET("indexapi/indexGoods")
    Observable<BaseHttpResult<RecommendListBean>> showList(@Query("pageNo")int pagNo);


    //    科技新闻：
    @GET("keji/")
    Observable<News> getNewsDatas(@Query("key") String key, @Query("num") String num, @Query("page") int page);

    @GET("data/福利/{num}/{page}")
    Observable<GirlsEntity> getPictures(@Path("num") int num, @Path("page") int page);

    @GET("data/福利/{num}/{page}")
    Observable<String> textChanges(@Path("num")String str);

    @GET("napi/discover")
    Observable<Kr36Bean> getData();


    @GET("user/{id}")
    Observable<UserBean> getUserInfoWithPath(@Path("id") int user_id);

    @POST
    Observable<BaseBean> login(@Body UserParam param);


    @GET("")
    Observable<List<Course>> getCar();
}
