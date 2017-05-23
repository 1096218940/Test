package com.ma.chasheng.chalutong;

import android.app.Application;
import android.content.Context;

import com.ma.chasheng.chalutong.utils.ToastUtils;

import io.realm.Realm;

/**
 * Created by mapingan
 * on 2017/4/25 0025.
 */

public class MyApp extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
        ToastUtils.init(mContext);
        Realm.init(this);
    }


    /**
     * @return
     * 全局的上下文
     */
    public static Context getmContext() {
        return mContext;
    }
}
