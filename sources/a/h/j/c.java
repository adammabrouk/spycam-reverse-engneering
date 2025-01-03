package a.h.j;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;

/* compiled from: ContentInfoCompat.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final ClipData f1115a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1116b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1117c;

    /* renamed from: d, reason: collision with root package name */
    public final Uri f1118d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f1119e;

    /* compiled from: ContentInfoCompat.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public ClipData f1120a;

        /* renamed from: b, reason: collision with root package name */
        public int f1121b;

        /* renamed from: c, reason: collision with root package name */
        public int f1122c;

        /* renamed from: d, reason: collision with root package name */
        public Uri f1123d;

        /* renamed from: e, reason: collision with root package name */
        public Bundle f1124e;

        public a(ClipData clipData, int i2) {
            this.f1120a = clipData;
            this.f1121b = i2;
        }

        public a a(int i2) {
            this.f1122c = i2;
            return this;
        }

        public a a(Uri uri) {
            this.f1123d = uri;
            return this;
        }

        public a a(Bundle bundle) {
            this.f1124e = bundle;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    public c(a aVar) {
        ClipData clipData = aVar.f1120a;
        a.h.i.h.a(clipData);
        this.f1115a = clipData;
        int i2 = aVar.f1121b;
        a.h.i.h.a(i2, 0, 3, "source");
        this.f1116b = i2;
        int i3 = aVar.f1122c;
        a.h.i.h.a(i3, 1);
        this.f1117c = i3;
        this.f1118d = aVar.f1123d;
        this.f1119e = aVar.f1124e;
    }

    public static String a(int i2) {
        return (i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2);
    }

    public static String b(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? String.valueOf(i2) : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    public int c() {
        return this.f1116b;
    }

    public String toString() {
        return "ContentInfoCompat{clip=" + this.f1115a + ", source=" + b(this.f1116b) + ", flags=" + a(this.f1117c) + ", linkUri=" + this.f1118d + ", extras=" + this.f1119e + "}";
    }

    public ClipData a() {
        return this.f1115a;
    }

    public int b() {
        return this.f1117c;
    }
}
