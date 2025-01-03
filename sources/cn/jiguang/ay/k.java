package cn.jiguang.ay;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class k {

    /* renamed from: d, reason: collision with root package name */
    public static k f8532d;

    /* renamed from: a, reason: collision with root package name */
    public String[] f8533a = null;

    /* renamed from: b, reason: collision with root package name */
    public g[] f8534b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f8535c = -1;

    static {
        c();
    }

    public k() {
        if (d() || e()) {
            return;
        }
        if (this.f8533a == null || this.f8534b == null) {
            if (System.getProperty("java.vendor").indexOf("Android") != -1) {
                g();
            } else {
                f();
            }
        }
    }

    private int a(String str) {
        try {
            int parseInt = Integer.parseInt(str.substring(6));
            if (parseInt >= 0) {
                return parseInt;
            }
            return -1;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private void a(int i2) {
        if (this.f8535c >= 0 || i2 <= 0) {
            return;
        }
        this.f8535c = i2;
    }

    private void a(String str, List list) {
        if (list.contains(str)) {
            return;
        }
        list.add(str);
    }

    private void a(List list, List list2) {
        if (this.f8533a == null && list.size() > 0) {
            this.f8533a = (String[]) list.toArray(new String[0]);
        }
        if (this.f8534b != null || list2.size() <= 0) {
            return;
        }
        this.f8534b = (g[]) list2.toArray(new g[0]);
    }

    public static synchronized k b() {
        k kVar;
        synchronized (k.class) {
            kVar = f8532d;
        }
        return kVar;
    }

    private void b(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            ArrayList arrayList = new ArrayList(0);
            ArrayList arrayList2 = new ArrayList(0);
            int i2 = -1;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.startsWith("nameserver")) {
                        StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                        stringTokenizer.nextToken();
                        a(stringTokenizer.nextToken(), arrayList);
                    } else if (readLine.startsWith("domain")) {
                        StringTokenizer stringTokenizer2 = new StringTokenizer(readLine);
                        stringTokenizer2.nextToken();
                        if (stringTokenizer2.hasMoreTokens() && arrayList2.isEmpty()) {
                            b(stringTokenizer2.nextToken(), arrayList2);
                        }
                    } else if (readLine.startsWith("search")) {
                        if (!arrayList2.isEmpty()) {
                            arrayList2.clear();
                        }
                        StringTokenizer stringTokenizer3 = new StringTokenizer(readLine);
                        stringTokenizer3.nextToken();
                        while (stringTokenizer3.hasMoreTokens()) {
                            b(stringTokenizer3.nextToken(), arrayList2);
                        }
                    } else if (readLine.startsWith("options")) {
                        StringTokenizer stringTokenizer4 = new StringTokenizer(readLine);
                        stringTokenizer4.nextToken();
                        while (stringTokenizer4.hasMoreTokens()) {
                            String nextToken = stringTokenizer4.nextToken();
                            if (nextToken.startsWith("ndots:")) {
                                i2 = a(nextToken);
                            }
                        }
                    }
                } catch (IOException unused) {
                }
            }
            bufferedReader.close();
            a(arrayList, arrayList2);
            a(i2);
        } catch (FileNotFoundException unused2) {
        }
    }

    private void b(String str, List list) {
        try {
            g a2 = g.a(str, g.f8515a);
            if (list.contains(a2)) {
                return;
            }
            list.add(a2);
        } catch (Exception unused) {
        }
    }

    public static void c() {
        k kVar = new k();
        synchronized (k.class) {
            f8532d = kVar;
        }
    }

    private boolean d() {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        String property = System.getProperty("dns.server");
        if (property != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
            while (stringTokenizer.hasMoreTokens()) {
                a(stringTokenizer.nextToken(), arrayList);
            }
        }
        String property2 = System.getProperty("dns.search");
        if (property2 != null) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(property2, ",");
            while (stringTokenizer2.hasMoreTokens()) {
                b(stringTokenizer2.nextToken(), arrayList2);
            }
        }
        a(arrayList, arrayList2);
        return (this.f8533a == null || this.f8534b == null) ? false : true;
    }

    private boolean e() {
        ArrayList arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        try {
            Class<?>[] clsArr = new Class[0];
            Object[] objArr = new Object[0];
            Class<?> cls = Class.forName("sun.net.dns.ResolverConfiguration");
            Object invoke = cls.getDeclaredMethod("open", clsArr).invoke(null, objArr);
            List list = (List) cls.getMethod("nameservers", clsArr).invoke(invoke, objArr);
            List list2 = (List) cls.getMethod("searchlist", clsArr).invoke(invoke, objArr);
            if (list.size() == 0) {
                return false;
            }
            if (list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    a((String) it.next(), arrayList);
                }
            }
            if (list2.size() > 0) {
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    b((String) it2.next(), arrayList2);
                }
            }
            a(arrayList, arrayList2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void f() {
        b("/etc/resolv.conf");
    }

    private void g() {
        ArrayList arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            String[] strArr = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
            for (int i2 = 0; i2 < 4; i2++) {
                String str = (String) method.invoke(null, strArr[i2]);
                if (str != null && ((str.matches("^\\d+(\\.\\d+){3}$") || str.matches("^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$")) && !arrayList.contains(str))) {
                    arrayList.add(str);
                }
            }
        } catch (Exception unused) {
        }
        a(arrayList, arrayList2);
    }

    public String[] a() {
        return this.f8533a;
    }
}
