package cn.jpush.android.x;

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
    public static Queue<cn.jpush.android.d.a> f9963a;

    public static synchronized void a(Context context, String str) {
        synchronized (d.class) {
            if (context == null) {
                cn.jpush.android.r.b.f("MsgQueueUtils", "unexcepted , context is null");
                return;
            }
            File filesDir = context.getFilesDir();
            if (filesDir == null) {
                cn.jpush.android.r.b.f("MsgQueueUtils", "can't get files dir");
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
            cn.jpush.android.r.b.a("MsgQueueUtils", "Action - saveObjects");
            if (context == null) {
                cn.jpush.android.r.b.f("MsgQueueUtils", "unexcepted , context is null");
                return;
            }
            if (arrayList == null) {
                cn.jpush.android.r.b.f("MsgQueueUtils", "mObjectList is null");
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
                cn.jpush.android.r.b.g("MsgQueueUtils", "save Objects  error:" + th.getMessage());
            }
        }
    }

    public static boolean a(Context context, cn.jpush.android.d.a aVar) {
        if (f9963a == null) {
            f9963a = new ConcurrentLinkedQueue();
            try {
                ArrayList<cn.jpush.android.d.a> b2 = b(context, "ad_msg_queue");
                if (b2 != null && !b2.isEmpty()) {
                    Iterator<cn.jpush.android.d.a> it = b2.iterator();
                    while (it.hasNext()) {
                        f9963a.offer(it.next());
                    }
                }
            } catch (Exception e2) {
                cn.jpush.android.r.b.g("MsgQueueUtils", "init lastMsgQueue failed:" + e2.getMessage());
            }
        }
        if (context == null) {
            cn.jpush.android.r.b.g("MsgQueueUtils", "#unexcepted - context was null");
            return false;
        }
        if (aVar == null) {
            cn.jpush.android.r.b.g("MsgQueueUtils", "#unexcepted - entityKey was null");
        }
        if (f9963a.contains(aVar)) {
            cn.jpush.android.r.b.h("MsgQueueUtils", "Duplicated msg. Give up processing - " + aVar);
            return true;
        }
        if (f9963a.size() >= 200) {
            f9963a.poll();
        }
        f9963a.offer(aVar);
        try {
            ArrayList<cn.jpush.android.d.a> b3 = b(context, "ad_msg_queue");
            if (b3 == null) {
                b3 = new ArrayList<>();
            }
            if (b3.size() >= 50) {
                b3.remove(0);
            }
            b3.add(aVar);
            a(context, "ad_msg_queue", b3);
        } catch (Exception e3) {
            cn.jpush.android.r.b.g("MsgQueueUtils", "msg save in sp failed:" + e3.getMessage());
        }
        return false;
    }

    public static synchronized ArrayList<cn.jpush.android.d.a> b(Context context, String str) {
        FileInputStream fileInputStream;
        Throwable th;
        synchronized (d.class) {
            FileInputStream fileInputStream2 = null;
            if (context == null) {
                cn.jpush.android.r.b.f("MsgQueueUtils", "unexcepted , context is null");
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
                            cn.jpush.android.r.b.f("MsgQueueUtils", "load objects error:" + th.getMessage());
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
