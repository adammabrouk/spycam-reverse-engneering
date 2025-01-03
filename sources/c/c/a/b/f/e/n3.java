package c.c.a.b.f.e;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class n3 extends p3 {

    /* renamed from: a, reason: collision with root package name */
    public int f4318a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f4319b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k3 f4320c;

    public n3(k3 k3Var) {
        this.f4320c = k3Var;
        this.f4319b = this.f4320c.zza();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4318a < this.f4319b;
    }

    @Override // c.c.a.b.f.e.t3
    public final byte zza() {
        int i2 = this.f4318a;
        if (i2 >= this.f4319b) {
            throw new NoSuchElementException();
        }
        this.f4318a = i2 + 1;
        return this.f4320c.zzb(i2);
    }
}
