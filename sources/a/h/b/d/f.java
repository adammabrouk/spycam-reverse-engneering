package a.h.b.d;

import a.h.i.h;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ResourcesCompat.java */
/* loaded from: classes.dex */
public final class f {

    /* compiled from: ResourcesCompat.java */
    public static abstract class a {

        /* compiled from: ResourcesCompat.java */
        /* renamed from: a.h.b.d.f$a$a, reason: collision with other inner class name */
        public class RunnableC0018a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Typeface f967a;

            public RunnableC0018a(Typeface typeface) {
                this.f967a = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a(this.f967a);
            }
        }

        /* compiled from: ResourcesCompat.java */
        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f969a;

            public b(int i2) {
                this.f969a = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a(this.f969a);
            }
        }

        public abstract void a(int i2);

        public abstract void a(Typeface typeface);

        public final void a(Typeface typeface, Handler handler) {
            a(handler).post(new RunnableC0018a(typeface));
        }

        public final void a(int i2, Handler handler) {
            a(handler).post(new b(i2));
        }

        public static Handler a(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }
    }

    /* compiled from: ResourcesCompat.java */
    public static final class b {

        /* compiled from: ResourcesCompat.java */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public static final Object f971a = new Object();

            /* renamed from: b, reason: collision with root package name */
            public static Method f972b;

            /* renamed from: c, reason: collision with root package name */
            public static boolean f973c;

            public static void a(Resources.Theme theme) {
                synchronized (f971a) {
                    if (!f973c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f972b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e2) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e2);
                        }
                        f973c = true;
                    }
                    if (f972b != null) {
                        try {
                            f972b.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e3) {
                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e3);
                            f972b = null;
                        }
                    }
                }
            }
        }

        /* compiled from: ResourcesCompat.java */
        /* renamed from: a.h.b.d.f$b$b, reason: collision with other inner class name */
        public static class C0019b {
            public static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                C0019b.a(theme);
            } else if (i2 >= 23) {
                a.a(theme);
            }
        }
    }

    public static Drawable a(Resources resources, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i2, theme) : resources.getDrawable(i2);
    }

    public static Typeface a(Context context, int i2) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i2, new TypedValue(), 0, null, null, false, false);
    }

    public static void a(Context context, int i2, a aVar, Handler handler) throws Resources.NotFoundException {
        h.a(aVar);
        if (context.isRestricted()) {
            aVar.a(-4, handler);
        } else {
            a(context, i2, new TypedValue(), 0, aVar, handler, false, false);
        }
    }

    public static Typeface a(Context context, int i2, TypedValue typedValue, int i3, a aVar) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i2, typedValue, i3, aVar, null, true, false);
    }

    public static Typeface a(Context context, int i2, TypedValue typedValue, int i3, a aVar, Handler handler, boolean z, boolean z2) {
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        Typeface a2 = a(context, resources, typedValue, i2, i3, aVar, handler, z, z2);
        if (a2 != null || aVar != null || z2) {
            return a2;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i2) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Typeface a(android.content.Context r15, android.content.res.Resources r16, android.util.TypedValue r17, int r18, int r19, a.h.b.d.f.a r20, android.os.Handler r21, boolean r22, boolean r23) {
        /*
            r0 = r16
            r1 = r17
            r4 = r18
            r5 = r19
            r9 = r20
            r10 = r21
            java.lang.String r11 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto Laa
            java.lang.String r12 = r2.toString()
            java.lang.String r1 = "res/"
            boolean r1 = r12.startsWith(r1)
            r13 = -3
            r14 = 0
            if (r1 != 0) goto L26
            if (r9 == 0) goto L25
            r9.a(r13, r10)
        L25:
            return r14
        L26:
            android.graphics.Typeface r1 = a.h.c.d.b(r0, r4, r5)
            if (r1 == 0) goto L32
            if (r9 == 0) goto L31
            r9.a(r1, r10)
        L31:
            return r1
        L32:
            if (r23 == 0) goto L35
            return r14
        L35:
            java.lang.String r1 = r12.toLowerCase()     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
            java.lang.String r2 = ".xml"
            boolean r1 = r1.endsWith(r2)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
            if (r1 == 0) goto L68
            android.content.res.XmlResourceParser r1 = r0.getXml(r4)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
            a.h.b.d.c$a r2 = a.h.b.d.c.a(r1, r0)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
            if (r2 != 0) goto L56
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r11, r0)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
            if (r9 == 0) goto L55
            r9.a(r13, r10)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
        L55:
            return r14
        L56:
            r1 = r15
            r3 = r16
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            android.graphics.Typeface r0 = a.h.c.d.a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
            return r0
        L68:
            r1 = r15
            android.graphics.Typeface r0 = a.h.c.d.a(r15, r0, r4, r12, r5)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
            if (r9 == 0) goto L78
            if (r0 == 0) goto L75
            r9.a(r0, r10)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
            goto L78
        L75:
            r9.a(r13, r10)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
        L78:
            return r0
        L79:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r11, r1, r0)
            goto La4
        L8f:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r11, r1, r0)
        La4:
            if (r9 == 0) goto La9
            r9.a(r13, r10)
        La9:
            return r14
        Laa:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r18)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.h.b.d.f.a(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, a.h.b.d.f$a, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
