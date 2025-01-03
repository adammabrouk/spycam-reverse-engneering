package cn.jiguang.x;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.supp.MittIdSupplierv2;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.supplier.IdSupplier;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<String> f9071a = new LinkedBlockingQueue<>(1);

    /* renamed from: b, reason: collision with root package name */
    public Context f9072b;

    public a(Context context) {
        this.f9072b = context;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String call() {
        try {
            int InitSdk = MdidSdkHelper.InitSdk(this.f9072b, false, new MittIdSupplierv2(this));
            return (InitSdk == 0 || InitSdk == 1008614) ? this.f9071a.take() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public void a(boolean z, IdSupplier idSupplier) {
        try {
            try {
                if (idSupplier == null) {
                    this.f9071a.put("");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                String oaid = idSupplier.getOAID();
                String vaid = idSupplier.getVAID();
                String aaid = idSupplier.getAAID();
                if (!TextUtils.isEmpty(oaid)) {
                    jSONObject.put("oaid", oaid);
                }
                if (!TextUtils.isEmpty(vaid)) {
                    jSONObject.put("vaid", vaid);
                }
                if (!TextUtils.isEmpty(aaid)) {
                    jSONObject.put("aaid", aaid);
                }
                this.f9071a.put(jSONObject.toString());
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            this.f9071a.put("");
        }
    }
}
