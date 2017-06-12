package com.ma.chasheng.chalutong.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

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

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                /**
                 * a.可能会导致很多没有意义的请求，耗费用户的流量，因为没更改一次就会访问网络，而且只是最后输入的关键字是有用的
                 * 希望程序猿可以在开发中多多考虑一下流量的优化问题。（曾经一个月因为超出流量扣了150块，那一个月我爱上了老干妈）
                 * b.可能导致用户最终搜素的结果不是用户想要的
                 * 例如：用户开始输入“AB”这个时候出现了两个请求，一个是A关键字，一个是AB关键字。如果因为一些原因，"AB"先返回数据，
                 * 之后“A”在返回，这样，A的结果就是覆盖AB的请求结果，从而导致搜索结果不正确。
                 */
                search(s.toString().trim());//请求搜索接口，成功后把结果显示在界面上
            }
        });
    }

    private void search(String trim) {
//        NewsService.createApi(ApiService.class)
//                .textChanges(trim)


        Observable

                .just("123")
                .debounce(200, TimeUnit.MICROSECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        return s.toString().trim().length() > 0;
                    }
                }).switchMap(new Function<String, ObservableSource<List<String>>>() {
            @Override
            public ObservableSource<List<String>> apply(String s) throws Exception {
                Log.e(TAG, s);
                List<String> list = new ArrayList<String>();
                list.add("abc");
                list.add("ada");

                return Observable.just(list);
            }
        })
//                .flatMap(new Function<String, ObservableSource<List<String>>>() {
//                    @Override
//                    public ObservableSource<List<String>> apply(String s) throws Exception {
//                        List<String> list=new ArrayList<String>();
//                        list.add("abc");
//                        list.add("ada");
//
//                        return Observable.just(list);
//                    }
//                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> strings) throws Exception {
                        Log.e(TAG, "list" + strings);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }


}
