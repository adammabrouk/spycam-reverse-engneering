package c.a.a.l.j;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: StreamEncoder.java */
/* loaded from: classes.dex */
public class o implements c.a.a.l.b<InputStream> {
    @Override // c.a.a.l.b
    public String c() {
        return "";
    }

    @Override // c.a.a.l.b
    public boolean a(InputStream inputStream, OutputStream outputStream) {
        byte[] a2 = c.a.a.r.a.b().a();
        while (true) {
            try {
                int read = inputStream.read(a2);
                if (read == -1) {
                    return true;
                }
                outputStream.write(a2, 0, read);
            } catch (IOException e2) {
                if (Log.isLoggable("StreamEncoder", 3)) {
                    Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e2);
                }
                return false;
            } finally {
                c.a.a.r.a.b().a(a2);
            }
        }
    }
}
