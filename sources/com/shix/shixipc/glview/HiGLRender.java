package com.shix.shixipc.glview;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.shix.shixipc.utils.MyLogUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
public class HiGLRender implements GLSurfaceView.Renderer {
    public int _x;
    public int _y;
    public int height;
    public int width;
    public int mHeight = 0;
    public ByteBuffer mUByteBuffer = null;
    public ByteBuffer mVByteBuffer = null;
    public int mWidth = 0;
    public ByteBuffer mYByteBuffer = null;
    public FloatBuffer positionBuffer = null;
    public int positionSlot = 0;
    public int programHandle = 0;
    public int texRangeSlot = 0;
    public int[] texture = new int[3];
    public int[] textureSlot = new int[3];
    public int vertexShader = 0;
    public int yuvFragmentShader = 0;
    public byte[] yuvData = null;
    public FloatBuffer textCoodBuffer = null;
    public boolean bNeedSleep = true;
    public final float[] textCoodBufferData = {0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    public final float[] positionBufferData = {-1.0f, 1.0f, 0.0f, 1.0f, -1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 1.0f};

    public HiGLRender(GLSurfaceView gLSurfaceView) {
        gLSurfaceView.setEGLContextClientVersion(2);
    }

    public static int compileShader(String str, int i2) {
        int glCreateShader = GLES20.glCreateShader(i2);
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        int[] iArr = new int[1];
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public void cleanWithRGB(float f2, float f3, float f4) {
        this.mWidth = 0;
        this.mWidth = 0;
        GLES20.glClear(16384);
        GLES20.glClearColor(f2, f3, f4, 1.0f);
        GLES20.glUseProgram(this.programHandle);
    }

    public long createShaders() {
        String str = (((((((((((((((((("uniform sampler2D Ytex;\nuniform sampler2D Utex;\n") + "uniform sampler2D Vtex;\n") + "precision mediump float;  \n") + "varying vec4 VaryingTexCoord0; \n") + "vec4 color;\n") + "void main()\n") + "{\n") + "float yuv0 = (texture2D(Ytex,VaryingTexCoord0.xy)).r;\n") + "float yuv1 = (texture2D(Utex,VaryingTexCoord0.xy)).r;\n") + "float yuv2 = (texture2D(Vtex,VaryingTexCoord0.xy)).r;\n") + OSSUtils.NEW_LINE) + "color.r = yuv0 + 1.4022 * yuv2 - 0.7011;\n") + "color.r = (color.r < 0.0) ? 0.0 : ((color.r > 1.0) ? 1.0 : color.r);\n") + "color.g = yuv0 - 0.3456 * yuv1 - 0.7145 * yuv2 + 0.53005;\n") + "color.g = (color.g < 0.0) ? 0.0 : ((color.g > 1.0) ? 1.0 : color.g);\n") + "color.b = yuv0 + 1.771 * yuv1 - 0.8855;\n") + "color.b = (color.b < 0.0) ? 0.0 : ((color.b > 1.0) ? 1.0 : color.b);\n") + "gl_FragColor = color;\n") + "}\n";
        int[] iArr = new int[1];
        int compileShader = compileShader((((((("uniform mat4 uMVPMatrix;   \nattribute vec4 vPosition;  \n") + "attribute vec4 myTexCoord; \n") + "varying vec4 VaryingTexCoord0; \n") + "void main(){               \n") + "VaryingTexCoord0 = myTexCoord; \n") + "gl_Position = vPosition; \n") + "}  \n", 35633);
        this.vertexShader = compileShader;
        if (compileShader == 0) {
            MyLogUtils.e("createShaders", "failed when compileShader(vertex)");
        }
        int compileShader2 = compileShader(str, 35632);
        this.yuvFragmentShader = compileShader2;
        if (compileShader2 == 0) {
            MyLogUtils.e("createShaders", "failed when compileShader(fragment)");
        }
        int glCreateProgram = GLES20.glCreateProgram();
        this.programHandle = glCreateProgram;
        GLES20.glAttachShader(glCreateProgram, this.vertexShader);
        GLES20.glAttachShader(this.programHandle, this.yuvFragmentShader);
        GLES20.glLinkProgram(this.programHandle);
        GLES20.glGetProgramiv(this.programHandle, 35714, iArr, 0);
        if (iArr[0] == 0) {
            MyLogUtils.e("createShaders", "link program err:" + GLES20.glGetProgramInfoLog(this.programHandle));
            destroyShaders();
        }
        this.texRangeSlot = GLES20.glGetAttribLocation(this.programHandle, "myTexCoord");
        this.textureSlot[0] = GLES20.glGetUniformLocation(this.programHandle, "Ytex");
        this.textureSlot[1] = GLES20.glGetUniformLocation(this.programHandle, "Utex");
        this.textureSlot[2] = GLES20.glGetUniformLocation(this.programHandle, "Vtex");
        this.positionSlot = GLES20.glGetAttribLocation(this.programHandle, "vPosition");
        MyLogUtils.d("aaaaa", "texRangeSlot: " + this.texRangeSlot);
        MyLogUtils.d("aaaaa", "positionSlot: " + this.positionSlot);
        MyLogUtils.d("aaaaa", "textureSlot[0]: " + this.textureSlot[0]);
        MyLogUtils.d("aaaaa", "textureSlot[1]: " + this.textureSlot[1]);
        MyLogUtils.d("aaaaa", "textureSlot[2]: " + this.textureSlot[2]);
        return 0L;
    }

    public long destroyShaders() {
        int i2 = this.programHandle;
        if (i2 != 0) {
            GLES20.glDetachShader(i2, this.yuvFragmentShader);
            GLES20.glDetachShader(this.programHandle, this.vertexShader);
            GLES20.glDeleteProgram(this.programHandle);
            this.programHandle = 0;
        }
        int i3 = this.yuvFragmentShader;
        if (i3 != 0) {
            GLES20.glDeleteShader(i3);
            this.yuvFragmentShader = 0;
        }
        int i4 = this.vertexShader;
        if (i4 == 0) {
            return 0L;
        }
        GLES20.glDeleteShader(i4);
        this.vertexShader = 0;
        return 0L;
    }

    public int draw(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i2, int i3) {
        GLES20.glClear(16384);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glUseProgram(this.programHandle);
        byteBuffer.position(0);
        GLES20.glActiveTexture(33984);
        loadTexture(this.texture[0], i2, i3, byteBuffer);
        byteBuffer2.position(0);
        GLES20.glActiveTexture(33985);
        int i4 = i2 >> 1;
        int i5 = i3 >> 1;
        loadTexture(this.texture[1], i4, i5, byteBuffer2);
        byteBuffer3.position(0);
        GLES20.glActiveTexture(33986);
        loadTexture(this.texture[2], i4, i5, byteBuffer3);
        GLES20.glUniform1i(this.textureSlot[0], 0);
        GLES20.glUniform1i(this.textureSlot[1], 1);
        GLES20.glUniform1i(this.textureSlot[2], 2);
        this.positionBuffer.position(0);
        GLES20.glEnableVertexAttribArray(this.positionSlot);
        GLES20.glVertexAttribPointer(this.positionSlot, 4, 5126, false, 0, (Buffer) this.positionBuffer);
        this.textCoodBuffer.position(0);
        GLES20.glEnableVertexAttribArray(this.texRangeSlot);
        GLES20.glVertexAttribPointer(this.texRangeSlot, 4, 5126, false, 0, (Buffer) this.textCoodBuffer);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.positionSlot);
        GLES20.glDisableVertexAttribArray(this.texRangeSlot);
        return 0;
    }

    public int loadTexture(int i2, int i3, int i4, Buffer buffer) {
        GLES20.glBindTexture(3553, i2);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6409, i3, i4, 0, 6409, 5121, buffer);
        return 0;
    }

    public int loadVBOs() {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(this.textCoodBufferData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.textCoodBuffer = asFloatBuffer;
        asFloatBuffer.put(this.textCoodBufferData).position(0);
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(this.positionBufferData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.positionBuffer = asFloatBuffer2;
        asFloatBuffer2.put(this.positionBufferData).position(0);
        return 0;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(16384);
        synchronized (this) {
            if (this.mWidth != 0 && this.mHeight != 0 && this.mYByteBuffer != null && this.mUByteBuffer != null && this.mVByteBuffer != null) {
                if (this.bNeedSleep) {
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                this.bNeedSleep = true;
                gl10.glViewport(this._x, this._y, this.width, this.height);
                draw(this.mYByteBuffer, this.mUByteBuffer, this.mVByteBuffer, this.mWidth, this.mHeight);
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        this.mWidth = 0;
        this.mWidth = 0;
        this.width = i2;
        this.height = i3;
        GLES20.glViewport(this._x, this._y, i2, i3);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glGenTextures(3, this.texture, 0);
        createShaders();
        loadVBOs();
    }

    public void setMatrix(int i2, int i3, int i4, int i5) {
        this._x = i2;
        this._y = i3;
        this.width = i4;
        this.height = i5;
    }

    public int unloadVBOs() {
        if (this.positionBuffer == null) {
            return 0;
        }
        this.positionBuffer = null;
        return 0;
    }

    public int writeSample(byte[] bArr, int i2, int i3) {
        synchronized (this) {
            if (i2 == 0 || i3 == 0) {
                MyLogUtils.d("writesample", "invalid param");
                return 0;
            }
            if (i2 != this.mWidth || i3 != this.mHeight) {
                this.mWidth = i2;
                this.mHeight = i3;
                this.mYByteBuffer = ByteBuffer.allocate(i2 * i3);
                this.mUByteBuffer = ByteBuffer.allocate((this.mWidth * this.mHeight) / 4);
                this.mVByteBuffer = ByteBuffer.allocate((this.mWidth * this.mHeight) / 4);
            }
            if (this.mYByteBuffer != null) {
                this.mYByteBuffer.position(0);
                this.mYByteBuffer.put(bArr, 0, this.mWidth * this.mHeight);
                this.mYByteBuffer.position(0);
            }
            if (this.mUByteBuffer != null) {
                this.mUByteBuffer.position(0);
                this.mUByteBuffer.put(bArr, this.mWidth * this.mHeight, (this.mWidth * this.mHeight) / 4);
                this.mUByteBuffer.position(0);
            }
            if (this.mVByteBuffer != null) {
                this.mVByteBuffer.position(0);
                this.mVByteBuffer.put(bArr, ((this.mWidth * this.mHeight) * 5) / 4, (this.mWidth * this.mHeight) / 4);
                this.mVByteBuffer.position(0);
            }
            this.bNeedSleep = false;
            return 1;
        }
    }
}
