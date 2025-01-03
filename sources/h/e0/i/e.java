package h.e0.i;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;

/* compiled from: Http2.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final i.f f11534a = i.f.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f11535b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f11536c = new String[64];

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f11537d = new String[RecyclerView.c0.FLAG_TMP_DETACHED];

    static {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = f11537d;
            if (i3 >= strArr.length) {
                break;
            }
            strArr[i3] = h.e0.c.a("%8s", Integer.toBinaryString(i3)).replace(' ', '0');
            i3++;
        }
        String[] strArr2 = f11536c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i4 = 0; i4 < 1; i4++) {
            int i5 = iArr[i4];
            f11536c[i5 | 8] = f11536c[i5] + "|PADDED";
        }
        String[] strArr3 = f11536c;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i6 = 0; i6 < 3; i6++) {
            int i7 = iArr2[i6];
            for (int i8 = 0; i8 < 1; i8++) {
                int i9 = iArr[i8];
                int i10 = i9 | i7;
                f11536c[i10] = f11536c[i9] + '|' + f11536c[i7];
                f11536c[i10 | 8] = f11536c[i9] + '|' + f11536c[i7] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr4 = f11536c;
            if (i2 >= strArr4.length) {
                return;
            }
            if (strArr4[i2] == null) {
                strArr4[i2] = f11537d[i2];
            }
            i2++;
        }
    }

    public static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(h.e0.c.a(str, objArr));
    }

    public static IOException b(String str, Object... objArr) throws IOException {
        throw new IOException(h.e0.c.a(str, objArr));
    }

    public static String a(boolean z, int i2, int i3, byte b2, byte b3) {
        String[] strArr = f11535b;
        String a2 = b2 < strArr.length ? strArr[b2] : h.e0.c.a("0x%02x", Byte.valueOf(b2));
        String a3 = a(b2, b3);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = a2;
        objArr[4] = a3;
        return h.e0.c.a("%s 0x%08x %5d %-13s %s", objArr);
    }

    public static String a(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        if (b2 != 2 && b2 != 3) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : f11537d[b3];
            }
            if (b2 != 7 && b2 != 8) {
                String[] strArr = f11536c;
                String str = b3 < strArr.length ? strArr[b3] : f11537d[b3];
                if (b2 != 5 || (b3 & 4) == 0) {
                    return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f11537d[b3];
    }
}
