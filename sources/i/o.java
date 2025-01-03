package i;

import javax.annotation.Nullable;

/* compiled from: Segment.java */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f11845a;

    /* renamed from: b, reason: collision with root package name */
    public int f11846b;

    /* renamed from: c, reason: collision with root package name */
    public int f11847c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11848d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f11849e;

    /* renamed from: f, reason: collision with root package name */
    public o f11850f;

    /* renamed from: g, reason: collision with root package name */
    public o f11851g;

    public o() {
        this.f11845a = new byte[8192];
        this.f11849e = true;
        this.f11848d = false;
    }

    public o a(o oVar) {
        oVar.f11851g = this;
        oVar.f11850f = this.f11850f;
        this.f11850f.f11851g = oVar;
        this.f11850f = oVar;
        return oVar;
    }

    @Nullable
    public o b() {
        o oVar = this.f11850f;
        if (oVar == this) {
            oVar = null;
        }
        o oVar2 = this.f11851g;
        oVar2.f11850f = this.f11850f;
        this.f11850f.f11851g = oVar2;
        this.f11850f = null;
        this.f11851g = null;
        return oVar;
    }

    public o c() {
        this.f11848d = true;
        return new o(this.f11845a, this.f11846b, this.f11847c, true, false);
    }

    public o(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.f11845a = bArr;
        this.f11846b = i2;
        this.f11847c = i3;
        this.f11848d = z;
        this.f11849e = z2;
    }

    public o a(int i2) {
        o a2;
        if (i2 > 0 && i2 <= this.f11847c - this.f11846b) {
            if (i2 >= 1024) {
                a2 = c();
            } else {
                a2 = p.a();
                System.arraycopy(this.f11845a, this.f11846b, a2.f11845a, 0, i2);
            }
            a2.f11847c = a2.f11846b + i2;
            this.f11846b += i2;
            this.f11851g.a(a2);
            return a2;
        }
        throw new IllegalArgumentException();
    }

    public void a() {
        o oVar = this.f11851g;
        if (oVar != this) {
            if (oVar.f11849e) {
                int i2 = this.f11847c - this.f11846b;
                if (i2 > (8192 - oVar.f11847c) + (oVar.f11848d ? 0 : oVar.f11846b)) {
                    return;
                }
                a(this.f11851g, i2);
                b();
                p.a(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public void a(o oVar, int i2) {
        if (oVar.f11849e) {
            int i3 = oVar.f11847c;
            if (i3 + i2 > 8192) {
                if (!oVar.f11848d) {
                    int i4 = oVar.f11846b;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = oVar.f11845a;
                        System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                        oVar.f11847c -= oVar.f11846b;
                        oVar.f11846b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f11845a, this.f11846b, oVar.f11845a, oVar.f11847c, i2);
            oVar.f11847c += i2;
            this.f11846b += i2;
            return;
        }
        throw new IllegalArgumentException();
    }
}
