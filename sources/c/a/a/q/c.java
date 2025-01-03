package c.a.a.q;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* compiled from: StringSignature.java */
/* loaded from: classes.dex */
public class c implements c.a.a.l.c {

    /* renamed from: a, reason: collision with root package name */
    public final String f3447a;

    public c(String str) {
        if (str == null) {
            throw new NullPointerException("Signature cannot be null!");
        }
        this.f3447a = str;
    }

    @Override // c.a.a.l.c
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.f3447a.getBytes("UTF-8"));
    }

    @Override // c.a.a.l.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.f3447a.equals(((c) obj).f3447a);
    }

    @Override // c.a.a.l.c
    public int hashCode() {
        return this.f3447a.hashCode();
    }

    public String toString() {
        return "StringSignature{signature='" + this.f3447a + "'}";
    }
}
