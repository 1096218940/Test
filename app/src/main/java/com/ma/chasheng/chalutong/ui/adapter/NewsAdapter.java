package com.ma.chasheng.chalutong.ui.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.model.News;

import java.util.List;

/**
 * Created by Administrator on 2017/5/2 0002.
 */

public class NewsAdapter extends BaseQuickAdapter<News.NewslistBean,BaseViewHolder> {
    public NewsAdapter(int layoutResId, List<News.NewslistBean> data) {
        super(R.layout.adapter_item, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, News.NewslistBean item) {

        holder.setText(R.id.adapter_item_title,item.getTitle())
                .setText(R.id.adapter_item_content,item.getDescription());

        Glide.with(mContext).load(item.getPicUrl()).into((ImageView) holder.getView(R.id.adapter_item_image));
    }
}
