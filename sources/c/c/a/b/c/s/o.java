package c.c.a.b.c.s;

import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public static String f4016a;

    /* renamed from: b, reason: collision with root package name */
    public static int f4017b;

    @Nullable
    public static String a() {
        if (f4016a == null) {
            if (f4017b == 0) {
                f4017b = Process.myPid();
            }
            f4016a = a(f4017b);
        }
        return f4016a;
    }

    @Nullable
    public static String a(int i2) {
        Throwable th;
        BufferedReader bufferedReader;
        String str = null;
        if (i2 <= 0) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(25);
            sb.append("/proc/");
            sb.append(i2);
            sb.append("/cmdline");
            bufferedReader = a(sb.toString());
        } catch (IOException unused) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        try {
            str = bufferedReader.readLine().trim();
            k.a(bufferedReader);
        } catch (IOException unused2) {
            k.a(bufferedReader);
            return str;
        } catch (Throwable th3) {
            th = th3;
            k.a(bufferedReader);
            throw th;
        }
        return str;
    }

    public static BufferedReader a(String str) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
