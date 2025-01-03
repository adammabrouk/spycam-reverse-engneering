package cn.jiguang.as;

import android.content.Context;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import cn.jiguang.e.e;
import cn.jiguang.internal.JConstants;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.shix.shixipc.utilcode.LogUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f8346a = "jpush_log";

    /* renamed from: b, reason: collision with root package name */
    public static String f8347b = "internal_debug_log.txt";

    /* renamed from: c, reason: collision with root package name */
    public static final SimpleDateFormat f8348c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);

    /* renamed from: d, reason: collision with root package name */
    public static final Object f8349d = new Object();

    public static void a() {
        try {
            synchronized (f8349d) {
                Context appContext = JConstants.getAppContext(null);
                if (appContext == null) {
                    appContext = e.a();
                }
                if (appContext == null) {
                    return;
                }
                File file = new File(appContext.getFilesDir() + File.separator + f8346a + File.separator);
                if (!file.exists()) {
                    file.delete();
                    return;
                }
                if (file.listFiles() != null) {
                    for (File file2 : file.listFiles()) {
                        file2.delete();
                    }
                }
                file.delete();
            }
        } catch (Throwable th) {
            d.g("Logger", "clearLogFiles error is " + th.getMessage());
        }
    }

    public static void a(final String str) {
        try {
            cn.jiguang.bj.d.a("ONCE_TASK", new Runnable() { // from class: cn.jiguang.as.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        synchronized (c.f8349d) {
                            Context appContext = JConstants.getAppContext(null);
                            if (appContext == null) {
                                appContext = e.a();
                            }
                            if (appContext == null) {
                                return;
                            }
                            File file = new File((appContext.getFilesDir() + File.separator + c.f8346a + File.separator) + c.f8347b);
                            File parentFile = file.getParentFile();
                            if (!parentFile.exists()) {
                                parentFile.mkdirs();
                            }
                            if (!file.exists()) {
                                file.createNewFile();
                                d.a("Logger", "create log file: " + file.getName());
                            }
                            cn.jiguang.e.c.a(file, str + OSSUtils.NEW_LINE);
                        }
                    } catch (Throwable th) {
                        d.g("Logger", "write logs to file error is " + th.getMessage());
                    }
                }
            });
        } catch (Throwable th) {
            d.g("Logger", "saveLogs error is " + th.getMessage());
        }
    }

    public static void a(String str, String str2, String str3, String str4, Throwable th) {
        if (str3 == null || str3.trim().equals("")) {
            str3 = "Logger";
        }
        if (str4 == null) {
            return;
        }
        try {
            String format = f8348c.format(new Date());
            BufferedReader bufferedReader = new BufferedReader(new StringReader(str4), RecyclerView.c0.FLAG_TMP_DETACHED);
            String str5 = "[" + str3 + "] ";
            String a2 = cn.jiguang.e.a.a(e.a());
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    a(((Object) format) + LogUtils.PLACEHOLDER + a2 + LogUtils.PLACEHOLDER + str + "/" + str2 + ":" + LogUtils.PLACEHOLDER + str5 + readLine);
                } catch (IOException e2) {
                    d.i("Logger", e2.getMessage());
                }
            }
            if (th != null) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                a(((Object) format) + LogUtils.PLACEHOLDER + str + stringWriter.toString());
            }
        } catch (Throwable th2) {
            Log.w("Logger", "log2File call failed:" + th2.getMessage());
        }
    }
}
