package com.ma.chasheng.chalutong.ui.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.api.Constant;
import com.ma.chasheng.chalutong.api.bean.HomeListBean;
import com.ma.chasheng.chalutong.api.bean.RecommendListBean;

import java.util.List;

/**
 * Created by mapingan
 * on 2017/4/25 0025.
 */

public class RecommendListAdapter extends BaseQuickAdapter<RecommendListBean.ResultBean,BaseViewHolder>{


    public RecommendListAdapter(int layoutResId, List<RecommendListBean.ResultBean> data) {
        super(R.layout.item_home_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecommendListBean.ResultBean item) {

        helper.setText(R.id.tv_title,item.getGoodsName())
                .setText(R.id.tv_new,item.getGoodsPrice()+"")
                .setText(R.id.tv_old,item.getGoodsMarketPrice());

        Glide.with(mContext).load(Constant.IMG_PATH+item.getGoodsImage()).into((ImageView) helper.getView(R.id.img));
    }
}
