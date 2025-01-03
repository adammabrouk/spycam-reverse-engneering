package c.c.a.c.l;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.google.android.material.R$string;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/* compiled from: DateFormatTextWatcher.java */
/* loaded from: classes.dex */
public abstract class c implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final String f5411a;

    /* renamed from: b, reason: collision with root package name */
    public final DateFormat f5412b;

    /* renamed from: c, reason: collision with root package name */
    public final TextInputLayout f5413c;

    /* renamed from: d, reason: collision with root package name */
    public final CalendarConstraints f5414d;

    /* renamed from: e, reason: collision with root package name */
    public final String f5415e;

    public c(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f5411a = str;
        this.f5412b = dateFormat;
        this.f5413c = textInputLayout;
        this.f5414d = calendarConstraints;
        this.f5415e = textInputLayout.getContext().getString(R$string.mtrl_picker_out_of_range);
    }

    public abstract void a();

    public abstract void a(Long l);

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f5413c.setError(null);
            a(null);
            return;
        }
        try {
            Date parse = this.f5412b.parse(charSequence.toString());
            this.f5413c.setError(null);
            long time = parse.getTime();
            if (this.f5414d.a().a(time) && this.f5414d.b(time)) {
                a(Long.valueOf(parse.getTime()));
            } else {
                this.f5413c.setError(String.format(this.f5415e, d.a(time)));
                a();
            }
        } catch (ParseException unused) {
            String string = this.f5413c.getContext().getString(R$string.mtrl_picker_invalid_format);
            String format = String.format(this.f5413c.getContext().getString(R$string.mtrl_picker_invalid_format_use), this.f5411a);
            String format2 = String.format(this.f5413c.getContext().getString(R$string.mtrl_picker_invalid_format_example), this.f5412b.format(new Date(p.d().getTimeInMillis())));
            this.f5413c.setError(string + OSSUtils.NEW_LINE + format + OSSUtils.NEW_LINE + format2);
            a();
        }
    }
}
