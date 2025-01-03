package c.c.a.c.l;

import a.h.j.y;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.c.a.c.l.f;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateSelector;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import com.google.android.material.datepicker.Month;

/* compiled from: MonthsPagerAdapter.java */
/* loaded from: classes.dex */
public class k extends RecyclerView.g<b> {

    /* renamed from: a, reason: collision with root package name */
    public final CalendarConstraints f5458a;

    /* renamed from: b, reason: collision with root package name */
    public final DateSelector<?> f5459b;

    /* renamed from: c, reason: collision with root package name */
    public final f.l f5460c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5461d;

    /* compiled from: MonthsPagerAdapter.java */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialCalendarGridView f5462a;

        public a(MaterialCalendarGridView materialCalendarGridView) {
            this.f5462a = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            if (this.f5462a.getAdapter().e(i2)) {
                k.this.f5460c.a(this.f5462a.getAdapter().getItem(i2).longValue());
            }
        }
    }

    /* compiled from: MonthsPagerAdapter.java */
    public static class b extends RecyclerView.c0 {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f5464a;

        /* renamed from: b, reason: collision with root package name */
        public final MaterialCalendarGridView f5465b;

        public b(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R$id.month_title);
            this.f5464a = textView;
            y.a((View) textView, true);
            this.f5465b = (MaterialCalendarGridView) linearLayout.findViewById(R$id.month_grid);
            if (z) {
                return;
            }
            this.f5464a.setVisibility(8);
        }
    }

    public k(Context context, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, f.l lVar) {
        Month f2 = calendarConstraints.f();
        Month c2 = calendarConstraints.c();
        Month e2 = calendarConstraints.e();
        if (f2.compareTo(e2) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (e2.compareTo(c2) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f5461d = (j.f5453e * f.a(context)) + (g.f(context) ? f.a(context) : 0);
        this.f5458a = calendarConstraints;
        this.f5459b = dateSelector;
        this.f5460c = lVar;
        setHasStableIds(true);
    }

    public CharSequence b(int i2) {
        return a(i2).c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f5458a.d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i2) {
        return this.f5458a.f().b(i2).d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i2) {
        Month b2 = this.f5458a.f().b(i2);
        bVar.f5464a.setText(b2.c());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f5465b.findViewById(R$id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !b2.equals(materialCalendarGridView.getAdapter().f5454a)) {
            j jVar = new j(b2, this.f5459b, this.f5458a);
            materialCalendarGridView.setNumColumns(b2.f10477e);
            materialCalendarGridView.setAdapter((ListAdapter) jVar);
        } else {
            materialCalendarGridView.getAdapter().notifyDataSetChanged();
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public b onCreateViewHolder(ViewGroup viewGroup, int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!g.f(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.p(-1, this.f5461d));
        return new b(linearLayout, true);
    }

    public Month a(int i2) {
        return this.f5458a.f().b(i2);
    }

    public int a(Month month) {
        return this.f5458a.f().b(month);
    }
}
