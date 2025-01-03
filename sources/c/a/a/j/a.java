package c.a.a.j;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.shix.shixipc.utilcode.ThreadUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* compiled from: GifDecoder.java */
/* loaded from: classes.dex */
public class a {
    public static final String o = "a";
    public static final Bitmap.Config p = Bitmap.Config.ARGB_8888;

    /* renamed from: a, reason: collision with root package name */
    public int[] f2981a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f2982b;

    /* renamed from: d, reason: collision with root package name */
    public short[] f2984d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f2985e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f2986f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f2987g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f2988h;

    /* renamed from: i, reason: collision with root package name */
    public int f2989i;
    public InterfaceC0063a k;
    public Bitmap l;
    public boolean m;
    public int n;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f2983c = new byte[RecyclerView.c0.FLAG_TMP_DETACHED];
    public c j = new c();

    /* compiled from: GifDecoder.java */
    /* renamed from: c.a.a.j.a$a, reason: collision with other inner class name */
    public interface InterfaceC0063a {
        Bitmap a(int i2, int i3, Bitmap.Config config);

        void a(Bitmap bitmap);
    }

    public a(InterfaceC0063a interfaceC0063a) {
        this.k = interfaceC0063a;
    }

    public void a() {
        this.f2989i = (this.f2989i + 1) % this.j.f3001c;
    }

    public void b() {
        this.j = null;
        this.f2987g = null;
        this.f2988h = null;
        Bitmap bitmap = this.l;
        if (bitmap != null) {
            this.k.a(bitmap);
        }
        this.l = null;
    }

    public int c() {
        return this.f2989i;
    }

    public int d() {
        return this.j.f3001c;
    }

    public int e() {
        return this.j.m;
    }

    public final Bitmap f() {
        InterfaceC0063a interfaceC0063a = this.k;
        c cVar = this.j;
        Bitmap a2 = interfaceC0063a.a(cVar.f3004f, cVar.f3005g, p);
        if (a2 == null) {
            c cVar2 = this.j;
            a2 = Bitmap.createBitmap(cVar2.f3004f, cVar2.f3005g, p);
        }
        a(a2);
        return a2;
    }

    public int g() {
        int i2;
        if (this.j.f3001c <= 0 || (i2 = this.f2989i) < 0) {
            return -1;
        }
        return a(i2);
    }

    public synchronized Bitmap h() {
        if (this.j.f3001c <= 0 || this.f2989i < 0) {
            if (Log.isLoggable(o, 3)) {
                Log.d(o, "unable to decode frame, frameCount=" + this.j.f3001c + " framePointer=" + this.f2989i);
            }
            this.n = 1;
        }
        if (this.n != 1 && this.n != 2) {
            int i2 = 0;
            this.n = 0;
            b bVar = this.j.f3003e.get(this.f2989i);
            int i3 = this.f2989i - 1;
            b bVar2 = i3 >= 0 ? this.j.f3003e.get(i3) : null;
            if (bVar.k == null) {
                this.f2981a = this.j.f2999a;
            } else {
                this.f2981a = bVar.k;
                if (this.j.j == bVar.f2997h) {
                    this.j.l = 0;
                }
            }
            if (bVar.f2995f) {
                int i4 = this.f2981a[bVar.f2997h];
                this.f2981a[bVar.f2997h] = 0;
                i2 = i4;
            }
            if (this.f2981a == null) {
                if (Log.isLoggable(o, 3)) {
                    Log.d(o, "No Valid Color Table");
                }
                this.n = 1;
                return null;
            }
            Bitmap a2 = a(bVar, bVar2);
            if (bVar.f2995f) {
                this.f2981a[bVar.f2997h] = i2;
            }
            return a2;
        }
        if (Log.isLoggable(o, 3)) {
            Log.d(o, "Unable to decode frame, status=" + this.n);
        }
        return null;
    }

    public final int i() {
        try {
            return this.f2982b.get() & ThreadUtils.TYPE_SINGLE;
        } catch (Exception unused) {
            this.n = 1;
            return 0;
        }
    }

    public final int j() {
        int i2 = i();
        int i3 = 0;
        if (i2 > 0) {
            while (i3 < i2) {
                int i4 = i2 - i3;
                try {
                    this.f2982b.get(this.f2983c, i3, i4);
                    i3 += i4;
                } catch (Exception e2) {
                    Log.w(o, "Error Reading Block", e2);
                    this.n = 1;
                }
            }
        }
        return i3;
    }

    public int a(int i2) {
        if (i2 >= 0) {
            c cVar = this.j;
            if (i2 < cVar.f3001c) {
                return cVar.f3003e.get(i2).f2998i;
            }
        }
        return -1;
    }

    public void a(c cVar, byte[] bArr) {
        this.j = cVar;
        this.n = 0;
        this.f2989i = -1;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f2982b = wrap;
        wrap.rewind();
        this.f2982b.order(ByteOrder.LITTLE_ENDIAN);
        this.m = false;
        Iterator<b> it = cVar.f3003e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().f2996g == 3) {
                this.m = true;
                break;
            }
        }
        int i2 = cVar.f3004f;
        int i3 = cVar.f3005g;
        this.f2987g = new byte[i2 * i3];
        this.f2988h = new int[i2 * i3];
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009a A[EDGE_INSN: B:47:0x009a->B:48:0x009a BREAK  A[LOOP:0: B:16:0x0042->B:44:0x0095], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Bitmap a(c.a.a.j.b r18, c.a.a.j.b r19) {
        /*
            Method dump skipped, instructions count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.a.j.a.a(c.a.a.j.b, c.a.a.j.b):android.graphics.Bitmap");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0134 A[LOOP:5: B:63:0x0132->B:64:0x0134, LOOP_END] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v30, types: [short] */
    /* JADX WARN: Type inference failed for: r1v32 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(c.a.a.j.b r27) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.a.j.a.a(c.a.a.j.b):void");
    }

    @TargetApi(12)
    public static void a(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }
}
