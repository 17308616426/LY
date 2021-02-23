package com.example.ly.Message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ly.Message.Bean.MVA_Bean;
import com.example.ly.R;

import java.util.ArrayList;
import java.util.List;

public class Message_View {

    private final Context mContext;
    private View view;
    private RelativeLayout rl_system;
    private TextView tv_system;
    private RelativeLayout rl_me;
    private TextView tv_me;
    private RelativeLayout rl_serve;
    private TextView tv_serve;
    private RelativeLayout rl_service;
    private TextView tv_service;
    private ListView list;
    private final LayoutInflater mInflater;
    private List<MVA_Bean> mva_beans;
    private MVA_Bean bean;


    public Message_View(Context context){
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    private void createView(){
        init();
    }

    public View getView(){
        if (view==null) createView();
        return view;
    }

    public void showView(){
        if (view==null) createView();
        view.setVisibility(View.VISIBLE);
    }


    private void init() {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.message_view, null);

        //系统通知
        rl_system = (RelativeLayout) view.findViewById(R.id.rl_system);
        tv_system = (TextView) view.findViewById(R.id.tv_system);
        //@我的
        rl_me = (RelativeLayout) view.findViewById(R.id.rl_me);
        tv_me = (TextView) view.findViewById(R.id.tv_me);
        //服务通知
        rl_serve = (RelativeLayout) view.findViewById(R.id.rl_serve);
        tv_serve = (TextView) view.findViewById(R.id.tv_serve);
        //客服
        rl_service = (RelativeLayout) view.findViewById(R.id.rl_service);
        tv_service = (TextView) view.findViewById(R.id.tv_service);
        //列表
        list = (ListView) view.findViewById(R.id.list);


        Message_View_Adapter adapter = new Message_View_Adapter(mContext);
        //传入数据
        initData();
        //把数组数据添加到adapter里面
        adapter.setData(mva_beans);
        //最后一步完成 数据添加到list列表里面去
        list.setAdapter(adapter);
    }

    private void initData() {
        mva_beans = new ArrayList<MVA_Bean>();     //把MVA_Bean变成一个数组
        for (int i = 0; i < 4; i++){
            bean = new MVA_Bean();
            bean.id =i + 1;
            switch (i){
                case 0:
                    bean.iv_head = R.drawable.main_2;
                    bean.tv_name = "张一";
                    bean.tv_message = "今天天气很好";
                    break;
                case 1:
                    bean.iv_head = R.drawable.main_2;
                    bean.tv_name = "张二";
                    bean.tv_message = "今天天气很好";
                    break;
                case 2:
                    bean.iv_head = R.drawable.main_2;
                    bean.tv_name = "张三";
                    bean.tv_message = "今天天气很好";
                    break;
                case 3:
                    bean.iv_head = R.drawable.main_2;
                    bean.tv_name = "张四";
                    bean.tv_message = "今天天气很好";
                    break;
            }
            mva_beans.add(bean);    //把bean数据添加到数组里面
        }
    }
}
