package cn.jpush.android.bd;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.bm.k;
import cn.jpush.android.helper.Logger;
import com.shix.shixipc.system.ContentCommon;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    public static int f9509c = 200;

    /* renamed from: f, reason: collision with root package name */
    public static e f9510f;

    /* renamed from: a, reason: collision with root package name */
    public Context f9511a;

    /* renamed from: b, reason: collision with root package name */
    public int f9512b = 100;

    /* renamed from: d, reason: collision with root package name */
    public volatile LinkedHashMap<String, cn.jpush.android.b.b> f9513d;

    /* renamed from: e, reason: collision with root package name */
    public volatile LinkedHashMap<String, cn.jpush.android.b.b> f9514e;

    /* renamed from: g, reason: collision with root package name */
    public a f9515g;

    public interface a {
        void a(cn.jpush.android.b.b bVar);

        void a(cn.jpush.android.b.b bVar, cn.jpush.android.b.b bVar2);

        void a(boolean z);

        void b(cn.jpush.android.b.b bVar);
    }

    public static cn.jpush.android.b.b a(cn.jpush.android.d.d dVar) {
        cn.jpush.android.b.b bVar = new cn.jpush.android.b.b();
        bVar.f9482a = dVar.ah;
        bVar.f9483b = dVar.ai;
        bVar.f9484c = dVar.aj;
        bVar.f9485d = dVar.ak;
        bVar.f9486e = dVar.am;
        bVar.f9487f = dVar.an;
        bVar.f9488g = dVar.ao;
        bVar.f9489h = dVar.ap;
        return bVar;
    }

    public static e a() {
        if (f9510f == null) {
            synchronized (e.class) {
                if (f9510f == null) {
                    f9510f = new e();
                }
            }
        }
        return f9510f;
    }

    private LinkedHashMap<String, cn.jpush.android.b.b> a(Context context, int i2) {
        FileInputStream fileInputStream = null;
        if (context == null) {
            Logger.w("GeofenceDataHelper", "unexcepted , context is null");
            return null;
        }
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap = new LinkedHashMap<>();
        try {
            File a2 = cn.jpush.android.bm.c.a(context, i2 == 2 ? "jpush_geofence_v5_report" : "jpush_geofence_v5");
            if (a2.exists()) {
                FileInputStream fileInputStream2 = new FileInputStream(a2);
                try {
                    JSONObject jSONObject = new JSONObject(new String(k.a((InputStream) fileInputStream2)));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        cn.jpush.android.b.b a3 = cn.jpush.android.b.b.a(context, jSONObject.getJSONObject(keys.next()));
                        if (a3 != null) {
                            linkedHashMap.put(a3.f9482a, a3);
                        }
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    try {
                        Logger.w("GeofenceDataHelper", "load objects error:" + th.getMessage());
                        return linkedHashMap;
                    } finally {
                        k.a((Closeable) fileInputStream);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return linkedHashMap;
    }

    private void a(String str, JSONObject jSONObject, int i2, boolean z) {
        a aVar;
        LinkedHashMap<String, cn.jpush.android.b.b> d2 = d(i2);
        Logger.dd("GeofenceDataHelper", "Before update.Current geofence size:" + d2.size() + ",type:" + i2);
        cn.jpush.android.b.b bVar = d2.get(str);
        if (bVar == null) {
            Logger.ww("GeofenceDataHelper", "can not update geofence because origin one not found");
            return;
        }
        bVar.b(jSONObject);
        if (bVar.f9486e * 1000 <= System.currentTimeMillis()) {
            d2.remove(str);
            a(bVar);
        } else if (z && (aVar = this.f9515g) != null) {
            aVar.a(bVar, bVar);
        }
        e(i2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:0|1|2|3|(1:7)|8|(13:50|(1:(2:69|(1:71)))(2:53|(5:57|(2:60|58)|61|62|(2:64|65)))|14|15|16|(1:18)|19|(1:21)(3:32|(4:35|(3:40|41|42)|43|33)|46)|22|(1:31)|(1:30)|27|28)(1:12)|13|14|15|16|(0)|19|(0)(0)|22|(0)|31|(0)|30|27|28|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00da, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00de, code lost:
    
        cn.jpush.android.helper.Logger.dd("GeofenceDataHelper", "recover geofence failed:" + r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00c0, code lost:
    
        if (r8.f9513d.isEmpty() == false) goto L27;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x015c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0163 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.bd.e.b(android.content.Context):void");
    }

    private boolean b(int i2) {
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap = i2 == 2 ? this.f9514e : this.f9513d;
        boolean z = false;
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            Iterator<Map.Entry<String, cn.jpush.android.b.b>> it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                cn.jpush.android.b.b value = it.next().getValue();
                if (value != null && value.f9486e * 1000 <= System.currentTimeMillis()) {
                    z = true;
                    Logger.dd("GeofenceDataHelper", "Geofence " + value.f9482a + " is out of date!");
                    it.remove();
                }
            }
        }
        return z;
    }

    private void c(int i2) {
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap;
        String str;
        if (i2 == 0) {
            c(2);
            c(1);
            return;
        }
        if (i2 == 2) {
            linkedHashMap = this.f9514e;
            Logger.dd("GeofenceDataHelper", "save report geofence to file");
            str = "jpush_geofence_v5_report";
        } else {
            linkedHashMap = this.f9513d;
            Logger.dd("GeofenceDataHelper", "save show geofence to file");
            str = "jpush_geofence_v5";
        }
        if (linkedHashMap == null) {
            return;
        }
        try {
            File a2 = cn.jpush.android.bm.c.a(this.f9511a, str);
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, cn.jpush.android.b.b> entry : linkedHashMap.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue().a());
            }
            cn.jpush.android.bm.c.a(a2.getAbsolutePath(), jSONObject.toString());
        } catch (Throwable th) {
            Logger.ww("GeofenceDataHelper", "save geo to file error:" + th.getMessage());
        }
    }

    private boolean c(cn.jpush.android.b.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.f9482a) && bVar.f9483b != -1) {
            double d2 = bVar.f9488g;
            if (d2 >= -90.0d && d2 <= 90.0d) {
                double d3 = bVar.f9487f;
                if (d3 >= -180.0d && d3 <= 180.0d) {
                    return true;
                }
            }
        }
        Logger.ww("GeofenceDataHelper", "The geofence is invalid, won't operate!");
        return false;
    }

    private LinkedHashMap<String, cn.jpush.android.b.b> d(int i2) {
        return i2 == 2 ? this.f9514e : this.f9513d;
    }

    private void e(int i2) {
        c(i2);
        a aVar = this.f9515g;
        if (aVar != null) {
            aVar.a(this.f9513d.isEmpty() && this.f9514e.isEmpty());
        }
    }

    private void f(int i2) {
        int size = this.f9513d.size();
        if (size > i2) {
            Logger.dd("GeofenceDataHelper", "ShowGeofence count= " + size + ",limit=" + i2 + ",need remove earliest");
            Iterator<cn.jpush.android.b.b> it = this.f9513d.values().iterator();
            while (it.hasNext() && size > i2) {
                cn.jpush.android.b.b next = it.next();
                if (next != null) {
                    a(next);
                }
                it.remove();
                size--;
            }
        }
    }

    public void a(int i2) {
        cn.jpush.android.cache.a.d(this.f9511a, i2);
        this.f9512b = i2;
        f(i2);
    }

    public synchronized void a(Context context) {
        if (context == null) {
            return;
        }
        this.f9511a = context.getApplicationContext();
        this.f9512b = cn.jpush.android.cache.a.e(context, 10);
        b(context);
        f(this.f9512b);
    }

    public void a(cn.jpush.android.b.b bVar) {
        if (bVar == null || !TextUtils.isEmpty(bVar.f9482a)) {
            int i2 = bVar.f9490i;
            String str = bVar.f9482a;
            LinkedHashMap<String, cn.jpush.android.b.b> d2 = d(i2);
            Logger.dd("GeofenceDataHelper", "Before delete.Current geofence size:" + d2.size() + ",type:" + i2);
            if (d2.remove(str) != null) {
                e(i2);
                a aVar = this.f9515g;
                if (aVar != null) {
                    aVar.b(bVar);
                    return;
                }
                return;
            }
            Logger.d("GeofenceDataHelper", "geofence=" + bVar.f9482a + " already not exists");
        }
    }

    public void a(a aVar) {
        this.f9515g = aVar;
    }

    public void a(String str) {
        Logger.d("GeofenceDataHelper", "will delete geofence=" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        cn.jpush.android.b.b bVar = this.f9513d.get(str);
        cn.jpush.android.b.b bVar2 = this.f9514e.get(str);
        if (bVar != null) {
            a(bVar);
        }
        if (bVar2 != null) {
            a(bVar2);
        }
        if (bVar == null && bVar2 == null) {
            Logger.d("GeofenceDataHelper", "geofence=" + str + " already not exists");
        }
    }

    public void a(String str, JSONObject jSONObject, boolean z) {
        int i2;
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        if (jSONObject.has(ContentCommon.TYPE)) {
            i2 = jSONObject.optInt(ContentCommon.TYPE, 1);
        } else {
            a(str, jSONObject, 1, z);
            i2 = 2;
        }
        a(str, jSONObject, i2, z);
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap = new LinkedHashMap<>();
        int i2 = 0;
        while (true) {
            try {
                if (i2 >= (jSONArray.length() <= f9509c ? jSONArray.length() : f9509c)) {
                    break;
                }
                cn.jpush.android.b.b a2 = cn.jpush.android.b.b.a(jSONArray.getJSONObject(i2));
                linkedHashMap.put(a2.f9482a, a2);
                i2++;
            } catch (Throwable th) {
                Logger.dd("GeofenceDataHelper", "Replace report geofences failed:" + th.getMessage());
                return;
            }
        }
        this.f9514e = linkedHashMap;
        e(2);
        a aVar = this.f9515g;
        if (aVar != null) {
            aVar.a(null, null);
        }
    }

    public LinkedHashMap<String, cn.jpush.android.b.b> b() {
        LinkedHashMap<String, cn.jpush.android.b.b> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.putAll(this.f9514e);
        linkedHashMap.putAll(this.f9513d);
        return linkedHashMap;
    }

    public void b(cn.jpush.android.b.b bVar) {
        StringBuilder sb;
        String str;
        if (c(bVar)) {
            int i2 = bVar.f9490i;
            LinkedHashMap<String, cn.jpush.android.b.b> d2 = d(i2);
            Logger.dd("GeofenceDataHelper", "Before add.Current geofence size:" + d2.size() + ",type:" + i2);
            cn.jpush.android.b.b bVar2 = d2.get(bVar.f9482a);
            if (bVar2 == null) {
                if (i2 == 2 && d2.size() >= f9509c) {
                    sb = new StringBuilder();
                    sb.append("Report geofence size limit :");
                    sb.append(f9509c);
                    sb.append(",won't add geofence");
                    str = bVar.f9482a;
                } else if (bVar.f9486e * 1000 <= System.currentTimeMillis()) {
                    sb = new StringBuilder();
                    sb.append("The geofence ");
                    sb.append(bVar.f9482a);
                    str = " is out of date, will not create!";
                } else {
                    f(this.f9512b - 1);
                    d2.put(bVar.f9482a, bVar);
                    a aVar = this.f9515g;
                    if (aVar != null) {
                        aVar.a(bVar);
                    }
                }
                sb.append(str);
                Logger.dd("GeofenceDataHelper", sb.toString());
                return;
            }
            if (bVar.f9486e * 1000 <= System.currentTimeMillis()) {
                d2.remove(bVar.f9482a);
                a(bVar2);
            } else {
                bVar.a(bVar2);
                d2.put(bVar.f9482a, bVar);
                a aVar2 = this.f9515g;
                if (aVar2 != null) {
                    aVar2.a(bVar2, bVar);
                }
            }
            e(i2);
        }
    }

    public int c() {
        return this.f9513d.size() + this.f9514e.size();
    }
}
