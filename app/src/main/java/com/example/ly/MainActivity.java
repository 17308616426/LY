package com.example.ly;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ly.Message.Message_View;
import com.example.ly.My.My_View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout title_bar;
    private TextView go_back;
    private TextView title_text;
    private FrameLayout body;
    private LinearLayout bottom_navigation;
    private RelativeLayout bottom_home;
    private TextView bottom_home_word;
    private ImageView bottom_home_picture;
    private RelativeLayout bottom_find;
    private TextView bottom_find_word;
    private ImageView bottom_find_picture;
    private RelativeLayout bottom_list;
    private TextView bottom_list_word;
    private ImageView bottom_list_picture;
    private RelativeLayout bottom_user;
    private TextView bottom_user_word;
    private ImageView bottom_user_picture;

    private My_View bottom__viewMe;


    private long exitTime;
    private Message_View message_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
        initBottomBar();

        setListener();
        setInitStatus();
    }

    //进去就是主页面
    private void setInitStatus() {
        clearBottomImageState();    //清除
        setSelectStatus(0);         //设置选中状态是“首页”
        createView(0);              //设置它的视图是“首页”
    }

    //批量事件监听
    private void setListener() {
        for (int i = 0; i < bottom_navigation.getChildCount(); i++) {
            bottom_navigation.getChildAt(i).setOnClickListener(this);
        }
    }

    //初始化底部
    private void initBottomBar() {
        bottom_navigation = (LinearLayout) findViewById(R.id.bottom_navigation);
        bottom_home = (RelativeLayout) findViewById(R.id.bottom_home);
        bottom_home_word = (TextView) findViewById(R.id.bottom_home_word);
        bottom_home_picture = (ImageView) findViewById(R.id.bottom_home_picture);

        bottom_find = (RelativeLayout) findViewById(R.id.bottom_find);
        bottom_find_word = (TextView) findViewById(R.id.bottom_find_word);
        bottom_find_picture = (ImageView) findViewById(R.id.bottom_find_picture);

        bottom_list = (RelativeLayout) findViewById(R.id.bottom_list);
        bottom_list_word = (TextView) findViewById(R.id.bottom_list_word);
        bottom_list_picture = (ImageView) findViewById(R.id.bottom_list_picture);

        bottom_user = (RelativeLayout) findViewById(R.id.bottom_user);
        bottom_user_word = (TextView) findViewById(R.id.bottom_user_word);
        bottom_user_picture = (ImageView) findViewById(R.id.bottom_user_picture);
    }

    //初始化标题栏
    private void init() {
        title_bar = (RelativeLayout) findViewById(R.id.title_bar);
        title_bar.setBackgroundColor(Color.parseColor("#30b4ff"));
        go_back = (TextView) findViewById(R.id.go_back);
        go_back.setVisibility(View.GONE);
        title_text = (TextView) findViewById(R.id.title_text);
        initBodyLayout();
    }

    //初始化主体
    private void initBodyLayout() {
        body = (FrameLayout) findViewById(R.id.body);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bottom_home:
                clearBottomImageState();       //创建这个方法，让底部全变灰
                selectDispalyView(0);            //设置选中状态是“首页”
                break;
            case R.id.bottom_find:
                clearBottomImageState();       //创建这个方法，让底部全变灰
                selectDispalyView(1);            //设置选中状态是“信息”
                break;
            case R.id.bottom_list:
                clearBottomImageState();       //创建这个方法，让底部全变灰
                selectDispalyView(2);            //设置选中状态是“我”
                break;
            case R.id.bottom_user:
                clearBottomImageState();       //创建这个方法，让底部全变灰
                selectDispalyView(3);            //设置选中状态是“我”
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
                title_bar.setVisibility(View.GONE);
                title_text.setText("首页");
                bottom_home.setSelected(true);
                bottom_home_word.setTextColor(Color.parseColor("#0097f7"));
                bottom_home_picture.setImageResource(R.drawable.bottom_home);
                break;
            case 1:
                title_bar.setVisibility(View.GONE);
                title_text.setText("发现");
                bottom_find.setSelected(true);
                bottom_find_word.setTextColor(Color.parseColor("#0097f7"));
                bottom_find_picture.setImageResource(R.drawable.bottom_find);
                break;
            case 2:
                title_bar.setVisibility(View.GONE);
                title_text.setText("订单");
                bottom_list.setSelected(true);
                bottom_list_word.setTextColor(Color.parseColor("#0097f7"));
                bottom_list_picture.setImageResource(R.drawable.bottom_list);
                break;
            case 3:
                title_bar.setVisibility(View.GONE);
                title_text.setText("我的");
                bottom_user.setSelected(true);
                bottom_user_word.setTextColor(Color.parseColor("#0097f7"));
                bottom_user_picture.setImageResource(R.drawable.bottom_user);
                break;
        }
    }

    private void createView(int i) {
        switch (i) {
            case 0:
                //首页
                break;
            case 1:
                //发现
                break;
            case 2:
                //消息
                if (message_view==null){
                    message_view = new Message_View(this);
                    body.addView(message_view.getView());
                }else {
                    message_view.getView();
                }
                message_view.showView();
                break;
            case 3:
                //我的
                if (bottom__viewMe == null) {
                    bottom__viewMe = new My_View(this);
                    body.addView(bottom__viewMe.getView());
                } else {
                    bottom__viewMe.getView();
                }
                bottom__viewMe.showView();
                break;
        }
    }

    private void removeAllView() {
        for (int i = 0; i < body.getChildCount(); i++) {
            body.getChildAt(i).setVisibility(View.GONE);
        }
    }

    //导航栏控件全部变灰并取消选中
    private void clearBottomImageState() {
        bottom_home_word.setTextColor(Color.parseColor("#666666"));
        bottom_home_picture.setImageResource(R.drawable.bottom_home);
        bottom_find_word.setTextColor(Color.parseColor("#666666"));
        bottom_find_picture.setImageResource(R.drawable.bottom_find);
        bottom_list_word.setTextColor(Color.parseColor("#666666"));
        bottom_list_picture.setImageResource(R.drawable.bottom_list);
        bottom_user_word.setTextColor(Color.parseColor("#666666"));
        bottom_user_picture.setImageResource(R.drawable.bottom_user);

        for (int i = 0; i < bottom_navigation.getChildCount(); i++) {
            bottom_navigation.getChildAt(i).setSelected(false);      //取消选中
        }
    }

    //点击退出时提示“再按一次退出旅影”
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {      //表示当前按下的是返回键
            if (System.currentTimeMillis() - exitTime > 2000) {
                Toast.makeText(MainActivity.this, "再按一次就退出旅影", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                MainActivity.this.finish();
                //把登陆的状态给清除掉，要不然下次登陆还在
                if (readLoginStatus()) clearLoginStatus();
            }
            return true;    //直接true，不要让它继续往下
        }
        return super.onKeyDown(keyCode, event);
    }

    private void clearLoginStatus() {
        SharedPreferences sp = getSharedPreferences("registerInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isRegister", false);
        editor.putString("registerUserName", "");
        editor.commit();       //提交上去
    }

    private boolean readLoginStatus() {
        SharedPreferences sp = getSharedPreferences("registerInfo", MODE_PRIVATE);
        boolean isRegister = sp.getBoolean("isRegister", false);      //默认不是登陆状态
        return isRegister;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            boolean isRegister = data.getBooleanExtra("isRegister", false);   //得到返回的数据
            if (isRegister) {
                clearBottomImageState();  //底部状态清空
                selectDispalyView(0);  //跳到第一个页面
            }
            //“点击登录”显示用户名
//            if (threeView!=null){
//                threeView.setRegisterParams(isRegister);
//            }
        }
    }
}
