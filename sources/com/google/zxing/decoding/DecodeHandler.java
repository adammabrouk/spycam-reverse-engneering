package com.google.zxing.decoding;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.activity.CaptureActivity;
import com.google.zxing.camera.CameraManager;
import com.google.zxing.camera.PlanarYUVLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.shix.lookcam.R;
import com.shix.shixipc.utils.MyLogUtils;
import java.util.Hashtable;

/* loaded from: classes.dex */
public final class DecodeHandler extends Handler {
    public static final String TAG = DecodeHandler.class.getSimpleName();
    public final CaptureActivity activity;
    public final MultiFormatReader multiFormatReader;

    public DecodeHandler(CaptureActivity captureActivity, Hashtable<DecodeHintType, Object> hashtable) {
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.multiFormatReader = multiFormatReader;
        multiFormatReader.setHints(hashtable);
        this.activity = captureActivity;
    }

    private void decode(byte[] bArr, int i2, int i3) {
        Result result;
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bArr2 = new byte[bArr.length];
        for (int i4 = 0; i4 < i3; i4++) {
            for (int i5 = 0; i5 < i2; i5++) {
                bArr2[(((i5 * i3) + i3) - i4) - 1] = bArr[(i4 * i2) + i5];
            }
        }
        PlanarYUVLuminanceSource buildLuminanceSource = CameraManager.get().buildLuminanceSource(bArr2, i3, i2);
        try {
            result = this.multiFormatReader.decodeWithState(new BinaryBitmap(new HybridBinarizer(buildLuminanceSource)));
            this.multiFormatReader.reset();
        } catch (ReaderException unused) {
            this.multiFormatReader.reset();
            result = null;
        } catch (Throwable th) {
            this.multiFormatReader.reset();
            throw th;
        }
        if (result == null) {
            Message.obtain(this.activity.getHandler(), R.id.decode_failed).sendToTarget();
            return;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        MyLogUtils.d(TAG, "Found barcode (" + (currentTimeMillis2 - currentTimeMillis) + " ms):\n" + result.toString());
        Message obtain = Message.obtain(this.activity.getHandler(), R.id.decode_succeeded, result);
        Bundle bundle = new Bundle();
        bundle.putParcelable(DecodeThread.BARCODE_BITMAP, buildLuminanceSource.renderCroppedGreyscaleBitmap());
        obtain.setData(bundle);
        obtain.sendToTarget();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == R.id.decode) {
            decode((byte[]) message.obj, message.arg1, message.arg2);
        } else {
            if (i2 != R.id.quit) {
                return;
            }
            Looper.myLooper().quit();
        }
    }
}
