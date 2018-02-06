package com.inclination.trust.manager;

import android.app.Activity;

import com.inclination.trust.utils.Logger;

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
        Logger.d(activity + "入栈");
    }

    public void removeActivity(Activity activity) {
        Logger.d(activity + "出栈");
        activities.remove(activity);
    }

    public void recreateAllActivity() {
        for (Activity activity : activities) {
            recreateActivity(activity);
        }
    }

    public void recreateActivity(Activity activity) {
        Logger.d(activity + "调用recreate方法");
        activity.recreate();
    }
}
