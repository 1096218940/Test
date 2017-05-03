package com.ma.chasheng.chalutong.ui.adapter;


import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.model.GirlsEntity;

/**
 * Created by 20939 on 2016/11/16.
 */
public class PictureRecyclerAdapter extends RecyclerArrayAdapter<GirlsEntity.ResultsBean> {


    public PictureRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new PictureViewHolder(parent);
    }

    class PictureViewHolder extends BaseViewHolder<GirlsEntity.ResultsBean>{

        private ImageView imageView;
        private TextView textView;

        public PictureViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_message_rv);
            imageView=$(R.id.iv_message_item);
            textView=$(R.id.tv_message_item);
        }

        @Override
        public void setData(GirlsEntity.ResultsBean data) {
            super.setData(data);
            Glide.with(getContext())
                    .load(data.getUrl())
                    .error(R.mipmap.ic_launcher)
                    .into(imageView);
            textView.setText(data.getDesc());
        }
    }
}

