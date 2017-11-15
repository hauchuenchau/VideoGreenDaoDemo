package net.eanfang.videogreendaodemo;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by MrHou
 *
 * @on 2017/11/15  13:35
 * @email houzhongzhou@yeah.net
 * @desc
 */

public class APP extends Application {
    public static APP mMyApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        mMyApplication=this;
        Fresco.initialize(this);

    }
}
