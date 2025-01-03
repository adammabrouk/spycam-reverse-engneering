package c.a.a.l.i;

/* compiled from: DiskCacheStrategy.java */
/* loaded from: classes.dex */
public enum b {
    ALL(true, true),
    NONE(false, false),
    SOURCE(true, false),
    RESULT(false, true);

    public final boolean cacheResult;
    public final boolean cacheSource;

    b(boolean z, boolean z2) {
        this.cacheSource = z;
        this.cacheResult = z2;
    }

    public boolean cacheResult() {
        return this.cacheResult;
    }

    public boolean cacheSource() {
        return this.cacheSource;
    }
}
