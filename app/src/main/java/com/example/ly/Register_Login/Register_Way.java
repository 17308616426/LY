package com.example.ly.Register_Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ly.R;

public class Register_Way extends AppCompatActivity {

    private Button phone_button;
    private Button account_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_way);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
    }

    private void init() {
        phone_button = (Button) findViewById(R.id.phone_button);
        account_button = (Button) findViewById(R.id.account_button);
//      skip>手机号登录页面
        phone_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register_Way.this, Register_Phone.class);
                startActivity(intent);
            }
        });
//      skip>账号登录页面
        account_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register_Way.this, Register_Account.class);
                startActivity(intent);
            }
        });
    }

}