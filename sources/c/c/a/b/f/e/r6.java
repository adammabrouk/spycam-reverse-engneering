package c.c.a.b.f.e;

import c.c.a.b.f.e.s4;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class r6 implements b6 {

    /* renamed from: a, reason: collision with root package name */
    public final d6 f4399a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4400b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f4401c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4402d;

    public r6(d6 d6Var, String str, Object[] objArr) {
        this.f4399a = d6Var;
        this.f4400b = str;
        this.f4401c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f4402d = charAt;
            return;
        }
        int i2 = charAt & 8191;
        int i3 = 13;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char charAt2 = str.charAt(i4);
            if (charAt2 < 55296) {
                this.f4402d = i2 | (charAt2 << i3);
                return;
            } else {
                i2 |= (charAt2 & 8191) << i3;
                i3 += 13;
                i4 = i5;
            }
        }
    }

    @Override // c.c.a.b.f.e.b6
    public final d6 C() {
        return this.f4399a;
    }

    public final String a() {
        return this.f4400b;
    }

    public final Object[] b() {
        return this.f4401c;
    }

    @Override // c.c.a.b.f.e.b6
    public final int zza() {
        return (this.f4402d & 1) == 1 ? s4.e.f4427i : s4.e.j;
    }

    @Override // c.c.a.b.f.e.b6
    public final boolean zzb() {
        return (this.f4402d & 2) == 2;
    }
}
