package a.m;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ViewModel.java */
/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f1541a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f1542b = false;

    public final void a() {
        this.f1542b = true;
        Map<String, Object> map = this.f1541a;
        if (map != null) {
            synchronized (map) {
                Iterator<Object> it = this.f1541a.values().iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            }
        }
        b();
    }

    public void b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T a(String str, T t) {
        Object obj;
        synchronized (this.f1541a) {
            obj = this.f1541a.get(str);
            if (obj == 0) {
                this.f1541a.put(str, t);
            }
        }
        if (obj != 0) {
            t = obj;
        }
        if (this.f1542b) {
            a(t);
        }
        return t;
    }

    public <T> T a(String str) {
        T t;
        Map<String, Object> map = this.f1541a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t = (T) this.f1541a.get(str);
        }
        return t;
    }

    public static void a(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }
}
