package com.shix.shixipc.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.TimePicker;
import com.shix.lookcam.R;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utils.TimeUtil;

/* loaded from: classes.dex */
public class BottomDialog extends Dialog {
    public OnClickCallBackListener callBackListener;
    public TextView cancel;
    public Context context;
    public TimePicker endTime;
    public int endTimes;
    public TimePicker startTime;
    public int startTimes;
    public TextView sure;

    public interface OnClickCallBackListener {
        void OnClickCancel(View view);

        void OnClickSure(View view);
    }

    public BottomDialog(Context context) {
        super(context, R.style.dialog_full);
        this.context = context;
    }

    private void initView() {
        this.cancel = (TextView) findViewById(R.id.dialog_bottom_cancel);
        this.sure = (TextView) findViewById(R.id.dialog_bottom_sure);
        this.startTime = (TimePicker) findViewById(R.id.dialog_bottom_tp1);
        this.endTime = (TimePicker) findViewById(R.id.dialog_bottom_tp2);
        this.startTime.setIs24HourView(true);
        this.endTime.setIs24HourView(true);
        this.cancel.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.view.BottomDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BottomDialog.this.callBackListener != null) {
                    BottomDialog.this.callBackListener.OnClickCancel(view);
                }
            }
        });
        this.sure.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.view.BottomDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BottomDialog.this.callBackListener != null) {
                    BottomDialog.this.callBackListener.OnClickSure(view);
                }
            }
        });
        this.startTime.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() { // from class: com.shix.shixipc.view.BottomDialog.3
            @Override // android.widget.TimePicker.OnTimeChangedListener
            public void onTimeChanged(TimePicker timePicker, int i2, int i3) {
                BottomDialog.this.startTimes = TimeUtil.getSeconds(i2, i3);
            }
        });
        this.endTime.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() { // from class: com.shix.shixipc.view.BottomDialog.4
            @Override // android.widget.TimePicker.OnTimeChangedListener
            public void onTimeChanged(TimePicker timePicker, int i2, int i3) {
                BottomDialog.this.endTimes = TimeUtil.getSeconds(i2, i3);
            }
        });
    }

    public int getEndTimes() {
        return this.endTimes;
    }

    public int getStartTimes() {
        return this.startTimes;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getLayoutInflater().inflate(R.layout.dialog_bottom_time, (ViewGroup) null), new ViewGroup.LayoutParams(-1, -2));
        Window window = getWindow();
        window.setGravity(80);
        window.setWindowAnimations(R.style.DialogBottomAnimation);
        getWindow().setLayout(-1, -1);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        initView();
    }

    public void setCallBackListener(OnClickCallBackListener onClickCallBackListener) {
        this.callBackListener = onClickCallBackListener;
    }

    public void setEndTime(long j) {
        int i2 = (int) (j / 3600);
        int i3 = (int) ((j - ((i2 * 60) * 60)) / 60);
        LogUtils.d("biniy", "hour= " + i2 + "---minute= " + i3 + "---seconds= " + j);
        if (Build.VERSION.SDK_INT >= 23) {
            if (i2 == 24 && i3 == 0) {
                this.endTime.setHour(23);
                this.endTime.setMinute(59);
            } else {
                this.endTime.setHour(i2);
                this.endTime.setMinute(i3);
            }
        }
    }

    public void setEndTimes(int i2) {
        this.endTimes = i2;
    }

    public void setStartTime(long j) {
        int i2 = (int) (j / 3600);
        int i3 = (int) ((j - ((i2 * 60) * 60)) / 60);
        if (Build.VERSION.SDK_INT >= 23) {
            if (i2 == 24 && i3 == 0) {
                this.startTime.setHour(23);
                this.startTime.setMinute(59);
            } else {
                this.startTime.setHour(i2);
                this.startTime.setMinute(i3);
            }
        }
    }

    public void setStartTimes(int i2) {
        this.startTimes = i2;
    }
}
