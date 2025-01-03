package cn.jpush.android.be;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.jpush.android.helper.Logger;

/* loaded from: classes.dex */
public class b extends e {

    /* renamed from: b, reason: collision with root package name */
    public static volatile b f9544b;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f9543a = {"_id", "ln_id", "ln_count", "ln_remove", "ln_type", "ln_extra", "ln_trigger_time", "ln_add_time"};

    /* renamed from: c, reason: collision with root package name */
    public static final Object f9545c = new Object();

    public b(Context context) {
        super(context, "jpush_local_notification.db", null, 1);
    }

    public static b a(Context context) {
        if (f9544b == null) {
            synchronized (f9545c) {
                if (f9544b == null) {
                    f9544b = new b(context.getApplicationContext());
                }
            }
        }
        return f9544b;
    }

    public static c a(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            Logger.d("LocalNotificationDb", "cursor is null");
            return null;
        }
        try {
            c cVar = new c();
            cVar.a(cursor.getLong(1));
            cVar.a(cursor.getInt(2));
            cVar.b(cursor.getInt(3));
            cVar.c(cursor.getInt(4));
            cVar.a(cursor.getString(5));
            cVar.c(cursor.getLong(6));
            cVar.b(cursor.getLong(7));
            Logger.i("LocalNotificationDb", cVar.toString());
            return cVar;
        } catch (Exception e2) {
            e2.getStackTrace();
            Logger.w("LocalNotificationDb", "initLocalNotificationDBData exception:" + e2.getMessage());
            return null;
        }
    }

    public int a(long j) {
        if (!a(true)) {
            return 0;
        }
        try {
            return getWritableDatabase().delete("t_localnotification", "ln_id=" + j, null);
        } catch (Exception unused) {
            return 0;
        } finally {
            b(true);
        }
    }

    public long a(long j, int i2, int i3, int i4, String str, long j2, long j3) {
        if (a(true)) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("ln_id", Long.valueOf(j));
                contentValues.put("ln_count", Integer.valueOf(i2));
                contentValues.put("ln_remove", Integer.valueOf(i3));
                contentValues.put("ln_type", Integer.valueOf(i4));
                contentValues.put("ln_extra", str);
                contentValues.put("ln_trigger_time", Long.valueOf(j2));
                contentValues.put("ln_add_time", Long.valueOf(j3));
                return getWritableDatabase().insert("t_localnotification", null, contentValues);
            } catch (Exception unused) {
            } finally {
                b(true);
            }
        }
        return 0L;
    }

    public Cursor a(int i2, long j) {
        try {
            return getReadableDatabase().query(true, "t_localnotification", f9543a, "ln_count=" + i2 + " and ln_trigger_time<" + j, null, null, null, null, null);
        } catch (Exception e2) {
            Logger.w("LocalNotificationDb", "getOutDatas exception:" + e2.getMessage());
            return null;
        }
    }

    public Cursor a(long j, long j2) {
        try {
            return getReadableDatabase().query(true, "t_localnotification", f9543a, "ln_count>0 and ln_trigger_time<" + (j2 + j) + " and ln_trigger_time>" + j, null, null, null, null, null);
        } catch (Exception e2) {
            Logger.w("LocalNotificationDb", "getRtcDatas exception:" + e2.getMessage());
            return null;
        }
    }

    public c a(long j, int i2) {
        if (!a(false)) {
            throw new Exception("open database failed");
        }
        Cursor cursor = null;
        try {
            cursor = getReadableDatabase().query(true, "t_localnotification", f9543a, "ln_id=" + j + " and ln_type=" + i2, null, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return a(cursor);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            b(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int[] a() {
        /*
            r13 = this;
            java.lang.String r4 = "1"
            r10 = 0
            boolean r0 = r13.a(r10)
            r11 = 0
            if (r0 == 0) goto L90
            r12 = 1
            java.lang.String r0 = "ln_id"
            java.lang.String[] r3 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L80
            android.database.sqlite.SQLiteDatabase r0 = r13.getReadableDatabase()     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L80
            r1 = 1
            java.lang.String r2 = "t_localnotification"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L80
            if (r0 == 0) goto L42
            int r1 = r0.getCount()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            if (r1 <= 0) goto L42
            int r1 = r0.getCount()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            int[] r1 = new int[r1]     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            r0.moveToFirst()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6e
            r2 = 0
        L33:
            int r3 = r0.getInt(r10)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6e
            r1[r2] = r3     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6e
            int r2 = r2 + 1
            boolean r3 = r0.moveToNext()     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6e
            if (r3 != 0) goto L33
            r11 = r1
        L42:
            boolean r1 = r13.a(r12)     // Catch: java.lang.Throwable -> L6a java.lang.Exception -> L6d
            if (r1 == 0) goto L5b
            java.lang.String r1 = "delete from t_localnotification"
            android.database.sqlite.SQLiteDatabase r2 = r13.getWritableDatabase()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L57
            r2.execSQL(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L57
            r1 = 1
            goto L5c
        L53:
            r1 = move-exception
            r11 = r0
            r0 = 1
            goto L72
        L57:
            r1 = r11
            r11 = r0
            r0 = 1
            goto L82
        L5b:
            r1 = 0
        L5c:
            if (r0 == 0) goto L61
            r0.close()
        L61:
            r13.b(r10)
            if (r1 == 0) goto L90
            r13.b(r12)
            goto L90
        L6a:
            r1 = move-exception
            r11 = r0
            goto L71
        L6d:
            r1 = r11
        L6e:
            r11 = r0
            goto L81
        L70:
            r1 = move-exception
        L71:
            r0 = 0
        L72:
            if (r11 == 0) goto L77
            r11.close()
        L77:
            r13.b(r10)
            if (r0 == 0) goto L7f
            r13.b(r12)
        L7f:
            throw r1
        L80:
            r1 = r11
        L81:
            r0 = 0
        L82:
            if (r11 == 0) goto L87
            r11.close()
        L87:
            r13.b(r10)
            if (r0 == 0) goto L8f
            r13.b(r12)
        L8f:
            r11 = r1
        L90:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.be.b.a():int[]");
    }

    public long b(long j, int i2, int i3, int i4, String str, long j2, long j3) {
        if (a(true)) {
            try {
                String str2 = "ln_id=" + j;
                ContentValues contentValues = new ContentValues();
                contentValues.put("ln_id", Long.valueOf(j));
                contentValues.put("ln_count", Integer.valueOf(i2));
                contentValues.put("ln_remove", Integer.valueOf(i3));
                contentValues.put("ln_type", Integer.valueOf(i4));
                contentValues.put("ln_extra", str);
                contentValues.put("ln_trigger_time", Long.valueOf(j2));
                contentValues.put("ln_add_time", Long.valueOf(j3));
                return getWritableDatabase().update("t_localnotification", contentValues, str2, null);
            } catch (Exception unused) {
            } finally {
                b(true);
            }
        }
        return 0L;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE t_localnotification (_id INTEGER PRIMARY KEY AUTOINCREMENT ,ln_id long not null,ln_count integer not null,ln_remove integer not null,ln_type integer not null,ln_extra text ,ln_trigger_time long ,ln_add_time long );");
        } catch (Exception unused) {
            Logger.v("LocalNotificationDb", "表已经存在");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_localnotification");
        onCreate(sQLiteDatabase);
    }
}
