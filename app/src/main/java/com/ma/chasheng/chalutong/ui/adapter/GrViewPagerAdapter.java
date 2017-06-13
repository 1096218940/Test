package com.ma.chasheng.chalutong.ui.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.api.bean.Kr36Bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/12 0012.
 */

public class GrViewPagerAdapter extends BaseQuickAdapter<Kr36Bean.DataBean.ColumnsBean,BaseViewHolder> {

    public GrViewPagerAdapter(int layoutResId, List<Kr36Bean.DataBean.ColumnsBean> data) {
        super(R.layout.item_viewpager, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Kr36Bean.DataBean.ColumnsBean item) {
        Glide.with(mContext).load(item.getCover_thumb()).into((ImageView) helper.getView(R.id.iv_item_viewpager));
        helper.setText(R.id.tv_item_viewpager,item.getName())
                .setText(R.id.tv_title_item_rv_competitive,item.getIntroduction());
    }
}
