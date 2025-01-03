package c.k.d;

import java.util.LinkedList;

/* loaded from: classes.dex */
public class g0 {

    /* renamed from: a, reason: collision with root package name */
    public LinkedList<a> f7140a = new LinkedList<>();

    public static class a {

        /* renamed from: d, reason: collision with root package name */
        public static final g0 f7141d = new g0();

        /* renamed from: a, reason: collision with root package name */
        public int f7142a;

        /* renamed from: b, reason: collision with root package name */
        public String f7143b;

        /* renamed from: c, reason: collision with root package name */
        public Object f7144c;

        public a(int i2, Object obj) {
            this.f7142a = i2;
            this.f7144c = obj;
        }
    }

    public static g0 a() {
        return a.f7141d;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized int m164a() {
        return this.f7140a.size();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized LinkedList<a> m165a() {
        LinkedList<a> linkedList;
        linkedList = this.f7140a;
        this.f7140a = new LinkedList<>();
        return linkedList;
    }

    /* renamed from: a, reason: collision with other method in class */
    public final void m166a() {
        if (this.f7140a.size() > 100) {
            this.f7140a.removeFirst();
        }
    }

    public synchronized void a(Object obj) {
        this.f7140a.add(new a(0, obj));
        m166a();
    }
}
