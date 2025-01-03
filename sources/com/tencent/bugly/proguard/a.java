package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    public static Proxy f11032e;

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, HashMap<String, byte[]>> f11033a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public String f11034b;

    /* renamed from: c, reason: collision with root package name */
    public i f11035c;

    /* renamed from: d, reason: collision with root package name */
    public HashMap<String, Object> f11036d;

    public a() {
        new HashMap();
        this.f11036d = new HashMap<>();
        this.f11034b = "GBK";
        this.f11035c = new i();
    }

    public static void a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            f11032e = null;
        } else {
            f11032e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i2));
        }
    }

    public static Proxy b() {
        return f11032e;
    }

    public static an b(byte[] bArr) {
        if (bArr != null) {
            try {
                d dVar = new d();
                dVar.c();
                dVar.a("utf-8");
                dVar.a(bArr);
                Object b2 = dVar.b("detail", new an());
                if (an.class.isInstance(b2)) {
                    return (an) an.class.cast(b2);
                }
                return null;
            } catch (Throwable th) {
                if (!x.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void a(InetAddress inetAddress, int i2) {
        if (inetAddress == null) {
            f11032e = null;
        } else {
            f11032e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i2));
        }
    }

    public void a(String str) {
        this.f11034b = str;
    }

    public static aq a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        aq aqVar = new aq();
        aqVar.f11101a = userInfoBean.f10837e;
        aqVar.f11105e = userInfoBean.j;
        aqVar.f11104d = userInfoBean.f10835c;
        aqVar.f11103c = userInfoBean.f10836d;
        aqVar.f11107g = userInfoBean.o == 1;
        int i2 = userInfoBean.f10834b;
        if (i2 == 1) {
            aqVar.f11102b = (byte) 1;
        } else if (i2 == 2) {
            aqVar.f11102b = (byte) 4;
        } else if (i2 == 3) {
            aqVar.f11102b = (byte) 2;
        } else if (i2 != 4) {
            if (i2 < 10 || i2 >= 20) {
                x.e("unknown uinfo type %d ", Integer.valueOf(userInfoBean.f10834b));
                return null;
            }
            aqVar.f11102b = (byte) i2;
        } else {
            aqVar.f11102b = (byte) 3;
        }
        HashMap hashMap = new HashMap();
        aqVar.f11106f = hashMap;
        if (userInfoBean.p >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(userInfoBean.p);
            hashMap.put("C01", sb.toString());
        }
        if (userInfoBean.q >= 0) {
            Map<String, String> map = aqVar.f11106f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(userInfoBean.q);
            map.put("C02", sb2.toString());
        }
        Map<String, String> map2 = userInfoBean.r;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.r.entrySet()) {
                aqVar.f11106f.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map3 = userInfoBean.s;
        if (map3 != null && map3.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.s.entrySet()) {
                aqVar.f11106f.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map4 = aqVar.f11106f;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(!userInfoBean.l);
        map4.put("A36", sb3.toString());
        Map<String, String> map5 = aqVar.f11106f;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(userInfoBean.f10839g);
        map5.put("F02", sb4.toString());
        Map<String, String> map6 = aqVar.f11106f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(userInfoBean.f10840h);
        map6.put("F03", sb5.toString());
        aqVar.f11106f.put("F04", userInfoBean.j);
        Map<String, String> map7 = aqVar.f11106f;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(userInfoBean.f10841i);
        map7.put("F05", sb6.toString());
        aqVar.f11106f.put("F06", userInfoBean.m);
        Map<String, String> map8 = aqVar.f11106f;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(userInfoBean.k);
        map8.put("F10", sb7.toString());
        x.c("summary type %d vm:%d", Byte.valueOf(aqVar.f11102b), Integer.valueOf(aqVar.f11106f.size()));
        return aqVar;
    }

    public static String a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (true) {
            String str = "map";
            if (i2 < arrayList.size()) {
                String str2 = arrayList.get(i2);
                if (str2.equals("java.lang.Integer") || str2.equals("int")) {
                    str = "int32";
                } else if (str2.equals("java.lang.Boolean") || str2.equals("boolean")) {
                    str = "bool";
                } else if (str2.equals("java.lang.Byte") || str2.equals("byte")) {
                    str = "char";
                } else if (str2.equals("java.lang.Double") || str2.equals("double")) {
                    str = "double";
                } else if (str2.equals("java.lang.Float") || str2.equals("float")) {
                    str = "float";
                } else if (str2.equals("java.lang.Long") || str2.equals("long")) {
                    str = "int64";
                } else if (str2.equals("java.lang.Short") || str2.equals("short")) {
                    str = "short";
                } else {
                    if (str2.equals("java.lang.Character")) {
                        throw new IllegalArgumentException("can not support java.lang.Character");
                    }
                    if (str2.equals("java.lang.String")) {
                        str = "string";
                    } else if (str2.equals("java.util.List")) {
                        str = "list";
                    } else if (!str2.equals("java.util.Map")) {
                        str = str2;
                    }
                }
                arrayList.set(i2, str);
                i2++;
            } else {
                Collections.reverse(arrayList);
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    String str3 = arrayList.get(i3);
                    if (str3.equals("list")) {
                        int i4 = i3 - 1;
                        arrayList.set(i4, "<" + arrayList.get(i4));
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str3.equals("map")) {
                        int i5 = i3 - 1;
                        arrayList.set(i5, "<" + arrayList.get(i5) + ",");
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str3.equals("Array")) {
                        int i6 = i3 - 1;
                        arrayList.set(i6, "<" + arrayList.get(i6));
                        arrayList.set(0, arrayList.get(0) + ">");
                    }
                }
                Collections.reverse(arrayList);
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next());
                }
                return stringBuffer.toString();
            }
        }
    }

    public <T> void a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t != null) {
            if (!(t instanceof Set)) {
                j jVar = new j();
                jVar.a(this.f11034b);
                jVar.a(t, 0);
                byte[] a2 = l.a(jVar.a());
                HashMap<String, byte[]> hashMap = new HashMap<>(1);
                ArrayList<String> arrayList = new ArrayList<>(1);
                a(arrayList, t);
                hashMap.put(a(arrayList), a2);
                this.f11036d.remove(str);
                this.f11033a.put(str, hashMap);
                return;
            }
            throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
    }

    public static ar a(List<UserInfoBean> list, int i2) {
        com.tencent.bugly.crashreport.common.info.a b2;
        if (list == null || list.size() == 0 || (b2 = com.tencent.bugly.crashreport.common.info.a.b()) == null) {
            return null;
        }
        b2.p();
        ar arVar = new ar();
        arVar.f11112b = b2.f10873d;
        arVar.f11113c = b2.h();
        ArrayList<aq> arrayList = new ArrayList<>();
        Iterator<UserInfoBean> it = list.iterator();
        while (it.hasNext()) {
            aq a2 = a(it.next());
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        arVar.f11114d = arrayList;
        HashMap hashMap = new HashMap();
        arVar.f11115e = hashMap;
        hashMap.put("A7", b2.f10876g);
        arVar.f11115e.put("A6", b2.o());
        arVar.f11115e.put("A5", b2.n());
        Map<String, String> map = arVar.f11115e;
        StringBuilder sb = new StringBuilder();
        sb.append(b2.l());
        map.put("A2", sb.toString());
        Map<String, String> map2 = arVar.f11115e;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(b2.l());
        map2.put("A1", sb2.toString());
        arVar.f11115e.put("A24", b2.f10877h);
        Map<String, String> map3 = arVar.f11115e;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(b2.m());
        map3.put("A17", sb3.toString());
        arVar.f11115e.put("A15", b2.r());
        Map<String, String> map4 = arVar.f11115e;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(b2.s());
        map4.put("A13", sb4.toString());
        arVar.f11115e.put("F08", b2.v);
        arVar.f11115e.put("F09", b2.w);
        Map<String, String> z = b2.z();
        if (z != null && z.size() > 0) {
            for (Map.Entry<String, String> entry : z.entrySet()) {
                arVar.f11115e.put("C04_" + entry.getKey(), entry.getValue());
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                x.e("unknown up type %d ", Integer.valueOf(i2));
                return null;
            }
            arVar.f11111a = (byte) 2;
        } else {
            arVar.f11111a = (byte) 1;
        }
        return arVar;
    }

    public static <T extends k> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                i iVar = new i(bArr);
                iVar.a("utf-8");
                newInstance.a(iVar);
                return newInstance;
            } catch (Throwable th) {
                if (!x.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static am a(Context context, int i2, byte[] bArr) {
        com.tencent.bugly.crashreport.common.info.a b2 = com.tencent.bugly.crashreport.common.info.a.b();
        StrategyBean c2 = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (b2 != null && c2 != null) {
            try {
                am amVar = new am();
                synchronized (b2) {
                    amVar.f11071a = 1;
                    amVar.f11072b = b2.f();
                    amVar.f11073c = b2.f10872c;
                    amVar.f11074d = b2.j;
                    amVar.f11075e = b2.l;
                    amVar.f11076f = b2.f10875f;
                    amVar.f11077g = i2;
                    if (bArr == null) {
                        bArr = "".getBytes();
                    }
                    amVar.f11078h = bArr;
                    amVar.f11079i = b2.i();
                    amVar.j = b2.f10877h;
                    amVar.k = new HashMap();
                    amVar.l = b2.e();
                    amVar.m = c2.n;
                    amVar.o = b2.h();
                    amVar.p = com.tencent.bugly.crashreport.common.info.b.b(context);
                    amVar.q = System.currentTimeMillis();
                    amVar.r = b2.j();
                    amVar.s = b2.h();
                    amVar.t = amVar.p;
                    b2.getClass();
                    amVar.n = "com.tencent.bugly";
                    amVar.k.put("A26", b2.t());
                    Map<String, String> map = amVar.k;
                    StringBuilder sb = new StringBuilder();
                    sb.append(b2.E());
                    map.put("A62", sb.toString());
                    Map<String, String> map2 = amVar.k;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(b2.F());
                    map2.put("A63", sb2.toString());
                    Map<String, String> map3 = amVar.k;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(b2.A);
                    map3.put("F11", sb3.toString());
                    Map<String, String> map4 = amVar.k;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(b2.z);
                    map4.put("F12", sb4.toString());
                    amVar.k.put("D3", b2.k);
                    if (com.tencent.bugly.b.f10826b != null) {
                        for (com.tencent.bugly.a aVar : com.tencent.bugly.b.f10826b) {
                            if (aVar.versionKey != null && aVar.version != null) {
                                amVar.k.put(aVar.versionKey, aVar.version);
                            }
                        }
                    }
                    amVar.k.put("G15", z.c("G15", ""));
                    amVar.k.put("G10", z.c("G10", ""));
                    amVar.k.put("D4", z.c("D4", "0"));
                }
                Map<String, String> y = b2.y();
                if (y != null) {
                    for (Map.Entry<String, String> entry : y.entrySet()) {
                        amVar.k.put(entry.getKey(), entry.getValue());
                    }
                }
                return amVar;
            } catch (Throwable th) {
                if (!x.b(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        x.e("Can not create request pkg for parameters is invalid.", new Object[0]);
        return null;
    }

    private void a(ArrayList<String> arrayList, Object obj) {
        if (obj.getClass().isArray()) {
            if (obj.getClass().getComponentType().toString().equals("byte")) {
                if (Array.getLength(obj) > 0) {
                    arrayList.add("java.util.List");
                    a(arrayList, Array.get(obj, 0));
                    return;
                } else {
                    arrayList.add("Array");
                    arrayList.add("?");
                    return;
                }
            }
            throw new IllegalArgumentException("only byte[] is supported");
        }
        if (!(obj instanceof Array)) {
            if (obj instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj;
                if (list.size() > 0) {
                    a(arrayList, list.get(0));
                    return;
                } else {
                    arrayList.add("?");
                    return;
                }
            }
            if (obj instanceof Map) {
                arrayList.add("java.util.Map");
                Map map = (Map) obj;
                if (map.size() > 0) {
                    Object next = map.keySet().iterator().next();
                    Object obj2 = map.get(next);
                    arrayList.add(next.getClass().getName());
                    a(arrayList, obj2);
                    return;
                }
                arrayList.add("?");
                arrayList.add("?");
                return;
            }
            arrayList.add(obj.getClass().getName());
            return;
        }
        throw new IllegalArgumentException("can not support Array, please use List");
    }

    public byte[] a() {
        j jVar = new j(0);
        jVar.a(this.f11034b);
        jVar.a((Map) this.f11033a, 0);
        return l.a(jVar.a());
    }

    public static byte[] a(Object obj) {
        try {
            d dVar = new d();
            dVar.c();
            dVar.a("utf-8");
            dVar.a(1);
            dVar.b("RqdServer");
            dVar.c("sync");
            dVar.a("detail", (String) obj);
            return dVar.a();
        } catch (Throwable th) {
            if (x.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public void a(byte[] bArr) {
        this.f11035c.a(bArr);
        this.f11035c.a(this.f11034b);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f11033a = this.f11035c.a((Map) hashMap, 0, false);
    }

    public static byte[] a(k kVar) {
        try {
            j jVar = new j();
            jVar.a("utf-8");
            kVar.a(jVar);
            return jVar.b();
        } catch (Throwable th) {
            if (x.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
