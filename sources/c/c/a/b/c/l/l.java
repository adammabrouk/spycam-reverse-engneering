package c.c.a.b.c.l;

import com.google.android.gms.common.Feature;

/* loaded from: classes.dex */
public final class l extends UnsupportedOperationException {
    public final Feature zzas;

    public l(Feature feature) {
        this.zzas = feature;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String valueOf = String.valueOf(this.zzas);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
