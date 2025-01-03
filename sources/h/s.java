package h;

import com.shix.shixipc.utilcode.ThreadUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: HttpUrl.java */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: i, reason: collision with root package name */
    public static final char[] f11740i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    public final String f11741a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11742b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11743c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11744d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11745e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final List<String> f11746f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f11747g;

    /* renamed from: h, reason: collision with root package name */
    public final String f11748h;

    /* compiled from: HttpUrl.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public String f11749a;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public String f11752d;

        /* renamed from: f, reason: collision with root package name */
        public final List<String> f11754f;

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        public List<String> f11755g;

        /* renamed from: h, reason: collision with root package name */
        @Nullable
        public String f11756h;

        /* renamed from: b, reason: collision with root package name */
        public String f11750b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f11751c = "";

        /* renamed from: e, reason: collision with root package name */
        public int f11753e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f11754f = arrayList;
            arrayList.add("");
        }

        public a a(int i2) {
            if (i2 > 0 && i2 <= 65535) {
                this.f11753e = i2;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i2);
        }

        public a b(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String b2 = b(str, 0, str.length());
            if (b2 != null) {
                this.f11752d = b2;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public final boolean c(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        public a d() {
            int size = this.f11754f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f11754f.set(i2, s.a(this.f11754f.get(i2), "[]", true, true, false, true));
            }
            List<String> list = this.f11755g;
            if (list != null) {
                int size2 = list.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str = this.f11755g.get(i3);
                    if (str != null) {
                        this.f11755g.set(i3, s.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f11756h;
            if (str2 != null) {
                this.f11756h = s.a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public a e(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.f11751c = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a f(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f11749a = "http";
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.f11749a = "https";
            }
            return this;
        }

        public a g(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.f11750b = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f11749a);
            sb.append("://");
            if (!this.f11750b.isEmpty() || !this.f11751c.isEmpty()) {
                sb.append(this.f11750b);
                if (!this.f11751c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f11751c);
                }
                sb.append('@');
            }
            if (this.f11752d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f11752d);
                sb.append(']');
            } else {
                sb.append(this.f11752d);
            }
            int b2 = b();
            if (b2 != s.c(this.f11749a)) {
                sb.append(':');
                sb.append(b2);
            }
            s.b(sb, this.f11754f);
            if (this.f11755g != null) {
                sb.append('?');
                s.a(sb, this.f11755g);
            }
            if (this.f11756h != null) {
                sb.append('#');
                sb.append(this.f11756h);
            }
            return sb.toString();
        }

        public final void c() {
            if (!this.f11754f.remove(r0.size() - 1).isEmpty() || this.f11754f.isEmpty()) {
                this.f11754f.add("");
            } else {
                this.f11754f.set(r0.size() - 1, "");
            }
        }

        public static int e(String str, int i2, int i3) {
            if (i3 - i2 < 2) {
                return -1;
            }
            char charAt = str.charAt(i2);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i2++;
                    if (i2 >= i3) {
                        break;
                    }
                    char charAt2 = str.charAt(i2);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i2;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public a a(@Nullable String str) {
            this.f11755g = str != null ? s.e(s.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public int b() {
            int i2 = this.f11753e;
            return i2 != -1 ? i2 : s.c(this.f11749a);
        }

        public static String b(String str, int i2, int i3) {
            return h.e0.c.a(s.a(str, i2, i3, false));
        }

        public static int c(String str, int i2, int i3) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(s.a(str, i2, i3, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        public s a() {
            if (this.f11749a != null) {
                if (this.f11752d != null) {
                    return new s(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public static int f(String str, int i2, int i3) {
            int i4 = 0;
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i4++;
                i2++;
            }
            return i4;
        }

        public a a(@Nullable s sVar, String str) {
            int a2;
            int i2;
            int b2 = h.e0.c.b(str, 0, str.length());
            int c2 = h.e0.c.c(str, b2, str.length());
            int e2 = e(str, b2, c2);
            if (e2 != -1) {
                if (str.regionMatches(true, b2, "https:", 0, 6)) {
                    this.f11749a = "https";
                    b2 += 6;
                } else if (str.regionMatches(true, b2, "http:", 0, 5)) {
                    this.f11749a = "http";
                    b2 += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, e2) + "'");
                }
            } else if (sVar != null) {
                this.f11749a = sVar.f11741a;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int f2 = f(str, b2, c2);
            char c3 = '?';
            char c4 = '#';
            if (f2 < 2 && sVar != null && sVar.f11741a.equals(this.f11749a)) {
                this.f11750b = sVar.f();
                this.f11751c = sVar.b();
                this.f11752d = sVar.f11744d;
                this.f11753e = sVar.f11745e;
                this.f11754f.clear();
                this.f11754f.addAll(sVar.d());
                if (b2 == c2 || str.charAt(b2) == '#') {
                    a(sVar.e());
                }
            } else {
                int i3 = b2 + f2;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a2 = h.e0.c.a(str, i3, c2, "@/\\?#");
                    char charAt = a2 != c2 ? str.charAt(a2) : (char) 65535;
                    if (charAt == 65535 || charAt == c4 || charAt == '/' || charAt == '\\' || charAt == c3) {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z) {
                            int a3 = h.e0.c.a(str, i3, a2, ':');
                            i2 = a2;
                            String a4 = s.a(str, i3, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                a4 = this.f11750b + "%40" + a4;
                            }
                            this.f11750b = a4;
                            if (a3 != i2) {
                                this.f11751c = s.a(str, a3 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i2 = a2;
                            this.f11751c += "%40" + s.a(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i3 = i2 + 1;
                    }
                    c3 = '?';
                    c4 = '#';
                }
                int d2 = d(str, i3, a2);
                int i4 = d2 + 1;
                if (i4 < a2) {
                    this.f11752d = b(str, i3, d2);
                    int c5 = c(str, i4, a2);
                    this.f11753e = c5;
                    if (c5 == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i4, a2) + '\"');
                    }
                } else {
                    this.f11752d = b(str, i3, d2);
                    this.f11753e = s.c(this.f11749a);
                }
                if (this.f11752d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i3, d2) + '\"');
                }
                b2 = a2;
            }
            int a5 = h.e0.c.a(str, b2, c2, "?#");
            a(str, b2, a5);
            if (a5 < c2 && str.charAt(a5) == '?') {
                int a6 = h.e0.c.a(str, a5, c2, '#');
                this.f11755g = s.e(s.a(str, a5 + 1, a6, " \"'<>#", true, false, true, true, null));
                a5 = a6;
            }
            if (a5 < c2 && str.charAt(a5) == '#') {
                this.f11756h = s.a(str, 1 + a5, c2, "", true, false, false, false, null);
            }
            return this;
        }

        public final boolean d(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public static int d(String str, int i2, int i3) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt == ':') {
                    return i2;
                }
                if (charAt == '[') {
                    do {
                        i2++;
                        if (i2 < i3) {
                        }
                    } while (str.charAt(i2) != ']');
                }
                i2++;
            }
            return i3;
        }

        public final void a(String str, int i2, int i3) {
            if (i2 == i3) {
                return;
            }
            char charAt = str.charAt(i2);
            if (charAt != '/' && charAt != '\\') {
                List<String> list = this.f11754f;
                list.set(list.size() - 1, "");
            } else {
                this.f11754f.clear();
                this.f11754f.add("");
                i2++;
            }
            while (true) {
                int i4 = i2;
                if (i4 >= i3) {
                    return;
                }
                i2 = h.e0.c.a(str, i4, i3, "/\\");
                boolean z = i2 < i3;
                a(str, i4, i2, z, true);
                if (z) {
                    i2++;
                }
            }
        }

        public final void a(String str, int i2, int i3, boolean z, boolean z2) {
            String a2 = s.a(str, i2, i3, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (c(a2)) {
                return;
            }
            if (d(a2)) {
                c();
                return;
            }
            if (this.f11754f.get(r11.size() - 1).isEmpty()) {
                this.f11754f.set(r11.size() - 1, a2);
            } else {
                this.f11754f.add(a2);
            }
            if (z) {
                this.f11754f.add("");
            }
        }
    }

    public s(a aVar) {
        this.f11741a = aVar.f11749a;
        this.f11742b = a(aVar.f11750b, false);
        this.f11743c = a(aVar.f11751c, false);
        this.f11744d = aVar.f11752d;
        this.f11745e = aVar.b();
        a(aVar.f11754f, false);
        List<String> list = aVar.f11755g;
        this.f11746f = list != null ? a(list, true) : null;
        String str = aVar.f11756h;
        this.f11747g = str != null ? a(str, false) : null;
        this.f11748h = aVar.toString();
    }

    public static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static int c(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public String b() {
        if (this.f11743c.isEmpty()) {
            return "";
        }
        return this.f11748h.substring(this.f11748h.indexOf(58, this.f11741a.length() + 3) + 1, this.f11748h.indexOf(64));
    }

    public List<String> d() {
        int indexOf = this.f11748h.indexOf(47, this.f11741a.length() + 3);
        String str = this.f11748h;
        int a2 = h.e0.c.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i2 = indexOf + 1;
            int a3 = h.e0.c.a(this.f11748h, i2, a2, '/');
            arrayList.add(this.f11748h.substring(i2, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    @Nullable
    public String e() {
        if (this.f11746f == null) {
            return null;
        }
        int indexOf = this.f11748h.indexOf(63) + 1;
        String str = this.f11748h;
        return this.f11748h.substring(indexOf, h.e0.c.a(str, indexOf, str.length(), '#'));
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof s) && ((s) obj).f11748h.equals(this.f11748h);
    }

    public String f() {
        if (this.f11742b.isEmpty()) {
            return "";
        }
        int length = this.f11741a.length() + 3;
        String str = this.f11748h;
        return this.f11748h.substring(length, h.e0.c.a(str, length, str.length(), ":@"));
    }

    public String g() {
        return this.f11744d;
    }

    public boolean h() {
        return this.f11741a.equals("https");
    }

    public int hashCode() {
        return this.f11748h.hashCode();
    }

    public a i() {
        a aVar = new a();
        aVar.f11749a = this.f11741a;
        aVar.f11750b = f();
        aVar.f11751c = b();
        aVar.f11752d = this.f11744d;
        aVar.f11753e = this.f11745e != c(this.f11741a) ? this.f11745e : -1;
        aVar.f11754f.clear();
        aVar.f11754f.addAll(d());
        aVar.a(e());
        aVar.f11756h = a();
        return aVar;
    }

    public int j() {
        return this.f11745e;
    }

    @Nullable
    public String k() {
        if (this.f11746f == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        a(sb, this.f11746f);
        return sb.toString();
    }

    public String l() {
        a a2 = a("/...");
        a2.g("");
        a2.e("");
        return a2.a().toString();
    }

    public String m() {
        return this.f11741a;
    }

    public URI n() {
        a i2 = i();
        i2.d();
        String aVar = i2.toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public String toString() {
        return this.f11748h;
    }

    public String c() {
        int indexOf = this.f11748h.indexOf(47, this.f11741a.length() + 3);
        String str = this.f11748h;
        return this.f11748h.substring(indexOf, h.e0.c.a(str, indexOf, str.length(), "?#"));
    }

    public static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    public static List<String> e(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 != -1 && indexOf2 <= indexOf) {
                arrayList.add(str.substring(i2, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            } else {
                arrayList.add(str.substring(i2, indexOf));
                arrayList.add(null);
            }
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    public static s d(String str) {
        a aVar = new a();
        aVar.a(null, str);
        return aVar.a();
    }

    @Nullable
    public String a() {
        if (this.f11747g == null) {
            return null;
        }
        return this.f11748h.substring(this.f11748h.indexOf(35) + 1);
    }

    @Nullable
    public s b(String str) {
        a a2 = a(str);
        if (a2 != null) {
            return a2.a();
        }
        return null;
    }

    @Nullable
    public a a(String str) {
        try {
            a aVar = new a();
            aVar.a(this, str);
            return aVar;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    public final List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static String a(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                i.c cVar = new i.c();
                cVar.a(str, i2, i4);
                a(cVar, str, i4, i3, z);
                return cVar.e();
            }
        }
        return str.substring(i2, i3);
    }

    public static void a(i.c cVar, String str, int i2, int i3, boolean z) {
        int i4;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                int a2 = h.e0.c.a(str.charAt(i2 + 1));
                int a3 = h.e0.c.a(str.charAt(i4));
                if (a2 != -1 && a3 != -1) {
                    cVar.writeByte((a2 << 4) + a3);
                    i2 = i4;
                }
                cVar.c(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    cVar.writeByte(32);
                }
                cVar.c(codePointAt);
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static boolean a(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && h.e0.c.a(str.charAt(i2 + 1)) != -1 && h.e0.c.a(str.charAt(i4)) != -1;
    }

    public static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int i4 = i2;
        while (i4 < i3) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || a(str, i4, i3)))) && (codePointAt != 43 || !z3))) {
                    i4 += Character.charCount(codePointAt);
                }
            }
            i.c cVar = new i.c();
            cVar.a(str, i2, i4);
            a(cVar, str, i4, i3, str2, z, z2, z3, z4, charset);
            return cVar.e();
        }
        return str.substring(i2, i3);
    }

    public static void a(i.c cVar, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        i.c cVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    cVar.a(z ? "+" : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || a(str, i2, i3)))))) {
                    cVar.c(codePointAt);
                } else {
                    if (cVar2 == null) {
                        cVar2 = new i.c();
                    }
                    if (charset != null && !charset.equals(h.e0.c.j)) {
                        cVar2.a(str, i2, Character.charCount(codePointAt) + i2, charset);
                    } else {
                        cVar2.c(codePointAt);
                    }
                    while (!cVar2.k()) {
                        int readByte = cVar2.readByte() & ThreadUtils.TYPE_SINGLE;
                        cVar.writeByte(37);
                        cVar.writeByte((int) f11740i[(readByte >> 4) & 15]);
                        cVar.writeByte((int) f11740i[readByte & 15]);
                    }
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}
