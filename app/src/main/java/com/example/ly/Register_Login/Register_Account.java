package com.example.ly.Register_Login;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ly.R;

public class Register_Account extends AppCompatActivity {

    private EditText account_number;
    private TextView go_back;
    private EditText ps;
    private ImageView show_ps;
    private TextView phone_register;
    private Button click_register;
    private ImageView icon_wx;
    private ImageView icon_qq;
    private ImageView icon_dy;
    private ImageView icon_wb;
    private String number;
    private String password;
    private TextView forget_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_account);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
    }

    private void init() {
        go_back = (TextView) findViewById(R.id.go_back);                     //返回
        account_number = (EditText) findViewById(R.id.account_number);       //账号输入框
        ps = (EditText) findViewById(R.id.ps);                               //密码输入框
        show_ps = (ImageView) findViewById(R.id.show_ps);                     //是否显示密码
        phone_register = (TextView) findViewById(R.id.phone_register);       //手机短信快速登录
        forget_password = (TextView) findViewById(R.id.forget_password);     //忘记密码
        click_register = (Button) findViewById(R.id.click_register);         //"登录"按钮
        icon_wx = (ImageView) findViewById(R.id.icon_wx);                    //微信图标
        icon_qq = (ImageView) findViewById(R.id.icon_qq);                    //QQ图标
        icon_dy = (ImageView) findViewById(R.id.icon_dy);                    //抖音图标
        icon_wb = (ImageView) findViewById(R.id.icon_wb);                    //微博图标

        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register_Account.this, Register_Way.class);
                startActivity(intent);
            }
        });
        click_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditString();
                if (TextUtils.isEmpty(number)) {   //判断文本框是否为空
                    Toast.makeText(Register_Account.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(password)){
                    Toast.makeText(Register_Account.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
        phone_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register_Account.this, Register_Phone.class);
                startActivity(intent);
            }
        });
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register_Account.this, Retrieve_Password.class);
                startActivity(intent);
            }
        });



    }


    private void getEditString() {
        number = account_number.getText().toString().trim();
        password = this.ps.getText().toString().trim();
    }
}