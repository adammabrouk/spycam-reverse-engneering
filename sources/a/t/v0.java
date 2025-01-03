package a.t;

import android.view.View;
import android.view.WindowId;

/* compiled from: WindowIdApi18.java */
/* loaded from: classes.dex */
public class v0 implements w0 {

    /* renamed from: a, reason: collision with root package name */
    public final WindowId f1893a;

    public v0(View view) {
        this.f1893a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof v0) && ((v0) obj).f1893a.equals(this.f1893a);
    }

    public int hashCode() {
        return this.f1893a.hashCode();
    }
}
