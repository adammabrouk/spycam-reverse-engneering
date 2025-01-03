package a.h.j.i0;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

/* compiled from: InputContentInfoCompat.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0032c f1192a;

    /* compiled from: InputContentInfoCompat.java */
    public static final class b implements InterfaceC0032c {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f1194a;

        /* renamed from: b, reason: collision with root package name */
        public final ClipDescription f1195b;

        /* renamed from: c, reason: collision with root package name */
        public final Uri f1196c;

        public b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f1194a = uri;
            this.f1195b = clipDescription;
            this.f1196c = uri2;
        }

        @Override // a.h.j.i0.c.InterfaceC0032c
        public ClipDescription a() {
            return this.f1195b;
        }

        @Override // a.h.j.i0.c.InterfaceC0032c
        public Object b() {
            return null;
        }

        @Override // a.h.j.i0.c.InterfaceC0032c
        public Uri c() {
            return this.f1194a;
        }

        @Override // a.h.j.i0.c.InterfaceC0032c
        public void d() {
        }

        @Override // a.h.j.i0.c.InterfaceC0032c
        public Uri e() {
            return this.f1196c;
        }
    }

    /* compiled from: InputContentInfoCompat.java */
    /* renamed from: a.h.j.i0.c$c, reason: collision with other inner class name */
    public interface InterfaceC0032c {
        ClipDescription a();

        Object b();

        Uri c();

        void d();

        Uri e();
    }

    public c(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f1192a = new a(uri, clipDescription, uri2);
        } else {
            this.f1192a = new b(uri, clipDescription, uri2);
        }
    }

    public Uri a() {
        return this.f1192a.c();
    }

    public ClipDescription b() {
        return this.f1192a.a();
    }

    public Uri c() {
        return this.f1192a.e();
    }

    public void d() {
        this.f1192a.d();
    }

    public Object e() {
        return this.f1192a.b();
    }

    /* compiled from: InputContentInfoCompat.java */
    public static final class a implements InterfaceC0032c {

        /* renamed from: a, reason: collision with root package name */
        public final InputContentInfo f1193a;

        public a(Object obj) {
            this.f1193a = (InputContentInfo) obj;
        }

        @Override // a.h.j.i0.c.InterfaceC0032c
        public ClipDescription a() {
            return this.f1193a.getDescription();
        }

        @Override // a.h.j.i0.c.InterfaceC0032c
        public Object b() {
            return this.f1193a;
        }

        @Override // a.h.j.i0.c.InterfaceC0032c
        public Uri c() {
            return this.f1193a.getContentUri();
        }

        @Override // a.h.j.i0.c.InterfaceC0032c
        public void d() {
            this.f1193a.requestPermission();
        }

        @Override // a.h.j.i0.c.InterfaceC0032c
        public Uri e() {
            return this.f1193a.getLinkUri();
        }

        public a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f1193a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    public static c a(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new c(new a(obj));
        }
        return null;
    }

    public c(InterfaceC0032c interfaceC0032c) {
        this.f1192a = interfaceC0032c;
    }
}
