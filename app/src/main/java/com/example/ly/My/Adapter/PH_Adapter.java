package com.example.ly.My.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ly.My.Bean.PH_Bean;
import com.example.ly.R;

import java.util.List;


public class PH_Adapter extends BaseAdapter {

    private final Context mContext;
    private List<List<PH_Bean>> cbl;

    public PH_Adapter(Context context) {
        mContext = context;
    }

    //自定义，把外面传递进来的方法保存
    public void setData(List<List<PH_Bean>> cbl) {    //一个List表示：一个item，两个的话就表示：总章节数/2 item
        this.cbl = cbl;         //保存cbl
        notifyDataSetChanged(); //数据变化时刷新ListView
    }

    @Override
    public int getCount() {
        return cbl == null ? 0 : cbl.size();
    }

    @Override
    public List<PH_Bean> getItem(int position) {
        return cbl == null ? null : cbl.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //ListView的优化方法：
    // 1.复用convertView（节省内存）
    // 2.使用ViewHolder（节省时间）
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder vh;
        //获得Item里的所有控件
        if (view == null) {    //第一次进入
            vh = new ViewHolder();
            LayoutInflater mInflater = LayoutInflater.from(mContext); //获得布局填充器
            view = mInflater.inflate(R.layout.iph_adapter_item, null);
            vh.iv_left_img = (ImageView) view.findViewById(R.id.iv_left_img);
            vh.iv_right_img = (ImageView) view.findViewById(R.id.iv_right_img);
            vh.tv_left_title = (TextView) view.findViewById(R.id.tv_left_title);
            vh.tv_right_title = (TextView) view.findViewById(R.id.tv_right_title);
            view.setTag(vh);   //对vh进行绑定
        } else {               //下次进入
            vh = (ViewHolder) view.getTag();
        }

        //对所有控件进行内容填充
        List<PH_Bean> list = getItem(position);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {   //填充它左右两部分
                final PH_Bean bean = list.get(i); //得到左右两个bean
                switch (i) {                    //开始填充
                    case 0:                    //左边
                        vh.tv_left_title.setText(bean.title);
                        setLeftImg(bean.id, vh.iv_left_img);   //自定义方法设置背景图片
                        break;
                    case 1:                    //右边
                        vh.tv_right_title.setText(bean.title);
                        setRightImg(bean.id, vh.iv_right_img);   //自定义方法设置背景图片
                        break;
                }
            }
        }
        return view;
    }

    private void setRightImg(int id, ImageView iv_right_img) {
        switch (id) {     //根据传递进来的id值来判断要设置哪张图片给它
            case 2:
                iv_right_img.setImageResource(R.drawable.icon);
                break;
            case 4:
                iv_right_img.setImageResource(R.drawable.icon_dy);
                break;
            case 6:
                iv_right_img.setImageResource(R.drawable.icon_qq);
                break;
            case 8:
                iv_right_img.setImageResource(R.drawable.icon_wx);
                break;
            case 10:
                iv_right_img.setImageResource(R.drawable.icon_wb);
                break;
        }
    }

    private void setLeftImg(int id, ImageView iv_left_img) {
        switch (id) {     //根据传递进来的id值来判断要设置哪张图片给它
            case 1:
                iv_left_img.setImageResource(R.drawable.icon);
                break;
            case 3:
                iv_left_img.setImageResource(R.drawable.icon_dy);
                break;
            case 5:
                iv_left_img.setImageResource(R.drawable.icon_qq);
                break;
            case 7:
                iv_left_img.setImageResource(R.drawable.icon_wx);
                break;
            case 9:
                iv_left_img.setImageResource(R.drawable.icon_wb);
                break;
        }
    }

    class ViewHolder {
        ImageView iv_left_img, iv_right_img;
        TextView tv_left_title, tv_right_title;
    }
}
