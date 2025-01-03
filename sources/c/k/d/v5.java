package c.k.d;

import android.os.Bundle;
import android.os.Parcelable;
import com.shix.shixipc.utilcode.LogUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class v5 {

    /* renamed from: a, reason: collision with root package name */
    public int f7943a;

    /* renamed from: b, reason: collision with root package name */
    public String f7944b;

    /* renamed from: c, reason: collision with root package name */
    public String f7945c;

    /* renamed from: d, reason: collision with root package name */
    public String f7946d;

    /* renamed from: e, reason: collision with root package name */
    public String f7947e;

    /* renamed from: f, reason: collision with root package name */
    public List<o5> f7948f;

    public static class a {

        /* renamed from: b, reason: collision with root package name */
        public static final a f7949b;

        /* renamed from: a, reason: collision with root package name */
        public String f7950a;

        static {
            new a("internal-server-error");
            new a("forbidden");
            new a("bad-request");
            new a("conflict");
            f7949b = new a("feature-not-implemented");
            new a("gone");
            new a("item-not-found");
            new a("jid-malformed");
            new a("not-acceptable");
            new a("not-allowed");
            new a("not-authorized");
            new a("payment-required");
            new a("recipient-unavailable");
            new a("redirect");
            new a("registration-required");
            new a("remote-server-error");
            new a("remote-server-not-found");
            new a("remote-server-timeout");
            new a("resource-constraint");
            new a("service-unavailable");
            new a("subscription-required");
            new a("undefined-condition");
            new a("unexpected-request");
            new a("request-timeout");
        }

        public a(String str) {
            this.f7950a = str;
        }

        public String toString() {
            return this.f7950a;
        }
    }

    public v5(int i2, String str, String str2, String str3, String str4, List<o5> list) {
        this.f7948f = null;
        this.f7943a = i2;
        this.f7944b = str;
        this.f7946d = str2;
        this.f7945c = str3;
        this.f7947e = str4;
        this.f7948f = list;
    }

    public v5(Bundle bundle) {
        this.f7948f = null;
        this.f7943a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f7944b = bundle.getString("ext_err_type");
        }
        this.f7945c = bundle.getString("ext_err_cond");
        this.f7946d = bundle.getString("ext_err_reason");
        this.f7947e = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f7948f = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                o5 a2 = o5.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f7948f.add(a2);
                }
            }
        }
    }

    public v5(a aVar) {
        this.f7948f = null;
        a(aVar);
        this.f7947e = null;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        String str = this.f7944b;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.f7943a);
        String str2 = this.f7946d;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        String str3 = this.f7945c;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        String str4 = this.f7947e;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        List<o5> list = this.f7948f;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i2 = 0;
            Iterator<o5> it = this.f7948f.iterator();
            while (it.hasNext()) {
                Bundle a2 = it.next().a();
                if (a2 != null) {
                    bundleArr[i2] = a2;
                    i2++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m502a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<error code=\"");
        sb.append(this.f7943a);
        sb.append("\"");
        if (this.f7944b != null) {
            sb.append(" type=\"");
            sb.append(this.f7944b);
            sb.append("\"");
        }
        if (this.f7946d != null) {
            sb.append(" reason=\"");
            sb.append(this.f7946d);
            sb.append("\"");
        }
        sb.append(">");
        if (this.f7945c != null) {
            sb.append("<");
            sb.append(this.f7945c);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.f7947e != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.f7947e);
            sb.append("</text>");
        }
        Iterator<o5> it = m503a().iterator();
        while (it.hasNext()) {
            sb.append(it.next().d());
        }
        sb.append("</error>");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized List<o5> m503a() {
        if (this.f7948f == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(this.f7948f);
    }

    public final void a(a aVar) {
        this.f7945c = aVar.f7950a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f7945c;
        if (str != null) {
            sb.append(str);
        }
        sb.append("(");
        sb.append(this.f7943a);
        sb.append(")");
        if (this.f7947e != null) {
            sb.append(LogUtils.PLACEHOLDER);
            sb.append(this.f7947e);
        }
        return sb.toString();
    }
}
