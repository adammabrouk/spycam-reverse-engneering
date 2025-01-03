package c.j.a;

import android.content.Context;

/* compiled from: PushClientTask.java */
/* loaded from: classes.dex */
public abstract class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public Context f6635a;

    /* renamed from: b, reason: collision with root package name */
    public int f6636b;

    /* renamed from: c, reason: collision with root package name */
    public v f6637c;

    public r(v vVar) {
        this.f6636b = -1;
        this.f6637c = vVar;
        int b2 = vVar.b();
        this.f6636b = b2;
        if (b2 < 0) {
            throw new IllegalArgumentException("PushTask need a > 0 task id.");
        }
        this.f6635a = m.m().g();
    }

    public final int a() {
        return this.f6636b;
    }

    public abstract void a(v vVar);

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f6635a;
        if (context != null && !(this.f6637c instanceof c.j.a.f.m)) {
            c.j.a.z.v.a(context, "[执行指令]" + this.f6637c);
        }
        a(this.f6637c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        v vVar = this.f6637c;
        sb.append(vVar == null ? "[null]" : vVar.toString());
        sb.append("}");
        return sb.toString();
    }
}
