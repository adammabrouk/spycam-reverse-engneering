package i;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: Okio.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f11833a = Logger.getLogger(l.class.getName());

    /* compiled from: Okio.java */
    public class a implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f11834a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OutputStream f11835b;

        public a(t tVar, OutputStream outputStream) {
            this.f11834a = tVar;
            this.f11835b = outputStream;
        }

        @Override // i.r
        public void a(i.c cVar, long j) throws IOException {
            u.a(cVar.f11820b, 0L, j);
            while (j > 0) {
                this.f11834a.e();
                o oVar = cVar.f11819a;
                int min = (int) Math.min(j, oVar.f11847c - oVar.f11846b);
                this.f11835b.write(oVar.f11845a, oVar.f11846b, min);
                int i2 = oVar.f11846b + min;
                oVar.f11846b = i2;
                long j2 = min;
                j -= j2;
                cVar.f11820b -= j2;
                if (i2 == oVar.f11847c) {
                    cVar.f11819a = oVar.b();
                    p.a(oVar);
                }
            }
        }

        @Override // i.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f11835b.close();
        }

        @Override // i.r, java.io.Flushable
        public void flush() throws IOException {
            this.f11835b.flush();
        }

        @Override // i.r
        public t timeout() {
            return this.f11834a;
        }

        public String toString() {
            return "sink(" + this.f11835b + ")";
        }
    }

    /* compiled from: Okio.java */
    public class b implements s {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f11836a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InputStream f11837b;

        public b(t tVar, InputStream inputStream) {
            this.f11836a = tVar;
            this.f11837b = inputStream;
        }

        @Override // i.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f11837b.close();
        }

        @Override // i.s
        public long read(i.c cVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (j == 0) {
                return 0L;
            }
            try {
                this.f11836a.e();
                o b2 = cVar.b(1);
                int read = this.f11837b.read(b2.f11845a, b2.f11847c, (int) Math.min(j, 8192 - b2.f11847c));
                if (read == -1) {
                    return -1L;
                }
                b2.f11847c += read;
                long j2 = read;
                cVar.f11820b += j2;
                return j2;
            } catch (AssertionError e2) {
                if (l.a(e2)) {
                    throw new IOException(e2);
                }
                throw e2;
            }
        }

        @Override // i.s
        public t timeout() {
            return this.f11836a;
        }

        public String toString() {
            return "source(" + this.f11837b + ")";
        }
    }

    /* compiled from: Okio.java */
    public class c extends i.a {
        public final /* synthetic */ Socket k;

        public c(Socket socket) {
            this.k = socket;
        }

        @Override // i.a
        public IOException b(@Nullable IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // i.a
        public void i() {
            try {
                this.k.close();
            } catch (AssertionError e2) {
                if (!l.a(e2)) {
                    throw e2;
                }
                l.f11833a.log(Level.WARNING, "Failed to close timed out socket " + this.k, (Throwable) e2);
            } catch (Exception e3) {
                l.f11833a.log(Level.WARNING, "Failed to close timed out socket " + this.k, (Throwable) e3);
            }
        }
    }

    public static e a(s sVar) {
        return new n(sVar);
    }

    public static s b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        i.a c2 = c(socket);
        return c2.a(a(socket.getInputStream(), c2));
    }

    public static i.a c(Socket socket) {
        return new c(socket);
    }

    public static d a(r rVar) {
        return new m(rVar);
    }

    public static r a(OutputStream outputStream, t tVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (tVar != null) {
            return new a(tVar, outputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static r a(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                i.a c2 = c(socket);
                return c2.a(a(socket.getOutputStream(), c2));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static s a(InputStream inputStream) {
        return a(inputStream, new t());
    }

    public static s a(InputStream inputStream, t tVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (tVar != null) {
            return new b(tVar, inputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static s a(File file) throws FileNotFoundException {
        if (file != null) {
            return a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
