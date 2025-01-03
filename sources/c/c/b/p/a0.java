package c.c.b.p;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.7 */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f6109a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6110b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6111c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque<String> f6112d = new ArrayDeque<>();

    /* renamed from: e, reason: collision with root package name */
    public final Executor f6113e;

    public a0(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.f6109a = sharedPreferences;
        this.f6110b = str;
        this.f6111c = str2;
        this.f6113e = executor;
    }

    public static a0 a(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        a0 a0Var = new a0(sharedPreferences, str, str2, executor);
        synchronized (a0Var.f6112d) {
            a0Var.f6112d.clear();
            String string = a0Var.f6109a.getString(a0Var.f6110b, "");
            if (!TextUtils.isEmpty(string) && string.contains(a0Var.f6111c)) {
                String[] split = string.split(a0Var.f6111c, -1);
                if (split.length == 0) {
                    Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                }
                for (String str3 : split) {
                    if (!TextUtils.isEmpty(str3)) {
                        a0Var.f6112d.add(str3);
                    }
                }
            }
        }
        return a0Var;
    }

    public final /* synthetic */ void b() {
        synchronized (this.f6112d) {
            SharedPreferences.Editor edit = this.f6109a.edit();
            String str = this.f6110b;
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.f6112d.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(this.f6111c);
            }
            edit.putString(str, sb.toString()).commit();
        }
    }

    public final boolean a(boolean z) {
        if (z) {
            this.f6113e.execute(new Runnable(this) { // from class: c.c.b.p.z

                /* renamed from: a, reason: collision with root package name */
                public final a0 f6169a;

                {
                    this.f6169a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f6169a.b();
                }
            });
        }
        return z;
    }

    public final boolean a(Object obj) {
        boolean remove;
        synchronized (this.f6112d) {
            remove = this.f6112d.remove(obj);
            a(remove);
        }
        return remove;
    }

    public final String a() {
        String peek;
        synchronized (this.f6112d) {
            peek = this.f6112d.peek();
        }
        return peek;
    }
}
