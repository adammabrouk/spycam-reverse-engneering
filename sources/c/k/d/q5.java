package c.k.d;

import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class q5 extends r5 {
    public boolean A;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public boolean u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public q5() {
        this.o = null;
        this.p = null;
        this.u = false;
        this.w = "";
        this.x = "";
        this.y = "";
        this.z = "";
        this.A = false;
    }

    public q5(Bundle bundle) {
        super(bundle);
        this.o = null;
        this.p = null;
        this.u = false;
        this.w = "";
        this.x = "";
        this.y = "";
        this.z = "";
        this.A = false;
        this.o = bundle.getString("ext_msg_type");
        this.q = bundle.getString("ext_msg_lang");
        this.p = bundle.getString("ext_msg_thread");
        this.r = bundle.getString("ext_msg_sub");
        this.s = bundle.getString("ext_msg_body");
        this.t = bundle.getString("ext_body_encode");
        this.v = bundle.getString("ext_msg_appid");
        this.u = bundle.getBoolean("ext_msg_trans", false);
        this.A = bundle.getBoolean("ext_msg_encrypt", false);
        this.w = bundle.getString("ext_msg_seq");
        this.x = bundle.getString("ext_msg_mseq");
        this.y = bundle.getString("ext_msg_fseq");
        this.z = bundle.getString("ext_msg_status");
    }

    @Override // c.k.d.r5
    public Bundle a() {
        Bundle a2 = super.a();
        if (!TextUtils.isEmpty(this.o)) {
            a2.putString("ext_msg_type", this.o);
        }
        String str = this.q;
        if (str != null) {
            a2.putString("ext_msg_lang", str);
        }
        String str2 = this.r;
        if (str2 != null) {
            a2.putString("ext_msg_sub", str2);
        }
        String str3 = this.s;
        if (str3 != null) {
            a2.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.t)) {
            a2.putString("ext_body_encode", this.t);
        }
        String str4 = this.p;
        if (str4 != null) {
            a2.putString("ext_msg_thread", str4);
        }
        String str5 = this.v;
        if (str5 != null) {
            a2.putString("ext_msg_appid", str5);
        }
        if (this.u) {
            a2.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.w)) {
            a2.putString("ext_msg_seq", this.w);
        }
        if (!TextUtils.isEmpty(this.x)) {
            a2.putString("ext_msg_mseq", this.x);
        }
        if (!TextUtils.isEmpty(this.y)) {
            a2.putString("ext_msg_fseq", this.y);
        }
        if (this.A) {
            a2.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.z)) {
            a2.putString("ext_msg_status", this.z);
        }
        return a2;
    }

    @Override // c.k.d.r5
    /* renamed from: a */
    public String mo336a() {
        v5 m447a;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (i() != null) {
            sb.append(" xmlns=\"");
            sb.append(i());
            sb.append("\"");
        }
        if (this.q != null) {
            sb.append(" xml:lang=\"");
            sb.append(q());
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
        if (!TextUtils.isEmpty(m())) {
            sb.append(" seq=\"");
            sb.append(m());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(n())) {
            sb.append(" mseq=\"");
            sb.append(n());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(o())) {
            sb.append(" fseq=\"");
            sb.append(o());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(p())) {
            sb.append(" status=\"");
            sb.append(p());
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
        if (this.u) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.v)) {
            sb.append(" appid=\"");
            sb.append(l());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.o)) {
            sb.append(" type=\"");
            sb.append(this.o);
            sb.append("\"");
        }
        if (this.A) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.r != null) {
            sb.append("<subject>");
            sb.append(c6.a(this.r));
            sb.append("</subject>");
        }
        if (this.s != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.t)) {
                sb.append(" encode=\"");
                sb.append(this.t);
                sb.append("\"");
            }
            sb.append(">");
            sb.append(c6.a(this.s));
            sb.append("</body>");
        }
        if (this.p != null) {
            sb.append("<thread>");
            sb.append(this.p);
            sb.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.o) && (m447a = m447a()) != null) {
            sb.append(m447a.m502a());
        }
        sb.append(h());
        sb.append("</message>");
        return sb.toString();
    }

    public void a(String str) {
        this.v = str;
    }

    public void a(String str, String str2) {
        this.s = str;
        this.t = str2;
    }

    public void a(boolean z) {
        this.u = z;
    }

    public String b() {
        return this.o;
    }

    public void b(boolean z) {
        this.A = z;
    }

    @Override // c.k.d.r5
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q5.class != obj.getClass()) {
            return false;
        }
        q5 q5Var = (q5) obj;
        if (!super.equals(q5Var)) {
            return false;
        }
        String str = this.s;
        if (str == null ? q5Var.s != null : !str.equals(q5Var.s)) {
            return false;
        }
        String str2 = this.q;
        if (str2 == null ? q5Var.q != null : !str2.equals(q5Var.q)) {
            return false;
        }
        String str3 = this.r;
        if (str3 == null ? q5Var.r != null : !str3.equals(q5Var.r)) {
            return false;
        }
        String str4 = this.p;
        if (str4 == null ? q5Var.p == null : str4.equals(q5Var.p)) {
            return this.o == q5Var.o;
        }
        return false;
    }

    public void g(String str) {
        this.w = str;
    }

    public void h(String str) {
        this.x = str;
    }

    @Override // c.k.d.r5
    public int hashCode() {
        String str = this.o;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.s;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.p;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.q;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.r;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public void i(String str) {
        this.y = str;
    }

    public void j(String str) {
        this.z = str;
    }

    public void k(String str) {
        this.o = str;
    }

    public String l() {
        return this.v;
    }

    public void l(String str) {
        this.r = str;
    }

    public String m() {
        return this.w;
    }

    public void m(String str) {
        this.s = str;
    }

    public String n() {
        return this.x;
    }

    public void n(String str) {
        this.p = str;
    }

    public String o() {
        return this.y;
    }

    public void o(String str) {
        this.q = str;
    }

    public String p() {
        return this.z;
    }

    public String q() {
        return this.q;
    }
}
