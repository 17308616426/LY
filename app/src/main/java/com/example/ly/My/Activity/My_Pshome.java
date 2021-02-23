package com.example.ly.My.Activity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ly.Notch.NotchFit;
import com.example.ly.Notch.args.NotchProperty;
import com.example.ly.Notch.args.NotchScreenType;
import com.example.ly.Notch.core.OnNotchCallBack;
import com.example.ly.Notch.utils.SizeUtils;
import com.example.ly.R;
import com.example.ly.CircleImageViewDrawable;
import com.example.ly.My.View.PH_View;

public class My_Pshome extends AppCompatActivity implements View.OnClickListener {

    private ImageView head;
    private TextView user_name;
    private Button attention;
    private TextView get_praise;
    private TextView get_attention;
    private TextView get_fans;
    private TextView get_love;
    private Button enter_merchant;
    private TextView navigation_all;
    private TextView small_video;
    private TextView short_video;
    private FrameLayout body;
    private TextView go_back;
    private LinearLayout centre_navigation;
    private RelativeLayout one;
    private RelativeLayout two;
    private RelativeLayout three;
    private ImageView img_all;
    private ImageView img_small;
    private ImageView img_short;
    private PH_View mCourseView;
    private LinearLayout rl_all;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_personal_home);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();

        //用户自己定义显示样式(普通屏状态栏适配)   下面就是刘海屏的适配
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        NotchFit.fit(this, NotchScreenType.TRANSLUCENT, new OnNotchCallBack() {
            @Override
            public void onNotchReady(NotchProperty notchProperty) {
                int fitSize;
                if(notchProperty.isNotchEnable()){
                    fitSize = notchProperty.getNotchHeight();
                }
                else {
                    fitSize = SizeUtils.getStatusBarHeight(My_Pshome.this);
                }

                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) rl_all.getLayoutParams();
                marginLayoutParams.topMargin = fitSize;
                rl_all.requestLayout();
            }
        });


        setListener();    //批量事件监听
        setInitStatus();  //进去就是主页面
    }

    private void setInitStatus() {
        clearBottomImageState();    //清除
        setSelectStatus(0);         //设置选中状态是“首页”
        createView(0);              //设置它的视图是“首页”
    }

    private void setListener() {
        for (int i = 0; i < centre_navigation.getChildCount(); i++) {
            centre_navigation.getChildAt(i).setOnClickListener(this);
        }
    }

    private void init() {
        rl_all = (LinearLayout) findViewById(R.id.rl_all);
        go_back = (TextView) findViewById(R.id.go_back);
        go_back.setVisibility(View.VISIBLE);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                My_Pshome.this.finish();
            }
        });
        TextView title_text = (TextView) findViewById(R.id.title_text);
        title_text.setVisibility(View.VISIBLE);
        title_text.setText("个人首页");

        head = (ImageView) findViewById(R.id.head);                             //头像
        user_name = (TextView) findViewById(R.id.user_name);                    //用户名
        attention = (Button) findViewById(R.id.attention);                      //按钮：关注
        get_praise = (TextView) findViewById(R.id.get_praise);                  //或赞数
        get_attention = (TextView) findViewById(R.id.get_attention);            //关注数
        get_fans = (TextView) findViewById(R.id.get_fans);                      //粉丝数
        get_love = (TextView) findViewById(R.id.get_love);                      //喜欢数
        enter_merchant = (Button) findViewById(R.id.enter_merchant);            //按钮：进入商家主页
        //导航栏
        centre_navigation = (LinearLayout) findViewById(R.id.centre_navigation);//导航：全部/小视频/短视频
        one = (RelativeLayout) findViewById(R.id.one);
        img_all = (ImageView) findViewById(R.id.img_all);
        navigation_all = (TextView) findViewById(R.id.navigation_all);          //全部
        img_small = (ImageView) findViewById(R.id.img_small);
        two = (RelativeLayout) findViewById(R.id.two);
        small_video = (TextView) findViewById(R.id.small_video);                //小视频
        img_short = (ImageView) findViewById(R.id.img_short);
        three = (RelativeLayout) findViewById(R.id.three);
        short_video = (TextView) findViewById(R.id.short_video);                //短视频
        //主体
        body = (FrameLayout) findViewById(R.id.body);                           //瀑布流区域



        //设置圆头
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_wx);
        CircleImageViewDrawable drawble = new CircleImageViewDrawable(bitmap);
        head.setImageDrawable(drawble);
    }



    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.one:
                clearBottomImageState();       //创建这个方法，让底部全变灰
                selectDispalyView(0);            //设置选中状态是“首页”
                break;
            case R.id.two:
                clearBottomImageState();       //创建这个方法，让底部全变灰
                selectDispalyView(1);            //设置选中状态是“首页”
                break;
            case R.id.three:
                clearBottomImageState();       //创建这个方法，让底部全变灰
                selectDispalyView(2);            //设置选中状态是“首页”
                break;
        }
    }

    private void selectDispalyView(int i) {
        //删除body里面的所有控件
        removeAllView();
        //填充body
        createView(i);
        //点击显示的页面
        setSelectStatus(i);
    }

    private void setSelectStatus(int i) {
        switch (i) {
            case 0:
                one.setSelected(true);
                navigation_all.setTextColor(Color.parseColor("#0097f7"));
                img_all.setVisibility(View.VISIBLE);
                break;
            case 1:
                two.setSelected(true);
                small_video.setTextColor(Color.parseColor("#0097f7"));
                img_small.setVisibility(View.VISIBLE);
                break;
            case 2:
                three.setSelected(true);
                short_video.setTextColor(Color.parseColor("#0097f7"));
                img_short.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void createView(int i) {
        switch (i) {
            case 0:
                //全部
                if (mCourseView==null) {
                    mCourseView = new PH_View(this);
                    body.addView(mCourseView.getView());
                }else {
                    mCourseView.getView();
                }
                mCourseView.showView();
                break;
            case 1:
                //小视频
                break;
            case 2:
                //短视频
                break;
        }
    }

    private void removeAllView() {
        for (int i = 0; i < body.getChildCount(); i++) {
            body.getChildAt(i).setVisibility(View.GONE);
        }
    }

    private void clearBottomImageState() {
        navigation_all.setTextColor(Color.parseColor("#666666"));
        img_all.setVisibility(View.GONE);
        small_video.setTextColor(Color.parseColor("#666666"));
        img_small.setVisibility(View.GONE);
        short_video.setTextColor(Color.parseColor("#666666"));
        img_short.setVisibility(View.GONE);

        for (int i = 0; i < centre_navigation.getChildCount(); i++) {
            centre_navigation.getChildAt(i).setSelected(false);      //取消选中
        }
    }

}