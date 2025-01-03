package c.k.d.p9;

import androidx.recyclerview.widget.RecyclerView;
import com.shix.shixipc.utilcode.JsonUtils;
import com.shix.shixipc.utilcode.LogUtils;

/* loaded from: classes.dex */
public class a0 {

    /* renamed from: d, reason: collision with root package name */
    public int f7529d = -666;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f7526a = new byte[RecyclerView.c0.FLAG_TMP_DETACHED];

    /* renamed from: c, reason: collision with root package name */
    public int f7528c = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f7527b = 0;

    public static int a(byte b2) {
        return b2 >= 0 ? b2 : b2 + JsonUtils.TYPE_BOOLEAN;
    }

    public static void a(byte[] bArr, int i2, int i3) {
        byte b2 = bArr[i2];
        bArr[i2] = bArr[i3];
        bArr[i3] = b2;
    }

    public static byte[] a(String str, String str2) {
        byte[] m185a = c.k.d.h0.m185a(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[m185a.length + 1 + bytes.length];
        for (int i2 = 0; i2 < m185a.length; i2++) {
            bArr[i2] = m185a[i2];
        }
        bArr[m185a.length] = 95;
        for (int i3 = 0; i3 < bytes.length; i3++) {
            bArr[m185a.length + 1 + i3] = bytes[i3];
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, c.k.d.h0.m185a(str));
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        a0 a0Var = new a0();
        a0Var.a(bArr);
        a0Var.m354a();
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            bArr3[i2] = (byte) (bArr2[i2] ^ a0Var.a());
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z, int i2, int i3) {
        byte[] bArr3;
        int i4;
        if (i2 < 0 || i2 > bArr2.length || i2 + i3 > bArr2.length) {
            throw new IllegalArgumentException("start = " + i2 + " len = " + i3);
        }
        if (z) {
            bArr3 = bArr2;
            i4 = i2;
        } else {
            bArr3 = new byte[i3];
            i4 = 0;
        }
        a0 a0Var = new a0();
        a0Var.a(bArr);
        a0Var.m354a();
        for (int i5 = 0; i5 < i3; i5++) {
            bArr3[i4 + i5] = (byte) (bArr2[i2 + i5] ^ a0Var.a());
        }
        return bArr3;
    }

    public byte a() {
        int i2 = (this.f7527b + 1) % RecyclerView.c0.FLAG_TMP_DETACHED;
        this.f7527b = i2;
        int a2 = (this.f7528c + a(this.f7526a[i2])) % RecyclerView.c0.FLAG_TMP_DETACHED;
        this.f7528c = a2;
        a(this.f7526a, this.f7527b, a2);
        byte[] bArr = this.f7526a;
        return bArr[(a(bArr[this.f7527b]) + a(this.f7526a[this.f7528c])) % RecyclerView.c0.FLAG_TMP_DETACHED];
    }

    /* renamed from: a, reason: collision with other method in class */
    public final void m354a() {
        this.f7528c = 0;
        this.f7527b = 0;
    }

    public final void a(int i2, byte[] bArr, boolean z) {
        int length = bArr.length;
        for (int i3 = 0; i3 < 256; i3++) {
            this.f7526a[i3] = (byte) i3;
        }
        this.f7528c = 0;
        this.f7527b = 0;
        while (true) {
            int i4 = this.f7527b;
            if (i4 >= i2) {
                break;
            }
            int a2 = ((this.f7528c + a(this.f7526a[i4])) + a(bArr[this.f7527b % length])) % RecyclerView.c0.FLAG_TMP_DETACHED;
            this.f7528c = a2;
            a(this.f7526a, this.f7527b, a2);
            this.f7527b++;
        }
        if (i2 != 256) {
            this.f7529d = ((this.f7528c + a(this.f7526a[i2])) + a(bArr[i2 % length])) % RecyclerView.c0.FLAG_TMP_DETACHED;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("S_");
            int i5 = i2 - 1;
            sb.append(i5);
            sb.append(":");
            for (int i6 = 0; i6 <= i2; i6++) {
                sb.append(LogUtils.PLACEHOLDER);
                sb.append(a(this.f7526a[i6]));
            }
            sb.append("   j_");
            sb.append(i5);
            sb.append("=");
            sb.append(this.f7528c);
            sb.append("   j_");
            sb.append(i2);
            sb.append("=");
            sb.append(this.f7529d);
            sb.append("   S_");
            sb.append(i5);
            sb.append("[j_");
            sb.append(i5);
            sb.append("]=");
            sb.append(a(this.f7526a[this.f7528c]));
            sb.append("   S_");
            sb.append(i5);
            sb.append("[j_");
            sb.append(i2);
            sb.append("]=");
            sb.append(a(this.f7526a[this.f7529d]));
            if (this.f7526a[1] != 0) {
                sb.append("   S[1]!=0");
            }
            c.k.a.a.a.c.m6a(sb.toString());
        }
    }

    public final void a(byte[] bArr) {
        a(RecyclerView.c0.FLAG_TMP_DETACHED, bArr, false);
    }
}
