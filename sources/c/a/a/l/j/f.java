package c.a.a.l.j;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* compiled from: ImageVideoModelLoader.java */
/* loaded from: classes.dex */
public class f<A> implements l<A, g> {

    /* renamed from: a, reason: collision with root package name */
    public final l<A, InputStream> f3193a;

    /* renamed from: b, reason: collision with root package name */
    public final l<A, ParcelFileDescriptor> f3194b;

    /* compiled from: ImageVideoModelLoader.java */
    public static class a implements c.a.a.l.h.c<g> {

        /* renamed from: a, reason: collision with root package name */
        public final c.a.a.l.h.c<InputStream> f3195a;

        /* renamed from: b, reason: collision with root package name */
        public final c.a.a.l.h.c<ParcelFileDescriptor> f3196b;

        public a(c.a.a.l.h.c<InputStream> cVar, c.a.a.l.h.c<ParcelFileDescriptor> cVar2) {
            this.f3195a = cVar;
            this.f3196b = cVar2;
        }

        @Override // c.a.a.l.h.c
        public String c() {
            c.a.a.l.h.c<InputStream> cVar = this.f3195a;
            return cVar != null ? cVar.c() : this.f3196b.c();
        }

        @Override // c.a.a.l.h.c
        public void cancel() {
            c.a.a.l.h.c<InputStream> cVar = this.f3195a;
            if (cVar != null) {
                cVar.cancel();
            }
            c.a.a.l.h.c<ParcelFileDescriptor> cVar2 = this.f3196b;
            if (cVar2 != null) {
                cVar2.cancel();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // c.a.a.l.h.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public c.a.a.l.j.g a(c.a.a.g r6) throws java.lang.Exception {
            /*
                r5 = this;
                c.a.a.l.h.c<java.io.InputStream> r0 = r5.f3195a
                r1 = 2
                r2 = 0
                java.lang.String r3 = "IVML"
                if (r0 == 0) goto L21
                java.lang.Object r0 = r0.a(r6)     // Catch: java.lang.Exception -> Lf
                java.io.InputStream r0 = (java.io.InputStream) r0     // Catch: java.lang.Exception -> Lf
                goto L22
            Lf:
                r0 = move-exception
                boolean r4 = android.util.Log.isLoggable(r3, r1)
                if (r4 == 0) goto L1b
                java.lang.String r4 = "Exception fetching input stream, trying ParcelFileDescriptor"
                android.util.Log.v(r3, r4, r0)
            L1b:
                c.a.a.l.h.c<android.os.ParcelFileDescriptor> r4 = r5.f3196b
                if (r4 == 0) goto L20
                goto L21
            L20:
                throw r0
            L21:
                r0 = r2
            L22:
                c.a.a.l.h.c<android.os.ParcelFileDescriptor> r4 = r5.f3196b
                if (r4 == 0) goto L3e
                java.lang.Object r6 = r4.a(r6)     // Catch: java.lang.Exception -> L2e
                android.os.ParcelFileDescriptor r6 = (android.os.ParcelFileDescriptor) r6     // Catch: java.lang.Exception -> L2e
                r2 = r6
                goto L3e
            L2e:
                r6 = move-exception
                boolean r1 = android.util.Log.isLoggable(r3, r1)
                if (r1 == 0) goto L3a
                java.lang.String r1 = "Exception fetching ParcelFileDescriptor"
                android.util.Log.v(r3, r1, r6)
            L3a:
                if (r0 == 0) goto L3d
                goto L3e
            L3d:
                throw r6
            L3e:
                c.a.a.l.j.g r6 = new c.a.a.l.j.g
                r6.<init>(r0, r2)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: c.a.a.l.j.f.a.a(c.a.a.g):c.a.a.l.j.g");
        }

        @Override // c.a.a.l.h.c
        public void a() {
            c.a.a.l.h.c<InputStream> cVar = this.f3195a;
            if (cVar != null) {
                cVar.a();
            }
            c.a.a.l.h.c<ParcelFileDescriptor> cVar2 = this.f3196b;
            if (cVar2 != null) {
                cVar2.a();
            }
        }
    }

    public f(l<A, InputStream> lVar, l<A, ParcelFileDescriptor> lVar2) {
        if (lVar == null && lVar2 == null) {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.f3193a = lVar;
        this.f3194b = lVar2;
    }

    @Override // c.a.a.l.j.l
    public c.a.a.l.h.c<g> a(A a2, int i2, int i3) {
        l<A, InputStream> lVar = this.f3193a;
        c.a.a.l.h.c<InputStream> a3 = lVar != null ? lVar.a(a2, i2, i3) : null;
        l<A, ParcelFileDescriptor> lVar2 = this.f3194b;
        c.a.a.l.h.c<ParcelFileDescriptor> a4 = lVar2 != null ? lVar2.a(a2, i2, i3) : null;
        if (a3 == null && a4 == null) {
            return null;
        }
        return new a(a3, a4);
    }
}
