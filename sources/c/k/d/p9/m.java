package c.k.d.p9;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import c.k.d.a7;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class m {

    /* renamed from: c, reason: collision with root package name */
    public static volatile m f7646c;

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f7647a;

    /* renamed from: b, reason: collision with root package name */
    public HashSet<a> f7648b = new HashSet<>();

    public static abstract class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public int f7649a;

        public a(int i2, String str) {
            this.f7649a = i2;
        }

        public abstract void a();

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.f7649a == ((a) obj).f7649a;
        }

        public int hashCode() {
            return this.f7649a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();
        }
    }

    public m(Context context) {
        this.f7647a = context.getSharedPreferences("mipush_oc", 0);
    }

    public static m a(Context context) {
        if (f7646c == null) {
            synchronized (m.class) {
                if (f7646c == null) {
                    f7646c = new m(context);
                }
            }
        }
        return f7646c;
    }

    public int a(int i2, int i3) {
        String b2 = b(i2);
        if (this.f7647a.contains(b2)) {
            return this.f7647a.getInt(b2, 0);
        }
        String a2 = a(i2);
        return this.f7647a.contains(a2) ? this.f7647a.getInt(a2, 0) : i3;
    }

    public final String a(int i2) {
        return "normal_oc_" + i2;
    }

    public String a(int i2, String str) {
        String b2 = b(i2);
        if (this.f7647a.contains(b2)) {
            return this.f7647a.getString(b2, null);
        }
        String a2 = a(i2);
        return this.f7647a.contains(a2) ? this.f7647a.getString(a2, null) : str;
    }

    public synchronized void a() {
        this.f7648b.clear();
    }

    public final void a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        Object obj = pair.second;
        if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
            }
        } else {
            String str2 = (String) obj;
            if (str.equals(a(a7.AppIsInstalledList.a()))) {
                str2 = c.k.d.h0.a(str2);
            }
            editor.putString(str, str2);
        }
    }

    public synchronized void a(a aVar) {
        if (!this.f7648b.contains(aVar)) {
            this.f7648b.add(aVar);
        }
    }

    public void a(List<Pair<Integer, Object>> list) {
        if (c.k.d.e.a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.f7647a.edit();
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null && pair.second != null) {
                a(edit, pair, a(((Integer) obj).intValue()));
            }
        }
        edit.commit();
    }

    public boolean a(int i2, boolean z) {
        String b2 = b(i2);
        if (this.f7647a.contains(b2)) {
            return this.f7647a.getBoolean(b2, false);
        }
        String a2 = a(i2);
        return this.f7647a.contains(a2) ? this.f7647a.getBoolean(a2, false) : z;
    }

    public final String b(int i2) {
        return "custom_oc_" + i2;
    }

    public void b() {
        c.k.a.a.a.c.c("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f7648b);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.run();
            }
        }
        hashSet.clear();
    }

    public void b(List<Pair<Integer, Object>> list) {
        if (c.k.d.e.a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.f7647a.edit();
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null) {
                String b2 = b(((Integer) obj).intValue());
                if (pair.second == null) {
                    edit.remove(b2);
                } else {
                    a(edit, pair, b2);
                }
            }
        }
        edit.commit();
    }
}
