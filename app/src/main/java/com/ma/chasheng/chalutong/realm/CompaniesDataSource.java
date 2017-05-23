package com.ma.chasheng.chalutong.realm;

import android.support.annotation.NonNull;

import com.ma.chasheng.chalutong.model.Company;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by mapingan
 * on 2017/5/9 0009.
 */

public interface CompaniesDataSource {

    Observable<List<Company>> getCompaines();

    Observable<Company> getCompany(@NonNull String companyId);

    void initData();

    Observable<List<Company>> searchCompanies(@NonNull String keyWords);
}
