package c.c.a.c.z;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: PasswordToggleEndIconDelegate.java */
/* loaded from: classes.dex */
public class h extends e {

    /* renamed from: d, reason: collision with root package name */
    public final TextWatcher f5792d;

    /* renamed from: e, reason: collision with root package name */
    public final TextInputLayout.f f5793e;

    /* renamed from: f, reason: collision with root package name */
    public final TextInputLayout.g f5794f;

    /* compiled from: PasswordToggleEndIconDelegate.java */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            h.this.f5777c.setChecked(!r1.c());
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* compiled from: PasswordToggleEndIconDelegate.java */
    public class b implements TextInputLayout.f {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            h.this.f5777c.setChecked(!r4.c());
            editText.removeTextChangedListener(h.this.f5792d);
            editText.addTextChangedListener(h.this.f5792d);
        }
    }

    /* compiled from: PasswordToggleEndIconDelegate.java */
    public class c implements TextInputLayout.g {
        public c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i2 != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            editText.removeTextChangedListener(h.this.f5792d);
        }
    }

    /* compiled from: PasswordToggleEndIconDelegate.java */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = h.this.f5775a.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            if (h.this.c()) {
                editText.setTransformationMethod(null);
            } else {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
        }
    }

    public h(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f5792d = new a();
        this.f5793e = new b();
        this.f5794f = new c();
    }

    public final boolean c() {
        EditText editText = this.f5775a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // c.c.a.c.z.e
    public void a() {
        this.f5775a.setEndIconDrawable(a.b.b.a.a.c(this.f5776b, R$drawable.design_password_eye));
        TextInputLayout textInputLayout = this.f5775a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.password_toggle_content_description));
        this.f5775a.setEndIconOnClickListener(new d());
        this.f5775a.addOnEditTextAttachedListener(this.f5793e);
        this.f5775a.addOnEndIconChangedListener(this.f5794f);
        EditText editText = this.f5775a.getEditText();
        if (a(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    public static boolean a(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }
}
