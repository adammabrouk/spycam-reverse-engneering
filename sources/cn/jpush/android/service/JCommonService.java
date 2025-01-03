package cn.jpush.android.service;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jiguang.android.IDataShare;
import cn.jiguang.ao.f;
import cn.jiguang.ao.g;
import cn.jiguang.as.d;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreInternalHelper;

/* loaded from: classes.dex */
public class JCommonService extends Service {
    public static final String TAG = "JCommonService";
    public static IDataShare.Stub mBinder;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        JConstants.mApplicationContext = getApplicationContext();
        if (mBinder == null) {
            mBinder = new DataShare();
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public final void onLowMemory() {
        super.onLowMemory();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public final void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        if (f.a() && g.a()) {
            d.d(TAG, "sdk is banned, not handle service task");
            return 2;
        }
        if (intent == null || TextUtils.isEmpty(intent.getAction())) {
            d.g(TAG, "onStartCommand intent is empty or action is empty");
            return 2;
        }
        JCoreInternalHelper.getInstance().onEvent(this, JConstants.SDK_TYPE, 2, true, intent.getAction(), intent.getExtras(), new Object[0]);
        return 2;
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
