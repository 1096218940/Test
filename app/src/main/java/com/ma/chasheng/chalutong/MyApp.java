package com.ma.chasheng.chalutong;

import android.app.Application;
import android.content.Context;

import com.ma.chasheng.chalutong.utils.ToastUtils;

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
    }


    /**
     * @return
     * 全局的上下文
     */
    public static Context getmContext() {
        return mContext;
    }
}
