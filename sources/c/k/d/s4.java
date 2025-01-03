package c.k.d;

import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class s4 {

    /* renamed from: e, reason: collision with root package name */
    public static String f7836e = c6.a(5) + "-";

    /* renamed from: f, reason: collision with root package name */
    public static long f7837f = 0;

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f7838g = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    public h3 f7839a;

    /* renamed from: b, reason: collision with root package name */
    public short f7840b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f7841c;

    /* renamed from: d, reason: collision with root package name */
    public String f7842d;

    public s4() {
        this.f7840b = (short) 2;
        this.f7841c = f7838g;
        this.f7842d = null;
        this.f7839a = new h3();
    }

    public s4(h3 h3Var, short s, byte[] bArr) {
        this.f7840b = (short) 2;
        this.f7841c = f7838g;
        this.f7842d = null;
        this.f7839a = h3Var;
        this.f7840b = s;
        this.f7841c = bArr;
    }

    @Deprecated
    public static s4 a(r5 r5Var, String str) {
        int i2;
        s4 s4Var = new s4();
        try {
            i2 = Integer.parseInt(r5Var.d());
        } catch (Exception e2) {
            c.k.a.a.a.c.m6a("Blob parse chid err " + e2.getMessage());
            i2 = 1;
        }
        s4Var.a(i2);
        s4Var.a(r5Var.c());
        s4Var.c(r5Var.f());
        s4Var.b(r5Var.g());
        s4Var.a("XMLMSG", (String) null);
        try {
            s4Var.a(r5Var.mo336a().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                s4Var.a((short) 3);
            } else {
                s4Var.a((short) 2);
                s4Var.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e3) {
            c.k.a.a.a.c.m6a("Blob setPayload err： " + e3.getMessage());
        }
        return s4Var;
    }

    public static s4 a(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s = slice.getShort(0);
            short s2 = slice.getShort(2);
            int i2 = slice.getInt(4);
            h3 h3Var = new h3();
            h3Var.a(slice.array(), slice.arrayOffset() + 8, (int) s2);
            byte[] bArr = new byte[i2];
            slice.position(s2 + 8);
            slice.get(bArr, 0, i2);
            return new s4(h3Var, s, bArr);
        } catch (Exception e2) {
            c.k.a.a.a.c.m6a("read Blob err :" + e2.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public static synchronized String g() {
        String sb;
        synchronized (s4.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f7836e);
            long j = f7837f;
            f7837f = 1 + j;
            sb2.append(Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    public int a() {
        return this.f7839a.c();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m461a() {
        return this.f7839a.m198c();
    }

    /* renamed from: a, reason: collision with other method in class */
    public ByteBuffer mo462a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(c());
        }
        byteBuffer.putShort(this.f7840b);
        byteBuffer.putShort((short) this.f7839a.a());
        byteBuffer.putInt(this.f7841c.length);
        int position = byteBuffer.position();
        this.f7839a.m459a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f7839a.a());
        byteBuffer.position(position + this.f7839a.a());
        byteBuffer.put(this.f7841c);
        return byteBuffer;
    }

    /* renamed from: a, reason: collision with other method in class */
    public short m463a() {
        return this.f7840b;
    }

    public void a(int i2) {
        this.f7839a.a(i2);
    }

    public void a(long j, String str, String str2) {
        if (j != 0) {
            this.f7839a.a(j);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f7839a.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f7839a.b(str2);
    }

    public void a(String str) {
        this.f7839a.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f7839a.c(str);
        this.f7839a.m193a();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f7839a.d(str2);
    }

    public void a(short s) {
        this.f7840b = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f7839a.c(0);
            this.f7841c = bArr;
        } else {
            this.f7839a.c(1);
            this.f7841c = c.k.d.p9.a0.a(c.k.d.p9.a0.a(str, d()), bArr);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m464a() {
        return this.f7839a.j();
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m465a() {
        return this.f7841c;
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m466a(String str) {
        if (this.f7839a.e() == 1) {
            return c.k.d.p9.a0.a(c.k.d.p9.a0.a(str, d()), this.f7841c);
        }
        if (this.f7839a.e() == 0) {
            return this.f7841c;
        }
        c.k.a.a.a.c.m6a("unknow cipher = " + this.f7839a.e());
        return this.f7841c;
    }

    public int b() {
        return this.f7839a.f();
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m467b() {
        return this.f7839a.m200d();
    }

    public void b(String str) {
        this.f7842d = str;
    }

    public int c() {
        return this.f7839a.b() + 8 + this.f7841c.length;
    }

    /* renamed from: c, reason: collision with other method in class */
    public String m468c() {
        return this.f7839a.m204f();
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf("@");
        try {
            long parseLong = Long.parseLong(str.substring(0, indexOf));
            int indexOf2 = str.indexOf("/", indexOf);
            String substring = str.substring(indexOf + 1, indexOf2);
            String substring2 = str.substring(indexOf2 + 1);
            this.f7839a.a(parseLong);
            this.f7839a.a(substring);
            this.f7839a.b(substring2);
        } catch (Exception e2) {
            c.k.a.a.a.c.m6a("Blob parse user err " + e2.getMessage());
        }
    }

    public String d() {
        String m202e = this.f7839a.m202e();
        if ("ID_NOT_AVAILABLE".equals(m202e)) {
            return null;
        }
        if (this.f7839a.g()) {
            return m202e;
        }
        String g2 = g();
        this.f7839a.e(g2);
        return g2;
    }

    public String e() {
        return this.f7842d;
    }

    public String f() {
        if (!this.f7839a.m197b()) {
            return null;
        }
        return Long.toString(this.f7839a.m192a()) + "@" + this.f7839a.m194a() + "/" + this.f7839a.m196b();
    }

    public String toString() {
        return "Blob [chid=" + a() + "; Id=" + d() + "; cmd=" + m461a() + "; type=" + ((int) m463a()) + "; from=" + f() + " ]";
    }
}
