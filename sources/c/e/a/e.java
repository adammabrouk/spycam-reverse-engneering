package c.e.a;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: ViewHolder.kt */
/* loaded from: classes.dex */
public final class e extends RecyclerView.c0 {

    /* renamed from: c, reason: collision with root package name */
    public static final a f6189c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray<View> f6190a;

    /* renamed from: b, reason: collision with root package name */
    public final View f6191b;

    /* compiled from: ViewHolder.kt */
    public static final class a {
        public a() {
        }

        public final e a(View view) {
            f.j.b.f.d(view, "itemView");
            return new e(view);
        }

        public /* synthetic */ a(f.j.b.d dVar) {
            this();
        }

        public final e a(Context context, ViewGroup viewGroup, int i2) {
            f.j.b.f.d(context, "context");
            f.j.b.f.d(viewGroup, "parent");
            View inflate = LayoutInflater.from(context).inflate(i2, viewGroup, false);
            f.j.b.f.a((Object) inflate, "itemView");
            return new e(inflate);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(View view) {
        super(view);
        f.j.b.f.d(view, "convertView");
        this.f6191b = view;
        this.f6190a = new SparseArray<>();
    }

    public final View a() {
        return this.f6191b;
    }

    public final <T extends View> T getView(int i2) {
        T t = (T) this.f6190a.get(i2);
        if (t == null) {
            t = (T) this.f6191b.findViewById(i2);
            this.f6190a.put(i2, t);
        }
        if (t != null) {
            return t;
        }
        throw new f.f("null cannot be cast to non-null type T");
    }

    public final <T extends View> T getViewOrNull(int i2) {
        T t = (T) this.f6190a.get(i2);
        if (t == null) {
            t = (T) this.f6191b.findViewById(i2);
            this.f6190a.put(i2, t);
        }
        if (t instanceof View) {
            return t;
        }
        return null;
    }

    public final e setText(int i2, CharSequence charSequence) {
        f.j.b.f.d(charSequence, "text");
        TextView textView = (TextView) getView(i2);
        if (textView != null) {
            textView.setText(charSequence);
        }
        return this;
    }
}
