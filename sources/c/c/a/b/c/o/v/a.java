package c.c.a.b.c.o.v;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.zxing.client.j2se.DecodeWorker;
import com.shix.shixipc.system.ContentCommon;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class a {

    /* renamed from: c.c.a.b.c.o.v.a$a, reason: collision with other inner class name */
    public static class C0090a extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public C0090a(java.lang.String r4, android.os.Parcel r5) {
            /*
                r3 = this;
                int r0 = r5.dataPosition()
                int r5 = r5.dataSize()
                java.lang.String r1 = java.lang.String.valueOf(r4)
                int r1 = r1.length()
                int r1 = r1 + 41
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r1)
                r2.append(r4)
                java.lang.String r4 = " Parcel: pos="
                r2.append(r4)
                r2.append(r0)
                java.lang.String r4 = " size="
                r2.append(r4)
                r2.append(r5)
                java.lang.String r4 = r2.toString()
                r3.<init>(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.c.o.v.a.C0090a.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    public static long A(Parcel parcel, int i2) {
        a(parcel, i2, 8);
        return parcel.readLong();
    }

    public static Long B(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        if (C == 0) {
            return null;
        }
        a(parcel, i2, C, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static int C(Parcel parcel, int i2) {
        return (i2 & DecodeWorker.RED) != -65536 ? (i2 >> 16) & ContentCommon.INVALID_OPTION : parcel.readInt();
    }

    public static void D(Parcel parcel, int i2) {
        parcel.setDataPosition(parcel.dataPosition() + C(parcel, i2));
    }

    public static int a(int i2) {
        return i2 & ContentCommon.INVALID_OPTION;
    }

    public static int a(Parcel parcel) {
        return parcel.readInt();
    }

    public static int b(Parcel parcel) {
        int a2 = a(parcel);
        int C = C(parcel, a2);
        int dataPosition = parcel.dataPosition();
        if (a(a2) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(a2));
            throw new C0090a(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i2 = C + dataPosition;
        if (i2 >= dataPosition && i2 <= parcel.dataSize()) {
            return i2;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("Size read is invalid start=");
        sb.append(dataPosition);
        sb.append(" end=");
        sb.append(i2);
        throw new C0090a(sb.toString(), parcel);
    }

    public static BigInteger c(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + C);
        return new BigInteger(createByteArray);
    }

    public static BigInteger[] d(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            bigIntegerArr[i3] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + C);
        return bigIntegerArr;
    }

    public static boolean[] e(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(dataPosition + C);
        return createBooleanArray;
    }

    public static Bundle f(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + C);
        return readBundle;
    }

    public static byte[] g(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + C);
        return createByteArray;
    }

    public static double[] h(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(dataPosition + C);
        return createDoubleArray;
    }

    public static float[] i(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + C);
        return createFloatArray;
    }

    public static int[] j(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + C);
        return createIntArray;
    }

    public static long[] k(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(dataPosition + C);
        return createLongArray;
    }

    public static Parcel l(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, C);
        parcel.setDataPosition(dataPosition + C);
        return obtain;
    }

    public static Parcel[] m(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i3] = obtain;
                parcel.setDataPosition(dataPosition2 + readInt2);
            } else {
                parcelArr[i3] = null;
            }
        }
        parcel.setDataPosition(dataPosition + C);
        return parcelArr;
    }

    public static String n(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + C);
        return readString;
    }

    public static String[] o(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + C);
        return createStringArray;
    }

    public static ArrayList<String> p(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + C);
        return createStringArrayList;
    }

    public static void q(Parcel parcel, int i2) {
        if (parcel.dataPosition() == i2) {
            return;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(i2);
        throw new C0090a(sb.toString(), parcel);
    }

    public static boolean r(Parcel parcel, int i2) {
        a(parcel, i2, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean s(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        if (C == 0) {
            return null;
        }
        a(parcel, i2, C, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static double t(Parcel parcel, int i2) {
        a(parcel, i2, 8);
        return parcel.readDouble();
    }

    public static Double u(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        if (C == 0) {
            return null;
        }
        a(parcel, i2, C, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static float v(Parcel parcel, int i2) {
        a(parcel, i2, 4);
        return parcel.readFloat();
    }

    public static Float w(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        if (C == 0) {
            return null;
        }
        a(parcel, i2, C, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static IBinder x(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + C);
        return readStrongBinder;
    }

    public static int y(Parcel parcel, int i2) {
        a(parcel, i2, 4);
        return parcel.readInt();
    }

    public static Integer z(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        if (C == 0) {
            return null;
        }
        a(parcel, i2, C, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static void a(Parcel parcel, int i2, int i3) {
        int C = C(parcel, i2);
        if (C == i3) {
            return;
        }
        String hexString = Integer.toHexString(C);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(C);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new C0090a(sb.toString(), parcel);
    }

    public static void a(Parcel parcel, int i2, int i3, int i4) {
        if (i3 == i4) {
            return;
        }
        String hexString = Integer.toHexString(i3);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i4);
        sb.append(" got ");
        sb.append(i3);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new C0090a(sb.toString(), parcel);
    }

    public static <T> ArrayList<T> c(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + C);
        return createTypedArrayList;
    }

    public static BigDecimal a(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(dataPosition + C);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static BigDecimal[] b(Parcel parcel, int i2) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i3] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + C);
        return bigDecimalArr;
    }

    public static <T extends Parcelable> T a(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + C);
        return createFromParcel;
    }

    public static <T> T[] b(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int C = C(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (C == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + C);
        return tArr;
    }
}
