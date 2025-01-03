package com.shix.shixipc.utils;

import android.app.Activity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class ActivityTaskManager {
    public static ActivityTaskManager activityTaskManager;
    public HashMap<String, Activity> activityMap;

    public ActivityTaskManager() {
        this.activityMap = null;
        this.activityMap = new HashMap<>();
    }

    private final void finisActivity(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
    }

    public static synchronized ActivityTaskManager getInstance() {
        ActivityTaskManager activityTaskManager2;
        synchronized (ActivityTaskManager.class) {
            if (activityTaskManager == null) {
                activityTaskManager = new ActivityTaskManager();
            }
            activityTaskManager2 = activityTaskManager;
        }
        return activityTaskManager2;
    }

    public void closeAllActivity() {
        Iterator<String> it = this.activityMap.keySet().iterator();
        while (it.hasNext()) {
            finisActivity(this.activityMap.get(it.next()));
        }
        this.activityMap.clear();
    }

    public void closeAllActivityExceptOne(String str) {
        Set<String> keySet = this.activityMap.keySet();
        Activity activity = this.activityMap.get(str);
        for (String str2 : keySet) {
            if (!str2.equals(str)) {
                finisActivity(this.activityMap.get(str2));
            }
        }
        this.activityMap.clear();
        this.activityMap.put(str, activity);
    }

    public boolean containsActivity(Activity activity) {
        return this.activityMap.containsValue(activity);
    }

    public boolean containsName(String str) {
        return this.activityMap.containsKey(str);
    }

    public Activity getActivity(String str) {
        return this.activityMap.get(str);
    }

    public boolean isEmpty() {
        return this.activityMap.isEmpty();
    }

    public Activity putActivity(String str, Activity activity) {
        return this.activityMap.put(str, activity);
    }

    public void removeActivity(String str) {
        finisActivity(this.activityMap.remove(str));
    }

    public int size() {
        return this.activityMap.size();
    }
}
