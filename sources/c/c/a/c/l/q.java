package c.c.a.c.l;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.c.a.c.l.f;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.datepicker.Month;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: YearGridAdapter.java */
/* loaded from: classes.dex */
public class q extends RecyclerView.g<b> {

    /* renamed from: a, reason: collision with root package name */
    public final f<?> f5471a;

    /* compiled from: YearGridAdapter.java */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5472a;

        public a(int i2) {
            this.f5472a = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q.this.f5471a.a(q.this.f5471a.c().a(Month.a(this.f5472a, q.this.f5471a.e().f10475c)));
            q.this.f5471a.a(f.k.DAY);
        }
    }

    /* compiled from: YearGridAdapter.java */
    public static class b extends RecyclerView.c0 {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f5474a;

        public b(TextView textView) {
            super(textView);
            this.f5474a = textView;
        }
    }

    public q(f<?> fVar) {
        this.f5471a = fVar;
    }

    public int b(int i2) {
        return i2 - this.f5471a.c().f().f10476d;
    }

    public int c(int i2) {
        return this.f5471a.c().f().f10476d + i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f5471a.c().h();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i2) {
        int c2 = c(i2);
        String string = bVar.f5474a.getContext().getString(R$string.mtrl_picker_navigate_to_year_description);
        bVar.f5474a.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(c2)));
        bVar.f5474a.setContentDescription(String.format(string, Integer.valueOf(c2)));
        c.c.a.c.l.b d2 = this.f5471a.d();
        Calendar d3 = p.d();
        c.c.a.c.l.a aVar = d3.get(1) == c2 ? d2.f5408f : d2.f5406d;
        Iterator<Long> it = this.f5471a.f().l().iterator();
        while (it.hasNext()) {
            d3.setTimeInMillis(it.next().longValue());
            if (d3.get(1) == c2) {
                aVar = d2.f5407e;
            }
        }
        aVar.a(bVar.f5474a);
        bVar.f5474a.setOnClickListener(a(c2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public b onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_year, viewGroup, false));
    }

    public final View.OnClickListener a(int i2) {
        return new a(i2);
    }
}
