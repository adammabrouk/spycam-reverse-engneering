package cn.jpush.android.au;

import android.content.Context;
import cn.jpush.android.bm.k;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static Queue<cn.jpush.android.d.a> f9376a;

    public static ArrayList<cn.jpush.android.d.a> a(Context context) {
        ArrayList<cn.jpush.android.d.a> b2 = b(context, "inmsg_queue_v405");
        if (b2 != null && b2.size() > 0) {
            a(context, "inmsg_queue_v405");
        }
        return b2;
    }

    public static synchronized void a(Context context, String str) {
        synchronized (d.class) {
            if (context == null) {
                cn.jpush.android.r.b.f("InAppMsgQueueUtils", "unexcepted , context is null");
                return;
            }
            File filesDir = context.getFilesDir();
            if (filesDir == null) {
                cn.jpush.android.r.b.f("InAppMsgQueueUtils", "can't get files dir");
                return;
            }
            File file = new File(filesDir, str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static synchronized void a(Context context, String str, ArrayList<cn.jpush.android.d.a> arrayList) {
        synchronized (d.class) {
            cn.jpush.android.r.b.a("InAppMsgQueueUtils", "Action - saveObjects");
            if (context == null) {
                cn.jpush.android.r.b.f("InAppMsgQueueUtils", "unexcepted , context is null");
                return;
            }
            if (arrayList == null) {
                cn.jpush.android.r.b.f("InAppMsgQueueUtils", "mObjectList is null");
                return;
            }
            try {
                File file = new File(context.getFilesDir(), str);
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    jSONArray.put(arrayList.get(i2).a());
                }
                cn.jpush.android.bm.c.a(file.getAbsolutePath(), jSONArray.toString());
            } catch (Throwable th) {
                cn.jpush.android.r.b.g("InAppMsgQueueUtils", "save Objects  error:" + th.getMessage());
            }
        }
    }

    public static boolean a(Context context, cn.jpush.android.d.a aVar, boolean z) {
        if (f9376a == null) {
            f9376a = new ConcurrentLinkedQueue();
            try {
                ArrayList<cn.jpush.android.d.a> b2 = b(context, "inmsg_queue_v405");
                if (b2 != null && !b2.isEmpty()) {
                    Iterator<cn.jpush.android.d.a> it = b2.iterator();
                    while (it.hasNext()) {
                        f9376a.offer(it.next());
                    }
                }
            } catch (Throwable th) {
                cn.jpush.android.r.b.f("InAppMsgQueueUtils", "init exposeMsgQueue failed:" + th.getMessage());
            }
        }
        if (context == null) {
            cn.jpush.android.r.b.f("InAppMsgQueueUtils", "#unexcepted - context was null");
            return false;
        }
        if (aVar == null) {
            cn.jpush.android.r.b.f("InAppMsgQueueUtils", "#unexcepted - entityKey was null");
        }
        if (!f9376a.contains(aVar)) {
            if (z) {
                f9376a.offer(aVar);
                try {
                    ArrayList<cn.jpush.android.d.a> b3 = b(context, "inmsg_queue_v405");
                    if (b3 == null) {
                        b3 = new ArrayList<>();
                    }
                    b3.add(aVar);
                    a(context, "inmsg_queue_v405", b3);
                } catch (Throwable th2) {
                    cn.jpush.android.r.b.f("InAppMsgQueueUtils", "msg save in sp failed:" + th2.getMessage());
                }
            }
            return true;
        }
        if (!z) {
            f9376a.remove(aVar);
            try {
                ArrayList<cn.jpush.android.d.a> b4 = b(context, "inmsg_queue_v405");
                if (b4 == null) {
                    b4 = new ArrayList<>();
                }
                b4.remove(aVar);
                a(context, "inmsg_queue_v405", b4);
            } catch (Throwable th3) {
                cn.jpush.android.r.b.f("InAppMsgQueueUtils", "msg save in sp failed:" + th3.getMessage());
            }
            cn.jpush.android.r.b.b("InAppMsgQueueUtils", "Exposed msg. remove processing - " + aVar);
        }
        return true;
    }

    public static synchronized ArrayList<cn.jpush.android.d.a> b(Context context, String str) {
        FileInputStream fileInputStream;
        Throwable th;
        synchronized (d.class) {
            FileInputStream fileInputStream2 = null;
            if (context == null) {
                cn.jpush.android.r.b.f("InAppMsgQueueUtils", "unexcepted , context is null");
                return null;
            }
            ArrayList<cn.jpush.android.d.a> arrayList = new ArrayList<>();
            try {
                File file = new File(context.getFilesDir(), str);
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        JSONArray jSONArray = new JSONArray(new String(k.a((InputStream) fileInputStream)));
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            arrayList.add(cn.jpush.android.d.a.a(jSONArray.getJSONObject(i2)));
                        }
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            cn.jpush.android.r.b.f("InAppMsgQueueUtils", "load objects error:" + th.getMessage());
                            a(context, str);
                            return arrayList;
                        } finally {
                            k.a((Closeable) fileInputStream);
                        }
                    }
                }
                k.a((Closeable) fileInputStream2);
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
            return arrayList;
        }
    }
}
