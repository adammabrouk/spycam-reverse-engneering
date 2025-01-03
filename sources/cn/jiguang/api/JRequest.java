package cn.jiguang.api;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class JRequest extends JProtocol {
    public JRequest(int i2, int i3, long j) {
        super(true, i2, i3, j);
    }

    public JRequest(Object obj, ByteBuffer byteBuffer) {
        super(true, obj, byteBuffer);
    }

    public void setJuid(long j) {
        this.head.a(j);
    }

    public void setSid(int i2) {
        this.head.b(i2);
    }
}
