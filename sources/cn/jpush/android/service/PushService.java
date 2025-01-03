package cn.jpush.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes.dex */
public class PushService extends Service {
    public static final String TAG = "PushService";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
