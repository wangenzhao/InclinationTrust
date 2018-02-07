package com.inclination.trust.baselib;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.inclination.trust.baselib.manager.ActivityManager;
import com.inclination.trust.baselib.theme.CustomTheme;

/**
 * author:王恩钊
 * time:2018/2/7 10:23
 */

public abstract class CustomActivity extends AppCompatActivity implements ActivityWrapper {

    protected LinearLayout rootLayout;
    private Toolbar toolbar;
    private TextView titleView;
    private ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        setTheme(getCustomTheme());

        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(CustomTheme.getCustomTheme().getColor(this, R.attr.main_color));
        }

        /**
         * 初始化ToolBar
         */
        rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        View toolBarView = LayoutInflater.from(this).inflate(R.layout.tool_bar, rootLayout, false);
        rootLayout.addView(toolBarView, 0);

        /**
         * 设置ActionBar
         */
        toolbar = toolBarView.findViewById(R.id.tool_bar);
        titleView = toolBarView.findViewById(R.id.title_view);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLeftClick();
            }
        });

        setContentView(rootLayout);
    }

    @Override
    public void setTitle(int titleId) {
        setTitle(getResources().getString(titleId));
    }

    @Override
    public void setTitle(CharSequence title) {
        titleView.setText(title);
    }

    @Override
    public void hideLeftBtn() {
        actionBar.setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public void setLeftIcon(@DrawableRes int resId) {
        toolbar.setNavigationIcon(resId);
    }

    @Override
    public void setLeftClick() {
        finish();
    }

    @Override
    public void setRightIcon(@DrawableRes int resId) {

    }

    @Override
    public void setRightClick() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().removeActivity(this);
    }

}
