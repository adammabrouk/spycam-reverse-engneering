package c.c.a.b.f.e;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public enum m4 {
    DOUBLE(0, o4.SCALAR, e5.DOUBLE),
    FLOAT(1, o4.SCALAR, e5.FLOAT),
    INT64(2, o4.SCALAR, e5.LONG),
    UINT64(3, o4.SCALAR, e5.LONG),
    INT32(4, o4.SCALAR, e5.INT),
    FIXED64(5, o4.SCALAR, e5.LONG),
    FIXED32(6, o4.SCALAR, e5.INT),
    BOOL(7, o4.SCALAR, e5.BOOLEAN),
    STRING(8, o4.SCALAR, e5.STRING),
    MESSAGE(9, o4.SCALAR, e5.MESSAGE),
    BYTES(10, o4.SCALAR, e5.BYTE_STRING),
    UINT32(11, o4.SCALAR, e5.INT),
    ENUM(12, o4.SCALAR, e5.ENUM),
    SFIXED32(13, o4.SCALAR, e5.INT),
    SFIXED64(14, o4.SCALAR, e5.LONG),
    SINT32(15, o4.SCALAR, e5.INT),
    SINT64(16, o4.SCALAR, e5.LONG),
    GROUP(17, o4.SCALAR, e5.MESSAGE),
    DOUBLE_LIST(18, o4.VECTOR, e5.DOUBLE),
    FLOAT_LIST(19, o4.VECTOR, e5.FLOAT),
    INT64_LIST(20, o4.VECTOR, e5.LONG),
    UINT64_LIST(21, o4.VECTOR, e5.LONG),
    INT32_LIST(22, o4.VECTOR, e5.INT),
    FIXED64_LIST(23, o4.VECTOR, e5.LONG),
    FIXED32_LIST(24, o4.VECTOR, e5.INT),
    BOOL_LIST(25, o4.VECTOR, e5.BOOLEAN),
    STRING_LIST(26, o4.VECTOR, e5.STRING),
    MESSAGE_LIST(27, o4.VECTOR, e5.MESSAGE),
    BYTES_LIST(28, o4.VECTOR, e5.BYTE_STRING),
    UINT32_LIST(29, o4.VECTOR, e5.INT),
    ENUM_LIST(30, o4.VECTOR, e5.ENUM),
    SFIXED32_LIST(31, o4.VECTOR, e5.INT),
    SFIXED64_LIST(32, o4.VECTOR, e5.LONG),
    SINT32_LIST(33, o4.VECTOR, e5.INT),
    SINT64_LIST(34, o4.VECTOR, e5.LONG),
    DOUBLE_LIST_PACKED(35, o4.PACKED_VECTOR, e5.DOUBLE),
    FLOAT_LIST_PACKED(36, o4.PACKED_VECTOR, e5.FLOAT),
    INT64_LIST_PACKED(37, o4.PACKED_VECTOR, e5.LONG),
    UINT64_LIST_PACKED(38, o4.PACKED_VECTOR, e5.LONG),
    INT32_LIST_PACKED(39, o4.PACKED_VECTOR, e5.INT),
    FIXED64_LIST_PACKED(40, o4.PACKED_VECTOR, e5.LONG),
    FIXED32_LIST_PACKED(41, o4.PACKED_VECTOR, e5.INT),
    BOOL_LIST_PACKED(42, o4.PACKED_VECTOR, e5.BOOLEAN),
    UINT32_LIST_PACKED(43, o4.PACKED_VECTOR, e5.INT),
    ENUM_LIST_PACKED(44, o4.PACKED_VECTOR, e5.ENUM),
    SFIXED32_LIST_PACKED(45, o4.PACKED_VECTOR, e5.INT),
    SFIXED64_LIST_PACKED(46, o4.PACKED_VECTOR, e5.LONG),
    SINT32_LIST_PACKED(47, o4.PACKED_VECTOR, e5.INT),
    SINT64_LIST_PACKED(48, o4.PACKED_VECTOR, e5.LONG),
    GROUP_LIST(49, o4.VECTOR, e5.MESSAGE),
    MAP(50, o4.MAP, e5.VOID);

    public static final m4[] Y;
    public final e5 zzaz;
    public final int zzba;
    public final o4 zzbb;
    public final Class<?> zzbc;
    public final boolean zzbd;

    static {
        m4[] values = values();
        Y = new m4[values.length];
        for (m4 m4Var : values) {
            Y[m4Var.zzba] = m4Var;
        }
    }

    m4(int i2, o4 o4Var, e5 e5Var) {
        int i3;
        this.zzba = i2;
        this.zzbb = o4Var;
        this.zzaz = e5Var;
        int i4 = p4.f4354a[o4Var.ordinal()];
        if (i4 == 1) {
            this.zzbc = e5Var.zza();
        } else if (i4 != 2) {
            this.zzbc = null;
        } else {
            this.zzbc = e5Var.zza();
        }
        this.zzbd = (o4Var != o4.SCALAR || (i3 = p4.f4355b[e5Var.ordinal()]) == 1 || i3 == 2 || i3 == 3) ? false : true;
    }

    public final int zza() {
        return this.zzba;
    }
}
