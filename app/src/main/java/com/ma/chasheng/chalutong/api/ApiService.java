package com.ma.chasheng.chalutong.api;

import com.ma.chasheng.chalutong.api.bean.RecommendListBean;
import com.ma.chasheng.chalutong.base.BaseHttpResult;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by mapingan
 * on 2017/4/25 0025.
 */

public interface ApiService {

    @GET("indexapi/indexGoods")
    Observable<BaseHttpResult<RecommendListBean>> showList(@Query("pageNo")int pagNo);
}
