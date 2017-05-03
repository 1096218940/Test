package com.ma.chasheng.chalutong.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.model.News;

import java.util.List;

/**
 * Created by Administrator on 2017/5/2 0002.
 */

public class NewsAdapter extends RecyclerArrayAdapter<News.NewslistBean> {
    public NewsAdapter(Context context) {
        super(context);
    }

    @Override
    public com.jude.easyrecyclerview.adapter.BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new EasyViewHolder(parent);
    }

    class EasyViewHolder extends com.jude.easyrecyclerview.adapter.BaseViewHolder<News.NewslistBean> {
        private ImageView easyImageView;
        private TextView easyTitleText;
        private TextView easyContentText;

        public EasyViewHolder(ViewGroup parent) {
            super(parent, R.layout.adapter_item);
            /* itemView.findViewById()的封装 */
            easyImageView = $(R.id.adapter_item_image);
            easyTitleText = $(R.id.adapter_item_title);
            easyContentText = $(R.id.adapter_item_content);
        }

        @Override
        public void setData(News.NewslistBean data) {
            easyTitleText.setText(data.getTitle());
            easyContentText.setText(data.getDescription());
            Glide.with(getContext())
                    .load(data.getPicUrl())
                    .error(R.mipmap.ic_launcher)
                    .into(easyImageView);
        }
    }
}
