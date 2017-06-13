package com.ma.chasheng.chalutong.ui.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.api.bean.Kr36Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/13 0013.
 */

public class ZhuantiAdapter extends BaseQuickAdapter<Kr36Bean.DataBean.MonographicsBean,BaseViewHolder> {
    public ZhuantiAdapter(int layoutResId, List<Kr36Bean.DataBean.MonographicsBean> data) {
        super(R.layout.item_rv_zhuanti, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Kr36Bean.DataBean.MonographicsBean item) {
        Glide.with(mContext).load(item.getCover())
                .into((ImageView) helper.getView(R.id.iv_item_rv_zhuanti));

        helper.setText(R.id.tv_item_zhuanti,item.getTitle())
                .setText(R.id.tv_hour_item_zhuanti,item.getPublished_at());
    }
}
