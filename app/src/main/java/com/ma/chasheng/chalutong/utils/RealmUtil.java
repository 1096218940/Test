package com.ma.chasheng.chalutong.utils;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by mapingan
 * on 2017/5/9 0009.
 */

public class RealmUtil {
    public static final String DATABASE_NAME="data.realm";

    public static Realm  newRealmInstance(){
        return Realm.getInstance(new RealmConfiguration.Builder()
        .deleteRealmIfMigrationNeeded()
        .name(RealmUtil.DATABASE_NAME)
        .build());
    }
}
