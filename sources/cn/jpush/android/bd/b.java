package cn.jpush.android.bd;

import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class b extends JPushResponse {

    /* renamed from: a, reason: collision with root package name */
    public int f9505a;

    public b(int i2, long j, long j2, ByteBuffer byteBuffer) {
        super(i2, j, j2, byteBuffer);
        this.f9505a = 0;
        parseBody();
    }

    public b(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public int a() {
        return this.f9505a;
    }

    @Override // cn.jpush.android.local.JPushResponse
    public void parseBody() {
        try {
            if (this.body != null) {
                this.f9505a = this.body.get();
                Logger.ww("GeoControl", "control type:" + this.f9505a);
            }
        } catch (Throwable unused) {
            Logger.ww("GeoControl", "parse geoContorl failed");
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[GeoControl] - type:" + this.f9505a + " - " + super.toString();
    }
}
