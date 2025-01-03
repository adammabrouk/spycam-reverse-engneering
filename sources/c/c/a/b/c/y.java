package c.c.a.b.c;

import android.os.RemoteException;
import android.util.Log;
import c.c.a.b.c.o.m0;
import c.c.a.b.c.o.n0;
import c.c.a.b.c.o.r;
import com.google.zxing.qrcode.encoder.Encoder;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class y extends n0 {

    /* renamed from: a, reason: collision with root package name */
    public int f4040a;

    public y(byte[] bArr) {
        r.a(bArr.length == 25);
        this.f4040a = Arrays.hashCode(bArr);
    }

    public static byte[] a(String str) {
        try {
            return str.getBytes(Encoder.DEFAULT_BYTE_MODE_ENCODING);
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // c.c.a.b.c.o.m0
    public final int C() {
        return hashCode();
    }

    public boolean equals(Object obj) {
        c.c.a.b.d.a zzb;
        if (obj != null && (obj instanceof m0)) {
            try {
                m0 m0Var = (m0) obj;
                if (m0Var.C() == hashCode() && (zzb = m0Var.zzb()) != null) {
                    return Arrays.equals(f(), (byte[]) c.c.a.b.d.b.a(zzb));
                }
                return false;
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            }
        }
        return false;
    }

    public abstract byte[] f();

    public int hashCode() {
        return this.f4040a;
    }

    @Override // c.c.a.b.c.o.m0
    public final c.c.a.b.d.a zzb() {
        return c.c.a.b.d.b.a(f());
    }
}
