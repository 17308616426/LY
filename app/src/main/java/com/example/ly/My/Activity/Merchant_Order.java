package com.example.ly.My.Activity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ly.R;
import com.example.ly.My.View.MO_View;

public class Merchant_Order extends AppCompatActivity implements View.OnClickListener {

    private TextView go_back;
    private TextView title_text;
    private ImageView iv_qw;
    private RelativeLayout rl_intro;
    private TextView tv_intro;
    private RelativeLayout rl_wait_order;
    private TextView tv_wait_order;
    private RelativeLayout rl_wait_check;
    private TextView tv_wait_check;
    private RelativeLayout rl_wait_refund;
    private TextView tv_wait_refund;
    private RelativeLayout rl_finish;
    private TextView tv_finish;
    private LinearLayout ll_all;
    private MO_View mCourseView;
    private EditText et_search;
    private FrameLayout body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_order);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();

        setListener();    //批量事件监听
        setInitStatus();
    }

    private void init() {
        go_back = (TextView) findViewById(R.id.go_back);
        go_back.setVisibility(View.VISIBLE);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Merchant_Order.this.finish();
            }
        });
        title_text = (TextView) findViewById(R.id.title_text);
        title_text.setVisibility(View.VISIBLE);
        title_text.setText("订单管理");

        iv_qw = (ImageView) findViewById(R.id.iv_qw);                       //图标:扫描二维码
        et_search = (EditText) findViewById(R.id.et_search);                //图标：搜索款

        ll_all = (LinearLayout) findViewById(R.id.ll_all);                  //全部/待接单/待入住/待退款/已完成
        rl_intro = (RelativeLayout) findViewById(R.id.rl_intro);            //全部
        rl_wait_order = (RelativeLayout) findViewById(R.id.rl_wait_order);  //待接单
        rl_wait_check = (RelativeLayout) findViewById(R.id.rl_wait_check);  //待入住
        rl_wait_refund = (RelativeLayout) findViewById(R.id.rl_wait_refund);//待退款
        rl_finish = (RelativeLayout) findViewById(R.id.rl_finish);          //已完成
        tv_intro = (TextView) findViewById(R.id.tv_intro);                  //全部（文字）
        tv_wait_order = (TextView) findViewById(R.id.tv_wait_order);        //待接单(文字)
        tv_wait_check = (TextView) findViewById(R.id.tv_wait_check);        //待入住(文字)
        tv_wait_refund = (TextView) findViewById(R.id.tv_wait_refund);      //待退款(文字)
        tv_finish = (TextView) findViewById(R.id.tv_finish);                //已完成(文字)

        body = (FrameLayout) findViewById(R.id.body);                       //主体
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_intro:
                clearBottomImageState();       //创建这个方法，让底部全变灰
                selectDimplyView(0);            //设置选中状态是“全部”
                break;
            case R.id.rl_wait_order:
                clearBottomImageState();       //创建这个方法，让底部全变灰
                selectDimplyView(1);            //设置选中状态是“待接单”
                break;
            case R.id.rl_wait_check:
                clearBottomImageState();       //创建这个方法，让底部全变灰
                selectDimplyView(2);            //设置选中状态是“待入住”
                break;
            case R.id.rl_wait_refund:
                clearBottomImageState();       //创建这个方法，让底部全变灰
                selectDimplyView(3);            //设置选中状态是“待退款”
                break;
            case R.id.rl_finish:
                clearBottomImageState();       //创建这个方法，让底部全变灰
                selectDimplyView(4);            //设置选中状态是“已完成”
                break;
        }
    }

    private void setInitStatus() {
        clearBottomImageState();    //清除
        setSelectStatus(0);         //设置选中状态是“首页”
        createView(0);           //设置它的视图是“首页”
    }

    private void setListener() {
        for (int i = 0; i < ll_all.getChildCount(); i++) {   //getChildCount得到布局里的个数
            ll_all.getChildAt(i).setOnClickListener(this);
        }
    }
    //设置选中状态
    private void selectDimplyView(int i) {
        //删除body里面的所有控件
        removeAllView();
        //点击显示的页面
        setSelectStatus(i);
        //填充body
        createView(i);
    }

    private void setSelectStatus(int i) {
        switch (i) {
            case 0:
                rl_intro.setSelected(true);
                rl_intro.setBackgroundColor(Color.parseColor("#0097f7"));
                break;
            case 1:
                rl_wait_order.setSelected(true);
                rl_wait_order.setBackgroundColor(Color.parseColor("#0097f7"));
                break;
            case 2:
                rl_wait_check.setSelected(true);
                rl_wait_check.setBackgroundColor(Color.parseColor("#0097f7"));
                break;
            case 3:
                rl_wait_refund.setSelected(true);
                rl_wait_refund.setBackgroundColor(Color.parseColor("#0097f7"));
                break;
            case 4:
                rl_finish.setSelected(true);
                rl_finish.setBackgroundColor(Color.parseColor("#0097f7"));
                break;
        }
    }
    private void createView(int i) {
        switch (i) {
            case 0:
                //全部
                if (mCourseView==null) {
                    mCourseView = new MO_View(this);
                    body.addView(mCourseView.getView());
                }else {
                    mCourseView.getView();
                }
                mCourseView.showView();
                break;
            case 1:
                //待付款
                break;
            case 2:
                //待入住
                break;
            case 3:
                //待退款
                break;
            case 4:
                //已完成
                break;
        }
    }

    private void removeAllView() {
        for (int i = 0; i < body.getChildCount(); i++) {
            body.getChildAt(i).setVisibility(View.GONE);
        }
    }

    private void clearBottomImageState() {
        rl_intro.setBackgroundColor(Color.parseColor("#666666"));
        tv_intro.setTextColor(Color.parseColor("#666666"));
        rl_wait_order.setBackgroundColor(Color.parseColor("#666666"));
        tv_wait_order.setTextColor(Color.parseColor("#666666"));
        rl_wait_check.setBackgroundColor(Color.parseColor("#666666"));
        tv_wait_check.setTextColor(Color.parseColor("#666666"));
        rl_wait_refund.setBackgroundColor(Color.parseColor("#666666"));
        tv_wait_refund.setTextColor(Color.parseColor("#666666"));
        rl_finish.setBackgroundColor(Color.parseColor("#666666"));
        tv_finish.setTextColor(Color.parseColor("#666666"));

        for (int i = 0; i < ll_all.getChildCount(); i++) {
            ll_all.getChildAt(i).setSelected(false);      //取消选中
        }
    }
}