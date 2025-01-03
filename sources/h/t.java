package h;

import java.io.IOException;

/* compiled from: Interceptor.java */
/* loaded from: classes.dex */
public interface t {

    /* compiled from: Interceptor.java */
    public interface a {
        a0 a(y yVar) throws IOException;

        y a();

        int b();

        int c();

        int d();
    }

    a0 intercept(a aVar) throws IOException;
}
