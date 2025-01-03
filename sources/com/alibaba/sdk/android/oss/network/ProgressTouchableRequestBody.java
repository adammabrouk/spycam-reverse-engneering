package com.alibaba.sdk.android.oss.network;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import h.u;
import h.z;
import i.d;
import i.l;
import i.s;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ProgressTouchableRequestBody<T extends OSSRequest> extends z {
    public static final int SEGMENT_SIZE = 2048;
    public OSSProgressCallback callback;
    public long contentLength;
    public String contentType;
    public InputStream inputStream;
    public T request;

    public ProgressTouchableRequestBody(InputStream inputStream, long j, String str, ExecutionContext executionContext) {
        this.inputStream = inputStream;
        this.contentType = str;
        this.contentLength = j;
        this.callback = executionContext.getProgressCallback();
        this.request = (T) executionContext.getRequest();
    }

    @Override // h.z
    public long contentLength() throws IOException {
        return this.contentLength;
    }

    @Override // h.z
    public u contentType() {
        return u.b(this.contentType);
    }

    @Override // h.z
    public void writeTo(d dVar) throws IOException {
        s a2 = l.a(this.inputStream);
        long j = 0;
        while (true) {
            long j2 = this.contentLength;
            if (j >= j2) {
                break;
            }
            long read = a2.read(dVar.d(), Math.min(j2 - j, 2048L));
            if (read == -1) {
                break;
            }
            j += read;
            dVar.flush();
            OSSProgressCallback oSSProgressCallback = this.callback;
            if (oSSProgressCallback != null && j != 0) {
                oSSProgressCallback.onProgress(this.request, j, this.contentLength);
            }
        }
        if (a2 != null) {
            a2.close();
        }
    }
}
