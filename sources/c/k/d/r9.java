package c.k.d;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class r9 {

    /* renamed from: d, reason: collision with root package name */
    public static final Set<String> f7823d = Collections.synchronizedSet(new HashSet());

    /* renamed from: a, reason: collision with root package name */
    public FileLock f7824a;

    /* renamed from: b, reason: collision with root package name */
    public String f7825b;

    /* renamed from: c, reason: collision with root package name */
    public RandomAccessFile f7826c;

    public r9(Context context) {
    }

    public static r9 a(Context context, File file) {
        c.k.a.a.a.c.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        if (!f7823d.add(str)) {
            throw new IOException("abtain lock failure");
        }
        r9 r9Var = new r9(context);
        r9Var.f7825b = str;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            r9Var.f7826c = randomAccessFile;
            r9Var.f7824a = randomAccessFile.getChannel().lock();
            c.k.a.a.a.c.c("Locked: " + str + " :" + r9Var.f7824a);
            return r9Var;
        } finally {
            if (r9Var.f7824a == null) {
                RandomAccessFile randomAccessFile2 = r9Var.f7826c;
                if (randomAccessFile2 != null) {
                    v9.a(randomAccessFile2);
                }
                f7823d.remove(r9Var.f7825b);
            }
        }
    }

    public void a() {
        c.k.a.a.a.c.c("unLock: " + this.f7824a);
        FileLock fileLock = this.f7824a;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.f7824a.release();
            } catch (IOException unused) {
            }
            this.f7824a = null;
        }
        RandomAccessFile randomAccessFile = this.f7826c;
        if (randomAccessFile != null) {
            v9.a(randomAccessFile);
        }
        f7823d.remove(this.f7825b);
    }
}
