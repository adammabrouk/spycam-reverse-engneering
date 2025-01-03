package a.b.a;

/* compiled from: TwilightCalculator.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: d, reason: collision with root package name */
    public static k f189d;

    /* renamed from: a, reason: collision with root package name */
    public long f190a;

    /* renamed from: b, reason: collision with root package name */
    public long f191b;

    /* renamed from: c, reason: collision with root package name */
    public int f192c;

    public static k a() {
        if (f189d == null) {
            f189d = new k();
        }
        return f189d;
    }

    public void a(long j, double d2, double d3) {
        float f2 = (j - 946728000000L) / 8.64E7f;
        double d4 = (0.01720197f * f2) + 6.24006f;
        double sin = Math.sin(d4) * 0.03341960161924362d;
        Double.isNaN(d4);
        double sin2 = sin + d4 + (Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        Double.isNaN(f2 - 9.0E-4f);
        double round = Math.round(r11 - r9) + 9.0E-4f;
        Double.isNaN(round);
        double sin3 = round + ((-d3) / 360.0d) + (Math.sin(d4) * 0.0053d) + (Math.sin(2.0d * sin2) * (-0.0069d));
        double asin = Math.asin(Math.sin(sin2) * Math.sin(0.4092797040939331d));
        double d5 = 0.01745329238474369d * d2;
        double sin4 = (Math.sin(-0.10471975803375244d) - (Math.sin(d5) * Math.sin(asin))) / (Math.cos(d5) * Math.cos(asin));
        if (sin4 >= 1.0d) {
            this.f192c = 1;
            this.f190a = -1L;
            this.f191b = -1L;
            return;
        }
        if (sin4 <= -1.0d) {
            this.f192c = 0;
            this.f190a = -1L;
            this.f191b = -1L;
            return;
        }
        double acos = (float) (Math.acos(sin4) / 6.283185307179586d);
        Double.isNaN(acos);
        this.f190a = Math.round((sin3 + acos) * 8.64E7d) + 946728000000L;
        Double.isNaN(acos);
        long round2 = Math.round((sin3 - acos) * 8.64E7d) + 946728000000L;
        this.f191b = round2;
        if (round2 < j && this.f190a > j) {
            this.f192c = 0;
        } else {
            this.f192c = 1;
        }
    }
}
