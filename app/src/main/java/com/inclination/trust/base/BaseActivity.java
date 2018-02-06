package com.inclination.trust.base;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.inclination.trust.R;

/**
 * author:王恩钊
 * time:2018/2/6 下午9:10
 */

public abstract class BaseActivity extends AppCompatActivity implements ActivityWrapper {

    private LinearLayout rootLayout;

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Default_Style);

        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = getTheme();
        theme.resolveAttribute(R.attr.main_color, typedValue, true);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(typedValue.data);
        }

        rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        View toolBarView = LayoutInflater.from(this).inflate(R.layout.tool_bar, rootLayout, false);
        rootLayout.addView(toolBarView, 0);
        View contentView = LayoutInflater.from(this).inflate(getLayout(), rootLayout, false);
        rootLayout.addView(contentView, 1);

        setContentView(rootLayout);

        toolbar = toolBarView.findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}
