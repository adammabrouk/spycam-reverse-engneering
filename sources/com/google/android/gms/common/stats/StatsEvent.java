package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    public String toString() {
        long v = v();
        int u = u();
        long w = w();
        String x = x();
        StringBuilder sb = new StringBuilder(String.valueOf(x).length() + 53);
        sb.append(v);
        sb.append("\t");
        sb.append(u);
        sb.append("\t");
        sb.append(w);
        sb.append(x);
        return sb.toString();
    }

    public abstract int u();

    public abstract long v();

    public abstract long w();

    public abstract String x();
}
