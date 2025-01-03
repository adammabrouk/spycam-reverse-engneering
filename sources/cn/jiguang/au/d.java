package cn.jiguang.au;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.e.c;
import cn.jiguang.internal.ActionManager;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static String f8366a;

    /* renamed from: b, reason: collision with root package name */
    public static String f8367b;

    /* renamed from: c, reason: collision with root package name */
    public static ConcurrentHashMap<File, Boolean> f8368c = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f8369d = new AtomicBoolean(false);

    public static File a(Context context, String str) {
        return new File(e(context) + str + File.separator + UUID.randomUUID().toString());
    }

    public static File a(Context context, String str, JSONObject jSONObject, boolean z) {
        File a2 = a(context, str);
        if (z) {
            b(a2);
        }
        cn.jiguang.e.c.c(a2, jSONObject.toString());
        return a2;
    }

    public static FileFilter a() {
        return new FileFilter() { // from class: cn.jiguang.au.d.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return (file.getName().length() == 24 || file.getName().equals("0")) ? false : true;
            }
        };
    }

    public static void a(Context context) {
        c.a aVar = new c.a(false, true, "jpush_stat_history", 1);
        String e2 = cn.jiguang.d.a.e(context);
        File[] a2 = cn.jiguang.e.c.a(context.getFilesDir(), aVar, a());
        if (a2 != null) {
            for (File file : a2) {
                try {
                    cn.jiguang.e.c.e(new File(file, "nowrap"));
                    File file2 = new File(file.getParent() + File.separator + e2 + File.separator + file.getName());
                    if (!file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    file.renameTo(file2);
                } catch (Throwable th) {
                    cn.jiguang.as.d.c("updateByAppKey", "e=" + th);
                }
            }
        }
    }

    public static void a(Context context, File file) {
        if (((Long) cn.jiguang.f.b.a(context, cn.jiguang.f.a.c())).longValue() == 0) {
            cn.jiguang.as.d.c("ReportHistory", "can't get uid, skip upload history");
            return;
        }
        File[] a2 = cn.jiguang.e.c.a(file, c.a.f8866a);
        if (a2 == null || a2.length == 0) {
            return;
        }
        LinkedList<File> linkedList = new LinkedList();
        for (File file2 : a2) {
            if (!Boolean.TRUE.equals(f8368c.get(file2))) {
                linkedList.add(file2);
            }
        }
        if (linkedList.isEmpty()) {
            return;
        }
        cn.jiguang.as.d.c("ReportHistory", "process space=" + e(file) + " history[" + linkedList.size() + "]");
        Collections.sort(linkedList, new Comparator<File>() { // from class: cn.jiguang.au.d.4
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(File file3, File file4) {
                long lastModified = file3.lastModified() - file4.lastModified();
                if (lastModified < 0) {
                    return 1;
                }
                return lastModified == 0 ? 0 : -1;
            }
        });
        for (File file3 : linkedList) {
            try {
                JSONObject a3 = c.a(file3);
                if (a3 == null) {
                    cn.jiguang.e.c.a(file3);
                } else {
                    b(file3);
                    Set<String> a4 = f.a(a3);
                    cn.jiguang.as.d.c("ReportHistory", "report history types=" + a4);
                    if (f.a(context, a4, a3, file3, null) == -2) {
                        return;
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.as.d.g("ReportHistory", "upload e:" + th);
            }
        }
    }

    public static void a(Context context, String... strArr) {
        FileFilter[] fileFilterArr;
        if (strArr == null || strArr.length == 0) {
            fileFilterArr = new FileFilter[1];
        } else {
            fileFilterArr = new FileFilter[strArr.length + 1];
            int i2 = 0;
            while (i2 < strArr.length) {
                int i3 = i2 + 1;
                fileFilterArr[i3] = c.a.a(strArr[i2]);
                i2 = i3;
            }
        }
        fileFilterArr[0] = new c.a(false, true, "jpush_stat_history", 1);
        File[] a2 = cn.jiguang.e.c.a(context.getFilesDir(), fileFilterArr);
        if (a2 != null) {
            for (File file : a2) {
                cn.jiguang.e.c.e(file);
            }
        }
    }

    public static void a(File file) {
        if (file != null) {
            f8368c.remove(file);
        }
    }

    public static Set<String> b() {
        HashSet hashSet = new HashSet();
        hashSet.add("uid");
        hashSet.add("app_key");
        hashSet.add("sdk_ver");
        hashSet.add("channel");
        hashSet.add("app_version");
        JSONObject jSONObject = new JSONObject();
        ActionManager.getInstance().wrapSdkVersionInfo(jSONObject);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet;
    }

    public static void b(final Context context) {
        cn.jiguang.bj.b bVar;
        String str;
        if (f8369d.get()) {
            cn.jiguang.as.d.c("ReportHistory", "isRunning, no need report");
            return;
        }
        String str2 = "ReportHistory#submitReportAll";
        if (TextUtils.isEmpty(cn.jiguang.ao.d.c(context)) || !context.getPackageName().equals(cn.jiguang.e.a.a(context))) {
            bVar = new cn.jiguang.bj.b(str2) { // from class: cn.jiguang.au.d.3
                @Override // cn.jiguang.bj.b
                public void a() {
                    d.f(context);
                }
            };
            str = "NORMAL_TASK";
        } else {
            bVar = new cn.jiguang.bj.b(str2) { // from class: cn.jiguang.au.d.2
                @Override // cn.jiguang.bj.b
                public void a() {
                    d.f(context);
                }
            };
            str = "MAJOR_TASK";
        }
        cn.jiguang.bj.d.a(str, bVar);
    }

    public static void b(Context context, File file) {
        try {
            JSONObject a2 = f.a(context);
            if (cn.jiguang.e.d.c(a2)) {
                return;
            }
            File[] a3 = cn.jiguang.e.c.a(new File(file, "nowrap"), c.a.f8866a);
            if (a3 != null && a3.length != 0) {
                cn.jiguang.as.d.c("ReportHistory", "process space=" + e(file) + " nowrap[" + a3.length + "]");
                File file2 = new File(file, "tmp");
                c a4 = c.a(a3[0], a2);
                for (int i2 = 1; i2 < a3.length; i2++) {
                    c a5 = c.a(a3[i2], a2);
                    if (a5 != null) {
                        if (a4 != null && a4.a(a5, file2)) {
                        }
                        a4 = a5;
                    }
                }
                if (a4 != null) {
                    a4.a((c) null, file2);
                }
            }
        } catch (Throwable th) {
            cn.jiguang.as.d.g("ReportHistory", "processNowrap e:" + th);
        }
    }

    public static void b(File file) {
        if (file != null) {
            f8368c.put(file, true);
        }
    }

    public static void c(Context context, File file) {
        cn.jiguang.as.d.c("ReportHistory", "upload space=" + e(file));
        b(context, file);
        d(file);
        a(context, file);
        c(file);
    }

    public static void c(File file) {
        int i2 = 0;
        File[] a2 = cn.jiguang.e.c.a(file, c.a.f8866a);
        if (a2 == null || a2.length <= 1) {
            return;
        }
        List<File> asList = Arrays.asList(a2);
        Collections.sort(asList, new Comparator<File>() { // from class: cn.jiguang.au.d.5
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(File file2, File file3) {
                long lastModified = file2.lastModified() - file3.lastModified();
                if (lastModified < 0) {
                    return 1;
                }
                return lastModified == 0 ? 0 : -1;
            }
        });
        for (File file2 : asList) {
            i2 = (int) (i2 + file2.length());
            if (i2 > 1048576) {
                cn.jiguang.e.c.a(file2);
            }
        }
        if (asList.size() < a2.length) {
            cn.jiguang.as.d.c("ReportHistory", "trim space history=" + e(file) + "," + a2.length + " to " + asList.size());
        }
    }

    public static synchronized String d(Context context) {
        String str;
        String replaceFirst;
        synchronized (d.class) {
            if (!TextUtils.isEmpty(f8367b)) {
                return f8367b;
            }
            if (f8366a == null) {
                String a2 = cn.jiguang.e.a.a(context);
                if (!TextUtils.isEmpty(a2)) {
                    if (a2.equals(context.getPackageName())) {
                        replaceFirst = "";
                    } else {
                        replaceFirst = a2.replaceFirst(context.getPackageName() + ":", "_");
                    }
                    f8366a = replaceFirst;
                }
            }
            if (f8366a != null) {
                str = "jpush_stat_history" + f8366a;
            } else {
                str = "jpush_stat_history";
            }
            File a3 = cn.jiguang.e.c.a(context, str);
            if (a3 != null) {
                String absolutePath = a3.getAbsolutePath();
                f8367b = absolutePath;
                return absolutePath;
            }
            return "jpush_stat_history" + f8366a;
        }
    }

    public static void d(File file) {
        try {
            File[] a2 = cn.jiguang.e.c.a(new File(file, "tmp"), c.a.f8866a);
            if (a2 != null && a2.length != 0) {
                LinkedList linkedList = new LinkedList();
                for (File file2 : a2) {
                    if (!Boolean.TRUE.equals(f8368c.get(file2))) {
                        linkedList.add(file2);
                    }
                }
                if (linkedList.isEmpty()) {
                    return;
                }
                cn.jiguang.as.d.c("ReportHistory", "process space=" + e(file) + " tmp[" + linkedList.size() + "]");
                Set<String> b2 = b();
                HashMap hashMap = new HashMap();
                c a3 = c.a(cn.jiguang.e.c.a(cn.jiguang.e.c.a(file, c.a.f8866a)), b2);
                if (a3 != null) {
                    hashMap.put(String.valueOf(a3.f8361b), a3);
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    c a4 = c.a((File) it.next(), b2);
                    if (a4 != null) {
                        String valueOf = String.valueOf(a4.f8361b);
                        c cVar = (c) hashMap.get(valueOf);
                        if (cVar != null && cVar.a(a4, file)) {
                        }
                        hashMap.put(valueOf, a4);
                    }
                }
                Iterator it2 = hashMap.values().iterator();
                while (it2.hasNext()) {
                    ((c) it2.next()).a((c) null, file);
                }
            }
        } catch (Throwable th) {
            cn.jiguang.as.d.g("ReportHistory", "processTmp e:" + th);
        }
    }

    public static String e(Context context) {
        String e2 = cn.jiguang.d.a.e(context);
        if (TextUtils.isEmpty(e2)) {
            e2 = "0";
        }
        return d(context) + File.separator + e2;
    }

    public static String e(File file) {
        try {
            File parentFile = file.getParentFile();
            return parentFile.getParentFile().getName() + File.separator + parentFile.getName() + File.separator + file.getName();
        } catch (Throwable unused) {
            return file.getAbsolutePath();
        }
    }

    public static void f(Context context) {
        try {
            f8369d.set(true);
            File[] a2 = cn.jiguang.e.c.a(e(context), c.a.f8867b);
            if (a2 != null) {
                for (File file : a2) {
                    c(context, file);
                }
            } else {
                cn.jiguang.as.d.c("ReportHistory", "no history, no report");
            }
        } finally {
            try {
            } finally {
            }
        }
    }
}
