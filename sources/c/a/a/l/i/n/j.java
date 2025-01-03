package c.a.a.l.i.n;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SafeKeyGenerator.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final c.a.a.r.e<c.a.a.l.c, String> f3174a = new c.a.a.r.e<>(1000);

    public String a(c.a.a.l.c cVar) {
        String a2;
        synchronized (this.f3174a) {
            a2 = this.f3174a.a(cVar);
        }
        if (a2 == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                cVar.a(messageDigest);
                a2 = c.a.a.r.h.a(messageDigest.digest());
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            } catch (NoSuchAlgorithmException e3) {
                e3.printStackTrace();
            }
            synchronized (this.f3174a) {
                this.f3174a.b(cVar, a2);
            }
        }
        return a2;
    }
}
