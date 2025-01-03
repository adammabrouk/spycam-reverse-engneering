package com.google.zxing.camera;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.view.SurfaceHolder;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public final class CameraManager {
    public static final int MAX_FRAME_HEIGHT = 360;
    public static final int MAX_FRAME_WIDTH = 480;
    public static final int MIN_FRAME_HEIGHT = 240;
    public static final int MIN_FRAME_WIDTH = 240;
    public static final int SDK_INT;
    public static final String TAG = "CameraManager";
    public static CameraManager cameraManager;
    public final AutoFocusCallback autoFocusCallback;
    public Camera camera;
    public final CameraConfigurationManager configManager;
    public final Context context;
    public Rect framingRect;
    public Rect framingRectInPreview;
    public boolean initialized;
    public final PreviewCallback previewCallback;
    public boolean previewing;
    public final boolean useOneShotPreviewCallback;

    static {
        int i2;
        try {
            i2 = Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException unused) {
            i2 = 10000;
        }
        SDK_INT = i2;
    }

    public CameraManager(Context context) {
        this.context = context;
        this.configManager = new CameraConfigurationManager(context);
        this.useOneShotPreviewCallback = Integer.parseInt(Build.VERSION.SDK) > 3;
        this.previewCallback = new PreviewCallback(this.configManager, this.useOneShotPreviewCallback);
        this.autoFocusCallback = new AutoFocusCallback();
    }

    public static CameraManager get() {
        return cameraManager;
    }

    public static void init(Context context) {
        if (cameraManager == null) {
            cameraManager = new CameraManager(context);
        }
    }

    public PlanarYUVLuminanceSource buildLuminanceSource(byte[] bArr, int i2, int i3) {
        getFramingRectInPreview();
        int previewFormat = this.configManager.getPreviewFormat();
        String previewFormatString = this.configManager.getPreviewFormatString();
        if (previewFormat == 16 || previewFormat == 17) {
            return new PlanarYUVLuminanceSource(bArr, i2, i3, 0, 0, i2, i3);
        }
        if ("yuv420p".equals(previewFormatString)) {
            return new PlanarYUVLuminanceSource(bArr, i2, i3, 0, 0, i2, i3);
        }
        throw new IllegalArgumentException("Unsupported picture format: " + previewFormat + '/' + previewFormatString);
    }

    public void closeDriver() {
        if (this.camera != null) {
            FlashlightManager.disableFlashlight();
            this.camera.release();
            this.camera = null;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public Rect getFramingRect() {
        Point screenResolution = this.configManager.getScreenResolution();
        if (screenResolution == null) {
            return null;
        }
        if (this.framingRect == null) {
            if (this.camera == null) {
                return null;
            }
            int i2 = (screenResolution.x * 7) / 10;
            int i3 = (screenResolution.y * 7) / 10;
            if (i3 < i2) {
                i2 = i3;
            }
            int i4 = (screenResolution.x - i2) / 2;
            int i5 = (screenResolution.y - i2) / 3;
            this.framingRect = new Rect(i4, i5, i4 + i2, i2 + i5);
        }
        return this.framingRect;
    }

    public Rect getFramingRectInPreview() {
        if (this.framingRectInPreview == null) {
            Rect rect = new Rect(getFramingRect());
            Point cameraResolution = this.configManager.getCameraResolution();
            Point screenResolution = this.configManager.getScreenResolution();
            int i2 = rect.left;
            int i3 = cameraResolution.y;
            int i4 = screenResolution.x;
            rect.left = (i2 * i3) / i4;
            rect.right = (rect.right * i3) / i4;
            int i5 = rect.top;
            int i6 = cameraResolution.x;
            int i7 = screenResolution.y;
            rect.top = (i5 * i6) / i7;
            rect.bottom = (rect.bottom * i6) / i7;
            this.framingRectInPreview = rect;
        }
        return this.framingRectInPreview;
    }

    public void openDriver(SurfaceHolder surfaceHolder) throws IOException {
        if (this.camera == null) {
            Camera open = Camera.open();
            this.camera = open;
            if (open == null) {
                throw new IOException();
            }
            open.setPreviewDisplay(surfaceHolder);
            if (!this.initialized) {
                this.initialized = true;
                this.configManager.initFromCameraParameters(this.camera);
            }
            this.configManager.setDesiredCameraParameters(this.camera);
            FlashlightManager.enableFlashlight();
        }
    }

    public void requestAutoFocus(Handler handler, int i2) {
        if (this.camera == null || !this.previewing) {
            return;
        }
        this.autoFocusCallback.setHandler(handler, i2);
        this.camera.autoFocus(this.autoFocusCallback);
    }

    public void requestPreviewFrame(Handler handler, int i2) {
        if (this.camera == null || !this.previewing) {
            return;
        }
        this.previewCallback.setHandler(handler, i2);
        if (this.useOneShotPreviewCallback) {
            this.camera.setOneShotPreviewCallback(this.previewCallback);
        } else {
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    public boolean setFlashLight(boolean z) {
        Camera.Parameters parameters;
        List<String> supportedFlashModes;
        Camera camera = this.camera;
        if (camera != null && this.previewing && (parameters = camera.getParameters()) != null && (supportedFlashModes = parameters.getSupportedFlashModes()) != null && supportedFlashModes.size() != 0) {
            String flashMode = parameters.getFlashMode();
            if (z) {
                if ("torch".equals(flashMode)) {
                    return true;
                }
                if (!supportedFlashModes.contains("torch")) {
                    return false;
                }
                parameters.setFlashMode("torch");
                this.camera.setParameters(parameters);
                return true;
            }
            if ("off".equals(flashMode)) {
                return true;
            }
            if (supportedFlashModes.contains("off")) {
                parameters.setFlashMode("off");
                this.camera.setParameters(parameters);
                return true;
            }
        }
        return false;
    }

    public void startPreview() {
        Camera camera = this.camera;
        if (camera == null || this.previewing) {
            return;
        }
        camera.startPreview();
        this.previewing = true;
    }

    public void stopPreview() {
        Camera camera = this.camera;
        if (camera == null || !this.previewing) {
            return;
        }
        if (!this.useOneShotPreviewCallback) {
            camera.setPreviewCallback(null);
        }
        this.camera.stopPreview();
        this.previewCallback.setHandler(null, 0);
        this.autoFocusCallback.setHandler(null, 0);
        this.previewing = false;
    }
}
