package a.f.a.j;

import java.util.Arrays;

/* compiled from: Helper.java */
/* loaded from: classes.dex */
public class j extends f {
    public f[] k0 = new f[4];
    public int l0 = 0;

    public void K() {
        this.l0 = 0;
    }

    public void b(f fVar) {
        int i2 = this.l0 + 1;
        f[] fVarArr = this.k0;
        if (i2 > fVarArr.length) {
            this.k0 = (f[]) Arrays.copyOf(fVarArr, fVarArr.length * 2);
        }
        f[] fVarArr2 = this.k0;
        int i3 = this.l0;
        fVarArr2[i3] = fVar;
        this.l0 = i3 + 1;
    }
}
