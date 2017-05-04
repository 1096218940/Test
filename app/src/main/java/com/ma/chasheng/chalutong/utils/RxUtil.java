package com.ma.chasheng.chalutong.utils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by mapingan
 * on 2017/5/4 0004.
 */

public class RxUtil {

    /**
     * 无进度条Schedulers
     * @param <T>
     * @return
     */
    public static <T>ObservableTransformer<T,T> applySchedulers(){
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> ObservableTransformer<T,T> applySchedulers(@NonNull final Dialog dialog){

        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream
                        .delay(1, TimeUnit.SECONDS)
                        .subscribeOn(Schedulers.io())
                        //处理加载进度条的显示及实现了取消请求的功能
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(@NonNull final Disposable disposable) throws Exception {
                                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                    @Override
                                    public void onCancel(DialogInterface dialog) {
                                        disposable.dispose();
                                    }
                                });
                                dialog.show();
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread())
                        //不论处理异常还是成功都会执行，finally
                        .doOnTerminate(new Action() {
                            @Override
                            public void run() throws Exception {
                                dialog.dismiss();
                            }
                        });
            }
        };

    }
}
