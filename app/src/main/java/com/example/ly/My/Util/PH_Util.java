package com.example.ly.My.Util;

import android.util.Xml;

import com.example.ly.My.Bean.PH_Bean;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PH_Util {

    //IPH
    public static List<List<PH_Bean>> getIPHinfos(InputStream is) throws Exception {
        ArrayList<List<PH_Bean>> IPHinfos = null;
        ArrayList<PH_Bean> IPHinfo = null;
        PH_Bean bean = null;
        int count=0;

        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(is,"utf-8");      //将输入流跟它一起绑定
        int type = parser.getEventType(); //得到事件类型
        while (type!= XmlPullParser.END_DOCUMENT){
            switch (type){
                case XmlPullParser.START_TAG:
                if ("infos".equals(parser.getName())){
                    IPHinfos = new ArrayList<List<PH_Bean>>();     //外层List
                    IPHinfo = new ArrayList<PH_Bean>();//里层List
                }else if ("ID".equals(parser.getName())){
                    bean = new PH_Bean();
                    String ids = parser.getAttributeValue(0);
                    bean.id= Integer.parseInt(ids);    //将ids保存到id中（将字符串转为整形）
                }else if ("title".equals(parser.getName())) {
                    bean.title = parser.nextText();  //取它的内容
                }else if ("intro".equals(parser.getName())) {
                    bean.intro = parser.nextText();  //取它的内容
                }
                break;
                case XmlPullParser.END_TAG:
                    if ("ID".equals(parser.getName())){
                        count++;
                        IPHinfo.add(bean); //把bean加进去
                        bean=null;
                        if (count%2==0){ //代表双数
                            IPHinfos.add(IPHinfo);
                            IPHinfo=null;
                            IPHinfo=new ArrayList<PH_Bean>();  //说明前面添加完后置空再添加，课程页面分单双数
                        }
                    }
                break;
            }
            type=parser.next();
        }
        return IPHinfos;
    }
    }