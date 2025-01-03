package com.shix.shixipc.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static final boolean DEBUG = true;
    public static final String TAG = "CrashHandler";
    public String deviceToken;
    public Context mContext;
    public Thread.UncaughtExceptionHandler mDefaultCrashHandler;
    public static final String PATH = Environment.getExternalStorageDirectory() + "/HDWiFiCam/video/ALLFile/";
    public static final String FILE_NAME = "crashHE";
    public static final String FILE_NAME_SUFFIX = ".txt";
    public static final String ABOLUTE_PATH = PATH + FILE_NAME + FILE_NAME_SUFFIX;
    public static CrashHandler sInstance = new CrashHandler();

    private File dumpExceptionToSDCard(Throwable th) throws IOException {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            Log.w(TAG, "sdcard unmounted,skip dump exception");
            return null;
        }
        File file = new File(PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
        File file2 = new File(PATH + FILE_NAME + FILE_NAME_SUFFIX);
        if (file2.exists()) {
            try {
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file2, true)));
                printWriter.println(format);
                dumpPhoneInfo(printWriter);
                printWriter.println();
                th.printStackTrace(printWriter);
                printWriter.println("---------------------------------分割线----------------------------------");
                printWriter.println();
                printWriter.close();
            } catch (Exception unused) {
                Log.e(TAG, "dump crash info failed");
            }
        } else {
            file2.createNewFile();
        }
        return file2;
    }

    private void dumpPhoneInfo(PrintWriter printWriter) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 1);
        printWriter.print("App Version: ");
        printWriter.print(packageInfo.versionName);
        printWriter.print('_');
        printWriter.println(packageInfo.versionCode);
        printWriter.print("OS Version: ");
        printWriter.print(Build.VERSION.RELEASE);
        printWriter.print("_");
        printWriter.println(Build.VERSION.SDK_INT);
        printWriter.print("Vendor: ");
        printWriter.println(Build.MANUFACTURER);
        printWriter.print("Model: ");
        printWriter.println(Build.MODEL);
        printWriter.print("CPU ABI: ");
        printWriter.println(Build.CPU_ABI);
    }

    public static CrashHandler getInstance() {
        return sInstance;
    }

    public void init(Context context) {
        this.mDefaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.mContext = context.getApplicationContext();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            dumpExceptionToSDCard(th);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        th.printStackTrace();
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultCrashHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
