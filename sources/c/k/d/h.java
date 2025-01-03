package c.k.d;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.hjq.permissions.Permission;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/* loaded from: classes.dex */
public class h {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    public static boolean a(Context context, String str, long j) {
        RandomAccessFile randomAccessFile;
        ?? r2 = 23;
        if (Build.VERSION.SDK_INT >= 23 && !d5.c(context, Permission.WRITE_EXTERNAL_STORAGE)) {
            return true;
        }
        FileLock fileLock = null;
        try {
            try {
                File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), "lcfp.lock");
                v9.m513a(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (IOException e2) {
                e = e2;
                randomAccessFile = null;
            } catch (Throwable th) {
                th = th;
                r2 = 0;
                if (0 != 0) {
                    try {
                        fileLock.release();
                    } catch (IOException unused) {
                    }
                }
                v9.a((Closeable) r2);
                throw th;
            }
            try {
                fileLock = randomAccessFile.getChannel().lock();
                boolean b2 = b(context, str, j);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException unused2) {
                    }
                }
                v9.a(randomAccessFile);
                return b2;
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException unused3) {
                    }
                }
                v9.a(randomAccessFile);
                return true;
            }
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0 && fileLock.isValid()) {
                fileLock.release();
            }
            v9.a((Closeable) r2);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00d2 A[Catch: all -> 0x00e6, IOException -> 0x00e9, LOOP:0: B:12:0x00cc->B:14:0x00d2, LOOP_END, TRY_LEAVE, TryCatch #9 {IOException -> 0x00e9, all -> 0x00e6, blocks: (B:11:0x00c8, B:12:0x00cc, B:14:0x00d2), top: B:10:0x00c8 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r16, java.lang.String r17, long r18) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.d.h.b(android.content.Context, java.lang.String, long):boolean");
    }
}
