package com.inclination.trust.baselib.manager;

import android.app.Activity;

import com.inclination.trust.baselib.utils.Logger;

import java.util.Stack;

/**
 * author:王恩钊
 * time:2018/2/6 下午9:11
 */

public class ActivityManager {

    private static ActivityManager instance;

    private Stack<Activity> activities;

    private ActivityManager() {
        activities = new Stack<>();
    }

    public static ActivityManager getInstance() {
        if (null == instance) {
            synchronized (ActivityManager.class) {
                if (null == instance) {
                    instance = new ActivityManager();
                }
            }
        }
        return instance;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
        Logger.d(activity.getClass().getSimpleName() + "入栈\n当前栈内有" + activities.size() + "个Activity");
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
        Logger.d(activity.getClass().getSimpleName() + "出栈\n当前栈内有" + activities.size() + "个Activity");
    }

    public void recreateAllActivity() {
        for (Activity activity : activities) {
            recreateActivity(activity);
        }
    }

    public void recreateActivity(Activity activity) {
        Logger.d(activity.getClass().getSimpleName() + "调用recreate方法");
        activity.recreate();
    }
}
