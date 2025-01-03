package cn.jpush.android.b;

import android.content.Context;
import android.location.Location;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.api.ReportCallBack;
import cn.jpush.android.bd.e;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public Context f9491a;

    public c(Context context) {
        this.f9491a = context.getApplicationContext();
        e.a().a(new e.a() { // from class: cn.jpush.android.b.c.1
            @Override // cn.jpush.android.bd.e.a
            public void a(b bVar) {
                c.this.a(bVar);
            }

            @Override // cn.jpush.android.bd.e.a
            public void a(b bVar, b bVar2) {
                c.this.a(bVar, bVar2);
            }

            @Override // cn.jpush.android.bd.e.a
            public void a(boolean z) {
                if (z) {
                    c.this.a();
                } else {
                    c.this.b();
                }
            }

            @Override // cn.jpush.android.bd.e.a
            public void b(b bVar) {
                c.this.b(bVar);
            }
        });
    }

    private void a(Context context, b bVar, Location location) {
        try {
            Logger.d("GeofenceAction", "geofence report id=" + bVar.f9482a);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("geofence_id", bVar.f9482a);
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("lat", location.getLatitude() + "");
                jSONObject2.put("lng", location.getLongitude() + "");
                jSONObject.put("gps", jSONObject2);
            }
            if (JCoreManager.onEvent(null, null, 26, null, null, jSONObject, "geo_fence") instanceof JSONObject) {
                JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 15, null, null, jSONObject, new ReportCallBack() { // from class: cn.jpush.android.b.c.2
                    @Override // cn.jiguang.api.ReportCallBack
                    public void onFinish(int i2) {
                        Logger.d("GeofenceAction", "report with callback:" + i2);
                    }
                });
            }
        } catch (Throwable th) {
            Logger.w("GeofenceAction", "report geofence error:" + th);
        }
    }

    public void a() {
    }

    public void a(long j) {
    }

    public abstract void a(b bVar);

    public void a(b bVar, Location location) {
        if (bVar != null) {
            try {
                if (bVar.f9490i == 2) {
                    a(this.f9491a, bVar, location);
                } else if (bVar.t != null) {
                    cn.jpush.android.d.b.a(this.f9491a, bVar.t);
                } else {
                    Logger.w("GeofenceAction", "there is no push entity, won't show notification");
                }
            } catch (Throwable th) {
                Logger.ww("GeofenceAction", "process geofence error:" + th);
            }
        }
    }

    public abstract void a(b bVar, b bVar2);

    public void b() {
    }

    public abstract void b(b bVar);
}
