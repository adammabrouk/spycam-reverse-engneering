package cn.jpush.android.g;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import cn.asus.push.DataBuffer;

/* loaded from: classes.dex */
public final class d extends a {

    /* renamed from: b, reason: collision with root package name */
    public b.a.a.d f9741b = null;

    public static /* synthetic */ b.a.a.d a(d dVar, b.a.a.d dVar2) {
        dVar.f9741b = null;
        return null;
    }

    @Override // cn.jpush.android.g.a
    public final void a(String str, String str2) {
        String str3;
        if (this.f9741b != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("JPUSH_CONTENT", str2);
                this.f9741b.a(new DataBuffer(str, bundle), new b());
                return;
            } catch (Throwable th) {
                str3 = "send data fail:" + th;
            }
        } else {
            str3 = "send data fail, please init first.";
        }
        cn.jpush.android.i.b.g("ServiceConnection", str3);
    }

    @Override // cn.jpush.android.g.a
    public final boolean a() {
        byte b2 = 0;
        if (a.f9740a.get()) {
            cn.jpush.android.i.b.b("ServiceConnection", "already connecting.");
            return false;
        }
        a.f9740a.set(true);
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(cn.jpush.android.f.c.f9725e, "cn.jpush.android.service.PushManagerService"));
            e eVar = new e(this, b2);
            boolean bindService = cn.jpush.android.f.c.f9721a.bindService(intent, eVar, 1);
            cn.jpush.android.i.b.b("ServiceConnection", "connect--" + bindService);
            if (bindService) {
                this.f9741b = b.a.a.c.a(eVar.f9742a.take());
            } else {
                a.f9740a.set(false);
            }
            return bindService;
        } catch (Throwable th) {
            cn.jpush.android.i.b.g("ServiceConnection", "init fail:" + th);
            a.f9740a.set(false);
            return false;
        }
    }

    @Override // cn.jpush.android.g.a
    public final boolean b() {
        b.a.a.d dVar = this.f9741b;
        if (dVar == null) {
            return false;
        }
        return dVar.asBinder().isBinderAlive();
    }
}
