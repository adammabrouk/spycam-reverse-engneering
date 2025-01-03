package c.c.a.b.c.l;

import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public class b extends Exception {
    public final Status mStatus;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b(com.google.android.gms.common.api.Status r5) {
        /*
            r4 = this;
            int r0 = r5.u()
            java.lang.String r1 = r5.v()
            if (r1 == 0) goto Lf
            java.lang.String r1 = r5.v()
            goto L11
        Lf:
            java.lang.String r1 = ""
        L11:
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            int r2 = r2 + 13
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r0)
            java.lang.String r0 = ": "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r4.<init>(r0)
            r4.mStatus = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.b.c.l.b.<init>(com.google.android.gms.common.api.Status):void");
    }

    public int getStatusCode() {
        return this.mStatus.u();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.v();
    }
}
