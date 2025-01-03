package com.shix.shixipc.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.shix.lookcam.R;

/* loaded from: classes.dex */
public class MyDialog extends Dialog {
    public String agree;
    public TextView agreeTv;
    public TextView disagreeTv;
    public String message;
    public TextView messageTv;
    public OnClickBottomListener onClickBottomListener;
    public TextView readMeTv;
    public String readme;
    public String title;
    public TextView titleTv;

    public interface OnClickBottomListener {
        void onAgreeClick();

        void onDisagressClick();

        void onReadMeClick();
    }

    public MyDialog(Context context) {
        super(context);
    }

    private void initEvent() {
        this.readMeTv.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.view.MyDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnClickBottomListener onClickBottomListener = MyDialog.this.onClickBottomListener;
                if (onClickBottomListener != null) {
                    onClickBottomListener.onReadMeClick();
                }
            }
        });
        this.agreeTv.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.view.MyDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnClickBottomListener onClickBottomListener = MyDialog.this.onClickBottomListener;
                if (onClickBottomListener != null) {
                    onClickBottomListener.onAgreeClick();
                }
            }
        });
        this.disagreeTv.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.view.MyDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnClickBottomListener onClickBottomListener = MyDialog.this.onClickBottomListener;
                if (onClickBottomListener != null) {
                    onClickBottomListener.onDisagressClick();
                }
            }
        });
    }

    private void initView() {
        this.titleTv = (TextView) findViewById(R.id.textview3);
        this.messageTv = (TextView) findViewById(R.id.textview4);
        this.readMeTv = (TextView) findViewById(R.id.textview5);
        this.agreeTv = (TextView) findViewById(R.id.textview6);
        this.disagreeTv = (TextView) findViewById(R.id.textview7);
        this.messageTv.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    private void refreshView() {
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_readme);
        setCanceledOnTouchOutside(false);
        initView();
        refreshView();
        initEvent();
    }

    public MyDialog setOnClickBottomListener(OnClickBottomListener onClickBottomListener) {
        this.onClickBottomListener = onClickBottomListener;
        return this;
    }

    public MyDialog(Context context, int i2) {
        super(context, i2);
    }

    public MyDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }
}
