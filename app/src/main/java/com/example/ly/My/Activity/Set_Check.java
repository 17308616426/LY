package com.example.ly.My.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ly.My.Adapter.SC_Adapter;
import com.example.ly.My.Bean.SC_Bean;
import com.example.ly.R;

import java.util.ArrayList;

public class Set_Check extends AppCompatActivity {

    private ListView lv_list;
    private ArrayList<SC_Bean> scb;
    private SC_Bean bean;
    private TextView go_back;
    private TextView title_text;
    private Button botton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_check);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();


    }

    private void init() {
        go_back = (TextView) findViewById(R.id.go_back);
        go_back.setVisibility(View.VISIBLE);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Set_Check.this.finish();
            }
        });
        title_text = (TextView) findViewById(R.id.title_text);
        title_text.setVisibility(View.VISIBLE);
        title_text.setText("添加入住人");
        lv_list = (ListView) findViewById(R.id.lv_list);

        botton = (Button) findViewById(R.id.button);
        botton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Set_Check.this, Set_Add.class);
                startActivity(intent);
            }
        });


        SC_Adapter adapter = new SC_Adapter(this);
        //传入数据
        initData();
        adapter.setData(scb);
        lv_list.setAdapter(adapter);

    }

    private void initData() {
        scb = new ArrayList<SC_Bean>();
        for (int i = 0; i < 10; i++) {
            bean = new SC_Bean();
            bean.id = i + 1;
            switch (i) {
                case 0:
                    bean.phone = "111111111111";
                    bean.card = "111111111111111111111111";
                    break;
                case 1:
                    bean.phone = "222222222222";
                    bean.card = "2222222222222222222222222";
                    break;
                case 2:
                    bean.phone = "33333333333";
                    bean.card = "333333333333333333";
                    break;
                case 3:
                    bean.phone = "4444444444444";
                    bean.card = "444444444444444444444444";
                    break;
                case 4:
                    bean.phone = "55555555555";
                    bean.card = "5555555555555555555555";
                    break;
                case 5:
                    bean.phone = "666666666666";
                    bean.card = "6666666666666666666666";
                    break;
                case 6:
                    bean.phone = "77777777777";
                    bean.card = "7777777777777777777777777";
                    break;
                case 7:
                    bean.phone = "888888888";
                    bean.card = "8888888888888888888888888";
                    break;
                case 8:
                    bean.phone = "999999999";
                    bean.card = "99999999999999999999999999999999";
                    break;
                case 9:
                    bean.phone = "0000000000000";
                    bean.card = "0000000000000000000000000000000000";
                    break;
            }//把bean加到edl里面去
            scb.add(bean);
        }
    }

}