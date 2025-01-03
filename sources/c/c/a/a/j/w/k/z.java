package c.c.a.a.j.w.k;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import c.c.a.a.j.h;
import c.c.a.a.j.l;
import c.c.a.a.j.x.b;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
/* loaded from: classes.dex */
public class z implements c.c.a.a.j.w.k.c, c.c.a.a.j.x.b {

    /* renamed from: e, reason: collision with root package name */
    public static final c.c.a.a.b f3769e = c.c.a.a.b.a("proto");

    /* renamed from: a, reason: collision with root package name */
    public final e0 f3770a;

    /* renamed from: b, reason: collision with root package name */
    public final c.c.a.a.j.y.a f3771b;

    /* renamed from: c, reason: collision with root package name */
    public final c.c.a.a.j.y.a f3772c;

    /* renamed from: d, reason: collision with root package name */
    public final c.c.a.a.j.w.k.d f3773d;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public interface b<T, U> {
        U a(T t);
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f3774a;

        /* renamed from: b, reason: collision with root package name */
        public final String f3775b;

        public c(String str, String str2) {
            this.f3774a = str;
            this.f3775b = str2;
        }
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.0 */
    public interface d<T> {
        T a();
    }

    public z(c.c.a.a.j.y.a aVar, c.c.a.a.j.y.a aVar2, c.c.a.a.j.w.k.d dVar, e0 e0Var) {
        this.f3770a = e0Var;
        this.f3771b = aVar;
        this.f3772c = aVar2;
        this.f3773d = dVar;
    }

    public static /* synthetic */ SQLiteDatabase b(Throwable th) {
        throw new c.c.a.a.j.x.a("Timed out while trying to open db.", th);
    }

    public static String c(Iterable<h> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<h> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().b());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public final SQLiteDatabase a() {
        e0 e0Var = this.f3770a;
        e0Var.getClass();
        return (SQLiteDatabase) a(r.a(e0Var), t.a());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3770a.close();
    }

    public final boolean e() {
        return b() * c() >= this.f3773d.d();
    }

    @Override // c.c.a.a.j.w.k.c
    public int f() {
        return ((Integer) a(l.a(this.f3771b.a() - this.f3773d.b()))).intValue();
    }

    @Override // c.c.a.a.j.w.k.c
    public Iterable<c.c.a.a.j.l> n() {
        return (Iterable) a(k.a());
    }

    @Override // c.c.a.a.j.w.k.c
    public h a(c.c.a.a.j.l lVar, c.c.a.a.j.h hVar) {
        c.c.a.a.j.u.a.a("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", lVar.c(), hVar.f(), lVar.a());
        long longValue = ((Long) a(u.a(this, lVar, hVar))).longValue();
        if (longValue < 1) {
            return null;
        }
        return h.a(longValue, lVar, hVar);
    }

    public final Long b(SQLiteDatabase sQLiteDatabase, c.c.a.a.j.l lVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(lVar.a(), String.valueOf(c.c.a.a.j.z.a.a(lVar.c()))));
        if (lVar.b() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(lVar.b(), 0));
        }
        return (Long) a(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), v.a());
    }

    public static /* synthetic */ Long a(z zVar, c.c.a.a.j.l lVar, c.c.a.a.j.h hVar, SQLiteDatabase sQLiteDatabase) {
        if (zVar.e()) {
            return -1L;
        }
        long a2 = zVar.a(sQLiteDatabase, lVar);
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(a2));
        contentValues.put("transport_name", hVar.f());
        contentValues.put("timestamp_ms", Long.valueOf(hVar.d()));
        contentValues.put("uptime_ms", Long.valueOf(hVar.g()));
        contentValues.put("payload_encoding", hVar.c().b().a());
        contentValues.put("payload", hVar.c().a());
        contentValues.put(JThirdPlatFormInterface.KEY_CODE, hVar.b());
        contentValues.put("num_attempts", (Integer) 0);
        long insert = sQLiteDatabase.insert("events", null, contentValues);
        for (Map.Entry<String, String> entry : hVar.e().entrySet()) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("event_id", Long.valueOf(insert));
            contentValues2.put("name", entry.getKey());
            contentValues2.put("value", entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues2);
        }
        return Long.valueOf(insert);
    }

    @Override // c.c.a.a.j.w.k.c
    public boolean c(c.c.a.a.j.l lVar) {
        return ((Boolean) a(y.a(this, lVar))).booleanValue();
    }

    public static /* synthetic */ List c(SQLiteDatabase sQLiteDatabase) {
        return (List) a(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), q.a());
    }

    public static /* synthetic */ List c(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            l.a d2 = c.c.a.a.j.l.d();
            d2.a(cursor.getString(1));
            d2.a(c.c.a.a.j.z.a.a(cursor.getInt(2)));
            d2.a(b(cursor.getString(3)));
            arrayList.add(d2.a());
        }
        return arrayList;
    }

    public static /* synthetic */ Long b(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    @Override // c.c.a.a.j.w.k.c
    public void b(Iterable<h> iterable) {
        if (iterable.iterator().hasNext()) {
            a(w.a("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + c(iterable)));
        }
    }

    public final List<h> c(SQLiteDatabase sQLiteDatabase, c.c.a.a.j.l lVar) {
        ArrayList arrayList = new ArrayList();
        Long b2 = b(sQLiteDatabase, lVar);
        if (b2 == null) {
            return arrayList;
        }
        a(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", JThirdPlatFormInterface.KEY_CODE}, "context_id = ?", new String[]{b2.toString()}, null, null, null, String.valueOf(this.f3773d.c())), m.a(arrayList, lVar));
        return arrayList;
    }

    @Override // c.c.a.a.j.w.k.c
    public long b(c.c.a.a.j.l lVar) {
        return ((Long) a(a().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{lVar.a(), String.valueOf(c.c.a.a.j.z.a.a(lVar.c()))}), x.a())).longValue();
    }

    public static /* synthetic */ List b(z zVar, c.c.a.a.j.l lVar, SQLiteDatabase sQLiteDatabase) {
        List<h> c2 = zVar.c(sQLiteDatabase, lVar);
        zVar.a(c2, zVar.a(sQLiteDatabase, c2));
        return c2;
    }

    public static c.c.a.a.b c(String str) {
        if (str == null) {
            return f3769e;
        }
        return c.c.a.a.b.a(str);
    }

    public static byte[] b(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    public static /* synthetic */ Object b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    public final long a(SQLiteDatabase sQLiteDatabase, c.c.a.a.j.l lVar) {
        Long b2 = b(sQLiteDatabase, lVar);
        if (b2 != null) {
            return b2.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", lVar.a());
        contentValues.put("priority", Integer.valueOf(c.c.a.a.j.z.a.a(lVar.c())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (lVar.b() != null) {
            contentValues.put("extras", Base64.encodeToString(lVar.b(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    public final long c() {
        return a().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    public final long b() {
        return a().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    public static /* synthetic */ Object a(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 10").execute();
        return null;
    }

    @Override // c.c.a.a.j.w.k.c
    public void a(Iterable<h> iterable) {
        if (iterable.iterator().hasNext()) {
            a().compileStatement("DELETE FROM events WHERE _id in " + c(iterable)).execute();
        }
    }

    public static /* synthetic */ Long a(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    public static /* synthetic */ Boolean a(z zVar, c.c.a.a.j.l lVar, SQLiteDatabase sQLiteDatabase) {
        Long b2 = zVar.b(sQLiteDatabase, lVar);
        if (b2 == null) {
            return false;
        }
        return (Boolean) a(zVar.a().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{b2.toString()}), s.a());
    }

    @Override // c.c.a.a.j.w.k.c
    public void a(c.c.a.a.j.l lVar, long j) {
        a(i.a(j, lVar));
    }

    public static /* synthetic */ Object a(long j, c.c.a.a.j.l lVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{lVar.a(), String.valueOf(c.c.a.a.j.z.a.a(lVar.c()))}) < 1) {
            contentValues.put("backend_name", lVar.a());
            contentValues.put("priority", Integer.valueOf(c.c.a.a.j.z.a.a(lVar.c())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    @Override // c.c.a.a.j.w.k.c
    public Iterable<h> a(c.c.a.a.j.l lVar) {
        return (Iterable) a(j.a(this, lVar));
    }

    public static /* synthetic */ Object a(List list, c.c.a.a.j.l lVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            h.a i2 = c.c.a.a.j.h.i();
            i2.a(cursor.getString(1));
            i2.a(cursor.getLong(2));
            i2.b(cursor.getLong(3));
            i2.a(new c.c.a.a.j.g(c(cursor.getString(4)), cursor.getBlob(5)));
            if (!cursor.isNull(6)) {
                i2.a(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(h.a(j, lVar, i2.a()));
        }
        return null;
    }

    public final Map<Long, Set<c>> a(SQLiteDatabase sQLiteDatabase, List<h> list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(list.get(i2).b());
            if (i2 < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        a(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), n.a((Map) hashMap));
        return hashMap;
    }

    public static /* synthetic */ Object a(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j), set);
            }
            set.add(new c(cursor.getString(1), cursor.getString(2)));
        }
    }

    public final List<h> a(List<h> list, Map<Long, Set<c>> map) {
        ListIterator<h> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            h next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.b()))) {
                h.a h2 = next.a().h();
                for (c cVar : map.get(Long.valueOf(next.b()))) {
                    h2.a(cVar.f3774a, cVar.f3775b);
                }
                listIterator.set(h.a(next.b(), next.c(), h2.a()));
            }
        }
        return list;
    }

    public final <T> T a(d<T> dVar, b<Throwable, T> bVar) {
        long a2 = this.f3772c.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e2) {
                if (this.f3772c.a() >= this.f3773d.a() + a2) {
                    return bVar.a(e2);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        a(o.a(sQLiteDatabase), p.a());
    }

    public static /* synthetic */ Object a(Throwable th) {
        throw new c.c.a.a.j.x.a("Timed out while trying to acquire the lock.", th);
    }

    @Override // c.c.a.a.j.x.b
    public <T> T a(b.a<T> aVar) {
        SQLiteDatabase a2 = a();
        a(a2);
        try {
            T G = aVar.G();
            a2.setTransactionSuccessful();
            return G;
        } finally {
            a2.endTransaction();
        }
    }

    public final <T> T a(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase a2 = a();
        a2.beginTransaction();
        try {
            T a3 = bVar.a(a2);
            a2.setTransactionSuccessful();
            return a3;
        } finally {
            a2.endTransaction();
        }
    }

    public static <T> T a(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.a(cursor);
        } finally {
            cursor.close();
        }
    }
}
