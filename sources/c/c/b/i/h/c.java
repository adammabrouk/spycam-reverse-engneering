package c.c.b.i.h;

import c.c.b.i.f;
import c.c.b.i.g;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.google.gson.internal.bind.util.ISO8601Utils;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object<c.c.b.i.h.c>] */
/* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final f<String> f5884c = c.c.b.i.h.a.a();

    /* renamed from: d, reason: collision with root package name */
    public static final f<Boolean> f5885d = c.c.b.i.h.b.a();

    /* renamed from: e, reason: collision with root package name */
    public static final b f5886e = new b(null);

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, c.c.b.i.d<?>> f5887a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, f<?>> f5888b = new HashMap();

    /* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
    public static final class b implements f<Date> {

        /* renamed from: a, reason: collision with root package name */
        public static final DateFormat f5890a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.ISO8601_DATE_FORMAT, Locale.US);
            f5890a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(ISO8601Utils.UTC_ID));
        }

        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // c.c.b.i.b
        public void a(Date date, g gVar) throws c.c.b.i.c, IOException {
            gVar.a(f5890a.format(date));
        }
    }

    public c() {
        a(String.class, f5884c);
        a(Boolean.class, f5885d);
        a(Date.class, f5886e);
    }

    /* compiled from: com.google.firebase:firebase-encoders-json@@16.0.0 */
    public class a implements c.c.b.i.a {
        public a() {
        }

        @Override // c.c.b.i.a
        public void a(Object obj, Writer writer) throws IOException, c.c.b.i.c {
            d dVar = new d(writer, c.this.f5887a, c.this.f5888b);
            dVar.a(obj);
            dVar.a();
        }

        @Override // c.c.b.i.a
        public String a(Object obj) throws c.c.b.i.c {
            StringWriter stringWriter = new StringWriter();
            try {
                a(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }

    public <T> c a(Class<T> cls, c.c.b.i.d<? super T> dVar) {
        if (!this.f5887a.containsKey(cls)) {
            this.f5887a.put(cls, dVar);
            return this;
        }
        throw new IllegalArgumentException("Encoder already registered for " + cls.getName());
    }

    public <T> c a(Class<T> cls, f<? super T> fVar) {
        if (!this.f5888b.containsKey(cls)) {
            this.f5888b.put(cls, fVar);
            return this;
        }
        throw new IllegalArgumentException("Encoder already registered for " + cls.getName());
    }

    public c.c.b.i.a a() {
        return new a();
    }
}
