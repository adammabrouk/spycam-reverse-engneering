package c.c.a.a.j;

import android.content.Context;
import java.io.Closeable;
import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public abstract class r implements Closeable {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public interface a {
        a a(Context context);

        r a();
    }

    public abstract c.c.a.a.j.w.k.c a();

    public abstract q b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a().close();
    }
}
