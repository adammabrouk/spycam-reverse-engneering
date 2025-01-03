package c.k.d;

import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class p8 extends t8 {
    public static final y8 l = new y8();

    /* renamed from: b, reason: collision with root package name */
    public int f7510b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7511c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f7512d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f7513e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f7514f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f7515g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f7516h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f7517i;
    public byte[] j;
    public byte[] k;

    public static class a implements v8 {

        /* renamed from: a, reason: collision with root package name */
        public int f7518a;

        /* renamed from: a, reason: collision with other field name */
        public boolean f80a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f7519b;

        public a() {
            this(false, true);
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i2) {
            this.f80a = false;
            this.f7519b = true;
            this.f80a = z;
            this.f7519b = z2;
            this.f7518a = i2;
        }

        @Override // c.k.d.v8
        public t8 a(d9 d9Var) {
            p8 p8Var = new p8(d9Var, this.f80a, this.f7519b);
            int i2 = this.f7518a;
            if (i2 != 0) {
                p8Var.b(i2);
            }
            return p8Var;
        }
    }

    public p8(d9 d9Var, boolean z, boolean z2) {
        super(d9Var);
        this.f7511c = false;
        this.f7512d = new byte[1];
        this.f7513e = new byte[2];
        this.f7514f = new byte[4];
        this.f7515g = new byte[8];
        this.f7516h = new byte[1];
        this.f7517i = new byte[2];
        this.j = new byte[4];
        this.k = new byte[8];
    }

    @Override // c.k.d.t8
    public byte a() {
        if (this.f7904a.b() < 1) {
            a(this.f7516h, 0, 1);
            return this.f7516h[0];
        }
        byte b2 = this.f7904a.mo122a()[this.f7904a.a()];
        this.f7904a.a(1);
        return b2;
    }

    @Override // c.k.d.t8
    /* renamed from: a, reason: collision with other method in class */
    public double mo340a() {
        return Double.longBitsToDouble(mo342a());
    }

    @Override // c.k.d.t8
    /* renamed from: a, reason: collision with other method in class */
    public int mo341a() {
        byte[] bArr = this.j;
        int i2 = 0;
        if (this.f7904a.b() >= 4) {
            bArr = this.f7904a.mo122a();
            i2 = this.f7904a.a();
            this.f7904a.a(4);
        } else {
            a(this.j, 0, 4);
        }
        return (bArr[i2 + 3] & ThreadUtils.TYPE_SINGLE) | ((bArr[i2] & ThreadUtils.TYPE_SINGLE) << 24) | ((bArr[i2 + 1] & ThreadUtils.TYPE_SINGLE) << 16) | ((bArr[i2 + 2] & ThreadUtils.TYPE_SINGLE) << 8);
    }

    public final int a(byte[] bArr, int i2, int i3) {
        c(i3);
        return this.f7904a.b(bArr, i2, i3);
    }

    @Override // c.k.d.t8
    /* renamed from: a, reason: collision with other method in class */
    public long mo342a() {
        byte[] bArr = this.k;
        int i2 = 0;
        if (this.f7904a.b() >= 8) {
            bArr = this.f7904a.mo122a();
            i2 = this.f7904a.a();
            this.f7904a.a(8);
        } else {
            a(this.k, 0, 8);
        }
        return (bArr[i2 + 7] & ThreadUtils.TYPE_SINGLE) | ((bArr[i2] & ThreadUtils.TYPE_SINGLE) << 56) | ((bArr[i2 + 1] & ThreadUtils.TYPE_SINGLE) << 48) | ((bArr[i2 + 2] & ThreadUtils.TYPE_SINGLE) << 40) | ((bArr[i2 + 3] & ThreadUtils.TYPE_SINGLE) << 32) | ((bArr[i2 + 4] & ThreadUtils.TYPE_SINGLE) << 24) | ((bArr[i2 + 5] & ThreadUtils.TYPE_SINGLE) << 16) | ((bArr[i2 + 6] & ThreadUtils.TYPE_SINGLE) << 8);
    }

    @Override // c.k.d.t8
    /* renamed from: a, reason: collision with other method in class */
    public q8 mo343a() {
        byte a2 = a();
        return new q8("", a2, a2 == 0 ? (short) 0 : mo350a());
    }

    @Override // c.k.d.t8
    /* renamed from: a, reason: collision with other method in class */
    public r8 mo344a() {
        return new r8(a(), mo341a());
    }

    @Override // c.k.d.t8
    /* renamed from: a, reason: collision with other method in class */
    public s8 mo345a() {
        return new s8(a(), a(), mo341a());
    }

    @Override // c.k.d.t8
    /* renamed from: a, reason: collision with other method in class */
    public x8 mo346a() {
        return new x8(a(), mo341a());
    }

    @Override // c.k.d.t8
    /* renamed from: a, reason: collision with other method in class */
    public y8 mo347a() {
        return l;
    }

    @Override // c.k.d.t8
    /* renamed from: a, reason: collision with other method in class */
    public String mo348a() {
        int mo341a = mo341a();
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

    public String a(int i2) {
        try {
            c(i2);
            byte[] bArr = new byte[i2];
            this.f7904a.b(bArr, 0, i2);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new n8("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // c.k.d.t8
    /* renamed from: a, reason: collision with other method in class */
    public ByteBuffer mo349a() {
        int mo341a = mo341a();
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

    @Override // c.k.d.t8
    /* renamed from: a, reason: collision with other method in class */
    public short mo350a() {
        byte[] bArr = this.f7517i;
        int i2 = 0;
        if (this.f7904a.b() >= 2) {
            bArr = this.f7904a.mo122a();
            i2 = this.f7904a.a();
            this.f7904a.a(2);
        } else {
            a(this.f7517i, 0, 2);
        }
        return (short) ((bArr[i2 + 1] & ThreadUtils.TYPE_SINGLE) | ((bArr[i2] & ThreadUtils.TYPE_SINGLE) << 8));
    }

    @Override // c.k.d.t8
    /* renamed from: a, reason: collision with other method in class */
    public void mo351a() {
    }

    @Override // c.k.d.t8
    public void a(byte b2) {
        byte[] bArr = this.f7512d;
        bArr[0] = b2;
        this.f7904a.mo76a(bArr, 0, 1);
    }

    @Override // c.k.d.t8
    /* renamed from: a, reason: collision with other method in class */
    public void mo352a(int i2) {
        byte[] bArr = this.f7514f;
        bArr[0] = (byte) ((i2 >> 24) & ViewfinderView.OPAQUE);
        bArr[1] = (byte) ((i2 >> 16) & ViewfinderView.OPAQUE);
        bArr[2] = (byte) ((i2 >> 8) & ViewfinderView.OPAQUE);
        bArr[3] = (byte) (i2 & ViewfinderView.OPAQUE);
        this.f7904a.mo76a(bArr, 0, 4);
    }

    @Override // c.k.d.t8
    public void a(long j) {
        byte[] bArr = this.f7515g;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        this.f7904a.mo76a(bArr, 0, 8);
    }

    @Override // c.k.d.t8
    public void a(q8 q8Var) {
        a(q8Var.f7785b);
        a(q8Var.f7786c);
    }

    @Override // c.k.d.t8
    public void a(r8 r8Var) {
        a(r8Var.f7821a);
        mo352a(r8Var.f7822b);
    }

    @Override // c.k.d.t8
    public void a(s8 s8Var) {
        a(s8Var.f7852a);
        a(s8Var.f7853b);
        mo352a(s8Var.f7854c);
    }

    @Override // c.k.d.t8
    public void a(y8 y8Var) {
    }

    @Override // c.k.d.t8
    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo352a(bytes.length);
            this.f7904a.mo76a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new n8("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // c.k.d.t8
    public void a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        mo352a(limit);
        this.f7904a.mo76a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    @Override // c.k.d.t8
    public void a(short s) {
        byte[] bArr = this.f7513e;
        bArr[0] = (byte) ((s >> 8) & ViewfinderView.OPAQUE);
        bArr[1] = (byte) (s & 255);
        this.f7904a.mo76a(bArr, 0, 2);
    }

    @Override // c.k.d.t8
    public void a(boolean z) {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // c.k.d.t8
    /* renamed from: a, reason: collision with other method in class */
    public boolean mo353a() {
        return a() == 1;
    }

    @Override // c.k.d.t8
    public void b() {
    }

    public void b(int i2) {
        this.f7510b = i2;
        this.f7511c = true;
    }

    @Override // c.k.d.t8
    public void c() {
        a((byte) 0);
    }

    public void c(int i2) {
        if (i2 < 0) {
            throw new n8("Negative length: " + i2);
        }
        if (this.f7511c) {
            int i3 = this.f7510b - i2;
            this.f7510b = i3;
            if (i3 >= 0) {
                return;
            }
            throw new n8("Message length exceeded: " + i2);
        }
    }

    @Override // c.k.d.t8
    public void d() {
    }

    @Override // c.k.d.t8
    public void e() {
    }

    @Override // c.k.d.t8
    public void f() {
    }

    @Override // c.k.d.t8
    public void g() {
    }

    @Override // c.k.d.t8
    public void h() {
    }

    @Override // c.k.d.t8
    public void i() {
    }

    @Override // c.k.d.t8
    public void j() {
    }
}
