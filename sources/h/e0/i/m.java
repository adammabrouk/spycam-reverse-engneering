package h.e0.i;

import androidx.recyclerview.widget.RecyclerView;
import com.shix.shixipc.system.ContentCommon;
import java.util.Arrays;

/* compiled from: Settings.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public int f11645a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f11646b = new int[10];

    public void a() {
        this.f11645a = 0;
        Arrays.fill(this.f11646b, 0);
    }

    public int b() {
        if ((this.f11645a & 2) != 0) {
            return this.f11646b[1];
        }
        return -1;
    }

    public int c(int i2) {
        return (this.f11645a & 32) != 0 ? this.f11646b[5] : i2;
    }

    public boolean d(int i2) {
        return ((1 << i2) & this.f11645a) != 0;
    }

    public int b(int i2) {
        return (this.f11645a & 16) != 0 ? this.f11646b[4] : i2;
    }

    public int c() {
        return (this.f11645a & RecyclerView.c0.FLAG_IGNORE) != 0 ? this.f11646b[7] : ContentCommon.INVALID_OPTION;
    }

    public int d() {
        return Integer.bitCount(this.f11645a);
    }

    public m a(int i2, int i3) {
        if (i2 >= 0) {
            int[] iArr = this.f11646b;
            if (i2 < iArr.length) {
                this.f11645a = (1 << i2) | this.f11645a;
                iArr[i2] = i3;
            }
        }
        return this;
    }

    public int a(int i2) {
        return this.f11646b[i2];
    }

    public void a(m mVar) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (mVar.d(i2)) {
                a(i2, mVar.a(i2));
            }
        }
    }
}
