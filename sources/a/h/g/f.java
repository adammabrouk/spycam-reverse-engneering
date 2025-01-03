package a.h.g;

import a.h.i.h;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: FontsContractCompat.java */
/* loaded from: classes.dex */
public class f {

    /* compiled from: FontsContractCompat.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f1048a;

        /* renamed from: b, reason: collision with root package name */
        public final b[] f1049b;

        @Deprecated
        public a(int i2, b[] bVarArr) {
            this.f1048a = i2;
            this.f1049b = bVarArr;
        }

        public b[] a() {
            return this.f1049b;
        }

        public int b() {
            return this.f1048a;
        }

        public static a a(int i2, b[] bVarArr) {
            return new a(i2, bVarArr);
        }
    }

    /* compiled from: FontsContractCompat.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f1050a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1051b;

        /* renamed from: c, reason: collision with root package name */
        public final int f1052c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f1053d;

        /* renamed from: e, reason: collision with root package name */
        public final int f1054e;

        @Deprecated
        public b(Uri uri, int i2, int i3, boolean z, int i4) {
            h.a(uri);
            this.f1050a = uri;
            this.f1051b = i2;
            this.f1052c = i3;
            this.f1053d = z;
            this.f1054e = i4;
        }

        public static b a(Uri uri, int i2, int i3, boolean z, int i4) {
            return new b(uri, i2, i3, z, i4);
        }

        public int b() {
            return this.f1051b;
        }

        public Uri c() {
            return this.f1050a;
        }

        public int d() {
            return this.f1052c;
        }

        public boolean e() {
            return this.f1053d;
        }

        public int a() {
            return this.f1054e;
        }
    }

    /* compiled from: FontsContractCompat.java */
    public static class c {
        public void a(int i2) {
            throw null;
        }

        public void a(Typeface typeface) {
            throw null;
        }
    }

    public static Typeface a(Context context, d dVar, int i2, boolean z, int i3, Handler handler, c cVar) {
        a.h.g.a aVar = new a.h.g.a(cVar, handler);
        return z ? e.a(context, dVar, aVar, i2, i3) : e.a(context, dVar, i2, (Executor) null, aVar);
    }
}
