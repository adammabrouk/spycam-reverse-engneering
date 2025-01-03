package c.k.d.p9;

import android.content.Context;
import c.k.d.v9;
import c.k.d.z6;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: classes.dex */
public final class n0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f7656a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z6 f7657b;

    public n0(Context context, z6 z6Var) {
        this.f7656a = context;
        this.f7657b = z6Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        RandomAccessFile randomAccessFile;
        synchronized (m0.f7650a) {
            FileLock fileLock = null;
            try {
                try {
                    File file = new File(this.f7656a.getFilesDir(), "tiny_data.lock");
                    v9.m513a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (Exception e2) {
                    e = e2;
                    randomAccessFile = null;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = null;
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException e3) {
                            c.k.a.a.a.c.a(e3);
                        }
                    }
                    v9.a(randomAccessFile);
                    throw th;
                }
                try {
                    try {
                        fileLock = randomAccessFile.getChannel().lock();
                        m0.c(this.f7656a, this.f7657b);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e4) {
                                c.k.a.a.a.c.a(e4);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileLock != null && fileLock.isValid()) {
                            fileLock.release();
                        }
                        v9.a(randomAccessFile);
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    c.k.a.a.a.c.a(e);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e6) {
                            c.k.a.a.a.c.a(e6);
                        }
                    }
                    v9.a(randomAccessFile);
                }
                v9.a(randomAccessFile);
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
