package com.ma.chasheng.chalutong.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.ma.chasheng.chalutong.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * 关键词搜索
 */
public class SearchActivity extends AppCompatActivity {

    public static final String TAG = "SearchActivity";
    @BindView(R.id.editText)
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);




                /**
                 * a.可能会导致很多没有意义的请求，耗费用户的流量，因为没更改一次就会访问网络，而且只是最后输入的关键字是有用的
                 * 希望程序猿可以在开发中多多考虑一下流量的优化问题。（曾经一个月因为超出流量扣了150块，那一个月我爱上了老干妈）
                 * b.可能导致用户最终搜素的结果不是用户想要的
                 * 例如：用户开始输入“AB”这个时候出现了两个请求，一个是A关键字，一个是AB关键字。如果因为一些原因，"AB"先返回数据，
                 * 之后“A”在返回，这样，A的结果就是覆盖AB的请求结果，从而导致搜索结果不正确。
                 */


        RxTextView.textChanges(editText)
                .debounce(200, TimeUnit.MICROSECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                //如果没有输入过滤一下
                .filter(new Predicate<CharSequence>() {
                    @Override
                    public boolean test(CharSequence charSequence) throws Exception {
                        return charSequence.toString().trim().length()>0;
                    }
                })
                .flatMap(new Function<CharSequence, ObservableSource<List<String>>>() {
                    @Override
                    public ObservableSource<List<String>> apply(CharSequence charSequence) throws Exception {
                        //网络请求
                        Log.e(TAG,"flatmap"+charSequence);
                        List<String> list=new ArrayList<String>();
                        list.add("abc");
                        list.add("adc");
                        list.add("soft");
                        return Observable.just(list);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> strings) throws Exception {
                        //显示结果
                        Log.e(TAG,strings+"!");
                    }
                });

    }






}
