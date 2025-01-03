package cn.jpush.android.bi;

import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class c extends JPushResponse {

    /* renamed from: a, reason: collision with root package name */
    public int f9594a;

    /* renamed from: b, reason: collision with root package name */
    public long f9595b;

    /* renamed from: c, reason: collision with root package name */
    public String f9596c;

    public c(int i2, long j, long j2, ByteBuffer byteBuffer) {
        super(i2, j, j2, byteBuffer);
        parseBody();
    }

    public c(JPushResponse jPushResponse) {
        this(jPushResponse.getCmd(), jPushResponse.getRid(), jPushResponse.rquestId, jPushResponse.getBody());
    }

    public int a() {
        return this.f9594a;
    }

    public long b() {
        return this.f9595b;
    }

    public String c() {
        return this.f9596c;
    }

    @Override // cn.jpush.android.local.JPushResponse
    public void parseBody() {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(this.body.array());
            this.f9594a = wrap.get();
            this.f9595b = wrap.getLong();
            byte[] bArr = new byte[wrap.getShort()];
            wrap.get(bArr);
            this.f9596c = new String(bArr, "UTF-8");
        } catch (Throwable th) {
            Logger.ww("MessagePush", "parse msg content failed, e: " + th.getMessage());
        }
    }

    @Override // cn.jpush.android.local.JPushResponse
    public String toString() {
        return "[MessagePush] - msgType:" + this.f9594a + ", msgId:" + this.f9595b + ", msgContent:" + this.f9596c + " - " + super.toString();
    }
}
