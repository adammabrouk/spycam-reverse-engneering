package c.k.d;

import java.util.Map;

/* loaded from: classes.dex */
public class a5 implements Cloneable {

    /* renamed from: e, reason: collision with root package name */
    public static final String f6951e = f.f7112b;

    /* renamed from: f, reason: collision with root package name */
    public static String f6952f = null;

    /* renamed from: a, reason: collision with root package name */
    public String f6953a;

    /* renamed from: b, reason: collision with root package name */
    public int f6954b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6955c = z4.q;

    /* renamed from: d, reason: collision with root package name */
    public String f6956d;

    public a5(Map<String, Integer> map, int i2, String str, e5 e5Var) {
        a(map, i2, str, e5Var);
    }

    public static final String a() {
        String str = f6952f;
        return str != null ? str : c.m97a() ? "sandbox.xmpush.xiaomi.com" : c.b() ? f6951e : "app.chat.xiaomi.net";
    }

    public static final void c(String str) {
        f6952f = str;
    }

    /* renamed from: a, reason: collision with other method in class */
    public int m71a() {
        return this.f6954b;
    }

    public void a(String str) {
        this.f6956d = str;
    }

    public final void a(Map<String, Integer> map, int i2, String str, e5 e5Var) {
        this.f6954b = i2;
    }

    public void a(boolean z) {
        this.f6955c = z;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m72a() {
        return this.f6955c;
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] mo73a() {
        throw null;
    }

    public String b() {
        return this.f6956d;
    }

    public void b(String str) {
        this.f6953a = str;
    }

    public String c() {
        if (this.f6953a == null) {
            this.f6953a = a();
        }
        return this.f6953a;
    }
}
