package c.a.a.l.j;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/* compiled from: GlideUrl.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final URL f3187a;

    /* renamed from: b, reason: collision with root package name */
    public final e f3188b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3189c;

    /* renamed from: d, reason: collision with root package name */
    public String f3190d;

    /* renamed from: e, reason: collision with root package name */
    public URL f3191e;

    public d(URL url) {
        this(url, e.f3192a);
    }

    public String a() {
        String str = this.f3189c;
        return str != null ? str : this.f3187a.toString();
    }

    public Map<String, String> b() {
        return this.f3188b.a();
    }

    public final String c() {
        if (TextUtils.isEmpty(this.f3190d)) {
            String str = this.f3189c;
            if (TextUtils.isEmpty(str)) {
                str = this.f3187a.toString();
            }
            this.f3190d = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
        }
        return this.f3190d;
    }

    public final URL d() throws MalformedURLException {
        if (this.f3191e == null) {
            this.f3191e = new URL(c());
        }
        return this.f3191e;
    }

    public URL e() throws MalformedURLException {
        return d();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return a().equals(dVar.a()) && this.f3188b.equals(dVar.f3188b);
    }

    public int hashCode() {
        return (a().hashCode() * 31) + this.f3188b.hashCode();
    }

    public String toString() {
        return a() + '\n' + this.f3188b.toString();
    }

    public d(String str) {
        this(str, e.f3192a);
    }

    public d(URL url, e eVar) {
        if (url == null) {
            throw new IllegalArgumentException("URL must not be null!");
        }
        if (eVar != null) {
            this.f3187a = url;
            this.f3189c = null;
            this.f3188b = eVar;
            return;
        }
        throw new IllegalArgumentException("Headers must not be null");
    }

    public d(String str, e eVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("String url must not be empty or null: " + str);
        }
        if (eVar != null) {
            this.f3189c = str;
            this.f3187a = null;
            this.f3188b = eVar;
            return;
        }
        throw new IllegalArgumentException("Headers must not be null");
    }
}
