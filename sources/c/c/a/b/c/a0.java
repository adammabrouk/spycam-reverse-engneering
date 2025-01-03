package c.c.a.b.c;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class a0 extends y {

    /* renamed from: c, reason: collision with root package name */
    public static final WeakReference<byte[]> f3804c = new WeakReference<>(null);

    /* renamed from: b, reason: collision with root package name */
    public WeakReference<byte[]> f3805b;

    public a0(byte[] bArr) {
        super(bArr);
        this.f3805b = f3804c;
    }

    @Override // c.c.a.b.c.y
    public final byte[] f() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.f3805b.get();
            if (bArr == null) {
                bArr = g();
                this.f3805b = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }

    public abstract byte[] g();
}
