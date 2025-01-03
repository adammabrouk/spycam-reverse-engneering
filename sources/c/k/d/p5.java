package c.k.d;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class p5 extends r5 {
    public a o;
    public final Map<String, String> p;

    public static class a {

        /* renamed from: b, reason: collision with root package name */
        public static final a f7499b = new a("get");

        /* renamed from: c, reason: collision with root package name */
        public static final a f7500c = new a("set");

        /* renamed from: d, reason: collision with root package name */
        public static final a f7501d = new a("result");

        /* renamed from: e, reason: collision with root package name */
        public static final a f7502e = new a("error");

        /* renamed from: f, reason: collision with root package name */
        public static final a f7503f = new a("command");

        /* renamed from: a, reason: collision with root package name */
        public String f7504a;

        public a(String str) {
            this.f7504a = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            if (f7499b.toString().equals(lowerCase)) {
                return f7499b;
            }
            if (f7500c.toString().equals(lowerCase)) {
                return f7500c;
            }
            if (f7502e.toString().equals(lowerCase)) {
                return f7502e;
            }
            if (f7501d.toString().equals(lowerCase)) {
                return f7501d;
            }
            if (f7503f.toString().equals(lowerCase)) {
                return f7503f;
            }
            return null;
        }

        public String toString() {
            return this.f7504a;
        }
    }

    public p5() {
        this.o = a.f7499b;
        this.p = new HashMap();
    }

    public p5(Bundle bundle) {
        super(bundle);
        this.o = a.f7499b;
        this.p = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.o = a.a(bundle.getString("ext_iq_type"));
        }
    }

    @Override // c.k.d.r5
    public Bundle a() {
        Bundle a2 = super.a();
        a aVar = this.o;
        if (aVar != null) {
            a2.putString("ext_iq_type", aVar.toString());
        }
        return a2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public a m335a() {
        return this.o;
    }

    @Override // c.k.d.r5
    /* renamed from: a, reason: collision with other method in class */
    public String mo336a() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (c() != null) {
            sb.append("id=\"" + c() + "\" ");
        }
        if (e() != null) {
            sb.append("to=\"");
            sb.append(c6.a(e()));
            sb.append("\" ");
        }
        if (f() != null) {
            sb.append("from=\"");
            sb.append(c6.a(f()));
            sb.append("\" ");
        }
        if (d() != null) {
            sb.append("chid=\"");
            sb.append(c6.a(d()));
            sb.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.p.entrySet()) {
            sb.append(c6.a(entry.getKey()));
            sb.append("=\"");
            sb.append(c6.a(entry.getValue()));
            sb.append("\" ");
        }
        if (this.o == null) {
            str = "type=\"get\">";
        } else {
            sb.append("type=\"");
            sb.append(m335a());
            str = "\">";
        }
        sb.append(str);
        String b2 = b();
        if (b2 != null) {
            sb.append(b2);
        }
        sb.append(h());
        v5 m447a = m447a();
        if (m447a != null) {
            sb.append(m447a.m502a());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    public void a(a aVar) {
        if (aVar == null) {
            aVar = a.f7499b;
        }
        this.o = aVar;
    }

    public synchronized void a(Map<String, String> map) {
        this.p.putAll(map);
    }

    public String b() {
        return null;
    }
}
