package c.k.d;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class c0 {

    /* renamed from: a, reason: collision with root package name */
    public int f7009a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f7010b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public String f7011c;

    public String a() {
        return this.f7011c;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.f7009a), this.f7010b.toString(), this.f7011c);
    }
}
