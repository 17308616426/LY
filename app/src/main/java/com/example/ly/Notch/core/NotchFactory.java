package com.example.ly.Notch.core;

import android.text.TextUtils;

import com.example.ly.Notch.manufacturer.GooglePNotch;
import com.example.ly.Notch.manufacturer.HuaweiNotch;
import com.example.ly.Notch.manufacturer.OppoNotch;
import com.example.ly.Notch.manufacturer.SmartisanNotch;
import com.example.ly.Notch.manufacturer.VivoNotch;
import com.example.ly.Notch.manufacturer.XiaomiNotch;
import com.example.ly.Notch.utils.DeviceUtils;


/**
 * Notch设备参数获取工厂
 * Created by wangchunlong on 2018/10/24.
 */

public class NotchFactory {
    private static NotchFactory instance;

    private NotchFactory(){}
    public static NotchFactory getInstance(){
        if(instance == null){
            synchronized (NotchFactory.class) {
                instance = new NotchFactory();
            }
        }
        return instance;
    }

    INotch notch;
    public INotch getNotch(){
        if(notch != null){
            return notch;
        }
        String manufacturer = DeviceUtils.getManufacturer().toLowerCase();
        if(TextUtils.equals(manufacturer, "huawei")){
            notch = new HuaweiNotch();
        }
        else if(TextUtils.equals(manufacturer, "xiaomi")){
            notch = new XiaomiNotch();
        }
        else if(TextUtils.equals(manufacturer, "oppo")){
            notch = new OppoNotch();
        }
        else if(TextUtils.equals(manufacturer, "vivo")){
            notch = new VivoNotch();
        }
        else if(TextUtils.equals(manufacturer, "smartisan")){
            notch = new SmartisanNotch();
        }
        else {
            notch = new GooglePNotch();
        }
        return notch;
    }
}
