package c.k.d;

/* loaded from: classes.dex */
public enum k7 {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);


    /* renamed from: a, reason: collision with other field name */
    public final int f52a;

    k7(int i2) {
        this.f52a = i2;
    }

    public static k7 a(int i2) {
        if (i2 == 0) {
            return RegIdExpired;
        }
        if (i2 == 1) {
            return PackageUnregistered;
        }
        if (i2 != 2) {
            return null;
        }
        return Init;
    }

    public int a() {
        return this.f52a;
    }
}
