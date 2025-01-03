package c.c.a.c.l;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: DaysOfWeekAdapter.java */
/* loaded from: classes.dex */
public class e extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    public static final int f5416d;

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f5417a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5418b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5419c;

    static {
        f5416d = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public e() {
        Calendar f2 = p.f();
        this.f5417a = f2;
        this.f5418b = f2.getMaximum(7);
        this.f5419c = this.f5417a.getFirstDayOfWeek();
    }

    public final int a(int i2) {
        int i3 = i2 + this.f5419c;
        int i4 = this.f5418b;
        return i3 > i4 ? i3 - i4 : i3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f5418b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public View getView(int i2, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.f5417a.set(7, a(i2));
        textView.setText(this.f5417a.getDisplayName(7, f5416d, Locale.getDefault()));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R$string.mtrl_picker_day_of_week_column_header), this.f5417a.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    @Override // android.widget.Adapter
    public Integer getItem(int i2) {
        if (i2 >= this.f5418b) {
            return null;
        }
        return Integer.valueOf(a(i2));
    }
}
