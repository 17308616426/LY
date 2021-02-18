package com.example.ly.My.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ly.Across_Vertical.Merchant_State_Activity;
import com.example.ly.R;
import com.example.ly.CircleImageViewDrawable;

public class My_Merchant extends AppCompatActivity {

    private ImageView head;
    private TextView user_name;
    private TextView phone;
    private TextView site;
    private RelativeLayout order_num;
    private RelativeLayout turnover;
    private RelativeLayout wait_list;
    private RelativeLayout pending_order;
    private RelativeLayout house_manage;
    private RelativeLayout order_manage;
    private RelativeLayout data_statistics;
    private TextView go_back;
    private TextView title_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_merchant);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
    }

    private void init() {
        go_back = (TextView) findViewById(R.id.go_back);
        go_back.setVisibility(View.VISIBLE);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                My_Merchant.this.finish();
            }
        });
        title_text = (TextView) findViewById(R.id.title_text);
        title_text.setVisibility(View.VISIBLE);
        title_text.setText("商家管理");
        head = (ImageView) findViewById(R.id.head);
        //设置为圆头像
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_wx);
        CircleImageViewDrawable drawble = new CircleImageViewDrawable(bitmap);
        head.setImageDrawable(drawble);

        user_name = (TextView) findViewById(R.id.user_name);                    //名宿名
        phone = (TextView) findViewById(R.id.phone);                            //电话
        site = (TextView) findViewById(R.id.site);                              //地址
        order_num = (RelativeLayout) findViewById(R.id.order_num);              //总订单数
        turnover = (RelativeLayout) findViewById(R.id.turnover);                //总交易额
        wait_list = (RelativeLayout) findViewById(R.id.wait_list);              //待接订单
        pending_order = (RelativeLayout) findViewById(R.id.pending_order);      //待入住订单
        house_manage = (RelativeLayout) findViewById(R.id.house_manage);        //房源管理
        order_manage = (RelativeLayout) findViewById(R.id.order_manage);        //订单管理
        data_statistics = (RelativeLayout) findViewById(R.id.data_statistics);  //数据统计

        order_manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(My_Merchant.this, Merchant_Order.class);
                startActivity(intent);
            }
        });

        house_manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(My_Merchant.this, Merchant_State_Activity.class);
                startActivity(intent);
            }
        });

        data_statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(My_Merchant.this, Merchant_Data.class);
                startActivity(intent);
            }
        });
    }
}