package c.e.b.g;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;
import c.e.b.e.j;
import com.lxj.xpopup.core.AttachPopupView;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.core.PositionPopupView;
import com.lxj.xpopup.impl.PartShadowPopupView;
import com.shix.shixipc.utils.SystemBarTintManager;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.Executors;

/* compiled from: XPopupUtils.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static int f6316a;

    /* renamed from: b, reason: collision with root package name */
    public static int f6317b;

    /* compiled from: XPopupUtils.java */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f6318a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f6319b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f6320c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f6321d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f6322e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Runnable f6323f;

        /* compiled from: XPopupUtils.java */
        /* renamed from: c.e.b.g.e$a$a, reason: collision with other inner class name */
        public class RunnableC0123a implements Runnable {
            public RunnableC0123a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Runnable runnable = a.this.f6323f;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }

        public a(ViewGroup viewGroup, int i2, int i3, int i4, int i5, Runnable runnable) {
            this.f6318a = viewGroup;
            this.f6319b = i2;
            this.f6320c = i3;
            this.f6321d = i4;
            this.f6322e = i5;
            this.f6323f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams layoutParams = this.f6318a.getLayoutParams();
            View childAt = this.f6318a.getChildAt(0);
            ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
            int measuredWidth = this.f6318a.getMeasuredWidth();
            int i2 = this.f6319b;
            if (i2 > 0) {
                layoutParams.width = Math.min(measuredWidth, i2);
                int i3 = this.f6320c;
                if (i3 > 0) {
                    layoutParams.width = Math.min(i3, this.f6319b);
                    layoutParams2.width = Math.min(this.f6320c, this.f6319b);
                }
            } else {
                int i4 = this.f6320c;
                if (i4 > 0) {
                    layoutParams.width = i4;
                    layoutParams2.width = i4;
                }
            }
            int measuredHeight = this.f6318a.getMeasuredHeight();
            int i5 = this.f6321d;
            if (i5 > 0) {
                layoutParams.height = Math.min(measuredHeight, i5);
                int i6 = this.f6322e;
                if (i6 > 0) {
                    layoutParams.height = Math.min(i6, this.f6321d);
                    layoutParams2.height = Math.min(this.f6322e, this.f6321d);
                }
            } else {
                int i7 = this.f6322e;
                if (i7 > 0) {
                    layoutParams.height = i7;
                    layoutParams2.height = i7;
                }
            }
            childAt.setLayoutParams(layoutParams2);
            this.f6318a.setLayoutParams(layoutParams);
            this.f6318a.post(new RunnableC0123a());
        }
    }

    /* compiled from: XPopupUtils.java */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BasePopupView f6325a;

        public b(BasePopupView basePopupView) {
            this.f6325a = basePopupView;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.c(e.f6317b, this.f6325a);
        }
    }

    /* compiled from: XPopupUtils.java */
    public static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f6326a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f6327b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f6328c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Handler f6329d;

        /* compiled from: XPopupUtils.java */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(c.this.f6327b, "图片不存在！", 0).show();
            }
        }

        /* compiled from: XPopupUtils.java */
        public class b implements MediaScannerConnection.OnScanCompletedListener {

            /* compiled from: XPopupUtils.java */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Context context = c.this.f6327b;
                    if (context != null) {
                        Toast.makeText(context, "已保存到相册！", 0).show();
                    }
                }
            }

            public b() {
            }

            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str, Uri uri) {
                c.this.f6329d.post(new a());
            }
        }

        /* compiled from: XPopupUtils.java */
        /* renamed from: c.e.b.g.e$c$c, reason: collision with other inner class name */
        public class RunnableC0124c implements Runnable {
            public RunnableC0124c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(c.this.f6327b, "没有保存权限，保存功能无法使用！", 0).show();
            }
        }

        public c(j jVar, Context context, Object obj, Handler handler) {
            this.f6326a = jVar;
            this.f6327b = context;
            this.f6328c = obj;
            this.f6329d = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            File a2 = this.f6326a.a(this.f6327b, this.f6328c);
            if (a2 == null) {
                this.f6329d.post(new a());
                return;
            }
            String absolutePath = this.f6327b.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath();
            File file = new File(absolutePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                String b2 = e.b(c.e.b.g.b.a(new FileInputStream(a2)));
                File file2 = new File(absolutePath, System.currentTimeMillis() + "." + b2);
                if (file2.exists()) {
                    file2.delete();
                }
                file2.createNewFile();
                e.b(file2, new FileInputStream(a2));
                MediaScannerConnection.scanFile(this.f6327b, new String[]{file2.getAbsolutePath()}, new String[]{"image/" + b2}, new b());
            } catch (IOException e2) {
                e2.printStackTrace();
                this.f6329d.post(new RunnableC0124c());
            }
        }
    }

    /* compiled from: XPopupUtils.java */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6334a;

        static {
            int[] iArr = new int[c.e.b.d.a.values().length];
            f6334a = iArr;
            try {
                iArr[c.e.b.d.a.GIF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6334a[c.e.b.d.a.PNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6334a[c.e.b.d.a.PNG_A.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6334a[c.e.b.d.a.WEBP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6334a[c.e.b.d.a.WEBP_A.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6334a[c.e.b.d.a.JPEG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static void a(EditText editText, int i2) {
    }

    public static int b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealSize(point);
        } else {
            windowManager.getDefaultDisplay().getSize(point);
        }
        return point.y;
    }

    public static int c(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    public static boolean d(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(i2 >= 24 ? context.getResources().getConfiguration().getLocales().get(0) : context.getResources().getConfiguration().locale) == 1;
        }
        return false;
    }

    public static int c() {
        Resources system = Resources.getSystem();
        return system.getDimensionPixelSize(system.getIdentifier(SystemBarTintManager.SystemBarConfig.STATUS_BAR_HEIGHT_RES_NAME, "dimen", "android"));
    }

    public static int a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.y;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x009c, code lost:
    
        if (r7 > 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x009e, code lost:
    
        r11 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0108, code lost:
    
        if (r7 > 0) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(int r11, com.lxj.xpopup.core.BasePopupView r12) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.b.g.e.c(int, com.lxj.xpopup.core.BasePopupView):void");
    }

    public static int b() {
        Resources system = Resources.getSystem();
        int identifier = system.getIdentifier(SystemBarTintManager.SystemBarConfig.NAV_BAR_HEIGHT_RES_NAME, "dimen", "android");
        if (identifier != 0) {
            return system.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void a(View view, int i2, int i3) {
        if (i2 > 0 || i3 > 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (i2 > 0) {
                layoutParams.width = i2;
            }
            if (i3 > 0) {
                layoutParams.height = i3;
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public static void b(int i2, BasePopupView basePopupView) {
        f6317b = i2;
        basePopupView.post(new b(basePopupView));
    }

    public static boolean b(BasePopupView basePopupView) {
        return (basePopupView instanceof PartShadowPopupView) && !((PartShadowPopupView) basePopupView).w;
    }

    public static boolean b(Window window) {
        boolean z;
        int i2;
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        int childCount = viewGroup.getChildCount();
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                z = false;
                break;
            }
            View childAt = viewGroup.getChildAt(i3);
            int id = childAt.getId();
            if (id != -1 && "navigationBarBackground".equals(window.getContext().getResources().getResourceEntryName(id)) && childAt.getVisibility() == 0) {
                z = true;
                break;
            }
            i3++;
        }
        if (!z) {
            return z;
        }
        if (c.e.b.g.a.d() && (i2 = Build.VERSION.SDK_INT) >= 17 && i2 < 29) {
            try {
                return Settings.Global.getInt(window.getContext().getContentResolver(), "navigationbar_hide_bar_enabled") == 0;
            } catch (Exception unused) {
            }
        }
        return (viewGroup.getSystemUiVisibility() & 2) == 0;
    }

    public static void a(ViewGroup viewGroup, int i2, int i3, int i4, int i5, Runnable runnable) {
        viewGroup.post(new a(viewGroup, i2, i4, i3, i5, runnable));
    }

    public static BitmapDrawable a(Resources resources, int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, 20, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(i3);
        canvas.drawRect(0.0f, 0.0f, createBitmap.getWidth(), 4.0f, paint);
        paint.setColor(0);
        canvas.drawRect(0.0f, 4.0f, createBitmap.getWidth(), 20.0f, paint);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, createBitmap);
        bitmapDrawable.setGravity(80);
        return bitmapDrawable;
    }

    public static String b(c.e.b.d.a aVar) {
        int i2 = d.f6334a[aVar.ordinal()];
        return i2 != 1 ? (i2 == 2 || i2 == 3) ? "png" : (i2 == 4 || i2 == 5) ? "webp" : "jpeg" : "gif";
    }

    public static StateListDrawable a(Drawable drawable, Drawable drawable2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_focused}, drawable2);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static boolean b(File file, InputStream inputStream) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 8192);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream2.write(bArr, 0, read);
                    }
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return true;
                } catch (IOException e4) {
                    e = e4;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    try {
                        inputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    if (bufferedOutputStream == null) {
                        throw th;
                    }
                    try {
                        bufferedOutputStream.close();
                        throw th;
                    } catch (IOException e8) {
                        e8.printStackTrace();
                        throw th;
                    }
                }
            } catch (IOException e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(float f2, float f3, Rect rect) {
        return f2 >= ((float) rect.left) && f2 <= ((float) rect.right) && f3 >= ((float) rect.top) && f3 <= ((float) rect.bottom);
    }

    public static int a(Window window) {
        View decorView = window.getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int abs = Math.abs(decorView.getBottom() - rect.bottom);
        if (abs <= b()) {
            f6316a = abs;
            return 0;
        }
        return abs - f6316a;
    }

    public static boolean a(BasePopupView basePopupView) {
        return (basePopupView instanceof PartShadowPopupView) && ((PartShadowPopupView) basePopupView).w;
    }

    public static void a(ArrayList<EditText> arrayList, ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof EditText) && childAt.getVisibility() == 0) {
                arrayList.add((EditText) childAt);
            } else if (childAt instanceof ViewGroup) {
                a(arrayList, (ViewGroup) childAt);
            }
        }
    }

    public static void c(BasePopupView basePopupView) {
        if (basePopupView instanceof PositionPopupView) {
            return;
        }
        boolean z = basePopupView instanceof PartShadowPopupView;
        if (z || !(basePopupView instanceof AttachPopupView)) {
            if (z && !a(basePopupView)) {
                basePopupView.getPopupImplView().animate().translationY(0.0f).setDuration(100L).start();
            } else {
                basePopupView.getPopupContentView().animate().translationY(0.0f).setDuration(100L).start();
            }
        }
    }

    public static Bitmap b(View view) {
        Bitmap createBitmap;
        if (view == null) {
            return null;
        }
        boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
        boolean willNotCacheDrawing = view.willNotCacheDrawing();
        view.setDrawingCacheEnabled(true);
        view.setWillNotCacheDrawing(false);
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            Bitmap drawingCache2 = view.getDrawingCache();
            if (drawingCache2 != null) {
                createBitmap = Bitmap.createBitmap(drawingCache2);
            } else {
                createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                view.draw(new Canvas(createBitmap));
            }
        } else {
            createBitmap = Bitmap.createBitmap(drawingCache);
        }
        view.destroyDrawingCache();
        view.setWillNotCacheDrawing(willNotCacheDrawing);
        view.setDrawingCacheEnabled(isDrawingCacheEnabled);
        return createBitmap;
    }

    public static void a(Context context, j jVar, Object obj) {
        Executors.newSingleThreadExecutor().execute(new c(jVar, context, obj, new Handler(Looper.getMainLooper())));
    }

    public static Bitmap a(Context context, Bitmap bitmap, float f2, boolean z) {
        RenderScript renderScript;
        if (!z) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        try {
            renderScript = RenderScript.create(context);
        } catch (Throwable th) {
            th = th;
            renderScript = null;
        }
        try {
            renderScript.setMessageHandler(new RenderScript.RSMessageHandler());
            Allocation createFromBitmap = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            Allocation createTyped = Allocation.createTyped(renderScript, createFromBitmap.getType());
            ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            create.setInput(createFromBitmap);
            create.setRadius(f2);
            create.forEach(createTyped);
            createTyped.copyTo(bitmap);
            if (renderScript != null) {
                renderScript.destroy();
            }
            return bitmap;
        } catch (Throwable th2) {
            th = th2;
            if (renderScript != null) {
                renderScript.destroy();
            }
            throw th;
        }
    }

    public static Activity a(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static Drawable a(int i2, float f2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius(f2);
        return gradientDrawable;
    }

    public static Drawable a(int i2, float f2, float f3, float f4, float f5) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadii(new float[]{f2, f2, f3, f3, f4, f4, f5, f5});
        return gradientDrawable;
    }
}
