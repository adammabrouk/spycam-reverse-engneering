package cn.jiguang.supp;

import cn.jiguang.w.a;
import com.bun.miitmdid.core.IIdentifierListener;
import com.bun.miitmdid.supplier.IdSupplier;

/* loaded from: classes.dex */
public class MittIdSupplier implements IIdentifierListener {
    public a mittCall;

    public MittIdSupplier(a aVar) {
        this.mittCall = aVar;
    }

    public void OnSupport(boolean z, IdSupplier idSupplier) {
        try {
            try {
                this.mittCall.a(z, idSupplier);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            this.mittCall.f9069a.put("");
        }
    }
}
