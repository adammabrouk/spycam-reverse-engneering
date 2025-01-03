package com.google.zxing.decoding;

import android.os.Handler;
import android.os.Looper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.activity.CaptureActivity;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public final class DecodeThread extends Thread {
    public static final String BARCODE_BITMAP = "barcode_bitmap";
    public final CaptureActivity activity;
    public Handler handler;
    public final CountDownLatch handlerInitLatch = new CountDownLatch(1);
    public final Hashtable<DecodeHintType, Object> hints = new Hashtable<>(3);

    public DecodeThread(CaptureActivity captureActivity, Vector<BarcodeFormat> vector, String str, ResultPointCallback resultPointCallback) {
        this.activity = captureActivity;
        if (vector == null || vector.isEmpty()) {
            vector = new Vector<>();
            vector.addAll(DecodeFormatManager.ONE_D_FORMATS);
            vector.addAll(DecodeFormatManager.QR_CODE_FORMATS);
            vector.addAll(DecodeFormatManager.DATA_MATRIX_FORMATS);
        }
        this.hints.put(DecodeHintType.POSSIBLE_FORMATS, vector);
        if (str != null) {
            this.hints.put(DecodeHintType.CHARACTER_SET, str);
        }
        this.hints.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, resultPointCallback);
    }

    public Handler getHandler() {
        try {
            this.handlerInitLatch.await();
        } catch (InterruptedException unused) {
        }
        return this.handler;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.handler = new DecodeHandler(this.activity, this.hints);
        this.handlerInitLatch.countDown();
        Looper.loop();
    }
}
