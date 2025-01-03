package cn.jpush.android.ad;

import android.util.ArrayMap;
import com.shix.shixipc.utilcode.TimeConstants;
import java.util.Map;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile b f9087a;

    /* renamed from: b, reason: collision with root package name */
    public static Map<String, Integer> f9088b = new ArrayMap();

    /* renamed from: c, reason: collision with root package name */
    public static Map<String, Integer> f9089c = new ArrayMap();

    static {
        f9088b.put("JUnionAdLoad", Integer.valueOf(TimeConstants.MIN));
        f9089c.put("JUnionAdLoad", Integer.valueOf(TimeConstants.HOUR));
    }

    public static b a() {
        if (f9087a == null) {
            synchronized (b.class) {
                if (f9087a == null) {
                    f9087a = new b();
                }
            }
        }
        return f9087a;
    }

    public int a(String str) {
        Integer num;
        Map<String, Integer> map = f9089c;
        return (map == null || (num = map.get(str)) == null) ? TimeConstants.DAY : num.intValue();
    }

    public int b(String str) {
        Integer num;
        Map<String, Integer> map = f9088b;
        return (map == null || (num = map.get(str)) == null) ? TimeConstants.DAY : num.intValue();
    }
}
