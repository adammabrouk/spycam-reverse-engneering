package cn.jiguang.ax;

import android.text.TextUtils;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* loaded from: classes.dex */
public class g implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public String f8423a;

    /* renamed from: b, reason: collision with root package name */
    public int f8424b;

    /* renamed from: c, reason: collision with root package name */
    public transient InetAddress f8425c;

    public g(String str, int i2) {
        this.f8423a = str;
        this.f8424b = i2;
    }

    public g(InetAddress inetAddress, int i2) {
        this.f8423a = inetAddress.getHostAddress();
        this.f8424b = i2;
        this.f8425c = inetAddress;
    }

    public static g a(String str) {
        int lastIndexOf;
        String substring;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(":")) < 0) {
            return null;
        }
        try {
            int intValue = Integer.decode(str.substring(lastIndexOf + 1)).intValue();
            if (lastIndexOf == 0) {
                substring = "";
            } else {
                int i2 = str.startsWith("[") ? 1 : 0;
                if (str.charAt(lastIndexOf - 1) == ']') {
                    lastIndexOf--;
                }
                substring = str.substring(i2, lastIndexOf);
            }
            return new g(substring, intValue);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(LinkedHashSet<g> linkedHashSet) {
        if (linkedHashSet == null || linkedHashSet.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<g> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static LinkedHashSet<g> a(LinkedHashMap<String, Integer> linkedHashMap) {
        LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            g gVar = new g(entry.getKey(), entry.getValue().intValue());
            if (gVar.a()) {
                linkedHashSet.add(gVar);
            }
        }
        return linkedHashSet;
    }

    public static boolean a(String str, int i2) {
        return !TextUtils.isEmpty(str) && i2 > 0 && i2 <= 65535;
    }

    public static LinkedHashSet<g> b(String str) {
        LinkedHashSet<g> linkedHashSet = new LinkedHashSet<>();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(",")) {
                g a2 = a(str2);
                if (a2 != null && a2.a()) {
                    linkedHashSet.add(a2);
                }
            }
        }
        return linkedHashSet;
    }

    public boolean a() {
        int i2;
        return !TextUtils.isEmpty(this.f8423a) && (i2 = this.f8424b) > 0 && i2 <= 65535;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f8424b == gVar.f8424b) {
            String str = this.f8423a;
            String str2 = gVar.f8423a;
            if (str != null) {
                if (str.equals(str2)) {
                    return true;
                }
            } else if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f8423a;
        return ((str != null ? str.hashCode() : 0) * 31) + this.f8424b;
    }

    public String toString() {
        StringBuilder sb;
        String str = ":";
        if (this.f8423a.contains(":")) {
            sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f8423a);
            str = "]:";
        } else {
            sb = new StringBuilder();
            sb.append(this.f8423a);
        }
        sb.append(str);
        sb.append(this.f8424b);
        return sb.toString();
    }
}
