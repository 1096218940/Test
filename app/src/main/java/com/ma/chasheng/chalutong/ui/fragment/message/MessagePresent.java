package com.ma.chasheng.chalutong.ui.fragment.message;

import com.ma.chasheng.chalutong.api.ApiService;
import com.ma.chasheng.chalutong.base.IBasePresenter;
import com.ma.chasheng.chalutong.model.GirlsEntity;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/5/3 0003.
 */

public class MessagePresent extends IBasePresenter<MessageView>{

    @Override
    public void attachView(MessageView ibaseView) {
        super.attachView(ibaseView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public  void getMeizhiPic(final int page){

        MessageService.createApi(ApiService.class).getPictures(10,page)
                .subscribeOn(Schedulers.io())
                .map(new Function<GirlsEntity, List<GirlsEntity.ResultsBean>>() {
                    @Override
                    public List<GirlsEntity.ResultsBean> apply(GirlsEntity girlsEntity) throws Exception {
                        return girlsEntity.getResults();
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<GirlsEntity.ResultsBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<GirlsEntity.ResultsBean> resultsBeen) {

                        if (page==1){
                            getmIBaseView().refresh(resultsBeen);
                        }else {
                            getmIBaseView().loadMore(resultsBeen);
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        getmIBaseView().showNetError("网络错误");
                    }

                    @Override
                    public void onComplete() {

                    }
                })
        ;
    }
}
