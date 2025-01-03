package c.c.b.n;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final FileChannel f6033a;

    /* renamed from: b, reason: collision with root package name */
    public final FileLock f6034b;

    public b(FileChannel fileChannel, FileLock fileLock) {
        this.f6033a = fileChannel;
        this.f6034b = fileLock;
    }

    public static b a(Context context, String str) {
        FileChannel fileChannel;
        FileLock fileLock;
        try {
            fileChannel = new RandomAccessFile(new File(context.getFilesDir(), str), "rw").getChannel();
            try {
                fileLock = fileChannel.lock();
                try {
                    return new b(fileChannel, fileLock);
                } catch (IOException e2) {
                    e = e2;
                    Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", e);
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException unused) {
                        }
                    }
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                }
            } catch (IOException e3) {
                e = e3;
                fileLock = null;
            }
        } catch (IOException e4) {
            e = e4;
            fileChannel = null;
            fileLock = null;
        }
    }

    public void a() {
        try {
            this.f6034b.release();
            this.f6033a.close();
        } catch (IOException e2) {
            Log.e("CrossProcessLock", "encountered error while releasing, ignoring", e2);
        }
    }
}
