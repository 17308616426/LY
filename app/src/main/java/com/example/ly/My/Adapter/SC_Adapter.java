package com.example.ly.My.Adapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.ly.My.Bean.SC_Bean;
import com.example.ly.R;
import java.util.List;

public class SC_Adapter extends BaseAdapter {
    private final Context mContext;
    private List<SC_Bean> scb;
    private ViewHolder vh;
    private SC_Bean bean;

    //保存上下文
    public SC_Adapter(Context context) {
        this.mContext = context;
    }

    //保存获得到的数据
    public void setData(List<SC_Bean> scb) {
        this.scb = scb;
        notifyDataSetChanged();  //ListView中的数据更改后利用该方法ListView
    }

    @Override
    public int getCount() {
        return scb == null ? 0 : scb.size();
    }

    @Override
    public Object getItem(int position) {
        return scb == null ? null : scb.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("CutPasteId")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //判断convertView为空的情况下
        if (convertView == null) {
            LayoutInflater mInflater = LayoutInflater.from(mContext);
            convertView = mInflater.inflate(R.layout.sc_adapter_item, null);
            vh = new ViewHolder();
            vh.phone = (TextView) convertView.findViewById(R.id.phone);
            vh.card = (TextView) convertView.findViewById(R.id.phone);
            convertView.setTag(vh);
        } else {
            convertView.getTag();
        }
        //设置好item里各个控件的内容
        bean = (SC_Bean) getItem(position);
        if (bean != null) {
            vh.phone.setText(bean.phone);
            vh.card.setText(bean.card);
        }
//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (bean == null) return;
                //跳转至编辑页(待编辑)
//                Intent intent = new Intent(mContext,OneDetailActivity.class);
//                intent.putExtra("id",bean.id);        //把id传递过去（第几章的试题）
//                intent.putExtra("title",bean.title);  //标题
//                mContext.startActivity(intent);
//            }
//        });
        return convertView;
    }

    class ViewHolder {
        public TextView phone, card;
    }
}
