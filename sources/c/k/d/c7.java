package c.k.d;

/* loaded from: classes.dex */
public enum c7 {
    INT(1),
    LONG(2),
    STRING(3),
    BOOLEAN(4);


    /* renamed from: a, reason: collision with other field name */
    public final int f8a;

    c7(int i2) {
        this.f8a = i2;
    }

    public static c7 a(int i2) {
        if (i2 == 1) {
            return INT;
        }
        if (i2 == 2) {
            return LONG;
        }
        if (i2 == 3) {
            return STRING;
        }
        if (i2 != 4) {
            return null;
        }
        return BOOLEAN;
    }
}
