package a.h.j;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

/* compiled from: PointerIconCompat.java */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public Object f1207a;

    public w(Object obj) {
        this.f1207a = obj;
    }

    public Object a() {
        return this.f1207a;
    }

    public static w a(Context context, int i2) {
        return Build.VERSION.SDK_INT >= 24 ? new w(PointerIcon.getSystemIcon(context, i2)) : new w(null);
    }
}
