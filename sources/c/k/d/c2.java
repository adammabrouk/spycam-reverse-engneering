package c.k.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class c2 {

    /* renamed from: h, reason: collision with root package name */
    public static String f7016h = "/MiPushLog";

    /* renamed from: b, reason: collision with root package name */
    public String f7018b;

    /* renamed from: c, reason: collision with root package name */
    public String f7019c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7020d;

    /* renamed from: e, reason: collision with root package name */
    public int f7021e;

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"SimpleDateFormat"})
    public final SimpleDateFormat f7017a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: f, reason: collision with root package name */
    public int f7022f = 2097152;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<File> f7023g = new ArrayList<>();

    public c2 a(File file) {
        if (file.exists()) {
            this.f7023g.add(file);
        }
        return this;
    }

    public c2 a(Date date, Date date2) {
        String format;
        if (date.after(date2)) {
            this.f7018b = this.f7017a.format(date2);
            format = this.f7017a.format(date);
        } else {
            this.f7018b = this.f7017a.format(date);
            format = this.f7017a.format(date2);
        }
        this.f7019c = format;
        return this;
    }

    public File a(Context context, Date date, Date date2, File file) {
        File file2;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            file2 = context.getFilesDir();
            a(new File(file2, "xmsf.log.1"));
            a(new File(file2, "xmsf.log"));
        } else {
            File file3 = new File(context.getExternalFilesDir(null) + f7016h);
            a(new File(file3, "log0.txt"));
            a(new File(file3, "log1.txt"));
            file2 = file3;
        }
        if (!file2.isDirectory()) {
            return null;
        }
        File file4 = new File(file, date.getTime() + "-" + date2.getTime() + ".zip");
        if (file4.exists()) {
            return null;
        }
        a(date, date2);
        long currentTimeMillis = System.currentTimeMillis();
        File file5 = new File(file, "log.txt");
        m119a(file5);
        c.k.a.a.a.c.c("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
        if (file5.exists()) {
            long currentTimeMillis2 = System.currentTimeMillis();
            v9.a(file4, file5);
            c.k.a.a.a.c.c("LOG: zip cost = " + (System.currentTimeMillis() - currentTimeMillis2));
            file5.delete();
            if (file4.exists()) {
                return file4;
            }
        }
        return null;
    }

    public void a(int i2) {
        if (i2 != 0) {
            this.f7022f = i2;
        }
    }

    public final void a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        boolean z = false;
        while (read != -1 && !z) {
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= read || !matcher.find(i2)) {
                    break;
                }
                int start = matcher.start();
                String substring = str.substring(start, this.f7018b.length() + start);
                if (this.f7020d) {
                    if (substring.compareTo(this.f7019c) > 0) {
                        read = start;
                        z = true;
                        break;
                    }
                } else if (substring.compareTo(this.f7018b) >= 0) {
                    this.f7020d = true;
                    i3 = start;
                }
                int indexOf = str.indexOf(10, start);
                if (indexOf == -1) {
                    indexOf = this.f7018b.length();
                }
                i2 = start + indexOf;
            }
            if (this.f7020d) {
                int i4 = read - i3;
                this.f7021e += i4;
                bufferedWriter.write(cArr, i3, i4);
                if (z || this.f7021e > this.f7022f) {
                    return;
                }
            }
            read = bufferedReader.read(cArr);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public final void m119a(File file) {
        BufferedReader bufferedReader;
        String str;
        Pattern compile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        BufferedReader bufferedReader2 = null;
        try {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    bufferedWriter.write("model :" + Build.MODEL + "; os :" + Build.VERSION.INCREMENTAL + "; uid :" + c.k.d.p9.h0.m381a() + "; lng :" + Locale.getDefault().toString() + "; sdk :39; andver :" + Build.VERSION.SDK_INT + OSSUtils.NEW_LINE);
                    this.f7021e = 0;
                    Iterator<File> it = this.f7023g.iterator();
                    while (it.hasNext()) {
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(it.next())));
                        try {
                            a(bufferedReader, bufferedWriter, compile);
                            bufferedReader.close();
                            bufferedReader2 = bufferedReader;
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            bufferedReader2 = bufferedWriter;
                            str = "LOG: filter error = " + e.getMessage();
                            c.k.a.a.a.c.c(str);
                            v9.a(bufferedReader2);
                            v9.a(bufferedReader);
                            return;
                        } catch (IOException e3) {
                            e = e3;
                            bufferedReader2 = bufferedWriter;
                            str = "LOG: filter error = " + e.getMessage();
                            c.k.a.a.a.c.c(str);
                            v9.a(bufferedReader2);
                            v9.a(bufferedReader);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedWriter;
                            v9.a(bufferedReader2);
                            v9.a(bufferedReader);
                            throw th;
                        }
                    }
                    bufferedWriter.write(u1.a().c());
                    v9.a(bufferedWriter);
                    v9.a(bufferedReader2);
                } catch (FileNotFoundException e4) {
                    e = e4;
                    bufferedReader = bufferedReader2;
                } catch (IOException e5) {
                    e = e5;
                    bufferedReader = bufferedReader2;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                bufferedReader = null;
            } catch (IOException e7) {
                e = e7;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
