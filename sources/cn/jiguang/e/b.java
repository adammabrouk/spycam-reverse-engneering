package cn.jiguang.e;

import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.google.gson.internal.bind.util.ISO8601Utils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f8861b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> f8862c = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public static String f8860a = "yyyyMMdd_HHmm";

    /* renamed from: d, reason: collision with root package name */
    public static final TimeZone f8863d = TimeZone.getTimeZone(ISO8601Utils.UTC_ID);

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadLocal<SimpleDateFormat> f8864e = new ThreadLocal<SimpleDateFormat>() { // from class: cn.jiguang.e.b.1
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.ALTERNATIVE_ISO8601_DATE_FORMAT, Locale.ROOT);
            simpleDateFormat.setTimeZone(b.f8863d);
            return simpleDateFormat;
        }
    };

    public static class a extends ThreadLocal<SimpleDateFormat> {

        /* renamed from: a, reason: collision with root package name */
        public String f8865a;

        public a(String str) {
            this.f8865a = str;
        }

        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.f8865a, Locale.ENGLISH);
        }
    }

    public static long a(int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.roll(6, i2);
        return calendar.getTime().getTime();
    }

    public static String a() {
        return a("yyyyMMdd HH:mm:ss.SSS").format(new Date());
    }

    public static String a(Date date) {
        return f8864e.get().format(date);
    }

    public static SimpleDateFormat a(String str) {
        ThreadLocal<SimpleDateFormat> threadLocal = f8862c.get(str);
        if (threadLocal == null) {
            synchronized (f8861b) {
                threadLocal = f8862c.get(str);
                if (threadLocal == null) {
                    threadLocal = new a(str);
                    f8862c.put(str, threadLocal);
                }
            }
        }
        return threadLocal.get();
    }

    public static Date a(long j) {
        Calendar calendar = Calendar.getInstance(f8863d);
        calendar.setTimeInMillis(j);
        return calendar.getTime();
    }

    public static String b() {
        return a("yyyy-MM-dd_HH:mm:ss").format(new Date());
    }

    public static Date c() {
        return Calendar.getInstance(f8863d).getTime();
    }
}
