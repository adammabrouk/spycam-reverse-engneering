package c.c.b.n;

import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-installations@@16.3.0 */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public static final long f6059a = TimeUnit.HOURS.toSeconds(1);

    static {
        Pattern.compile("\\AA[\\w-]{38}\\z");
    }

    public boolean a(c.c.b.n.q.d dVar) {
        return TextUtils.isEmpty(dVar.a()) || dVar.g() + dVar.b() < a() + f6059a;
    }

    public long a() {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }
}
