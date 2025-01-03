package h.e0.g;

import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: HttpDate.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<DateFormat> f11459a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f11460b;

    /* renamed from: c, reason: collision with root package name */
    public static final DateFormat[] f11461c;

    /* compiled from: HttpDate.java */
    public class a extends ThreadLocal<DateFormat> {
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.RFC822_DATE_FORMAT, Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(h.e0.c.o);
            return simpleDateFormat;
        }
    }

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f11460b = strArr;
        f11461c = new DateFormat[strArr.length];
    }

    public static Date a(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = f11459a.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        synchronized (f11460b) {
            int length = f11460b.length;
            for (int i2 = 0; i2 < length; i2++) {
                DateFormat dateFormat = f11461c[i2];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f11460b[i2], Locale.US);
                    dateFormat.setTimeZone(h.e0.c.o);
                    f11461c[i2] = dateFormat;
                }
                parsePosition.setIndex(0);
                Date parse2 = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            return null;
        }
    }

    public static String a(Date date) {
        return f11459a.get().format(date);
    }
}
