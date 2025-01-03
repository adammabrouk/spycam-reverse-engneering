package c.c.a.b.c;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class z extends y {

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f4041b;

    public z(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f4041b = bArr;
    }

    @Override // c.c.a.b.c.y
    public final byte[] f() {
        return this.f4041b;
    }
}
