package a.b.f;

import a.h.b.d.f;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/* compiled from: TintTypedArray.java */
/* loaded from: classes.dex */
public class g0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f483a;

    /* renamed from: b, reason: collision with root package name */
    public final TypedArray f484b;

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f485c;

    public g0(Context context, TypedArray typedArray) {
        this.f483a = context;
        this.f484b = typedArray;
    }

    public static g0 a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new g0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public Drawable b(int i2) {
        int resourceId;
        return (!this.f484b.hasValue(i2) || (resourceId = this.f484b.getResourceId(i2, 0)) == 0) ? this.f484b.getDrawable(i2) : a.b.b.a.a.c(this.f483a, resourceId);
    }

    public Drawable c(int i2) {
        int resourceId;
        if (!this.f484b.hasValue(i2) || (resourceId = this.f484b.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return f.b().a(this.f483a, resourceId, true);
    }

    public String d(int i2) {
        return this.f484b.getString(i2);
    }

    public CharSequence e(int i2) {
        return this.f484b.getText(i2);
    }

    public int f(int i2, int i3) {
        return this.f484b.getLayoutDimension(i2, i3);
    }

    public int g(int i2, int i3) {
        return this.f484b.getResourceId(i2, i3);
    }

    public static g0 a(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3) {
        return new g0(context, context.obtainStyledAttributes(attributeSet, iArr, i2, i3));
    }

    public int d(int i2, int i3) {
        return this.f484b.getInt(i2, i3);
    }

    public int e(int i2, int i3) {
        return this.f484b.getInteger(i2, i3);
    }

    public CharSequence[] f(int i2) {
        return this.f484b.getTextArray(i2);
    }

    public boolean g(int i2) {
        return this.f484b.hasValue(i2);
    }

    public static g0 a(Context context, int i2, int[] iArr) {
        return new g0(context, context.obtainStyledAttributes(i2, iArr));
    }

    public int c(int i2, int i3) {
        return this.f484b.getDimensionPixelSize(i2, i3);
    }

    public TypedArray a() {
        return this.f484b;
    }

    public float b(int i2, float f2) {
        return this.f484b.getFloat(i2, f2);
    }

    public Typeface a(int i2, int i3, f.a aVar) {
        int resourceId = this.f484b.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f485c == null) {
            this.f485c = new TypedValue();
        }
        return a.h.b.d.f.a(this.f483a, resourceId, this.f485c, i3, aVar);
    }

    public int b(int i2, int i3) {
        return this.f484b.getDimensionPixelOffset(i2, i3);
    }

    public void b() {
        this.f484b.recycle();
    }

    public boolean a(int i2, boolean z) {
        return this.f484b.getBoolean(i2, z);
    }

    public int a(int i2, int i3) {
        return this.f484b.getColor(i2, i3);
    }

    public ColorStateList a(int i2) {
        int resourceId;
        ColorStateList b2;
        return (!this.f484b.hasValue(i2) || (resourceId = this.f484b.getResourceId(i2, 0)) == 0 || (b2 = a.b.b.a.a.b(this.f483a, resourceId)) == null) ? this.f484b.getColorStateList(i2) : b2;
    }

    public float a(int i2, float f2) {
        return this.f484b.getDimension(i2, f2);
    }
}
