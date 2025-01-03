package c.a.a.m;

import android.content.Context;
import c.a.a.m.c;

/* compiled from: ConnectivityMonitorFactory.java */
/* loaded from: classes.dex */
public class d {
    public c a(Context context, c.a aVar) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 ? new e(context, aVar) : new i();
    }
}
