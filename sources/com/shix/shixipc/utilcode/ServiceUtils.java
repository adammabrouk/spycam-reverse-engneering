package com.shix.shixipc.utilcode;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class ServiceUtils {
    public ServiceUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void bindService(String str, ServiceConnection serviceConnection, int i2) {
        try {
            bindService(Class.forName(str), serviceConnection, i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static Set<String> getAllRunningServices() {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) Utils.getApp().getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        HashSet hashSet = new HashSet();
        if (runningServices == null || runningServices.size() == 0) {
            return null;
        }
        Iterator<ActivityManager.RunningServiceInfo> it = runningServices.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().service.getClassName());
        }
        return hashSet;
    }

    public static boolean isServiceRunning(Class<?> cls) {
        return isServiceRunning(cls.getName());
    }

    public static void startService(String str) {
        try {
            startService(Class.forName(str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean stopService(String str) {
        try {
            return stopService(Class.forName(str));
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void unbindService(ServiceConnection serviceConnection) {
        Utils.getApp().unbindService(serviceConnection);
    }

    public static boolean isServiceRunning(String str) {
        try {
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) Utils.getApp().getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
            if (runningServices != null && runningServices.size() != 0) {
                Iterator<ActivityManager.RunningServiceInfo> it = runningServices.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().service.getClassName())) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void bindService(Class<?> cls, ServiceConnection serviceConnection, int i2) {
        bindService(new Intent(Utils.getApp(), cls), serviceConnection, i2);
    }

    public static void startService(Class<?> cls) {
        startService(new Intent(Utils.getApp(), cls));
    }

    public static boolean stopService(Class<?> cls) {
        return stopService(new Intent(Utils.getApp(), cls));
    }

    public static void bindService(Intent intent, ServiceConnection serviceConnection, int i2) {
        try {
            Utils.getApp().bindService(intent, serviceConnection, i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void startService(Intent intent) {
        try {
            intent.setFlags(32);
            if (Build.VERSION.SDK_INT >= 26) {
                Utils.getApp().startForegroundService(intent);
            } else {
                Utils.getApp().startService(intent);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean stopService(Intent intent) {
        try {
            return Utils.getApp().stopService(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
