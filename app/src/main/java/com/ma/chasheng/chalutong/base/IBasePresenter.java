package com.ma.chasheng.chalutong.base;

import retrofit2.http.PUT;

/**
 * Created by long on 2016/8/23.
 * 基础 Presenter
 */
public class IBasePresenter<T extends IBaseView> implements  Presenter<T> {

    private T mIBaseView;

    @Override
    public void attachView(T ibaseView) {
        mIBaseView=ibaseView;
    }

    @Override
    public void detachView() {

        mIBaseView=null;
    }

    public boolean isViewAttached(){
        return mIBaseView!=null;
    }

    public T getmIBaseView(){
        return mIBaseView;
    }

    public void checkViewAttached(){
        if (!isViewAttached()) throw new  MvpViewNotAttachedException();
    }

    public static class  MvpViewNotAttachedException extends RuntimeException{

        public  MvpViewNotAttachedException(){
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
