package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.model.OSSResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class OSSAsyncTask<T extends OSSResult> {
    public volatile boolean canceled;
    public ExecutionContext context;
    public Future<T> future;

    public static OSSAsyncTask wrapRequestTask(Future future, ExecutionContext executionContext) {
        OSSAsyncTask oSSAsyncTask = new OSSAsyncTask();
        oSSAsyncTask.future = future;
        oSSAsyncTask.context = executionContext;
        return oSSAsyncTask;
    }

    public void cancel() {
        this.canceled = true;
        ExecutionContext executionContext = this.context;
        if (executionContext != null) {
            executionContext.getCancellationHandler().cancel();
        }
    }

    public T getResult() throws ClientException, ServiceException {
        try {
            return this.future.get();
        } catch (InterruptedException e2) {
            throw new ClientException(" InterruptedException and message : " + e2.getMessage(), e2);
        } catch (ExecutionException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof ClientException) {
                throw ((ClientException) cause);
            }
            if (cause instanceof ServiceException) {
                throw ((ServiceException) cause);
            }
            cause.printStackTrace();
            throw new ClientException("Unexpected exception!" + cause.getMessage());
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public boolean isCompleted() {
        return this.future.isDone();
    }

    public void waitUntilFinished() {
        try {
            this.future.get();
        } catch (Exception unused) {
        }
    }
}
