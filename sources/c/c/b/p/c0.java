package c.c.b.p;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f6120d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: a, reason: collision with root package name */
    public final String f6121a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6122b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6123c;

    public c0(String str, String str2) {
        String str3;
        if (str2 == null || !str2.startsWith("/topics/")) {
            str3 = str2;
        } else {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str));
            str3 = str2.substring(8);
        }
        if (str3 == null || !f6120d.matcher(str3).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", str3, "[a-zA-Z0-9-_.~%]{1,900}"));
        }
        this.f6121a = str3;
        this.f6122b = str;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("!");
        sb.append(str2);
        this.f6123c = sb.toString();
    }

    public static c0 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("!", -1);
        if (split.length != 2) {
            return null;
        }
        return new c0(split[0], split[1]);
    }

    public final String b() {
        return this.f6122b;
    }

    public final String c() {
        return this.f6123c;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f6121a.equals(c0Var.f6121a) && this.f6122b.equals(c0Var.f6122b);
    }

    public final int hashCode() {
        return c.c.a.b.c.o.q.a(this.f6122b, this.f6121a);
    }

    public final String a() {
        return this.f6121a;
    }
}
