package com.alibaba.sdk.android.oss.network;

import android.content.Context;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.callback.OSSRetryCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.OSSResult;
import h.v;

/* loaded from: classes.dex */
public class ExecutionContext<Request extends OSSRequest, Result extends OSSResult> {
    public Context applicationContext;
    public CancellationHandler cancellationHandler;
    public v client;
    public OSSCompletedCallback completedCallback;
    public OSSProgressCallback progressCallback;
    public Request request;
    public OSSRetryCallback retryCallback;

    public ExecutionContext(v vVar, Request request) {
        this(vVar, request, null);
    }

    public Context getApplicationContext() {
        return this.applicationContext;
    }

    public CancellationHandler getCancellationHandler() {
        return this.cancellationHandler;
    }

    public v getClient() {
        return this.client;
    }

    public OSSCompletedCallback<Request, Result> getCompletedCallback() {
        return this.completedCallback;
    }

    public OSSProgressCallback getProgressCallback() {
        return this.progressCallback;
    }

    public Request getRequest() {
        return this.request;
    }

    public OSSRetryCallback getRetryCallback() {
        return this.retryCallback;
    }

    public void setClient(v vVar) {
        this.client = vVar;
    }

    public void setCompletedCallback(OSSCompletedCallback<Request, Result> oSSCompletedCallback) {
        this.completedCallback = oSSCompletedCallback;
    }

    public void setProgressCallback(OSSProgressCallback oSSProgressCallback) {
        this.progressCallback = oSSProgressCallback;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void setRetryCallback(OSSRetryCallback oSSRetryCallback) {
        this.retryCallback = oSSRetryCallback;
    }

    public ExecutionContext(v vVar, Request request, Context context) {
        this.cancellationHandler = new CancellationHandler();
        setClient(vVar);
        setRequest(request);
        this.applicationContext = context;
    }
}
