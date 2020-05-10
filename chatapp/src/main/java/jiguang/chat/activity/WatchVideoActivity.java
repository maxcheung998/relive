package jiguang.chat.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.VideoView;

import jiguang.chat.R;


public class WatchVideoActivity extends Activity{

    private VideoView mVv_video;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_watch_video);

        mVv_video = (VideoView) findViewById(R.id.vv_video);

        String videoPath = getIntent().getStringExtra("video_path");

        mVv_video.setVideoPath(videoPath);
        mVv_video.start();
    }
}