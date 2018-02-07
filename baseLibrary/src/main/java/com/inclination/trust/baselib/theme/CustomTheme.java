package com.inclination.trust.baselib.theme;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;

/**
 * author:王恩钊
 * time:2018/2/7 11:33
 */

public class CustomTheme implements ICustomTheme {

    private static ICustomTheme customTheme;
    private int mTheme;

    public static void init() {
        customTheme = new CustomTheme();
    }

    public static ICustomTheme getCustomTheme() {
        return customTheme;
    }

    @Override
    public void setTheme(int theme) {
        this.mTheme = theme;
    }

    @Override
    public int getTheme() {
        return mTheme;
    }

    @Override
    public int getColor(Context context, int resId) {
        return getColor(context, resId, Color.WHITE);
    }

    @Override
    public int getColor(Context context, int resId, int defaultColor) {
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(resId, typedValue, true);
        defaultColor = typedValue.data;
        return defaultColor;
    }

    @Override
    public CharSequence getString(Context context, int resId) {
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(resId, typedValue, true);
        return typedValue.string;
    }
}
