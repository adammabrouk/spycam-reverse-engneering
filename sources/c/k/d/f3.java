package c.k.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import c.k.d.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class f3 extends j.a {

    /* renamed from: a, reason: collision with root package name */
    public Context f7118a;

    /* renamed from: b, reason: collision with root package name */
    public SharedPreferences f7119b;

    /* renamed from: c, reason: collision with root package name */
    public c.k.d.p9.m f7120c;

    public f3(Context context) {
        this.f7118a = context;
        this.f7119b = context.getSharedPreferences("mipush_extra", 0);
        this.f7120c = c.k.d.p9.m.a(context);
    }

    @Override // c.k.d.j.a
    public int a() {
        return 1;
    }

    public final List<d7> a(File file) {
        RandomAccessFile randomAccessFile;
        FileInputStream fileInputStream;
        k2 m271a = l2.a().m271a();
        String a2 = m271a == null ? "" : m271a.a();
        FileLock fileLock = null;
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (q2.f7757a) {
            try {
                File file2 = new File(this.f7118a.getExternalFilesDir(null), "push_cdata.lock");
                v9.m513a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    FileLock lock = randomAccessFile.getChannel().lock();
                    try {
                        fileInputStream = new FileInputStream(file);
                        while (fileInputStream.read(bArr) == 4) {
                            try {
                                int a3 = d.a(bArr);
                                byte[] bArr2 = new byte[a3];
                                if (fileInputStream.read(bArr2) != a3) {
                                    break;
                                }
                                byte[] a4 = p2.a(a2, bArr2);
                                if (a4 != null && a4.length != 0) {
                                    d7 d7Var = new d7();
                                    h8.a(d7Var, a4);
                                    arrayList.add(d7Var);
                                    a(d7Var);
                                }
                            } catch (Exception unused) {
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused2) {
                                    }
                                }
                                v9.a(fileInputStream);
                                v9.a(randomAccessFile);
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused3) {
                                    }
                                }
                                v9.a(fileInputStream);
                                v9.a(randomAccessFile);
                                throw th;
                            }
                        }
                        if (lock != null && lock.isValid()) {
                            try {
                                lock.release();
                            } catch (IOException unused4) {
                            }
                        }
                        v9.a(fileInputStream);
                    } catch (Exception unused5) {
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                    }
                } catch (Exception unused6) {
                    fileInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                }
            } catch (Exception unused7) {
                randomAccessFile = null;
                fileInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
                fileInputStream = null;
            }
            v9.a(randomAccessFile);
        }
        return arrayList;
    }

    /* renamed from: a, reason: collision with other method in class */
    public final void m149a() {
        SharedPreferences.Editor edit = this.f7119b.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    public final void a(d7 d7Var) {
        if (d7Var.f14a != x6.AppInstallList || d7Var.f15a.startsWith("same_")) {
            return;
        }
        SharedPreferences.Editor edit = this.f7119b.edit();
        edit.putLong("dc_job_result_time_4", d7Var.f7074a);
        edit.putString("dc_job_result_4", k0.a(d7Var.f15a));
        edit.commit();
    }

    /* renamed from: a, reason: collision with other method in class */
    public final boolean m150a() {
        if (e0.d(this.f7118a)) {
            return false;
        }
        if (!e0.f(this.f7118a) || c()) {
            return (e0.g(this.f7118a) && !b()) || e0.h(this.f7118a);
        }
        return true;
    }

    public final boolean b() {
        if (!this.f7120c.a(a7.Upload3GSwitch.a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f7119b.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f7120c.a(a7.Upload3GFrequency.a(), 432000)));
    }

    public final boolean c() {
        if (!this.f7120c.a(a7.Upload4GSwitch.a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f7119b.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f7120c.a(a7.Upload4GFrequency.a(), 259200)));
    }

    @Override // java.lang.Runnable
    public void run() {
        File file = new File(this.f7118a.getExternalFilesDir(null), "push_cdata.data");
        if (!e0.c(this.f7118a)) {
            if (file.length() > 1863680) {
                file.delete();
                return;
            }
            return;
        }
        if (!m150a() && file.exists()) {
            List<d7> a2 = a(file);
            if (!e.a(a2)) {
                int size = a2.size();
                if (size > 4000) {
                    a2 = a2.subList(size - 4000, size);
                }
                p7 p7Var = new p7();
                p7Var.a(a2);
                byte[] a3 = v9.a(h8.a(p7Var));
                v7 v7Var = new v7("-1", false);
                v7Var.c(g7.DataCollection.f30a);
                v7Var.a(a3);
                k2 m271a = l2.a().m271a();
                if (m271a != null) {
                    m271a.a(v7Var, v6.Notification, null);
                }
                m149a();
            }
            file.delete();
        }
    }
}
