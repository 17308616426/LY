package com.example.ly.Message;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ly.Message.Bean.MVA_Bean;
import com.example.ly.R;

import java.util.List;

public class Message_View_Adapter extends BaseAdapter {

    private final Context mContext;
    private List<MVA_Bean> mva_beans;
    private View view;
    private ViewHolder vh;

    public Message_View_Adapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<MVA_Bean> mva_beans){
        this.mva_beans = mva_beans;
        notifyDataSetChanged();     //ListView中的数据更改后利用该方法
    }



    @Override
    public int getCount() {
        return mva_beans==null ? 0: mva_beans.size();
    }

    @Override
    public MVA_Bean getItem(int position) {
        return mva_beans==null ? null: mva_beans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            LayoutInflater mInflater = LayoutInflater.from(mContext);
            view = mInflater.inflate(R.layout.message_view_adapter, null);

            vh = new ViewHolder();
            vh.iv_head = (ImageView) view.findViewById(R.id.iv_head);
            vh.tv_name = (TextView) view.findViewById(R.id.tv_name);
            vh.tv_message = (TextView) view.findViewById(R.id.tv_message);
            view.setTag(vh);
        }else {
            view.getTag();
        }

        //设置好item里各个控件的内容
        final MVA_Bean bean = (MVA_Bean) getItem(position);
        if (bean!=null){
            vh.iv_head.setBackgroundResource(bean.iv_head);
            vh.tv_name.setText(bean.tv_name);
            vh.tv_message.setText(bean.tv_message);
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bean == null) return;
                //跳转到聊天页面
//                Intent intent = new Intent(mContext, 哪个页面.class);
//                intent.putExtra("id",bean.id);
//                intent.putExtra("tv_name",bean.tv_name);
//                mContext.startActivity(intent);
            }
        });
        return view;
    }

    class ViewHolder{
        public ImageView iv_head;
        public TextView tv_name,tv_message;
    }
}
