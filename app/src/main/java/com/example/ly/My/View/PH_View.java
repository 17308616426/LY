package com.example.ly.My.View;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import androidx.fragment.app.FragmentActivity;

import com.example.ly.My.Adapter.PH_Adapter;
import com.example.ly.My.Bean.PH_Bean;
import com.example.ly.R;
import com.example.ly.My.Util.PH_Util;

import java.io.InputStream;
import java.util.List;

public class PH_View {
    private ListView lv_list;
    private PH_Adapter adapter;
    private List<List<PH_Bean>> cbl;
    private FragmentActivity mContext;
    private LayoutInflater mInflater;
    private View mCurrentView;

    public PH_View(FragmentActivity context){
        mContext=context;
    }
    private void createView(){
        getCourseData();
        initView();
    }

    private void initView() {
        mInflater= LayoutInflater.from(mContext);
        mCurrentView = mInflater.inflate(R.layout.iph_view,null);
        lv_list=(ListView)mCurrentView.findViewById(R.id.lv_list);
        adapter=new PH_Adapter(mContext);
        adapter.setData(cbl);
        lv_list.setAdapter(adapter);
    }
    private void getCourseData(){
        try {
            InputStream is=mContext.getResources().getAssets().open("iph.xml");
            cbl= PH_Util.getIPHinfos(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public View getView(){
        if (mCurrentView==null){
            createView();
        }
        return mCurrentView;
    }

    public void showView(){
        if (mCurrentView==null){
            createView();
        }
        mCurrentView.setVisibility(View.VISIBLE);
    }
}
