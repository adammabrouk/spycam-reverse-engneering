package com.google.zxing.decoding;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.activity.CaptureActivity;
import com.google.zxing.camera.CameraManager;
import com.google.zxing.view.ViewfinderResultPointCallback;
import com.shix.lookcam.R;
import com.shix.shixipc.utils.MyLogUtils;
import java.util.Vector;

/* loaded from: classes.dex */
public final class CaptureActivityHandler extends Handler {
    public static final String TAG = CaptureActivityHandler.class.getSimpleName();
    public final CaptureActivity activity;
    public final DecodeThread decodeThread;
    public State state;

    public enum State {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public CaptureActivityHandler(CaptureActivity captureActivity, Vector<BarcodeFormat> vector, String str) {
        this.activity = captureActivity;
        DecodeThread decodeThread = new DecodeThread(captureActivity, vector, str, new ViewfinderResultPointCallback(captureActivity.getViewfinderView()));
        this.decodeThread = decodeThread;
        decodeThread.start();
        this.state = State.SUCCESS;
        CameraManager.get().startPreview();
        restartPreviewAndDecode();
    }

    private void restartPreviewAndDecode() {
        if (this.state == State.SUCCESS) {
            this.state = State.PREVIEW;
            CameraManager.get().requestPreviewFrame(this.decodeThread.getHandler(), R.id.decode);
            CameraManager.get().requestAutoFocus(this, R.id.auto_focus);
            this.activity.drawViewfinder();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case R.id.auto_focus /* 2131230818 */:
                if (this.state == State.PREVIEW) {
                    CameraManager.get().requestAutoFocus(this, R.id.auto_focus);
                    break;
                }
                break;
            case R.id.decode_failed /* 2131230966 */:
                this.state = State.PREVIEW;
                CameraManager.get().requestPreviewFrame(this.decodeThread.getHandler(), R.id.decode);
                break;
            case R.id.decode_succeeded /* 2131230967 */:
                MyLogUtils.d(TAG, "Got decode succeeded message");
                this.state = State.SUCCESS;
                Bundle data = message.getData();
                this.activity.handleDecode((Result) message.obj, data == null ? null : (Bitmap) data.getParcelable(DecodeThread.BARCODE_BITMAP));
                break;
            case R.id.launch_product_query /* 2131231138 */:
                MyLogUtils.d(TAG, "Got product query message");
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String) message.obj));
                intent.addFlags(524288);
                this.activity.startActivity(intent);
                break;
            case R.id.restart_preview /* 2131231358 */:
                MyLogUtils.d(TAG, "Got restart preview message");
                restartPreviewAndDecode();
                break;
            case R.id.return_scan_result /* 2131231359 */:
                MyLogUtils.d(TAG, "Got return scan result message");
                this.activity.setResult(-1, (Intent) message.obj);
                this.activity.finish();
                break;
        }
    }

    public void quitSynchronously() {
        this.state = State.DONE;
        CameraManager.get().stopPreview();
        Message.obtain(this.decodeThread.getHandler(), R.id.quit).sendToTarget();
        try {
            this.decodeThread.join();
        } catch (InterruptedException unused) {
        }
        removeMessages(R.id.decode_succeeded);
        removeMessages(R.id.decode_failed);
    }
}
