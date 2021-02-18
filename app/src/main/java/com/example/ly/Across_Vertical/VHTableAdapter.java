package com.example.ly.Across_Vertical;

import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.example.ly.R;

import java.util.ArrayList;

public class VHTableAdapter implements VHBaseAdapter {
    private Context context;
    private ArrayList<String> titleData;
    private ArrayList<ArrayList<String>> dataList;
    private EditText et_library;
    private TextView tv_data_start;
    private TextView tv_data_end;
    private Button bt_open;
    private Button bt_close;

    public VHTableAdapter(Context context, ArrayList<String> titleData, ArrayList<ArrayList<String>> dataList) {
        this.context=context;
        this.titleData=titleData;
        this.dataList=dataList;
    }

    //表格内容的行数，不包括标题行
    @Override
    public int getContentRows() {
        return dataList.size();
    }

    //列数
    @Override
    public int getContentColumn() {
        return titleData.size();
    }

    //标题的view，这里从0开始，这里要注意，一定要有view返回去，不能为null，每一行
    // 各列的宽度就等于标题行的列的宽度，且边框的话，自己在这里和下文的表格单元格view里面设置
    @Override
    public View getTitleView(int columnPosition, ViewGroup parent) {

        TextView tv_item = new TextView(context);
        tv_item.setBackgroundResource(R.drawable.bg_shape_black);     //设置表格边框以及背景
        if(0==columnPosition){
            tv_item.setPadding(100, 40, 50, 100); //左上右下
        }else {
            tv_item.setPadding(50, 40, 50, 40);
        }
        tv_item.setText(titleData.get(columnPosition));
        tv_item.setGravity(Gravity.CENTER);
        tv_item.setTextColor(context.getResources().getColor(R.color.black));
        return tv_item;
    }

    //表格正文的view，行和列都从0开始，宽度的话在载入的时候，默认会是以标题行各列的宽度，高度的话自适应
    @Override
    public View getTableCellView(int contentRow, int contentColum, View view, ViewGroup parent) {
        if(null==view) {
            view = new TextView(context);
        }

        view.setBackgroundResource(R.drawable.bg_shape_gray);
        view.setPadding(40, 40, 40, 40);
        ((TextView)view).setText(dataList.get(contentRow).get(contentColum));
        ((TextView)view).setGravity(Gravity.CENTER);
        //为了更灵活一些，在VHTableView没收做设置边框，在这里通过背景实现，我这里的背景边框是顺手设的，要是想美观点的话，对应的边框做一下对应的设置就好
        ((TextView)view).setTextColor(context.getResources().getColor(R.color.black));



        //跳转对话框
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context,R.style.Pop);       //把信息放在对话框(AlertDialog)里头
                builder.setTitle("广州慕吉云溪山居  常规|西厢房");
                LayoutInflater mInflater = LayoutInflater.from(context);
                View view = mInflater.inflate(R.layout.dialog , null);
                et_library = (EditText) view.findViewById(R.id.et_library);
                tv_data_start = (TextView) view.findViewById(R.id.tv_data_start);
                tv_data_end = (TextView) view.findViewById(R.id.tv_data_end);
                bt_open = (Button) view.findViewById(R.id.bt_open);
                bt_close = (Button) view.findViewById(R.id.bt_close);
                builder.setView(view);

                //确定
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String a = et_library.getText().toString().trim();
                        //    将输入的用户名和密码打印出来
                        Toast.makeText(context,"请输入库存", Toast.LENGTH_SHORT).show();
                    }
                });
                //取消
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });
        return view;
    }

    @Override
    public Object getItem(int contentRow) {
        return dataList.get(contentRow);
    }

    //每一行被点击的时候的回调
    @Override
    public void OnClickContentRowItem(int row, View convertView) {
    }
}
