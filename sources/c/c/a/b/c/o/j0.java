package c.c.a.b.c.o;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import c.c.a.b.c.o.h;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class j0 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final Set<ServiceConnection> f3974a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public int f3975b = 2;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3976c;

    /* renamed from: d, reason: collision with root package name */
    public IBinder f3977d;

    /* renamed from: e, reason: collision with root package name */
    public final h.a f3978e;

    /* renamed from: f, reason: collision with root package name */
    public ComponentName f3979f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ i0 f3980g;

    public j0(i0 i0Var, h.a aVar) {
        this.f3980g = i0Var;
        this.f3978e = aVar;
    }

    public final void a(String str) {
        c.c.a.b.c.r.a aVar;
        Context context;
        Context context2;
        c.c.a.b.c.r.a aVar2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j;
        this.f3975b = 3;
        aVar = this.f3980g.f3969f;
        context = this.f3980g.f3967d;
        h.a aVar3 = this.f3978e;
        context2 = this.f3980g.f3967d;
        boolean a2 = aVar.a(context, str, aVar3.a(context2), this, this.f3978e.c());
        this.f3976c = a2;
        if (a2) {
            handler = this.f3980g.f3968e;
            Message obtainMessage = handler.obtainMessage(1, this.f3978e);
            handler2 = this.f3980g.f3968e;
            j = this.f3980g.f3971h;
            handler2.sendMessageDelayed(obtainMessage, j);
            return;
        }
        this.f3975b = 2;
        try {
            aVar2 = this.f3980g.f3969f;
            context3 = this.f3980g.f3967d;
            aVar2.a(context3, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void b(String str) {
        Handler handler;
        c.c.a.b.c.r.a aVar;
        Context context;
        handler = this.f3980g.f3968e;
        handler.removeMessages(1, this.f3978e);
        aVar = this.f3980g.f3969f;
        context = this.f3980g.f3967d;
        aVar.a(context, this);
        this.f3976c = false;
        this.f3975b = 2;
    }

    public final int c() {
        return this.f3975b;
    }

    public final boolean d() {
        return this.f3976c;
    }

    public final boolean e() {
        return this.f3974a.isEmpty();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f3980g.f3966c;
        synchronized (hashMap) {
            handler = this.f3980g.f3968e;
            handler.removeMessages(1, this.f3978e);
            this.f3977d = iBinder;
            this.f3979f = componentName;
            Iterator<ServiceConnection> it = this.f3974a.iterator();
            while (it.hasNext()) {
                it.next().onServiceConnected(componentName, iBinder);
            }
            this.f3975b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f3980g.f3966c;
        synchronized (hashMap) {
            handler = this.f3980g.f3968e;
            handler.removeMessages(1, this.f3978e);
            this.f3977d = null;
            this.f3979f = componentName;
            Iterator<ServiceConnection> it = this.f3974a.iterator();
            while (it.hasNext()) {
                it.next().onServiceDisconnected(componentName);
            }
            this.f3975b = 2;
        }
    }

    public final void b(ServiceConnection serviceConnection, String str) {
        c.c.a.b.c.r.a unused;
        Context unused2;
        unused = this.f3980g.f3969f;
        unused2 = this.f3980g.f3967d;
        this.f3974a.remove(serviceConnection);
    }

    public final ComponentName b() {
        return this.f3979f;
    }

    public final void a(ServiceConnection serviceConnection, String str) {
        Context context;
        c.c.a.b.c.r.a unused;
        Context unused2;
        unused = this.f3980g.f3969f;
        unused2 = this.f3980g.f3967d;
        h.a aVar = this.f3978e;
        context = this.f3980g.f3967d;
        aVar.a(context);
        this.f3974a.add(serviceConnection);
    }

    public final boolean a(ServiceConnection serviceConnection) {
        return this.f3974a.contains(serviceConnection);
    }

    public final IBinder a() {
        return this.f3977d;
    }
}
