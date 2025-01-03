package a.b.a;

import a.b.f.d0;
import a.h.j.y;
import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: AppCompatViewInflater.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    public static final Class<?>[] f157b = {Context.class, AttributeSet.class};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f158c = {R.attr.onClick};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f159d = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: e, reason: collision with root package name */
    public static final a.e.g<String, Constructor<? extends View>> f160e = new a.e.g<>();

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f161a = new Object[2];

    /* compiled from: AppCompatViewInflater.java */
    public static class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final View f162a;

        /* renamed from: b, reason: collision with root package name */
        public final String f163b;

        /* renamed from: c, reason: collision with root package name */
        public Method f164c;

        /* renamed from: d, reason: collision with root package name */
        public Context f165d;

        public a(View view, String str) {
            this.f162a = view;
            this.f163b = str;
        }

        public final void a(Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f163b, View.class)) != null) {
                        this.f164c = method;
                        this.f165d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f162a.getId();
            if (id == -1) {
                str = "";
            } else {
                str = " with id '" + this.f162a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f163b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f162a.getClass() + str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f164c == null) {
                a(this.f162a.getContext());
            }
            try {
                this.f164c.invoke(this.f165d, view);
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (InvocationTargetException e3) {
                throw new IllegalStateException("Could not execute method for android:onClick", e3);
            }
        }
    }

    public View a(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    public final View a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2;
        View m;
        context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = d0.b(context2);
        }
        switch (str) {
            case "TextView":
                m = m(context2, attributeSet);
                a(m, str);
                break;
            case "ImageView":
                m = g(context2, attributeSet);
                a(m, str);
                break;
            case "Button":
                m = b(context2, attributeSet);
                a(m, str);
                break;
            case "EditText":
                m = e(context2, attributeSet);
                a(m, str);
                break;
            case "Spinner":
                m = l(context2, attributeSet);
                a(m, str);
                break;
            case "ImageButton":
                m = f(context2, attributeSet);
                a(m, str);
                break;
            case "CheckBox":
                m = c(context2, attributeSet);
                a(m, str);
                break;
            case "RadioButton":
                m = i(context2, attributeSet);
                a(m, str);
                break;
            case "CheckedTextView":
                m = d(context2, attributeSet);
                a(m, str);
                break;
            case "AutoCompleteTextView":
                m = a(context2, attributeSet);
                a(m, str);
                break;
            case "MultiAutoCompleteTextView":
                m = h(context2, attributeSet);
                a(m, str);
                break;
            case "RatingBar":
                m = j(context2, attributeSet);
                a(m, str);
                break;
            case "SeekBar":
                m = k(context2, attributeSet);
                a(m, str);
                break;
            case "ToggleButton":
                m = n(context2, attributeSet);
                a(m, str);
                break;
            default:
                m = a(context2, str, attributeSet);
                break;
        }
        if (m == null && context != context2) {
            m = b(context2, str, attributeSet);
        }
        if (m != null) {
            a(m, attributeSet);
        }
        return m;
    }

    public AppCompatButton b(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    public AppCompatCheckBox c(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    public AppCompatCheckedTextView d(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckedTextView(context, attributeSet);
    }

    public AppCompatEditText e(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    public AppCompatImageButton f(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    public AppCompatImageView g(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    public AppCompatMultiAutoCompleteTextView h(Context context, AttributeSet attributeSet) {
        return new AppCompatMultiAutoCompleteTextView(context, attributeSet);
    }

    public AppCompatRadioButton i(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    public AppCompatRatingBar j(Context context, AttributeSet attributeSet) {
        return new AppCompatRatingBar(context, attributeSet);
    }

    public AppCompatSeekBar k(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    public AppCompatSpinner l(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    public AppCompatTextView m(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    public AppCompatToggleButton n(Context context, AttributeSet attributeSet) {
        return new AppCompatToggleButton(context, attributeSet);
    }

    public final View b(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.f161a[0] = context;
            this.f161a[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return a(context, str, (String) null);
            }
            for (int i2 = 0; i2 < f159d.length; i2++) {
                View a2 = a(context, str, f159d[i2]);
                if (a2 != null) {
                    return a2;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr = this.f161a;
            objArr[0] = null;
            objArr[1] = null;
        }
    }

    public AppCompatAutoCompleteTextView a(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    public final void a(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    public final void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT < 15 || y.E(view)) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f158c);
                String string = obtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new a(view, string));
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    public final View a(Context context, String str, String str2) throws ClassNotFoundException, InflateException {
        String str3;
        Constructor<? extends View> constructor = f160e.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f157b);
            f160e.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f161a);
    }

    public static Context a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(R$styleable.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(R$styleable.View_theme, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof a.b.e.d) && ((a.b.e.d) context).b() == resourceId) ? context : new a.b.e.d(context, resourceId) : context;
    }
}
