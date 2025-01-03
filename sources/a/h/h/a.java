package a.h.h;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* compiled from: BidiFormatter.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final d f1063d = e.f1095c;

    /* renamed from: e, reason: collision with root package name */
    public static final String f1064e = Character.toString(8206);

    /* renamed from: f, reason: collision with root package name */
    public static final String f1065f = Character.toString(8207);

    /* renamed from: g, reason: collision with root package name */
    public static final a f1066g = new a(false, 2, f1063d);

    /* renamed from: h, reason: collision with root package name */
    public static final a f1067h = new a(true, 2, f1063d);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1068a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1069b;

    /* renamed from: c, reason: collision with root package name */
    public final d f1070c;

    /* compiled from: BidiFormatter.java */
    public static class b {

        /* renamed from: f, reason: collision with root package name */
        public static final byte[] f1074f = new byte[1792];

        /* renamed from: a, reason: collision with root package name */
        public final CharSequence f1075a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f1076b;

        /* renamed from: c, reason: collision with root package name */
        public final int f1077c;

        /* renamed from: d, reason: collision with root package name */
        public int f1078d;

        /* renamed from: e, reason: collision with root package name */
        public char f1079e;

        static {
            for (int i2 = 0; i2 < 1792; i2++) {
                f1074f[i2] = Character.getDirectionality(i2);
            }
        }

        public b(CharSequence charSequence, boolean z) {
            this.f1075a = charSequence;
            this.f1076b = z;
            this.f1077c = charSequence.length();
        }

        public static byte a(char c2) {
            return c2 < 1792 ? f1074f[c2] : Character.getDirectionality(c2);
        }

        public byte b() {
            char charAt = this.f1075a.charAt(this.f1078d);
            this.f1079e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f1075a, this.f1078d);
                this.f1078d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f1078d++;
            byte a2 = a(this.f1079e);
            if (!this.f1076b) {
                return a2;
            }
            char c2 = this.f1079e;
            return c2 == '<' ? h() : c2 == '&' ? f() : a2;
        }

        public int c() {
            this.f1078d = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (this.f1078d < this.f1077c && i2 == 0) {
                byte b2 = b();
                if (b2 != 0) {
                    if (b2 == 1 || b2 == 2) {
                        if (i4 == 0) {
                            return 1;
                        }
                    } else if (b2 != 9) {
                        switch (b2) {
                            case 14:
                            case 15:
                                i4++;
                                i3 = -1;
                                continue;
                            case 16:
                            case 17:
                                i4++;
                                i3 = 1;
                                continue;
                            case 18:
                                i4--;
                                i3 = 0;
                                continue;
                        }
                    }
                } else if (i4 == 0) {
                    return -1;
                }
                i2 = i4;
            }
            if (i2 == 0) {
                return 0;
            }
            if (i3 != 0) {
                return i3;
            }
            while (this.f1078d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i2 == i4) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i2 == i4) {
                            return 1;
                        }
                        break;
                    case 18:
                        i4++;
                        continue;
                }
                i4--;
            }
            return 0;
        }

        public int d() {
            this.f1078d = this.f1077c;
            int i2 = 0;
            int i3 = 0;
            while (this.f1078d > 0) {
                byte a2 = a();
                if (a2 != 0) {
                    if (a2 == 1 || a2 == 2) {
                        if (i2 == 0) {
                            return 1;
                        }
                        if (i3 == 0) {
                            i3 = i2;
                        }
                    } else if (a2 != 9) {
                        switch (a2) {
                            case 14:
                            case 15:
                                if (i3 == i2) {
                                    return -1;
                                }
                                i2--;
                                break;
                            case 16:
                            case 17:
                                if (i3 == i2) {
                                    return 1;
                                }
                                i2--;
                                break;
                            case 18:
                                i2++;
                                break;
                            default:
                                if (i3 != 0) {
                                    break;
                                } else {
                                    i3 = i2;
                                    break;
                                }
                        }
                    } else {
                        continue;
                    }
                } else {
                    if (i2 == 0) {
                        return -1;
                    }
                    if (i3 == 0) {
                        i3 = i2;
                    }
                }
            }
            return 0;
        }

        public final byte e() {
            char charAt;
            int i2 = this.f1078d;
            do {
                int i3 = this.f1078d;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f1075a;
                int i4 = i3 - 1;
                this.f1078d = i4;
                charAt = charSequence.charAt(i4);
                this.f1079e = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.f1078d = i2;
            this.f1079e = ';';
            return (byte) 13;
        }

        public final byte f() {
            char charAt;
            do {
                int i2 = this.f1078d;
                if (i2 >= this.f1077c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f1075a;
                this.f1078d = i2 + 1;
                charAt = charSequence.charAt(i2);
                this.f1079e = charAt;
            } while (charAt != ';');
            return (byte) 12;
        }

        public final byte g() {
            char charAt;
            int i2 = this.f1078d;
            while (true) {
                int i3 = this.f1078d;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f1075a;
                int i4 = i3 - 1;
                this.f1078d = i4;
                char charAt2 = charSequence.charAt(i4);
                this.f1079e = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    char c2 = this.f1079e;
                    do {
                        int i5 = this.f1078d;
                        if (i5 > 0) {
                            CharSequence charSequence2 = this.f1075a;
                            int i6 = i5 - 1;
                            this.f1078d = i6;
                            charAt = charSequence2.charAt(i6);
                            this.f1079e = charAt;
                        }
                    } while (charAt != c2);
                }
            }
            this.f1078d = i2;
            this.f1079e = '>';
            return (byte) 13;
        }

        public final byte h() {
            char charAt;
            int i2 = this.f1078d;
            while (true) {
                int i3 = this.f1078d;
                if (i3 >= this.f1077c) {
                    this.f1078d = i2;
                    this.f1079e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.f1075a;
                this.f1078d = i3 + 1;
                char charAt2 = charSequence.charAt(i3);
                this.f1079e = charAt2;
                if (charAt2 == '>') {
                    return (byte) 12;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    char c2 = this.f1079e;
                    do {
                        int i4 = this.f1078d;
                        if (i4 < this.f1077c) {
                            CharSequence charSequence2 = this.f1075a;
                            this.f1078d = i4 + 1;
                            charAt = charSequence2.charAt(i4);
                            this.f1079e = charAt;
                        }
                    } while (charAt != c2);
                }
            }
        }

        public byte a() {
            char charAt = this.f1075a.charAt(this.f1078d - 1);
            this.f1079e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f1075a, this.f1078d);
                this.f1078d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f1078d--;
            byte a2 = a(this.f1079e);
            if (!this.f1076b) {
                return a2;
            }
            char c2 = this.f1079e;
            return c2 == '>' ? g() : c2 == ';' ? e() : a2;
        }
    }

    public a(boolean z, int i2, d dVar) {
        this.f1068a = z;
        this.f1069b = i2;
        this.f1070c = dVar;
    }

    public static a b() {
        return new C0023a().a();
    }

    public static int c(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    public boolean a() {
        return (this.f1069b & 2) != 0;
    }

    public final String a(CharSequence charSequence, d dVar) {
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        return (this.f1068a || !(a2 || c(charSequence) == 1)) ? this.f1068a ? (!a2 || c(charSequence) == -1) ? f1065f : "" : "" : f1064e;
    }

    public final String b(CharSequence charSequence, d dVar) {
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        return (this.f1068a || !(a2 || b(charSequence) == 1)) ? this.f1068a ? (!a2 || b(charSequence) == -1) ? f1065f : "" : "" : f1064e;
    }

    /* compiled from: BidiFormatter.java */
    /* renamed from: a.h.h.a$a, reason: collision with other inner class name */
    public static final class C0023a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1071a;

        /* renamed from: b, reason: collision with root package name */
        public int f1072b;

        /* renamed from: c, reason: collision with root package name */
        public d f1073c;

        public C0023a() {
            a(a.a(Locale.getDefault()));
        }

        public static a b(boolean z) {
            return z ? a.f1067h : a.f1066g;
        }

        public final void a(boolean z) {
            this.f1071a = z;
            this.f1073c = a.f1063d;
            this.f1072b = 2;
        }

        public a a() {
            if (this.f1072b == 2 && this.f1073c == a.f1063d) {
                return b(this.f1071a);
            }
            return new a(this.f1071a, this.f1072b, this.f1073c);
        }
    }

    public static int b(CharSequence charSequence) {
        return new b(charSequence, false).c();
    }

    public String a(String str, d dVar, boolean z) {
        if (str == null) {
            return null;
        }
        return a((CharSequence) str, dVar, z).toString();
    }

    public CharSequence a(CharSequence charSequence, d dVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (a() && z) {
            spannableStringBuilder.append((CharSequence) b(charSequence, a2 ? e.f1094b : e.f1093a));
        }
        if (a2 != this.f1068a) {
            spannableStringBuilder.append(a2 ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) a(charSequence, a2 ? e.f1094b : e.f1093a));
        }
        return spannableStringBuilder;
    }

    public String a(String str) {
        return a(str, this.f1070c, true);
    }

    public CharSequence a(CharSequence charSequence) {
        return a(charSequence, this.f1070c, true);
    }

    public static boolean a(Locale locale) {
        return f.b(locale) == 1;
    }
}
