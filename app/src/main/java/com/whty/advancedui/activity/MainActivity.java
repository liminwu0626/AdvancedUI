package com.whty.advancedui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.whty.advancedui.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.btn_flowlayout)
    Button mBtnFlowlayout;
    @InjectView(R.id.btn_progressbar)
    Button mBtnProgressbar;
    @InjectView(R.id.btn_dashpath)
    Button mBtnDashpath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.btn_flowlayout, R.id.btn_progressbar, R.id.btn_dashpath})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_flowlayout:
                openActivity(FlowLayoutActivity.class);
                break;
            case R.id.btn_progressbar:
                openActivity(CircleProgressBarActivity.class);
                break;
            case R.id.btn_dashpath:
                openActivity(DashPathViewActivity.class);
                break;
        }
    }

    /**
     * 跳转指定的activity
     *
     * @param cls
     */
    private void openActivity(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, cls);
        startActivity(intent);
    }

}
