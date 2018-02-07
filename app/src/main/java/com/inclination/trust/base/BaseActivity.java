package com.inclination.trust.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.inclination.trust.R;
import com.inclination.trust.baselib.CustomActivity;
import com.inclination.trust.baselib.theme.CustomTheme;

/**
 * author:王恩钊
 * time:2018/2/6 下午9:10
 */

public abstract class BaseActivity extends CustomActivity {

    @Override
    public int getCustomTheme() {
        return CustomTheme.getCustomTheme().getTheme();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setLeftIcon(R.mipmap.ic_back);
        /**
         * 设置主布局
         */
        View contentView = LayoutInflater.from(this).inflate(getLayout(), rootLayout, false);
        rootLayout.addView(contentView, 1);

        initView();
    }
}
