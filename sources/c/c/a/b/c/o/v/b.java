package c.c.a.b.c.o.v;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.zxing.client.j2se.DecodeWorker;
import java.util.List;

/* loaded from: classes.dex */
public class b {
    public static int a(Parcel parcel) {
        return b(parcel, 20293);
    }

    public static void b(Parcel parcel, int i2, int i3) {
        if (i3 < 65535) {
            parcel.writeInt(i2 | (i3 << 16));
        } else {
            parcel.writeInt(i2 | DecodeWorker.RED);
            parcel.writeInt(i3);
        }
    }

    public static void c(Parcel parcel, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i2 - 4);
        parcel.writeInt(dataPosition - i2);
        parcel.setDataPosition(dataPosition);
    }

    public static void a(Parcel parcel, int i2) {
        c(parcel, i2);
    }

    public static void a(Parcel parcel, int i2, boolean z) {
        b(parcel, i2, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static int b(Parcel parcel, int i2) {
        parcel.writeInt(i2 | DecodeWorker.RED);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void a(Parcel parcel, int i2, Boolean bool, boolean z) {
        if (bool != null) {
            b(parcel, i2, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            b(parcel, i2, 0);
        }
    }

    public static <T extends Parcelable> void b(Parcel parcel, int i2, List<T> list, boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i2, 0);
                return;
            }
            return;
        }
        int b2 = b(parcel, i2);
        int size = list.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            T t = list.get(i3);
            if (t == null) {
                parcel.writeInt(0);
            } else {
                a(parcel, t, 0);
            }
        }
        c(parcel, b2);
    }

    public static void a(Parcel parcel, int i2, int i3) {
        b(parcel, i2, 4);
        parcel.writeInt(i3);
    }

    public static void a(Parcel parcel, int i2, Integer num, boolean z) {
        if (num != null) {
            b(parcel, i2, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            b(parcel, i2, 0);
        }
    }

    public static void a(Parcel parcel, int i2, long j) {
        b(parcel, i2, 8);
        parcel.writeLong(j);
    }

    public static void a(Parcel parcel, int i2, Long l, boolean z) {
        if (l != null) {
            b(parcel, i2, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            b(parcel, i2, 0);
        }
    }

    public static void a(Parcel parcel, int i2, float f2) {
        b(parcel, i2, 4);
        parcel.writeFloat(f2);
    }

    public static void a(Parcel parcel, int i2, Float f2, boolean z) {
        if (f2 != null) {
            b(parcel, i2, 4);
            parcel.writeFloat(f2.floatValue());
        } else if (z) {
            b(parcel, i2, 0);
        }
    }

    public static void a(Parcel parcel, int i2, Double d2, boolean z) {
        if (d2 != null) {
            b(parcel, i2, 8);
            parcel.writeDouble(d2.doubleValue());
        } else if (z) {
            b(parcel, i2, 0);
        }
    }

    public static void a(Parcel parcel, int i2, String str, boolean z) {
        if (str == null) {
            if (z) {
                b(parcel, i2, 0);
            }
        } else {
            int b2 = b(parcel, i2);
            parcel.writeString(str);
            c(parcel, b2);
        }
    }

    public static void a(Parcel parcel, int i2, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            if (z) {
                b(parcel, i2, 0);
            }
        } else {
            int b2 = b(parcel, i2);
            parcel.writeStrongBinder(iBinder);
            c(parcel, b2);
        }
    }

    public static void a(Parcel parcel, int i2, Parcelable parcelable, int i3, boolean z) {
        if (parcelable == null) {
            if (z) {
                b(parcel, i2, 0);
            }
        } else {
            int b2 = b(parcel, i2);
            parcelable.writeToParcel(parcel, i3);
            c(parcel, b2);
        }
    }

    public static void a(Parcel parcel, int i2, Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                b(parcel, i2, 0);
            }
        } else {
            int b2 = b(parcel, i2);
            parcel.writeBundle(bundle);
            c(parcel, b2);
        }
    }

    public static void a(Parcel parcel, int i2, String[] strArr, boolean z) {
        if (strArr == null) {
            if (z) {
                b(parcel, i2, 0);
            }
        } else {
            int b2 = b(parcel, i2);
            parcel.writeStringArray(strArr);
            c(parcel, b2);
        }
    }

    public static void a(Parcel parcel, int i2, List<String> list, boolean z) {
        if (list == null) {
            if (z) {
                b(parcel, i2, 0);
            }
        } else {
            int b2 = b(parcel, i2);
            parcel.writeStringList(list);
            c(parcel, b2);
        }
    }

    public static <T extends Parcelable> void a(Parcel parcel, int i2, T[] tArr, int i3, boolean z) {
        if (tArr == null) {
            if (z) {
                b(parcel, i2, 0);
                return;
            }
            return;
        }
        int b2 = b(parcel, i2);
        parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                a(parcel, t, i3);
            }
        }
        c(parcel, b2);
    }

    public static <T extends Parcelable> void a(Parcel parcel, T t, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i2);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    public static void a(Parcel parcel, int i2, Parcel parcel2, boolean z) {
        if (parcel2 == null) {
            if (z) {
                b(parcel, i2, 0);
            }
        } else {
            int b2 = b(parcel, i2);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            c(parcel, b2);
        }
    }
}
