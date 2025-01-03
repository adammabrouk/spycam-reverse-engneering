package c.k.d;

import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

/* loaded from: classes.dex */
public class t4 {

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f7875a = ByteBuffer.allocate(2048);

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f7876b = ByteBuffer.allocate(4);

    /* renamed from: c, reason: collision with root package name */
    public Adler32 f7877c = new Adler32();

    /* renamed from: d, reason: collision with root package name */
    public v4 f7878d = new v4();

    /* renamed from: e, reason: collision with root package name */
    public InputStream f7879e;

    /* renamed from: f, reason: collision with root package name */
    public x4 f7880f;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f7881g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f7882h;

    public t4(InputStream inputStream, x4 x4Var) {
        this.f7879e = new BufferedInputStream(inputStream);
        this.f7880f = x4Var;
    }

    public s4 a() {
        int i2;
        try {
            ByteBuffer m480a = m480a();
            i2 = m480a.position();
            try {
                m480a.flip();
                m480a.position(8);
                s4 w4Var = i2 == 8 ? new w4() : s4.a(m480a.slice());
                c.k.a.a.a.c.c("[Slim] Read {cmd=" + w4Var.m461a() + ";chid=" + w4Var.a() + ";len=" + i2 + "}");
                return w4Var;
            } catch (IOException e2) {
                e = e2;
                if (i2 == 0) {
                    i2 = this.f7875a.position();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[Slim] read Blob [");
                byte[] array = this.f7875a.array();
                if (i2 > 128) {
                    i2 = RecyclerView.c0.FLAG_IGNORE;
                }
                sb.append(g.a(array, 0, i2));
                sb.append("] Err:");
                sb.append(e.getMessage());
                c.k.a.a.a.c.m6a(sb.toString());
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            i2 = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cf  */
    /* renamed from: a, reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.nio.ByteBuffer m480a() {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.t4.m480a():java.nio.ByteBuffer");
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m481a() {
        try {
            c();
        } catch (IOException e2) {
            if (!this.f7881g) {
                throw e2;
            }
        }
    }

    public final void a(ByteBuffer byteBuffer, int i2) {
        int position = byteBuffer.position();
        do {
            int read = this.f7879e.read(byteBuffer.array(), position, i2);
            if (read == -1) {
                throw new EOFException();
            }
            i2 -= read;
            position += read;
        } while (i2 > 0);
        byteBuffer.position(position);
    }

    public void b() {
        this.f7881g = true;
    }

    public final void c() {
        String str;
        StringBuilder sb;
        boolean z = false;
        this.f7881g = false;
        s4 a2 = a();
        if ("CONN".equals(a2.m461a())) {
            m3 a3 = m3.a(a2.m465a());
            if (a3.m296a()) {
                this.f7880f.a(a3.m295a());
                z = true;
            }
            if (a3.c()) {
                i3 m294a = a3.m294a();
                s4 s4Var = new s4();
                s4Var.a("SYNC", "CONF");
                s4Var.a(m294a.m460a(), (String) null);
                this.f7880f.b(s4Var);
            }
            c.k.a.a.a.c.m6a("[Slim] CONN: host = " + a3.m297b());
        }
        if (!z) {
            c.k.a.a.a.c.m6a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f7882h = this.f7880f.m526a();
        while (!this.f7881g) {
            s4 a4 = a();
            this.f7880f.c();
            short m463a = a4.m463a();
            if (m463a != 1) {
                if (m463a != 2) {
                    if (m463a != 3) {
                        str = "[Slim] unknow blob type " + ((int) a4.m463a());
                        c.k.a.a.a.c.m6a(str);
                    } else {
                        try {
                            this.f7880f.b(this.f7878d.a(a4.m465a(), this.f7880f));
                        } catch (Exception e2) {
                            e = e2;
                            sb = new StringBuilder();
                            sb.append("[Slim] Parse packet from Blob chid=");
                            sb.append(a4.a());
                            sb.append("; Id=");
                            sb.append(a4.d());
                            sb.append(" failure:");
                            sb.append(e.getMessage());
                            str = sb.toString();
                            c.k.a.a.a.c.m6a(str);
                        }
                    }
                } else if ("SECMSG".equals(a4.m461a()) && ((a4.a() == 2 || a4.a() == 3) && TextUtils.isEmpty(a4.m467b()))) {
                    try {
                        this.f7880f.b(this.f7878d.a(a4.m466a(c.k.d.p9.r.a().a(Integer.valueOf(a4.a()).toString(), a4.f()).f7685i), this.f7880f));
                    } catch (Exception e3) {
                        e = e3;
                        sb = new StringBuilder();
                        sb.append("[Slim] Parse packet from Blob chid=");
                        sb.append(a4.a());
                        sb.append("; Id=");
                        sb.append(a4.d());
                        sb.append(" failure:");
                        sb.append(e.getMessage());
                        str = sb.toString();
                        c.k.a.a.a.c.m6a(str);
                    }
                }
            }
            this.f7880f.b(a4);
        }
    }
}
