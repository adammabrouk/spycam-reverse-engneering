package a.b.f;

import android.R;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: SuggestionsAdapter.java */
/* loaded from: classes.dex */
public class a0 extends a.i.a.c implements View.OnClickListener {
    public final SearchView l;
    public final SearchableInfo m;
    public final Context n;
    public final WeakHashMap<String, Drawable.ConstantState> o;
    public final int p;
    public boolean q;
    public int r;
    public ColorStateList t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* compiled from: SuggestionsAdapter.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f425a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f426b;

        /* renamed from: c, reason: collision with root package name */
        public final ImageView f427c;

        /* renamed from: d, reason: collision with root package name */
        public final ImageView f428d;

        /* renamed from: e, reason: collision with root package name */
        public final ImageView f429e;

        public a(View view) {
            this.f425a = (TextView) view.findViewById(R.id.text1);
            this.f426b = (TextView) view.findViewById(R.id.text2);
            this.f427c = (ImageView) view.findViewById(R.id.icon1);
            this.f428d = (ImageView) view.findViewById(R.id.icon2);
            this.f429e = (ImageView) view.findViewById(R$id.edit_query);
        }
    }

    public a0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.q = false;
        this.r = 1;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = -1;
        this.y = -1;
        this.z = -1;
        this.l = searchView;
        this.m = searchableInfo;
        this.p = searchView.getSuggestionCommitIconResId();
        this.n = context;
        this.o = weakHashMap;
    }

    public void a(int i2) {
        this.r = i2;
    }

    @Override // a.i.a.c, a.i.a.a
    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        View b2 = super.b(context, cursor, viewGroup);
        b2.setTag(new a(b2));
        ((ImageView) b2.findViewById(R$id.edit_query)).setImageResource(this.p);
        return b2;
    }

    public final Drawable c() {
        Drawable b2 = b(this.m.getSearchActivity());
        return b2 != null ? b2 : this.n.getPackageManager().getDefaultActivityIcon();
    }

    public final Drawable d(Cursor cursor) {
        int i2 = this.x;
        if (i2 == -1) {
            return null;
        }
        Drawable b2 = b(cursor.getString(i2));
        return b2 != null ? b2 : c();
    }

    public final Drawable e(Cursor cursor) {
        int i2 = this.y;
        if (i2 == -1) {
            return null;
        }
        return b(cursor.getString(i2));
    }

    public final void f(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // a.i.a.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View a2 = a(this.n, a(), viewGroup);
            if (a2 != null) {
                ((a) a2.getTag()).f425a.setText(e2.toString());
            }
            return a2;
        }
    }

    @Override // a.i.a.a, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i2, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View b2 = b(this.n, a(), viewGroup);
            if (b2 != null) {
                ((a) b2.getTag()).f425a.setText(e2.toString());
            }
            return b2;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        f(a());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        f(a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.l.b((CharSequence) tag);
        }
    }

    @Override // a.i.a.b.a
    public Cursor a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.l.getVisibility() == 0 && this.l.getWindowVisibility() == 0) {
            try {
                Cursor a2 = a(this.m, charSequence2, 50);
                if (a2 != null) {
                    a2.getCount();
                    return a2;
                }
            } catch (RuntimeException e2) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e2);
            }
        }
        return null;
    }

    public final CharSequence b(CharSequence charSequence) {
        if (this.t == null) {
            TypedValue typedValue = new TypedValue();
            this.n.getTheme().resolveAttribute(R$attr.textColorSearchUrl, typedValue, true);
            this.t = this.n.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.t, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    @Override // a.i.a.a, a.i.a.b.a
    public void a(Cursor cursor) {
        if (this.q) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.u = cursor.getColumnIndex("suggest_text_1");
                this.v = cursor.getColumnIndex("suggest_text_2");
                this.w = cursor.getColumnIndex("suggest_text_2_url");
                this.x = cursor.getColumnIndex("suggest_icon_1");
                this.y = cursor.getColumnIndex("suggest_icon_2");
                this.z = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e2);
        }
    }

    @Override // a.i.a.a, a.i.a.b.a
    public CharSequence b(Cursor cursor) {
        String a2;
        String a3;
        if (cursor == null) {
            return null;
        }
        String a4 = a(cursor, "suggest_intent_query");
        if (a4 != null) {
            return a4;
        }
        if (this.m.shouldRewriteQueryFromData() && (a3 = a(cursor, "suggest_intent_data")) != null) {
            return a3;
        }
        if (!this.m.shouldRewriteQueryFromText() || (a2 = a(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return a2;
    }

    public final Drawable b(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.n.getPackageName() + "/" + parseInt;
            Drawable a2 = a(str2);
            if (a2 != null) {
                return a2;
            }
            Drawable c2 = a.h.b.a.c(this.n, parseInt);
            a(str2, c2);
            return c2;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable a3 = a(str);
            if (a3 != null) {
                return a3;
            }
            Drawable a4 = a(Uri.parse(str));
            a(str, a4);
            return a4;
        }
    }

    @Override // a.i.a.a
    public void a(View view, Context context, Cursor cursor) {
        CharSequence a2;
        a aVar = (a) view.getTag();
        int i2 = this.z;
        int i3 = i2 != -1 ? cursor.getInt(i2) : 0;
        if (aVar.f425a != null) {
            a(aVar.f425a, a(cursor, this.u));
        }
        if (aVar.f426b != null) {
            String a3 = a(cursor, this.w);
            if (a3 != null) {
                a2 = b((CharSequence) a3);
            } else {
                a2 = a(cursor, this.v);
            }
            if (TextUtils.isEmpty(a2)) {
                TextView textView = aVar.f425a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f425a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f425a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f425a.setMaxLines(1);
                }
            }
            a(aVar.f426b, a2);
        }
        ImageView imageView = aVar.f427c;
        if (imageView != null) {
            a(imageView, d(cursor), 4);
        }
        ImageView imageView2 = aVar.f428d;
        if (imageView2 != null) {
            a(imageView2, e(cursor), 8);
        }
        int i4 = this.r;
        if (i4 != 2 && (i4 != 1 || (i3 & 1) == 0)) {
            aVar.f429e.setVisibility(8);
            return;
        }
        aVar.f429e.setVisibility(0);
        aVar.f429e.setTag(aVar.f425a.getText());
        aVar.f429e.setOnClickListener(this);
    }

    public final Drawable b(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        if (this.o.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState = this.o.get(flattenToShortString);
            if (constantState == null) {
                return null;
            }
            return constantState.newDrawable(this.n.getResources());
        }
        Drawable a2 = a(componentName);
        this.o.put(flattenToShortString, a2 != null ? a2.getConstantState() : null);
        return a2;
    }

    public Drawable b(Uri uri) throws FileNotFoundException {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.n.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (parseInt != 0) {
                        return resourcesForApplication.getDrawable(parseInt);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        }
        throw new FileNotFoundException("No authority: " + uri);
    }

    public final void a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    public final void a(ImageView imageView, Drawable drawable, int i2) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i2);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public final Drawable a(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return b(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.n.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                try {
                    return Drawable.createFromStream(openInputStream, null);
                } finally {
                    try {
                        openInputStream.close();
                    } catch (IOException e2) {
                        Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e2);
                    }
                }
            }
            throw new FileNotFoundException("Failed to open " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
        return null;
    }

    public final Drawable a(String str) {
        Drawable.ConstantState constantState = this.o.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    public final void a(String str, Drawable drawable) {
        if (drawable != null) {
            this.o.put(str, drawable.getConstantState());
        }
    }

    public final Drawable a(ComponentName componentName) {
        PackageManager packageManager = this.n.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, RecyclerView.c0.FLAG_IGNORE);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.w("SuggestionsAdapter", e2.toString());
            return null;
        }
    }

    public static String a(Cursor cursor, String str) {
        return a(cursor, cursor.getColumnIndex(str));
    }

    public static String a(Cursor cursor, int i2) {
        if (i2 == -1) {
            return null;
        }
        try {
            return cursor.getString(i2);
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e2);
            return null;
        }
    }

    public Cursor a(SearchableInfo searchableInfo, String str, int i2) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i2 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i2));
        }
        return this.n.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }
}
