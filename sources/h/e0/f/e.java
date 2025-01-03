package h.e0.f;

import java.io.IOException;

/* compiled from: RouteException.java */
/* loaded from: classes.dex */
public final class e extends RuntimeException {
    public IOException firstException;
    public IOException lastException;

    public e(IOException iOException) {
        super(iOException);
        this.firstException = iOException;
        this.lastException = iOException;
    }

    public void addConnectException(IOException iOException) {
        h.e0.c.a((Throwable) this.firstException, (Throwable) iOException);
        this.lastException = iOException;
    }

    public IOException getFirstConnectException() {
        return this.firstException;
    }

    public IOException getLastConnectException() {
        return this.lastException;
    }
}
