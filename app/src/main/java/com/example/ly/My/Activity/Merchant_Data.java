package com.example.ly.My.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ly.R;

public class Merchant_Data extends AppCompatActivity implements View.OnClickListener {

    private TextView go_back;
    private TextView title_text;
    private RelativeLayout rl_day;
    private RelativeLayout rl_month;
    private RelativeLayout rl_year;
    private RelativeLayout rl_quarter;
    private TextView tv_day;
    private TextView tv_month;
    private TextView tv_quarter;
    private TextView tv_year;
    private LinearLayout ll_all;
    private FrameLayout body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant__data);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();

        setListener();    //批量事件监听
        setStatus();      //设置状态
    }

    private void init() {
        go_back = (TextView) findViewById(R.id.go_back);
        go_back.setVisibility(View.VISIBLE);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Merchant_Data.this.finish();
            }
        });
        title_text = (TextView) findViewById(R.id.title_text);
        title_text.setVisibility(View.VISIBLE);
        title_text.setText("数据统计");
        //日        //月        //季度        //年
        ll_all = (LinearLayout) findViewById(R.id.ll_all);
        //日
        rl_day = (RelativeLayout) findViewById(R.id.rl_day);
        tv_day = (TextView) findViewById(R.id.tv_day);
        //月
        rl_month = (RelativeLayout) findViewById(R.id.rl_month);
        tv_month = (TextView) findViewById(R.id.tv_month);
        //季度
        rl_quarter = (RelativeLayout) findViewById(R.id.rl_quarter);
        tv_quarter = (TextView) findViewById(R.id.tv_quarter);
        //年
        rl_year = (RelativeLayout) findViewById(R.id.rl_year);
        tv_year = (TextView) findViewById(R.id.tv_year);

        body = (FrameLayout) findViewById(R.id.body);
    }

    //批量事件监听
    private void setListener() {
        for (int i = 0; i < ll_all.getChildCount(); i++) {
            ll_all.getChildAt(i).setOnClickListener(this);
        }
    }
    //设置状态
    private void setStatus() {
        grayStatus();            //创建这个方法，让底部全变灰
        setSelectStatus(0);      //设置选中的状态
        firstView(0);         //首次进入的视图
    }
    //设置选中状态
    private void setselectStatus(int i) {
        //删除body里面的所有控件
        removeAllView();
        //设置选中的状态
        setSelectStatus(i);
        //填充body
        firstView(i);
    }
    private void removeAllView() {
        for (int i = 0; i < body.getChildCount(); i++) {
            body.getChildAt(i).setVisibility(View.GONE);
        }
    }

    //设置选中的状态
    private void setSelectStatus(int i) {
        switch (i) {
            case 0:
                rl_day.setSelected(true);
                rl_day.setBackgroundColor(Color.parseColor("#0097f7"));
                break;
            case 1:
                rl_month.setSelected(true);
                rl_month.setBackgroundColor(Color.parseColor("#0097f7"));
                break;
            case 2:
                rl_quarter.setSelected(true);
                rl_quarter.setBackgroundColor(Color.parseColor("#0097f7"));
                break;
            case 3:
                rl_year.setSelected(true);
                rl_year.setBackgroundColor(Color.parseColor("#0097f7"));
                break;
        }
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_day:
                grayStatus();          //创建这个方法，让底部全变灰
                setselectStatus(0);      //设置选中的状态(日)
                break;
            case R.id.rl_month:
                grayStatus();          //创建这个方法，让底部全变灰
                setselectStatus(1);      //设置选中的状态(月)
                break;
            case R.id.rl_quarter:
                grayStatus();          //创建这个方法，让底部全变灰
                setselectStatus(2);      //设置选中的状态(季度)
                break;
            case R.id.rl_year:
                grayStatus();          //创建这个方法，让底部全变灰
                setselectStatus(3);      //设置选中的状态(年)
                break;
        }
    }

    //取消选中状态变灰
    private void grayStatus() {
        rl_day.setBackgroundColor(Color.parseColor("#666666"));
        tv_day.setTextColor(Color.parseColor("#666666"));
        rl_month.setBackgroundColor(Color.parseColor("#666666"));
        tv_month.setTextColor(Color.parseColor("#666666"));
        rl_quarter.setBackgroundColor(Color.parseColor("#666666"));
        tv_quarter.setTextColor(Color.parseColor("#666666"));
        rl_year.setBackgroundColor(Color.parseColor("#666666"));
        tv_year.setTextColor(Color.parseColor("#666666"));
        for (int i = 0; i < ll_all.getChildCount(); i++) {
            ll_all.getChildAt(i).setSelected(false);      //取消选中
        }
    }

    private void firstView(int i) {
        switch (i) {
            case 0:
                //日
                break;
            case 1:
                //月
                break;
            case 2:
                //季度
                break;
            case 3:
                //年
                break;
        }
    }

}