package cn.jiguang.supp;

import cn.jiguang.x.a;
import com.bun.supplier.IIdentifierListener;
import com.bun.supplier.IdSupplier;

/* loaded from: classes.dex */
public class MittIdSupplierv2 implements IIdentifierListener {
    public a mittCall;

    public MittIdSupplierv2(a aVar) {
        this.mittCall = aVar;
    }

    public void OnSupport(boolean z, IdSupplier idSupplier) {
        try {
            try {
                this.mittCall.a(z, idSupplier);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            this.mittCall.f9071a.put("");
        }
    }
}
