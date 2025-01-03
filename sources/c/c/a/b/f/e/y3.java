package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class y3 extends w3 {

    /* renamed from: a, reason: collision with root package name */
    public int f4532a;

    /* renamed from: b, reason: collision with root package name */
    public int f4533b;

    /* renamed from: c, reason: collision with root package name */
    public int f4534c;

    /* renamed from: d, reason: collision with root package name */
    public int f4535d;

    /* renamed from: e, reason: collision with root package name */
    public int f4536e;

    public y3(byte[] bArr, int i2, int i3, boolean z) {
        super();
        this.f4536e = Integer.MAX_VALUE;
        this.f4532a = i3 + i2;
        this.f4534c = i2;
        this.f4535d = i2;
    }

    public final int a() {
        return this.f4534c - this.f4535d;
    }

    public final int b(int i2) throws c5 {
        if (i2 < 0) {
            throw c5.zzb();
        }
        int a2 = i2 + a();
        int i3 = this.f4536e;
        if (a2 > i3) {
            throw c5.zza();
        }
        this.f4536e = a2;
        b();
        return i3;
    }

    public final void b() {
        int i2 = this.f4532a + this.f4533b;
        this.f4532a = i2;
        int i3 = i2 - this.f4535d;
        int i4 = this.f4536e;
        if (i3 > i4) {
            int i5 = i3 - i4;
            this.f4533b = i5;
            this.f4532a = i2 - i5;
            return;
        }
        this.f4533b = 0;
    }
}
