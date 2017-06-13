package com.ma.chasheng.chalutong.ui.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigkoo.convenientbanner.holder.Holder;
import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.api.bean.Kr36Bean;
import com.ma.chasheng.chalutong.utils.AutoLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/12 0012.
 */

public class BannerHolderView implements Holder<Kr36Bean.DataBean.ColumnsBean> {


    private RecyclerView rv;
    private List<Kr36Bean.DataBean.ColumnsBean > datas=new ArrayList<>();

    @Override
    public View createView(Context context) {
        rv =new RecyclerView(context);
        rv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,220));
//        View view=LayoutInflater.from(context).inflate(R.layout.viewpage_item,null);
//        rv = ((RecyclerView) view.findViewById(R.id.rv_viewpager));
        return rv;
    }

    @Override
    public void UpdateUI(Context context, int position, Kr36Bean.DataBean.ColumnsBean data) {
        datas.add(data);
        rv.setAdapter(new GrViewPagerAdapter(R.layout.item_viewpager,datas));
        rv.setLayoutManager(new AutoLinearLayoutManager(context,3));
    }


}
