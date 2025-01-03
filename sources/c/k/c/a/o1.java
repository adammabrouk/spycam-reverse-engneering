package c.k.c.a;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class o1 {

    /* renamed from: a, reason: collision with root package name */
    public int f6878a = 0;

    /* renamed from: b, reason: collision with root package name */
    public String f6879b = "";

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof o1)) {
            return false;
        }
        o1 o1Var = (o1) obj;
        return !TextUtils.isEmpty(o1Var.f6879b) && o1Var.f6879b.equals(this.f6879b);
    }
}
