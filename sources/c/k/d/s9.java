package c.k.d;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class s9 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public Context f7855a;

    /* renamed from: b, reason: collision with root package name */
    public File f7856b;

    /* renamed from: c, reason: collision with root package name */
    public Runnable f7857c;

    public s9(Context context, File file) {
        this.f7855a = context;
        this.f7856b = file;
    }

    public /* synthetic */ s9(Context context, File file, t9 t9Var) {
        this(context, file);
    }

    public static void a(Context context, File file, Runnable runnable) {
        new t9(context, file, runnable).run();
    }

    public abstract void a(Context context);

    @Override // java.lang.Runnable
    public final void run() {
        r9 r9Var = null;
        try {
            try {
                if (this.f7856b == null) {
                    this.f7856b = new File(this.f7855a.getFilesDir(), "default_locker");
                }
                r9Var = r9.a(this.f7855a, this.f7856b);
                if (this.f7857c != null) {
                    this.f7857c.run();
                }
                a(this.f7855a);
                if (r9Var == null) {
                    return;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                if (r9Var == null) {
                    return;
                }
            }
            r9Var.a();
        } catch (Throwable th) {
            if (r9Var != null) {
                r9Var.a();
            }
            throw th;
        }
    }
}
