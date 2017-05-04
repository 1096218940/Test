package com.ma.chasheng.chalutong.base;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.ma.chasheng.chalutong.utils.NetworkUtil;
import com.ma.chasheng.chalutong.utils.ToastUtils;

import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.ResourceSubscriber;

/**
 * Created by mapingan
 * on 2017/5/4 0004.
 */

public abstract class CommonSubscriber<T> extends DisposableSubscriber<T>{

    private Context context;

    public CommonSubscriber(Context context) {
        this.context = context;
    }

    private static final String TAG = "CommonSubscriber";

    @Override
    protected void onStart() {
        super.onStart();
        if (!NetworkUtil.isNetworkAvailable(context)){
            ToastUtils.showToast("网络不可用");
        }else {
            Log.e(TAG,"网络可用");
        }
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable t) {
       // ToastUtils.showToast( "错误信息为 " + "code:" + e.code + "   message:" + e.message);
    }
}
