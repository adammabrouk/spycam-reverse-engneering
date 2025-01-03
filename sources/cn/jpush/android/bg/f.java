package cn.jpush.android.bg;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static Queue<Integer> f9592a = new ConcurrentLinkedQueue();

    public static int a() {
        if (f9592a.size() > 0) {
            return f9592a.poll().intValue();
        }
        return 0;
    }

    public static boolean a(int i2) {
        return f9592a.offer(Integer.valueOf(i2));
    }

    public static int b() {
        return f9592a.size();
    }

    public static boolean b(int i2) {
        return f9592a.contains(Integer.valueOf(i2));
    }
}
