package a.s;

import android.os.Trace;

/* compiled from: TraceApi18Impl.java */
/* loaded from: classes.dex */
public final class b {
    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void a() {
        Trace.endSection();
    }
}
