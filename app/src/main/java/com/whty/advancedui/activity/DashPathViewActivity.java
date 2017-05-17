package com.whty.advancedui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.whty.advancedui.view.RoundImageView;

public class DashPathViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_dash_path_view);
//        ZoomImageView zoomImageView = new ZoomImageView(this);
//        HeartMapView heartMapView = new HeartMapView(this);
        RoundImageView roundImageView = new RoundImageView(this);
        setContentView(roundImageView);
    }
}
