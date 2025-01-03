package c.c.a.c.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MotionSpec.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final a.e.g<String, i> f5319a = new a.e.g<>();

    /* renamed from: b, reason: collision with root package name */
    public final a.e.g<String, PropertyValuesHolder[]> f5320b = new a.e.g<>();

    public void a(String str, i iVar) {
        this.f5319a.put(str, iVar);
    }

    public i b(String str) {
        if (d(str)) {
            return this.f5319a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public boolean c(String str) {
        return this.f5320b.get(str) != null;
    }

    public boolean d(String str) {
        return this.f5319a.get(str) != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            return this.f5319a.equals(((h) obj).f5319a);
        }
        return false;
    }

    public int hashCode() {
        return this.f5319a.hashCode();
    }

    public String toString() {
        return '\n' + h.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f5319a + "}\n";
    }

    public PropertyValuesHolder[] a(String str) {
        if (c(str)) {
            return a(this.f5320b.get(str));
        }
        throw new IllegalArgumentException();
    }

    public void a(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f5320b.put(str, propertyValuesHolderArr);
    }

    public final PropertyValuesHolder[] a(PropertyValuesHolder[] propertyValuesHolderArr) {
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i2 = 0; i2 < propertyValuesHolderArr.length; i2++) {
            propertyValuesHolderArr2[i2] = propertyValuesHolderArr[i2].clone();
        }
        return propertyValuesHolderArr2;
    }

    public <T> ObjectAnimator a(String str, T t, Property<T, ?> property) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(t, a(str));
        ofPropertyValuesHolder.setProperty(property);
        b(str).a((Animator) ofPropertyValuesHolder);
        return ofPropertyValuesHolder;
    }

    public long a() {
        int size = this.f5319a.size();
        long j = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i e2 = this.f5319a.e(i2);
            j = Math.max(j, e2.a() + e2.b());
        }
        return j;
    }

    public static h a(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return a(context, resourceId);
    }

    public static h a(Context context, int i2) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i2);
            if (loadAnimator instanceof AnimatorSet) {
                return a(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return a(arrayList);
        } catch (Exception e2) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i2), e2);
            return null;
        }
    }

    public static h a(List<Animator> list) {
        h hVar = new h();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(hVar, list.get(i2));
        }
        return hVar;
    }

    public static void a(h hVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            hVar.a(objectAnimator.getPropertyName(), objectAnimator.getValues());
            hVar.a(objectAnimator.getPropertyName(), i.a((ValueAnimator) objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }
}
