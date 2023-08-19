package com.fernfog.mathhome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.VideoView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class VideosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        setContentView(R.layout.activity_videos);

        String[] fiveClassVideos = {"7_RC1SU1dno", "f0Mkw7pGeYs"};
        String[] sixClassVideos = {"5xvXjamvV3E"};
        String[] sevenClassVideos = {"ifXQXRaKXRQ", "6dihno5V-5Y"};
        String[] eightClassVideos = {"1y2-Tm7PYSY", "PsEZhhnU49w"};
        String[] nineClassVideos = {"bCp_PbqhDIY", "hOelMV5VGu8"};
        String[] tenClassVideos = {"h6EPIScCNTc", "Yb8_v9RrsYs"};
        String[] elevenClassVideos = {"dB3SRsI3XpU", "VlK0-smxhAw"};

        LinearLayout layout = findViewById(R.id.videoLayout);

        int value = sharedPreferences.getInt("class", 5);

        switch (value) {
            case 5:
                for (String i: fiveClassVideos) {
                    createYouTubeVideoPlayer(layout, i);
                }
                break;
            case 6:
                for (String i: sixClassVideos) {
                    createYouTubeVideoPlayer(layout, i);
                }
                break;
            case 7:
                for (String i: sevenClassVideos) {
                    createYouTubeVideoPlayer(layout, i);
                }
                break;
            case 8:
                for (String i: eightClassVideos) {
                    createYouTubeVideoPlayer(layout, i);
                }
                break;
            case 9:
                for (String i: nineClassVideos) {
                    createYouTubeVideoPlayer(layout, i);
                }
                break;
            case 10:
                for (String i: tenClassVideos) {
                    createYouTubeVideoPlayer(layout, i);
                }
                break;
            case 11:
                for (String i: elevenClassVideos) {
                    createYouTubeVideoPlayer(layout, i);
                }
                break;
        }

    }

    public void createYouTubeVideoPlayer(LinearLayout layout, String videoId) {
        YouTubePlayerView youTubePlayerView = new YouTubePlayerView(this);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);

                youTubePlayer.cueVideo(videoId, 0);
            }
        });

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0,0,0,32);

        youTubePlayerView.setLayoutParams(layoutParams);

        layout.addView(youTubePlayerView);
    }
}