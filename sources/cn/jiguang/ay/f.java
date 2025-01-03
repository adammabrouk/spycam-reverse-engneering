package cn.jiguang.ay;

import com.shix.shixipc.utilcode.LogUtils;
import java.util.HashMap;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static Integer[] f8507a = new Integer[64];

    /* renamed from: d, reason: collision with root package name */
    public String f8510d;

    /* renamed from: e, reason: collision with root package name */
    public int f8511e;

    /* renamed from: f, reason: collision with root package name */
    public String f8512f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8514h;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f8508b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public HashMap f8509c = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public int f8513g = Integer.MAX_VALUE;

    static {
        int i2 = 0;
        while (true) {
            Integer[] numArr = f8507a;
            if (i2 >= numArr.length) {
                return;
            }
            numArr[i2] = Integer.valueOf(i2);
            i2++;
        }
    }

    public f(String str, int i2) {
        this.f8510d = str;
        this.f8511e = i2;
    }

    private String a(String str) {
        int i2 = this.f8511e;
        return i2 == 2 ? str.toUpperCase() : i2 == 3 ? str.toLowerCase() : str;
    }

    public static Integer b(int i2) {
        if (i2 >= 0) {
            Integer[] numArr = f8507a;
            if (i2 < numArr.length) {
                return numArr[i2];
            }
        }
        return Integer.valueOf(i2);
    }

    public void a(int i2) {
        this.f8513g = i2;
    }

    public void a(int i2, String str) {
        c(i2);
        Integer b2 = b(i2);
        String a2 = a(str);
        this.f8508b.put(a2, b2);
        this.f8509c.put(b2, a2);
    }

    public void a(boolean z) {
        this.f8514h = z;
    }

    public void c(int i2) {
        if (i2 < 0 || i2 > this.f8513g) {
            throw new IllegalArgumentException(this.f8510d + LogUtils.PLACEHOLDER + i2 + "is out of range");
        }
    }

    public String d(int i2) {
        c(i2);
        String str = (String) this.f8509c.get(b(i2));
        if (str != null) {
            return str;
        }
        String num = Integer.toString(i2);
        if (this.f8512f == null) {
            return num;
        }
        return this.f8512f + num;
    }
}
