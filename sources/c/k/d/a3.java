package c.k.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import c.k.d.j;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: classes.dex */
public abstract class a3 extends j.a {

    /* renamed from: a, reason: collision with root package name */
    public int f6949a;

    /* renamed from: b, reason: collision with root package name */
    public Context f6950b;

    public a3(Context context, int i2) {
        this.f6949a = i2;
        this.f6950b = context;
    }

    public static void a(Context context, d7 d7Var) {
        k2 m271a = l2.a().m271a();
        String a2 = m271a == null ? "" : m271a.a();
        if (TextUtils.isEmpty(a2) || TextUtils.isEmpty(d7Var.a())) {
            return;
        }
        a(context, d7Var, a2);
    }

    public static void a(Context context, d7 d7Var, String str) {
        BufferedOutputStream bufferedOutputStream;
        RandomAccessFile randomAccessFile;
        byte[] b2 = p2.b(str, h8.a(d7Var));
        if (b2 == null || b2.length == 0) {
            return;
        }
        synchronized (q2.f7757a) {
            FileLock fileLock = null;
            try {
                try {
                    File file = new File(context.getExternalFilesDir(null), "push_cdata.lock");
                    v9.m513a(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        FileLock lock = randomAccessFile.getChannel().lock();
                        try {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(context.getExternalFilesDir(null), "push_cdata.data"), true));
                        } catch (IOException e2) {
                            e = e2;
                            bufferedOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream = null;
                        }
                        try {
                            bufferedOutputStream.write(d.a(b2.length));
                            bufferedOutputStream.write(b2);
                            bufferedOutputStream.flush();
                            if (lock != null && lock.isValid()) {
                                try {
                                    lock.release();
                                } catch (IOException unused) {
                                }
                            }
                            v9.a(bufferedOutputStream);
                        } catch (IOException e3) {
                            e = e3;
                            fileLock = lock;
                            try {
                                e.printStackTrace();
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused2) {
                                    }
                                }
                                v9.a(bufferedOutputStream);
                                v9.a(randomAccessFile);
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused3) {
                                    }
                                }
                                v9.a(bufferedOutputStream);
                                v9.a(randomAccessFile);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileLock = lock;
                            if (fileLock != null) {
                                fileLock.release();
                            }
                            v9.a(bufferedOutputStream);
                            v9.a(randomAccessFile);
                            throw th;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        bufferedOutputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream = null;
                    }
                } catch (IOException e5) {
                    e = e5;
                    bufferedOutputStream = null;
                    randomAccessFile = null;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = null;
                    randomAccessFile = null;
                }
                v9.a(randomAccessFile);
            } catch (Throwable th6) {
                throw th6;
            }
        }
    }

    /* renamed from: a */
    public abstract x6 mo92a();

    /* renamed from: a, reason: collision with other method in class */
    public abstract String mo67a();

    /* renamed from: a, reason: collision with other method in class */
    public boolean mo68a() {
        return false;
    }

    public final String b() {
        return "dc_job_result_time_" + a();
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m69b() {
        return p2.a(this.f6950b, String.valueOf(a()), this.f6949a);
    }

    public final String c() {
        return "dc_job_result_" + a();
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m70c() {
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (m69b()) {
            c.k.a.a.a.c.m6a("DC run job mutual: " + a());
            return;
        }
        k2 m271a = l2.a().m271a();
        String a2 = m271a == null ? "" : m271a.a();
        if (!TextUtils.isEmpty(a2) && m70c()) {
            String mo67a = mo67a();
            if (TextUtils.isEmpty(mo67a)) {
                return;
            }
            if (mo68a()) {
                SharedPreferences sharedPreferences = this.f6950b.getSharedPreferences("mipush_extra", 0);
                if (k0.a(mo67a).equals(sharedPreferences.getString(c(), null))) {
                    long j = sharedPreferences.getLong(b(), 0L);
                    int a3 = c.k.d.p9.m.a(this.f6950b).a(a7.DCJobUploadRepeatedInterval.a(), 604800);
                    if ((System.currentTimeMillis() - j) / 1000 < this.f6949a) {
                        return;
                    }
                    if ((System.currentTimeMillis() - j) / 1000 < a3) {
                        mo67a = "same_" + j;
                    }
                }
            }
            d7 d7Var = new d7();
            d7Var.a(mo67a);
            d7Var.a(System.currentTimeMillis());
            d7Var.a(mo92a());
            a(this.f6950b, d7Var, a2);
        }
    }
}
