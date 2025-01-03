package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import cn.jiguang.internal.JConstants;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f10842a;

    /* renamed from: b, reason: collision with root package name */
    public long f10843b;

    /* renamed from: c, reason: collision with root package name */
    public int f10844c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10845d;

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a.this.c();
            } catch (Throwable th) {
                x.a(th);
            }
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$a, reason: collision with other inner class name */
    public class RunnableC0164a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public boolean f10849a;

        /* renamed from: b, reason: collision with root package name */
        public UserInfoBean f10850b;

        public RunnableC0164a(UserInfoBean userInfoBean, boolean z) {
            this.f10850b = userInfoBean;
            this.f10849a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.bugly.crashreport.common.info.a b2;
            try {
                if (this.f10850b != null) {
                    UserInfoBean userInfoBean = this.f10850b;
                    if (userInfoBean != null && (b2 = com.tencent.bugly.crashreport.common.info.a.b()) != null) {
                        userInfoBean.j = b2.e();
                    }
                    x.c("[UserInfo] Record user info.", new Object[0]);
                    a.a(a.this, this.f10850b, false);
                }
                if (this.f10849a) {
                    a aVar = a.this;
                    w a2 = w.a();
                    if (a2 != null) {
                        a2.a(aVar.new AnonymousClass2());
                    }
                }
            } catch (Throwable th) {
                if (x.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* compiled from: BUGLY */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < a.this.f10843b) {
                w.a().a(a.this.new b(), (a.this.f10843b - currentTimeMillis) + 5000);
            } else {
                a.this.a(3, false, 0L);
                a.this.a();
            }
        }
    }

    /* compiled from: BUGLY */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public long f10853a;

        public c(long j) {
            this.f10853a = 21600000L;
            this.f10853a = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            w a2 = w.a();
            if (a2 != null) {
                a2.a(aVar.new AnonymousClass2());
            }
            a aVar2 = a.this;
            long j = this.f10853a;
            w.a().a(aVar2.new c(j), j);
        }
    }

    public a(Context context, boolean z) {
        this.f10845d = true;
        this.f10842a = context;
        this.f10845d = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f2 A[Catch: all -> 0x0173, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:12:0x000f, B:16:0x0017, B:18:0x001d, B:22:0x0027, B:24:0x003c, B:27:0x0045, B:29:0x004c, B:30:0x004f, B:32:0x0055, B:34:0x0069, B:36:0x0079, B:43:0x0081, B:45:0x008b, B:46:0x0090, B:48:0x0096, B:50:0x00a4, B:52:0x00b1, B:53:0x00b4, B:56:0x00c2, B:58:0x00c6, B:60:0x00cb, B:63:0x00d0, B:73:0x00d7, B:74:0x00ec, B:76:0x00f2, B:78:0x00f7, B:81:0x00fe, B:84:0x0116, B:86:0x011c, B:89:0x0125, B:91:0x012b, B:94:0x0134, B:96:0x013e, B:99:0x0147, B:102:0x0165, B:107:0x016a, B:111:0x00e6), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x011c A[Catch: all -> 0x0173, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:12:0x000f, B:16:0x0017, B:18:0x001d, B:22:0x0027, B:24:0x003c, B:27:0x0045, B:29:0x004c, B:30:0x004f, B:32:0x0055, B:34:0x0069, B:36:0x0079, B:43:0x0081, B:45:0x008b, B:46:0x0090, B:48:0x0096, B:50:0x00a4, B:52:0x00b1, B:53:0x00b4, B:56:0x00c2, B:58:0x00c6, B:60:0x00cb, B:63:0x00d0, B:73:0x00d7, B:74:0x00ec, B:76:0x00f2, B:78:0x00f7, B:81:0x00fe, B:84:0x0116, B:86:0x011c, B:89:0x0125, B:91:0x012b, B:94:0x0134, B:96:0x013e, B:99:0x0147, B:102:0x0165, B:107:0x016a, B:111:0x00e6), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0125 A[Catch: all -> 0x0173, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:12:0x000f, B:16:0x0017, B:18:0x001d, B:22:0x0027, B:24:0x003c, B:27:0x0045, B:29:0x004c, B:30:0x004f, B:32:0x0055, B:34:0x0069, B:36:0x0079, B:43:0x0081, B:45:0x008b, B:46:0x0090, B:48:0x0096, B:50:0x00a4, B:52:0x00b1, B:53:0x00b4, B:56:0x00c2, B:58:0x00c6, B:60:0x00cb, B:63:0x00d0, B:73:0x00d7, B:74:0x00ec, B:76:0x00f2, B:78:0x00f7, B:81:0x00fe, B:84:0x0116, B:86:0x011c, B:89:0x0125, B:91:0x012b, B:94:0x0134, B:96:0x013e, B:99:0x0147, B:102:0x0165, B:107:0x016a, B:111:0x00e6), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void c() {
        /*
            Method dump skipped, instructions count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.a.c():void");
    }

    public static /* synthetic */ void a(a aVar, UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> a2;
        if (userInfoBean != null) {
            if (!z && userInfoBean.f10834b != 1 && (a2 = aVar.a(com.tencent.bugly.crashreport.common.info.a.a(aVar.f10842a).f10873d)) != null && a2.size() >= 20) {
                x.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(a2.size()));
                return;
            }
            long a3 = p.a().a("t_ui", a(userInfoBean), (o) null, true);
            if (a3 >= 0) {
                x.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(a3));
                userInfoBean.f10833a = a3;
            }
        }
    }

    public final void b() {
        w a2 = w.a();
        if (a2 != null) {
            a2.a(new AnonymousClass2());
        }
    }

    public final void a(int i2, boolean z, long j) {
        com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a2 != null && !a2.c().f10887f && i2 != 1 && i2 != 3) {
            x.e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i2 == 1 || i2 == 3) {
            this.f10844c++;
        }
        com.tencent.bugly.crashreport.common.info.a a3 = com.tencent.bugly.crashreport.common.info.a.a(this.f10842a);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f10834b = i2;
        userInfoBean.f10835c = a3.f10873d;
        userInfoBean.f10836d = a3.g();
        userInfoBean.f10837e = System.currentTimeMillis();
        userInfoBean.f10838f = -1L;
        userInfoBean.n = a3.j;
        userInfoBean.o = i2 == 1 ? 1 : 0;
        userInfoBean.l = a3.a();
        userInfoBean.m = a3.p;
        userInfoBean.f10839g = a3.q;
        userInfoBean.f10840h = a3.r;
        userInfoBean.f10841i = a3.s;
        userInfoBean.k = a3.t;
        userInfoBean.r = a3.u();
        userInfoBean.s = a3.z();
        userInfoBean.p = a3.A();
        userInfoBean.q = a3.B();
        w.a().a(new RunnableC0164a(userInfoBean, z), 0L);
    }

    public final void a() {
        this.f10843b = z.b() + JConstants.DAY;
        w.a().a(new b(), (this.f10843b - System.currentTimeMillis()) + 5000);
    }

    public final List<UserInfoBean> a(String str) {
        Cursor cursor;
        String str2;
        try {
            if (z.a(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursor = p.a().a("t_ui", null, str2, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    UserInfoBean a2 = a(cursor);
                    if (a2 != null) {
                        arrayList.add(a2);
                    } else {
                        try {
                            long j = cursor.getLong(cursor.getColumnIndex("_id"));
                            sb.append(" or _id");
                            sb.append(" = ");
                            sb.append(j);
                        } catch (Throwable unused) {
                            x.d("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    x.d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(p.a().a("t_ui", sb2.substring(4), (String[]) null, (o) null, true)));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public static void a(List<UserInfoBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size() && i2 < 50; i2++) {
            UserInfoBean userInfoBean = list.get(i2);
            sb.append(" or _id");
            sb.append(" = ");
            sb.append(userInfoBean.f10833a);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            sb2 = sb2.substring(4);
        }
        String str = sb2;
        sb.setLength(0);
        try {
            x.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(p.a().a("t_ui", str, (String[]) null, (o) null, true)));
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public static ContentValues a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (userInfoBean.f10833a > 0) {
                contentValues.put("_id", Long.valueOf(userInfoBean.f10833a));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f10837e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f10838f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.f10834b));
            contentValues.put("_pc", userInfoBean.f10835c);
            contentValues.put("_dt", z.a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) z.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f10833a = j;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
