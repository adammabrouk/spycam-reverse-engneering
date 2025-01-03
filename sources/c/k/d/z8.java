package c.k.d;

import c.k.d.p8;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class z8 extends p8 {
    public static int m = 10000;
    public static int n = 10000;
    public static int o = 10000;
    public static int p = 10485760;
    public static int q = 104857600;

    public static class a extends p8.a {
        public a() {
            super(false, true);
        }

        public a(boolean z, boolean z2, int i2) {
            super(z, z2, i2);
        }

        @Override // c.k.d.p8.a, c.k.d.v8
        public t8 a(d9 d9Var) {
            z8 z8Var = new z8(d9Var, ((p8.a) this).f80a, this.f7519b);
            int i2 = ((p8.a) this).f7518a;
            if (i2 != 0) {
                z8Var.b(i2);
            }
            return z8Var;
        }
    }

    public z8(d9 d9Var, boolean z, boolean z2) {
        super(d9Var, z, z2);
    }

    @Override // c.k.d.p8, c.k.d.t8
    /* renamed from: a */
    public r8 mo344a() {
        byte a2 = a();
        int mo341a = mo341a();
        if (mo341a <= n) {
            return new r8(a2, mo341a);
        }
        throw new u8(3, "Thrift list size " + mo341a + " out of range!");
    }

    @Override // c.k.d.p8, c.k.d.t8
    /* renamed from: a */
    public s8 mo345a() {
        byte a2 = a();
        byte a3 = a();
        int mo341a = mo341a();
        if (mo341a <= m) {
            return new s8(a2, a3, mo341a);
        }
        throw new u8(3, "Thrift map size " + mo341a + " out of range!");
    }

    @Override // c.k.d.p8, c.k.d.t8
    /* renamed from: a */
    public x8 mo346a() {
        byte a2 = a();
        int mo341a = mo341a();
        if (mo341a <= o) {
            return new x8(a2, mo341a);
        }
        throw new u8(3, "Thrift set size " + mo341a + " out of range!");
    }

    @Override // c.k.d.p8, c.k.d.t8
    /* renamed from: a */
    public String mo348a() {
        int mo341a = mo341a();
        if (mo341a > p) {
            throw new u8(3, "Thrift string size " + mo341a + " out of range!");
        }
        if (this.f7904a.b() < mo341a) {
            return a(mo341a);
        }
        try {
            String str = new String(this.f7904a.mo122a(), this.f7904a.a(), mo341a, "UTF-8");
            this.f7904a.a(mo341a);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new n8("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // c.k.d.p8, c.k.d.t8
    /* renamed from: a */
    public ByteBuffer mo349a() {
        int mo341a = mo341a();
        if (mo341a > q) {
            throw new u8(3, "Thrift binary size " + mo341a + " out of range!");
        }
        c(mo341a);
        if (this.f7904a.b() >= mo341a) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f7904a.mo122a(), this.f7904a.a(), mo341a);
            this.f7904a.a(mo341a);
            return wrap;
        }
        byte[] bArr = new byte[mo341a];
        this.f7904a.b(bArr, 0, mo341a);
        return ByteBuffer.wrap(bArr);
    }
}
