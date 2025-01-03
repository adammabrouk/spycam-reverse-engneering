package androidx.appcompat.app;

import a.h.j.y;
import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class AlertController {
    public NestedScrollView A;
    public Drawable C;
    public ImageView D;
    public TextView E;
    public TextView F;
    public View G;
    public ListAdapter H;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public Handler R;

    /* renamed from: a, reason: collision with root package name */
    public final Context f2077a;

    /* renamed from: b, reason: collision with root package name */
    public final a.b.a.f f2078b;

    /* renamed from: c, reason: collision with root package name */
    public final Window f2079c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2080d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f2081e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f2082f;

    /* renamed from: g, reason: collision with root package name */
    public ListView f2083g;

    /* renamed from: h, reason: collision with root package name */
    public View f2084h;

    /* renamed from: i, reason: collision with root package name */
    public int f2085i;
    public int j;
    public int k;
    public int l;
    public int m;
    public Button o;
    public CharSequence p;
    public Message q;
    public Drawable r;
    public Button s;
    public CharSequence t;
    public Message u;
    public Drawable v;
    public Button w;
    public CharSequence x;
    public Message y;
    public Drawable z;
    public boolean n = false;
    public int B = 0;
    public int I = -1;
    public int Q = 0;
    public final View.OnClickListener S = new a();

    public static class RecycleListView extends ListView {

        /* renamed from: a, reason: collision with root package name */
        public final int f2086a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2087b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public void a(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f2086a, getPaddingRight(), z2 ? getPaddingBottom() : this.f2087b);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecycleListView);
            this.f2087b = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f2086a = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message obtain;
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            if (view != alertController.o || (message3 = alertController.q) == null) {
                AlertController alertController2 = AlertController.this;
                if (view != alertController2.s || (message2 = alertController2.u) == null) {
                    AlertController alertController3 = AlertController.this;
                    obtain = (view != alertController3.w || (message = alertController3.y) == null) ? null : Message.obtain(message);
                } else {
                    obtain = Message.obtain(message2);
                }
            } else {
                obtain = Message.obtain(message3);
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController alertController4 = AlertController.this;
            alertController4.R.obtainMessage(1, alertController4.f2078b).sendToTarget();
        }
    }

    public class b implements NestedScrollView.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2089a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f2090b;

        public b(AlertController alertController, View view, View view2) {
            this.f2089a = view;
            this.f2090b = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.b
        public void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            AlertController.a(nestedScrollView, this.f2089a, this.f2090b);
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2091a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f2092b;

        public c(View view, View view2) {
            this.f2091a = view;
            this.f2092b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.a(AlertController.this.A, this.f2091a, this.f2092b);
        }
    }

    public class d implements AbsListView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2094a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f2095b;

        public d(AlertController alertController, View view, View view2) {
            this.f2094a = view;
            this.f2095b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            AlertController.a(absListView, this.f2094a, this.f2095b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
        }
    }

    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2096a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f2097b;

        public e(View view, View view2) {
            this.f2096a = view;
            this.f2097b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.a(AlertController.this.f2083g, this.f2096a, this.f2097b);
        }
    }

    public static class f {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public e O;

        /* renamed from: a, reason: collision with root package name */
        public final Context f2099a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f2100b;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f2102d;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f2104f;

        /* renamed from: g, reason: collision with root package name */
        public View f2105g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f2106h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f2107i;
        public Drawable j;
        public DialogInterface.OnClickListener k;
        public CharSequence l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public DialogInterface.OnCancelListener s;
        public DialogInterface.OnDismissListener t;
        public DialogInterface.OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;

        /* renamed from: c, reason: collision with root package name */
        public int f2101c = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f2103e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean r = true;

        public class a extends ArrayAdapter<CharSequence> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f2108a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Context context, int i2, int i3, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i2, i3, charSequenceArr);
                this.f2108a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i2, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i2, view, viewGroup);
                boolean[] zArr = f.this.F;
                if (zArr != null && zArr[i2]) {
                    this.f2108a.setItemChecked(i2, true);
                }
                return view2;
            }
        }

        public class b extends CursorAdapter {

            /* renamed from: a, reason: collision with root package name */
            public final int f2110a;

            /* renamed from: b, reason: collision with root package name */
            public final int f2111b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f2112c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ AlertController f2113d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Context context, Cursor cursor, boolean z, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z);
                this.f2112c = recycleListView;
                this.f2113d = alertController;
                Cursor cursor2 = getCursor();
                this.f2110a = cursor2.getColumnIndexOrThrow(f.this.L);
                this.f2111b = cursor2.getColumnIndexOrThrow(f.this.M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f2110a));
                this.f2112c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f2111b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f2100b.inflate(this.f2113d.M, viewGroup, false);
            }
        }

        public class c implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AlertController f2115a;

            public c(AlertController alertController) {
                this.f2115a = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                f.this.x.onClick(this.f2115a.f2078b, i2);
                if (f.this.H) {
                    return;
                }
                this.f2115a.f2078b.dismiss();
            }
        }

        public class d implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f2117a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AlertController f2118b;

            public d(RecycleListView recycleListView, AlertController alertController) {
                this.f2117a = recycleListView;
                this.f2118b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                boolean[] zArr = f.this.F;
                if (zArr != null) {
                    zArr[i2] = this.f2117a.isItemChecked(i2);
                }
                f.this.J.onClick(this.f2118b.f2078b, i2, this.f2117a.isItemChecked(i2));
            }
        }

        public interface e {
            void a(ListView listView);
        }

        public f(Context context) {
            this.f2099a = context;
            this.f2100b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a(AlertController alertController) {
            View view = this.f2105g;
            if (view != null) {
                alertController.a(view);
            } else {
                CharSequence charSequence = this.f2104f;
                if (charSequence != null) {
                    alertController.b(charSequence);
                }
                Drawable drawable = this.f2102d;
                if (drawable != null) {
                    alertController.a(drawable);
                }
                int i2 = this.f2101c;
                if (i2 != 0) {
                    alertController.b(i2);
                }
                int i3 = this.f2103e;
                if (i3 != 0) {
                    alertController.b(alertController.a(i3));
                }
            }
            CharSequence charSequence2 = this.f2106h;
            if (charSequence2 != null) {
                alertController.a(charSequence2);
            }
            if (this.f2107i != null || this.j != null) {
                alertController.a(-1, this.f2107i, this.k, (Message) null, this.j);
            }
            if (this.l != null || this.m != null) {
                alertController.a(-2, this.l, this.n, (Message) null, this.m);
            }
            if (this.o != null || this.p != null) {
                alertController.a(-3, this.o, this.q, (Message) null, this.p);
            }
            if (this.v != null || this.K != null || this.w != null) {
                b(alertController);
            }
            View view2 = this.z;
            if (view2 != null) {
                if (this.E) {
                    alertController.a(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.b(view2);
                    return;
                }
            }
            int i4 = this.y;
            if (i4 != 0) {
                alertController.c(i4);
            }
        }

        public final void b(AlertController alertController) {
            ListAdapter listAdapter;
            RecycleListView recycleListView = (RecycleListView) this.f2100b.inflate(alertController.L, (ViewGroup) null);
            if (this.G) {
                listAdapter = this.K == null ? new a(this.f2099a, alertController.M, R.id.text1, this.v, recycleListView) : new b(this.f2099a, this.K, false, recycleListView, alertController);
            } else {
                int i2 = this.H ? alertController.N : alertController.O;
                if (this.K != null) {
                    listAdapter = new SimpleCursorAdapter(this.f2099a, i2, this.K, new String[]{this.L}, new int[]{R.id.text1});
                } else {
                    listAdapter = this.w;
                    if (listAdapter == null) {
                        listAdapter = new h(this.f2099a, i2, R.id.text1, this.v);
                    }
                }
            }
            e eVar = this.O;
            if (eVar != null) {
                eVar.a(recycleListView);
            }
            alertController.H = listAdapter;
            alertController.I = this.I;
            if (this.x != null) {
                recycleListView.setOnItemClickListener(new c(alertController));
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f2083g = recycleListView;
        }
    }

    public static final class g extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<DialogInterface> f2120a;

        public g(DialogInterface dialogInterface) {
            this.f2120a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == -3 || i2 == -2 || i2 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f2120a.get(), message.what);
            } else {
                if (i2 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public static class h extends ArrayAdapter<CharSequence> {
        public h(Context context, int i2, int i3, CharSequence[] charSequenceArr) {
            super(context, i2, i3, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, a.b.a.f fVar, Window window) {
        this.f2077a = context;
        this.f2078b = fVar;
        this.f2079c = window;
        this.R = new g(fVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.AlertDialog, R$attr.alertDialogStyle, 0);
        this.J = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_android_layout, 0);
        this.K = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.L = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listLayout, 0);
        this.M = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.N = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.O = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listItemLayout, 0);
        this.P = obtainStyledAttributes.getBoolean(R$styleable.AlertDialog_showTitle, true);
        this.f2080d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        fVar.a(1);
    }

    public static boolean a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public static boolean c(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (c(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public void b() {
        this.f2078b.setContentView(c());
        d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d() {
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3 = this.f2079c.findViewById(R$id.parentPanel);
        View findViewById4 = findViewById3.findViewById(R$id.topPanel);
        View findViewById5 = findViewById3.findViewById(R$id.contentPanel);
        View findViewById6 = findViewById3.findViewById(R$id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R$id.customPanel);
        c(viewGroup);
        View findViewById7 = viewGroup.findViewById(R$id.topPanel);
        View findViewById8 = viewGroup.findViewById(R$id.contentPanel);
        View findViewById9 = viewGroup.findViewById(R$id.buttonPanel);
        ViewGroup a2 = a(findViewById7, findViewById4);
        ViewGroup a3 = a(findViewById8, findViewById5);
        ViewGroup a4 = a(findViewById9, findViewById6);
        b(a3);
        a(a4);
        d(a2);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a2 == null || a2.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (a4 == null || a4.getVisibility() == 8) ? false : true;
        if (!z3 && a3 != null && (findViewById2 = a3.findViewById(R$id.textSpacerNoButtons)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z2 != 0) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View findViewById10 = (this.f2082f == null && this.f2083g == null) ? null : a2.findViewById(R$id.titleDividerNoCustom);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        } else if (a3 != null && (findViewById = a3.findViewById(R$id.textSpacerNoTitle)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f2083g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z2, z3);
        }
        if (!z) {
            View view = this.f2083g;
            if (view == null) {
                view = this.A;
            }
            if (view != null) {
                a(a3, view, z2 | (z3 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f2083g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i2 = this.I;
        if (i2 > -1) {
            listView2.setItemChecked(i2, true);
            listView2.setSelection(i2);
        }
    }

    public void a(View view) {
        this.G = view;
    }

    public void b(CharSequence charSequence) {
        this.f2081e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void a(CharSequence charSequence) {
        this.f2082f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void b(View view) {
        this.f2084h = view;
        this.f2085i = 0;
        this.n = false;
    }

    public final int c() {
        int i2 = this.K;
        if (i2 == 0) {
            return this.J;
        }
        return this.Q == 1 ? i2 : this.J;
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        this.f2084h = view;
        this.f2085i = 0;
        this.n = true;
        this.j = i2;
        this.k = i3;
        this.l = i4;
        this.m = i5;
    }

    public void b(int i2) {
        this.C = null;
        this.B = i2;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i2 != 0) {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void c(int i2) {
        this.f2084h = null;
        this.f2085i = i2;
        this.n = false;
    }

    public final void c(ViewGroup viewGroup) {
        View view = this.f2084h;
        if (view == null) {
            view = this.f2085i != 0 ? LayoutInflater.from(this.f2077a).inflate(this.f2085i, viewGroup, false) : null;
        }
        boolean z = view != null;
        if (!z || !c(view)) {
            this.f2079c.setFlags(OSSConstants.DEFAULT_STREAM_BUFFER_SIZE, OSSConstants.DEFAULT_STREAM_BUFFER_SIZE);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f2079c.findViewById(R$id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.n) {
                frameLayout.setPadding(this.j, this.k, this.l, this.m);
            }
            if (this.f2083g != null) {
                ((LinearLayout.LayoutParams) ((LinearLayoutCompat.a) viewGroup.getLayoutParams())).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    public void a(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i2, onClickListener);
        }
        if (i2 == -3) {
            this.x = charSequence;
            this.y = message;
            this.z = drawable;
        } else if (i2 == -2) {
            this.t = charSequence;
            this.u = message;
            this.v = drawable;
        } else {
            if (i2 == -1) {
                this.p = charSequence;
                this.q = message;
                this.r = drawable;
                return;
            }
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public boolean b(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.a(keyEvent);
    }

    public final void b(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f2079c.findViewById(R$id.scrollView);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f2082f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f2083g != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
            int indexOfChild = viewGroup2.indexOfChild(this.A);
            viewGroup2.removeViewAt(indexOfChild);
            viewGroup2.addView(this.f2083g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    public void a(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public int a(int i2) {
        TypedValue typedValue = new TypedValue();
        this.f2077a.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView a() {
        return this.f2083g;
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.a(keyEvent);
    }

    public final ViewGroup a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void d(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f2079c.findViewById(R$id.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f2079c.findViewById(R.id.icon);
        if ((!TextUtils.isEmpty(this.f2081e)) && this.P) {
            TextView textView = (TextView) this.f2079c.findViewById(R$id.alertTitle);
            this.E = textView;
            textView.setText(this.f2081e);
            int i2 = this.B;
            if (i2 != 0) {
                this.D.setImageResource(i2);
                return;
            }
            Drawable drawable = this.C;
            if (drawable != null) {
                this.D.setImageDrawable(drawable);
                return;
            } else {
                this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
                this.D.setVisibility(8);
                return;
            }
        }
        this.f2079c.findViewById(R$id.title_template).setVisibility(8);
        this.D.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    public final void a(ViewGroup viewGroup, View view, int i2, int i3) {
        View findViewById = this.f2079c.findViewById(R$id.scrollIndicatorUp);
        View findViewById2 = this.f2079c.findViewById(R$id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            y.a(view, i2, i3);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i2 & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 != null && (i2 & 2) == 0) {
            viewGroup.removeView(findViewById2);
            findViewById2 = null;
        }
        if (findViewById == null && findViewById2 == null) {
            return;
        }
        if (this.f2082f != null) {
            this.A.setOnScrollChangeListener(new b(this, findViewById, findViewById2));
            this.A.post(new c(findViewById, findViewById2));
            return;
        }
        ListView listView = this.f2083g;
        if (listView != null) {
            listView.setOnScrollListener(new d(this, findViewById, findViewById2));
            this.f2083g.post(new e(findViewById, findViewById2));
            return;
        }
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (findViewById2 != null) {
            viewGroup.removeView(findViewById2);
        }
    }

    public static void a(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    public final void a(ViewGroup viewGroup) {
        int i2;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.o = button;
        button.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.p) && this.r == null) {
            this.o.setVisibility(8);
            i2 = 0;
        } else {
            this.o.setText(this.p);
            Drawable drawable = this.r;
            if (drawable != null) {
                int i3 = this.f2080d;
                drawable.setBounds(0, 0, i3, i3);
                this.o.setCompoundDrawables(this.r, null, null, null);
            }
            this.o.setVisibility(0);
            i2 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.s = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.t) && this.v == null) {
            this.s.setVisibility(8);
        } else {
            this.s.setText(this.t);
            Drawable drawable2 = this.v;
            if (drawable2 != null) {
                int i4 = this.f2080d;
                drawable2.setBounds(0, 0, i4, i4);
                this.s.setCompoundDrawables(this.v, null, null, null);
            }
            this.s.setVisibility(0);
            i2 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.w = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.x) && this.z == null) {
            this.w.setVisibility(8);
        } else {
            this.w.setText(this.x);
            Drawable drawable3 = this.z;
            if (drawable3 != null) {
                int i5 = this.f2080d;
                drawable3.setBounds(0, 0, i5, i5);
                this.w.setCompoundDrawables(this.z, null, null, null);
            }
            this.w.setVisibility(0);
            i2 |= 4;
        }
        if (a(this.f2077a)) {
            if (i2 == 1) {
                a(this.o);
            } else if (i2 == 2) {
                a(this.s);
            } else if (i2 == 4) {
                a(this.w);
            }
        }
        if (i2 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    public final void a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }
}
