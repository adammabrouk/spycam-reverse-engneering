package cn.jiguang.p;

import android.util.Base64;
import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f9036a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f9037b = new ConcurrentHashMap<>();

    public static String a(String str) {
        return new String(Base64.decode(str.getBytes(), 2));
    }

    public static String b(String str) {
        return Base64.encodeToString(str.getBytes(), 2);
    }
}
