package com.whty.advancedui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.whty.advancedui.R;
import com.whty.advancedui.view.CircleProgressBar;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class CircleProgressBarActivity extends AppCompatActivity {

    @InjectView(R.id.progressbar)
    CircleProgressBar mProgressbar;
    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_progress_bar);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.progressbar)
    public void onViewClicked() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progress <= 100) {
                    progress += 2;
                    mProgressbar.setProgress(progress);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
