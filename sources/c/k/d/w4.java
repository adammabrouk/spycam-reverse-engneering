package c.k.d;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class w4 extends s4 {
    public w4() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    @Override // c.k.d.s4
    /* renamed from: a */
    public ByteBuffer mo462a(ByteBuffer byteBuffer) {
        return m465a().length == 0 ? byteBuffer : super.mo462a(byteBuffer);
    }

    @Override // c.k.d.s4
    public int c() {
        if (m465a().length == 0) {
            return 0;
        }
        return super.c();
    }
}
