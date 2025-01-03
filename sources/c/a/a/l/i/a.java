package c.a.a.l.i;

import android.util.Log;
import c.a.a.l.i.n.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: DecodeJob.java */
/* loaded from: classes.dex */
public class a<A, T, Z> {
    public static final b m = new b();

    /* renamed from: a, reason: collision with root package name */
    public final f f3056a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3057b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3058c;

    /* renamed from: d, reason: collision with root package name */
    public final c.a.a.l.h.c<A> f3059d;

    /* renamed from: e, reason: collision with root package name */
    public final c.a.a.o.b<A, T> f3060e;

    /* renamed from: f, reason: collision with root package name */
    public final c.a.a.l.g<T> f3061f;

    /* renamed from: g, reason: collision with root package name */
    public final c.a.a.l.k.j.c<T, Z> f3062g;

    /* renamed from: h, reason: collision with root package name */
    public final InterfaceC0064a f3063h;

    /* renamed from: i, reason: collision with root package name */
    public final c.a.a.l.i.b f3064i;
    public final c.a.a.g j;
    public final b k;
    public volatile boolean l;

    /* compiled from: DecodeJob.java */
    /* renamed from: c.a.a.l.i.a$a, reason: collision with other inner class name */
    public interface InterfaceC0064a {
        c.a.a.l.i.n.a a();
    }

    /* compiled from: DecodeJob.java */
    public static class b {
        public OutputStream a(File file) throws FileNotFoundException {
            return new BufferedOutputStream(new FileOutputStream(file));
        }
    }

    /* compiled from: DecodeJob.java */
    public class c<DataType> implements a.b {

        /* renamed from: a, reason: collision with root package name */
        public final c.a.a.l.b<DataType> f3065a;

        /* renamed from: b, reason: collision with root package name */
        public final DataType f3066b;

        public c(c.a.a.l.b<DataType> bVar, DataType datatype) {
            this.f3065a = bVar;
            this.f3066b = datatype;
        }

        @Override // c.a.a.l.i.n.a.b
        public boolean a(File file) {
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = a.this.k.a(file);
                    boolean a2 = this.f3065a.a(this.f3066b, outputStream);
                    if (outputStream == null) {
                        return a2;
                    }
                    try {
                        outputStream.close();
                        return a2;
                    } catch (IOException unused) {
                        return a2;
                    }
                } catch (FileNotFoundException e2) {
                    if (Log.isLoggable("DecodeJob", 3)) {
                        Log.d("DecodeJob", "Failed to find file to write to disk cache", e2);
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return false;
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        }
    }

    public a(f fVar, int i2, int i3, c.a.a.l.h.c<A> cVar, c.a.a.o.b<A, T> bVar, c.a.a.l.g<T> gVar, c.a.a.l.k.j.c<T, Z> cVar2, InterfaceC0064a interfaceC0064a, c.a.a.l.i.b bVar2, c.a.a.g gVar2) {
        this(fVar, i2, i3, cVar, bVar, gVar, cVar2, interfaceC0064a, bVar2, gVar2, m);
    }

    public k<Z> b() throws Exception {
        return c(d());
    }

    public k<Z> c() throws Exception {
        if (!this.f3064i.cacheResult()) {
            return null;
        }
        long a2 = c.a.a.r.d.a();
        k<T> a3 = a((c.a.a.l.c) this.f3056a);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Decoded transformed from cache", a2);
        }
        long a4 = c.a.a.r.d.a();
        k<Z> a5 = a((k) a3);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Transcoded transformed from cache", a4);
        }
        return a5;
    }

    public final void d(k<T> kVar) {
        if (kVar == null || !this.f3064i.cacheResult()) {
            return;
        }
        long a2 = c.a.a.r.d.a();
        this.f3063h.a().a(this.f3056a, new c(this.f3060e.e(), kVar));
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Wrote transformed from source to cache", a2);
        }
    }

    public k<Z> e() throws Exception {
        if (!this.f3064i.cacheSource()) {
            return null;
        }
        long a2 = c.a.a.r.d.a();
        k<T> a3 = a(this.f3056a.a());
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Decoded source from cache", a2);
        }
        return c(a3);
    }

    public a(f fVar, int i2, int i3, c.a.a.l.h.c<A> cVar, c.a.a.o.b<A, T> bVar, c.a.a.l.g<T> gVar, c.a.a.l.k.j.c<T, Z> cVar2, InterfaceC0064a interfaceC0064a, c.a.a.l.i.b bVar2, c.a.a.g gVar2, b bVar3) {
        this.f3056a = fVar;
        this.f3057b = i2;
        this.f3058c = i3;
        this.f3059d = cVar;
        this.f3060e = bVar;
        this.f3061f = gVar;
        this.f3062g = cVar2;
        this.f3063h = interfaceC0064a;
        this.f3064i = bVar2;
        this.j = gVar2;
        this.k = bVar3;
    }

    public void a() {
        this.l = true;
        this.f3059d.cancel();
    }

    public final k<T> b(A a2) throws IOException {
        if (this.f3064i.cacheSource()) {
            return a((a<A, T, Z>) a2);
        }
        long a3 = c.a.a.r.d.a();
        k<T> a4 = this.f3060e.f().a(a2, this.f3057b, this.f3058c);
        if (!Log.isLoggable("DecodeJob", 2)) {
            return a4;
        }
        a("Decoded from source", a3);
        return a4;
    }

    public final k<T> a(A a2) throws IOException {
        long a3 = c.a.a.r.d.a();
        this.f3063h.a().a(this.f3056a.a(), new c(this.f3060e.b(), a2));
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Wrote source to cache", a3);
        }
        long a4 = c.a.a.r.d.a();
        k<T> a5 = a(this.f3056a.a());
        if (Log.isLoggable("DecodeJob", 2) && a5 != null) {
            a("Decoded source from cache", a4);
        }
        return a5;
    }

    public final k<T> d() throws Exception {
        try {
            long a2 = c.a.a.r.d.a();
            A a3 = this.f3059d.a(this.j);
            if (Log.isLoggable("DecodeJob", 2)) {
                a("Fetched data", a2);
            }
            if (this.l) {
                return null;
            }
            return b((a<A, T, Z>) a3);
        } finally {
            this.f3059d.a();
        }
    }

    public final k<T> b(k<T> kVar) {
        if (kVar == null) {
            return null;
        }
        k<T> a2 = this.f3061f.a(kVar, this.f3057b, this.f3058c);
        if (!kVar.equals(a2)) {
            kVar.a();
        }
        return a2;
    }

    public final k<Z> c(k<T> kVar) {
        long a2 = c.a.a.r.d.a();
        k<T> b2 = b((k) kVar);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Transformed resource from source", a2);
        }
        d(b2);
        long a3 = c.a.a.r.d.a();
        k<Z> a4 = a((k) b2);
        if (Log.isLoggable("DecodeJob", 2)) {
            a("Transcoded transformed from source", a3);
        }
        return a4;
    }

    public final k<T> a(c.a.a.l.c cVar) throws IOException {
        File b2 = this.f3063h.a().b(cVar);
        if (b2 == null) {
            return null;
        }
        try {
            k<T> a2 = this.f3060e.a().a(b2, this.f3057b, this.f3058c);
            if (a2 == null) {
            }
            return a2;
        } finally {
            this.f3063h.a().a(cVar);
        }
    }

    public final k<Z> a(k<T> kVar) {
        if (kVar == null) {
            return null;
        }
        return this.f3062g.a(kVar);
    }

    public final void a(String str, long j) {
        Log.v("DecodeJob", str + " in " + c.a.a.r.d.a(j) + ", key: " + this.f3056a);
    }
}
