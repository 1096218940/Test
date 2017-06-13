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

public class Top10Adapter extends BaseQuickAdapter<Kr36Bean.DataBean.TopNewsBean,BaseViewHolder> {
    public Top10Adapter(int layoutResId, List<Kr36Bean.DataBean.TopNewsBean> data) {
        super(R.layout.item_rv_top10, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Kr36Bean.DataBean.TopNewsBean item) {
        Glide.with(mContext).load(item.getCover())
                .into((ImageView) helper.getView(R.id.iv_item_rv_top10));
        helper.setText(R.id.tv_item_rv_top10,item.getTitle())
                .setText(R.id.tv_num_item_rv_top10,item.getTotal_words()+"次阅读");

    }
}
