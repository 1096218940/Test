package com.ma.chasheng.chalutong.ui.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ma.chasheng.chalutong.R;
import com.ma.chasheng.chalutong.model.GirlsEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/5/3 0003.
 */

public class MessageAdapter extends BaseQuickAdapter<GirlsEntity.ResultsBean,BaseViewHolder> {
    public MessageAdapter(int layoutResId, List<GirlsEntity.ResultsBean> data) {
        super(R.layout.item_message_rv, data);
    }
    public MessageAdapter(int page){
        super(R.layout.item_message_rv);

    }

    @Override
    protected void convert(BaseViewHolder helper, GirlsEntity.ResultsBean item) {
        helper.setText(R.id.tv_message_item,item.getWho());
        Glide.with(mContext).load(item.getUrl()).into((ImageView) helper.getView(R.id.iv_message_item));
    }
}
