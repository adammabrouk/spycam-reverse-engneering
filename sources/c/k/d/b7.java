package c.k.d;

/* loaded from: classes.dex */
public enum b7 {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);


    /* renamed from: a, reason: collision with other field name */
    public final int f4a;

    b7(int i2) {
        this.f4a = i2;
    }

    public static b7 a(int i2) {
        if (i2 == 1) {
            return MISC_CONFIG;
        }
        if (i2 != 2) {
            return null;
        }
        return PLUGIN_CONFIG;
    }

    public int a() {
        return this.f4a;
    }
}
