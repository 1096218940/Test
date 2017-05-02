package com.ma.chasheng.chalutong.base;




import com.ma.chasheng.chalutong.exception.ErrorType;
import com.ma.chasheng.chalutong.exception.ExceptionEngine;
import com.ma.chasheng.chalutong.exception.ServerException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;


/**
 * Created by gaosheng on 2016/11/6.
 * 23:00
 * com.example.gaosheng.myapplication.transformer
 */

public class ErrorTransformer<T> implements ObservableTransformer<BaseHttpResult<T>, T> {

    private static ErrorTransformer errorTransformer = null;
    private static final String TAG = "ErrorTransformer";

    /**
     * @return 线程安全, 双层校验
     */
    public static <T> ErrorTransformer<T> getInstance() {

        if (errorTransformer == null) {
            synchronized (ErrorTransformer.class) {
                if (errorTransformer == null) {
                    errorTransformer = new ErrorTransformer<>();
                }
            }
        }
        return errorTransformer;

    }

    @Override
    public ObservableSource<T> apply(Observable<BaseHttpResult<T>> upstream) {

        return upstream.map(new Function<BaseHttpResult<T>, T>() {
            @Override
            public T apply(BaseHttpResult<T> tBaseHttpResult) throws Exception {
                if (tBaseHttpResult == null)
                    throw new ServerException(ErrorType.EMPTY_BEAN, "解析对象为空");

                //    LogUtils.e(TAG, httpResult.toString());

                if (tBaseHttpResult.getStatus() != ErrorType.SUCCESS)
                    throw new ServerException(tBaseHttpResult.getStatus(), tBaseHttpResult.getMessage());
                return tBaseHttpResult.getData();
            }


        }).onErrorResumeNext(new Function<Throwable, ObservableSource<? extends T>>() {
            @Override
            public ObservableSource<? extends T> apply(Throwable throwable) throws Exception {
                //ExceptionEngine为处理异常的驱动器throwable
                throwable.printStackTrace();
                return Observable.error(ExceptionEngine.handleException(throwable));
            }
        });
    }
}
