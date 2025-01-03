package c.k.d.p9;

import android.content.Context;
import android.text.TextUtils;
import c.k.d.v9;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: classes.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    public static volatile a f7520f;

    /* renamed from: a, reason: collision with root package name */
    public final Object f7521a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Object f7522b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public volatile String f7523c;

    /* renamed from: d, reason: collision with root package name */
    public volatile String f7524d;

    /* renamed from: e, reason: collision with root package name */
    public Context f7525e;

    public a(Context context) {
        this.f7525e = context;
    }

    public static a a(Context context) {
        if (f7520f == null) {
            synchronized (a.class) {
                if (f7520f == null) {
                    f7520f = new a(context);
                }
            }
        }
        return f7520f;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f7523c)) {
            this.f7523c = a(this.f7525e, "mipush_region", "mipush_region.lock", this.f7521a);
        }
        return this.f7523c;
    }

    public final String a(Context context, String str, String str2, Object obj) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        File file = new File(context.getFilesDir(), str);
        FileLock fileLock2 = null;
        if (!file.exists()) {
            c.k.a.a.a.c.m6a("No ready file to get data from " + str);
            return null;
        }
        synchronized (obj) {
            try {
                File file2 = new File(context.getFilesDir(), str2);
                v9.m513a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile.getChannel().lock();
                } catch (Exception e2) {
                    e = e2;
                    fileLock = null;
                } catch (Throwable th) {
                    th = th;
                    if (fileLock2 != null) {
                        try {
                            fileLock2.release();
                        } catch (IOException e3) {
                            c.k.a.a.a.c.a(e3);
                        }
                    }
                    v9.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                randomAccessFile = null;
                fileLock = null;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = null;
            }
            try {
                try {
                    String a2 = v9.a(file);
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e5) {
                            c.k.a.a.a.c.a(e5);
                        }
                    }
                    v9.a(randomAccessFile);
                    return a2;
                } catch (Throwable th3) {
                    th = th3;
                    fileLock2 = fileLock;
                    if (fileLock2 != null && fileLock2.isValid()) {
                        fileLock2.release();
                    }
                    v9.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                c.k.a.a.a.c.a(e);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e7) {
                        c.k.a.a.a.c.a(e7);
                    }
                }
                v9.a(randomAccessFile);
                return null;
            }
        }
    }

    public final void a(Context context, String str, String str2, String str3, Object obj) {
        RandomAccessFile randomAccessFile;
        synchronized (obj) {
            FileLock fileLock = null;
            try {
                try {
                    File file = new File(context.getFilesDir(), str3);
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
                        v9.a(new File(context.getFilesDir(), str2), str);
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

    public void a(String str) {
        if (TextUtils.equals(str, this.f7523c)) {
            return;
        }
        this.f7523c = str;
        a(this.f7525e, this.f7523c, "mipush_region", "mipush_region.lock", this.f7521a);
    }

    public String b() {
        if (TextUtils.isEmpty(this.f7524d)) {
            this.f7524d = a(this.f7525e, "mipush_country_code", "mipush_country_code.lock", this.f7522b);
        }
        return this.f7524d;
    }

    public void b(String str) {
        if (TextUtils.equals(str, this.f7524d)) {
            return;
        }
        this.f7524d = str;
        a(this.f7525e, this.f7524d, "mipush_country_code", "mipush_country_code.lock", this.f7522b);
    }
}
