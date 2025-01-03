package c.e.b.g;

import com.google.zxing.client.j2se.DecodeWorker;
import com.google.zxing.view.ViewfinderView;
import com.shix.shixipc.system.ContentCommon;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ImageHeaderParser.java */
/* loaded from: classes.dex */
public class b {

    /* compiled from: ImageHeaderParser.java */
    public interface a {
        int a() throws IOException;

        int b() throws IOException;

        long skip(long j) throws IOException;
    }

    /* compiled from: ImageHeaderParser.java */
    /* renamed from: c.e.b.g.b$b, reason: collision with other inner class name */
    public static final class C0122b implements a {

        /* renamed from: a, reason: collision with root package name */
        public final InputStream f6301a;

        public C0122b(InputStream inputStream) {
            this.f6301a = inputStream;
        }

        @Override // c.e.b.g.b.a
        public int a() throws IOException {
            return ((this.f6301a.read() << 8) & 65280) | (this.f6301a.read() & ViewfinderView.OPAQUE);
        }

        @Override // c.e.b.g.b.a
        public int b() throws IOException {
            return this.f6301a.read();
        }

        @Override // c.e.b.g.b.a
        public long skip(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f6301a.skip(j2);
                if (skip <= 0) {
                    if (this.f6301a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }
    }

    public static c.e.b.d.a a(InputStream inputStream) throws IOException {
        C0122b c0122b = new C0122b(inputStream);
        int a2 = c0122b.a();
        if (a2 == 65496) {
            return c.e.b.d.a.JPEG;
        }
        int a3 = ((a2 << 16) & DecodeWorker.RED) | (c0122b.a() & ContentCommon.INVALID_OPTION);
        if (a3 == -1991225785) {
            c0122b.skip(21L);
            return c0122b.b() >= 3 ? c.e.b.d.a.PNG_A : c.e.b.d.a.PNG;
        }
        if ((a3 >> 8) == 4671814) {
            return c.e.b.d.a.GIF;
        }
        if (a3 != 1380533830) {
            return c.e.b.d.a.UNKNOWN;
        }
        c0122b.skip(4L);
        if ((((c0122b.a() << 16) & DecodeWorker.RED) | (c0122b.a() & ContentCommon.INVALID_OPTION)) != 1464156752) {
            return c.e.b.d.a.UNKNOWN;
        }
        int a4 = ((c0122b.a() << 16) & DecodeWorker.RED) | (c0122b.a() & ContentCommon.INVALID_OPTION);
        if ((a4 & (-256)) != 1448097792) {
            return c.e.b.d.a.UNKNOWN;
        }
        int i2 = a4 & ViewfinderView.OPAQUE;
        if (i2 == 88) {
            c0122b.skip(4L);
            return (c0122b.b() & 16) != 0 ? c.e.b.d.a.WEBP_A : c.e.b.d.a.WEBP;
        }
        if (i2 == 76) {
            c0122b.skip(4L);
            return (c0122b.b() & 8) != 0 ? c.e.b.d.a.WEBP_A : c.e.b.d.a.WEBP;
        }
        inputStream.close();
        return c.e.b.d.a.WEBP;
    }
}
