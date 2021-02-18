package com.example.ly.My.Activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ly.R;

public class Set_Add extends AppCompatActivity {

    private TextView go_back;
    private TextView title_text;
    private EditText et_name;
    private EditText et_cart;
    private EditText et_phone;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_add);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();

    }

    private void init() {
        go_back = (TextView) findViewById(R.id.go_back);
        go_back.setVisibility(View.VISIBLE);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Set_Add.this.finish();
            }
        });
        title_text = (TextView) findViewById(R.id.title_text);
        title_text.setVisibility(View.VISIBLE);
        title_text.setText("添加入住人");

        et_name = (EditText) findViewById(R.id.et_name);    //输入框：姓名
        et_cart = (EditText) findViewById(R.id.et_cart);    //输入框：身份证
        et_phone = (EditText) findViewById(R.id.et_phone);  //输入框：手机号
        button = (Button) findViewById(R.id.button);        //按钮：保存
    }
}