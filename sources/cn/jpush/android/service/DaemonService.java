package cn.jpush.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import cn.jiguang.ai.a;
import cn.jiguang.an.e;

/* loaded from: classes.dex */
public class DaemonService extends Service {
    public static final String TAG = "DaemonService";

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        e.a(getApplicationContext(), intent != null ? intent.getExtras() : null, 2);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        a.a(TAG, "action onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        a.a(TAG, "action onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        e.a(getApplicationContext(), intent != null ? intent.getExtras() : null, 1);
        return super.onStartCommand(intent, i2, i3);
    }
}
