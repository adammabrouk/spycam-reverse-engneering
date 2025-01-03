package c.e.b.d;

/* compiled from: ImageType.java */
/* loaded from: classes.dex */
public enum a {
    GIF(true),
    JPEG(false),
    RAW(false),
    PNG_A(true),
    PNG(false),
    WEBP_A(true),
    WEBP(false),
    UNKNOWN(false);

    public final boolean hasAlpha;

    a(boolean z) {
        this.hasAlpha = z;
    }

    public boolean hasAlpha() {
        return this.hasAlpha;
    }
}
