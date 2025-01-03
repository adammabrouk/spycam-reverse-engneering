package c.c.a.b.g.b;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class f4 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final g4 f4720a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4721b;

    /* renamed from: c, reason: collision with root package name */
    public final Throwable f4722c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f4723d;

    /* renamed from: e, reason: collision with root package name */
    public final String f4724e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<String, List<String>> f4725f;

    public f4(String str, g4 g4Var, int i2, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        c.c.a.b.c.o.r.a(g4Var);
        this.f4720a = g4Var;
        this.f4721b = i2;
        this.f4722c = th;
        this.f4723d = bArr;
        this.f4724e = str;
        this.f4725f = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4720a.a(this.f4724e, this.f4721b, this.f4722c, this.f4723d, this.f4725f);
    }
}
