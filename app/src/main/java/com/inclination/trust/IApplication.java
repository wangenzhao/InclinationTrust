package com.inclination.trust;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.inclination.trust.manager.ActivityManager;
import com.inclination.trust.utils.Logger;

/**
 * author:王恩钊
 * time:2018/2/6 下午8:59
 */

public class IApplication extends Application implements Application.ActivityLifecycleCallbacks {

    private int currentTheme = R.style.Default_Style;

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init(this);
        registerActivityLifecycleCallbacks(this);

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        unregisterActivityLifecycleCallbacks(this);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        ActivityManager.getInstance().removeActivity(activity);
    }
}
