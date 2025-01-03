package a.t;

import android.os.IBinder;

/* compiled from: WindowIdApi14.java */
/* loaded from: classes.dex */
public class u0 implements w0 {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f1890a;

    public u0(IBinder iBinder) {
        this.f1890a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof u0) && ((u0) obj).f1890a.equals(this.f1890a);
    }

    public int hashCode() {
        return this.f1890a.hashCode();
    }
}
