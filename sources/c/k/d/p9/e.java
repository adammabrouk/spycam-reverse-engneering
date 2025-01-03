package c.k.d.p9;

import android.os.Process;
import android.text.TextUtils;
import c.k.d.g3;
import c.k.d.n6;
import c.k.d.v9;
import com.alibaba.sdk.android.oss.common.LogThreadPoolManager;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static long f7558a;

    /* renamed from: b, reason: collision with root package name */
    public static ThreadPoolExecutor f7559b;

    static {
        Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
        f7558a = 0L;
        f7559b = new ThreadPoolExecutor(1, 1, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static String a(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
        } catch (Exception unused) {
            bufferedReader = null;
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    String sb2 = sb.toString();
                    v9.a(bufferedReader);
                    return sb2;
                }
                sb.append(OSSUtils.NEW_LINE);
                sb.append(readLine);
            }
        } catch (Exception unused2) {
            v9.a(bufferedReader);
            return null;
        } catch (Throwable th3) {
            th = th3;
            v9.a(bufferedReader);
            throw th;
        }
    }

    public static void a() {
        g3 m385a;
        long currentTimeMillis = System.currentTimeMillis();
        if ((f7559b.getActiveCount() <= 0 || currentTimeMillis - f7558a >= 1800000) && n6.m307a().m312a() && (m385a = h0.a().m385a()) != null && m385a.e() > 0) {
            f7558a = currentTimeMillis;
            a(m385a.m167a(), true);
        }
    }

    public static void a(List<String> list, boolean z) {
        f7559b.execute(new f(list, z));
    }

    public static void b() {
        String a2 = a("/proc/self/net/tcp");
        if (!TextUtils.isEmpty(a2)) {
            c.k.a.a.a.c.m6a("dump tcp for uid = " + Process.myUid());
            c.k.a.a.a.c.m6a(a2);
        }
        String a3 = a("/proc/self/net/tcp6");
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        c.k.a.a.a.c.m6a("dump tcp6 for uid = " + Process.myUid());
        c.k.a.a.a.c.m6a(a3);
    }

    public static boolean b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            c.k.a.a.a.c.m6a("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(c.k.d.s1.m457a(str, 5222), LogThreadPoolManager.TIME_KEEP_ALIVE);
            socket.setTcpNoDelay(true);
            c.k.a.a.a.c.m6a("ConnectivityTest: connect to " + str + " in " + (System.currentTimeMillis() - currentTimeMillis));
            socket.close();
            return true;
        } catch (Throwable th) {
            c.k.a.a.a.c.d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }
}
