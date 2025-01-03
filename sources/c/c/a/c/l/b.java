package c.c.a.c.l;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;

/* compiled from: CalendarStyle.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final a f5403a;

    /* renamed from: b, reason: collision with root package name */
    public final a f5404b;

    /* renamed from: c, reason: collision with root package name */
    public final a f5405c;

    /* renamed from: d, reason: collision with root package name */
    public final a f5406d;

    /* renamed from: e, reason: collision with root package name */
    public final a f5407e;

    /* renamed from: f, reason: collision with root package name */
    public final a f5408f;

    /* renamed from: g, reason: collision with root package name */
    public final a f5409g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f5410h;

    public b(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(c.c.a.c.t.b.a(context, R$attr.materialCalendarStyle, f.class.getCanonicalName()), R$styleable.MaterialCalendar);
        this.f5403a = a.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayStyle, 0));
        this.f5409g = a.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.f5404b = a.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_daySelectedStyle, 0));
        this.f5405c = a.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList a2 = c.c.a.c.t.c.a(context, obtainStyledAttributes, R$styleable.MaterialCalendar_rangeFillColor);
        this.f5406d = a.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearStyle, 0));
        this.f5407e = a.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f5408f = a.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f5410h = paint;
        paint.setColor(a2.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
