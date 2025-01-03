package cn.jiguang.ay;

import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.utilcode.LogUtils;
import java.util.Random;

/* loaded from: classes.dex */
public class d implements Cloneable {

    /* renamed from: d, reason: collision with root package name */
    public static Random f8498d = new Random();

    /* renamed from: a, reason: collision with root package name */
    public int f8499a;

    /* renamed from: b, reason: collision with root package name */
    public int f8500b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f8501c;

    public d() {
        this.f8500b = RecyclerView.c0.FLAG_TMP_DETACHED;
        d();
    }

    public d(int i2) {
        this.f8500b = RecyclerView.c0.FLAG_TMP_DETACHED;
        d();
        a(i2);
    }

    public d(b bVar) {
        this(bVar.g());
        this.f8500b = bVar.g();
        int i2 = 0;
        while (true) {
            int[] iArr = this.f8501c;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = bVar.g();
            i2++;
        }
    }

    private void d() {
        this.f8501c = new int[4];
        this.f8500b = RecyclerView.c0.FLAG_TMP_DETACHED;
        this.f8499a = -1;
    }

    public int a() {
        int i2;
        int i3 = this.f8499a;
        if (i3 >= 0) {
            return i3;
        }
        synchronized (this) {
            if (this.f8499a < 0) {
                this.f8499a = f8498d.nextInt(ContentCommon.INVALID_OPTION);
            }
            i2 = this.f8499a;
        }
        return i2;
    }

    public void a(int i2) {
        if (i2 >= 0 && i2 <= 65535) {
            this.f8499a = i2;
            return;
        }
        throw new IllegalArgumentException("DNS message ID " + i2 + " is out of range");
    }

    public void a(c cVar) {
        cVar.c(a());
        cVar.c(this.f8500b);
        int i2 = 0;
        while (true) {
            int[] iArr = this.f8501c;
            if (i2 >= iArr.length) {
                return;
            }
            cVar.c(iArr[i2]);
            i2++;
        }
    }

    public int b() {
        return this.f8500b & 15;
    }

    public void b(int i2) {
        int[] iArr = this.f8501c;
        if (iArr[i2] == 65535) {
            throw new IllegalStateException("DNS section count cannot be incremented");
        }
        iArr[i2] = iArr[i2] + 1;
    }

    public int c() {
        return this.f8500b;
    }

    public int c(int i2) {
        return this.f8501c[i2];
    }

    public Object clone() {
        d dVar = new d();
        dVar.f8499a = this.f8499a;
        dVar.f8500b = this.f8500b;
        int[] iArr = this.f8501c;
        System.arraycopy(iArr, 0, dVar.f8501c, 0, iArr.length);
        return dVar;
    }

    public String d(int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(";; ->>HEADER<<- ");
        stringBuffer.append(", id: " + a());
        stringBuffer.append(OSSUtils.NEW_LINE);
        stringBuffer.append("; ");
        for (int i3 = 0; i3 < 4; i3++) {
            stringBuffer.append(n.a(i3) + ": " + c(i3) + LogUtils.PLACEHOLDER);
        }
        return stringBuffer.toString();
    }

    public String toString() {
        return d(b());
    }
}
