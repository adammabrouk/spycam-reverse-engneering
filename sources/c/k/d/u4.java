package c.k.d;

import android.os.Build;
import com.shix.shixipc.utilcode.TimeConstants;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;

/* loaded from: classes.dex */
public class u4 {

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f7926a = ByteBuffer.allocate(2048);

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f7927b = ByteBuffer.allocate(4);

    /* renamed from: c, reason: collision with root package name */
    public Adler32 f7928c = new Adler32();

    /* renamed from: d, reason: collision with root package name */
    public x4 f7929d;

    /* renamed from: e, reason: collision with root package name */
    public OutputStream f7930e;

    /* renamed from: f, reason: collision with root package name */
    public int f7931f;

    /* renamed from: g, reason: collision with root package name */
    public int f7932g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f7933h;

    public u4(OutputStream outputStream, x4 x4Var) {
        this.f7930e = new BufferedOutputStream(outputStream);
        this.f7929d = x4Var;
        TimeZone timeZone = TimeZone.getDefault();
        this.f7931f = timeZone.getRawOffset() / TimeConstants.HOUR;
        this.f7932g = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(s4 s4Var) {
        int c2 = s4Var.c();
        if (c2 > 32768) {
            c.k.a.a.a.c.m6a("Blob size=" + c2 + " should be less than 32768 Drop blob chid=" + s4Var.a() + " id=" + s4Var.d());
            return 0;
        }
        this.f7926a.clear();
        int i2 = c2 + 8 + 4;
        if (i2 > this.f7926a.capacity() || this.f7926a.capacity() > 4096) {
            this.f7926a = ByteBuffer.allocate(i2);
        }
        this.f7926a.putShort((short) -15618);
        this.f7926a.putShort((short) 5);
        this.f7926a.putInt(c2);
        int position = this.f7926a.position();
        this.f7926a = s4Var.mo462a(this.f7926a);
        if (!"CONN".equals(s4Var.m461a())) {
            if (this.f7933h == null) {
                this.f7933h = this.f7929d.m526a();
            }
            c.k.d.p9.a0.a(this.f7933h, this.f7926a.array(), true, position, c2);
        }
        this.f7928c.reset();
        this.f7928c.update(this.f7926a.array(), 0, this.f7926a.position());
        this.f7927b.putInt(0, (int) this.f7928c.getValue());
        this.f7930e.write(this.f7926a.array(), 0, this.f7926a.position());
        this.f7930e.write(this.f7927b.array(), 0, 4);
        this.f7930e.flush();
        int position2 = this.f7926a.position() + 4;
        c.k.a.a.a.c.c("[Slim] Wrote {cmd=" + s4Var.m461a() + ";chid=" + s4Var.a() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        l3 l3Var = new l3();
        l3Var.a(106);
        l3Var.a(Build.MODEL);
        l3Var.b(q9.m433a());
        l3Var.c(c.k.d.p9.h0.m381a());
        l3Var.b(39);
        l3Var.d(this.f7929d.m546b());
        l3Var.e(this.f7929d.mo543a());
        l3Var.f(Locale.getDefault().toString());
        l3Var.c(Build.VERSION.SDK_INT);
        byte[] mo73a = this.f7929d.m542a().mo73a();
        if (mo73a != null) {
            l3Var.a(i3.a(mo73a));
        }
        s4 s4Var = new s4();
        s4Var.a(0);
        s4Var.a("CONN", (String) null);
        s4Var.a(0L, "xiaomi.com", null);
        s4Var.a(l3Var.m460a(), (String) null);
        a(s4Var);
        c.k.a.a.a.c.m6a("[slim] open conn: andver=" + Build.VERSION.SDK_INT + " sdk=39 hash=" + c.k.d.p9.h0.m381a() + " tz=" + this.f7931f + ":" + this.f7932g + " Model=" + Build.MODEL + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        s4 s4Var = new s4();
        s4Var.a("CLOSE", (String) null);
        a(s4Var);
        this.f7930e.close();
    }
}
