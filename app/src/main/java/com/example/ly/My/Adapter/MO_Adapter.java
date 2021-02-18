package com.example.ly.My.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.ly.My.Bean.MO_Bean;
import com.example.ly.R;

import java.util.List;

public class MO_Adapter extends BaseAdapter {

    private final Context mContext;
    private List<MO_Bean> imo;
    private ViewHolder vh;

    public MO_Adapter(Context context) {
        mContext = context;
    }

    public void setData(List<MO_Bean> oib) {
        this.imo = oib;
        notifyDataSetChanged();  //ListView中的数据更改后利用该方法ListView
    }

    @Override
    public int getCount() {
        return imo == null ? 0 : imo.size();
    }

    @Override
    public Object getItem(int position) {
        return imo == null ? null : imo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = LayoutInflater.from(mContext);
            convertView = mInflater.inflate(R.layout.imo_adapter, null);
            vh = new ViewHolder();
            vh.order_mark = (TextView) convertView.findViewById(R.id.order_mark);       //订单号
            vh.wait_order = (TextView) convertView.findViewById(R.id.wait_order);       //待接单
            vh.house_name = (TextView) convertView.findViewById(R.id.house_name);       //酒店名
            vh.data = (TextView) convertView.findViewById(R.id.data);                   //日期
            vh.reserve_type = (TextView) convertView.findViewById(R.id.reserve_type);   //预定类型
            vh.money = (TextView) convertView.findViewById(R.id.money);                 //支付金额
            vh.reserve_way = (TextView) convertView.findViewById(R.id.reserve_way);     //预定方式
            vh.remark = (TextView) convertView.findViewById(R.id.remark);               //备注
            vh.name = (TextView) convertView.findViewById(R.id.name);                   //姓名
            vh.phone = (TextView) convertView.findViewById(R.id.phone);                 //电话
            vh.accept = (Button) convertView.findViewById(R.id.accept);                 //按钮：接单
            vh.refuse = (Button) convertView.findViewById(R.id.refuse);                 //按钮：拒单
            convertView.setTag(vh);
        } else {
            convertView.getTag(); //不为空说明已经进入过这个方法
        }
        //设置好item里各个控件的内容
        final MO_Bean bean = (MO_Bean) getItem(position);
        if (bean!=null) {
            vh.order_mark.setText(bean.order_mark);
            vh.wait_order.setText(bean.wait_order);
            vh.house_name.setText(bean.house_name);
            vh.data.setText(bean.data);
            vh.reserve_type.setText(bean.reserve_type);
            vh.money.setText(bean.money);
            vh.reserve_way.setText(bean.reserve_way);
            vh.remark.setText(bean.remark);
            vh.name.setText(bean.name);
            vh.phone.setText(bean.phone);
        }
        return convertView;
    }

    static class ViewHolder {
        public TextView order_mark, wait_order, house_name, data, reserve_type, money, reserve_way, remark, name, phone;
        public Button accept,refuse;
    }
}

