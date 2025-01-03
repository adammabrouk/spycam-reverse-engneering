package a.i.a;

import a.i.a.b;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* compiled from: CursorAdapter.java */
/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f1265a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1266b;

    /* renamed from: c, reason: collision with root package name */
    public Cursor f1267c;

    /* renamed from: d, reason: collision with root package name */
    public Context f1268d;

    /* renamed from: e, reason: collision with root package name */
    public int f1269e;

    /* renamed from: f, reason: collision with root package name */
    public C0034a f1270f;

    /* renamed from: g, reason: collision with root package name */
    public DataSetObserver f1271g;

    /* renamed from: h, reason: collision with root package name */
    public a.i.a.b f1272h;

    /* compiled from: CursorAdapter.java */
    /* renamed from: a.i.a.a$a, reason: collision with other inner class name */
    public class C0034a extends ContentObserver {
        public C0034a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            a.this.b();
        }
    }

    /* compiled from: CursorAdapter.java */
    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f1265a = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f1265a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    public void a(Context context, Cursor cursor, int i2) {
        if ((i2 & 1) == 1) {
            i2 |= 2;
            this.f1266b = true;
        } else {
            this.f1266b = false;
        }
        boolean z = cursor != null;
        this.f1267c = cursor;
        this.f1265a = z;
        this.f1268d = context;
        this.f1269e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i2 & 2) == 2) {
            this.f1270f = new C0034a();
            this.f1271g = new b();
        } else {
            this.f1270f = null;
            this.f1271g = null;
        }
        if (z) {
            C0034a c0034a = this.f1270f;
            if (c0034a != null) {
                cursor.registerContentObserver(c0034a);
            }
            DataSetObserver dataSetObserver = this.f1271g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public abstract View b(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract CharSequence b(Cursor cursor);

    public void b() {
        Cursor cursor;
        if (!this.f1266b || (cursor = this.f1267c) == null || cursor.isClosed()) {
            return;
        }
        this.f1265a = this.f1267c.requery();
    }

    public Cursor c(Cursor cursor) {
        Cursor cursor2 = this.f1267c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0034a c0034a = this.f1270f;
            if (c0034a != null) {
                cursor2.unregisterContentObserver(c0034a);
            }
            DataSetObserver dataSetObserver = this.f1271g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1267c = cursor;
        if (cursor != null) {
            C0034a c0034a2 = this.f1270f;
            if (c0034a2 != null) {
                cursor.registerContentObserver(c0034a2);
            }
            DataSetObserver dataSetObserver2 = this.f1271g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f1269e = cursor.getColumnIndexOrThrow("_id");
            this.f1265a = true;
            notifyDataSetChanged();
        } else {
            this.f1269e = -1;
            this.f1265a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f1265a || (cursor = this.f1267c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f1265a) {
            return null;
        }
        this.f1267c.moveToPosition(i2);
        if (view == null) {
            view = a(this.f1268d, this.f1267c, viewGroup);
        }
        a(view, this.f1268d, this.f1267c);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f1272h == null) {
            this.f1272h = new a.i.a.b(this);
        }
        return this.f1272h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        Cursor cursor;
        if (!this.f1265a || (cursor = this.f1267c) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.f1267c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        Cursor cursor;
        if (this.f1265a && (cursor = this.f1267c) != null && cursor.moveToPosition(i2)) {
            return this.f1267c.getLong(this.f1269e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (!this.f1265a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f1267c.moveToPosition(i2)) {
            if (view == null) {
                view = b(this.f1268d, this.f1267c, viewGroup);
            }
            a(view, this.f1268d, this.f1267c);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i2);
    }

    @Override // a.i.a.b.a
    public Cursor a() {
        return this.f1267c;
    }

    public void a(Cursor cursor) {
        Cursor c2 = c(cursor);
        if (c2 != null) {
            c2.close();
        }
    }
}
