package c.c.a.c.l;

import java.util.Calendar;
import java.util.TimeZone;

/* compiled from: TimeSource.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: c, reason: collision with root package name */
    public static final o f5467c = new o(null, null);

    /* renamed from: a, reason: collision with root package name */
    public final Long f5468a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeZone f5469b;

    public o(Long l, TimeZone timeZone) {
        this.f5468a = l;
        this.f5469b = timeZone;
    }

    public static o b() {
        return f5467c;
    }

    public Calendar a() {
        return a(this.f5469b);
    }

    public Calendar a(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = this.f5468a;
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        return calendar;
    }
}
