package com.inclination.trust.baselib;

import android.support.annotation.DrawableRes;

/**
 * author:王恩钊
 * time:2018/2/6 下午9:24
 */

public interface ActivityWrapper {

    int getLayout();
    void initView();

    int getCustomTheme();

    void hideLeftBtn();
    void setLeftIcon(@DrawableRes int resId);
    void setLeftClick();
    void setRightIcon(@DrawableRes int resId);
    void setRightClick();

}
