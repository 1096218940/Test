package com.ma.chasheng.chalutong.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.api.ApiService;
import com.ma.chasheng.chalutong.api.bean.Kr36Bean;
import com.ma.chasheng.chalutong.ui.adapter.AuthorAdapter;
import com.ma.chasheng.chalutong.ui.adapter.GridViewAdapter;
import com.ma.chasheng.chalutong.ui.adapter.Top10Adapter;
import com.ma.chasheng.chalutong.ui.adapter.ViewPagerAdapter;
import com.ma.chasheng.chalutong.ui.adapter.ZhuantiAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Kr_36Activity extends AppCompatActivity {

    public static final String TAG="Kr_36Activity";
    public static final String BASE_URL = "https://36kr.com/";

    @BindView(R.id.rv_top10)
    RecyclerView rvTop10;
    @BindView(R.id.rv_)
    RecyclerView rvZhuanti;
    @BindView(R.id.rv_author)
    RecyclerView rvAuthor;
    @BindView(R.id.ll_dot)
    LinearLayout mLlDot;
    @BindView(R.id.viewpager)
    ViewPager mPager;

    private List<View> mPagerList;
    private List<Kr36Bean.DataBean.ColumnsBean> mData;
    private LayoutInflater inflater;
    /**
     * 总的页数
     */
    private int pageCount;
    /**
     * 每一页显示的个数
     */
    private int pageSize = 6;
    /**
     * 当前显示的是第几页
     */
    private int curIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kr_36);
        ButterKnife.bind(this);
        //初始化数据源
        initData();

    }

    private void initData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getData()
                .subscribeOn(Schedulers.io())
                .map(new Function<Kr36Bean, Kr36Bean.DataBean>() {


                    @Override
                    public Kr36Bean.DataBean apply(Kr36Bean kr36Bean) throws Exception {
                        return kr36Bean.getData();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Kr36Bean.DataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Kr36Bean.DataBean dataBean) {

                        mData=new ArrayList<Kr36Bean.DataBean.ColumnsBean>();
                        mData.addAll(dataBean.getColumns());
                        Log.e(TAG,mData.size()+"!");
                        inflater = LayoutInflater.from(Kr_36Activity.this);
                        //总的页数=总数/每页数量，并取整
                        pageCount = (int) Math.ceil(mData.size() * 1.0 / pageSize);
                        mPagerList = new ArrayList<View>();
                        for (int i = 0; i < pageCount; i++) {
                            //每个页面都是inflate出一个新实例
                            GridView gridView = (GridView) inflater.inflate(R.layout.gridview, mPager, false);
                            gridView.setAdapter(new GridViewAdapter(Kr_36Activity.this, mData, i, pageSize));
                            mPagerList.add(gridView);

                            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    int pos = position + curIndex * pageSize;
                                    Toast.makeText(Kr_36Activity.this, mData.get(pos).getName(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        //设置适配器
                        mPager.setAdapter(new ViewPagerAdapter(mPagerList));
                        //设置圆点
                        setOvalLayout();

                        rvTop10.setAdapter(new Top10Adapter(R.layout.item_rv_top10, dataBean.getTopNews()));
                        rvTop10.setNestedScrollingEnabled(false);
                        rvTop10.setLayoutManager(new LinearLayoutManager(Kr_36Activity.this));

                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Kr_36Activity.this);
                        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                        rvZhuanti.setAdapter(new ZhuantiAdapter(R.layout.item_rv_zhuanti, dataBean.getMonographics()));
                        rvZhuanti.setNestedScrollingEnabled(false);
                        rvZhuanti.setLayoutManager(linearLayoutManager);

                        rvAuthor.setAdapter(new AuthorAdapter(R.layout.item_author, dataBean.getTopWriters()));
                        rvAuthor.setNestedScrollingEnabled(false);
                        rvAuthor.setLayoutManager(new LinearLayoutManager(Kr_36Activity.this));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 设置圆点
     */
    public void setOvalLayout() {
        for (int i = 0; i < pageCount; i++) {
            mLlDot.addView(inflater.inflate(R.layout.dot, null));
        }
        // 默认显示第一页
        mLlDot.getChildAt(0).findViewById(R.id.v_dot)
                .setBackgroundResource(R.drawable.dot_selected);
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageSelected(int position) {
                // 取消圆点选中
                mLlDot.getChildAt(curIndex)
                        .findViewById(R.id.v_dot)
                        .setBackgroundResource(R.drawable.dot_normal);
                // 圆点选中
                mLlDot.getChildAt(position)
                        .findViewById(R.id.v_dot)
                        .setBackgroundResource(R.drawable.dot_selected);
                curIndex = position;
            }

            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }
}
