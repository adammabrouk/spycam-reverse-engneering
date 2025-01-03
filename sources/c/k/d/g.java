package c.k.d;

import android.content.Context;
import com.shix.shixipc.utilcode.ThreadUtils;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f7139a = "0123456789ABCDEF".toCharArray();

    public static String a(byte[] bArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder(i3 * 2);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = bArr[i2 + i4] & ThreadUtils.TYPE_SINGLE;
            sb.append(f7139a[i5 >> 4]);
            sb.append(f7139a[i5 & 15]);
        }
        return sb.toString();
    }

    public static boolean a(Context context) {
        return f.f7111a;
    }
}
