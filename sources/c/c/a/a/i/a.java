package c.c.a.a.i;

import c.c.a.a.b;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.0 */
/* loaded from: classes.dex */
public final class a implements c.c.a.a.j.f {

    /* renamed from: c, reason: collision with root package name */
    public static final String f3470c = f.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");

    /* renamed from: d, reason: collision with root package name */
    public static final String f3471d = f.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");

    /* renamed from: e, reason: collision with root package name */
    public static final String f3472e = f.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");

    /* renamed from: f, reason: collision with root package name */
    public static final Set<b> f3473f = Collections.unmodifiableSet(new HashSet(Arrays.asList(b.a("proto"), b.a("json"))));

    /* renamed from: g, reason: collision with root package name */
    public static final a f3474g;

    /* renamed from: a, reason: collision with root package name */
    public final String f3475a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3476b;

    static {
        new a(f3470c, null);
        f3474g = new a(f3471d, f3472e);
    }

    public a(String str, String str2) {
        this.f3475a = str;
        this.f3476b = str2;
    }

    public static a a(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] split = str.substring(2).split(Pattern.quote("\\"), 2);
        if (split.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = split[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = split[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new a(str2, str3);
    }

    @Override // c.c.a.a.j.e
    public String b() {
        return "cct";
    }

    @Override // c.c.a.a.j.e
    public byte[] c() {
        return d();
    }

    public byte[] d() {
        if (this.f3476b == null && this.f3475a == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f3475a;
        objArr[2] = "\\";
        String str = this.f3476b;
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }

    public String e() {
        return this.f3476b;
    }

    public String f() {
        return this.f3475a;
    }

    @Override // c.c.a.a.j.f
    public Set<b> a() {
        return f3473f;
    }
}
