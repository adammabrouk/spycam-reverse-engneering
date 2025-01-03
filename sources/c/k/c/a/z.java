package c.k.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class z {

    /* renamed from: c, reason: collision with root package name */
    public static volatile z f6938c;

    /* renamed from: a, reason: collision with root package name */
    public Context f6939a;

    /* renamed from: b, reason: collision with root package name */
    public List<o1> f6940b = new ArrayList();

    public z(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f6939a = applicationContext;
        if (applicationContext == null) {
            this.f6939a = context;
        }
    }

    public static z a(Context context) {
        if (f6938c == null) {
            synchronized (z.class) {
                if (f6938c == null) {
                    f6938c = new z(context);
                }
            }
        }
        return f6938c;
    }

    public int a(String str) {
        synchronized (this.f6940b) {
            o1 o1Var = new o1();
            o1Var.f6879b = str;
            if (this.f6940b.contains(o1Var)) {
                for (o1 o1Var2 : this.f6940b) {
                    if (o1Var2.equals(o1Var)) {
                        return o1Var2.f6878a;
                    }
                }
            }
            return 0;
        }
    }

    public synchronized String a(n0 n0Var) {
        return this.f6939a.getSharedPreferences("mipush_extra", 0).getString(n0Var.name(), "");
    }

    public synchronized void a(n0 n0Var, String str) {
        SharedPreferences sharedPreferences = this.f6939a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(n0Var.name(), str).commit();
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m62a(String str) {
        synchronized (this.f6940b) {
            o1 o1Var = new o1();
            o1Var.f6878a = 0;
            o1Var.f6879b = str;
            if (this.f6940b.contains(o1Var)) {
                this.f6940b.remove(o1Var);
            }
            this.f6940b.add(o1Var);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m63a(String str) {
        synchronized (this.f6940b) {
            o1 o1Var = new o1();
            o1Var.f6879b = str;
            return this.f6940b.contains(o1Var);
        }
    }

    public void b(String str) {
        synchronized (this.f6940b) {
            o1 o1Var = new o1();
            o1Var.f6879b = str;
            if (this.f6940b.contains(o1Var)) {
                Iterator<o1> it = this.f6940b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    o1 next = it.next();
                    if (o1Var.equals(next)) {
                        o1Var = next;
                        break;
                    }
                }
            }
            o1Var.f6878a++;
            this.f6940b.remove(o1Var);
            this.f6940b.add(o1Var);
        }
    }

    public void c(String str) {
        synchronized (this.f6940b) {
            o1 o1Var = new o1();
            o1Var.f6879b = str;
            if (this.f6940b.contains(o1Var)) {
                this.f6940b.remove(o1Var);
            }
        }
    }
}
