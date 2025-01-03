package cn.jiguang.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.jiguang.bj.d;
import cn.jiguang.bk.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, SharedPreferences> f8881a = new ConcurrentHashMap();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static Handler f8884a;

        /* renamed from: b, reason: collision with root package name */
        public static final Object f8885b = new Object();

        /* renamed from: c, reason: collision with root package name */
        public static final LinkedList<Runnable> f8886c = new LinkedList<>();

        /* renamed from: d, reason: collision with root package name */
        public static boolean f8887d = true;

        /* renamed from: e, reason: collision with root package name */
        public static final Object f8888e = new Object();

        /* renamed from: cn.jiguang.f.b$a$a, reason: collision with other inner class name */
        public static class HandlerC0139a extends Handler {
            public HandlerC0139a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    d.a("FUTURE_TASK", new cn.jiguang.bj.b() { // from class: cn.jiguang.f.b.a.a.1
                        @Override // cn.jiguang.bj.b
                        public void a() {
                            a.c();
                        }
                    });
                }
            }
        }

        public static void a(Runnable runnable, boolean z) {
            try {
                Handler b2 = b();
                if (b2 != null) {
                    synchronized (f8885b) {
                        f8886c.add(runnable);
                        if (z && f8887d) {
                            b2.sendEmptyMessageDelayed(1, 100L);
                        } else {
                            b2.sendEmptyMessage(1);
                        }
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.as.d.g("Sp", "sp task add queue failed, " + th.getMessage());
            }
        }

        public static Handler b() {
            if (f8884a == null) {
                synchronized (f8885b) {
                    if (f8884a == null) {
                        f8884a = new HandlerC0139a(Looper.getMainLooper());
                    }
                }
            }
            return f8884a;
        }

        public static void c() {
            LinkedList linkedList;
            try {
                System.currentTimeMillis();
                synchronized (f8888e) {
                    synchronized (f8885b) {
                        linkedList = (LinkedList) f8886c.clone();
                        f8886c.clear();
                        Handler b2 = b();
                        if (b2 != null) {
                            b2.removeMessages(1);
                        }
                    }
                    if (linkedList.size() > 0) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            ((Runnable) it.next()).run();
                        }
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.as.d.g("Sp", "sp commit task error, " + th.getMessage());
            }
        }
    }

    public static <T> T a(Context context, cn.jiguang.f.a<T> aVar) {
        T t = (T) b(context, aVar);
        return t != null ? t : aVar.f8878e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T a(SharedPreferences sharedPreferences, String str, T t) {
        if (sharedPreferences != null && sharedPreferences.contains(str)) {
            try {
                if (t instanceof Boolean) {
                    return (T) Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) t).booleanValue()));
                }
                if (t instanceof String) {
                    return (T) sharedPreferences.getString(str, (String) t);
                }
                if (t instanceof Integer) {
                    return (T) Integer.valueOf(sharedPreferences.getInt(str, ((Integer) t).intValue()));
                }
                if (t instanceof Long) {
                    return (T) Long.valueOf(sharedPreferences.getLong(str, ((Long) t).longValue()));
                }
                if (t instanceof Float) {
                    return (T) Float.valueOf(sharedPreferences.getFloat(str, ((Float) t).floatValue()));
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(Context context, cn.jiguang.f.a<T> aVar, cn.jiguang.f.a<T> aVar2) {
        Object b2;
        if (b(context, aVar) != null || (b2 = b(context, aVar2)) == null) {
            return;
        }
        a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{aVar.a((cn.jiguang.f.a<T>) b2)});
        a(context, (cn.jiguang.f.a<?>[]) new cn.jiguang.f.a[]{aVar2.a((cn.jiguang.f.a<T>) null)});
    }

    public static void a(Context context, String str) {
        SharedPreferences e2 = e(context, str);
        if (e2 != null) {
            e2.edit().clear().apply();
        }
    }

    public static void a(final Context context, boolean z, final cn.jiguang.f.a<?>... aVarArr) {
        try {
            cn.jiguang.bj.b bVar = new cn.jiguang.bj.b() { // from class: cn.jiguang.f.b.1
                @Override // cn.jiguang.bj.b
                public void a() {
                    SharedPreferences e2;
                    try {
                        HashMap hashMap = new HashMap();
                        for (cn.jiguang.f.a aVar : aVarArr) {
                            SharedPreferences.Editor editor = (SharedPreferences.Editor) hashMap.get(aVar.f8876c);
                            if (editor == null && (e2 = b.e(context, aVar.f8876c)) != null) {
                                editor = e2.edit();
                                hashMap.put(aVar.f8876c, editor);
                            }
                            b.b(editor, aVar.f8877d, aVar.f8878e, aVar.f8880g);
                        }
                        for (String str : hashMap.keySet()) {
                            SharedPreferences.Editor editor2 = (SharedPreferences.Editor) hashMap.get(str);
                            if (editor2 != null && !editor2.commit()) {
                                cn.jiguang.as.d.g("Sp", "sp commit failed, sp_file: " + str);
                            }
                        }
                    } catch (Throwable th) {
                        cn.jiguang.as.d.g("Sp", "sp commit failed, " + th.getMessage());
                    }
                }
            };
            if (z) {
                a.a(bVar, false);
            } else {
                bVar.run();
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, cn.jiguang.f.a<?>... aVarArr) {
        if (aVarArr == null || aVarArr.length <= 0) {
            return;
        }
        if (!a()) {
            b(context, aVarArr);
        } else {
            cn.jiguang.as.d.c("Sp", "main thread, async sp set");
            a(context, true, aVarArr);
        }
    }

    public static boolean a() {
        try {
            return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
        } catch (Throwable th) {
            cn.jiguang.as.d.g("Sp", "[isMainThread] failed:" + th.getMessage());
            return true;
        }
    }

    public static <T> T b(Context context, cn.jiguang.f.a<T> aVar) {
        Object a2 = a(e(context, aVar.f8876c), aVar.f8877d, aVar.f8878e);
        if (a2 == null && aVar.f8879f) {
            a2 = (T) a(d(context, aVar.f8876c), aVar.f8877d, aVar.f8878e);
        }
        if (a2 == null) {
            return null;
        }
        if (aVar.f8880g && (a2 instanceof String)) {
            String str = a2;
            if (str.length() > 0) {
                a2 = (T) e.b(str, cn.jiguang.a.a.f8105i);
            }
        }
        aVar.a((cn.jiguang.f.a<T>) a2);
        return (T) a2;
    }

    public static void b(Context context, cn.jiguang.f.a<?>... aVarArr) {
        if (aVarArr == null || aVarArr.length <= 0) {
            return;
        }
        a(context, false, aVarArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void b(SharedPreferences.Editor editor, String str, T t, boolean z) {
        if (editor != null) {
            if (t == 0) {
                editor.remove(str);
                return;
            }
            if (t instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) t).booleanValue());
                return;
            }
            boolean z2 = t instanceof String;
            String str2 = t;
            if (z2) {
                if (z) {
                    String str3 = (String) t;
                    str2 = t;
                    if (str3.length() > 0) {
                        str2 = (T) e.a(str3, cn.jiguang.a.a.f8105i);
                    }
                }
                editor.putString(str, str2);
                return;
            }
            if (t instanceof Integer) {
                editor.putInt(str, ((Integer) t).intValue());
            } else if (t instanceof Long) {
                editor.putLong(str, ((Long) t).longValue());
            } else if (t instanceof Float) {
                editor.putFloat(str, ((Float) t).floatValue());
            }
        }
    }

    public static void c(Context context, String str) {
        String str2 = (String) a(context, cn.jiguang.f.a.y());
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        str2.startsWith("1.");
    }

    public static SharedPreferences d(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            context.getSharedPreferences(str, 4);
        }
        return context.getSharedPreferences(str, 0);
    }

    public static SharedPreferences e(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SharedPreferences sharedPreferences = f8881a.get(str);
        if (sharedPreferences != null || context == null) {
            return sharedPreferences;
        }
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(str, 0);
        f8881a.put(str, sharedPreferences2);
        c(context, str);
        return sharedPreferences2;
    }
}
