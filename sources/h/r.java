package h;

import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.Nullable;

/* compiled from: Headers.java */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final String[] f11738a;

    public r(a aVar) {
        List<String> list = aVar.f11739a;
        this.f11738a = (String[]) list.toArray(new String[list.size()]);
    }

    @Nullable
    public String a(String str) {
        return a(this.f11738a, str);
    }

    public int b() {
        return this.f11738a.length / 2;
    }

    public Map<String, List<String>> c() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int b2 = b();
        for (int i2 = 0; i2 < b2; i2++) {
            String lowerCase = a(i2).toLowerCase(Locale.US);
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(b(i2));
        }
        return treeMap;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof r) && Arrays.equals(((r) obj).f11738a, this.f11738a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f11738a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int b2 = b();
        for (int i2 = 0; i2 < b2; i2++) {
            sb.append(a(i2));
            sb.append(": ");
            sb.append(b(i2));
            sb.append(OSSUtils.NEW_LINE);
        }
        return sb.toString();
    }

    /* compiled from: Headers.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final List<String> f11739a = new ArrayList(20);

        public a a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                b(str.substring(0, indexOf), str.substring(indexOf + 1));
                return this;
            }
            if (str.startsWith(":")) {
                b("", str.substring(1));
                return this;
            }
            b("", str);
            return this;
        }

        public a b(String str, String str2) {
            this.f11739a.add(str);
            this.f11739a.add(str2.trim());
            return this;
        }

        public final void c(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= ' ' || charAt >= 127) {
                    throw new IllegalArgumentException(h.e0.c.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                char charAt2 = str2.charAt(i3);
                if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= 127) {
                    throw new IllegalArgumentException(h.e0.c.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i3), str, str2));
                }
            }
        }

        public a d(String str, String str2) {
            c(str, str2);
            b(str);
            b(str, str2);
            return this;
        }

        public a b(String str) {
            int i2 = 0;
            while (i2 < this.f11739a.size()) {
                if (str.equalsIgnoreCase(this.f11739a.get(i2))) {
                    this.f11739a.remove(i2);
                    this.f11739a.remove(i2);
                    i2 -= 2;
                }
                i2 += 2;
            }
            return this;
        }

        public a a(String str, String str2) {
            c(str, str2);
            b(str, str2);
            return this;
        }

        public r a() {
            return new r(this);
        }
    }

    public String a(int i2) {
        return this.f11738a[i2 * 2];
    }

    public String b(int i2) {
        return this.f11738a[(i2 * 2) + 1];
    }

    public a a() {
        a aVar = new a();
        Collections.addAll(aVar.f11739a, this.f11738a);
        return aVar;
    }

    public List<String> b(String str) {
        int b2 = b();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < b2; i2++) {
            if (str.equalsIgnoreCase(a(i2))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i2));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }
}
