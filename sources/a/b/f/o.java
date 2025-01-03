package a.b.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatEditText;
import com.shix.shixipc.utilcode.MemoryConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: AppCompatTextViewAutoSizeHelper.java */
/* loaded from: classes.dex */
public class o {
    public static final RectF l = new RectF();

    @SuppressLint({"BanConcurrentHashMap"})
    public static ConcurrentHashMap<String, Method> m = new ConcurrentHashMap<>();

    @SuppressLint({"BanConcurrentHashMap"})
    public static ConcurrentHashMap<String, Field> n = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public int f555a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f556b = false;

    /* renamed from: c, reason: collision with root package name */
    public float f557c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f558d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f559e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    public int[] f560f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public boolean f561g = false;

    /* renamed from: h, reason: collision with root package name */
    public TextPaint f562h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f563i;
    public final Context j;
    public final c k;

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    public static class a extends c {
        @Override // a.b.f.o.c
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) o.b(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    public static class b extends a {
        @Override // a.b.f.o.c
        public boolean a(TextView textView) {
            return textView.isHorizontallyScrollable();
        }

        @Override // a.b.f.o.a, a.b.f.o.c
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    public static class c {
        public void a(StaticLayout.Builder builder, TextView textView) {
        }

        public boolean a(TextView textView) {
            return ((Boolean) o.b(textView, "getHorizontallyScrolling", false)).booleanValue();
        }
    }

    public o(TextView textView) {
        this.f563i = textView;
        this.j = textView.getContext();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            this.k = new b();
        } else if (i2 >= 23) {
            this.k = new a();
        } else {
            this.k = new c();
        }
    }

    public void a(AttributeSet attributeSet, int i2) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.j.obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i2, 0);
        TextView textView = this.f563i;
        a.h.j.y.a(textView, textView.getContext(), R$styleable.AppCompatTextView, attributeSet, obtainStyledAttributes, i2, 0);
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeTextType)) {
            this.f555a = obtainStyledAttributes.getInt(R$styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(R$styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(R$styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(R$styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(R$styleable.AppCompatTextView_autoSizePresetSizes) && (resourceId = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            a(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!k()) {
            this.f555a = 0;
            return;
        }
        if (this.f555a == 1) {
            if (!this.f561g) {
                DisplayMetrics displayMetrics = this.j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                a(dimension2, dimension3, dimension);
            }
            i();
        }
    }

    public void b(int i2) {
        if (k()) {
            if (i2 == 0) {
                b();
                return;
            }
            if (i2 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i2);
            }
            DisplayMetrics displayMetrics = this.j.getResources().getDisplayMetrics();
            a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (i()) {
                a();
            }
        }
    }

    public int c() {
        return Math.round(this.f559e);
    }

    public int d() {
        return Math.round(this.f558d);
    }

    public int e() {
        return Math.round(this.f557c);
    }

    public int[] f() {
        return this.f560f;
    }

    public int g() {
        return this.f555a;
    }

    public boolean h() {
        return k() && this.f555a != 0;
    }

    public final boolean i() {
        if (k() && this.f555a == 1) {
            if (!this.f561g || this.f560f.length == 0) {
                int floor = ((int) Math.floor((this.f559e - this.f558d) / this.f557c)) + 1;
                int[] iArr = new int[floor];
                for (int i2 = 0; i2 < floor; i2++) {
                    iArr[i2] = Math.round(this.f558d + (i2 * this.f557c));
                }
                this.f560f = a(iArr);
            }
            this.f556b = true;
        } else {
            this.f556b = false;
        }
        return this.f556b;
    }

    public final boolean j() {
        boolean z = this.f560f.length > 0;
        this.f561g = z;
        if (z) {
            this.f555a = 1;
            int[] iArr = this.f560f;
            this.f558d = iArr[0];
            this.f559e = iArr[r0 - 1];
            this.f557c = -1.0f;
        }
        return this.f561g;
    }

    public final boolean k() {
        return !(this.f563i instanceof AppCompatEditText);
    }

    public final void b() {
        this.f555a = 0;
        this.f558d = -1.0f;
        this.f559e = -1.0f;
        this.f557c = -1.0f;
        this.f560f = new int[0];
        this.f556b = false;
    }

    public final StaticLayout b(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f562h, i2);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(this.f563i.getLineSpacingExtra(), this.f563i.getLineSpacingMultiplier()).setIncludePad(this.f563i.getIncludeFontPadding()).setBreakStrategy(this.f563i.getBreakStrategy()).setHyphenationFrequency(this.f563i.getHyphenationFrequency());
        if (i3 == -1) {
            i3 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i3);
        try {
            this.k.a(obtain, this.f563i);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return obtain.build();
    }

    public void a(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (k()) {
            DisplayMetrics displayMetrics = this.j.getResources().getDisplayMetrics();
            a(TypedValue.applyDimension(i5, i2, displayMetrics), TypedValue.applyDimension(i5, i3, displayMetrics), TypedValue.applyDimension(i5, i4, displayMetrics));
            if (i()) {
                a();
            }
        }
    }

    public final StaticLayout b(CharSequence charSequence, Layout.Alignment alignment, int i2) {
        return new StaticLayout(charSequence, this.f562h, i2, alignment, this.f563i.getLineSpacingMultiplier(), this.f563i.getLineSpacingExtra(), this.f563i.getIncludeFontPadding());
    }

    public static <T> T b(Object obj, String str, T t) {
        try {
            return (T) b(str).invoke(obj, new Object[0]);
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e2);
            return t;
        }
    }

    public void a(int[] iArr, int i2) throws IllegalArgumentException {
        if (k()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i2 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.j.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr2[i3] = Math.round(TypedValue.applyDimension(i2, iArr[i3], displayMetrics));
                    }
                }
                this.f560f = a(iArr2);
                if (!j()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f561g = false;
            }
            if (i()) {
                a();
            }
        }
    }

    public static Method b(String str) {
        try {
            Method method = m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                m.put(str, method);
            }
            return method;
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e2);
            return null;
        }
    }

    public final void a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = typedArray.getDimensionPixelSize(i2, -1);
            }
            this.f560f = a(iArr);
            j();
        }
    }

    public final int[] a(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr2;
    }

    public final void a(float f2, float f3, float f4) throws IllegalArgumentException {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        }
        if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        }
        if (f4 > 0.0f) {
            this.f555a = 1;
            this.f558d = f2;
            this.f559e = f3;
            this.f557c = f4;
            this.f561g = false;
            return;
        }
        throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
    }

    public void a() {
        if (h()) {
            if (this.f556b) {
                if (this.f563i.getMeasuredHeight() <= 0 || this.f563i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.k.a(this.f563i) ? MemoryConstants.MB : (this.f563i.getMeasuredWidth() - this.f563i.getTotalPaddingLeft()) - this.f563i.getTotalPaddingRight();
                int height = (this.f563i.getHeight() - this.f563i.getCompoundPaddingBottom()) - this.f563i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                synchronized (l) {
                    l.setEmpty();
                    l.right = measuredWidth;
                    l.bottom = height;
                    float a2 = a(l);
                    if (a2 != this.f563i.getTextSize()) {
                        a(0, a2);
                    }
                }
            }
            this.f556b = true;
        }
    }

    public void a(int i2, float f2) {
        Resources resources;
        Context context = this.j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        a(TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics()));
    }

    public final void a(float f2) {
        if (f2 != this.f563i.getPaint().getTextSize()) {
            this.f563i.getPaint().setTextSize(f2);
            boolean isInLayout = Build.VERSION.SDK_INT >= 18 ? this.f563i.isInLayout() : false;
            if (this.f563i.getLayout() != null) {
                this.f556b = false;
                try {
                    Method b2 = b("nullLayouts");
                    if (b2 != null) {
                        b2.invoke(this.f563i, new Object[0]);
                    }
                } catch (Exception e2) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e2);
                }
                if (!isInLayout) {
                    this.f563i.requestLayout();
                } else {
                    this.f563i.forceLayout();
                }
                this.f563i.invalidate();
            }
        }
    }

    public final int a(RectF rectF) {
        int length = this.f560f.length;
        if (length != 0) {
            int i2 = length - 1;
            int i3 = 1;
            int i4 = 0;
            while (i3 <= i2) {
                int i5 = (i3 + i2) / 2;
                if (a(this.f560f[i5], rectF)) {
                    int i6 = i5 + 1;
                    i4 = i3;
                    i3 = i6;
                } else {
                    i4 = i5 - 1;
                    i2 = i4;
                }
            }
            return this.f560f[i4];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public void a(int i2) {
        TextPaint textPaint = this.f562h;
        if (textPaint == null) {
            this.f562h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f562h.set(this.f563i.getPaint());
        this.f562h.setTextSize(i2);
    }

    public StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 23) {
            return b(charSequence, alignment, i2, i3);
        }
        if (i4 >= 16) {
            return b(charSequence, alignment, i2);
        }
        return a(charSequence, alignment, i2);
    }

    public final boolean a(int i2, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f563i.getText();
        TransformationMethod transformationMethod = this.f563i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f563i)) != null) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.f563i.getMaxLines() : -1;
        a(i2);
        StaticLayout a2 = a(text, (Layout.Alignment) b(this.f563i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (a2.getLineCount() <= maxLines && a2.getLineEnd(a2.getLineCount() - 1) == text.length())) && ((float) a2.getHeight()) <= rectF.bottom;
    }

    public final StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i2) {
        return new StaticLayout(charSequence, this.f562h, i2, alignment, ((Float) a(this.f563i, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) a(this.f563i, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) a(this.f563i, "mIncludePad", true)).booleanValue());
    }

    public static <T> T a(Object obj, String str, T t) {
        try {
            Field a2 = a(str);
            return a2 == null ? t : (T) a2.get(obj);
        } catch (IllegalAccessException e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e2);
            return t;
        }
    }

    public static Field a(String str) {
        try {
            Field field = n.get(str);
            if (field == null && (field = TextView.class.getDeclaredField(str)) != null) {
                field.setAccessible(true);
                n.put(str, field);
            }
            return field;
        } catch (NoSuchFieldException e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e2);
            return null;
        }
    }
}
