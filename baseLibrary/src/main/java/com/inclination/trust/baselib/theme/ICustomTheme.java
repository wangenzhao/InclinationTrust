package com.inclination.trust.baselib.theme;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.StyleRes;

/**
 * author:王恩钊
 * time:2018/2/7 11:32
 */

public interface ICustomTheme {

    void setTheme(@StyleRes int theme);

    @StyleRes int getTheme();

    int getColor(Context context, @AttrRes int resId);

    int getColor(Context context, @AttrRes int resId, int defaultColor);

    CharSequence getString(Context context, @AttrRes int resId);
}
