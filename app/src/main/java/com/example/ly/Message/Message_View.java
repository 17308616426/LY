package com.example.ly.Message;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ly.R;

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


    }

}
