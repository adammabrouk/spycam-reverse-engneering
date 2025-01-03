package c.c.a.b.g.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.recyclerview.widget.RecyclerView;
import c.c.a.b.f.e.b1;
import c.c.a.b.f.e.g0;
import c.c.a.b.f.e.h0;
import c.c.a.b.f.e.i0;
import c.c.a.b.f.e.k0;
import c.c.a.b.f.e.oa;
import c.c.a.b.f.e.s4;
import c.c.a.b.f.e.x0;
import c.c.a.b.f.e.z0;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.google.android.gms.measurement.internal.zzy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class c extends i9 {

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f4619f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f4620g = {OSSHeaders.ORIGIN, "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f4621h = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f4622i = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    public static final String[] j = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    public static final String[] k = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] l = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] m = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* renamed from: d, reason: collision with root package name */
    public final h f4623d;

    /* renamed from: e, reason: collision with root package name */
    public final d9 f4624e;

    public c(l9 l9Var) {
        super(l9Var);
        this.f4624e = new d9(b());
        this.f4623d = new h(this, d(), "google_app_measurement.db");
    }

    public final boolean A() {
        return b("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    public final void B() {
        int delete;
        g();
        q();
        if (x()) {
            long a2 = k().f4830h.a();
            long b2 = b().b();
            if (Math.abs(b2 - a2) > r.y.a(null).longValue()) {
                k().f4830h.a(b2);
                g();
                q();
                if (!x() || (delete = u().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(b().a()), String.valueOf(b.w())})) <= 0) {
                    return;
                }
                c().B().a("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    public final long C() {
        return a("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    public final long D() {
        return a("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    public final boolean E() {
        return b("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean G() {
        return b("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final long a(String str, String[] strArr, long j2) {
        Cursor cursor = null;
        try {
            try {
                cursor = u().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    return cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return j2;
            } catch (SQLiteException e2) {
                c().t().a("Database error", str, e2);
                throw e2;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final long b(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = u().rawQuery(str, strArr);
                if (!rawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j2;
            } catch (SQLiteException e2) {
                c().t().a("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final c.c.a.b.g.b.t9 c(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            c.c.a.b.c.o.r.b(r19)
            c.c.a.b.c.o.r.b(r20)
            r18.g()
            r18.q()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.u()     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            java.lang.String r11 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r1 = "value"
            java.lang.String r2 = "origin"
            java.lang.String[] r12 = new java.lang.String[]{r0, r1, r2}     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            r1 = 0
            r14[r1] = r19     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            r2 = 1
            r14[r2] = r8     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            boolean r3 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L7a
            if (r3 != 0) goto L3f
            if (r10 == 0) goto L3e
            r10.close()
        L3e:
            return r9
        L3f:
            long r5 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L7a
            r11 = r18
            java.lang.Object r7 = r11.a(r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            java.lang.String r3 = r10.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            c.c.a.b.g.b.t9 r0 = new c.c.a.b.g.b.t9     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            boolean r1 = r10.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            if (r1 == 0) goto L6e
            c.c.a.b.g.b.w3 r1 = r18.c()     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            c.c.a.b.g.b.y3 r1 = r1.t()     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = c.c.a.b.g.b.w3.a(r19)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            r1.a(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
        L6e:
            if (r10 == 0) goto L73
            r10.close()
        L73:
            return r0
        L74:
            r0 = move-exception
            goto L86
        L76:
            r0 = move-exception
            r11 = r18
            goto La6
        L7a:
            r0 = move-exception
            r11 = r18
            goto L86
        L7e:
            r0 = move-exception
            r11 = r18
            goto La7
        L82:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L86:
            c.c.a.b.g.b.w3 r1 = r18.c()     // Catch: java.lang.Throwable -> La5
            c.c.a.b.g.b.y3 r1 = r1.t()     // Catch: java.lang.Throwable -> La5
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = c.c.a.b.g.b.w3.a(r19)     // Catch: java.lang.Throwable -> La5
            c.c.a.b.g.b.u3 r4 = r18.i()     // Catch: java.lang.Throwable -> La5
            java.lang.String r4 = r4.c(r8)     // Catch: java.lang.Throwable -> La5
            r1.a(r2, r3, r4, r0)     // Catch: java.lang.Throwable -> La5
            if (r10 == 0) goto La4
            r10.close()
        La4:
            return r9
        La5:
            r0 = move-exception
        La6:
            r9 = r10
        La7:
            if (r9 == 0) goto Lac
            r9.close()
        Lac:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.c.c(java.lang.String, java.lang.String):c.c.a.b.g.b.t9");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzy d(java.lang.String r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.c.d(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzy");
    }

    public final int e(String str, String str2) {
        c.c.a.b.c.o.r.b(str);
        c.c.a.b.c.o.r.b(str2);
        g();
        q();
        try {
            return u().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            c().t().a("Error deleting conditional property", w3.a(str), i().c(str2), e2);
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b6  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.Integer, java.util.List<c.c.a.b.f.e.h0>> f(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.q()
            r12.g()
            c.c.a.b.c.o.r.b(r13)
            c.c.a.b.c.o.r.b(r14)
            a.e.a r0 = new a.e.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.u()
            r9 = 0
            java.lang.String r2 = "event_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L97 android.database.sqlite.SQLiteException -> L99
            java.lang.String r4 = "app_id=? AND event_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L97 android.database.sqlite.SQLiteException -> L99
            r10 = 0
            r5[r10] = r13     // Catch: java.lang.Throwable -> L97 android.database.sqlite.SQLiteException -> L99
            r11 = 1
            r5[r11] = r14     // Catch: java.lang.Throwable -> L97 android.database.sqlite.SQLiteException -> L99
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L97 android.database.sqlite.SQLiteException -> L99
            boolean r1 = r14.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            if (r1 != 0) goto L42
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            if (r14 == 0) goto L41
            r14.close()
        L41:
            return r13
        L42:
            byte[] r1 = r14.getBlob(r11)     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            c.c.a.b.f.e.h0$a r2 = c.c.a.b.f.e.h0.x()     // Catch: java.io.IOException -> L77 android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            c.c.a.b.g.b.p9.a(r2, r1)     // Catch: java.io.IOException -> L77 android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            c.c.a.b.f.e.h0$a r2 = (c.c.a.b.f.e.h0.a) r2     // Catch: java.io.IOException -> L77 android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            c.c.a.b.f.e.d6 r1 = r2.F()     // Catch: java.io.IOException -> L77 android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            c.c.a.b.f.e.s4 r1 = (c.c.a.b.f.e.s4) r1     // Catch: java.io.IOException -> L77 android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            c.c.a.b.f.e.h0 r1 = (c.c.a.b.f.e.h0) r1     // Catch: java.io.IOException -> L77 android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            int r2 = r14.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            java.lang.Object r3 = r0.get(r3)     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            java.util.List r3 = (java.util.List) r3     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            if (r3 != 0) goto L73
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            r0.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
        L73:
            r3.add(r1)     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            goto L89
        L77:
            r1 = move-exception
            c.c.a.b.g.b.w3 r2 = r12.c()     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            c.c.a.b.g.b.y3 r2 = r2.t()     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = c.c.a.b.g.b.w3.a(r13)     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            r2.a(r3, r4, r1)     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
        L89:
            boolean r1 = r14.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            if (r1 != 0) goto L42
            if (r14 == 0) goto L94
            r14.close()
        L94:
            return r0
        L95:
            r0 = move-exception
            goto L9b
        L97:
            r13 = move-exception
            goto Lb4
        L99:
            r0 = move-exception
            r14 = r9
        L9b:
            c.c.a.b.g.b.w3 r1 = r12.c()     // Catch: java.lang.Throwable -> Lb2
            c.c.a.b.g.b.y3 r1 = r1.t()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = c.c.a.b.g.b.w3.a(r13)     // Catch: java.lang.Throwable -> Lb2
            r1.a(r2, r13, r0)     // Catch: java.lang.Throwable -> Lb2
            if (r14 == 0) goto Lb1
            r14.close()
        Lb1:
            return r9
        Lb2:
            r13 = move-exception
            r9 = r14
        Lb4:
            if (r9 == 0) goto Lb9
            r9.close()
        Lb9:
            goto Lbb
        Lba:
            throw r13
        Lbb:
            goto Lba
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.c.f(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b6  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.Integer, java.util.List<c.c.a.b.f.e.k0>> g(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.q()
            r12.g()
            c.c.a.b.c.o.r.b(r13)
            c.c.a.b.c.o.r.b(r14)
            a.e.a r0 = new a.e.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.u()
            r9 = 0
            java.lang.String r2 = "property_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L97 android.database.sqlite.SQLiteException -> L99
            java.lang.String r4 = "app_id=? AND property_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L97 android.database.sqlite.SQLiteException -> L99
            r10 = 0
            r5[r10] = r13     // Catch: java.lang.Throwable -> L97 android.database.sqlite.SQLiteException -> L99
            r11 = 1
            r5[r11] = r14     // Catch: java.lang.Throwable -> L97 android.database.sqlite.SQLiteException -> L99
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L97 android.database.sqlite.SQLiteException -> L99
            boolean r1 = r14.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            if (r1 != 0) goto L42
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            if (r14 == 0) goto L41
            r14.close()
        L41:
            return r13
        L42:
            byte[] r1 = r14.getBlob(r11)     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            c.c.a.b.f.e.k0$a r2 = c.c.a.b.f.e.k0.u()     // Catch: java.io.IOException -> L77 android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            c.c.a.b.g.b.p9.a(r2, r1)     // Catch: java.io.IOException -> L77 android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            c.c.a.b.f.e.k0$a r2 = (c.c.a.b.f.e.k0.a) r2     // Catch: java.io.IOException -> L77 android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            c.c.a.b.f.e.d6 r1 = r2.F()     // Catch: java.io.IOException -> L77 android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            c.c.a.b.f.e.s4 r1 = (c.c.a.b.f.e.s4) r1     // Catch: java.io.IOException -> L77 android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            c.c.a.b.f.e.k0 r1 = (c.c.a.b.f.e.k0) r1     // Catch: java.io.IOException -> L77 android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            int r2 = r14.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            java.lang.Object r3 = r0.get(r3)     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            java.util.List r3 = (java.util.List) r3     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            if (r3 != 0) goto L73
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            r0.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
        L73:
            r3.add(r1)     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            goto L89
        L77:
            r1 = move-exception
            c.c.a.b.g.b.w3 r2 = r12.c()     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            c.c.a.b.g.b.y3 r2 = r2.t()     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = c.c.a.b.g.b.w3.a(r13)     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            r2.a(r3, r4, r1)     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
        L89:
            boolean r1 = r14.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L95 java.lang.Throwable -> Lb2
            if (r1 != 0) goto L42
            if (r14 == 0) goto L94
            r14.close()
        L94:
            return r0
        L95:
            r0 = move-exception
            goto L9b
        L97:
            r13 = move-exception
            goto Lb4
        L99:
            r0 = move-exception
            r14 = r9
        L9b:
            c.c.a.b.g.b.w3 r1 = r12.c()     // Catch: java.lang.Throwable -> Lb2
            c.c.a.b.g.b.y3 r1 = r1.t()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = c.c.a.b.g.b.w3.a(r13)     // Catch: java.lang.Throwable -> Lb2
            r1.a(r2, r13, r0)     // Catch: java.lang.Throwable -> Lb2
            if (r14 == 0) goto Lb1
            r14.close()
        Lb1:
            return r9
        Lb2:
            r13 = move-exception
            r9 = r14
        Lb4:
            if (r9 == 0) goto Lb9
            r9.close()
        Lb9:
            goto Lbb
        Lba:
            throw r13
        Lbb:
            goto Lba
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.c.g(java.lang.String, java.lang.String):java.util.Map");
    }

    public final long h(String str, String str2) {
        c.c.a.b.c.o.r.b(str);
        c.c.a.b.c.o.r.b(str2);
        g();
        q();
        SQLiteDatabase u = u();
        u.beginTransaction();
        long j2 = 0;
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str2);
            sb.append(" from app2 where app_id=?");
            try {
                try {
                    long a2 = a(sb.toString(), new String[]{str}, -1L);
                    if (a2 == -1) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("app_id", str);
                        contentValues.put("first_open_count", (Integer) 0);
                        contentValues.put("previous_install_count", (Integer) 0);
                        if (u.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                            c().t().a("Failed to insert column (got -1). appId", w3.a(str), str2);
                            u.endTransaction();
                            return -1L;
                        }
                        a2 = 0;
                    }
                    try {
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("app_id", str);
                        contentValues2.put(str2, Long.valueOf(1 + a2));
                        if (u.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                            c().t().a("Failed to update column (got 0). appId", w3.a(str), str2);
                            u.endTransaction();
                            return -1L;
                        }
                        u.setTransactionSuccessful();
                        u.endTransaction();
                        return a2;
                    } catch (SQLiteException e2) {
                        e = e2;
                        j2 = a2;
                        c().t().a("Error inserting column. appId", w3.a(str), str2, e);
                        u.endTransaction();
                        return j2;
                    }
                } catch (Throwable th) {
                    th = th;
                    u.endTransaction();
                    throw th;
                }
            } catch (SQLiteException e3) {
                e = e3;
            }
        } catch (SQLiteException e4) {
            e = e4;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // c.c.a.b.g.b.i9
    public final boolean s() {
        return false;
    }

    public final void t() {
        q();
        u().setTransactionSuccessful();
    }

    public final SQLiteDatabase u() {
        g();
        try {
            return this.f4623d.getWritableDatabase();
        } catch (SQLiteException e2) {
            c().w().a("Error opening database", e2);
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String v() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.u()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L24 android.database.sqlite.SQLiteException -> L29
            boolean r2 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r2 == 0) goto L1c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r0 == 0) goto L1b
            r0.close()
        L1b:
            return r1
        L1c:
            if (r0 == 0) goto L21
            r0.close()
        L21:
            return r1
        L22:
            r2 = move-exception
            goto L2b
        L24:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3f
        L29:
            r2 = move-exception
            r0 = r1
        L2b:
            c.c.a.b.g.b.w3 r3 = r6.c()     // Catch: java.lang.Throwable -> L3e
            c.c.a.b.g.b.y3 r3 = r3.t()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.a(r4, r2)     // Catch: java.lang.Throwable -> L3e
            if (r0 == 0) goto L3d
            r0.close()
        L3d:
            return r1
        L3e:
            r1 = move-exception
        L3f:
            if (r0 == 0) goto L44
            r0.close()
        L44:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.c.v():java.lang.String");
    }

    public final long w() {
        Cursor cursor = null;
        try {
            try {
                cursor = u().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -1L;
                }
                long j2 = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j2;
            } catch (SQLiteException e2) {
                c().t().a("Error querying raw events", e2);
                if (cursor != null) {
                    cursor.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final boolean x() {
        return d().getDatabasePath("google_app_measurement.db").exists();
    }

    public final void y() {
        q();
        u().beginTransaction();
    }

    public final void z() {
        q();
        u().endTransaction();
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x014c: MOVE (r18 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:71:0x014c */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final c.c.a.b.g.b.m a(java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.c.a(java.lang.String, java.lang.String):c.c.a.b.g.b.m");
    }

    public final void b(String str, String str2) {
        c.c.a.b.c.o.r.b(str);
        c.c.a.b.c.o.r.b(str2);
        g();
        q();
        try {
            u().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            c().t().a("Error deleting user property. appId", w3.a(str), i().c(str2), e2);
        }
    }

    public final Map<Integer, List<c.c.a.b.f.e.h0>> e(String str) {
        c.c.a.b.c.o.r.b(str);
        a.e.a aVar = new a.e.a();
        Cursor cursor = null;
        try {
            try {
                Cursor query = u().query("event_filters", new String[]{"audience_id", JThirdPlatFormInterface.KEY_DATA}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, List<c.c.a.b.f.e.h0>> emptyMap = Collections.emptyMap();
                    if (query != null) {
                        query.close();
                    }
                    return emptyMap;
                }
                do {
                    byte[] blob = query.getBlob(1);
                    try {
                        h0.a x = c.c.a.b.f.e.h0.x();
                        p9.a(x, blob);
                        c.c.a.b.f.e.h0 h0Var = (c.c.a.b.f.e.h0) ((c.c.a.b.f.e.s4) x.F());
                        if (h0Var.r()) {
                            int i2 = query.getInt(0);
                            List list = (List) aVar.get(Integer.valueOf(i2));
                            if (list == null) {
                                list = new ArrayList();
                                aVar.put(Integer.valueOf(i2), list);
                            }
                            list.add(h0Var);
                        }
                    } catch (IOException e2) {
                        c().t().a("Failed to merge filter. appId", w3.a(str), e2);
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return aVar;
            } catch (SQLiteException e3) {
                c().t().a("Database error querying filters. appId", w3.a(str), e3);
                Map<Integer, List<c.c.a.b.f.e.h0>> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<zzy> b(String str, String str2, String str3) {
        c.c.a.b.c.o.r.b(str);
        g();
        q();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return a(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final long c(String str) {
        c.c.a.b.c.o.r.b(str);
        g();
        q();
        try {
            return u().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, l().b(str, r.p))))});
        } catch (SQLiteException e2) {
            c().t().a("Error deleting over the limit events. appId", w3.a(str), e2);
            return 0L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009c  */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.Integer, c.c.a.b.f.e.d1> g(java.lang.String r12) {
        /*
            r11 = this;
            r11.q()
            r11.g()
            c.c.a.b.c.o.r.b(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.u()
            r8 = 0
            java.lang.String r1 = "audience_filter_values"
            java.lang.String r2 = "audience_id"
            java.lang.String r3 = "current_results"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L7f
            java.lang.String r3 = "app_id=?"
            r9 = 1
            java.lang.String[] r4 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L7f
            r10 = 0
            r4[r10] = r12     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L7f
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L7d android.database.sqlite.SQLiteException -> L7f
            boolean r1 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L98
            if (r1 != 0) goto L33
            if (r0 == 0) goto L32
            r0.close()
        L32:
            return r8
        L33:
            a.e.a r1 = new a.e.a     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L98
            r1.<init>()     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L98
        L38:
            int r2 = r0.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L98
            byte[] r3 = r0.getBlob(r9)     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L98
            c.c.a.b.f.e.d1$a r4 = c.c.a.b.f.e.d1.y()     // Catch: java.io.IOException -> L59 android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L98
            c.c.a.b.g.b.p9.a(r4, r3)     // Catch: java.io.IOException -> L59 android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L98
            c.c.a.b.f.e.d1$a r4 = (c.c.a.b.f.e.d1.a) r4     // Catch: java.io.IOException -> L59 android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L98
            c.c.a.b.f.e.d6 r3 = r4.F()     // Catch: java.io.IOException -> L59 android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L98
            c.c.a.b.f.e.s4 r3 = (c.c.a.b.f.e.s4) r3     // Catch: java.io.IOException -> L59 android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L98
            c.c.a.b.f.e.d1 r3 = (c.c.a.b.f.e.d1) r3     // Catch: java.io.IOException -> L59 android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L98
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L98
            r1.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L98
            goto L6f
        L59:
            r3 = move-exception
            c.c.a.b.g.b.w3 r4 = r11.c()     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L98
            c.c.a.b.g.b.y3 r4 = r4.t()     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L98
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = c.c.a.b.g.b.w3.a(r12)     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L98
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L98
            r4.a(r5, r6, r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L98
        L6f:
            boolean r2 = r0.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L7b java.lang.Throwable -> L98
            if (r2 != 0) goto L38
            if (r0 == 0) goto L7a
            r0.close()
        L7a:
            return r1
        L7b:
            r1 = move-exception
            goto L81
        L7d:
            r12 = move-exception
            goto L9a
        L7f:
            r1 = move-exception
            r0 = r8
        L81:
            c.c.a.b.g.b.w3 r2 = r11.c()     // Catch: java.lang.Throwable -> L98
            c.c.a.b.g.b.y3 r2 = r2.t()     // Catch: java.lang.Throwable -> L98
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r12 = c.c.a.b.g.b.w3.a(r12)     // Catch: java.lang.Throwable -> L98
            r2.a(r3, r12, r1)     // Catch: java.lang.Throwable -> L98
            if (r0 == 0) goto L97
            r0.close()
        L97:
            return r8
        L98:
            r12 = move-exception
            r8 = r0
        L9a:
            if (r8 == 0) goto L9f
            r8.close()
        L9f:
            goto La1
        La0:
            throw r12
        La1:
            goto La0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.c.g(java.lang.String):java.util.Map");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0086  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> f(java.lang.String r8) {
        /*
            r7 = this;
            r7.q()
            r7.g()
            c.c.a.b.c.o.r.b(r8)
            a.e.a r0 = new a.e.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r7.u()
            r2 = 0
            java.lang.String r3 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L69
            r5 = 0
            r4[r5] = r8     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L69
            r6 = 1
            r4[r6] = r8     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L69
            android.database.Cursor r1 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L69
            boolean r3 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            if (r3 != 0) goto L32
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            if (r1 == 0) goto L31
            r1.close()
        L31:
            return r8
        L32:
            int r3 = r1.getInt(r5)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            java.lang.Object r4 = r0.get(r4)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            java.util.List r4 = (java.util.List) r4     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            if (r4 != 0) goto L4e
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            r4.<init>()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            r0.put(r3, r4)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
        L4e:
            int r3 = r1.getInt(r6)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            r4.add(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L82
            if (r3 != 0) goto L32
            if (r1 == 0) goto L64
            r1.close()
        L64:
            return r0
        L65:
            r0 = move-exception
            goto L6b
        L67:
            r8 = move-exception
            goto L84
        L69:
            r0 = move-exception
            r1 = r2
        L6b:
            c.c.a.b.g.b.w3 r3 = r7.c()     // Catch: java.lang.Throwable -> L82
            c.c.a.b.g.b.y3 r3 = r3.t()     // Catch: java.lang.Throwable -> L82
            java.lang.String r4 = "Database error querying scoped filters. appId"
            java.lang.Object r8 = c.c.a.b.g.b.w3.a(r8)     // Catch: java.lang.Throwable -> L82
            r3.a(r4, r8, r0)     // Catch: java.lang.Throwable -> L82
            if (r1 == 0) goto L81
            r1.close()
        L81:
            return r2
        L82:
            r8 = move-exception
            r2 = r1
        L84:
            if (r2 == 0) goto L89
            r2.close()
        L89:
            goto L8b
        L8a:
            throw r8
        L8b:
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.c.f(java.lang.String):java.util.Map");
    }

    public final long h(String str) {
        c.c.a.b.c.o.r.b(str);
        return a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0159 A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:14:0x006f, B:16:0x00d0, B:20:0x00da, B:23:0x0124, B:25:0x0159, B:28:0x0167, B:29:0x0163, B:30:0x016a, B:32:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:45:0x01a8, B:47:0x01b3, B:48:0x01c5, B:50:0x01cb, B:52:0x01d7, B:53:0x01e0, B:55:0x01e9, B:60:0x01a4, B:62:0x011f), top: B:13:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0187 A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:14:0x006f, B:16:0x00d0, B:20:0x00da, B:23:0x0124, B:25:0x0159, B:28:0x0167, B:29:0x0163, B:30:0x016a, B:32:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:45:0x01a8, B:47:0x01b3, B:48:0x01c5, B:50:0x01cb, B:52:0x01d7, B:53:0x01e0, B:55:0x01e9, B:60:0x01a4, B:62:0x011f), top: B:13:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01b3 A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:14:0x006f, B:16:0x00d0, B:20:0x00da, B:23:0x0124, B:25:0x0159, B:28:0x0167, B:29:0x0163, B:30:0x016a, B:32:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:45:0x01a8, B:47:0x01b3, B:48:0x01c5, B:50:0x01cb, B:52:0x01d7, B:53:0x01e0, B:55:0x01e9, B:60:0x01a4, B:62:0x011f), top: B:13:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01cb A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:14:0x006f, B:16:0x00d0, B:20:0x00da, B:23:0x0124, B:25:0x0159, B:28:0x0167, B:29:0x0163, B:30:0x016a, B:32:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:45:0x01a8, B:47:0x01b3, B:48:0x01c5, B:50:0x01cb, B:52:0x01d7, B:53:0x01e0, B:55:0x01e9, B:60:0x01a4, B:62:0x011f), top: B:13:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e9 A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TRY_LEAVE, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:14:0x006f, B:16:0x00d0, B:20:0x00da, B:23:0x0124, B:25:0x0159, B:28:0x0167, B:29:0x0163, B:30:0x016a, B:32:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:45:0x01a8, B:47:0x01b3, B:48:0x01c5, B:50:0x01cb, B:52:0x01d7, B:53:0x01e0, B:55:0x01e9, B:60:0x01a4, B:62:0x011f), top: B:13:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a4 A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:14:0x006f, B:16:0x00d0, B:20:0x00da, B:23:0x0124, B:25:0x0159, B:28:0x0167, B:29:0x0163, B:30:0x016a, B:32:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:45:0x01a8, B:47:0x01b3, B:48:0x01c5, B:50:0x01cb, B:52:0x01d7, B:53:0x01e0, B:55:0x01e9, B:60:0x01a4, B:62:0x011f), top: B:13:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011f A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:14:0x006f, B:16:0x00d0, B:20:0x00da, B:23:0x0124, B:25:0x0159, B:28:0x0167, B:29:0x0163, B:30:0x016a, B:32:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:45:0x01a8, B:47:0x01b3, B:48:0x01c5, B:50:0x01cb, B:52:0x01d7, B:53:0x01e0, B:55:0x01e9, B:60:0x01a4, B:62:0x011f), top: B:13:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x022d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final c.c.a.b.g.b.d5 b(java.lang.String r35) {
        /*
            Method dump skipped, instructions count: 561
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.c.b(java.lang.String):c.c.a.b.g.b.d5");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] d(java.lang.String r11) {
        /*
            r10 = this;
            c.c.a.b.c.o.r.b(r11)
            r10.g()
            r10.q()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.u()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            java.lang.String r4 = "app_id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            r9 = 0
            r5[r9] = r11     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
            if (r2 != 0) goto L31
            if (r1 == 0) goto L30
            r1.close()
        L30:
            return r0
        L31:
            byte[] r2 = r1.getBlob(r9)     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
            if (r3 == 0) goto L4c
            c.c.a.b.g.b.w3 r3 = r10.c()     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
            c.c.a.b.g.b.y3 r3 = r3.t()     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
            java.lang.String r4 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r5 = c.c.a.b.g.b.w3.a(r11)     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
            r3.a(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
        L4c:
            if (r1 == 0) goto L51
            r1.close()
        L51:
            return r2
        L52:
            r2 = move-exception
            goto L58
        L54:
            r11 = move-exception
            goto L71
        L56:
            r2 = move-exception
            r1 = r0
        L58:
            c.c.a.b.g.b.w3 r3 = r10.c()     // Catch: java.lang.Throwable -> L6f
            c.c.a.b.g.b.y3 r3 = r3.t()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r11 = c.c.a.b.g.b.w3.a(r11)     // Catch: java.lang.Throwable -> L6f
            r3.a(r4, r11, r2)     // Catch: java.lang.Throwable -> L6f
            if (r1 == 0) goto L6e
            r1.close()
        L6e:
            return r0
        L6f:
            r11 = move-exception
            r0 = r1
        L71:
            if (r0 == 0) goto L76
            r0.close()
        L76:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.c.d(java.lang.String):byte[]");
    }

    public final void a(m mVar) {
        c.c.a.b.c.o.r.a(mVar);
        g();
        q();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", mVar.f4914a);
        contentValues.put("name", mVar.f4915b);
        contentValues.put("lifetime_count", Long.valueOf(mVar.f4916c));
        contentValues.put("current_bundle_count", Long.valueOf(mVar.f4917d));
        contentValues.put("last_fire_timestamp", Long.valueOf(mVar.f4919f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(mVar.f4920g));
        contentValues.put("last_bundled_day", mVar.f4921h);
        contentValues.put("last_sampled_complex_event_id", mVar.f4922i);
        contentValues.put("last_sampling_rate", mVar.j);
        contentValues.put("current_session_count", Long.valueOf(mVar.f4918e));
        Boolean bool = mVar.k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (u().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                c().t().a("Failed to insert/update event aggregates (got -1). appId", w3.a(mVar.f4914a));
            }
        } catch (SQLiteException e2) {
            c().t().a("Error storing event aggregates. appId", w3.a(mVar.f4914a), e2);
        }
    }

    public final boolean a(t9 t9Var) {
        c.c.a.b.c.o.r.a(t9Var);
        g();
        q();
        if (c(t9Var.f5104a, t9Var.f5106c) == null) {
            if (s9.h(t9Var.f5106c)) {
                if (b("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{t9Var.f5104a}) >= l().c(t9Var.f5104a)) {
                    return false;
                }
            } else if (!"_npa".equals(t9Var.f5106c) && b("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{t9Var.f5104a, t9Var.f5105b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", t9Var.f5104a);
        contentValues.put(OSSHeaders.ORIGIN, t9Var.f5105b);
        contentValues.put("name", t9Var.f5106c);
        contentValues.put("set_timestamp", Long.valueOf(t9Var.f5107d));
        a(contentValues, "value", t9Var.f5108e);
        try {
            if (u().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                c().t().a("Failed to insert/update user property (got -1). appId", w3.a(t9Var.f5104a));
            }
        } catch (SQLiteException e2) {
            c().t().a("Error storing user property. appId", w3.a(t9Var.f5104a), e2);
        }
        return true;
    }

    public final boolean b(String str, List<Integer> list) {
        c.c.a.b.c.o.r.b(str);
        q();
        g();
        SQLiteDatabase u = u();
        try {
            long b2 = b("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(RecyclerView.MAX_SCROLL_DURATION, l().b(str, r.F)));
            if (b2 <= max) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Integer num = list.get(i2);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 140);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return u.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e2) {
            c().t().a("Database error querying filters. appId", w3.a(str), e2);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<c.c.a.b.g.b.t9> a(java.lang.String r14) {
        /*
            r13 = this;
            c.c.a.b.c.o.r.b(r14)
            r13.g()
            r13.q()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r13.u()     // Catch: java.lang.Throwable -> L82 android.database.sqlite.SQLiteException -> L84
            java.lang.String r3 = "user_attributes"
            java.lang.String r4 = "name"
            java.lang.String r5 = "origin"
            java.lang.String r6 = "set_timestamp"
            java.lang.String r7 = "value"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7}     // Catch: java.lang.Throwable -> L82 android.database.sqlite.SQLiteException -> L84
            java.lang.String r5 = "app_id=?"
            r11 = 1
            java.lang.String[] r6 = new java.lang.String[r11]     // Catch: java.lang.Throwable -> L82 android.database.sqlite.SQLiteException -> L84
            r12 = 0
            r6[r12] = r14     // Catch: java.lang.Throwable -> L82 android.database.sqlite.SQLiteException -> L84
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1000"
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L82 android.database.sqlite.SQLiteException -> L84
            boolean r3 = r2.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            if (r3 != 0) goto L3f
            if (r2 == 0) goto L3e
            r2.close()
        L3e:
            return r0
        L3f:
            java.lang.String r7 = r2.getString(r12)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            java.lang.String r3 = r2.getString(r11)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            if (r3 != 0) goto L4b
            java.lang.String r3 = ""
        L4b:
            r6 = r3
            r3 = 2
            long r8 = r2.getLong(r3)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            r3 = 3
            java.lang.Object r10 = r13.a(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            if (r10 != 0) goto L6a
            c.c.a.b.g.b.w3 r3 = r13.c()     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            c.c.a.b.g.b.y3 r3 = r3.t()     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            java.lang.String r4 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r5 = c.c.a.b.g.b.w3.a(r14)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            r3.a(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            goto L74
        L6a:
            c.c.a.b.g.b.t9 r3 = new c.c.a.b.g.b.t9     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            r4 = r3
            r5 = r14
            r4.<init>(r5, r6, r7, r8, r10)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            r0.add(r3)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
        L74:
            boolean r3 = r2.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> L9d
            if (r3 != 0) goto L3f
            if (r2 == 0) goto L7f
            r2.close()
        L7f:
            return r0
        L80:
            r0 = move-exception
            goto L86
        L82:
            r14 = move-exception
            goto L9f
        L84:
            r0 = move-exception
            r2 = r1
        L86:
            c.c.a.b.g.b.w3 r3 = r13.c()     // Catch: java.lang.Throwable -> L9d
            c.c.a.b.g.b.y3 r3 = r3.t()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r4 = "Error querying user properties. appId"
            java.lang.Object r14 = c.c.a.b.g.b.w3.a(r14)     // Catch: java.lang.Throwable -> L9d
            r3.a(r4, r14, r0)     // Catch: java.lang.Throwable -> L9d
            if (r2 == 0) goto L9c
            r2.close()
        L9c:
            return r1
        L9d:
            r14 = move-exception
            r1 = r2
        L9f:
            if (r1 == 0) goto La4
            r1.close()
        La4:
            goto La6
        La5:
            throw r14
        La6:
            goto La5
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.c.a(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0090, code lost:
    
        c().t().a("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<c.c.a.b.g.b.t9> a(java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.c.a(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final boolean a(zzy zzyVar) {
        c.c.a.b.c.o.r.a(zzyVar);
        g();
        q();
        if (c(zzyVar.f10227a, zzyVar.f10229c.f10212b) == null && b("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzyVar.f10227a}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzyVar.f10227a);
        contentValues.put(OSSHeaders.ORIGIN, zzyVar.f10228b);
        contentValues.put("name", zzyVar.f10229c.f10212b);
        a(contentValues, "value", zzyVar.f10229c.zza());
        contentValues.put("active", Boolean.valueOf(zzyVar.f10231e));
        contentValues.put("trigger_event_name", zzyVar.f10232f);
        contentValues.put("trigger_timeout", Long.valueOf(zzyVar.f10234h));
        j();
        contentValues.put("timed_out_event", s9.a((Parcelable) zzyVar.f10233g));
        contentValues.put("creation_timestamp", Long.valueOf(zzyVar.f10230d));
        j();
        contentValues.put("triggered_event", s9.a((Parcelable) zzyVar.f10235i));
        contentValues.put("triggered_timestamp", Long.valueOf(zzyVar.f10229c.f10213c));
        contentValues.put("time_to_live", Long.valueOf(zzyVar.j));
        j();
        contentValues.put("expired_event", s9.a((Parcelable) zzyVar.k));
        try {
            if (u().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                c().t().a("Failed to insert/update conditional user property (got -1)", w3.a(zzyVar.f10227a));
            }
        } catch (SQLiteException e2) {
            c().t().a("Error storing conditional user property", w3.a(zzyVar.f10227a), e2);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
    
        c().t().a("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzy> a(java.lang.String r25, java.lang.String[] r26) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.c.a(java.lang.String, java.lang.String[]):java.util.List");
    }

    public final void a(d5 d5Var) {
        c.c.a.b.c.o.r.a(d5Var);
        g();
        q();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", d5Var.l());
        contentValues.put("app_instance_id", d5Var.m());
        contentValues.put("gmp_app_id", d5Var.n());
        contentValues.put("resettable_device_id_hash", d5Var.q());
        contentValues.put("last_bundle_index", Long.valueOf(d5Var.B()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(d5Var.s()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(d5Var.t()));
        contentValues.put("app_version", d5Var.u());
        contentValues.put("app_store", d5Var.w());
        contentValues.put("gmp_version", Long.valueOf(d5Var.x()));
        contentValues.put("dev_cert_hash", Long.valueOf(d5Var.y()));
        contentValues.put("measurement_enabled", Boolean.valueOf(d5Var.A()));
        contentValues.put("day", Long.valueOf(d5Var.F()));
        contentValues.put("daily_public_events_count", Long.valueOf(d5Var.G()));
        contentValues.put("daily_events_count", Long.valueOf(d5Var.H()));
        contentValues.put("daily_conversions_count", Long.valueOf(d5Var.I()));
        contentValues.put("config_fetched_time", Long.valueOf(d5Var.C()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(d5Var.D()));
        contentValues.put("app_version_int", Long.valueOf(d5Var.v()));
        contentValues.put("firebase_instance_id", d5Var.r());
        contentValues.put("daily_error_events_count", Long.valueOf(d5Var.c()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(d5Var.b()));
        contentValues.put("health_monitor_sample", d5Var.d());
        contentValues.put("android_id", Long.valueOf(d5Var.f()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(d5Var.g()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(d5Var.h()));
        contentValues.put("admob_app_id", d5Var.o());
        contentValues.put("dynamite_version", Long.valueOf(d5Var.z()));
        if (d5Var.j() != null) {
            if (d5Var.j().size() == 0) {
                c().w().a("Safelisted events should not be an empty list. appId", d5Var.l());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", d5Var.j()));
            }
        }
        if (oa.a() && l().e(d5Var.l(), r.p0)) {
            contentValues.put("ga_app_id", d5Var.p());
        }
        try {
            SQLiteDatabase u = u();
            if (u.update("apps", contentValues, "app_id = ?", new String[]{d5Var.l()}) == 0 && u.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                c().t().a("Failed to insert/update app (got -1). appId", w3.a(d5Var.l()));
            }
        } catch (SQLiteException e2) {
            c().t().a("Error storing app. appId", w3.a(d5Var.l()), e2);
        }
    }

    public final f a(long j2, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return a(j2, str, 1L, false, false, z3, false, z5);
    }

    public final f a(long j2, String str, long j3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        c.c.a.b.c.o.r.b(str);
        g();
        q();
        String[] strArr = {str};
        f fVar = new f();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase u = u();
                Cursor query = u.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    c().w().a("Not updating daily counts, app is not known. appId", w3.a(str));
                    if (query != null) {
                        query.close();
                    }
                    return fVar;
                }
                if (query.getLong(0) == j2) {
                    fVar.f4712b = query.getLong(1);
                    fVar.f4711a = query.getLong(2);
                    fVar.f4713c = query.getLong(3);
                    fVar.f4714d = query.getLong(4);
                    fVar.f4715e = query.getLong(5);
                }
                if (z) {
                    fVar.f4712b += j3;
                }
                if (z2) {
                    fVar.f4711a += j3;
                }
                if (z3) {
                    fVar.f4713c += j3;
                }
                if (z4) {
                    fVar.f4714d += j3;
                }
                if (z5) {
                    fVar.f4715e += j3;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j2));
                contentValues.put("daily_public_events_count", Long.valueOf(fVar.f4711a));
                contentValues.put("daily_events_count", Long.valueOf(fVar.f4712b));
                contentValues.put("daily_conversions_count", Long.valueOf(fVar.f4713c));
                contentValues.put("daily_error_events_count", Long.valueOf(fVar.f4714d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(fVar.f4715e));
                u.update("apps", contentValues, "app_id=?", strArr);
                if (query != null) {
                    query.close();
                }
                return fVar;
            } catch (SQLiteException e2) {
                c().t().a("Error updating daily counts. appId", w3.a(str), e2);
                if (0 != 0) {
                    cursor.close();
                }
                return fVar;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final boolean a(c.c.a.b.f.e.b1 b1Var, boolean z) {
        g();
        q();
        c.c.a.b.c.o.r.a(b1Var);
        c.c.a.b.c.o.r.b(b1Var.w0());
        c.c.a.b.c.o.r.b(b1Var.l0());
        B();
        long a2 = b().a();
        if (b1Var.m0() < a2 - b.w() || b1Var.m0() > b.w() + a2) {
            c().w().a("Storing bundle outside of the max uploading time span. appId, now, timestamp", w3.a(b1Var.w0()), Long.valueOf(a2), Long.valueOf(b1Var.m0()));
        }
        try {
            byte[] c2 = m().c(b1Var.g());
            c().B().a("Saving bundle, size", Integer.valueOf(c2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", b1Var.w0());
            contentValues.put("bundle_end_timestamp", Long.valueOf(b1Var.m0()));
            contentValues.put(JThirdPlatFormInterface.KEY_DATA, c2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (b1Var.O()) {
                contentValues.put("retry_count", Integer.valueOf(b1Var.Q()));
            }
            try {
                if (u().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                c().t().a("Failed to insert bundle (got -1). appId", w3.a(b1Var.w0()));
                return false;
            } catch (SQLiteException e2) {
                c().t().a("Error storing bundle. appId", w3.a(b1Var.w0()), e2);
                return false;
            }
        } catch (IOException e3) {
            c().t().a("Data loss. Failed to serialize bundle. appId", w3.a(b1Var.w0()), e3);
            return false;
        }
    }

    public final List<Pair<c.c.a.b.f.e.b1, Long>> a(String str, int i2, int i3) {
        byte[] b2;
        g();
        q();
        c.c.a.b.c.o.r.a(i2 > 0);
        c.c.a.b.c.o.r.a(i3 > 0);
        c.c.a.b.c.o.r.b(str);
        Cursor cursor = null;
        try {
            try {
                Cursor query = u().query("queue", new String[]{"rowid", JThirdPlatFormInterface.KEY_DATA, "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i2));
                if (!query.moveToFirst()) {
                    List<Pair<c.c.a.b.f.e.b1, Long>> emptyList = Collections.emptyList();
                    if (query != null) {
                        query.close();
                    }
                    return emptyList;
                }
                ArrayList arrayList = new ArrayList();
                int i4 = 0;
                do {
                    long j2 = query.getLong(0);
                    try {
                        b2 = m().b(query.getBlob(1));
                    } catch (IOException e2) {
                        c().t().a("Failed to unzip queued bundle. appId", w3.a(str), e2);
                    }
                    if (!arrayList.isEmpty() && b2.length + i4 > i3) {
                        break;
                    }
                    try {
                        b1.a z0 = c.c.a.b.f.e.b1.z0();
                        p9.a(z0, b2);
                        b1.a aVar = z0;
                        if (!query.isNull(2)) {
                            aVar.i(query.getInt(2));
                        }
                        i4 += b2.length;
                        arrayList.add(Pair.create((c.c.a.b.f.e.b1) ((c.c.a.b.f.e.s4) aVar.F()), Long.valueOf(j2)));
                    } catch (IOException e3) {
                        c().t().a("Failed to merge queued bundle. appId", w3.a(str), e3);
                    }
                    if (!query.moveToNext()) {
                        break;
                    }
                } while (i4 <= i3);
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e4) {
                c().t().a("Error querying bundles. appId", w3.a(str), e4);
                List<Pair<c.c.a.b.f.e.b1, Long>> emptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyList2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void a(List<Long> list) {
        g();
        q();
        c.c.a.b.c.o.r.a(list);
        c.c.a.b.c.o.r.a(list.size());
        if (x()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (b(sb3.toString(), (String[]) null) > 0) {
                c().w().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase u = u();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                u.execSQL(sb4.toString());
            } catch (SQLiteException e2) {
                c().t().a("Error incrementing retry count. error", e2);
            }
        }
    }

    public final boolean a(String str, int i2, c.c.a.b.f.e.h0 h0Var) {
        q();
        g();
        c.c.a.b.c.o.r.b(str);
        c.c.a.b.c.o.r.a(h0Var);
        if (TextUtils.isEmpty(h0Var.o())) {
            c().w().a("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", w3.a(str), Integer.valueOf(i2), String.valueOf(h0Var.zza() ? Integer.valueOf(h0Var.n()) : null));
            return false;
        }
        byte[] g2 = h0Var.g();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        contentValues.put("filter_id", h0Var.zza() ? Integer.valueOf(h0Var.n()) : null);
        contentValues.put("event_name", h0Var.o());
        contentValues.put("session_scoped", h0Var.v() ? Boolean.valueOf(h0Var.w()) : null);
        contentValues.put(JThirdPlatFormInterface.KEY_DATA, g2);
        try {
            if (u().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            c().t().a("Failed to insert event filter (got -1). appId", w3.a(str));
            return true;
        } catch (SQLiteException e2) {
            c().t().a("Error storing event filter. appId", w3.a(str), e2);
            return false;
        }
    }

    public final boolean a(String str, int i2, c.c.a.b.f.e.k0 k0Var) {
        q();
        g();
        c.c.a.b.c.o.r.b(str);
        c.c.a.b.c.o.r.a(k0Var);
        if (TextUtils.isEmpty(k0Var.o())) {
            c().w().a("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", w3.a(str), Integer.valueOf(i2), String.valueOf(k0Var.zza() ? Integer.valueOf(k0Var.n()) : null));
            return false;
        }
        byte[] g2 = k0Var.g();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        contentValues.put("filter_id", k0Var.zza() ? Integer.valueOf(k0Var.n()) : null);
        contentValues.put("property_name", k0Var.o());
        contentValues.put("session_scoped", k0Var.s() ? Boolean.valueOf(k0Var.t()) : null);
        contentValues.put(JThirdPlatFormInterface.KEY_DATA, g2);
        try {
            if (u().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            c().t().a("Failed to insert property filter (got -1). appId", w3.a(str));
            return false;
        } catch (SQLiteException e2) {
            c().t().a("Error storing property filter. appId", w3.a(str), e2);
            return false;
        }
    }

    public static void a(ContentValues contentValues, String str, Object obj) {
        c.c.a.b.c.o.r.b(str);
        c.c.a.b.c.o.r.a(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    public final Object a(Cursor cursor, int i2) {
        int type = cursor.getType(i2);
        if (type == 0) {
            c().t().a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i2));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i2));
        }
        if (type == 3) {
            return cursor.getString(i2);
        }
        if (type != 4) {
            c().t().a("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        c().t().a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    public final long a(c.c.a.b.f.e.b1 b1Var) throws IOException {
        g();
        q();
        c.c.a.b.c.o.r.a(b1Var);
        c.c.a.b.c.o.r.b(b1Var.w0());
        byte[] g2 = b1Var.g();
        long a2 = m().a(g2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", b1Var.w0());
        contentValues.put("metadata_fingerprint", Long.valueOf(a2));
        contentValues.put("metadata", g2);
        try {
            u().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return a2;
        } catch (SQLiteException e2) {
            c().t().a("Error storing raw event metadata. appId", w3.a(b1Var.w0()), e2);
            throw e2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(long r5) {
        /*
            r4 = this;
            r4.g()
            r4.q()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.u()     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            boolean r1 = r5.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r1 != 0) goto L34
            c.c.a.b.g.b.w3 r6 = r4.c()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            c.c.a.b.g.b.y3 r6 = r6.B()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.a(r1)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r5 == 0) goto L33
            r5.close()
        L33:
            return r0
        L34:
            java.lang.String r6 = r5.getString(r6)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r5 == 0) goto L3d
            r5.close()
        L3d:
            return r6
        L3e:
            r6 = move-exception
            goto L44
        L40:
            r6 = move-exception
            goto L59
        L42:
            r6 = move-exception
            r5 = r0
        L44:
            c.c.a.b.g.b.w3 r1 = r4.c()     // Catch: java.lang.Throwable -> L57
            c.c.a.b.g.b.y3 r1 = r1.t()     // Catch: java.lang.Throwable -> L57
            java.lang.String r2 = "Error selecting expired configs"
            r1.a(r2, r6)     // Catch: java.lang.Throwable -> L57
            if (r5 == 0) goto L56
            r5.close()
        L56:
            return r0
        L57:
            r6 = move-exception
            r0 = r5
        L59:
            if (r0 == 0) goto L5e
            r0.close()
        L5e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.c.a(long):java.lang.String");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0090: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x0090 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair<c.c.a.b.f.e.x0, java.lang.Long> a(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.g()
            r7.q()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.u()     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            r6 = 1
            r3[r6] = r5     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7a
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> L8f
            if (r2 != 0) goto L37
            c.c.a.b.g.b.w3 r8 = r7.c()     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> L8f
            c.c.a.b.g.b.y3 r8 = r8.B()     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> L8f
            java.lang.String r9 = "Main event not found"
            r8.a(r9)     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> L8f
            if (r1 == 0) goto L36
            r1.close()
        L36:
            return r0
        L37:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> L8f
            long r3 = r1.getLong(r6)     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> L8f
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> L8f
            c.c.a.b.f.e.x0$a r4 = c.c.a.b.f.e.x0.x()     // Catch: java.io.IOException -> L5e android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> L8f
            c.c.a.b.g.b.p9.a(r4, r2)     // Catch: java.io.IOException -> L5e android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> L8f
            c.c.a.b.f.e.x0$a r4 = (c.c.a.b.f.e.x0.a) r4     // Catch: java.io.IOException -> L5e android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> L8f
            c.c.a.b.f.e.d6 r2 = r4.F()     // Catch: java.io.IOException -> L5e android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> L8f
            c.c.a.b.f.e.s4 r2 = (c.c.a.b.f.e.s4) r2     // Catch: java.io.IOException -> L5e android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> L8f
            c.c.a.b.f.e.x0 r2 = (c.c.a.b.f.e.x0) r2     // Catch: java.io.IOException -> L5e android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> L8f
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> L8f
            if (r1 == 0) goto L5d
            r1.close()
        L5d:
            return r8
        L5e:
            r2 = move-exception
            c.c.a.b.g.b.w3 r3 = r7.c()     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> L8f
            c.c.a.b.g.b.y3 r3 = r3.t()     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> L8f
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = c.c.a.b.g.b.w3.a(r8)     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> L8f
            r3.a(r4, r8, r9, r2)     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> L8f
            if (r1 == 0) goto L75
            r1.close()
        L75:
            return r0
        L76:
            r8 = move-exception
            goto L7c
        L78:
            r8 = move-exception
            goto L91
        L7a:
            r8 = move-exception
            r1 = r0
        L7c:
            c.c.a.b.g.b.w3 r9 = r7.c()     // Catch: java.lang.Throwable -> L8f
            c.c.a.b.g.b.y3 r9 = r9.t()     // Catch: java.lang.Throwable -> L8f
            java.lang.String r2 = "Error selecting main event"
            r9.a(r2, r8)     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L8e
            r1.close()
        L8e:
            return r0
        L8f:
            r8 = move-exception
            r0 = r1
        L91:
            if (r0 == 0) goto L96
            r0.close()
        L96:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.g.b.c.a(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final boolean a(String str, Long l2, long j2, c.c.a.b.f.e.x0 x0Var) {
        g();
        q();
        c.c.a.b.c.o.r.a(x0Var);
        c.c.a.b.c.o.r.b(str);
        c.c.a.b.c.o.r.a(l2);
        byte[] g2 = x0Var.g();
        c().B().a("Saving complex main event, appId, data size", i().a(str), Integer.valueOf(g2.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l2);
        contentValues.put("children_to_process", Long.valueOf(j2));
        contentValues.put("main_event", g2);
        try {
            if (u().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            c().t().a("Failed to insert complex main event (got -1). appId", w3.a(str));
            return false;
        } catch (SQLiteException e2) {
            c().t().a("Error storing complex main event. appId", w3.a(str), e2);
            return false;
        }
    }

    public final boolean a(k kVar, long j2, boolean z) {
        g();
        q();
        c.c.a.b.c.o.r.a(kVar);
        c.c.a.b.c.o.r.b(kVar.f4841a);
        x0.a x = c.c.a.b.f.e.x0.x();
        x.b(kVar.f4845e);
        Iterator<String> it = kVar.f4846f.iterator();
        while (it.hasNext()) {
            String next = it.next();
            z0.a B = c.c.a.b.f.e.z0.B();
            B.a(next);
            m().a(B, kVar.f4846f.b(next));
            x.a(B);
        }
        byte[] g2 = ((c.c.a.b.f.e.x0) ((c.c.a.b.f.e.s4) x.F())).g();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", kVar.f4841a);
        contentValues.put("name", kVar.f4842b);
        contentValues.put("timestamp", Long.valueOf(kVar.f4844d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j2));
        contentValues.put(JThirdPlatFormInterface.KEY_DATA, g2);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (u().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            c().t().a("Failed to insert raw event (got -1). appId", w3.a(kVar.f4841a));
            return false;
        } catch (SQLiteException e2) {
            c().t().a("Error storing raw event. appId", w3.a(kVar.f4841a), e2);
            return false;
        }
    }

    public final void a(String str, List<c.c.a.b.f.e.g0> list) {
        boolean z;
        boolean z2;
        c.c.a.b.c.o.r.a(list);
        for (int i2 = 0; i2 < list.size(); i2++) {
            g0.a j2 = list.get(i2).j();
            if (j2.j() != 0) {
                for (int i3 = 0; i3 < j2.j(); i3++) {
                    h0.a j3 = j2.b(i3).j();
                    h0.a aVar = (h0.a) ((s4.b) j3.clone());
                    String a2 = a6.a(j3.zza());
                    if (a2 != null) {
                        aVar.a(a2);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i4 = 0; i4 < j3.j(); i4++) {
                        c.c.a.b.f.e.i0 a3 = j3.a(i4);
                        String a4 = z5.a(a3.t());
                        if (a4 != null) {
                            i0.a j4 = a3.j();
                            j4.a(a4);
                            aVar.a(i4, (c.c.a.b.f.e.i0) ((c.c.a.b.f.e.s4) j4.F()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        j2.a(i3, aVar);
                        list.set(i2, (c.c.a.b.f.e.g0) ((c.c.a.b.f.e.s4) j2.F()));
                    }
                }
            }
            if (j2.zza() != 0) {
                for (int i5 = 0; i5 < j2.zza(); i5++) {
                    c.c.a.b.f.e.k0 a5 = j2.a(i5);
                    String a6 = c6.a(a5.o());
                    if (a6 != null) {
                        k0.a j5 = a5.j();
                        j5.a(a6);
                        j2.a(i5, j5);
                        list.set(i2, (c.c.a.b.f.e.g0) ((c.c.a.b.f.e.s4) j2.F()));
                    }
                }
            }
        }
        q();
        g();
        c.c.a.b.c.o.r.b(str);
        c.c.a.b.c.o.r.a(list);
        SQLiteDatabase u = u();
        u.beginTransaction();
        try {
            q();
            g();
            c.c.a.b.c.o.r.b(str);
            SQLiteDatabase u2 = u();
            u2.delete("property_filters", "app_id=?", new String[]{str});
            u2.delete("event_filters", "app_id=?", new String[]{str});
            for (c.c.a.b.f.e.g0 g0Var : list) {
                q();
                g();
                c.c.a.b.c.o.r.b(str);
                c.c.a.b.c.o.r.a(g0Var);
                if (!g0Var.zza()) {
                    c().w().a("Audience with no ID. appId", w3.a(str));
                } else {
                    int n = g0Var.n();
                    Iterator<c.c.a.b.f.e.h0> it = g0Var.q().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().zza()) {
                                c().w().a("Event filter with no ID. Audience definition ignored. appId, audienceId", w3.a(str), Integer.valueOf(n));
                                break;
                            }
                        } else {
                            Iterator<c.c.a.b.f.e.k0> it2 = g0Var.o().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().zza()) {
                                        c().w().a("Property filter with no ID. Audience definition ignored. appId, audienceId", w3.a(str), Integer.valueOf(n));
                                        break;
                                    }
                                } else {
                                    Iterator<c.c.a.b.f.e.h0> it3 = g0Var.q().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!a(str, n, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<c.c.a.b.f.e.k0> it4 = g0Var.o().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!a(str, n, it4.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        q();
                                        g();
                                        c.c.a.b.c.o.r.b(str);
                                        SQLiteDatabase u3 = u();
                                        u3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(n)});
                                        u3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(n)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (c.c.a.b.f.e.g0 g0Var2 : list) {
                arrayList.add(g0Var2.zza() ? Integer.valueOf(g0Var2.n()) : null);
            }
            b(str, arrayList);
            u.setTransactionSuccessful();
        } finally {
            u.endTransaction();
        }
    }
}
