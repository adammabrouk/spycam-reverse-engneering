package c.c.a.c.l;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateSelector;
import java.util.Iterator;

/* compiled from: MaterialTextInputPicker.java */
/* loaded from: classes.dex */
public final class i<S> extends m<S> {

    /* renamed from: b, reason: collision with root package name */
    public DateSelector<S> f5450b;

    /* renamed from: c, reason: collision with root package name */
    public CalendarConstraints f5451c;

    public static <T> i<T> a(DateSelector<T> dateSelector, CalendarConstraints calendarConstraints) {
        i<T> iVar = new i<>();
        Bundle bundle = new Bundle();
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        iVar.setArguments(bundle);
        return iVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f5450b = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f5451c = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f5450b.a(layoutInflater, viewGroup, bundle, this.f5451c, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f5450b);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f5451c);
    }

    /* compiled from: MaterialTextInputPicker.java */
    public class a extends l<S> {
        public a() {
        }

        @Override // c.c.a.c.l.l
        public void a(S s) {
            Iterator<l<S>> it = i.this.f5466a.iterator();
            while (it.hasNext()) {
                it.next().a(s);
            }
        }

        @Override // c.c.a.c.l.l
        public void a() {
            Iterator<l<S>> it = i.this.f5466a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }
}
