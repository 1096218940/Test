package com.ma.chasheng.chalutong.ui.fragment.video;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ma.chasheng.chalutong.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {

    @BindView(R.id.jv_video)
    JCVideoPlayerStandard jvVideo;
    Unbinder unbinder;
    private String videoUrl = "http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4";

    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.video_item, container, false);
        unbinder = ButterKnife.bind(this, view);
        initVideoView();
        return view;
    }

    private void initVideoView() {
        jvVideo.setUp(videoUrl,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "幽默小故事");
        jvVideo.thumbImageView.setImageResource(R.mipmap.car);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
