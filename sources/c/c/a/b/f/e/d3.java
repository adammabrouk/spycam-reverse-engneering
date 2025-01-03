package c.c.a.b.f.e;

import c.c.a.b.f.e.b3;
import c.c.a.b.f.e.d3;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public abstract class d3<MessageType extends b3<MessageType, BuilderType>, BuilderType extends d3<MessageType, BuilderType>> implements c6 {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.c.a.b.f.e.c6
    public final /* synthetic */ c6 a(d6 d6Var) {
        if (c().getClass().isInstance(d6Var)) {
            return a((d3<MessageType, BuilderType>) d6Var);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public abstract BuilderType a(MessageType messagetype);

    public abstract BuilderType a(byte[] bArr, int i2, int i3) throws c5;

    public abstract BuilderType a(byte[] bArr, int i2, int i3, e4 e4Var) throws c5;

    @Override // c.c.a.b.f.e.c6
    public final /* synthetic */ c6 b(byte[] bArr) throws c5 {
        a(bArr, 0, bArr.length);
        return this;
    }

    @Override // c.c.a.b.f.e.c6
    public final /* synthetic */ c6 a(byte[] bArr, e4 e4Var) throws c5 {
        a(bArr, 0, bArr.length, e4Var);
        return this;
    }
}
