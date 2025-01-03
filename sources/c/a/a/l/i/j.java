package c.a.a.l.i;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/* compiled from: OriginalKey.java */
/* loaded from: classes.dex */
public class j implements c.a.a.l.c {

    /* renamed from: a, reason: collision with root package name */
    public final String f3117a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a.a.l.c f3118b;

    public j(String str, c.a.a.l.c cVar) {
        this.f3117a = str;
        this.f3118b = cVar;
    }

    @Override // c.a.a.l.c
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.f3117a.getBytes("UTF-8"));
        this.f3118b.a(messageDigest);
    }

    @Override // c.a.a.l.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.f3117a.equals(jVar.f3117a) && this.f3118b.equals(jVar.f3118b);
    }

    @Override // c.a.a.l.c
    public int hashCode() {
        return (this.f3117a.hashCode() * 31) + this.f3118b.hashCode();
    }
}
