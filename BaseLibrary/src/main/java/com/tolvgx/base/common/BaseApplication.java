package com.tolvgx.base.common;

import android.app.Application;
import android.content.Context;
import com.tolvgx.base.di.component.AppComponent;
import com.tolvgx.base.di.component.DaggerAppComponent;
import com.tolvgx.base.di.moudle.AppMoudle;

/**
 * <pre>
 *     author: Tolvgx
 *     date  : 2018/8/15
 *     email : tolvgx@163.com
 *     github: https://github.com/tolvgx
 * </pre>
 *
 * Application 基类
 */

public class BaseApplication extends Application {

    public AppComponent appComponent;

    public static Context context;
    public static Application application;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;
        context = getApplicationContext();

        initAppInjection();
    }

    private void initAppInjection() {
        appComponent = DaggerAppComponent.builder()
                .appMoudle(new AppMoudle(this))
                .build();
    }
}
