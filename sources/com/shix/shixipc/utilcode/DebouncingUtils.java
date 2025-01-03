package com.shix.shixipc.utilcode;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class DebouncingUtils {
    public static final int CACHE_SIZE = 64;
    public static final long DEBOUNCING_DEFAULT_VALUE = 1000;
    public static final Map<String, Long> KEY_MILLIS_MAP = new ConcurrentHashMap(64);

    public DebouncingUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void clearIfNecessary(long j) {
        if (KEY_MILLIS_MAP.size() < 64) {
            return;
        }
        Iterator<Map.Entry<String, Long>> it = KEY_MILLIS_MAP.entrySet().iterator();
        while (it.hasNext()) {
            if (j >= it.next().getValue().longValue()) {
                it.remove();
            }
        }
    }

    public static boolean isValid(View view) {
        return isValid(view, 1000L);
    }

    public static boolean isValid(View view, long j) {
        return isValid(String.valueOf(view.hashCode()), j);
    }

    public static boolean isValid(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The key is null.");
        }
        if (j >= 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            clearIfNecessary(elapsedRealtime);
            Long l = KEY_MILLIS_MAP.get(str);
            if (l != null && elapsedRealtime < l.longValue()) {
                return false;
            }
            KEY_MILLIS_MAP.put(str, Long.valueOf(elapsedRealtime + j));
            return true;
        }
        throw new IllegalArgumentException("The duration is less than 0.");
    }
}
