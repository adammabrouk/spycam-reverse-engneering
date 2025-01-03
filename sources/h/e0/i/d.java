package h.e0.i;

import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.shix.shixipc.utilcode.ThreadUtils;
import i.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Hpack.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final c[] f11515a = {new c(c.f11511i, ""), new c(c.f11508f, "GET"), new c(c.f11508f, "POST"), new c(c.f11509g, "/"), new c(c.f11509g, "/index.html"), new c(c.f11510h, "http"), new c(c.f11510h, "https"), new c(c.f11507e, "200"), new c(c.f11507e, "204"), new c(c.f11507e, "206"), new c(c.f11507e, "304"), new c(c.f11507e, "400"), new c(c.f11507e, "404"), new c(c.f11507e, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c(RequestParameters.SUBRESOURCE_LOCATION, ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c(RequestParameters.SUBRESOURCE_REFERER, ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};

    /* renamed from: b, reason: collision with root package name */
    public static final Map<i.f, Integer> f11516b = a();

    /* compiled from: Hpack.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final List<c> f11517a;

        /* renamed from: b, reason: collision with root package name */
        public final i.e f11518b;

        /* renamed from: c, reason: collision with root package name */
        public final int f11519c;

        /* renamed from: d, reason: collision with root package name */
        public int f11520d;

        /* renamed from: e, reason: collision with root package name */
        public c[] f11521e;

        /* renamed from: f, reason: collision with root package name */
        public int f11522f;

        /* renamed from: g, reason: collision with root package name */
        public int f11523g;

        /* renamed from: h, reason: collision with root package name */
        public int f11524h;

        public a(int i2, s sVar) {
            this(i2, i2, sVar);
        }

        public final void a() {
            int i2 = this.f11520d;
            int i3 = this.f11524h;
            if (i2 < i3) {
                if (i2 == 0) {
                    b();
                } else {
                    b(i3 - i2);
                }
            }
        }

        public final void b() {
            Arrays.fill(this.f11521e, (Object) null);
            this.f11522f = this.f11521e.length - 1;
            this.f11523g = 0;
            this.f11524h = 0;
        }

        public List<c> c() {
            ArrayList arrayList = new ArrayList(this.f11517a);
            this.f11517a.clear();
            return arrayList;
        }

        public final boolean d(int i2) {
            return i2 >= 0 && i2 <= d.f11515a.length - 1;
        }

        public final void e(int i2) throws IOException {
            if (d(i2)) {
                this.f11517a.add(d.f11515a[i2]);
                return;
            }
            int a2 = a(i2 - d.f11515a.length);
            if (a2 >= 0) {
                c[] cVarArr = this.f11521e;
                if (a2 < cVarArr.length) {
                    this.f11517a.add(cVarArr[a2]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        public void f() throws IOException {
            while (!this.f11518b.k()) {
                int readByte = this.f11518b.readByte() & ThreadUtils.TYPE_SINGLE;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & RecyclerView.c0.FLAG_IGNORE) == 128) {
                    e(a(readByte, 127) - 1);
                } else if (readByte == 64) {
                    g();
                } else if ((readByte & 64) == 64) {
                    f(a(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int a2 = a(readByte, 31);
                    this.f11520d = a2;
                    if (a2 < 0 || a2 > this.f11519c) {
                        throw new IOException("Invalid dynamic table size update " + this.f11520d);
                    }
                    a();
                } else if (readByte == 16 || readByte == 0) {
                    h();
                } else {
                    g(a(readByte, 15) - 1);
                }
            }
        }

        public final void g(int i2) throws IOException {
            this.f11517a.add(new c(c(i2), e()));
        }

        public final void h() throws IOException {
            i.f e2 = e();
            d.a(e2);
            this.f11517a.add(new c(e2, e()));
        }

        public a(int i2, int i3, s sVar) {
            this.f11517a = new ArrayList();
            this.f11521e = new c[8];
            this.f11522f = r0.length - 1;
            this.f11523g = 0;
            this.f11524h = 0;
            this.f11519c = i2;
            this.f11520d = i3;
            this.f11518b = i.l.a(sVar);
        }

        public final int d() throws IOException {
            return this.f11518b.readByte() & ThreadUtils.TYPE_SINGLE;
        }

        public final i.f c(int i2) throws IOException {
            if (d(i2)) {
                return d.f11515a[i2].f11512a;
            }
            int a2 = a(i2 - d.f11515a.length);
            if (a2 >= 0) {
                c[] cVarArr = this.f11521e;
                if (a2 < cVarArr.length) {
                    return cVarArr[a2].f11512a;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        public final int a(int i2) {
            return this.f11522f + 1 + i2;
        }

        public final void g() throws IOException {
            i.f e2 = e();
            d.a(e2);
            a(-1, new c(e2, e()));
        }

        public final void a(int i2, c cVar) {
            this.f11517a.add(cVar);
            int i3 = cVar.f11514c;
            if (i2 != -1) {
                i3 -= this.f11521e[a(i2)].f11514c;
            }
            int i4 = this.f11520d;
            if (i3 > i4) {
                b();
                return;
            }
            int b2 = b((this.f11524h + i3) - i4);
            if (i2 == -1) {
                int i5 = this.f11523g + 1;
                c[] cVarArr = this.f11521e;
                if (i5 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f11522f = this.f11521e.length - 1;
                    this.f11521e = cVarArr2;
                }
                int i6 = this.f11522f;
                this.f11522f = i6 - 1;
                this.f11521e[i6] = cVar;
                this.f11523g++;
            } else {
                this.f11521e[i2 + a(i2) + b2] = cVar;
            }
            this.f11524h += i3;
        }

        public final int b(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.f11521e.length;
                while (true) {
                    length--;
                    if (length < this.f11522f || i2 <= 0) {
                        break;
                    }
                    c[] cVarArr = this.f11521e;
                    i2 -= cVarArr[length].f11514c;
                    this.f11524h -= cVarArr[length].f11514c;
                    this.f11523g--;
                    i3++;
                }
                c[] cVarArr2 = this.f11521e;
                int i4 = this.f11522f;
                System.arraycopy(cVarArr2, i4 + 1, cVarArr2, i4 + 1 + i3, this.f11523g);
                this.f11522f += i3;
            }
            return i3;
        }

        public i.f e() throws IOException {
            int d2 = d();
            boolean z = (d2 & RecyclerView.c0.FLAG_IGNORE) == 128;
            int a2 = a(d2, 127);
            if (z) {
                return i.f.of(k.b().a(this.f11518b.d(a2)));
            }
            return this.f11518b.c(a2);
        }

        public final void f(int i2) throws IOException {
            a(-1, new c(c(i2), e()));
        }

        public int a(int i2, int i3) throws IOException {
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                int d2 = d();
                if ((d2 & RecyclerView.c0.FLAG_IGNORE) == 0) {
                    return i3 + (d2 << i5);
                }
                i3 += (d2 & 127) << i5;
                i5 += 7;
            }
        }
    }

    /* compiled from: Hpack.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final i.c f11525a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f11526b;

        /* renamed from: c, reason: collision with root package name */
        public int f11527c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f11528d;

        /* renamed from: e, reason: collision with root package name */
        public int f11529e;

        /* renamed from: f, reason: collision with root package name */
        public c[] f11530f;

        /* renamed from: g, reason: collision with root package name */
        public int f11531g;

        /* renamed from: h, reason: collision with root package name */
        public int f11532h;

        /* renamed from: i, reason: collision with root package name */
        public int f11533i;

        public b(i.c cVar) {
            this(4096, true, cVar);
        }

        public final int a(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.f11530f.length;
                while (true) {
                    length--;
                    if (length < this.f11531g || i2 <= 0) {
                        break;
                    }
                    c[] cVarArr = this.f11530f;
                    i2 -= cVarArr[length].f11514c;
                    this.f11533i -= cVarArr[length].f11514c;
                    this.f11532h--;
                    i3++;
                }
                c[] cVarArr2 = this.f11530f;
                int i4 = this.f11531g;
                System.arraycopy(cVarArr2, i4 + 1, cVarArr2, i4 + 1 + i3, this.f11532h);
                c[] cVarArr3 = this.f11530f;
                int i5 = this.f11531g;
                Arrays.fill(cVarArr3, i5 + 1, i5 + 1 + i3, (Object) null);
                this.f11531g += i3;
            }
            return i3;
        }

        public final void b() {
            Arrays.fill(this.f11530f, (Object) null);
            this.f11531g = this.f11530f.length - 1;
            this.f11532h = 0;
            this.f11533i = 0;
        }

        public b(int i2, boolean z, i.c cVar) {
            this.f11527c = Integer.MAX_VALUE;
            this.f11530f = new c[8];
            this.f11531g = r0.length - 1;
            this.f11532h = 0;
            this.f11533i = 0;
            this.f11529e = i2;
            this.f11526b = z;
            this.f11525a = cVar;
        }

        public void b(int i2) {
            int min = Math.min(i2, 16384);
            int i3 = this.f11529e;
            if (i3 == min) {
                return;
            }
            if (min < i3) {
                this.f11527c = Math.min(this.f11527c, min);
            }
            this.f11528d = true;
            this.f11529e = min;
            a();
        }

        public final void a(c cVar) {
            int i2 = cVar.f11514c;
            int i3 = this.f11529e;
            if (i2 > i3) {
                b();
                return;
            }
            a((this.f11533i + i2) - i3);
            int i4 = this.f11532h + 1;
            c[] cVarArr = this.f11530f;
            if (i4 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f11531g = this.f11530f.length - 1;
                this.f11530f = cVarArr2;
            }
            int i5 = this.f11531g;
            this.f11531g = i5 - 1;
            this.f11530f[i5] = cVar;
            this.f11532h++;
            this.f11533i += i2;
        }

        public void a(List<c> list) throws IOException {
            int i2;
            int i3;
            if (this.f11528d) {
                int i4 = this.f11527c;
                if (i4 < this.f11529e) {
                    a(i4, 31, 32);
                }
                this.f11528d = false;
                this.f11527c = Integer.MAX_VALUE;
                a(this.f11529e, 31, 32);
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                c cVar = list.get(i5);
                i.f asciiLowercase = cVar.f11512a.toAsciiLowercase();
                i.f fVar = cVar.f11513b;
                Integer num = d.f11516b.get(asciiLowercase);
                if (num != null) {
                    i2 = num.intValue() + 1;
                    if (i2 > 1 && i2 < 8) {
                        if (h.e0.c.a(d.f11515a[i2 - 1].f11513b, fVar)) {
                            i3 = i2;
                        } else if (h.e0.c.a(d.f11515a[i2].f11513b, fVar)) {
                            i3 = i2;
                            i2++;
                        }
                    }
                    i3 = i2;
                    i2 = -1;
                } else {
                    i2 = -1;
                    i3 = -1;
                }
                if (i2 == -1) {
                    int i6 = this.f11531g + 1;
                    int length = this.f11530f.length;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        }
                        if (h.e0.c.a(this.f11530f[i6].f11512a, asciiLowercase)) {
                            if (h.e0.c.a(this.f11530f[i6].f11513b, fVar)) {
                                i2 = d.f11515a.length + (i6 - this.f11531g);
                                break;
                            } else if (i3 == -1) {
                                i3 = (i6 - this.f11531g) + d.f11515a.length;
                            }
                        }
                        i6++;
                    }
                }
                if (i2 != -1) {
                    a(i2, 127, RecyclerView.c0.FLAG_IGNORE);
                } else if (i3 == -1) {
                    this.f11525a.writeByte(64);
                    a(asciiLowercase);
                    a(fVar);
                    a(cVar);
                } else if (asciiLowercase.startsWith(c.f11506d) && !c.f11511i.equals(asciiLowercase)) {
                    a(i3, 15, 0);
                    a(fVar);
                } else {
                    a(i3, 63, 64);
                    a(fVar);
                    a(cVar);
                }
            }
        }

        public void a(int i2, int i3, int i4) {
            if (i2 < i3) {
                this.f11525a.writeByte(i2 | i4);
                return;
            }
            this.f11525a.writeByte(i4 | i3);
            int i5 = i2 - i3;
            while (i5 >= 128) {
                this.f11525a.writeByte(128 | (i5 & 127));
                i5 >>>= 7;
            }
            this.f11525a.writeByte(i5);
        }

        public void a(i.f fVar) throws IOException {
            if (this.f11526b && k.b().a(fVar) < fVar.size()) {
                i.c cVar = new i.c();
                k.b().a(fVar, cVar);
                i.f c2 = cVar.c();
                a(c2.size(), 127, RecyclerView.c0.FLAG_IGNORE);
                this.f11525a.a(c2);
                return;
            }
            a(fVar.size(), 127, 0);
            this.f11525a.a(fVar);
        }

        public final void a() {
            int i2 = this.f11529e;
            int i3 = this.f11533i;
            if (i2 < i3) {
                if (i2 == 0) {
                    b();
                } else {
                    a(i3 - i2);
                }
            }
        }
    }

    public static Map<i.f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f11515a.length);
        int i2 = 0;
        while (true) {
            c[] cVarArr = f11515a;
            if (i2 >= cVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(cVarArr[i2].f11512a)) {
                linkedHashMap.put(f11515a[i2].f11512a, Integer.valueOf(i2));
            }
            i2++;
        }
    }

    public static i.f a(i.f fVar) throws IOException {
        int size = fVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            byte b2 = fVar.getByte(i2);
            if (b2 >= 65 && b2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.utf8());
            }
        }
        return fVar;
    }
}
