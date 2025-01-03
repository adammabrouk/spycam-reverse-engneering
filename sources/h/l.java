package h;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* compiled from: Cookie.java */
/* loaded from: classes.dex */
public final class l {
    public static final Pattern j = Pattern.compile("(\\d{2,4})[^\\d]*");
    public static final Pattern k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern l = Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final Pattern m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: collision with root package name */
    public final String f11714a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11715b;

    /* renamed from: c, reason: collision with root package name */
    public final long f11716c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11717d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11718e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f11719f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f11720g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f11721h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f11722i;

    public l(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f11714a = str;
        this.f11715b = str2;
        this.f11716c = j2;
        this.f11717d = str3;
        this.f11718e = str4;
        this.f11719f = z;
        this.f11720g = z2;
        this.f11722i = z3;
        this.f11721h = z4;
    }

    public String a() {
        return this.f11714a;
    }

    public String b() {
        return this.f11715b;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return lVar.f11714a.equals(this.f11714a) && lVar.f11715b.equals(this.f11715b) && lVar.f11717d.equals(this.f11717d) && lVar.f11718e.equals(this.f11718e) && lVar.f11716c == this.f11716c && lVar.f11719f == this.f11719f && lVar.f11720g == this.f11720g && lVar.f11721h == this.f11721h && lVar.f11722i == this.f11722i;
    }

    public int hashCode() {
        int hashCode = (((((((527 + this.f11714a.hashCode()) * 31) + this.f11715b.hashCode()) * 31) + this.f11717d.hashCode()) * 31) + this.f11718e.hashCode()) * 31;
        long j2 = this.f11716c;
        return ((((((((hashCode + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (!this.f11719f ? 1 : 0)) * 31) + (!this.f11720g ? 1 : 0)) * 31) + (!this.f11721h ? 1 : 0)) * 31) + (!this.f11722i ? 1 : 0);
    }

    public String toString() {
        return a(false);
    }

    public static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !h.e0.c.d(str);
    }

    public static long b(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e2) {
            if (!str.matches("-?\\d+")) {
                throw e2;
            }
            if (str.startsWith("-")) {
                return Long.MIN_VALUE;
            }
            return RecyclerView.FOREVER_NS;
        }
    }

    @Nullable
    public static l a(s sVar, String str) {
        return a(System.currentTimeMillis(), sVar, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f0  */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static h.l a(long r23, h.s r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h.l.a(long, h.s, java.lang.String):h.l");
    }

    public static long a(String str, int i2, int i3) {
        int a2 = a(str, i2, i3, false);
        Matcher matcher = m.matcher(str);
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        while (a2 < i3) {
            int a3 = a(str, a2 + 1, i3, true);
            matcher.region(a2, a3);
            if (i5 == -1 && matcher.usePattern(m).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
                i8 = Integer.parseInt(matcher.group(2));
                i9 = Integer.parseInt(matcher.group(3));
            } else if (i6 == -1 && matcher.usePattern(l).matches()) {
                i6 = Integer.parseInt(matcher.group(1));
            } else if (i7 == -1 && matcher.usePattern(k).matches()) {
                i7 = k.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
            } else if (i4 == -1 && matcher.usePattern(j).matches()) {
                i4 = Integer.parseInt(matcher.group(1));
            }
            a2 = a(str, a3 + 1, i3, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += RecyclerView.MAX_SCROLL_DURATION;
        }
        if (i4 < 1601) {
            throw new IllegalArgumentException();
        }
        if (i7 == -1) {
            throw new IllegalArgumentException();
        }
        if (i6 < 1 || i6 > 31) {
            throw new IllegalArgumentException();
        }
        if (i5 < 0 || i5 > 23) {
            throw new IllegalArgumentException();
        }
        if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        }
        if (i9 >= 0 && i9 <= 59) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(h.e0.c.o);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i4);
            gregorianCalendar.set(2, i7 - 1);
            gregorianCalendar.set(5, i6);
            gregorianCalendar.set(11, i5);
            gregorianCalendar.set(12, i8);
            gregorianCalendar.set(13, i9);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
        throw new IllegalArgumentException();
    }

    public static int a(String str, int i2, int i3, boolean z) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static String a(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String a2 = h.e0.c.a(str);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public static List<l> a(s sVar, r rVar) {
        List<String> b2 = rVar.b("Set-Cookie");
        int size = b2.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            l a2 = a(sVar, b2.get(i2));
            if (a2 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a2);
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f11714a);
        sb.append('=');
        sb.append(this.f11715b);
        if (this.f11721h) {
            if (this.f11716c == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(h.e0.g.d.a(new Date(this.f11716c)));
            }
        }
        if (!this.f11722i) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f11717d);
        }
        sb.append("; path=");
        sb.append(this.f11718e);
        if (this.f11719f) {
            sb.append("; secure");
        }
        if (this.f11720g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
}
