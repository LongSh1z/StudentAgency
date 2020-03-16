package com.example.studentagency.ui.activity;

import android.app.Application;

import com.example.studentagency.utils.NotificationClickEventReceiver;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.im.android.api.JMessageClient;

/**
 * author：LongSh1z
 * email：2674461089@qq.com
 * time：2019/12/16
 * desc:
 */
public class MyApp extends Application {

    private static final String TAG = "MyApp";
    public static final String PLACEHOLDER_PIC = "http://www.longsh1z.top/resources/placeholder_pic.png";
    public static int userId = 20160001;
    public static String userPhoneNum;

    @Override
    public void onCreate() {
        super.onCreate();

        //极光推送及IM初始化
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        JMessageClient.setDebugMode(true);
        JMessageClient.init(this);

        NotificationClickEventReceiver notificationClickEventReceiver = new NotificationClickEventReceiver(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        JMessageClient.logout();
    }
}
