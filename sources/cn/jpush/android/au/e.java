package cn.jpush.android.au;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static List<cn.jpush.android.d.d> f9377a = null;

    /* renamed from: b, reason: collision with root package name */
    public static int f9378b = 10;

    public static synchronized int a(Context context) {
        int size;
        synchronized (e.class) {
            if (f9377a == null) {
                f9377a = new LinkedList();
                ArrayList<cn.jpush.android.d.d> b2 = b(context, "notify_inapp_data");
                if (b2 != null && !b2.isEmpty()) {
                    f9377a.addAll(b2);
                }
            }
            size = f9377a.size();
        }
        return size;
    }

    public static synchronized void a(Context context, cn.jpush.android.d.d dVar) {
        ArrayList<cn.jpush.android.d.d> arrayList;
        boolean z;
        synchronized (e.class) {
            try {
            } finally {
            }
            if (dVar == null) {
                cn.jpush.android.r.b.g("NotifyInAppListUtils", "#unexcepted -  message is null");
                return;
            }
            f9378b = dVar.av > 0 ? dVar.av : 10;
            if (f9377a == null) {
                f9377a = new LinkedList();
                z = true;
                arrayList = b(context, "notify_inapp_data");
                if (arrayList != null && !arrayList.isEmpty()) {
                    f9377a.addAll(arrayList);
                }
            } else {
                arrayList = null;
                z = false;
            }
            if (a(dVar)) {
                cn.jpush.android.r.b.b("NotifyInAppListUtils", "the notify message cache already, messageId: " + dVar.f9700d);
                return;
            }
            if (f9377a.size() >= f9378b) {
                for (List<cn.jpush.android.d.d> list = f9377a; list.size() >= f9378b; list = f9377a) {
                    f9377a.remove(0);
                }
            }
            f9377a.add(dVar);
            cn.jpush.android.r.b.b("NotifyInAppListUtils", "notify in app cache, current size is " + f9377a.size() + ", cache max size: " + f9378b);
            if (!z) {
                arrayList = b(context, "notify_inapp_data");
            }
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (arrayList.size() >= f9378b) {
                arrayList.remove(0);
            }
            arrayList.add(dVar);
            a(context, "notify_inapp_data", arrayList);
        }
    }

    public static void a(Context context, String str, ArrayList<cn.jpush.android.d.d> arrayList) {
        String str2;
        cn.jpush.android.r.b.a("NotifyInAppListUtils", "Action - saveObjects");
        if (context == null) {
            str2 = "unexcepted , context is null";
        } else {
            if (arrayList != null && arrayList.size() > 0) {
                try {
                    File a2 = cn.jpush.android.bm.c.a(context, str);
                    if (a2 == null) {
                        cn.jpush.android.r.b.f("NotifyInAppListUtils", "file is null");
                        return;
                    }
                    new JSONArray();
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        }
                        cn.jpush.android.d.d dVar = arrayList.get(size);
                        if (dVar != null) {
                            if (TextUtils.isEmpty(dVar.au) || cn.jpush.android.bm.b.b(dVar.au) > System.currentTimeMillis()) {
                                arrayList2.add(0, dVar.c());
                                if (arrayList2.size() == f9378b) {
                                    cn.jpush.android.r.b.b("NotifyInAppListUtils", "[saveObjects] reach max cache message count: " + f9378b + ", drop message count: " + (arrayList.size() - f9378b));
                                    break;
                                }
                            } else {
                                cn.jpush.android.r.b.c("NotifyInAppListUtils", "message out of date, endTime: " + dVar.au);
                                cn.jpush.android.helper.c.a(dVar.f9700d, 1603, context);
                            }
                        }
                        size--;
                    }
                    JSONArray jSONArray = new JSONArray((Collection) arrayList2);
                    cn.jpush.android.r.b.b("NotifyInAppListUtils", "save object to file, size: " + jSONArray.length());
                    cn.jpush.android.bm.c.a(a2.getAbsolutePath(), jSONArray.toString());
                    return;
                } catch (Throwable th) {
                    cn.jpush.android.r.b.g("NotifyInAppListUtils", "save Objects  error:" + th.getMessage());
                    return;
                }
            }
            str2 = "mObjectList is null or size is 0";
        }
        cn.jpush.android.r.b.f("NotifyInAppListUtils", str2);
    }

    public static synchronized boolean a(Context context, String str) {
        boolean z;
        String str2;
        synchronized (e.class) {
            ArrayList<cn.jpush.android.d.d> arrayList = null;
            try {
                if (f9377a == null) {
                    f9377a = new LinkedList();
                    arrayList = b(context, "notify_inapp_data");
                    if (arrayList != null && !arrayList.isEmpty()) {
                        f9377a.addAll(arrayList);
                    }
                    z = true;
                } else {
                    z = false;
                }
                if (f9377a.size() <= 0) {
                    return false;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= f9377a.size()) {
                        break;
                    }
                    cn.jpush.android.d.d dVar = f9377a.get(i3);
                    if (dVar != null && dVar.f9700d.equals(str)) {
                        f9377a.remove(i3);
                        cn.jpush.android.r.b.b("NotifyInAppListUtils", "cancel notify in app, delete from cache msgId: " + str);
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return false;
                }
                if (f9377a.size() != 0) {
                    if (!z) {
                        arrayList = b(context, "notify_inapp_data");
                    }
                    if (arrayList != null && arrayList.size() >= i2 + 1) {
                        arrayList.remove(i2);
                        if (arrayList.size() > 0) {
                            a(context, "notify_inapp_data", arrayList);
                        } else {
                            str2 = "notify_inapp_data";
                        }
                    }
                    return true;
                }
                str2 = "notify_inapp_data";
                c(context, str2);
                return true;
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("NotifyInAppListUtils", "get notify inapp message failed, " + th.getMessage());
                return false;
            }
        }
    }

    public static boolean a(cn.jpush.android.d.d dVar) {
        if (f9377a.size() <= 0) {
            return false;
        }
        if (dVar == null) {
            return true;
        }
        Iterator<cn.jpush.android.d.d> it = f9377a.iterator();
        while (it.hasNext()) {
            if (it.next().f9700d.equals(dVar.f9700d)) {
                return true;
            }
        }
        return false;
    }

    public static synchronized cn.jpush.android.d.d b(Context context) {
        ArrayList<cn.jpush.android.d.d> arrayList;
        int size;
        String str;
        synchronized (e.class) {
            boolean z = false;
            cn.jpush.android.d.d dVar = null;
            try {
                if (f9377a == null) {
                    f9377a = new LinkedList();
                    ArrayList<cn.jpush.android.d.d> b2 = b(context, "notify_inapp_data");
                    if (b2 != null && !b2.isEmpty()) {
                        f9377a.addAll(b2);
                    }
                    arrayList = b2;
                    z = true;
                } else {
                    arrayList = null;
                }
                size = f9377a.size();
            } catch (Throwable th) {
                th = th;
            }
            if (size <= 0) {
                return null;
            }
            int i2 = size - 1;
            cn.jpush.android.d.d dVar2 = f9377a.get(i2);
            try {
                f9377a.remove(i2);
            } catch (Throwable th2) {
                th = th2;
                dVar = dVar2;
                cn.jpush.android.r.b.f("NotifyInAppListUtils", "get notify inapp message failed, " + th.getMessage());
                dVar2 = dVar;
                cn.jpush.android.r.b.b("NotifyInAppListUtils", "get notify in app, current size is " + f9377a.size());
                return dVar2;
            }
            if (f9377a.size() != 0) {
                if (!z) {
                    arrayList = b(context, "notify_inapp_data");
                }
                if (arrayList != null && arrayList.size() > 0) {
                    arrayList.remove(arrayList.size() - 1);
                    if (arrayList.size() > 0) {
                        a(context, "notify_inapp_data", arrayList);
                    } else {
                        str = "notify_inapp_data";
                    }
                }
                cn.jpush.android.r.b.b("NotifyInAppListUtils", "get notify in app, current size is " + f9377a.size());
                return dVar2;
            }
            str = "notify_inapp_data";
            c(context, str);
            cn.jpush.android.r.b.b("NotifyInAppListUtils", "get notify in app, current size is " + f9377a.size());
            return dVar2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0084, code lost:
    
        cn.jpush.android.r.b.b("NotifyInAppListUtils", "[loadObjects] reach max cache message count: " + cn.jpush.android.au.e.f9378b + ", drop message count: " + (r3.length() - cn.jpush.android.au.e.f9378b));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<cn.jpush.android.d.d> b(android.content.Context r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.au.e.b(android.content.Context, java.lang.String):java.util.ArrayList");
    }

    public static void c(Context context, String str) {
        String str2;
        if (context == null) {
            str2 = "unexcepted , context is null";
        } else {
            File a2 = cn.jpush.android.bm.c.a(context, str);
            if (a2 != null) {
                if (a2.exists()) {
                    a2.delete();
                    return;
                }
                return;
            }
            str2 = "can't get files dir";
        }
        cn.jpush.android.r.b.f("NotifyInAppListUtils", str2);
    }
}
