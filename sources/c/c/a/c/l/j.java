package c.c.a.c.l;

import android.content.Context;
import android.widget.BaseAdapter;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateSelector;
import com.google.android.material.datepicker.Month;

/* compiled from: MonthAdapter.java */
/* loaded from: classes.dex */
public class j extends BaseAdapter {

    /* renamed from: e, reason: collision with root package name */
    public static final int f5453e = p.f().getMaximum(4);

    /* renamed from: a, reason: collision with root package name */
    public final Month f5454a;

    /* renamed from: b, reason: collision with root package name */
    public final DateSelector<?> f5455b;

    /* renamed from: c, reason: collision with root package name */
    public b f5456c;

    /* renamed from: d, reason: collision with root package name */
    public final CalendarConstraints f5457d;

    public j(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.f5454a = month;
        this.f5455b = dateSelector;
        this.f5457d = calendarConstraints;
    }

    public final void a(Context context) {
        if (this.f5456c == null) {
            this.f5456c = new b(context);
        }
    }

    public int b() {
        return (this.f5454a.a() + this.f5454a.f10478f) - 1;
    }

    public boolean c(int i2) {
        return (i2 + 1) % this.f5454a.f10477e == 0;
    }

    public int d(int i2) {
        return (i2 - this.f5454a.a()) + 1;
    }

    public boolean e(int i2) {
        return i2 >= a() && i2 <= b();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f5454a.f10478f + a();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2 / this.f5454a.f10477e;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public boolean b(int i2) {
        return i2 % this.f5454a.f10477e == 0;
    }

    @Override // android.widget.Adapter
    public Long getItem(int i2) {
        if (i2 < this.f5454a.a() || i2 > b()) {
            return null;
        }
        return Long.valueOf(this.f5454a.a(d(i2)));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.a(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R$layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.a()
            int r7 = r6 - r7
            r8 = 1
            if (r7 < 0) goto L61
            com.google.android.material.datepicker.Month r2 = r5.f5454a
            int r3 = r2.f10478f
            if (r7 < r3) goto L2e
            goto L61
        L2e:
            int r7 = r7 + r8
            r0.setTag(r2)
            java.lang.String r2 = java.lang.String.valueOf(r7)
            r0.setText(r2)
            com.google.android.material.datepicker.Month r2 = r5.f5454a
            long r2 = r2.a(r7)
            com.google.android.material.datepicker.Month r7 = r5.f5454a
            int r7 = r7.f10476d
            com.google.android.material.datepicker.Month r4 = com.google.android.material.datepicker.Month.e()
            int r4 = r4.f10476d
            if (r7 != r4) goto L53
            java.lang.String r7 = c.c.a.c.l.d.c(r2)
            r0.setContentDescription(r7)
            goto L5a
        L53:
            java.lang.String r7 = c.c.a.c.l.d.e(r2)
            r0.setContentDescription(r7)
        L5a:
            r0.setVisibility(r1)
            r0.setEnabled(r8)
            goto L69
        L61:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
        L69:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L70
            return r0
        L70:
            com.google.android.material.datepicker.CalendarConstraints r7 = r5.f5457d
            com.google.android.material.datepicker.CalendarConstraints$DateValidator r7 = r7.a()
            long r2 = r6.longValue()
            boolean r7 = r7.a(r2)
            if (r7 == 0) goto Ld5
            r0.setEnabled(r8)
            com.google.android.material.datepicker.DateSelector<?> r7 = r5.f5455b
            java.util.Collection r7 = r7.l()
            java.util.Iterator r7 = r7.iterator()
        L8d:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto Lb5
            java.lang.Object r8 = r7.next()
            java.lang.Long r8 = (java.lang.Long) r8
            long r1 = r8.longValue()
            long r3 = r6.longValue()
            long r3 = c.c.a.c.l.p.a(r3)
            long r1 = c.c.a.c.l.p.a(r1)
            int r8 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r8 != 0) goto L8d
            c.c.a.c.l.b r6 = r5.f5456c
            c.c.a.c.l.a r6 = r6.f5404b
            r6.a(r0)
            return r0
        Lb5:
            java.util.Calendar r7 = c.c.a.c.l.p.d()
            long r7 = r7.getTimeInMillis()
            long r1 = r6.longValue()
            int r6 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r6 != 0) goto Lcd
            c.c.a.c.l.b r6 = r5.f5456c
            c.c.a.c.l.a r6 = r6.f5405c
            r6.a(r0)
            return r0
        Lcd:
            c.c.a.c.l.b r6 = r5.f5456c
            c.c.a.c.l.a r6 = r6.f5403a
            r6.a(r0)
            return r0
        Ld5:
            r0.setEnabled(r1)
            c.c.a.c.l.b r6 = r5.f5456c
            c.c.a.c.l.a r6 = r6.f5409g
            r6.a(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.c.l.j.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    public int a() {
        return this.f5454a.a();
    }

    public int a(int i2) {
        return a() + (i2 - 1);
    }
}
