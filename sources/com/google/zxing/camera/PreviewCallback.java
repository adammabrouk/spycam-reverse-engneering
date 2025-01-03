package com.google.zxing.camera;

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import com.shix.shixipc.utils.MyLogUtils;

/* loaded from: classes.dex */
public final class PreviewCallback implements Camera.PreviewCallback {
    public static final String TAG = PreviewCallback.class.getSimpleName();
    public final CameraConfigurationManager configManager;
    public Handler previewHandler;
    public int previewMessage;
    public final boolean useOneShotPreviewCallback;

    public PreviewCallback(CameraConfigurationManager cameraConfigurationManager, boolean z) {
        this.configManager = cameraConfigurationManager;
        this.useOneShotPreviewCallback = z;
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point cameraResolution = this.configManager.getCameraResolution();
        if (!this.useOneShotPreviewCallback) {
            camera.setPreviewCallback(null);
        }
        Handler handler = this.previewHandler;
        if (handler == null) {
            MyLogUtils.d(TAG, "Got preview callback, but no handler for it");
        } else {
            handler.obtainMessage(this.previewMessage, cameraResolution.x, cameraResolution.y, bArr).sendToTarget();
            this.previewHandler = null;
        }
    }

    public void setHandler(Handler handler, int i2) {
        this.previewHandler = handler;
        this.previewMessage = i2;
    }
}
