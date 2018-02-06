package com.inclination.trust;

import android.content.Intent;
import android.view.View;

import com.inclination.trust.base.BaseActivity;
import com.inclination.trust.ui.SettingActivity;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    public void openSetting(View v) {

        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }
}
