package com.example.ly.My;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ly.MainActivity;
import com.example.ly.My.Activity.My_Merchant;
import com.example.ly.My.Activity.My_Pshome;
import com.example.ly.My.Activity.My_Set;
import com.example.ly.Notch.NotchFit;
import com.example.ly.Notch.args.NotchProperty;
import com.example.ly.Notch.args.NotchScreenType;
import com.example.ly.Notch.core.OnNotchCallBack;
import com.example.ly.Notch.utils.SizeUtils;
import com.example.ly.R;


public class My_View extends AppCompatActivity {
    private Activity mContext;
    private LayoutInflater mInflater;
    private View view;

    private RelativeLayout background;
    private ImageView head;
    private TextView user_name;
    private TextView sign_in;
    private TextView compile_data;
    private ImageView information;
    private TextView balance;
    private TextView integral;
    private TextView coupons;
    private RelativeLayout examine;
    private ImageView shrink_one;
    private RelativeLayout video;
    private RelativeLayout shop;
    private ImageView shrink_two;
    private RelativeLayout wait_payment;
    private RelativeLayout wait_check;
    private RelativeLayout wait_receiving;
    private RelativeLayout wait_evaluate;
    private ImageView shrink_three;
    private RelativeLayout share_award;
    private RelativeLayout commission;
    private RelativeLayout spread_qr;
    private RelativeLayout share_guide;
    private RelativeLayout share_ranking;
    private RelativeLayout manage;
    private RelativeLayout service;
    private RelativeLayout message;
    private RelativeLayout set;
    private Resources resources;
    private ScrollView all;


    //构造函数
    public My_View(Activity context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    //方便后面调用
    private void createView() {
        init();
    }

    //判断three_info是否为空，为空就创建
    public View getView() {
        if (view == null) createView();
        return view;
    }

    //没显示出来就让它显示出来
    public void showView() {
        if (view == null) createView();
        view.setVisibility(View.VISIBLE);
    }

    //“我的”页面
    private void init() {
        view = mInflater.inflate(R.layout.my_bottom, null);
        view.setVisibility(View.VISIBLE);
//        all = (ScrollView) view.findViewById(R.id.all);
        background = (RelativeLayout) view.findViewById(R.id.background);        //背景
        head = (ImageView) view.findViewById(R.id.head);                    //头像
        user_name = (TextView) view.findViewById(R.id.user_name);           //名字
        sign_in = (TextView) view.findViewById(R.id.sign_in);               //按钮：签到
        compile_data = (TextView) view.findViewById(R.id.compile_data);     //按钮：编辑资料
        information = (ImageView) view.findViewById(R.id.information);      //图标：消息
        balance = (TextView) view.findViewById(R.id.balance);               //余额充值
        integral = (TextView) view.findViewById(R.id.integral);             //我的积分
        coupons = (TextView) view.findViewById(R.id.coupons);               //优惠券

        examine = (RelativeLayout) view.findViewById(R.id.examine);              //按钮:查看权益
        shrink_one = (ImageView) view.findViewById(R.id.shrink_one);             //收缩：创作中心
        video = (RelativeLayout) view.findViewById(R.id.video);                  //我的视频
        shop = (RelativeLayout) view.findViewById(R.id.shop);                    //我的小店

        shrink_two = (ImageView) view.findViewById(R.id.shrink_two);              //收缩:我的订单
        wait_payment = (RelativeLayout) view.findViewById(R.id.wait_payment);     //待付款
        wait_check = (RelativeLayout) view.findViewById(R.id.wait_check);         //待入住
        wait_receiving = (RelativeLayout) view.findViewById(R.id.wait_Receiving); //待收货
        wait_evaluate = (RelativeLayout) view.findViewById(R.id.wait_evaluate);   //待评价

        shrink_three = (ImageView) view.findViewById(R.id.shrink_three);          //收缩:分销中心
        share_award = (RelativeLayout) view.findViewById(R.id.share_award);       //分享奖励
        commission = (RelativeLayout) view.findViewById(R.id.commission);         //分销返佣
        spread_qr = (RelativeLayout) view.findViewById(R.id.spread_qr);           //推广二维码
        share_guide = (RelativeLayout) view.findViewById(R.id.share_guide);       //分享指南
        share_ranking = (RelativeLayout) view.findViewById(R.id.share_ranking);   //分享排行榜

        manage = (RelativeLayout) view.findViewById(R.id.manage);                 //商家管理
        service = (RelativeLayout) view.findViewById(R.id.service);               //我的客服
        message = (RelativeLayout) view.findViewById(R.id.message);               //常用信息
        set = (RelativeLayout) view.findViewById(R.id.set);                       //设置

        //设置圆头！！报错
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_wx);
//        CircleImageViewDrawable drawble = new CircleImageViewDrawable(bitmap);
//        head.setImageDrawable(drawble);

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, My_Set.class);
                mContext.startActivity(intent);
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, My_Pshome.class);
                mContext.startActivity(intent);
            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, My_Pshome.class);
                mContext.startActivity(intent);
            }
        });
        manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, My_Merchant.class);
                mContext.startActivity(intent);
            }
        });
    }
}
