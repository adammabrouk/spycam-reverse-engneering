package com.shix.shixipc.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shix.lookcam.R;

/* loaded from: classes.dex */
public class NiftyDialogBuilder extends Dialog implements DialogInterface {
    public static volatile NiftyDialogBuilder instance = null;
    public static int mOrientation = 1;
    public boolean isCancelable;
    public View mDialogView;
    public int mDuration;
    public TextView mMessage;
    public RelativeLayout mRelativeLayoutView;
    public TextView mTitle;
    public ImageView tv3;
    public TextView tv_1;
    public TextView tv_2;
    public Effectstype type;

    public NiftyDialogBuilder(Context context) {
        super(context);
        this.type = null;
        this.mDuration = -1;
        this.isCancelable = true;
        init(context);
    }

    public static NiftyDialogBuilder getInstance(Context context) {
        int i2 = context.getResources().getConfiguration().orientation;
        if (mOrientation != i2) {
            mOrientation = i2;
            instance = null;
        }
        if (instance == null) {
            synchronized (NiftyDialogBuilder.class) {
                if (instance == null) {
                    instance = new NiftyDialogBuilder(context, R.style.dialog_untran);
                }
            }
        }
        return instance;
    }

    private void init(Context context) {
        View inflate = View.inflate(context, R.layout.dialog_layout, null);
        this.mDialogView = inflate;
        this.mRelativeLayoutView = (RelativeLayout) inflate.findViewById(R.id.main);
        this.mTitle = (TextView) this.mDialogView.findViewById(R.id.dialog_title);
        this.mMessage = (TextView) this.mDialogView.findViewById(R.id.tv_content);
        this.tv3 = (ImageView) this.mDialogView.findViewById(R.id.tv_3);
        this.tv_1 = (TextView) this.mDialogView.findViewById(R.id.tv_1);
        this.tv_2 = (TextView) this.mDialogView.findViewById(R.id.tv_2);
        setContentView(this.mDialogView);
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.shix.shixipc.view.NiftyDialogBuilder.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (NiftyDialogBuilder.this.type == null) {
                    NiftyDialogBuilder.this.type = Effectstype.Slidetop;
                }
                NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.this;
                niftyDialogBuilder.start(niftyDialogBuilder.type);
            }
        });
        this.mRelativeLayoutView.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.view.NiftyDialogBuilder.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NiftyDialogBuilder.this.isCancelable) {
                    NiftyDialogBuilder.this.dismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void start(Effectstype effectstype) {
        BaseEffects animator = effectstype.getAnimator();
        if (this.mDuration != -1) {
            animator.setDuration(Math.abs(r0));
        }
        animator.start(this.mRelativeLayoutView);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (instance != null) {
            instance = null;
        }
    }

    public NiftyDialogBuilder isCancelable(boolean z) {
        this.isCancelable = z;
        setCancelable(z);
        return this;
    }

    public NiftyDialogBuilder isCancelableOnTouchOutside(boolean z) {
        this.isCancelable = z;
        setCanceledOnTouchOutside(z);
        return this;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.height = -2;
        attributes.width = -2;
        getWindow().setAttributes(attributes);
        setCancelable(false);
    }

    public NiftyDialogBuilder setButton1Click(View.OnClickListener onClickListener) {
        this.tv_1.setOnClickListener(onClickListener);
        return this;
    }

    public NiftyDialogBuilder setButton2Click(View.OnClickListener onClickListener) {
        this.tv_2.setOnClickListener(onClickListener);
        return this;
    }

    public void setTv1(String str) {
        TextView textView = this.tv_1;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTv2(String str) {
        TextView textView = this.tv_2;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    public NiftyDialogBuilder withButton1Text(CharSequence charSequence) {
        this.tv_1.setText(charSequence);
        return this;
    }

    public NiftyDialogBuilder withButton2Text(CharSequence charSequence) {
        this.tv_2.setText(charSequence);
        return this;
    }

    public NiftyDialogBuilder withDuration(int i2) {
        this.mDuration = i2;
        return this;
    }

    public NiftyDialogBuilder withEffect(Effectstype effectstype) {
        this.type = effectstype;
        return this;
    }

    public NiftyDialogBuilder withMessage(int i2) {
        this.mMessage.setText(i2);
        return this;
    }

    public NiftyDialogBuilder withMessageLayoutWrap() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.mMessage.setLayoutParams(layoutParams);
        return this;
    }

    public NiftyDialogBuilder withOneBtn() {
        this.tv_1.setVisibility(8);
        this.tv3.setVisibility(8);
        return this;
    }

    public NiftyDialogBuilder withTitle(CharSequence charSequence) {
        this.mTitle.setText(charSequence);
        return this;
    }

    public NiftyDialogBuilder withTitleColor(String str) {
        this.mTitle.setTextColor(Color.parseColor(str));
        return this;
    }

    public NiftyDialogBuilder withMessage(CharSequence charSequence) {
        this.mMessage.setText(charSequence);
        return this;
    }

    public NiftyDialogBuilder(Context context, int i2) {
        super(context, i2);
        this.type = null;
        this.mDuration = -1;
        this.isCancelable = true;
        init(context);
    }
}
