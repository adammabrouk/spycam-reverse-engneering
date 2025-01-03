package a.h.h;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;

/* compiled from: PrecomputedTextCompat.java */
/* loaded from: classes.dex */
public class c implements Spannable {

    /* renamed from: a, reason: collision with root package name */
    public final Spannable f1082a;

    /* renamed from: b, reason: collision with root package name */
    public final a f1083b;

    /* renamed from: c, reason: collision with root package name */
    public final PrecomputedText f1084c;

    /* compiled from: PrecomputedTextCompat.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextPaint f1085a;

        /* renamed from: b, reason: collision with root package name */
        public final TextDirectionHeuristic f1086b;

        /* renamed from: c, reason: collision with root package name */
        public final int f1087c;

        /* renamed from: d, reason: collision with root package name */
        public final int f1088d;

        /* compiled from: PrecomputedTextCompat.java */
        /* renamed from: a.h.h.c$a$a, reason: collision with other inner class name */
        public static class C0024a {

            /* renamed from: a, reason: collision with root package name */
            public final TextPaint f1089a;

            /* renamed from: b, reason: collision with root package name */
            public TextDirectionHeuristic f1090b;

            /* renamed from: c, reason: collision with root package name */
            public int f1091c;

            /* renamed from: d, reason: collision with root package name */
            public int f1092d;

            public C0024a(TextPaint textPaint) {
                this.f1089a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f1091c = 1;
                    this.f1092d = 1;
                } else {
                    this.f1092d = 0;
                    this.f1091c = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f1090b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.f1090b = null;
                }
            }

            public C0024a a(int i2) {
                this.f1091c = i2;
                return this;
            }

            public C0024a b(int i2) {
                this.f1092d = i2;
                return this;
            }

            public C0024a a(TextDirectionHeuristic textDirectionHeuristic) {
                this.f1090b = textDirectionHeuristic;
                return this;
            }

            public a a() {
                return new a(this.f1089a, this.f1090b, this.f1091c, this.f1092d);
            }
        }

        @SuppressLint({"NewApi"})
        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i2, int i3) {
            if (Build.VERSION.SDK_INT >= 29) {
                new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i2).setHyphenationFrequency(i3).setTextDirection(textDirectionHeuristic).build();
            }
            this.f1085a = textPaint;
            this.f1086b = textDirectionHeuristic;
            this.f1087c = i2;
            this.f1088d = i3;
        }

        public int a() {
            return this.f1087c;
        }

        public int b() {
            return this.f1088d;
        }

        public TextDirectionHeuristic c() {
            return this.f1086b;
        }

        public TextPaint d() {
            return this.f1085a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (a(aVar)) {
                return Build.VERSION.SDK_INT < 18 || this.f1086b == aVar.c();
            }
            return false;
        }

        public int hashCode() {
            int i2 = Build.VERSION.SDK_INT;
            return i2 >= 24 ? a.h.i.c.a(Float.valueOf(this.f1085a.getTextSize()), Float.valueOf(this.f1085a.getTextScaleX()), Float.valueOf(this.f1085a.getTextSkewX()), Float.valueOf(this.f1085a.getLetterSpacing()), Integer.valueOf(this.f1085a.getFlags()), this.f1085a.getTextLocales(), this.f1085a.getTypeface(), Boolean.valueOf(this.f1085a.isElegantTextHeight()), this.f1086b, Integer.valueOf(this.f1087c), Integer.valueOf(this.f1088d)) : i2 >= 21 ? a.h.i.c.a(Float.valueOf(this.f1085a.getTextSize()), Float.valueOf(this.f1085a.getTextScaleX()), Float.valueOf(this.f1085a.getTextSkewX()), Float.valueOf(this.f1085a.getLetterSpacing()), Integer.valueOf(this.f1085a.getFlags()), this.f1085a.getTextLocale(), this.f1085a.getTypeface(), Boolean.valueOf(this.f1085a.isElegantTextHeight()), this.f1086b, Integer.valueOf(this.f1087c), Integer.valueOf(this.f1088d)) : i2 >= 18 ? a.h.i.c.a(Float.valueOf(this.f1085a.getTextSize()), Float.valueOf(this.f1085a.getTextScaleX()), Float.valueOf(this.f1085a.getTextSkewX()), Integer.valueOf(this.f1085a.getFlags()), this.f1085a.getTextLocale(), this.f1085a.getTypeface(), this.f1086b, Integer.valueOf(this.f1087c), Integer.valueOf(this.f1088d)) : i2 >= 17 ? a.h.i.c.a(Float.valueOf(this.f1085a.getTextSize()), Float.valueOf(this.f1085a.getTextScaleX()), Float.valueOf(this.f1085a.getTextSkewX()), Integer.valueOf(this.f1085a.getFlags()), this.f1085a.getTextLocale(), this.f1085a.getTypeface(), this.f1086b, Integer.valueOf(this.f1087c), Integer.valueOf(this.f1088d)) : a.h.i.c.a(Float.valueOf(this.f1085a.getTextSize()), Float.valueOf(this.f1085a.getTextScaleX()), Float.valueOf(this.f1085a.getTextSkewX()), Integer.valueOf(this.f1085a.getFlags()), this.f1085a.getTypeface(), this.f1086b, Integer.valueOf(this.f1087c), Integer.valueOf(this.f1088d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f1085a.getTextSize());
            sb.append(", textScaleX=" + this.f1085a.getTextScaleX());
            sb.append(", textSkewX=" + this.f1085a.getTextSkewX());
            if (Build.VERSION.SDK_INT >= 21) {
                sb.append(", letterSpacing=" + this.f1085a.getLetterSpacing());
                sb.append(", elegantTextHeight=" + this.f1085a.isElegantTextHeight());
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                sb.append(", textLocale=" + this.f1085a.getTextLocales());
            } else if (i2 >= 17) {
                sb.append(", textLocale=" + this.f1085a.getTextLocale());
            }
            sb.append(", typeface=" + this.f1085a.getTypeface());
            if (Build.VERSION.SDK_INT >= 26) {
                sb.append(", variationSettings=" + this.f1085a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f1086b);
            sb.append(", breakStrategy=" + this.f1087c);
            sb.append(", hyphenationFrequency=" + this.f1088d);
            sb.append("}");
            return sb.toString();
        }

        public boolean a(a aVar) {
            if ((Build.VERSION.SDK_INT >= 23 && (this.f1087c != aVar.a() || this.f1088d != aVar.b())) || this.f1085a.getTextSize() != aVar.d().getTextSize() || this.f1085a.getTextScaleX() != aVar.d().getTextScaleX() || this.f1085a.getTextSkewX() != aVar.d().getTextSkewX()) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 21 && (this.f1085a.getLetterSpacing() != aVar.d().getLetterSpacing() || !TextUtils.equals(this.f1085a.getFontFeatureSettings(), aVar.d().getFontFeatureSettings()))) || this.f1085a.getFlags() != aVar.d().getFlags()) {
                return false;
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                if (!this.f1085a.getTextLocales().equals(aVar.d().getTextLocales())) {
                    return false;
                }
            } else if (i2 >= 17 && !this.f1085a.getTextLocale().equals(aVar.d().getTextLocale())) {
                return false;
            }
            return this.f1085a.getTypeface() == null ? aVar.d().getTypeface() == null : this.f1085a.getTypeface().equals(aVar.d().getTypeface());
        }

        public a(PrecomputedText.Params params) {
            this.f1085a = params.getTextPaint();
            this.f1086b = params.getTextDirection();
            this.f1087c = params.getBreakStrategy();
            this.f1088d = params.getHyphenationFrequency();
            int i2 = Build.VERSION.SDK_INT;
        }
    }

    public a a() {
        return this.f1083b;
    }

    public PrecomputedText b() {
        Spannable spannable = this.f1082a;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i2) {
        return this.f1082a.charAt(i2);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f1082a.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f1082a.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f1082a.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? (T[]) this.f1084c.getSpans(i2, i3, cls) : (T[]) this.f1082a.getSpans(i2, i3, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f1082a.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i2, int i3, Class cls) {
        return this.f1082a.nextSpanTransition(i2, i3, cls);
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1084c.removeSpan(obj);
        } else {
            this.f1082a.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i2, int i3, int i4) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1084c.setSpan(obj, i2, i3, i4);
        } else {
            this.f1082a.setSpan(obj, i2, i3, i4);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i2, int i3) {
        return this.f1082a.subSequence(i2, i3);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f1082a.toString();
    }
}
