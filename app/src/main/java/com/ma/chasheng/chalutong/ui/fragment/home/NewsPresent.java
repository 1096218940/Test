package com.ma.chasheng.chalutong.ui.fragment.home;

import com.ma.chasheng.chalutong.api.ApiService;
import com.ma.chasheng.chalutong.base.IBasePresenter;
import com.ma.chasheng.chalutong.model.News;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import rx.Subscriber;


/**
 * Created by Administrator on 2017/5/2 0002.
 */

public class NewsPresent extends IBasePresenter<NewsView> {

    public static final String APIKEY = "bc880d0a8dd61c0c8af01647c1c97684";

    @Override
    public void attachView(NewsView ibaseView) {
        super.attachView(ibaseView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void getNewsData(final int page){

        NewsService.createApi(ApiService.class)
                .getNewsDatas(APIKEY, "10", page)
                .subscribeOn(Schedulers.io())
                .map(new Function<News, List<News.NewslistBean>>() {
                    @Override
                    public List<News.NewslistBean> apply(News news) throws Exception {
                        return news.getNewslist();
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subject<List<News.NewslistBean>>() {
                    @Override
                    public boolean hasObservers() {
                        return false;
                    }

                    @Override
                    public boolean hasThrowable() {
                        return false;
                    }

                    @Override
                    public boolean hasComplete() {
                        return false;
                    }

                    @Override
                    public Throwable getThrowable() {
                        return null;
                    }

                    @Override
                    protected void subscribeActual(Observer<? super List<News.NewslistBean>> observer) {

                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<News.NewslistBean> newslistBeen) {

                        if (page==1){
                            getmIBaseView().refresh(newslistBeen);
                        }else {
                            getmIBaseView().loadMore(newslistBeen);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                        getmIBaseView().showNetError("网络错误");
                    }

                    @Override
                    public void onComplete() {

                    }
                });




    }


}
