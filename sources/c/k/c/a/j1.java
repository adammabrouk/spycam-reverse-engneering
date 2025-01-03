package c.k.c.a;

import android.content.Context;
import c.k.d.h2;
import c.k.d.v9;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class j1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f6850a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f6851b;

    public j1(Context context, boolean z) {
        this.f6850a = context;
        this.f6851b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap<String, String> a2;
        String str;
        File a3;
        File file = null;
        try {
            a2 = v.a(this.f6850a, "");
            if (this.f6851b) {
                str = this.f6850a.getFilesDir().getAbsolutePath();
            } else {
                str = this.f6850a.getExternalFilesDir(null).getAbsolutePath() + h2.f7211f;
            }
            a3 = f.a(str);
        } catch (Throwable th) {
            th = th;
        }
        if (a3 == null) {
            c.k.a.a.a.c.m6a("log file null");
            return;
        }
        File file2 = new File(str, this.f6850a.getPackageName() + ".zip");
        try {
            v9.a(file2, a3);
            if (file2.exists()) {
                c.k.d.e0.a((this.f6851b ? "https://api.xmpush.xiaomi.com/upload/xmsf_log?file=" : "https://api.xmpush.xiaomi.com/upload/app_log?file=") + file2.getName(), a2, file2, "file");
            } else {
                c.k.a.a.a.c.m6a("zip log file failed");
            }
        } catch (Throwable th2) {
            th = th2;
            file = file2;
            c.k.a.a.a.c.a(th);
            file2 = file;
            if (file2 == null) {
            } else {
                return;
            }
        }
        if (file2 == null && file2.exists()) {
            file2.delete();
        }
    }
}
