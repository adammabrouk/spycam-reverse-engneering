package c.a.a.l.j;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

/* compiled from: StringLoader.java */
/* loaded from: classes.dex */
public class p<T> implements l<String, T> {

    /* renamed from: a, reason: collision with root package name */
    public final l<Uri, T> f3215a;

    public p(l<Uri, T> lVar) {
        this.f3215a = lVar;
    }

    @Override // c.a.a.l.j.l
    public c.a.a.l.h.c<T> a(String str, int i2, int i3) {
        Uri a2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("/")) {
            a2 = a(str);
        } else {
            Uri parse = Uri.parse(str);
            a2 = parse.getScheme() == null ? a(str) : parse;
        }
        return this.f3215a.a(a2, i2, i3);
    }

    public static Uri a(String str) {
        return Uri.fromFile(new File(str));
    }
}
