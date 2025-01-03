package cn.jpush.android.bi;

import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class a extends JPushResponse {

    /* renamed from: a, reason: collision with root package name */
    public int f9593a;

    public a(int i2, long j, long j2, ByteBuffer byteBuffer) {
        super(i2, j, j2, byteBuffer);
        parseBody();
    }

    public a(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public int a() {
        return this.f9593a;
    }

    @Override // cn.jpush.android.local.JPushResponse
    public void parseBody() {
        try {
            this.f9593a = this.body.getShort();
        } catch (Throwable th) {
            Logger.ww("CommonResponse", "parse code failed :" + th.getMessage());
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[CommonResponse] - " + this.f9593a;
    }
}
