package com.alibaba.sdk.android.oss.network;

import com.alibaba.sdk.android.oss.common.HttpMethod;
import com.alibaba.sdk.android.oss.internal.OSSRetryHandler;
import com.alibaba.sdk.android.oss.internal.RequestMessage;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParser;
import com.alibaba.sdk.android.oss.model.OSSResult;
import h.a0;
import h.r;
import h.v;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class OSSRequestTask<T extends OSSResult> implements Callable<T> {
    public v client;
    public ExecutionContext context;
    public int currentRetryCount = 0;
    public RequestMessage message;
    public ResponseParser<T> responseParser;
    public OSSRetryHandler retryHandler;

    /* renamed from: com.alibaba.sdk.android.oss.network.OSSRequestTask$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod;

        static {
            int[] iArr = new int[HttpMethod.values().length];
            $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod = iArr;
            try {
                iArr[HttpMethod.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.GET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.HEAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod[HttpMethod.DELETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public OSSRequestTask(RequestMessage requestMessage, ResponseParser responseParser, ExecutionContext executionContext, int i2) {
        this.responseParser = responseParser;
        this.message = requestMessage;
        this.context = executionContext;
        this.client = executionContext.getClient();
        this.retryHandler = new OSSRetryHandler(i2);
    }

    private ResponseMessage buildResponseMessage(RequestMessage requestMessage, a0 a0Var) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequest(requestMessage);
        responseMessage.setResponse(a0Var);
        HashMap hashMap = new HashMap();
        r g2 = a0Var.g();
        for (int i2 = 0; i2 < g2.b(); i2++) {
            hashMap.put(g2.a(i2), g2.b(i2));
        }
        responseMessage.setHeaders(hashMap);
        responseMessage.setStatusCode(a0Var.c());
        responseMessage.setContentLength(a0Var.a().contentLength());
        responseMessage.setContent(a0Var.a().byteStream());
        return responseMessage;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0192 A[Catch: Exception -> 0x02c5, TryCatch #7 {Exception -> 0x02c5, blocks: (B:3:0x0004, B:5:0x000c, B:6:0x0019, B:8:0x003a, B:10:0x0043, B:11:0x0050, B:12:0x0061, B:14:0x0067, B:16:0x007d, B:27:0x01f4, B:112:0x00c4, B:113:0x00c9, B:114:0x00ce, B:117:0x00d8, B:119:0x00e7, B:123:0x0192, B:125:0x019a, B:126:0x01a5, B:128:0x01c5, B:129:0x01e1, B:130:0x00fe, B:132:0x0106, B:135:0x0123, B:136:0x012a, B:137:0x012b, B:139:0x0133, B:145:0x0163, B:150:0x016d, B:151:0x0170, B:155:0x0171, B:157:0x0179, B:158:0x0187, B:160:0x004a, B:161:0x02bd, B:162:0x02c4), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0316 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public T call() throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1094
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.network.OSSRequestTask.call():com.alibaba.sdk.android.oss.model.OSSResult");
    }
}
