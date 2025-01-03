package c.j.a.z;

/* compiled from: VivoPushException.java */
/* loaded from: classes.dex */
public class f extends Exception {
    public static final int REASON_CODE_ACCESS = 10000;
    public int mReasonCode;

    public f(String str) {
        this(10000, str);
    }

    public int getCode() {
        return this.mReasonCode;
    }

    public f(int i2, String str) {
        super(str);
        this.mReasonCode = i2;
    }
}
