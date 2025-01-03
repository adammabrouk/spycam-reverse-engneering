package com.google.zxing.camera;

import android.hardware.Camera;
import android.os.Handler;
import com.shix.shixipc.utils.MyLogUtils;

/* loaded from: classes.dex */
public final class AutoFocusCallback implements Camera.AutoFocusCallback {
    public static final long AUTOFOCUS_INTERVAL_MS = 1500;
    public static final String TAG = AutoFocusCallback.class.getSimpleName();
    public Handler autoFocusHandler;
    public int autoFocusMessage;

    @Override // android.hardware.Camera.AutoFocusCallback
    public void onAutoFocus(boolean z, Camera camera) {
        Handler handler = this.autoFocusHandler;
        if (handler == null) {
            MyLogUtils.d(TAG, "Got auto-focus callback, but no handler for it");
            return;
        }
        this.autoFocusHandler.sendMessageDelayed(handler.obtainMessage(this.autoFocusMessage, Boolean.valueOf(z)), AUTOFOCUS_INTERVAL_MS);
        this.autoFocusHandler = null;
    }

    public void setHandler(Handler handler, int i2) {
        this.autoFocusHandler = handler;
        this.autoFocusMessage = i2;
    }
}
