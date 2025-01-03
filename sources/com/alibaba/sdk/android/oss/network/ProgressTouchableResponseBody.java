package com.alibaba.sdk.android.oss.network;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import h.b0;
import h.u;
import i.c;
import i.e;
import i.h;
import i.l;
import i.s;
import java.io.IOException;

/* loaded from: classes.dex */
public class ProgressTouchableResponseBody<T extends OSSRequest> extends b0 {
    public e mBufferedSource;
    public OSSProgressCallback mProgressListener;
    public final b0 mResponseBody;
    public T request;

    public ProgressTouchableResponseBody(b0 b0Var, ExecutionContext executionContext) {
        this.mResponseBody = b0Var;
        this.mProgressListener = executionContext.getProgressCallback();
        this.request = (T) executionContext.getRequest();
    }

    @Override // h.b0
    public long contentLength() {
        return this.mResponseBody.contentLength();
    }

    @Override // h.b0
    public u contentType() {
        return this.mResponseBody.contentType();
    }

    @Override // h.b0
    public e source() {
        if (this.mBufferedSource == null) {
            this.mBufferedSource = l.a(source(this.mResponseBody.source()));
        }
        return this.mBufferedSource;
    }

    private s source(s sVar) {
        return new h(sVar) { // from class: com.alibaba.sdk.android.oss.network.ProgressTouchableResponseBody.1
            public long totalBytesRead = 0;

            @Override // i.h, i.s
            public long read(c cVar, long j) throws IOException {
                long read = super.read(cVar, j);
                this.totalBytesRead += read != -1 ? read : 0L;
                if (ProgressTouchableResponseBody.this.mProgressListener != null && read != -1 && this.totalBytesRead != 0) {
                    ProgressTouchableResponseBody.this.mProgressListener.onProgress(ProgressTouchableResponseBody.this.request, this.totalBytesRead, ProgressTouchableResponseBody.this.mResponseBody.contentLength());
                }
                return read;
            }
        };
    }
}
