package com.alibaba.sdk.android.oss.network;

import h.a0;
import h.t;
import h.v;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class NetworkProgressHelper {
    public static ProgressTouchableRequestBody addProgressRequestBody(InputStream inputStream, long j, String str, ExecutionContext executionContext) {
        return new ProgressTouchableRequestBody(inputStream, j, str, executionContext);
    }

    public static v addProgressResponseListener(v vVar, final ExecutionContext executionContext) {
        v.b p = vVar.p();
        p.a(new t() { // from class: com.alibaba.sdk.android.oss.network.NetworkProgressHelper.1
            @Override // h.t
            public a0 intercept(t.a aVar) throws IOException {
                a0 a2 = aVar.a(aVar.a());
                a0.a l = a2.l();
                l.a(new ProgressTouchableResponseBody(a2.a(), ExecutionContext.this));
                return l.a();
            }
        });
        return p.a();
    }
}
