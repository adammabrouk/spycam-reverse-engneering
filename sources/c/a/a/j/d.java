package c.a.a.j;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: GifHeaderParser.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f3009b;

    /* renamed from: c, reason: collision with root package name */
    public c f3010c;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f3008a = new byte[RecyclerView.c0.FLAG_TMP_DETACHED];

    /* renamed from: d, reason: collision with root package name */
    public int f3011d = 0;

    public d a(byte[] bArr) {
        m();
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.f3009b = wrap;
            wrap.rewind();
            this.f3009b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f3009b = null;
            this.f3010c.f3000b = 2;
        }
        return this;
    }

    public final boolean b() {
        return this.f3010c.f3000b != 0;
    }

    public c c() {
        if (this.f3009b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (b()) {
            return this.f3010c;
        }
        i();
        if (!b()) {
            g();
            c cVar = this.f3010c;
            if (cVar.f3001c < 0) {
                cVar.f3000b = 1;
            }
        }
        return this.f3010c;
    }

    public final int d() {
        try {
            return this.f3009b.get() & ThreadUtils.TYPE_SINGLE;
        } catch (Exception unused) {
            this.f3010c.f3000b = 1;
            return 0;
        }
    }

    public final void e() {
        this.f3010c.f3002d.f2990a = l();
        this.f3010c.f3002d.f2991b = l();
        this.f3010c.f3002d.f2992c = l();
        this.f3010c.f3002d.f2993d = l();
        int d2 = d();
        boolean z = (d2 & RecyclerView.c0.FLAG_IGNORE) != 0;
        int pow = (int) Math.pow(2.0d, (d2 & 7) + 1);
        this.f3010c.f3002d.f2994e = (d2 & 64) != 0;
        if (z) {
            this.f3010c.f3002d.k = a(pow);
        } else {
            this.f3010c.f3002d.k = null;
        }
        this.f3010c.f3002d.j = this.f3009b.position();
        o();
        if (b()) {
            return;
        }
        c cVar = this.f3010c;
        cVar.f3001c++;
        cVar.f3003e.add(cVar.f3002d);
    }

    public final int f() {
        int d2 = d();
        this.f3011d = d2;
        int i2 = 0;
        if (d2 > 0) {
            int i3 = 0;
            while (i2 < this.f3011d) {
                try {
                    i3 = this.f3011d - i2;
                    this.f3009b.get(this.f3008a, i2, i3);
                    i2 += i3;
                } catch (Exception e2) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.f3011d, e2);
                    }
                    this.f3010c.f3000b = 1;
                }
            }
        }
        return i2;
    }

    public final void g() {
        boolean z = false;
        while (!z && !b()) {
            int d2 = d();
            if (d2 == 33) {
                int d3 = d();
                if (d3 == 1) {
                    n();
                } else if (d3 == 249) {
                    this.f3010c.f3002d = new b();
                    h();
                } else if (d3 == 254) {
                    n();
                } else if (d3 != 255) {
                    n();
                } else {
                    f();
                    String str = "";
                    for (int i2 = 0; i2 < 11; i2++) {
                        str = str + ((char) this.f3008a[i2]);
                    }
                    if (str.equals("NETSCAPE2.0")) {
                        k();
                    } else {
                        n();
                    }
                }
            } else if (d2 == 44) {
                c cVar = this.f3010c;
                if (cVar.f3002d == null) {
                    cVar.f3002d = new b();
                }
                e();
            } else if (d2 != 59) {
                this.f3010c.f3000b = 1;
            } else {
                z = true;
            }
        }
    }

    public final void h() {
        d();
        int d2 = d();
        b bVar = this.f3010c.f3002d;
        int i2 = (d2 & 28) >> 2;
        bVar.f2996g = i2;
        if (i2 == 0) {
            bVar.f2996g = 1;
        }
        this.f3010c.f3002d.f2995f = (d2 & 1) != 0;
        int l = l();
        if (l < 3) {
            l = 10;
        }
        b bVar2 = this.f3010c.f3002d;
        bVar2.f2998i = l * 10;
        bVar2.f2997h = d();
        d();
    }

    public final void i() {
        String str = "";
        for (int i2 = 0; i2 < 6; i2++) {
            str = str + ((char) d());
        }
        if (!str.startsWith("GIF")) {
            this.f3010c.f3000b = 1;
            return;
        }
        j();
        if (!this.f3010c.f3006h || b()) {
            return;
        }
        c cVar = this.f3010c;
        cVar.f2999a = a(cVar.f3007i);
        c cVar2 = this.f3010c;
        cVar2.l = cVar2.f2999a[cVar2.j];
    }

    public final void j() {
        this.f3010c.f3004f = l();
        this.f3010c.f3005g = l();
        int d2 = d();
        this.f3010c.f3006h = (d2 & RecyclerView.c0.FLAG_IGNORE) != 0;
        c cVar = this.f3010c;
        cVar.f3007i = 2 << (d2 & 7);
        cVar.j = d();
        this.f3010c.k = d();
    }

    public final void k() {
        do {
            f();
            byte[] bArr = this.f3008a;
            if (bArr[0] == 1) {
                this.f3010c.m = ((bArr[2] & ThreadUtils.TYPE_SINGLE) << 8) | (bArr[1] & ThreadUtils.TYPE_SINGLE);
            }
            if (this.f3011d <= 0) {
                return;
            }
        } while (!b());
    }

    public final int l() {
        return this.f3009b.getShort();
    }

    public final void m() {
        this.f3009b = null;
        Arrays.fill(this.f3008a, (byte) 0);
        this.f3010c = new c();
        this.f3011d = 0;
    }

    public final void n() {
        int d2;
        do {
            d2 = d();
            ByteBuffer byteBuffer = this.f3009b;
            byteBuffer.position(byteBuffer.position() + d2);
        } while (d2 > 0);
    }

    public final void o() {
        d();
        n();
    }

    public void a() {
        this.f3009b = null;
        this.f3010c = null;
    }

    public final int[] a(int i2) {
        byte[] bArr = new byte[i2 * 3];
        int[] iArr = null;
        try {
            this.f3009b.get(bArr);
            iArr = new int[RecyclerView.c0.FLAG_TMP_DETACHED];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i3 + 1;
                iArr[i3] = ((bArr[i4] & ThreadUtils.TYPE_SINGLE) << 16) | (-16777216) | ((bArr[i5] & ThreadUtils.TYPE_SINGLE) << 8) | (bArr[i6] & ThreadUtils.TYPE_SINGLE);
                i4 = i7;
                i3 = i8;
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e2);
            }
            this.f3010c.f3000b = 1;
        }
        return iArr;
    }
}
