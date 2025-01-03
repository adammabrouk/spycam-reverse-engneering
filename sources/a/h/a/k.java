package a.h.a;

import android.app.Person;
import androidx.core.graphics.drawable.IconCompat;

/* compiled from: Person.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f941a;

    /* renamed from: b, reason: collision with root package name */
    public IconCompat f942b;

    /* renamed from: c, reason: collision with root package name */
    public String f943c;

    /* renamed from: d, reason: collision with root package name */
    public String f944d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f945e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f946f;

    public IconCompat a() {
        return this.f942b;
    }

    public String b() {
        return this.f944d;
    }

    public CharSequence c() {
        return this.f941a;
    }

    public String d() {
        return this.f943c;
    }

    public boolean e() {
        return this.f945e;
    }

    public boolean f() {
        return this.f946f;
    }

    public String g() {
        String str = this.f943c;
        if (str != null) {
            return str;
        }
        if (this.f941a == null) {
            return "";
        }
        return "name:" + ((Object) this.f941a);
    }

    public Person h() {
        return new Person.Builder().setName(c()).setIcon(a() != null ? a().g() : null).setUri(d()).setKey(b()).setBot(e()).setImportant(f()).build();
    }
}
