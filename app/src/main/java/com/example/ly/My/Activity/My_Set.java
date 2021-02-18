package com.example.ly.My.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ly.R;

public class My_Set extends AppCompatActivity {

    private TextView go_back;
    private TextView title_text;
    private RelativeLayout site;
    private RelativeLayout check_person;
    private RelativeLayout change_psw;
    private RelativeLayout about;
    private RelativeLayout sweep_cache;
    private RelativeLayout switch_account;
    private Button exit_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_set);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
    }

    private void init() {
        go_back = (TextView) findViewById(R.id.go_back);
        go_back.setVisibility(View.VISIBLE);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                My_Set.this.finish();
            }
        });
        title_text = (TextView) findViewById(R.id.title_text);
        title_text.setVisibility(View.VISIBLE);
        title_text.setText("设置");

        site = (RelativeLayout) findViewById(R.id.site);                        //收货地址
        check_person = (RelativeLayout) findViewById(R.id.check_person);        //入住人设置
        change_psw = (RelativeLayout) findViewById(R.id.change_psw);            //修改密码
        about = (RelativeLayout) findViewById(R.id.about);                      //关于我们
        sweep_cache = (RelativeLayout) findViewById(R.id.sweep_cache);          //清除缓存
        switch_account = (RelativeLayout) findViewById(R.id.switch_account);    //切换账号
        exit_register = (Button) findViewById(R.id.exit_register);              //退出登录

        check_person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(My_Set.this, Set_Check.class);
                startActivity(intent);
            }
        });
    }
}