package com.inclination.trust.baselib;

import android.app.Application;

import com.inclination.trust.baselib.theme.CustomTheme;
import com.inclination.trust.baselib.utils.Logger;

/**
 * author:王恩钊
 * time:2018/2/7 12:01
 */

public abstract class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init(this);
        CustomTheme.init();
        CustomTheme.getCustomTheme().setTheme(getCurrentTheme());
    }

    protected abstract int getCurrentTheme();
}
