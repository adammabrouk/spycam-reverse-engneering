package cn.jiguang.bb;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class a {
    public static Pair<c, ByteBuffer> a(Context context, byte[] bArr, String str) {
        ByteBuffer wrap;
        if (bArr.length < 20) {
            cn.jiguang.as.d.h("JCommands", "Error: received body-length short than common head-length, return null");
            return null;
        }
        byte[] bArr2 = new byte[20];
        System.arraycopy(bArr, 0, bArr2, 0, 20);
        c cVar = new c(false, bArr2);
        cn.jiguang.as.d.c("JCommands", "parsed head - " + cVar.toString());
        int i2 = cVar.f8635a - 20;
        if (i2 < 0) {
            cn.jiguang.as.d.h("JCommands", "Error: totalBytes length error with no encrypted, return null");
            return null;
        }
        cn.jiguang.as.d.a("JCommands", "body size:" + i2);
        if (TextUtils.isEmpty(str)) {
            str = b.a(context);
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr, 20, bArr3, 0, i2);
        if (TextUtils.isEmpty(str)) {
            System.arraycopy(bArr, 20, bArr3, 0, i2);
            wrap = ByteBuffer.wrap(bArr3);
        } else {
            try {
                wrap = ByteBuffer.wrap(cVar.f8638d == 2 ? new cn.jiguang.bk.d().b(bArr3, str) : cn.jiguang.bk.e.a(bArr3, str, str.substring(0, 16), false));
            } catch (Exception e2) {
                cn.jiguang.as.d.c("JCommands", "decryptBytes error:" + e2.getMessage());
                return null;
            }
        }
        return new Pair<>(cVar, wrap);
    }

    public static boolean a(Context context, byte[] bArr) {
        try {
            Pair<c, ByteBuffer> a2 = a(context, bArr, "");
            if (a2 == null) {
                return false;
            }
            cn.jiguang.d.a.f(context);
            long j = ((c) a2.first).f8641g;
            cn.jiguang.az.b.a().a(context, (c) a2.first, (ByteBuffer) a2.second);
            return true;
        } catch (Throwable th) {
            cn.jiguang.as.d.h("JCommands", "dispatchMessage error:" + th.getMessage());
            return false;
        }
    }
}
