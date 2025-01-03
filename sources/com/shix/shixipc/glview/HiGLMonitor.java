package com.shix.shixipc.glview;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class HiGLMonitor extends GLSurfaceView {
    public Handler handler;
    public int mCurVideoHeight;
    public int mCurVideoWidth;
    public HiGLRender renderer;
    public byte[] videoBuffer;

    public HiGLMonitor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.renderer = null;
        this.mCurVideoWidth = 0;
        this.mCurVideoHeight = 0;
        this.handler = new Handler() { // from class: com.shix.shixipc.glview.HiGLMonitor.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                HiGLMonitor.this.renderer.writeSample(HiGLMonitor.this.videoBuffer, HiGLMonitor.this.mCurVideoWidth, HiGLMonitor.this.mCurVideoHeight);
            }
        };
        HiGLRender hiGLRender = new HiGLRender(this);
        this.renderer = hiGLRender;
        setRenderer(hiGLRender);
    }

    public void setMatrix(int i2, int i3, int i4, int i5) {
        HiGLRender hiGLRender = this.renderer;
        if (hiGLRender == null) {
            return;
        }
        hiGLRender.setMatrix(i2, i3, i4, i5);
    }

    public void setYuvFrameData(byte[] bArr, int i2, int i3) {
        if (this.mCurVideoWidth != i2 || this.mCurVideoHeight != i3) {
            this.mCurVideoWidth = i2;
            this.mCurVideoHeight = i3;
            this.videoBuffer = null;
            this.videoBuffer = new byte[4147200];
        }
        int length = bArr.length;
        byte[] bArr2 = this.videoBuffer;
        if (length > bArr2.length) {
            return;
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.handler.sendMessage(new Message());
    }
}
