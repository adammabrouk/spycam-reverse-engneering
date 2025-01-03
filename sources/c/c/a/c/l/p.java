package c.c.a.c.l;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import com.google.android.material.R$string;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.shix.shixipc.utilcode.LogUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: UtcDates.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public static AtomicReference<o> f5470a = new AtomicReference<>();

    public static Calendar a(Calendar calendar) {
        Calendar b2 = b(calendar);
        Calendar f2 = f();
        f2.set(b2.get(1), b2.get(2), b2.get(5));
        return f2;
    }

    public static o b() {
        o oVar = f5470a.get();
        return oVar == null ? o.b() : oVar;
    }

    public static TimeZone c() {
        return TimeZone.getTimeZone(ISO8601Utils.UTC_ID);
    }

    public static Calendar d() {
        Calendar a2 = b().a();
        a2.set(11, 0);
        a2.set(12, 0);
        a2.set(13, 0);
        a2.set(14, 0);
        a2.setTimeZone(c());
        return a2;
    }

    @TargetApi(24)
    public static android.icu.util.TimeZone e() {
        return android.icu.util.TimeZone.getTimeZone(ISO8601Utils.UTC_ID);
    }

    public static Calendar f() {
        return b((Calendar) null);
    }

    @TargetApi(24)
    public static DateFormat g(Locale locale) {
        return a("yMMMEd", locale);
    }

    public static SimpleDateFormat h(Locale locale) {
        return b("LLLL, yyyy", locale);
    }

    public static java.text.DateFormat c(Locale locale) {
        return a(0, locale);
    }

    public static java.text.DateFormat e(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) d(locale);
        simpleDateFormat.applyPattern(a(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    @TargetApi(24)
    public static DateFormat f(Locale locale) {
        return a("yMMMd", locale);
    }

    public static SimpleDateFormat g() {
        return h(Locale.getDefault());
    }

    public static Calendar b(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(c());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    public static SimpleDateFormat b(String str, Locale locale) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, locale);
        simpleDateFormat.setTimeZone(c());
        return simpleDateFormat;
    }

    public static long a(long j) {
        Calendar f2 = f();
        f2.setTimeInMillis(j);
        return a(f2).getTimeInMillis();
    }

    public static java.text.DateFormat d(Locale locale) {
        return a(2, locale);
    }

    @TargetApi(24)
    public static DateFormat b(Locale locale) {
        return a("MMMEd", locale);
    }

    @TargetApi(24)
    public static DateFormat a(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(e());
        return instanceForSkeleton;
    }

    public static java.text.DateFormat a(int i2, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i2, locale);
        dateInstance.setTimeZone(c());
        return dateInstance;
    }

    public static SimpleDateFormat a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toLocalizedPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(c());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    public static String a(Resources resources, SimpleDateFormat simpleDateFormat) {
        String localizedPattern = simpleDateFormat.toLocalizedPattern();
        return localizedPattern.replaceAll("d", resources.getString(R$string.mtrl_picker_text_input_day_abbr)).replaceAll("M", resources.getString(R$string.mtrl_picker_text_input_month_abbr)).replaceAll("y", resources.getString(R$string.mtrl_picker_text_input_year_abbr));
    }

    @TargetApi(24)
    public static DateFormat a(Locale locale) {
        return a("MMMd", locale);
    }

    public static String a(String str) {
        int a2 = a(str, "yY", 1, 0);
        if (a2 >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int a3 = a(str, "EMd", 1, a2);
        if (a3 < str.length()) {
            str2 = "EMd,";
        }
        return str.replace(str.substring(a(str, str2, -1, a2) + 1, a3), LogUtils.PLACEHOLDER).trim();
    }

    public static int a(String str, String str2, int i2, int i3) {
        while (i3 >= 0 && i3 < str.length() && str2.indexOf(str.charAt(i3)) == -1) {
            if (str.charAt(i3) == '\'') {
                do {
                    i3 += i2;
                    if (i3 >= 0 && i3 < str.length()) {
                    }
                } while (str.charAt(i3) != '\'');
            }
            i3 += i2;
        }
        return i3;
    }
}
