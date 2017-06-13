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

public class AuthorAdapter extends BaseQuickAdapter<Kr36Bean.DataBean.TopWritersBean,BaseViewHolder> {
    public AuthorAdapter(int layoutResId, List<Kr36Bean.DataBean.TopWritersBean> data) {
        super(R.layout.item_author, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Kr36Bean.DataBean.TopWritersBean item) {

        Glide.with(mContext).load(item.getPosts().get(0).getCover())
                .into((ImageView) helper.getView(R.id.item_circle));

        Glide.with(mContext).load(item.getPosts().get(0).getCover())
                .into((ImageView) helper.getView(R.id.image_item));

        helper.setText(R.id.author_item,item.getName())
                .setText(R.id.author_show_item,item.getIntroduction())
                .setText(R.id.tv_image_show_item,item.getPosts().get(0).getTitle());
    }
}
