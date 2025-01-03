package cn.jiguang.api;

import cn.jiguang.api.utils.ByteBufferUtils;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class JResponse extends JProtocol {
    public int code;

    public JResponse(int i2, int i3, long j, long j2, int i4, String str) {
        super(false, i2, i3, j, -1, j2);
        this.code = i4;
    }

    public JResponse(Object obj, ByteBuffer byteBuffer) {
        super(false, obj, byteBuffer);
    }

    public JResponse(ByteBuffer byteBuffer, byte[] bArr) {
        super(false, byteBuffer, bArr);
    }

    @Override // cn.jiguang.api.JProtocol
    public void parseBody() {
        if (isNeedParseeErrorMsg()) {
            this.code = ByteBufferUtils.getShort(this.body, this);
        }
    }

    @Override // cn.jiguang.api.JProtocol
    public String toString() {
        return "JResponse{code=" + this.code + '}';
    }

    @Override // cn.jiguang.api.JProtocol
    public void writeBody() {
        int i2 = this.code;
        if (i2 >= 0) {
            writeInt2(i2);
        }
    }
}
