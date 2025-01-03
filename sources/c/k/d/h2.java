package c.k.d;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class h2 implements c.k.a.a.a.a {

    /* renamed from: e, reason: collision with root package name */
    public static final SimpleDateFormat f7210e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");

    /* renamed from: f, reason: collision with root package name */
    public static String f7211f = "/MiPushLog";

    /* renamed from: g, reason: collision with root package name */
    public static List<Pair<String, Throwable>> f7212g = Collections.synchronizedList(new ArrayList());

    /* renamed from: a, reason: collision with root package name */
    public String f7213a;

    /* renamed from: b, reason: collision with root package name */
    public Context f7214b;

    /* renamed from: c, reason: collision with root package name */
    public String f7215c = "";

    /* renamed from: d, reason: collision with root package name */
    public Handler f7216d;

    public h2(Context context) {
        this.f7214b = context;
        if (context.getApplicationContext() != null) {
            this.f7214b = context.getApplicationContext();
        }
        this.f7213a = this.f7214b.getPackageName();
        HandlerThread handlerThread = new HandlerThread("Log2FileHandlerThread");
        handlerThread.start();
        this.f7216d = new Handler(handlerThread.getLooper());
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:114:0x017a -> B:50:0x017f). Please report as a decompilation issue!!! */
    /* renamed from: a, reason: collision with other method in class */
    public final void m191a() {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        File file;
        File externalFilesDir;
        BufferedWriter bufferedWriter = null;
        try {
            try {
                try {
                    if (TextUtils.isEmpty(this.f7215c) && (externalFilesDir = this.f7214b.getExternalFilesDir(null)) != null) {
                        this.f7215c = externalFilesDir.getAbsolutePath() + "";
                    }
                    file = new File(this.f7215c + f7211f);
                } catch (Exception e2) {
                    e = e2;
                    fileLock = null;
                    randomAccessFile = null;
                } catch (Throwable th) {
                    th = th;
                    fileLock = null;
                    randomAccessFile = null;
                }
            } catch (IOException e3) {
                Log.e(this.f7213a, "", e3);
            }
            if ((!file.exists() || !file.isDirectory()) && !file.mkdirs()) {
                Log.w(this.f7213a, "Create mipushlog directory fail.");
                return;
            }
            File file2 = new File(file, "log.lock");
            if (!file2.exists() || file2.isDirectory()) {
                file2.createNewFile();
            }
            randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(file, "log1.txt"), true)));
                    while (!f7212g.isEmpty()) {
                        try {
                            Pair<String, Throwable> remove = f7212g.remove(0);
                            String str = (String) remove.first;
                            if (remove.second != null) {
                                str = (str + OSSUtils.NEW_LINE) + Log.getStackTraceString((Throwable) remove.second);
                            }
                            bufferedWriter2.write(str + OSSUtils.NEW_LINE);
                        } catch (Exception e4) {
                            e = e4;
                            bufferedWriter = bufferedWriter2;
                            Log.e(this.f7213a, "", e);
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e5) {
                                    Log.e(this.f7213a, "", e5);
                                }
                            }
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e6) {
                                    Log.e(this.f7213a, "", e6);
                                }
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e7) {
                                    Log.e(this.f7213a, "", e7);
                                }
                            }
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e8) {
                                    Log.e(this.f7213a, "", e8);
                                }
                            }
                            if (randomAccessFile == null) {
                                throw th;
                            }
                            try {
                                randomAccessFile.close();
                                throw th;
                            } catch (IOException e9) {
                                Log.e(this.f7213a, "", e9);
                                throw th;
                            }
                        }
                    }
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    File file3 = new File(file, "log1.txt");
                    if (file3.length() >= 1048576) {
                        File file4 = new File(file, "log0.txt");
                        if (file4.exists() && file4.isFile()) {
                            file4.delete();
                        }
                        file3.renameTo(file4);
                    }
                    if (0 != 0) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e10) {
                            Log.e(this.f7213a, "", e10);
                        }
                    }
                    if (fileLock != null && fileLock.isValid()) {
                        try {
                            fileLock.release();
                        } catch (IOException e11) {
                            Log.e(this.f7213a, "", e11);
                        }
                    }
                    randomAccessFile.close();
                } catch (Exception e12) {
                    e = e12;
                }
            } catch (Exception e13) {
                e = e13;
                fileLock = null;
            } catch (Throwable th3) {
                th = th3;
                fileLock = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // c.k.a.a.a.a
    public final void a(String str) {
        a(str, null);
    }

    @Override // c.k.a.a.a.a
    public final void a(String str, Throwable th) {
        f7212g.add(new Pair<>(String.format("%1$s %2$s %3$s ", f7210e.format(new Date()), this.f7213a, str), th));
        this.f7216d.post(new i2(this));
    }
}
