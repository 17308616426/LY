package com.example.ly.Across_Vertical;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.ly.R;
import java.util.ArrayList;

public class Merchant_State_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_state);

        TextView go_back = (TextView) findViewById(R.id.go_back);
        go_back.setVisibility(View.VISIBLE);
        TextView title_text = (TextView) findViewById(R.id.title_text);
        title_text.setVisibility(View.VISIBLE);
        title_text.setText("房源管理");

        //设置数据源
        VHTableView vht_table=(VHTableView)findViewById(R.id.vht_table);
        ArrayList<String> titleData=new ArrayList<>();
        titleData.add("");
        titleData.add("广州慕吉云溪山居\n  常规|西厢房");  //\n换行的意思
        titleData.add("广州慕吉云溪山居\n  精品|西厢房");

        ArrayList<ArrayList<String>> contentData=new ArrayList<>();

        for(int i=1;i<21;i++){
            ArrayList<String> contentRowData=new ArrayList<>();
            if(i<20) {
                contentRowData.add(i+"");
            }else {
                contentRowData.add(i+"");
            }
            contentRowData.add("|10间");
            contentRowData.add("|5间");
            contentData.add(contentRowData);
        }

        VHTableAdapter tableAdapter=new VHTableAdapter(this,titleData,contentData);
        //vht_table.setFirstColumnIsMove(true);//设置第一列是否可移动,默认不可移动
        //vht_table.setShowTitle(false);//设置是否显示标题行,默认显示
        //一般表格都只是展示用的，所以这里没做刷新，真要刷新数据的话，重新setadaper一次吧
        vht_table.setAdapter(tableAdapter);
    }
}
