package a.h.g;

import a.h.i.h;
import android.util.Base64;
import java.util.List;

/* compiled from: FontRequest.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f1026a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1027b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1028c;

    /* renamed from: d, reason: collision with root package name */
    public final List<List<byte[]>> f1029d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1030e;

    /* renamed from: f, reason: collision with root package name */
    public final String f1031f;

    public d(String str, String str2, String str3, List<List<byte[]>> list) {
        h.a(str);
        this.f1026a = str;
        h.a(str2);
        this.f1027b = str2;
        h.a(str3);
        this.f1028c = str3;
        h.a(list);
        this.f1029d = list;
        this.f1030e = 0;
        this.f1031f = a(str, str2, str3);
    }

    public final String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public int b() {
        return this.f1030e;
    }

    public String c() {
        return this.f1031f;
    }

    public String d() {
        return this.f1026a;
    }

    public String e() {
        return this.f1027b;
    }

    public String f() {
        return this.f1028c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f1026a + ", mProviderPackage: " + this.f1027b + ", mQuery: " + this.f1028c + ", mCertificates:");
        for (int i2 = 0; i2 < this.f1029d.size(); i2++) {
            sb.append(" [");
            List<byte[]> list = this.f1029d.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f1030e);
        return sb.toString();
    }

    public List<List<byte[]>> a() {
        return this.f1029d;
    }
}
