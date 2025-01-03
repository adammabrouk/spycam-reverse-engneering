package c.k.d;

import android.content.Context;
import c.k.d.j;

/* loaded from: classes.dex */
public class v0 extends j.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u0 f7941a;

    public v0(u0 u0Var) {
        this.f7941a = u0Var;
    }

    @Override // c.k.d.j.a
    public int a() {
        return 10052;
    }

    @Override // java.lang.Runnable
    public void run() {
        l1 l1Var;
        l1 l1Var2;
        Context context;
        c.k.a.a.a.c.c("exec== mUploadJob");
        l1Var = this.f7941a.f7911e;
        if (l1Var != null) {
            l1Var2 = this.f7941a.f7911e;
            context = this.f7941a.f7907a;
            l1Var2.a(context);
            this.f7941a.b("upload_time");
        }
    }
}
