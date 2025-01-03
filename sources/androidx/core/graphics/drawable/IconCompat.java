package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    public static final PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f2486a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2487b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f2488c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f2489d;

    /* renamed from: e, reason: collision with root package name */
    public int f2490e;

    /* renamed from: f, reason: collision with root package name */
    public int f2491f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f2492g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f2493h;

    /* renamed from: i, reason: collision with root package name */
    public String f2494i;
    public String j;

    public IconCompat() {
        this.f2486a = -1;
        this.f2488c = null;
        this.f2489d = null;
        this.f2490e = 0;
        this.f2491f = 0;
        this.f2492g = null;
        this.f2493h = k;
        this.f2494i = null;
    }

    public static IconCompat a(Resources resources, String str, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("Package must not be null.");
        }
        if (i2 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f2490e = i2;
        if (resources != null) {
            try {
                iconCompat.f2487b = resources.getResourceName(i2);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f2487b = str;
        }
        iconCompat.j = str;
        return iconCompat;
    }

    public static String a(int i2) {
        switch (i2) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public int b() {
        if (this.f2486a == -1 && Build.VERSION.SDK_INT >= 23) {
            return a((Icon) this.f2487b);
        }
        if (this.f2486a == 2) {
            return this.f2490e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String c() {
        if (this.f2486a == -1 && Build.VERSION.SDK_INT >= 23) {
            return b((Icon) this.f2487b);
        }
        if (this.f2486a == 2) {
            return TextUtils.isEmpty(this.j) ? ((String) this.f2487b).split(":", -1)[0] : this.j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int d() {
        return (this.f2486a != -1 || Build.VERSION.SDK_INT < 23) ? this.f2486a : c((Icon) this.f2487b);
    }

    public Uri e() {
        if (this.f2486a == -1 && Build.VERSION.SDK_INT >= 23) {
            return d((Icon) this.f2487b);
        }
        int i2 = this.f2486a;
        if (i2 == 4 || i2 == 6) {
            return Uri.parse((String) this.f2487b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public void f() {
        this.f2493h = PorterDuff.Mode.valueOf(this.f2494i);
        switch (this.f2486a) {
            case -1:
                Parcelable parcelable = this.f2489d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f2487b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f2489d;
                if (parcelable2 != null) {
                    this.f2487b = parcelable2;
                    return;
                }
                byte[] bArr = this.f2488c;
                this.f2487b = bArr;
                this.f2486a = 3;
                this.f2490e = 0;
                this.f2491f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f2488c, Charset.forName("UTF-16"));
                this.f2487b = str;
                if (this.f2486a == 2 && this.j == null) {
                    this.j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f2487b = this.f2488c;
                return;
        }
    }

    @Deprecated
    public Icon g() {
        return b((Context) null);
    }

    public String toString() {
        if (this.f2486a == -1) {
            return String.valueOf(this.f2487b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(a(this.f2486a));
        switch (this.f2486a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f2487b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f2487b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(b())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f2490e);
                if (this.f2491f != 0) {
                    sb.append(" off=");
                    sb.append(this.f2491f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f2487b);
                break;
        }
        if (this.f2492g != null) {
            sb.append(" tint=");
            sb.append(this.f2492g);
        }
        if (this.f2493h != k) {
            sb.append(" mode=");
            sb.append(this.f2493h);
        }
        sb.append(")");
        return sb.toString();
    }

    public static Uri d(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon uri", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon uri", e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon uri", e4);
            return null;
        }
    }

    public Icon b(Context context) {
        Icon createWithBitmap;
        switch (this.f2486a) {
            case -1:
                return (Icon) this.f2487b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                createWithBitmap = Icon.createWithBitmap((Bitmap) this.f2487b);
                break;
            case 2:
                createWithBitmap = Icon.createWithResource(c(), this.f2490e);
                break;
            case 3:
                createWithBitmap = Icon.createWithData((byte[]) this.f2487b, this.f2490e, this.f2491f);
                break;
            case 4:
                createWithBitmap = Icon.createWithContentUri((String) this.f2487b);
                break;
            case 5:
                if (Build.VERSION.SDK_INT >= 26) {
                    createWithBitmap = Icon.createWithAdaptiveBitmap((Bitmap) this.f2487b);
                    break;
                } else {
                    createWithBitmap = Icon.createWithBitmap(a((Bitmap) this.f2487b, false));
                    break;
                }
            case 6:
                if (Build.VERSION.SDK_INT >= 30) {
                    createWithBitmap = Icon.createWithAdaptiveBitmapContentUri(e());
                    break;
                } else if (context != null) {
                    InputStream a2 = a(context);
                    if (a2 != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            createWithBitmap = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(a2));
                            break;
                        } else {
                            createWithBitmap = Icon.createWithBitmap(a(BitmapFactory.decodeStream(a2), false));
                            break;
                        }
                    } else {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + e());
                    }
                } else {
                    throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + e());
                }
        }
        ColorStateList colorStateList = this.f2492g;
        if (colorStateList != null) {
            createWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.f2493h;
        if (mode != k) {
            createWithBitmap.setTintMode(mode);
        }
        return createWithBitmap;
    }

    public static int c(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e2);
            return -1;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e3);
            return -1;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e4);
            return -1;
        }
    }

    public static IconCompat a(Bitmap bitmap) {
        if (bitmap != null) {
            IconCompat iconCompat = new IconCompat(1);
            iconCompat.f2487b = bitmap;
            return iconCompat;
        }
        throw new IllegalArgumentException("Bitmap must not be null.");
    }

    public IconCompat(int i2) {
        this.f2486a = -1;
        this.f2488c = null;
        this.f2489d = null;
        this.f2490e = 0;
        this.f2491f = 0;
        this.f2492g = null;
        this.f2493h = k;
        this.f2494i = null;
        this.f2486a = i2;
    }

    public Bitmap a() {
        if (this.f2486a == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f2487b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        int i2 = this.f2486a;
        if (i2 == 1) {
            return (Bitmap) this.f2487b;
        }
        if (i2 == 5) {
            return a((Bitmap) this.f2487b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public InputStream a(Context context) {
        Uri e2 = e();
        String scheme = e2.getScheme();
        if (!"content".equals(scheme) && !"file".equals(scheme)) {
            try {
                return new FileInputStream(new File((String) this.f2487b));
            } catch (FileNotFoundException e3) {
                Log.w("IconCompat", "Unable to load image from path: " + e2, e3);
                return null;
            }
        }
        try {
            return context.getContentResolver().openInputStream(e2);
        } catch (Exception e4) {
            Log.w("IconCompat", "Unable to load image from URI: " + e2, e4);
            return null;
        }
    }

    public void a(boolean z) {
        this.f2494i = this.f2493h.name();
        switch (this.f2486a) {
            case -1:
                if (!z) {
                    this.f2489d = (Parcelable) this.f2487b;
                    return;
                }
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z) {
                    Bitmap bitmap = (Bitmap) this.f2487b;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f2488c = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.f2489d = (Parcelable) this.f2487b;
                return;
            case 2:
                this.f2488c = ((String) this.f2487b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f2488c = (byte[]) this.f2487b;
                return;
            case 4:
            case 6:
                this.f2488c = this.f2487b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    public static String b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon package", e4);
            return null;
        }
    }

    public static int a(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon resource", e4);
            return 0;
        }
    }

    public static Bitmap a(Bitmap bitmap, boolean z) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f2 = min;
        float f3 = 0.5f * f2;
        float f4 = 0.9166667f * f3;
        if (z) {
            float f5 = 0.010416667f * f2;
            paint.setColor(0);
            paint.setShadowLayer(f5, 0.0f, f2 * 0.020833334f, 1023410176);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.setShadowLayer(f5, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f3, f3, f4, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2, (-(bitmap.getHeight() - min)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f3, f3, f4, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }
}
