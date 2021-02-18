package com.example.ly.Register_Login;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ly.R;

import java.util.Timer;
import java.util.TimerTask;

public class Register_Phone extends AppCompatActivity {
    private TextView go_back;
    private TextView import_number;
    private TextView gain_verification;
    private TextView import_note;
    private TextView account_button;
    private TextView click_register;
    private ImageView icon_wx;
    private ImageView icon_qq;
    private ImageView icon_dy;
    private ImageView icon_wb;
    private TextView welcome_back;
    private Timer mTimer = null;
    private int countdown = 60;
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            gain_verification.setText(countdown + "秒");    //设置显示内容
            gain_verification.setAlpha(0.5f);               //设置透明
            if (0 == countdown) {
                //停止倒计时时显示页面
                resume();
                stopTimer();
                return;
            }

            countdown--;  //数字倒计
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_phone);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();

    }

    private void init() {
        go_back = (TextView) findViewById(R.id.go_back);                       //“返回”按钮
        welcome_back = (TextView) findViewById(R.id.welcome_back);             //欢迎回来
        import_number = (TextView) findViewById(R.id.import_number);           //编辑框：手机号
        gain_verification = (TextView) findViewById(R.id.gain_verification);   //按钮：倒计时
        import_note = (TextView) findViewById(R.id.import_note);               //编辑框：验证码
        account_button = (TextView) findViewById(R.id.account_button);         //文字：“账号/密码登录”
        click_register = (TextView) findViewById(R.id.click_register);         //按钮：登录
        icon_wx = (ImageView) findViewById(R.id.icon_wx);                      //图标：微信
        icon_qq = (ImageView) findViewById(R.id.icon_qq);                      //图标：QQ
        icon_dy = (ImageView) findViewById(R.id.icon_dy);                      //图标：抖音
        icon_wb = (ImageView) findViewById(R.id.icon_wb);                      //图标：微博
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register_Phone.this, Register_Way.class);
                startActivity(intent);
            }
        });
        account_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register_Phone.this, Register_Account.class);
                startActivity(intent);
            }
        });
        gain_verification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });
    }

    //开始倒计时
    private void startTimer() {
        //点击获取验证码后改变按钮的状态,让按钮不可点击
        gain_verification.setClickable(false);
        if (mTimer == null) {
            mTimer = new Timer(true);
        }
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(1);           //sendEmptyMessage：发送空信息
            }
        }, 0, 1000);
    }

    private void resume() {
        countdown = 60;
        //倒计时结束后,让按钮重新可点击
        gain_verification.setClickable(true);
        gain_verification.setText("重发");
        gain_verification.setAlpha(0.9f);
    }

    private void stopTimer() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
        }
    }


}