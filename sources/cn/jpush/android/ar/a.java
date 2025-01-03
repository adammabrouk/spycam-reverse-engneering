package cn.jpush.android.ar;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JPushMessageReceiver;
import com.hjq.permissions.XXPermissions;
import com.tencent.bugly.CrashModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends cn.jpush.android.as.d implements cn.jpush.android.as.b {

    /* renamed from: d, reason: collision with root package name */
    public static HashMap<Integer, Integer> f9248d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public static HashMap<Integer, Integer> f9249e = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public cn.jpush.android.as.a f9250a;

    /* renamed from: b, reason: collision with root package name */
    public List<cn.jpush.android.d.d> f9251b;

    /* renamed from: f, reason: collision with root package name */
    public int f9253f = 0;

    /* renamed from: g, reason: collision with root package name */
    public HashMap<Integer, cn.jpush.android.as.c> f9254g = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    public int f9252c = 3;

    /* renamed from: cn.jpush.android.ar.a$a, reason: collision with other inner class name */
    public class C0145a extends cn.jpush.android.bm.e {

        /* renamed from: a, reason: collision with root package name */
        public Context f9255a;

        /* renamed from: b, reason: collision with root package name */
        public int f9256b;

        /* renamed from: c, reason: collision with root package name */
        public cn.jpush.android.aw.e f9257c;

        /* renamed from: d, reason: collision with root package name */
        public Object[] f9258d;

        public C0145a(Context context, int i2, cn.jpush.android.aw.e eVar, Object... objArr) {
            this.f9255a = context;
            this.f9256b = i2;
            this.f9257c = eVar;
            this.f9258d = objArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0111 A[Catch: all -> 0x01c4, TryCatch #0 {all -> 0x01c4, blocks: (B:6:0x000b, B:15:0x0024, B:17:0x004c, B:19:0x0057, B:21:0x005a, B:23:0x0060, B:25:0x0066, B:28:0x0079, B:30:0x0090, B:31:0x00aa, B:33:0x00b4, B:35:0x00be, B:36:0x00db, B:38:0x00e0, B:40:0x00e9, B:42:0x00ec, B:44:0x00f2, B:45:0x0109, B:48:0x0111, B:50:0x0139, B:51:0x0146, B:52:0x014c, B:53:0x0141, B:54:0x0151, B:56:0x015a, B:57:0x01be, B:60:0x0161, B:62:0x0164, B:64:0x016a, B:66:0x018f, B:68:0x0192, B:70:0x0198, B:73:0x01a8, B:75:0x01b7), top: B:5:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0151 A[Catch: all -> 0x01c4, TryCatch #0 {all -> 0x01c4, blocks: (B:6:0x000b, B:15:0x0024, B:17:0x004c, B:19:0x0057, B:21:0x005a, B:23:0x0060, B:25:0x0066, B:28:0x0079, B:30:0x0090, B:31:0x00aa, B:33:0x00b4, B:35:0x00be, B:36:0x00db, B:38:0x00e0, B:40:0x00e9, B:42:0x00ec, B:44:0x00f2, B:45:0x0109, B:48:0x0111, B:50:0x0139, B:51:0x0146, B:52:0x014c, B:53:0x0141, B:54:0x0151, B:56:0x015a, B:57:0x01be, B:60:0x0161, B:62:0x0164, B:64:0x016a, B:66:0x018f, B:68:0x0192, B:70:0x0198, B:73:0x01a8, B:75:0x01b7), top: B:5:0x000b }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean a(android.content.Context r12, int r13, cn.jpush.android.aw.e r14, java.lang.Object... r15) {
            /*
                Method dump skipped, instructions count: 572
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.ar.a.C0145a.a(android.content.Context, int, cn.jpush.android.aw.e, java.lang.Object[]):boolean");
        }

        @Override // cn.jpush.android.bm.e
        public void a() {
            a(this.f9255a, this.f9256b, this.f9257c, this.f9258d);
        }
    }

    static {
        f9248d.put(1015, 0);
        f9248d.put(1001, 1292);
        f9248d.put(1002, 1284);
        f9248d.put(1006, 1262);
        f9248d.put(1008, 1254);
        f9248d.put(1009, 1200);
        f9248d.put(1010, 1201);
        f9248d.put(1007, 1229);
        f9248d.put(Integer.valueOf(CrashModule.MODULE_ID), 1271);
        f9248d.put(1017, 1235);
        f9248d.put(1023, 1319);
        f9248d.put(1024, 1320);
        f9248d.put(Integer.valueOf(XXPermissions.REQUEST_CODE), 1321);
        f9248d.put(1027, 1322);
        f9248d.put(1026, 1322);
        f9248d.put(1028, 1324);
        f9248d.put(1030, 1329);
        f9248d.put(1032, 1330);
        f9248d.put(1033, 1330);
        f9248d.put(1034, 1334);
        f9248d.put(1035, 1338);
        f9248d.put(1036, 1443);
        f9248d.put(1037, 1339);
        f9249e.put(100, 1253);
        f9249e.put(101, 1296);
        f9249e.put(102, 1297);
        f9249e.put(103, 1441);
        f9249e.put(104, 1326);
        f9249e.put(105, 1440);
        f9249e.put(106, 1442);
    }

    public a(cn.jpush.android.as.a aVar) {
        this.f9250a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(cn.jpush.android.aw.e eVar) {
        JSONObject jSONObject = new JSONObject();
        if (eVar != null && eVar.s()) {
            try {
                jSONObject.put("page_name", d.a());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, cn.jpush.android.aw.e eVar) {
        int i2 = eVar.v;
        int i3 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? 0 : 1318 : 1317 : 1316 : 1315;
        if (i3 > 0) {
            cn.jpush.android.l.c.a(context, eVar.m(), i3, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, cn.jpush.android.aw.e eVar, int i2, Object... objArr) {
        if (a(eVar, i2)) {
            cn.jpush.android.d.a a2 = eVar.t().a();
            if (i2 == 1017 && objArr != null && objArr.length > 0 && (objArr[0] instanceof String)) {
                cn.jpush.android.d.d dVar = new cn.jpush.android.d.d();
                dVar.f9700d = (String) objArr[0];
                dVar.f9704h = "";
                a2 = dVar.a();
            }
            cn.jpush.android.au.d.a(context, a2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, cn.jpush.android.aw.e eVar, Integer num) {
        String m = eVar.m();
        int i2 = eVar.t().bq;
        if (num != null) {
            cn.jpush.android.l.c.a(context, m, num.intValue(), 0);
        }
        cn.jpush.android.l.c.a(context, m, 1211, 0);
        a(context, eVar.t(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, cn.jpush.android.aw.e eVar, Object... objArr) {
        boolean z;
        long j;
        if (objArr == null || objArr.length <= 2 || !(objArr[1] instanceof Boolean) || !(objArr[2] instanceof Long)) {
            z = false;
            j = 0;
        } else {
            z = ((Boolean) objArr[1]).booleanValue();
            j = ((Long) objArr[2]).longValue();
        }
        JSONObject a2 = a(eVar);
        String str = eVar.t().by;
        if (TextUtils.isEmpty(str)) {
            str = "default";
        }
        String str2 = str;
        cn.jpush.android.r.b.d("AdInAppHelper", "handleInAppDisplay - delayTime: " + j + ", adPositionId: " + str2 + ", reportStr: " + a2);
        cn.jpush.android.o.b.a(context, str2);
        if (eVar.n() == 1) {
            d.a(context, eVar.t());
        }
        String m = eVar.m();
        if (z) {
            cn.jpush.android.l.c.a(context, m, 1295, "", 0, "", a2);
        }
        cn.jpush.android.l.c.a(context, m, 1210, "", 0, "", a2);
        a(context, eVar.t(), 2);
        cn.jpush.android.au.d.a(context, eVar.t().a(), true);
        cn.jpush.android.o.b.a(context, str2, eVar.t().bE, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, cn.jpush.android.d.d dVar, int i2) {
        int a2 = d.a(dVar.aC, dVar.aE);
        cn.jpush.android.as.c cVar = this.f9254g.get(Integer.valueOf(a2));
        if (cVar != null) {
            cVar.a(i2);
            if (i2 == 0) {
                cn.jpush.android.r.b.b("AdInAppHelper", "release inapp handle object, displayStyleMaps size: " + this.f9254g.size());
            }
        }
        cn.jpush.android.as.a aVar = this.f9250a;
        if (aVar != null) {
            aVar.a(context, 200, a2, i2);
        }
    }

    private boolean a(cn.jpush.android.aw.e eVar, int i2) {
        int i3;
        return i2 == 1017 || i2 == 1019 || i2 == 1021 || i2 == 1029 || i2 == 1027 || i2 == 1026 || (i2 == 1015 && ((i3 = eVar.v) == 1 || i3 == 2 || i3 == 3 || i3 == 4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(int i2) {
        Integer num = f9248d.get(Integer.valueOf(i2));
        if (num == null || num.intValue() <= 0) {
            return 0;
        }
        return num.intValue();
    }

    private cn.jpush.android.as.c c(int i2) {
        if (i2 == 0) {
            return null;
        }
        cn.jpush.android.as.c cVar = this.f9254g.get(Integer.valueOf(i2));
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c(this);
        this.f9254g.put(Integer.valueOf(i2), cVar2);
        return cVar2;
    }

    public static boolean e(Context context, cn.jpush.android.d.d dVar) {
        int i2 = dVar.aC;
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            return true;
        }
        cn.jpush.android.r.b.g("AdInAppHelper", "unsupported in app message type. type: " + dVar.aC);
        cn.jpush.android.l.c.a(context, dVar.f9700d, 1226, 0);
        return false;
    }

    public static byte g(Context context) {
        String messageReceiverClass;
        if (context == null) {
            return (byte) 0;
        }
        try {
            messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("AdInAppHelper", "[onCheckInAppMessageState]  error. " + th.getMessage());
        }
        if (Class.forName(messageReceiverClass).getMethod("onCheckInAppMessageState", Context.class, String.class) == null) {
            cn.jpush.android.r.b.b("AdInAppHelper", "not found onCheckInAppMessageState method");
            return (byte) 0;
        }
        if (!TextUtils.isEmpty(messageReceiverClass)) {
            byte onCheckInAppMessageState = ((JPushMessageReceiver) Class.forName(messageReceiverClass).newInstance()).onCheckInAppMessageState(context, cn.jpush.android.bm.a.d(context));
            cn.jpush.android.r.b.b("AdInAppHelper", "check InAppMessageState:" + ((int) onCheckInAppMessageState));
            return onCheckInAppMessageState;
        }
        return (byte) 0;
    }

    @Override // cn.jpush.android.as.d
    public int a() {
        return 200;
    }

    @Override // cn.jpush.android.as.d
    public int a(int i2) {
        cn.jpush.android.as.c cVar = this.f9254g.get(Integer.valueOf(i2));
        if (cVar != null) {
            return cVar.a();
        }
        return 0;
    }

    @Override // cn.jpush.android.as.d
    public int a(Context context) {
        return this.f9252c;
    }

    @Override // cn.jpush.android.as.b
    public Boolean a(Context context, int i2, cn.jpush.android.aw.e eVar, Object... objArr) {
        JCoreHelper.normalExecutor(context, "AdInAppHelper", new C0145a(context, i2, eVar, objArr));
        return Boolean.valueOf(i2 != 1012);
    }

    @Override // cn.jpush.android.as.d
    public void a(int i2, int i3) {
        cn.jpush.android.as.c cVar = this.f9254g.get(Integer.valueOf(i2));
        if (cVar != null) {
            cVar.a(i3);
            if (i3 == 0) {
                cn.jpush.android.r.b.b("AdInAppHelper", "release inapp handle object, displayStyleMaps size: " + this.f9254g.size());
            }
        }
    }

    @Override // cn.jpush.android.as.d
    public void a(Context context, int i2) {
        Iterator<cn.jpush.android.as.c> it = this.f9254g.values().iterator();
        while (it.hasNext()) {
            it.next().a(context, i2);
        }
    }

    @Override // cn.jpush.android.as.d
    public void a(Context context, cn.jpush.android.aw.e eVar, int i2) {
        cn.jpush.android.as.c c2 = c(d.a(eVar.n(), eVar.t().aE));
        if (c2 != null) {
            c2.a(context, eVar, i2);
        }
    }

    @Override // cn.jpush.android.as.d
    public void a(Context context, cn.jpush.android.aw.e eVar, String str) {
        if (TextUtils.isEmpty(str) || eVar == null) {
            return;
        }
        try {
            cn.jpush.android.l.c.a(context, eVar.m(), 1234, "", 0, "", new JSONObject(str));
        } catch (Throwable unused) {
        }
    }

    @Override // cn.jpush.android.as.d
    public void a(Context context, cn.jpush.android.d.d dVar) {
        if (dVar != null) {
            boolean e2 = e(context, dVar);
            if (e2) {
                this.f9252c = dVar.br;
                JCoreHelper.normalExecutor(context, JPushConstants.SDK_TYPE, new e(context, dVar, this.f9250a));
                cn.jpush.android.as.c c2 = c(d.a(dVar.aC, dVar.aE));
                if (c2 != null) {
                    c2.a(1);
                }
            }
            if (e2) {
                return;
            }
            a(context, dVar, 0);
        }
    }

    @Override // cn.jpush.android.as.d
    public void a(Context context, String str) {
        Iterator<cn.jpush.android.as.c> it = this.f9254g.values().iterator();
        while (it.hasNext()) {
            it.next().a(context, str);
        }
    }

    @Override // cn.jpush.android.as.d
    public void a(Context context, String str, boolean z) {
        Iterator<cn.jpush.android.as.c> it = this.f9254g.values().iterator();
        while (it.hasNext()) {
            it.next().a(context, str, z);
        }
    }

    @Override // cn.jpush.android.as.d
    public void a(cn.jpush.android.aw.e eVar, int i2, String str) {
        cn.jpush.android.as.c c2 = c(d.a(eVar.n(), eVar.t().aE));
        if (c2 != null) {
            c2.a(eVar, i2, str);
        }
    }

    @Override // cn.jpush.android.as.d
    public boolean a(Context context, boolean z, cn.jpush.android.d.d dVar) {
        return z;
    }

    @Override // cn.jpush.android.as.d
    public cn.jpush.android.d.d b(Context context) {
        List<cn.jpush.android.d.d> list = this.f9251b;
        if (list == null || list.isEmpty()) {
            return null;
        }
        int size = this.f9251b.size() - 1;
        cn.jpush.android.d.d dVar = this.f9251b.get(size);
        this.f9251b.remove(size);
        cn.jpush.android.r.b.b("AdInAppHelper", "get in app message, current size is " + this.f9251b.size());
        return dVar;
    }

    @Override // cn.jpush.android.as.d
    public void b(Context context, int i2) {
        cn.jpush.android.as.c cVar = this.f9254g.get(Integer.valueOf(i2));
        if (cVar != null) {
            cVar.a(context, 3);
        }
    }

    @Override // cn.jpush.android.as.d
    public void b(Context context, cn.jpush.android.d.d dVar) {
        try {
            if (dVar == null) {
                cn.jpush.android.r.b.f("AdInAppHelper", "cache ad in app, message is null");
                return;
            }
            if (this.f9251b == null) {
                this.f9251b = new LinkedList();
            }
            if (this.f9251b.contains(dVar)) {
                cn.jpush.android.r.b.f("AdInAppHelper", "the ad message cache already, messageId: " + dVar.f9700d);
                return;
            }
            if (this.f9251b.size() >= 5) {
                this.f9251b.remove(0);
                cn.jpush.android.r.b.b("AdInAppHelper", "cache in app size large 5");
            }
            this.f9251b.add(dVar);
            this.f9252c = dVar.br;
            cn.jpush.android.r.b.b("AdInAppHelper", "in app message cache, current size is " + this.f9251b.size());
            cn.jpush.android.l.c.a(context, dVar.f9700d, 1310, 0);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("AdInAppHelper", "cache in app data failed, " + th.getMessage());
        }
    }

    @Override // cn.jpush.android.as.d
    public void b(Context context, String str) {
        Iterator<cn.jpush.android.as.c> it = this.f9254g.values().iterator();
        while (it.hasNext()) {
            it.next().b(context, str);
        }
    }

    @Override // cn.jpush.android.as.d
    public void c(Context context, String str) {
        Iterator<cn.jpush.android.as.c> it = this.f9254g.values().iterator();
        while (it.hasNext()) {
            it.next().c(context, str);
        }
    }

    @Override // cn.jpush.android.as.d
    public boolean c(Context context) {
        List<cn.jpush.android.d.d> list = this.f9251b;
        return list != null && list.size() > 0;
    }

    @Override // cn.jpush.android.as.d
    public boolean c(Context context, cn.jpush.android.d.d dVar) {
        cn.jpush.android.as.c c2 = c(d.a(dVar.aC, dVar.aE));
        if (c2 == null) {
            return false;
        }
        c2.a(context, dVar);
        return false;
    }

    @Override // cn.jpush.android.as.d
    public void d(Context context) {
        for (cn.jpush.android.as.c cVar : this.f9254g.values()) {
            if (cVar.a() != 0) {
                cVar.a(context);
            }
        }
    }

    @Override // cn.jpush.android.as.d
    public void d(Context context, String str) {
        Iterator<cn.jpush.android.as.c> it = this.f9254g.values().iterator();
        while (it.hasNext()) {
            it.next().d(context, str);
        }
    }

    @Override // cn.jpush.android.as.d
    public void e(Context context, String str) {
        Iterator<cn.jpush.android.as.c> it = this.f9254g.values().iterator();
        while (it.hasNext()) {
            it.next().e(context, str);
        }
    }

    @Override // cn.jpush.android.as.d
    public boolean e(Context context) {
        String messageReceiverClass;
        try {
            messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
        } catch (Throwable th) {
            cn.jpush.android.r.b.f("AdInAppHelper", "check user intercept in app display failed, " + th.getMessage());
        }
        if (Class.forName(messageReceiverClass).getMethod("onInAppMessageUnShow", Context.class, NotificationMessage.class) == null) {
            cn.jpush.android.r.b.c("AdInAppHelper", "not found onInAppMessageUnShow method");
            return false;
        }
        if (!TextUtils.isEmpty(messageReceiverClass) && !((JPushMessageReceiver) Class.forName(messageReceiverClass).newInstance()).isNeedShowInAppMessage(context, new NotificationMessage(), cn.jpush.android.bm.a.d(context))) {
            cn.jpush.android.r.b.c("AdInAppHelper", "user intercept in app display");
            return true;
        }
        return false;
    }

    @Override // cn.jpush.android.as.d
    public void f(Context context) {
        ArrayList<cn.jpush.android.d.a> a2 = cn.jpush.android.au.d.a(context);
        if (a2 == null || a2.size() <= 0) {
            return;
        }
        Iterator<cn.jpush.android.d.a> it = a2.iterator();
        while (it.hasNext()) {
            cn.jpush.android.d.a next = it.next();
            if (!TextUtils.isEmpty(next.f9694a)) {
                cn.jpush.android.l.c.a(context, next.f9694a, 1323, 0);
            }
        }
    }
}
