package c.c.a.b.g.b;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzy;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class s3 extends c3 {

    /* renamed from: c, reason: collision with root package name */
    public final v3 f5058c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5059d;

    public s3(a5 a5Var) {
        super(a5Var);
        this.f5058c = new v3(this, d(), "google_app_measurement_local.db");
    }

    public final void A() {
        e();
        g();
        try {
            int delete = D().delete("messages", null, null) + 0;
            if (delete > 0) {
                c().B().a("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            c().t().a("Error resetting local analytics data. error", e2);
        }
    }

    public final boolean B() {
        return a(3, new byte[0]);
    }

    public final boolean C() {
        g();
        e();
        if (this.f5059d || !E()) {
            return false;
        }
        int i2 = 5;
        for (int i3 = 0; i3 < 5; i3++) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    SQLiteDatabase D = D();
                    if (D == null) {
                        this.f5059d = true;
                        if (D != null) {
                            D.close();
                        }
                        return false;
                    }
                    D.beginTransaction();
                    D.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                    D.setTransactionSuccessful();
                    D.endTransaction();
                    if (D != null) {
                        D.close();
                    }
                    return true;
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep(i2);
                    i2 += 20;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                } catch (SQLiteFullException e2) {
                    c().t().a("Error deleting app launch break from local database", e2);
                    this.f5059d = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            } catch (SQLiteException e3) {
                if (0 != 0) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Throwable th) {
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                }
                c().t().a("Error deleting app launch break from local database", e3);
                this.f5059d = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        c().w().a("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    public final SQLiteDatabase D() throws SQLiteException {
        if (this.f5059d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f5058c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f5059d = true;
        return null;
    }

    public final boolean E() {
        return d().getDatabasePath("google_app_measurement_local.db").exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0128  */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(int r17, byte[] r18) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.s3.a(int, byte[]):boolean");
    }

    @Override // c.c.a.b.g.b.c3
    public final boolean z() {
        return false;
    }

    public final boolean a(zzaq zzaqVar) {
        Parcel obtain = Parcel.obtain();
        zzaqVar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            c().u().a("Event is too long for local database. Sending event directly to service");
            return false;
        }
        return a(0, marshall);
    }

    public final boolean a(zzkn zzknVar) {
        Parcel obtain = Parcel.obtain();
        zzknVar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            c().u().a("User property too long for local database. Sending directly to service");
            return false;
        }
        return a(1, marshall);
    }

    public final boolean a(zzy zzyVar) {
        j();
        byte[] a2 = s9.a((Parcelable) zzyVar);
        if (a2.length > 131072) {
            c().u().a("Conditional user property too long for local database. Sending directly to service");
            return false;
        }
        return a(2, a2);
    }

    /* JADX WARN: Removed duplicated region for block: B:149:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0203  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> a(int r22) {
        /*
            Method dump skipped, instructions count: 533
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.s3.a(int):java.util.List");
    }

    public static long a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
            if (cursor.moveToFirst()) {
                return cursor.getLong(0);
            }
            if (cursor == null) {
                return -1L;
            }
            cursor.close();
            return -1L;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
