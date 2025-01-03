package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static p f11158a = null;

    /* renamed from: b, reason: collision with root package name */
    public static q f11159b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f11160c = false;

    public p(Context context, List<com.tencent.bugly.a> list) {
        f11159b = new q(context, list);
    }

    private synchronized boolean b(r rVar) {
        ContentValues d2;
        if (rVar == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = f11159b.getWritableDatabase();
            if (writableDatabase == null || (d2 = d(rVar)) == null) {
                return false;
            }
            long replace = writableDatabase.replace("t_pf", "_id", d2);
            if (replace < 0) {
                return false;
            }
            x.c("[Database] insert %s success.", "t_pf");
            rVar.f11174a = replace;
            return true;
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            } finally {
            }
        }
    }

    public static ContentValues c(r rVar) {
        if (rVar == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (rVar.f11174a > 0) {
                contentValues.put("_id", Long.valueOf(rVar.f11174a));
            }
            contentValues.put("_tp", Integer.valueOf(rVar.f11175b));
            contentValues.put("_pc", rVar.f11176c);
            contentValues.put("_th", rVar.f11177d);
            contentValues.put("_tm", Long.valueOf(rVar.f11178e));
            if (rVar.f11180g != null) {
                contentValues.put("_dt", rVar.f11180g);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public static ContentValues d(r rVar) {
        if (rVar != null && !z.a(rVar.f11179f)) {
            try {
                ContentValues contentValues = new ContentValues();
                if (rVar.f11174a > 0) {
                    contentValues.put("_id", Long.valueOf(rVar.f11174a));
                }
                contentValues.put("_tp", rVar.f11179f);
                contentValues.put("_tm", Long.valueOf(rVar.f11178e));
                if (rVar.f11180g != null) {
                    contentValues.put("_dt", rVar.f11180g);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static synchronized p a(Context context, List<com.tencent.bugly.a> list) {
        p pVar;
        synchronized (p.class) {
            if (f11158a == null) {
                f11158a = new p(context, list);
            }
            pVar = f11158a;
        }
        return pVar;
    }

    /* compiled from: BUGLY */
    public class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public int f11161a;

        /* renamed from: b, reason: collision with root package name */
        public o f11162b;

        /* renamed from: c, reason: collision with root package name */
        public String f11163c;

        /* renamed from: d, reason: collision with root package name */
        public ContentValues f11164d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f11165e;

        /* renamed from: f, reason: collision with root package name */
        public String[] f11166f;

        /* renamed from: g, reason: collision with root package name */
        public String f11167g;

        /* renamed from: h, reason: collision with root package name */
        public String[] f11168h;

        /* renamed from: i, reason: collision with root package name */
        public String f11169i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String[] n;
        public int o;
        public String p;
        public byte[] q;

        public a(int i2, o oVar) {
            this.f11161a = i2;
            this.f11162b = oVar;
        }

        public final void a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.f11165e = z;
            this.f11163c = str;
            this.f11166f = strArr;
            this.f11167g = str2;
            this.f11168h = strArr2;
            this.f11169i = str3;
            this.j = str4;
            this.k = str5;
            this.l = str6;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.f11161a) {
                case 1:
                    p.this.a(this.f11163c, this.f11164d, this.f11162b);
                    break;
                case 2:
                    p.this.a(this.f11163c, this.m, this.n, this.f11162b);
                    break;
                case 3:
                    Cursor a2 = p.this.a(this.f11165e, this.f11163c, this.f11166f, this.f11167g, this.f11168h, this.f11169i, this.j, this.k, this.l, this.f11162b);
                    if (a2 != null) {
                        a2.close();
                        break;
                    }
                    break;
                case 4:
                    p.this.a(this.o, this.p, this.q, this.f11162b);
                    break;
                case 5:
                    p.this.a(this.o, this.f11162b);
                    break;
                case 6:
                    p.this.a(this.o, this.p, this.f11162b);
                    break;
            }
        }

        public final void a(int i2, String str, byte[] bArr) {
            this.o = i2;
            this.p = str;
            this.q = bArr;
        }
    }

    public static synchronized p a() {
        p pVar;
        synchronized (p.class) {
            pVar = f11158a;
        }
        return pVar;
    }

    public final long a(String str, ContentValues contentValues, o oVar, boolean z) {
        return a(str, contentValues, (o) null);
    }

    private synchronized List<r> c(int i2) {
        Cursor cursor;
        try {
            SQLiteDatabase writableDatabase = f11159b.getWritableDatabase();
            if (writableDatabase != null) {
                String str = "_id = " + i2;
                cursor = writableDatabase.query("t_pf", null, str, null, null, null, null);
                if (cursor == null) {
                    return null;
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    ArrayList arrayList = new ArrayList();
                    while (cursor.moveToNext()) {
                        r b2 = b(cursor);
                        if (b2 != null) {
                            arrayList.add(b2);
                        } else {
                            try {
                                String string = cursor.getString(cursor.getColumnIndex("_tp"));
                                sb.append(" or _tp");
                                sb.append(" = ");
                                sb.append(string);
                            } catch (Throwable unused) {
                                x.d("[Database] unknown id.", new Object[0]);
                            }
                        }
                    }
                    if (sb.length() > 0) {
                        sb.append(" and _id");
                        sb.append(" = ");
                        sb.append(i2);
                        x.d("[Database] deleted %s illegal data %d.", "t_pf", Integer.valueOf(writableDatabase.delete("t_pf", str.substring(4), null)));
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
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return null;
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2, o oVar, boolean z) {
        return a(false, str, strArr, str2, null, null, null, null, null, null);
    }

    public final int a(String str, String str2, String[] strArr, o oVar, boolean z) {
        return a(str, str2, (String[]) null, (o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized long a(String str, ContentValues contentValues, o oVar) {
        long j;
        j = 0;
        try {
            SQLiteDatabase writableDatabase = f11159b.getWritableDatabase();
            if (writableDatabase != null && contentValues != null) {
                long replace = writableDatabase.replace(str, "_id", contentValues);
                if (replace >= 0) {
                    x.c("[Database] insert %s success.", str);
                } else {
                    x.d("[Database] replace %s error.", str);
                }
                j = replace;
            }
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return j;
    }

    public final synchronized void b(int i2) {
        String str;
        SQLiteDatabase writableDatabase = f11159b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i2 >= 0) {
                try {
                    str = "_tp = " + i2;
                } catch (Throwable th) {
                    if (x.a(th)) {
                        return;
                    }
                    th.printStackTrace();
                    return;
                }
            } else {
                str = null;
            }
            x.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", str, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Cursor a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, o oVar) {
        Cursor cursor;
        cursor = null;
        try {
            SQLiteDatabase writableDatabase = f11159b.getWritableDatabase();
            if (writableDatabase != null) {
                cursor = writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
        } finally {
            try {
                return cursor;
            } finally {
            }
        }
        return cursor;
    }

    public static r b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            r rVar = new r();
            rVar.f11174a = cursor.getLong(cursor.getColumnIndex("_id"));
            rVar.f11178e = cursor.getLong(cursor.getColumnIndex("_tm"));
            rVar.f11179f = cursor.getString(cursor.getColumnIndex("_tp"));
            rVar.f11180g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return rVar;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int a(String str, String str2, String[] strArr, o oVar) {
        int i2;
        i2 = 0;
        try {
            SQLiteDatabase writableDatabase = f11159b.getWritableDatabase();
            if (writableDatabase != null) {
                i2 = writableDatabase.delete(str, str2, strArr);
            }
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return i2;
    }

    public final boolean a(int i2, String str, byte[] bArr, o oVar, boolean z) {
        if (!z) {
            a aVar = new a(4, null);
            aVar.a(i2, str, bArr);
            w.a().a(aVar);
            return true;
        }
        return a(i2, str, bArr, (o) null);
    }

    public final Map<String, byte[]> a(int i2, o oVar, boolean z) {
        return a(i2, (o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i2, String str, byte[] bArr, o oVar) {
        try {
            r rVar = new r();
            rVar.f11174a = i2;
            rVar.f11179f = str;
            rVar.f11178e = System.currentTimeMillis();
            rVar.f11180g = bArr;
            return b(rVar);
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, byte[]> a(int i2, o oVar) {
        HashMap hashMap = null;
        try {
            List<r> c2 = c(i2);
            if (c2 == null) {
                return null;
            }
            HashMap hashMap2 = new HashMap();
            try {
                for (r rVar : c2) {
                    byte[] bArr = rVar.f11180g;
                    if (bArr != null) {
                        hashMap2.put(rVar.f11179f, bArr);
                    }
                }
                return hashMap2;
            } catch (Throwable th) {
                th = th;
                hashMap = hashMap2;
                if (x.a(th)) {
                    return hashMap;
                }
                th.printStackTrace();
                return hashMap;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final synchronized boolean a(r rVar) {
        ContentValues c2;
        if (rVar == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = f11159b.getWritableDatabase();
            if (writableDatabase == null || (c2 = c(rVar)) == null) {
                return false;
            }
            long replace = writableDatabase.replace("t_lr", "_id", c2);
            if (replace < 0) {
                return false;
            }
            x.c("[Database] insert %s success.", "t_lr");
            rVar.f11174a = replace;
            return true;
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
                return false;
            } finally {
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00aa A[Catch: all -> 0x00b3, TRY_LEAVE, TryCatch #1 {all -> 0x00b3, blocks: (B:43:0x00a4, B:45:0x00aa), top: B:42:0x00a4, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00af A[Catch: all -> 0x00bc, TRY_ENTER, TryCatch #4 {, blocks: (B:3:0x0001, B:11:0x0031, B:37:0x009b, B:48:0x00af, B:51:0x00b6, B:52:0x00b9, B:43:0x00a4, B:45:0x00aa), top: B:2:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.List<com.tencent.bugly.proguard.r> a(int r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            com.tencent.bugly.proguard.q r0 = com.tencent.bugly.proguard.p.f11159b     // Catch: java.lang.Throwable -> Lbc
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch: java.lang.Throwable -> Lbc
            r9 = 0
            if (r0 == 0) goto Lba
            if (r12 < 0) goto L20
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1c
            java.lang.String r2 = "_tp = "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L1c
            r1.append(r12)     // Catch: java.lang.Throwable -> L1c
            java.lang.String r12 = r1.toString()     // Catch: java.lang.Throwable -> L1c
            r4 = r12
            goto L21
        L1c:
            r12 = move-exception
            r0 = r9
            goto La4
        L20:
            r4 = r9
        L21:
            java.lang.String r2 = "t_lr"
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r0
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L1c
            if (r12 != 0) goto L36
            if (r12 == 0) goto L34
            r12.close()     // Catch: java.lang.Throwable -> Lbc
        L34:
            monitor-exit(r11)
            return r9
        L36:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La0
            r1.<init>()     // Catch: java.lang.Throwable -> La0
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> La0
            r2.<init>()     // Catch: java.lang.Throwable -> La0
        L40:
            boolean r3 = r12.moveToNext()     // Catch: java.lang.Throwable -> La0
            r4 = 0
            if (r3 == 0) goto L71
            com.tencent.bugly.proguard.r r3 = a(r12)     // Catch: java.lang.Throwable -> La0
            if (r3 == 0) goto L51
            r2.add(r3)     // Catch: java.lang.Throwable -> La0
            goto L40
        L51:
            java.lang.String r3 = "_id"
            int r3 = r12.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L69
            long r5 = r12.getLong(r3)     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = " or _id"
            r1.append(r3)     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = " = "
            r1.append(r3)     // Catch: java.lang.Throwable -> L69
            r1.append(r5)     // Catch: java.lang.Throwable -> L69
            goto L40
        L69:
            java.lang.String r3 = "[Database] unknown id."
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> La0
            com.tencent.bugly.proguard.x.d(r3, r4)     // Catch: java.lang.Throwable -> La0
            goto L40
        L71:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> La0
            int r3 = r1.length()     // Catch: java.lang.Throwable -> La0
            if (r3 <= 0) goto L99
            r3 = 4
            java.lang.String r1 = r1.substring(r3)     // Catch: java.lang.Throwable -> La0
            java.lang.String r3 = "t_lr"
            int r0 = r0.delete(r3, r1, r9)     // Catch: java.lang.Throwable -> La0
            java.lang.String r1 = "[Database] deleted %s illegal data %d"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> La0
            java.lang.String r5 = "t_lr"
            r3[r4] = r5     // Catch: java.lang.Throwable -> La0
            r4 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> La0
            r3[r4] = r0     // Catch: java.lang.Throwable -> La0
            com.tencent.bugly.proguard.x.d(r1, r3)     // Catch: java.lang.Throwable -> La0
        L99:
            if (r12 == 0) goto L9e
            r12.close()     // Catch: java.lang.Throwable -> Lbc
        L9e:
            monitor-exit(r11)
            return r2
        La0:
            r0 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
        La4:
            boolean r1 = com.tencent.bugly.proguard.x.a(r12)     // Catch: java.lang.Throwable -> Lb3
            if (r1 != 0) goto Lad
            r12.printStackTrace()     // Catch: java.lang.Throwable -> Lb3
        Lad:
            if (r0 == 0) goto Lba
            r0.close()     // Catch: java.lang.Throwable -> Lbc
            goto Lba
        Lb3:
            r12 = move-exception
            if (r0 == 0) goto Lb9
            r0.close()     // Catch: java.lang.Throwable -> Lbc
        Lb9:
            throw r12     // Catch: java.lang.Throwable -> Lbc
        Lba:
            monitor-exit(r11)
            return r9
        Lbc:
            r12 = move-exception
            monitor-exit(r11)
            goto Lc0
        Lbf:
            throw r12
        Lc0:
            goto Lbf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.p.a(int):java.util.List");
    }

    public final synchronized void a(List<r> list) {
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = f11159b.getWritableDatabase();
                if (writableDatabase != null) {
                    StringBuilder sb = new StringBuilder();
                    for (r rVar : list) {
                        sb.append(" or _id");
                        sb.append(" = ");
                        sb.append(rVar.f11174a);
                    }
                    String sb2 = sb.toString();
                    if (sb2.length() > 0) {
                        sb2 = sb2.substring(4);
                    }
                    sb.setLength(0);
                    try {
                        x.c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", sb2, null)));
                    } catch (Throwable th) {
                        if (x.a(th)) {
                            return;
                        }
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    public static r a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            r rVar = new r();
            rVar.f11174a = cursor.getLong(cursor.getColumnIndex("_id"));
            rVar.f11175b = cursor.getInt(cursor.getColumnIndex("_tp"));
            rVar.f11176c = cursor.getString(cursor.getColumnIndex("_pc"));
            rVar.f11177d = cursor.getString(cursor.getColumnIndex("_th"));
            rVar.f11178e = cursor.getLong(cursor.getColumnIndex("_tm"));
            rVar.f11180g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return rVar;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(int i2, String str, o oVar) {
        boolean z;
        String str2;
        z = false;
        try {
            SQLiteDatabase writableDatabase = f11159b.getWritableDatabase();
            if (writableDatabase != null) {
                if (z.a(str)) {
                    str2 = "_id = " + i2;
                } else {
                    str2 = "_id = " + i2 + " and _tp = \"" + str + "\"";
                }
                int delete = writableDatabase.delete("t_pf", str2, null);
                x.c("[Database] deleted %s data %d", "t_pf", Integer.valueOf(delete));
                if (delete > 0) {
                    z = true;
                }
            }
        } catch (Throwable th) {
            try {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z;
    }
}
