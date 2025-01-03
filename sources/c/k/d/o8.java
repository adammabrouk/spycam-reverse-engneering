package c.k.d;

import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class o8 {

    /* renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f7475a;

    /* renamed from: b, reason: collision with root package name */
    public final a9 f7476b;

    /* renamed from: c, reason: collision with root package name */
    public t8 f7477c;

    public o8(v8 v8Var) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f7475a = byteArrayOutputStream;
        a9 a9Var = new a9(byteArrayOutputStream);
        this.f7476b = a9Var;
        this.f7477c = v8Var.a(a9Var);
    }

    public byte[] a(i8 i8Var) {
        this.f7475a.reset();
        i8Var.b(this.f7477c);
        return this.f7475a.toByteArray();
    }
}
