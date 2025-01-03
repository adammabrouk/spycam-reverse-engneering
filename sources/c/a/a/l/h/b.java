package c.a.a.l.h;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* compiled from: ByteArrayFetcher.java */
/* loaded from: classes.dex */
public class b implements c<InputStream> {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f3045a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3046b;

    public b(byte[] bArr, String str) {
        this.f3045a = bArr;
        this.f3046b = str;
    }

    @Override // c.a.a.l.h.c
    public void a() {
    }

    @Override // c.a.a.l.h.c
    public String c() {
        return this.f3046b;
    }

    @Override // c.a.a.l.h.c
    public void cancel() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // c.a.a.l.h.c
    public InputStream a(c.a.a.g gVar) {
        return new ByteArrayInputStream(this.f3045a);
    }
}
