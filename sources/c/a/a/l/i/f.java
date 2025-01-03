package c.a.a.l.i;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: EngineKey.java */
/* loaded from: classes.dex */
public class f implements c.a.a.l.c {

    /* renamed from: a, reason: collision with root package name */
    public final String f3096a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3097b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3098c;

    /* renamed from: d, reason: collision with root package name */
    public final c.a.a.l.e f3099d;

    /* renamed from: e, reason: collision with root package name */
    public final c.a.a.l.e f3100e;

    /* renamed from: f, reason: collision with root package name */
    public final c.a.a.l.g f3101f;

    /* renamed from: g, reason: collision with root package name */
    public final c.a.a.l.f f3102g;

    /* renamed from: h, reason: collision with root package name */
    public final c.a.a.l.k.j.c f3103h;

    /* renamed from: i, reason: collision with root package name */
    public final c.a.a.l.b f3104i;
    public final c.a.a.l.c j;
    public String k;
    public int l;
    public c.a.a.l.c m;

    public f(String str, c.a.a.l.c cVar, int i2, int i3, c.a.a.l.e eVar, c.a.a.l.e eVar2, c.a.a.l.g gVar, c.a.a.l.f fVar, c.a.a.l.k.j.c cVar2, c.a.a.l.b bVar) {
        this.f3096a = str;
        this.j = cVar;
        this.f3097b = i2;
        this.f3098c = i3;
        this.f3099d = eVar;
        this.f3100e = eVar2;
        this.f3101f = gVar;
        this.f3102g = fVar;
        this.f3103h = cVar2;
        this.f3104i = bVar;
    }

    public c.a.a.l.c a() {
        if (this.m == null) {
            this.m = new j(this.f3096a, this.j);
        }
        return this.m;
    }

    @Override // c.a.a.l.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (!this.f3096a.equals(fVar.f3096a) || !this.j.equals(fVar.j) || this.f3098c != fVar.f3098c || this.f3097b != fVar.f3097b) {
            return false;
        }
        if ((this.f3101f == null) ^ (fVar.f3101f == null)) {
            return false;
        }
        c.a.a.l.g gVar = this.f3101f;
        if (gVar != null && !gVar.c().equals(fVar.f3101f.c())) {
            return false;
        }
        if ((this.f3100e == null) ^ (fVar.f3100e == null)) {
            return false;
        }
        c.a.a.l.e eVar = this.f3100e;
        if (eVar != null && !eVar.c().equals(fVar.f3100e.c())) {
            return false;
        }
        if ((this.f3099d == null) ^ (fVar.f3099d == null)) {
            return false;
        }
        c.a.a.l.e eVar2 = this.f3099d;
        if (eVar2 != null && !eVar2.c().equals(fVar.f3099d.c())) {
            return false;
        }
        if ((this.f3102g == null) ^ (fVar.f3102g == null)) {
            return false;
        }
        c.a.a.l.f fVar2 = this.f3102g;
        if (fVar2 != null && !fVar2.c().equals(fVar.f3102g.c())) {
            return false;
        }
        if ((this.f3103h == null) ^ (fVar.f3103h == null)) {
            return false;
        }
        c.a.a.l.k.j.c cVar = this.f3103h;
        if (cVar != null && !cVar.c().equals(fVar.f3103h.c())) {
            return false;
        }
        if ((this.f3104i == null) ^ (fVar.f3104i == null)) {
            return false;
        }
        c.a.a.l.b bVar = this.f3104i;
        return bVar == null || bVar.c().equals(fVar.f3104i.c());
    }

    @Override // c.a.a.l.c
    public int hashCode() {
        if (this.l == 0) {
            int hashCode = this.f3096a.hashCode();
            this.l = hashCode;
            int hashCode2 = (hashCode * 31) + this.j.hashCode();
            this.l = hashCode2;
            int i2 = (hashCode2 * 31) + this.f3097b;
            this.l = i2;
            int i3 = (i2 * 31) + this.f3098c;
            this.l = i3;
            int i4 = i3 * 31;
            c.a.a.l.e eVar = this.f3099d;
            int hashCode3 = i4 + (eVar != null ? eVar.c().hashCode() : 0);
            this.l = hashCode3;
            int i5 = hashCode3 * 31;
            c.a.a.l.e eVar2 = this.f3100e;
            int hashCode4 = i5 + (eVar2 != null ? eVar2.c().hashCode() : 0);
            this.l = hashCode4;
            int i6 = hashCode4 * 31;
            c.a.a.l.g gVar = this.f3101f;
            int hashCode5 = i6 + (gVar != null ? gVar.c().hashCode() : 0);
            this.l = hashCode5;
            int i7 = hashCode5 * 31;
            c.a.a.l.f fVar = this.f3102g;
            int hashCode6 = i7 + (fVar != null ? fVar.c().hashCode() : 0);
            this.l = hashCode6;
            int i8 = hashCode6 * 31;
            c.a.a.l.k.j.c cVar = this.f3103h;
            int hashCode7 = i8 + (cVar != null ? cVar.c().hashCode() : 0);
            this.l = hashCode7;
            int i9 = hashCode7 * 31;
            c.a.a.l.b bVar = this.f3104i;
            this.l = i9 + (bVar != null ? bVar.c().hashCode() : 0);
        }
        return this.l;
    }

    public String toString() {
        if (this.k == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("EngineKey{");
            sb.append(this.f3096a);
            sb.append('+');
            sb.append(this.j);
            sb.append("+[");
            sb.append(this.f3097b);
            sb.append('x');
            sb.append(this.f3098c);
            sb.append("]+");
            sb.append('\'');
            c.a.a.l.e eVar = this.f3099d;
            sb.append(eVar != null ? eVar.c() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            c.a.a.l.e eVar2 = this.f3100e;
            sb.append(eVar2 != null ? eVar2.c() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            c.a.a.l.g gVar = this.f3101f;
            sb.append(gVar != null ? gVar.c() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            c.a.a.l.f fVar = this.f3102g;
            sb.append(fVar != null ? fVar.c() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            c.a.a.l.k.j.c cVar = this.f3103h;
            sb.append(cVar != null ? cVar.c() : "");
            sb.append('\'');
            sb.append('+');
            sb.append('\'');
            c.a.a.l.b bVar = this.f3104i;
            sb.append(bVar != null ? bVar.c() : "");
            sb.append('\'');
            sb.append('}');
            this.k = sb.toString();
        }
        return this.k;
    }

    @Override // c.a.a.l.c
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        byte[] array = ByteBuffer.allocate(8).putInt(this.f3097b).putInt(this.f3098c).array();
        this.j.a(messageDigest);
        messageDigest.update(this.f3096a.getBytes("UTF-8"));
        messageDigest.update(array);
        c.a.a.l.e eVar = this.f3099d;
        messageDigest.update((eVar != null ? eVar.c() : "").getBytes("UTF-8"));
        c.a.a.l.e eVar2 = this.f3100e;
        messageDigest.update((eVar2 != null ? eVar2.c() : "").getBytes("UTF-8"));
        c.a.a.l.g gVar = this.f3101f;
        messageDigest.update((gVar != null ? gVar.c() : "").getBytes("UTF-8"));
        c.a.a.l.f fVar = this.f3102g;
        messageDigest.update((fVar != null ? fVar.c() : "").getBytes("UTF-8"));
        c.a.a.l.b bVar = this.f3104i;
        messageDigest.update((bVar != null ? bVar.c() : "").getBytes("UTF-8"));
    }
}
