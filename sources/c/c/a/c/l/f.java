package c.c.a.c.l;

import a.h.j.y;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateSelector;
import com.google.android.material.datepicker.Month;
import java.util.Calendar;
import java.util.Iterator;

/* compiled from: MaterialCalendar.java */
/* loaded from: classes.dex */
public final class f<S> extends m<S> {
    public static final Object l = "MONTHS_VIEW_GROUP_TAG";
    public static final Object m = "NAVIGATION_PREV_TAG";
    public static final Object n = "NAVIGATION_NEXT_TAG";
    public static final Object o = "SELECTOR_TOGGLE_TAG";

    /* renamed from: b, reason: collision with root package name */
    public int f5420b;

    /* renamed from: c, reason: collision with root package name */
    public DateSelector<S> f5421c;

    /* renamed from: d, reason: collision with root package name */
    public CalendarConstraints f5422d;

    /* renamed from: e, reason: collision with root package name */
    public Month f5423e;

    /* renamed from: f, reason: collision with root package name */
    public k f5424f;

    /* renamed from: g, reason: collision with root package name */
    public c.c.a.c.l.b f5425g;

    /* renamed from: h, reason: collision with root package name */
    public RecyclerView f5426h;

    /* renamed from: i, reason: collision with root package name */
    public RecyclerView f5427i;
    public View j;
    public View k;

    /* compiled from: MaterialCalendar.java */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5428a;

        public a(int i2) {
            this.f5428a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f5427i.smoothScrollToPosition(this.f5428a);
        }
    }

    /* compiled from: MaterialCalendar.java */
    public class b extends a.h.j.a {
        public b(f fVar) {
        }

        @Override // a.h.j.a
        public void a(View view, a.h.j.h0.c cVar) {
            super.a(view, cVar);
            cVar.a((Object) null);
        }
    }

    /* compiled from: MaterialCalendar.java */
    public class c extends n {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5430a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, int i2, boolean z, int i3) {
            super(context, i2, z);
            this.f5430a = i3;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(RecyclerView.z zVar, int[] iArr) {
            if (this.f5430a == 0) {
                iArr[0] = f.this.f5427i.getWidth();
                iArr[1] = f.this.f5427i.getWidth();
            } else {
                iArr[0] = f.this.f5427i.getHeight();
                iArr[1] = f.this.f5427i.getHeight();
            }
        }
    }

    /* compiled from: MaterialCalendar.java */
    public class d implements l {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.c.a.c.l.f.l
        public void a(long j) {
            if (f.this.f5422d.a().a(j)) {
                f.this.f5421c.f(j);
                Iterator<c.c.a.c.l.l<S>> it = f.this.f5466a.iterator();
                while (it.hasNext()) {
                    it.next().a(f.this.f5421c.o());
                }
                f.this.f5427i.getAdapter().notifyDataSetChanged();
                if (f.this.f5426h != null) {
                    f.this.f5426h.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    /* compiled from: MaterialCalendar.java */
    public class e extends RecyclerView.n {

        /* renamed from: a, reason: collision with root package name */
        public final Calendar f5433a = p.f();

        /* renamed from: b, reason: collision with root package name */
        public final Calendar f5434b = p.f();

        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
            if ((recyclerView.getAdapter() instanceof q) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                q qVar = (q) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (a.h.i.d<Long, Long> dVar : f.this.f5421c.b()) {
                    Long l = dVar.f1104a;
                    if (l != null && dVar.f1105b != null) {
                        this.f5433a.setTimeInMillis(l.longValue());
                        this.f5434b.setTimeInMillis(dVar.f1105b.longValue());
                        int b2 = qVar.b(this.f5433a.get(1));
                        int b3 = qVar.b(this.f5434b.get(1));
                        View findViewByPosition = gridLayoutManager.findViewByPosition(b2);
                        View findViewByPosition2 = gridLayoutManager.findViewByPosition(b3);
                        int spanCount = b2 / gridLayoutManager.getSpanCount();
                        int spanCount2 = b3 / gridLayoutManager.getSpanCount();
                        int i2 = spanCount;
                        while (i2 <= spanCount2) {
                            if (gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i2) != null) {
                                canvas.drawRect(i2 == spanCount ? findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2) : 0, r9.getTop() + f.this.f5425g.f5406d.b(), i2 == spanCount2 ? findViewByPosition2.getLeft() + (findViewByPosition2.getWidth() / 2) : recyclerView.getWidth(), r9.getBottom() - f.this.f5425g.f5406d.a(), f.this.f5425g.f5410h);
                            }
                            i2++;
                        }
                    }
                }
            }
        }
    }

    /* compiled from: MaterialCalendar.java */
    /* renamed from: c.c.a.c.l.f$f, reason: collision with other inner class name */
    public class C0103f extends a.h.j.a {
        public C0103f() {
        }

        @Override // a.h.j.a
        public void a(View view, a.h.j.h0.c cVar) {
            super.a(view, cVar);
            cVar.d(f.this.k.getVisibility() == 0 ? f.this.getString(R$string.mtrl_picker_toggle_to_year_selection) : f.this.getString(R$string.mtrl_picker_toggle_to_day_selection));
        }
    }

    /* compiled from: MaterialCalendar.java */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.h();
        }
    }

    /* compiled from: MaterialCalendar.java */
    public class i implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.c.a.c.l.k f5441a;

        public i(c.c.a.c.l.k kVar) {
            this.f5441a = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int findFirstVisibleItemPosition = f.this.g().findFirstVisibleItemPosition() + 1;
            if (findFirstVisibleItemPosition < f.this.f5427i.getAdapter().getItemCount()) {
                f.this.a(this.f5441a.a(findFirstVisibleItemPosition));
            }
        }
    }

    /* compiled from: MaterialCalendar.java */
    public class j implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.c.a.c.l.k f5443a;

        public j(c.c.a.c.l.k kVar) {
            this.f5443a = kVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int findLastVisibleItemPosition = f.this.g().findLastVisibleItemPosition() - 1;
            if (findLastVisibleItemPosition >= 0) {
                f.this.a(this.f5443a.a(findLastVisibleItemPosition));
            }
        }
    }

    /* compiled from: MaterialCalendar.java */
    public enum k {
        DAY,
        YEAR
    }

    /* compiled from: MaterialCalendar.java */
    public interface l {
        void a(long j);
    }

    public LinearLayoutManager g() {
        return (LinearLayoutManager) this.f5427i.getLayoutManager();
    }

    public void h() {
        k kVar = this.f5424f;
        if (kVar == k.YEAR) {
            a(k.DAY);
        } else if (kVar == k.DAY) {
            a(k.YEAR);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f5420b = bundle.getInt("THEME_RES_ID_KEY");
        this.f5421c = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f5422d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f5423e = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f5420b);
        this.f5425g = new c.c.a.c.l.b(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month f2 = this.f5422d.f();
        if (c.c.a.c.l.g.f(contextThemeWrapper)) {
            i2 = R$layout.mtrl_calendar_vertical;
            i3 = 1;
        } else {
            i2 = R$layout.mtrl_calendar_horizontal;
            i3 = 0;
        }
        View inflate = cloneInContext.inflate(i2, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(R$id.mtrl_calendar_days_of_week);
        y.a(gridView, new b(this));
        gridView.setAdapter((ListAdapter) new c.c.a.c.l.e());
        gridView.setNumColumns(f2.f10477e);
        gridView.setEnabled(false);
        this.f5427i = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_months);
        this.f5427i.setLayoutManager(new c(getContext(), i3, false, i3));
        this.f5427i.setTag(l);
        c.c.a.c.l.k kVar = new c.c.a.c.l.k(contextThemeWrapper, this.f5421c, this.f5422d, new d());
        this.f5427i.setAdapter(kVar);
        int integer = contextThemeWrapper.getResources().getInteger(R$integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.f5426h = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f5426h.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f5426h.setAdapter(new q(this));
            this.f5426h.addItemDecoration(b());
        }
        if (inflate.findViewById(R$id.month_navigation_fragment_toggle) != null) {
            a(inflate, kVar);
        }
        if (!c.c.a.c.l.g.f(contextThemeWrapper)) {
            new a.p.a.i().a(this.f5427i);
        }
        this.f5427i.scrollToPosition(kVar.a(this.f5423e));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f5420b);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f5421c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f5422d);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f5423e);
    }

    public final RecyclerView.n b() {
        return new e();
    }

    public CalendarConstraints c() {
        return this.f5422d;
    }

    public c.c.a.c.l.b d() {
        return this.f5425g;
    }

    public Month e() {
        return this.f5423e;
    }

    public DateSelector<S> f() {
        return this.f5421c;
    }

    public static <T> f<T> a(DateSelector<T> dateSelector, int i2, CalendarConstraints calendarConstraints) {
        f<T> fVar = new f<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.e());
        fVar.setArguments(bundle);
        return fVar;
    }

    /* compiled from: MaterialCalendar.java */
    public class g extends RecyclerView.t {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.c.a.c.l.k f5437a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MaterialButton f5438b;

        public g(c.c.a.c.l.k kVar, MaterialButton materialButton) {
            this.f5437a = kVar;
            this.f5438b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i2, int i3) {
            int findFirstVisibleItemPosition = i2 < 0 ? f.this.g().findFirstVisibleItemPosition() : f.this.g().findLastVisibleItemPosition();
            f.this.f5423e = this.f5437a.a(findFirstVisibleItemPosition);
            this.f5438b.setText(this.f5437a.b(findFirstVisibleItemPosition));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                CharSequence text = this.f5438b.getText();
                if (Build.VERSION.SDK_INT >= 16) {
                    recyclerView.announceForAccessibility(text);
                } else {
                    recyclerView.sendAccessibilityEvent(2048);
                }
            }
        }
    }

    public void a(Month month) {
        c.c.a.c.l.k kVar = (c.c.a.c.l.k) this.f5427i.getAdapter();
        int a2 = kVar.a(month);
        int a3 = a2 - kVar.a(this.f5423e);
        boolean z = Math.abs(a3) > 3;
        boolean z2 = a3 > 0;
        this.f5423e = month;
        if (z && z2) {
            this.f5427i.scrollToPosition(a2 - 3);
            a(a2);
        } else if (z) {
            this.f5427i.scrollToPosition(a2 + 3);
            a(a2);
        } else {
            a(a2);
        }
    }

    public static int a(Context context) {
        return context.getResources().getDimensionPixelSize(R$dimen.mtrl_calendar_day_height);
    }

    public void a(k kVar) {
        this.f5424f = kVar;
        if (kVar == k.YEAR) {
            this.f5426h.getLayoutManager().scrollToPosition(((q) this.f5426h.getAdapter()).b(this.f5423e.f10476d));
            this.j.setVisibility(0);
            this.k.setVisibility(8);
        } else if (kVar == k.DAY) {
            this.j.setVisibility(8);
            this.k.setVisibility(0);
            a(this.f5423e);
        }
    }

    public final void a(View view, c.c.a.c.l.k kVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.month_navigation_fragment_toggle);
        materialButton.setTag(o);
        y.a(materialButton, new C0103f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.month_navigation_previous);
        materialButton2.setTag(m);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R$id.month_navigation_next);
        materialButton3.setTag(n);
        this.j = view.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.k = view.findViewById(R$id.mtrl_calendar_day_selector_frame);
        a(k.DAY);
        materialButton.setText(this.f5423e.c());
        this.f5427i.addOnScrollListener(new g(kVar, materialButton));
        materialButton.setOnClickListener(new h());
        materialButton3.setOnClickListener(new i(kVar));
        materialButton2.setOnClickListener(new j(kVar));
    }

    public final void a(int i2) {
        this.f5427i.post(new a(i2));
    }
}
