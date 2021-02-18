package com.example.ly.My.Activity;

import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ly.R;
import com.example.ly.CircleImageViewDrawable;

public class My_Data extends AppCompatActivity {

    private TextView go_back;
    private TextView title_text;
    private TextView right_text;
    private RelativeLayout head;
    private TextView data_autonym;
    private ImageView data_head;
    private EditText data_nickname;
    private RelativeLayout sex;
    private TextView data_sex;
    private RelativeLayout birth;
    private TextView data_birth;
    private RelativeLayout hobby;
    private TextView data_hobby_three;
    private TextView data_hobby_two;
    private TextView data_hobby_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
    }

    private void init() {
//        导航栏
        title_text = (TextView) findViewById(R.id.title_text);
        title_text.setVisibility(View.VISIBLE);
        title_text.setText("编辑资料");
        right_text = (TextView) findViewById(R.id.right_text);
        right_text.setVisibility(View.VISIBLE);
        right_text.setText("实名认证");
        go_back = (TextView) findViewById(R.id.go_back);
        go_back.setVisibility(View.VISIBLE);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                My_Data.this.finish();
            }
        });
//      头像
        head = (RelativeLayout) findViewById(R.id.head);
        data_autonym = (TextView) findViewById(R.id.data_autonym);
        data_head = (ImageView) findViewById(R.id.data_head);
//      用户昵称
        data_nickname = (EditText) findViewById(R.id.data_nickname);
//      性别
        sex = (RelativeLayout) findViewById(R.id.sex);
        data_sex = (TextView) findViewById(R.id.data_sex);
//      出生年月
        birth = (RelativeLayout) findViewById(R.id.birth);
        data_birth = (TextView) findViewById(R.id.data_birth);
//      爱好
        hobby = (RelativeLayout) findViewById(R.id.hobby);
        data_hobby_three = (TextView) findViewById(R.id.data_hobby_three);
        data_hobby_two = (TextView) findViewById(R.id.data_hobby_two);
        data_hobby_one = (TextView) findViewById(R.id.data_hobby_one);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_wx);
        CircleImageViewDrawable drawble = new CircleImageViewDrawable(bitmap);
        data_head.setImageDrawable(drawble);
    }


}