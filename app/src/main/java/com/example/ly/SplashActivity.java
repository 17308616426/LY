package com.example.ly;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ly.Notch.NotchFit;
import com.example.ly.Notch.args.NotchProperty;
import com.example.ly.Notch.args.NotchScreenType;
import com.example.ly.Notch.core.OnNotchCallBack;
import com.example.ly.Notch.utils.SizeUtils;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private TextView v;
    private LinearLayout all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();

        NotchFit.fit(this, NotchScreenType.TRANSLUCENT, new OnNotchCallBack() {
            @Override
            public void onNotchReady(NotchProperty notchProperty) {
                int fitSize;
                if(notchProperty.isNotchEnable()){
                    fitSize = notchProperty.getNotchHeight();
                }
                else {
                    fitSize = SizeUtils.getStatusBarHeight(SplashActivity.this);
                }

                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
                marginLayoutParams.topMargin = fitSize;
                v.requestLayout();
            }
        });

    }


    //版本号
    private void init() {
        v = (TextView) findViewById(R.id.v);
        all = (LinearLayout) findViewById(R.id.all);
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), 0);
            v.setText("V"+info.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            v.setText("V");
        }


        //定时器
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        };
        timer.schedule(task,3000);
    }
}
