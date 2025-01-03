package h;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* compiled from: RequestBody.java */
/* loaded from: classes.dex */
public abstract class z {

    /* compiled from: RequestBody.java */
    public class a extends z {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f11799a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i.f f11800b;

        public a(u uVar, i.f fVar) {
            this.f11799a = uVar;
            this.f11800b = fVar;
        }

        @Override // h.z
        public long contentLength() throws IOException {
            return this.f11800b.size();
        }

        @Override // h.z
        @Nullable
        public u contentType() {
            return this.f11799a;
        }

        @Override // h.z
        public void writeTo(i.d dVar) throws IOException {
            dVar.a(this.f11800b);
        }
    }

    /* compiled from: RequestBody.java */
    public class b extends z {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f11801a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f11802b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ byte[] f11803c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f11804d;

        public b(u uVar, int i2, byte[] bArr, int i3) {
            this.f11801a = uVar;
            this.f11802b = i2;
            this.f11803c = bArr;
            this.f11804d = i3;
        }

        @Override // h.z
        public long contentLength() {
            return this.f11802b;
        }

        @Override // h.z
        @Nullable
        public u contentType() {
            return this.f11801a;
        }

        @Override // h.z
        public void writeTo(i.d dVar) throws IOException {
            dVar.write(this.f11803c, this.f11804d, this.f11802b);
        }
    }

    /* compiled from: RequestBody.java */
    public class c extends z {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f11805a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ File f11806b;

        public c(u uVar, File file) {
            this.f11805a = uVar;
            this.f11806b = file;
        }

        @Override // h.z
        public long contentLength() {
            return this.f11806b.length();
        }

        @Override // h.z
        @Nullable
        public u contentType() {
            return this.f11805a;
        }

        @Override // h.z
        public void writeTo(i.d dVar) throws IOException {
            i.s sVar = null;
            try {
                sVar = i.l.a(this.f11806b);
                dVar.a(sVar);
            } finally {
                h.e0.c.a(sVar);
            }
        }
    }

    public static z create(@Nullable u uVar, String str) {
        Charset charset = h.e0.c.j;
        if (uVar != null && (charset = uVar.a()) == null) {
            charset = h.e0.c.j;
            uVar = u.b(uVar + "; charset=utf-8");
        }
        return create(uVar, str.getBytes(charset));
    }

    public abstract long contentLength() throws IOException;

    @Nullable
    public abstract u contentType();

    public abstract void writeTo(i.d dVar) throws IOException;

    public static z create(@Nullable u uVar, i.f fVar) {
        return new a(uVar, fVar);
    }

    public static z create(@Nullable u uVar, byte[] bArr) {
        return create(uVar, bArr, 0, bArr.length);
    }

    public static z create(@Nullable u uVar, byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            h.e0.c.a(bArr.length, i2, i3);
            return new b(uVar, i3, bArr, i2);
        }
        throw new NullPointerException("content == null");
    }

    public static z create(@Nullable u uVar, File file) {
        if (file != null) {
            return new c(uVar, file);
        }
        throw new NullPointerException("content == null");
    }
}
