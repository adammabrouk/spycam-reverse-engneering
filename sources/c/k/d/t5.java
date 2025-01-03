package c.k.d;

import android.os.Bundle;

/* loaded from: classes.dex */
public class t5 extends r5 {
    public b o;
    public String p;
    public int q;
    public a r;

    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public t5(Bundle bundle) {
        super(bundle);
        this.o = b.available;
        this.p = null;
        this.q = Integer.MIN_VALUE;
        this.r = null;
        if (bundle.containsKey("ext_pres_type")) {
            this.o = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.p = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.q = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.r = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public t5(b bVar) {
        this.o = b.available;
        this.p = null;
        this.q = Integer.MIN_VALUE;
        this.r = null;
        a(bVar);
    }

    @Override // c.k.d.r5
    public Bundle a() {
        Bundle a2 = super.a();
        b bVar = this.o;
        if (bVar != null) {
            a2.putString("ext_pres_type", bVar.toString());
        }
        String str = this.p;
        if (str != null) {
            a2.putString("ext_pres_status", str);
        }
        int i2 = this.q;
        if (i2 != Integer.MIN_VALUE) {
            a2.putInt("ext_pres_prio", i2);
        }
        a aVar = this.r;
        if (aVar != null && aVar != a.available) {
            a2.putString("ext_pres_mode", aVar.toString());
        }
        return a2;
    }

    @Override // c.k.d.r5
    /* renamed from: a */
    public String mo336a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<presence");
        if (i() != null) {
            sb.append(" xmlns=\"");
            sb.append(i());
            sb.append("\"");
        }
        if (c() != null) {
            sb.append(" id=\"");
            sb.append(c());
            sb.append("\"");
        }
        if (e() != null) {
            sb.append(" to=\"");
            sb.append(c6.a(e()));
            sb.append("\"");
        }
        if (f() != null) {
            sb.append(" from=\"");
            sb.append(c6.a(f()));
            sb.append("\"");
        }
        if (d() != null) {
            sb.append(" chid=\"");
            sb.append(c6.a(d()));
            sb.append("\"");
        }
        if (this.o != null) {
            sb.append(" type=\"");
            sb.append(this.o);
            sb.append("\"");
        }
        sb.append(">");
        if (this.p != null) {
            sb.append("<status>");
            sb.append(c6.a(this.p));
            sb.append("</status>");
        }
        if (this.q != Integer.MIN_VALUE) {
            sb.append("<priority>");
            sb.append(this.q);
            sb.append("</priority>");
        }
        a aVar = this.r;
        if (aVar != null && aVar != a.available) {
            sb.append("<show>");
            sb.append(this.r);
            sb.append("</show>");
        }
        sb.append(h());
        v5 m447a = m447a();
        if (m447a != null) {
            sb.append(m447a.m502a());
        }
        sb.append("</presence>");
        return sb.toString();
    }

    public void a(int i2) {
        if (i2 >= -128 && i2 <= 128) {
            this.q = i2;
            return;
        }
        throw new IllegalArgumentException("Priority value " + i2 + " is not valid. Valid range is -128 through 128.");
    }

    public void a(a aVar) {
        this.r = aVar;
    }

    public void a(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("Type cannot be null");
        }
        this.o = bVar;
    }

    public void a(String str) {
        this.p = str;
    }
}
