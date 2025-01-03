package com.google.zxing.camera;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.shix.shixipc.utils.MyLogUtils;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class CameraConfigurationManager {
    public static final Pattern COMMA_PATTERN = Pattern.compile(",");
    public static final int DESIRED_SHARPNESS = 30;
    public static final String TAG = "CameraConfigurationManager";
    public static final int TEN_DESIRED_ZOOM = 27;
    public Point cameraResolution;
    public final Context context;
    public int previewFormat;
    public String previewFormatString;
    public Point screenResolution;

    public CameraConfigurationManager(Context context) {
        this.context = context;
    }

    public static int findBestMotZoomValue(CharSequence charSequence, int i2) {
        int i3 = 0;
        for (String str : COMMA_PATTERN.split(charSequence)) {
            try {
                double parseDouble = Double.parseDouble(str.trim());
                int i4 = (int) (10.0d * parseDouble);
                double d2 = i2;
                Double.isNaN(d2);
                if (Math.abs(d2 - parseDouble) < Math.abs(i2 - i3)) {
                    i3 = i4;
                }
            } catch (NumberFormatException unused) {
                return i2;
            }
        }
        return i3;
    }

    public static Point findBestPreviewSizeValue(CharSequence charSequence, Point point) {
        String[] split = COMMA_PATTERN.split(charSequence);
        int length = split.length;
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            String trim = split[i3].trim();
            int indexOf = trim.indexOf(120);
            if (indexOf < 0) {
                MyLogUtils.w(TAG, "Bad preview-size: " + trim);
            } else {
                try {
                    int parseInt = Integer.parseInt(trim.substring(0, indexOf));
                    int parseInt2 = Integer.parseInt(trim.substring(indexOf + 1));
                    int abs = Math.abs(parseInt - point.x) + Math.abs(parseInt2 - point.y);
                    if (abs == 0) {
                        i5 = parseInt2;
                        i4 = parseInt;
                        break;
                    }
                    if (abs < i2) {
                        i5 = parseInt2;
                        i2 = abs;
                        i4 = parseInt;
                    }
                } catch (NumberFormatException unused) {
                    MyLogUtils.w(TAG, "Bad preview-size: " + trim);
                }
            }
            i3++;
        }
        if (i4 <= 0 || i5 <= 0) {
            return null;
        }
        return new Point(i4, i5);
    }

    public static int getDesiredSharpness() {
        return 30;
    }

    private void setFlash(Camera.Parameters parameters) {
        if (Build.MODEL.contains("Behold II") && CameraManager.SDK_INT == 3) {
            parameters.set("flash-value", 1);
        } else {
            parameters.set("flash-value", 2);
        }
        parameters.set("flash-mode", "off");
    }

    private void setZoom(Camera.Parameters parameters) {
        String str = parameters.get("zoom-supported");
        if (str == null || Boolean.parseBoolean(str)) {
            int i2 = 27;
            String str2 = parameters.get("max-zoom");
            if (str2 != null) {
                try {
                    int parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                    if (27 > parseDouble) {
                        i2 = parseDouble;
                    }
                } catch (NumberFormatException unused) {
                    MyLogUtils.w(TAG, "Bad max-zoom: " + str2);
                }
            }
            String str3 = parameters.get("taking-picture-zoom-max");
            if (str3 != null) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    if (i2 > parseInt) {
                        i2 = parseInt;
                    }
                } catch (NumberFormatException unused2) {
                    MyLogUtils.w(TAG, "Bad taking-picture-zoom-max: " + str3);
                }
            }
            String str4 = parameters.get("mot-zoom-values");
            if (str4 != null) {
                i2 = findBestMotZoomValue(str4, i2);
            }
            String str5 = parameters.get("mot-zoom-step");
            if (str5 != null) {
                try {
                    int parseDouble2 = (int) (Double.parseDouble(str5.trim()) * 10.0d);
                    if (parseDouble2 > 1) {
                        i2 -= i2 % parseDouble2;
                    }
                } catch (NumberFormatException unused3) {
                }
            }
            if (str2 != null || str4 != null) {
                double d2 = i2;
                Double.isNaN(d2);
                parameters.set("zoom", String.valueOf(d2 / 10.0d));
            }
            if (str3 != null) {
                parameters.set("taking-picture-zoom", i2);
            }
        }
    }

    public Point getCameraResolution() {
        return this.cameraResolution;
    }

    public int getPreviewFormat() {
        return this.previewFormat;
    }

    public String getPreviewFormatString() {
        return this.previewFormatString;
    }

    public Point getScreenResolution() {
        return this.screenResolution;
    }

    public void initFromCameraParameters(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        this.previewFormat = parameters.getPreviewFormat();
        this.previewFormatString = parameters.get("preview-format");
        MyLogUtils.d(TAG, "Default preview format: " + this.previewFormat + '/' + this.previewFormatString);
        Display defaultDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
        this.screenResolution = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        MyLogUtils.d(TAG, "Screen resolution: " + this.screenResolution);
        Point point = new Point();
        Point point2 = this.screenResolution;
        point.x = point2.x;
        point.y = point2.y;
        int i2 = point2.x;
        int i3 = point2.y;
        if (i2 < i3) {
            point.x = i3;
            point.y = point2.x;
        }
        this.cameraResolution = getCameraResolution(parameters, point);
        MyLogUtils.d(TAG, "Camera resolution: " + this.screenResolution);
    }

    public void setDesiredCameraParameters(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        MyLogUtils.d(TAG, "Setting preview size: " + this.cameraResolution);
        Point point = this.cameraResolution;
        parameters.setPreviewSize(point.x, point.y);
        setFlash(parameters);
        setZoom(parameters);
        camera.setDisplayOrientation(90);
        camera.setParameters(parameters);
    }

    public static Point getCameraResolution(Camera.Parameters parameters, Point point) {
        String str = parameters.get("preview-size-values");
        if (str == null) {
            str = parameters.get("preview-size-value");
        }
        Point point2 = null;
        if (str != null) {
            MyLogUtils.d(TAG, "preview-size-values parameter: " + str);
            point2 = findBestPreviewSizeValue(str, point);
        }
        return point2 == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : point2;
    }
}
