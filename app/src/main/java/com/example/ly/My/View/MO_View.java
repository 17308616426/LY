package com.example.ly.My.View;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import androidx.fragment.app.FragmentActivity;

import com.example.ly.My.Adapter.MO_Adapter;
import com.example.ly.My.Bean.MO_Bean;
import com.example.ly.R;

import java.util.ArrayList;

public class MO_View {
    private final FragmentActivity mContext;

    private View view;
    private ArrayList<MO_Bean> imo;
    private MO_Bean bean;


    //构造函数
    public MO_View(FragmentActivity context) {
        mContext = context;
    }

    private void createView() {
        //传入数据
        initData();
        initView();
    }


    private void initView() {
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.imo_view, null);
        ListView lv_list = (ListView) view.findViewById(R.id.lv_list);
        MO_Adapter adapter = new MO_Adapter(mContext);
        adapter.setData(imo);
        lv_list.setAdapter(adapter);
    }


    private void initData() {
        imo = new ArrayList<MO_Bean>();
        for (int i = 0; i < 3; i++) {
            bean = new MO_Bean();
            bean.id = i + 1;
            switch (i) {
                case 0:
                    bean.order_mark = "123138585415";
                    bean.wait_order = "待接单";
                    bean.house_name = "潮州宾馆";
                    bean.data = "2020.12.3-2020.12.4";
                    bean.reserve_type = "东厢房";
                    bean.money = "0";
                    bean.reserve_way = "名宿会员卡";
                    bean.remark = "名宿非常干净，环境非常幽美";
                    bean.name = "托马斯";
                    bean.phone = "1390708573";
                    break;
                case 1:
                    bean.order_mark = "12313885415";
                    bean.wait_order = "待接单";
                    bean.house_name = "潮州宾馆";
                    bean.data = "2020.12.3-2020.12.4";
                    bean.reserve_type = "东厢房";
                    bean.money = "0";
                    bean.reserve_way = "名宿会员卡";
                    bean.remark = "名宿非常干净，环境非常幽美";
                    bean.name = "托马斯";
                    bean.phone = "1390708573";
                    break;
                case 2:
                    bean.order_mark = "1231585415";
                    bean.wait_order = "待接单";
                    bean.house_name = "潮州宾馆";
                    bean.data = "2020.12.3-2020.12.4";
                    bean.reserve_type = "东厢房";
                    bean.money = "0";
                    bean.reserve_way = "名宿会员卡";
                    bean.remark = "名宿非常干净，环境非常幽美";
                    bean.name = "托马斯";
                    bean.phone = "1390708573";
                    break;
            }
            imo.add(bean);
        }
    }

    public View getView() {
        if (view == null) {
            createView();
        }
        return view;
    }

    public void showView() {
        if (view == null) {
            createView();
        }
        view.setVisibility(View.VISIBLE);
    }
}


