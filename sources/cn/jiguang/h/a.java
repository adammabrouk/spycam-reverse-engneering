package cn.jiguang.h;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.ArrayMap;
import cn.jiguang.internal.JConstants;
import cn.jiguang.m.c;
import com.hjq.permissions.XXPermissions;
import com.shix.shixipc.utilcode.LogUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@TargetApi(19)
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, Integer> f8891a;

    /* renamed from: d, reason: collision with root package name */
    public static Map<Integer, Boolean> f8892d;

    /* renamed from: e, reason: collision with root package name */
    public static ArrayList<Integer> f8893e;

    /* renamed from: f, reason: collision with root package name */
    public static Map<Integer, Integer[]> f8894f;

    /* renamed from: g, reason: collision with root package name */
    public static a f8895g;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList<String[]> f8896b;

    /* renamed from: c, reason: collision with root package name */
    public Map<Integer, cn.jiguang.m.a> f8897c;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8898h = false;

    static {
        ArrayMap arrayMap = new ArrayMap();
        f8891a = arrayMap;
        arrayMap.put("JDevice", 1000);
        f8891a.put("JLocation", 1500);
        f8891a.put("JArp", 1600);
        f8891a.put("JAppAll", Integer.valueOf(LogUtils.MAX_LEN));
        f8891a.put("JAppMovement", 1101);
        f8891a.put("JAppPermission", 1300);
        f8891a.put("JAppRunning", 1102);
        f8891a.put("JAppSdk", 1103);
        f8891a.put("JDeviceBattery", 1200);
        f8891a.put("JLocationv2", 1500);
        f8891a.put("JDeviceIds", 1900);
        f8891a.put("JBt", 2400);
        f8891a.put("uid", 2300);
        f8891a.put("JAppActive", 1104);
        f8892d = new ArrayMap();
        ArrayList<Integer> arrayList = new ArrayList<>();
        f8893e = arrayList;
        arrayList.add(1800);
        ArrayMap arrayMap2 = new ArrayMap();
        f8894f = arrayMap2;
        arrayMap2.put(1022, new Integer[]{1023, 1024, Integer.valueOf(XXPermissions.REQUEST_CODE)});
        f8895g = null;
    }

    private long a(Date date) {
        if (date == null) {
            return 0L;
        }
        Date date2 = new Date();
        date2.setHours(date.getHours());
        date2.setMinutes(date.getMinutes());
        date2.setSeconds(date.getSeconds());
        return (date2.getTime() / 1000) * 1000;
    }

    public static a a() {
        if (f8895g == null) {
            synchronized (a.class) {
                if (f8895g == null) {
                    f8895g = new a();
                }
                f8895g.f8896b = new ArrayList<>();
                f8895g.f8897c = new ArrayMap();
            }
        }
        return f8895g;
    }

    public void a(Context context) {
        if (this.f8898h) {
            return;
        }
        synchronized (a.class) {
            if (this.f8898h) {
                return;
            }
            c.a().b(context);
            this.f8898h = true;
        }
    }

    public void a(cn.jiguang.m.a aVar) {
        int a2;
        try {
            if (this.f8897c == null) {
                this.f8897c = new ArrayMap();
            }
            if (aVar != null && !this.f8897c.containsKey(Integer.valueOf(aVar.a()))) {
                this.f8897c.put(Integer.valueOf(aVar.a()), aVar);
            }
            if (aVar == null || aVar.a() >= 2000 || (a2 = (aVar.a() / 100) * 100) == 1100 || this.f8897c.containsKey(Integer.valueOf(a2))) {
                return;
            }
            cn.jiguang.m.a aVar2 = new cn.jiguang.m.a();
            aVar2.a(a2);
            aVar2.a(true);
            aVar2.b(aVar.c());
            aVar2.d(aVar.e());
            aVar2.c(aVar.d());
            aVar2.e(aVar.f());
            aVar2.f(aVar.g());
            aVar2.g(aVar.h());
            this.f8897c.put(Integer.valueOf(a2), aVar2);
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JDataConfigManager", "addConfig failed :" + th);
        }
    }

    public synchronized void a(String str) {
        try {
            if (f8891a != null) {
                Integer num = f8891a.get(str);
                if (f8892d != null && num != null && !f8892d.containsKey(num)) {
                    cn.jiguang.ai.a.a("JDataConfigManager", "mark first collect delay :" + str + ":" + num);
                    f8892d.put(num, true);
                }
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(int r14) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.h.a.a(int):boolean");
    }

    public synchronized int b(int i2) {
        cn.jiguang.m.a aVar;
        try {
        } finally {
            return 0;
        }
        if (f8892d != null && f8892d.containsKey(Integer.valueOf(i2))) {
            return 0;
        }
        if (this.f8897c != null && this.f8897c.containsKey(Integer.valueOf(i2)) && (aVar = this.f8897c.get(Integer.valueOf(i2))) != null) {
            return aVar.c() * 1000;
        }
        return 0;
    }

    public long b(String str) {
        cn.jiguang.m.a aVar;
        try {
            if (f8891a == null) {
                return JConstants.DAY;
            }
            Integer num = f8891a.get(str);
            return (this.f8897c == null || num == null || !this.f8897c.containsKey(num) || (aVar = this.f8897c.get(num)) == null) ? JConstants.DAY : aVar.e() * 60 * 1000;
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JDataConfigManager", "get clt interval  failed :" + th);
            return JConstants.DAY;
        }
    }

    public void b() {
        this.f8896b = new ArrayList<>();
        this.f8897c = new ArrayMap();
    }

    public int c(int i2) {
        cn.jiguang.m.a aVar;
        try {
            if (this.f8897c == null || !this.f8897c.containsKey(Integer.valueOf(i2)) || (aVar = this.f8897c.get(Integer.valueOf(i2))) == null) {
                return 0;
            }
            return aVar.g();
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JDataConfigManager", "get bg interval  failed :" + th);
            return 0;
        }
    }

    public long c(String str) {
        cn.jiguang.m.a aVar;
        try {
            if (f8891a == null) {
                return JConstants.DAY;
            }
            Integer num = f8891a.get(str);
            return (this.f8897c == null || num == null || !this.f8897c.containsKey(num) || (aVar = this.f8897c.get(num)) == null) ? JConstants.DAY : aVar.f() * 60 * 1000;
        } catch (Throwable th) {
            cn.jiguang.ai.a.d("JDataConfigManager", "get rpt interval  failed :" + th);
            return JConstants.DAY;
        }
    }

    public boolean d(int i2) {
        boolean z = a().a(i2) && !cn.jiguang.l.b.a(i2);
        cn.jiguang.ai.a.a("JDataConfigManager", "configId is " + i2 + ", isCanCollect is " + z);
        return z;
    }

    public boolean e(int i2) {
        boolean a2 = a().a(i2);
        cn.jiguang.ai.a.a("JDataConfigManager", "configId is " + i2 + ", isConfigCanCollect is " + a2);
        return a2;
    }

    public boolean f(int i2) {
        boolean z = !a().a(i2) || cn.jiguang.l.b.a(i2);
        cn.jiguang.ai.a.a("JDataConfigManager", "configId is " + i2 + ", isNotCollect is " + z);
        return z;
    }
}
