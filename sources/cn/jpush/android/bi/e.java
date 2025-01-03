package cn.jpush.android.bi;

import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class e extends JPushResponse {

    /* renamed from: a, reason: collision with root package name */
    public int f9601a;

    /* renamed from: b, reason: collision with root package name */
    public String f9602b;

    public e(int i2, long j, long j2, ByteBuffer byteBuffer) {
        super(i2, j, j2, byteBuffer);
        parseBody();
    }

    public e(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public String a() {
        return this.f9602b;
    }

    @Override // cn.jpush.android.local.JPushResponse
    public void parseBody() {
        try {
            if (this.cmd == 10) {
                this.f9601a = this.body.getShort();
            }
            if (this.f9601a <= 0) {
                byte[] bArr = new byte[this.body.getShort()];
                this.body.get(bArr);
                this.f9602b = new String(bArr, "UTF-8");
            } else {
                Logger.e("TagaliasResponse", "Response error - code:" + this.f9601a);
            }
        } catch (Throwable th) {
            Logger.ww("TagaliasResponse", "parse failed:" + th.getMessage());
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[TagaliasResponse] - action:" + this.f9602b + " - " + super.toString();
    }
}
