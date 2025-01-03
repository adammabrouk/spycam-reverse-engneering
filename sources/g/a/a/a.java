package g.a.a;

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

/* compiled from: MyRender.java */
/* loaded from: classes.dex */
public class a implements GLSurfaceView.Renderer {

    /* renamed from: a, reason: collision with root package name */
    public int f11327a = 0;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f11328b = null;

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer f11329c = null;

    /* renamed from: d, reason: collision with root package name */
    public int f11330d = 0;

    /* renamed from: e, reason: collision with root package name */
    public ByteBuffer f11331e = null;

    /* renamed from: f, reason: collision with root package name */
    public FloatBuffer f11332f = null;

    /* renamed from: h, reason: collision with root package name */
    public int f11334h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f11335i = 0;
    public int j = 0;
    public int[] k = new int[3];
    public int[] l = new int[3];
    public int m = 0;
    public int n = 0;
    public FloatBuffer p = null;
    public boolean q = true;
    public final float[] o = {0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: g, reason: collision with root package name */
    public final float[] f11333g = {-1.0f, 1.0f, 0.0f, 1.0f, -1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 1.0f};

    public a(GLSurfaceView gLSurfaceView) {
        gLSurfaceView.setEGLContextClientVersion(2);
    }

    public static int a(String str, int i2) {
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
        MyLogUtils.e("compileShader", "compile shader err:" + GLES20.glGetProgramInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public long b() {
        int i2 = this.f11335i;
        if (i2 != 0) {
            GLES20.glDetachShader(i2, this.n);
            GLES20.glDetachShader(this.f11335i, this.m);
            GLES20.glDeleteProgram(this.f11335i);
            this.f11335i = 0;
        }
        int i3 = this.n;
        if (i3 != 0) {
            GLES20.glDeleteShader(i3);
            this.n = 0;
        }
        int i4 = this.m;
        if (i4 == 0) {
            return 0L;
        }
        GLES20.glDeleteShader(i4);
        this.m = 0;
        return 0L;
    }

    public int c() {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(this.o.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.p = asFloatBuffer;
        asFloatBuffer.put(this.o).position(0);
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(this.f11333g.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f11332f = asFloatBuffer2;
        asFloatBuffer2.put(this.f11333g).position(0);
        return 0;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        MyLogUtils.d("opengl1_yuvRender", "onDrawFrame");
        GLES20.glClear(16384);
        synchronized (this) {
            if (this.f11330d != 0 && this.f11327a != 0 && this.f11331e != null && this.f11328b != null && this.f11329c != null) {
                if (this.q) {
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                this.q = true;
                a(this.f11331e, this.f11328b, this.f11329c, this.f11330d, this.f11327a);
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        GLES20.glViewport(0, 0, i2, i3);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glGenTextures(3, this.k, 0);
        a();
        c();
    }

    public long a() {
        String str = (((((((((((((((((("uniform sampler2D Ytex;\nuniform sampler2D Utex;\n") + "uniform sampler2D Vtex;\n") + "precision mediump float;  \n") + "varying vec4 VaryingTexCoord0; \n") + "vec4 color;\n") + "void main()\n") + "{\n") + "float yuv0 = (texture2D(Ytex,VaryingTexCoord0.xy)).r;\n") + "float yuv1 = (texture2D(Utex,VaryingTexCoord0.xy)).r;\n") + "float yuv2 = (texture2D(Vtex,VaryingTexCoord0.xy)).r;\n") + OSSUtils.NEW_LINE) + "color.r = yuv0 + 1.4022 * yuv2 - 0.7011;\n") + "color.r = (color.r < 0.0) ? 0.0 : ((color.r > 1.0) ? 1.0 : color.r);\n") + "color.g = yuv0 - 0.3456 * yuv1 - 0.7145 * yuv2 + 0.53005;\n") + "color.g = (color.g < 0.0) ? 0.0 : ((color.g > 1.0) ? 1.0 : color.g);\n") + "color.b = yuv0 + 1.771 * yuv1 - 0.8855;\n") + "color.b = (color.b < 0.0) ? 0.0 : ((color.b > 1.0) ? 1.0 : color.b);\n") + "gl_FragColor = color;\n") + "}\n";
        int[] iArr = new int[1];
        int a2 = a((((((("uniform mat4 uMVPMatrix;   \nattribute vec4 vPosition;  \n") + "attribute vec4 myTexCoord; \n") + "varying vec4 VaryingTexCoord0; \n") + "void main(){               \n") + "VaryingTexCoord0 = myTexCoord; \n") + "gl_Position = vPosition; \n") + "}  \n", 35633);
        this.m = a2;
        if (a2 == 0) {
            MyLogUtils.e("createShaders", "failed when compileShader(vertex)");
        }
        int a3 = a(str, 35632);
        this.n = a3;
        if (a3 == 0) {
            MyLogUtils.e("createShaders", "failed when compileShader(fragment)");
        }
        int glCreateProgram = GLES20.glCreateProgram();
        this.f11335i = glCreateProgram;
        GLES20.glAttachShader(glCreateProgram, this.m);
        GLES20.glAttachShader(this.f11335i, this.n);
        GLES20.glLinkProgram(this.f11335i);
        GLES20.glGetProgramiv(this.f11335i, 35714, iArr, 0);
        if (iArr[0] == 0) {
            MyLogUtils.e("createShaders", "link program err:" + GLES20.glGetProgramInfoLog(this.f11335i));
            b();
        }
        this.j = GLES20.glGetAttribLocation(this.f11335i, "myTexCoord");
        this.l[0] = GLES20.glGetUniformLocation(this.f11335i, "Ytex");
        this.l[1] = GLES20.glGetUniformLocation(this.f11335i, "Utex");
        this.l[2] = GLES20.glGetUniformLocation(this.f11335i, "Vtex");
        this.f11334h = GLES20.glGetAttribLocation(this.f11335i, "vPosition");
        MyLogUtils.d("aaaaa", "texRangeSlot: " + this.j);
        MyLogUtils.d("aaaaa", "positionSlot: " + this.f11334h);
        MyLogUtils.d("aaaaa", "textureSlot[0]: " + this.l[0]);
        MyLogUtils.d("aaaaa", "textureSlot[1]: " + this.l[1]);
        MyLogUtils.d("aaaaa", "textureSlot[2]: " + this.l[2]);
        return 0L;
    }

    public int a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i2, int i3) {
        GLES20.glClear(16384);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glUseProgram(this.f11335i);
        byteBuffer.position(0);
        GLES20.glActiveTexture(33984);
        a(this.k[0], i2, i3, byteBuffer);
        byteBuffer2.position(0);
        GLES20.glActiveTexture(33985);
        int i4 = i2 >> 1;
        int i5 = i3 >> 1;
        a(this.k[1], i4, i5, byteBuffer2);
        byteBuffer3.position(0);
        GLES20.glActiveTexture(33986);
        a(this.k[2], i4, i5, byteBuffer3);
        GLES20.glUniform1i(this.l[0], 0);
        GLES20.glUniform1i(this.l[1], 1);
        GLES20.glUniform1i(this.l[2], 2);
        this.f11332f.position(0);
        GLES20.glEnableVertexAttribArray(this.f11334h);
        GLES20.glVertexAttribPointer(this.f11334h, 4, 5126, false, 0, (Buffer) this.f11332f);
        this.p.position(0);
        GLES20.glEnableVertexAttribArray(this.j);
        GLES20.glVertexAttribPointer(this.j, 4, 5126, false, 0, (Buffer) this.p);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f11334h);
        GLES20.glDisableVertexAttribArray(this.j);
        return 0;
    }

    public int a(int i2, int i3, int i4, Buffer buffer) {
        GLES20.glBindTexture(3553, i2);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6409, i3, i4, 0, 6409, 5121, buffer);
        return 0;
    }

    public int a(byte[] bArr, int i2, int i3) {
        synchronized (this) {
            if (i2 != 0 && i3 != 0) {
                if (i2 != this.f11330d || i3 != this.f11327a) {
                    this.f11330d = i2;
                    this.f11327a = i3;
                    this.f11331e = ByteBuffer.allocate(i2 * i3);
                    this.f11328b = ByteBuffer.allocate((this.f11330d * this.f11327a) / 4);
                    this.f11329c = ByteBuffer.allocate((this.f11330d * this.f11327a) / 4);
                }
                if (this.f11331e != null) {
                    this.f11331e.position(0);
                    this.f11331e.put(bArr, 0, this.f11330d * this.f11327a);
                    this.f11331e.position(0);
                }
                if (this.f11328b != null) {
                    this.f11328b.position(0);
                    this.f11328b.put(bArr, this.f11330d * this.f11327a, (this.f11330d * this.f11327a) / 4);
                    this.f11328b.position(0);
                }
                if (this.f11329c != null) {
                    this.f11329c.position(0);
                    this.f11329c.put(bArr, ((this.f11330d * this.f11327a) * 5) / 4, (this.f11330d * this.f11327a) / 4);
                    this.f11329c.position(0);
                }
                this.q = false;
                return 1;
            }
            MyLogUtils.d("writesample", "invalid param");
            return 0;
        }
    }
}
