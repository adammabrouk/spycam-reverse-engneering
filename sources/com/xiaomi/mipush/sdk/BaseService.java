package com.xiaomi.mipush.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import c.k.a.a.a.c;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class BaseService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public a f11250a;

    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<BaseService> f11251a;

        public a(WeakReference<BaseService> weakReference) {
            this.f11251a = weakReference;
        }

        public void a() {
            if (hasMessages(1001)) {
                removeMessages(1001);
            }
            sendEmptyMessageDelayed(1001, 1000L);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference<BaseService> weakReference;
            BaseService baseService;
            if (message.what != 1001 || (weakReference = this.f11251a) == null || (baseService = weakReference.get()) == null) {
                return;
            }
            c.c("TimeoutHandler" + baseService.toString() + "  kill self");
            if (!baseService.mo578a()) {
                baseService.stopSelf();
            } else {
                c.c("TimeoutHandler has job");
                sendEmptyMessageDelayed(1001, 1000L);
            }
        }
    }

    /* renamed from: a */
    public abstract boolean mo578a();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        super.onStart(intent, i2);
        if (this.f11250a == null) {
            this.f11250a = new a(new WeakReference(this));
        }
        this.f11250a.a();
    }
}
