package c.c.a.b.f.a;

import android.os.Parcel;

/* loaded from: classes.dex */
public class c {
    static {
        c.class.getClassLoader();
    }

    public static void a(Parcel parcel, boolean z) {
        parcel.writeInt(1);
    }

    public static boolean a(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
