package com.shix.shixipc.activity;

import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.adapter.PlaybackTFAdapter;
import com.shix.shixipc.bean.PlayTFStatusBean;
import com.shix.shixipc.bean.YearsModel;
import com.shix.shixipc.he.DeviceUtil;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.FileUtil;
import com.shix.shixipc.utils.MyLogUtils;
import com.shix.shixipc.view.Effectstype;
import com.shix.shixipc.view.NiftyDialogBuilder;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PlayBackTFActivity extends BaseActivity implements View.OnClickListener, ExpandableListView.OnGroupClickListener, ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupCollapseListener, AbsListView.OnScrollListener, NUIMainActivity.SHIXCOMMONInterface, ExpandableListView.OnGroupExpandListener {
    public int indicatorGroupHeight;
    public LinearLayout llAnim;
    public int nPageCount;
    public Button plauBackDelete;
    public Button playBackAll;
    public Button playBackOk;
    public String selectName;
    public TextView text_resolution;
    public int year;
    public Button btnBack = null;
    public TextView tvNoVideo = null;
    public ProgressDialog progressDialog = null;
    public int TIMEOUT = RecyclerView.MAX_SCROLL_DURATION;
    public final int PARAMS = 1;
    public final int GETDAYS = 2;
    public final int GETFILES = 3;
    public boolean successFlag = false;
    public int startTime = 0;
    public int endTime = 0;
    public String strName = null;
    public String strDID = null;
    public TextView tvTitle = null;
    public ExpandableListView exListView = null;
    public PlaybackTFAdapter mExAdapter = null;
    public int the_group_expand_position = -1;
    public int count_expand = 0;
    public Map<Integer, Integer> expandGroup = new HashMap();
    public boolean isFirstOn = false;
    public int isFirstOn2 = 0;
    public List<String> selectNames = new ArrayList();
    public YearsModel yearsModel = new YearsModel();
    public boolean isEditMode = false;
    public boolean isSeleted = false;
    public List<PlayTFStatusBean> deleteList = new ArrayList();
    public int isSupportMp4 = 0;
    public int shot_snap_en = 0;
    public Handler mHandler = new Handler() { // from class: com.shix.shixipc.activity.PlayBackTFActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                MyLogUtils.d("tag", " yearsModel:" + PlayBackTFActivity.this.yearsModel.toString());
                PlayBackTFActivity.this.successFlag = true;
                if (PlayBackTFActivity.this.progressDialog.isShowing()) {
                    PlayBackTFActivity.this.progressDialog.cancel();
                }
                PlayBackTFActivity.this.mExAdapter.notifyDataSetChanged();
                return;
            }
            if (i2 == 2) {
                if (PlayBackTFActivity.this.yearsModel == null) {
                    return;
                }
                if (PlayBackTFActivity.this.yearsModel.getDays().size() != 0) {
                    new AsyncTask<Void, Void, Void>() { // from class: com.shix.shixipc.activity.PlayBackTFActivity.1.1
                        @Override // android.os.AsyncTask
                        public Void doInBackground(Void... voidArr) {
                            PlayBackTFActivity.this.countGet = 0;
                            PlayBackTFActivity.this.countPhotoGet = 0;
                            for (int i3 = 0; i3 < PlayBackTFActivity.this.yearsModel.getDays().size(); i3++) {
                                if (PlayBackTFActivity.this.shot_snap_en == 1) {
                                    NativeCallerTools.SDKAPITransferMessage(PlayBackTFActivity.this.strDID, CommonUtil.getPhotoList(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackTFActivity.this.yearsModel.getDays().get(i3)));
                                }
                                NativeCallerTools.SDKAPITransferMessage(PlayBackTFActivity.this.strDID, CommonUtil.getRecordList(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackTFActivity.this.yearsModel.getDays().get(i3)));
                                try {
                                    Thread.sleep(1000L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                                if (i3 == PlayBackTFActivity.this.yearsModel.getDays().size() - 1) {
                                    PlayBackTFActivity.this.mHandler.sendEmptyMessage(205);
                                }
                            }
                            return null;
                        }
                    }.execute(new Void[0]);
                    return;
                }
                if (PlayBackTFActivity.this.progressDialog.isShowing()) {
                    PlayBackTFActivity.this.progressDialog.cancel();
                }
                PlayBackTFActivity.this.mHandler.sendEmptyMessage(205);
                return;
            }
            if (i2 == 110) {
                String string = message.getData().getString("filename");
                if (string.length() > 8 && !string.contains("h264") && !string.contains("h265")) {
                    PlayBackTFActivity.this.mExAdapter.addGroupAndChild(string.substring(0, 4) + "-" + string.substring(4, 6) + "-" + string.substring(6, 8), string);
                }
                PlayBackTFActivity.this.mExAdapter.notifyDataSetChanged();
                return;
            }
            if (i2 == 111) {
                String string2 = message.getData().getString("filename");
                if (string2.length() > 8 && (string2.endsWith("png") || string2.endsWith("jpg"))) {
                    PlayBackTFActivity.this.mExAdapter.addGroupAndChild(string2.substring(0, 4) + "-" + string2.substring(4, 6) + "-" + string2.substring(6, 8), string2);
                }
                PlayBackTFActivity.this.mExAdapter.notifyDataSetChanged();
                return;
            }
            if (i2 != 205) {
                return;
            }
            LogUtils.e("biniy", "isFirstOn2-0= " + PlayBackTFActivity.this.isFirstOn2);
            if (PlayBackTFActivity.this.isFirstOn2 == 0) {
                LogUtils.e("biniy", "isFirstOn2-1= " + PlayBackTFActivity.this.isFirstOn2);
                NativeCallerTools.SDKAPITransferMessage(PlayBackTFActivity.this.strDID, CommonUtil.getRecordDays(SystemValue.doorBellAdmin, SystemValue.doorBellPass, PlayBackTFActivity.this.year));
            } else if (PlayBackTFActivity.this.isFirstOn2 == 1) {
                LogUtils.e("biniy", "isFirstOn2-2= " + PlayBackTFActivity.this.isFirstOn2);
                NativeCallerTools.SDKAPITransferMessage(PlayBackTFActivity.this.strDID, CommonUtil.getRecordDays(SystemValue.doorBellAdmin, SystemValue.doorBellPass, 1970));
            }
            PlayBackTFActivity.access$908(PlayBackTFActivity.this);
        }
    };
    public Runnable runnable = new Runnable() { // from class: com.shix.shixipc.activity.PlayBackTFActivity.2
        @Override // java.lang.Runnable
        public void run() {
            if (PlayBackTFActivity.this.successFlag) {
                return;
            }
            if (PlayBackTFActivity.this.progressDialog.isShowing()) {
                PlayBackTFActivity.this.progressDialog.dismiss();
            }
            if (PlayBackTFActivity.this.mExAdapter.getGroupCount() > 0) {
                PlayBackTFActivity.this.exListView.setVisibility(0);
                PlayBackTFActivity.this.tvNoVideo.setVisibility(8);
            } else {
                PlayBackTFActivity.this.exListView.setVisibility(0);
                PlayBackTFActivity.this.tvNoVideo.setVisibility(8);
            }
        }
    };
    public RelativeLayout floatHeaderView = null;
    public ImageView headerImg = null;
    public TextView headerTitle = null;
    public TextView headerSum = null;
    public int mySum = 0;
    public int countGet = 0;
    public int countPhotoGet = 0;
    public AdapterView.OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener() { // from class: com.shix.shixipc.activity.PlayBackTFActivity.8
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
            return true;
        }
    };

    public static /* synthetic */ int access$908(PlayBackTFActivity playBackTFActivity) {
        int i2 = playBackTFActivity.isFirstOn2;
        playBackTFActivity.isFirstOn2 = i2 + 1;
        return i2;
    }

    private void findView() {
        this.exListView = (ExpandableListView) findViewById(R.id.listview);
        this.btnBack = (Button) findViewById(R.id.back);
        this.tvNoVideo = (TextView) findViewById(R.id.no_video);
        this.tvTitle = (TextView) findViewById(R.id.tv_camera_setting);
        this.playBackOk = (Button) findViewById(R.id.play_back_ok);
        this.llAnim = (LinearLayout) findViewById(R.id.ll_anim);
        this.playBackAll = (Button) findViewById(R.id.play_back_all);
        this.plauBackDelete = (Button) findViewById(R.id.play_back_delete);
        this.floatHeaderView = (RelativeLayout) findViewById(R.id.floatHeaderView);
        this.headerImg = (ImageView) findViewById(R.id.header_img);
        this.headerTitle = (TextView) findViewById(R.id.header_tv_date);
        this.headerSum = (TextView) findViewById(R.id.header_tv_sum);
    }

    private void getDataFromOther() {
        Intent intent = getIntent();
        this.strName = intent.getStringExtra(ContentCommon.STR_CAMERA_NAME);
        this.strDID = intent.getStringExtra(ContentCommon.STR_CAMERA_ID);
        MyLogUtils.d("tag", "PlayBackTFActivity  strName:" + this.strName + " strDID:" + this.strDID + " strPwd:" + intent.getStringExtra(ContentCommon.STR_CAMERA_PWD) + " strUser:" + intent.getStringExtra(ContentCommon.STR_CAMERA_USER));
    }

    private int getHeight() {
        int i2 = this.indicatorGroupHeight;
        int pointToPosition = this.exListView.pointToPosition(0, i2);
        if (pointToPosition == -1 || ExpandableListView.getPackedPositionGroup(this.exListView.getExpandableListPosition(pointToPosition)) == this.the_group_expand_position) {
            return i2;
        }
        ExpandableListView expandableListView = this.exListView;
        return expandableListView.getChildAt(pointToPosition - expandableListView.getFirstVisiblePosition()).getTop();
    }

    public static Uri getUriFromFile(String str, Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor query = contentResolver.query(MediaStore.Files.getContentUri("external"), new String[]{"_id"}, "_data = ?", new String[]{str}, "date_added desc");
        query.moveToFirst();
        if (!query.isAfterLast()) {
            Uri build = MediaStore.Files.getContentUri("external").buildUpon().appendPath(Integer.toString(query.getInt(query.getColumnIndex("_id")))).build();
            query.close();
            return build;
        }
        query.close();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_data", str);
        return contentResolver.insert(MediaStore.Files.getContentUri("external"), contentValues);
    }

    private void initDate() {
        int i2;
        int i3;
        int i4;
        Calendar calendar = Calendar.getInstance();
        int i5 = calendar.get(1);
        int i6 = calendar.get(2);
        int i7 = calendar.get(5);
        if (i7 == 1) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(calendar.get(1), calendar.get(2) - 1, 1);
            i3 = gregorianCalendar.get(1);
            i4 = gregorianCalendar.get(2);
            i2 = gregorianCalendar.getActualMaximum(5);
        } else {
            i2 = i7 - 1;
            i3 = i5;
            i4 = i6;
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(i3, i4, i2);
        GregorianCalendar gregorianCalendar3 = new GregorianCalendar(i5, i6, i7);
        Date time = gregorianCalendar2.getTime();
        Date time2 = gregorianCalendar3.getTime();
        this.startTime = (int) time.getTime();
        this.endTime = (int) time2.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.format(time);
        simpleDateFormat.format(time2);
    }

    private boolean isRepeat(String str) {
        String[] list = new File(FileUtil.getRootDir().getAbsolutePath() + "/" + ContentCommon.SDCARD_PATH + "/video/" + ContentCommon.SAVEFILES + "/").list();
        if (list == null) {
            return false;
        }
        for (String str2 : list) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private void loadAnimation(float f2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.llAnim, "translationY", this.llAnim.getTranslationY(), f2);
        ofFloat.setDuration(250L);
        ofFloat.start();
    }

    private void setListener() {
        this.btnBack.setOnClickListener(this);
        this.exListView.setOnGroupCollapseListener(this);
        this.exListView.setOnGroupExpandListener(this);
        this.exListView.setOnGroupClickListener(this);
        this.exListView.setOnChildClickListener(this);
        this.exListView.setOnScrollListener(this);
        this.playBackOk.setOnClickListener(this);
        this.plauBackDelete.setOnClickListener(this);
        this.playBackAll.setOnClickListener(this);
        this.progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.shix.shixipc.activity.PlayBackTFActivity.3
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                return i2 == 4;
            }
        });
        this.floatHeaderView.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.PlayBackTFActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PlayBackTFActivity.this.floatHeaderView.setVisibility(8);
                PlayBackTFActivity.this.exListView.collapseGroup(PlayBackTFActivity.this.the_group_expand_position);
                PlayBackTFActivity.this.exListView.setSelectedGroup(PlayBackTFActivity.this.the_group_expand_position);
            }
        });
        this.mExAdapter.setClickDownload(new PlaybackTFAdapter.onClickButton() { // from class: com.shix.shixipc.activity.PlayBackTFActivity.5
            @Override // com.shix.shixipc.adapter.PlaybackTFAdapter.onClickButton
            public void clickDownload(int i2, int i3) {
                PlayBackTFActivity playBackTFActivity = PlayBackTFActivity.this;
                playBackTFActivity.selectName = playBackTFActivity.mExAdapter.getChildFilePath(i2, i3);
                Intent intent = new Intent(PlayBackTFActivity.this, (Class<?>) DownloadActivity.class);
                intent.putExtra(FragmentCameraList.STR_DID, PlayBackTFActivity.this.strDID);
                intent.putExtra("filepath", PlayBackTFActivity.this.selectName);
                PlayBackTFActivity.this.startActivity(intent);
            }

            @Override // com.shix.shixipc.adapter.PlaybackTFAdapter.onClickButton
            public void clickPlay(String str) {
                Uri uriForFile;
                String str2 = FileUtil.getRootDir() + "/" + ContentCommon.SDCARD_PATH + "/video/" + ContentCommon.SAVEFILES + "/" + str;
                String str3 = "file://" + str2;
                LogUtils.e("biniy", "cccc-bpath = " + str3);
                if (!str.endsWith(".mp4")) {
                    if (str.endsWith(".jpg")) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(str2);
                        Intent intent = new Intent(PlayBackTFActivity.this, (Class<?>) PhotoViewActivity.class);
                        intent.putStringArrayListExtra("pic_file", arrayList);
                        intent.putExtra("pic_index", 0);
                        PlayBackTFActivity.this.startActivity(intent);
                        return;
                    }
                    return;
                }
                Intent intent2 = new Intent("android.intent.action.VIEW");
                Uri.parse(str3);
                if (Build.VERSION.SDK_INT <= 23) {
                    uriForFile = Uri.parse(str3);
                } else {
                    intent2.setFlags(1);
                    uriForFile = FileProvider.getUriForFile(PlayBackTFActivity.this, "com.shix.lookcam.provider", new File(str2));
                }
                LogUtils.e("biniy", "cccc-uri.getPath = " + uriForFile.getPath());
                CommonUtil.Log(1, "SHIXURL   :" + uriForFile.toString());
                intent2.setDataAndType(uriForFile, "video/*");
                PlayBackTFActivity.this.startActivity(intent2);
            }
        });
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.SHIXCOMMONInterface
    public void CallBackSHIXJasonCommon(String str, String str2) {
        if (TextUtils.isEmpty(this.strDID) || !str.equals(this.strDID.replace("-", ""))) {
            return;
        }
        CommonUtil.Log(1, "CallBackSHIXJasonCommon:" + str2);
        int i2 = 0;
        try {
            i2 = new JSONObject(str2).getInt("cmd");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (i2 == 205) {
            try {
                this.yearsModel = YearsModel.jsonToModel(str2);
                this.mHandler.sendEmptyMessage(2);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        if (i2 == 133) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                this.isSupportMp4 = jSONObject.getInt("mp4");
                this.shot_snap_en = jSONObject.getInt("shot_snap_en");
                MyLogUtils.d("shot_snap_en", "图片列表命令" + str2);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        if (i2 == 206) {
            this.countGet++;
            try {
                JSONObject jSONObject2 = new JSONObject(str2);
                for (int i3 = jSONObject2.getInt("record_num") - 1; i3 >= 0; i3--) {
                    String string = jSONObject2.getString("record_name[" + i3 + "]");
                    if (this.strDID.equals(str)) {
                        Message obtainMessage = this.mHandler.obtainMessage();
                        obtainMessage.what = 110;
                        Bundle bundle = new Bundle();
                        bundle.putString("filename", string);
                        obtainMessage.setData(bundle);
                        this.mHandler.sendMessage(obtainMessage);
                    }
                }
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
        if (i2 == 208) {
            this.countPhotoGet++;
            MyLogUtils.d("photo列表", "图片列表命令" + str2);
            try {
                JSONObject jSONObject3 = new JSONObject(str2);
                for (int i4 = jSONObject3.getInt("photo_num") - 1; i4 >= 0; i4--) {
                    String string2 = jSONObject3.getString("photo_name[" + i4 + "]");
                    if (this.strDID.equals(str)) {
                        Message obtainMessage2 = this.mHandler.obtainMessage();
                        obtainMessage2.what = 111;
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("filename", string2);
                        obtainMessage2.setData(bundle2);
                        this.mHandler.sendMessage(obtainMessage2);
                    }
                }
            } catch (JSONException e6) {
                e6.printStackTrace();
            }
        }
        YearsModel yearsModel = this.yearsModel;
        if (yearsModel == null || this.countGet != yearsModel.getDays().size()) {
            return;
        }
        this.mHandler.sendEmptyMessage(1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j) {
        Uri uriForFile;
        this.isSeleted = this.mExAdapter.getChildStatus(i2, i3);
        if (this.isEditMode) {
            for (int i4 = 0; i4 < this.deleteList.size(); i4++) {
                if (this.deleteList.get(i4).getGroupPosition() == i2 && this.deleteList.get(i4).getChildPosition() == i3) {
                    this.isSeleted = this.deleteList.get(i4).isSelected();
                    this.mySum = i4;
                }
            }
            if (this.isSeleted) {
                this.mExAdapter.setSeleteOne(i2, i3, false);
                this.deleteList.remove(this.mySum);
            } else {
                this.mExAdapter.setSeleteOne(i2, i3, true);
                this.deleteList.add(new PlayTFStatusBean(i2, i3, true));
            }
        } else {
            this.selectName = this.mExAdapter.getChildFilePath(i2, i3);
            String str = FileUtil.getRootDir() + "/" + ContentCommon.SDCARD_PATH + "/video/" + ContentCommon.SAVEFILES + "/" + this.selectName;
            if (isRepeat(this.selectName)) {
                if (this.selectName.endsWith(".png") || this.selectName.endsWith(".jpg")) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(str);
                    Intent intent = new Intent(this, (Class<?>) PhotoViewActivity.class);
                    intent.putStringArrayListExtra("pic_file", arrayList);
                    intent.putExtra("pic_index", 0);
                    startActivity(intent);
                } else if (this.selectName.endsWith(".mp4")) {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    String str2 = "file://" + str;
                    Uri.parse(str2);
                    int i5 = Build.VERSION.SDK_INT;
                    if (i5 <= 23) {
                        uriForFile = Uri.parse(str2);
                    } else if (i5 >= 29) {
                        uriForFile = getUriFromFile(str, this);
                    } else {
                        intent2.setFlags(1);
                        uriForFile = FileProvider.getUriForFile(this, "com.shix.lookcam.provider", new File(str));
                    }
                    CommonUtil.Log(1, "SHIXURL   :" + uriForFile.toString());
                    intent2.setDataAndType(uriForFile, "video/*");
                    startActivity(intent2);
                } else {
                    Intent intent3 = new Intent(this, (Class<?>) PlayBackActivity.class);
                    intent3.putExtra(FragmentCameraList.STR_DID, this.strDID);
                    intent3.putExtra("filepath", this.selectName);
                    intent3.putExtra("mp4", this.isSupportMp4);
                    startActivity(intent3);
                }
            } else if (this.selectName.endsWith(".png") || this.selectName.endsWith(".jpg")) {
                Intent intent4 = new Intent(this, (Class<?>) DownloadActivity.class);
                intent4.putExtra(FragmentCameraList.STR_DID, this.strDID);
                intent4.putExtra("filepath", this.selectName);
                startActivity(intent4);
            } else {
                Intent intent5 = new Intent(this, (Class<?>) PlayBackActivity.class);
                intent5.putExtra(FragmentCameraList.STR_DID, this.strDID);
                intent5.putExtra("filepath", this.selectName);
                intent5.putExtra("mp4", this.isSupportMp4);
                startActivity(intent5);
            }
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131230819 */:
                finish();
                overridePendingTransition(R.anim.out_to_right, R.anim.in_from_left);
                break;
            case R.id.play_back_all /* 2131231298 */:
                int groupCount = this.mExAdapter.getGroupCount();
                for (int i2 = 0; i2 < groupCount; i2++) {
                    if (this.exListView.isGroupExpanded(i2)) {
                        this.isFirstOn = true;
                        this.mExAdapter.setSeleteAll(i2);
                        for (int i3 = 0; i3 < this.mExAdapter.getChildrenCount(i2); i3++) {
                            this.deleteList.add(new PlayTFStatusBean(i2, i3, true));
                        }
                    }
                }
                if (!this.isFirstOn) {
                    Toast.makeText(this, R.string.tip_qxzwjj, 0).show();
                    break;
                }
                break;
            case R.id.play_back_delete /* 2131231300 */:
                if (this.deleteList.size() <= 0) {
                    Toast.makeText(this, R.string.tip_qxzlx, 0).show();
                    break;
                } else {
                    final NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.getInstance(this);
                    niftyDialogBuilder.withTitle(getString(R.string.tip_reminder)).withMessage(getString(R.string.del_sucess_title)).withEffect(Effectstype.Slidetop).setButton1Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.PlayBackTFActivity.7
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            niftyDialogBuilder.dismiss();
                        }
                    }).setButton2Click(new View.OnClickListener() { // from class: com.shix.shixipc.activity.PlayBackTFActivity.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            for (int i4 = 0; i4 < PlayBackTFActivity.this.deleteList.size(); i4++) {
                                PlayBackTFActivity playBackTFActivity = PlayBackTFActivity.this;
                                playBackTFActivity.selectName = playBackTFActivity.mExAdapter.getChildFilePath(((PlayTFStatusBean) PlayBackTFActivity.this.deleteList.get(i4)).getGroupPosition(), ((PlayTFStatusBean) PlayBackTFActivity.this.deleteList.get(i4)).getChildPosition());
                                PlayBackTFActivity.this.selectNames.add(PlayBackTFActivity.this.selectName);
                                PlayBackTFActivity.this.exListView.collapseGroup(((PlayTFStatusBean) PlayBackTFActivity.this.deleteList.get(i4)).getGroupPosition());
                                PlayBackTFActivity.this.exListView.expandGroup(((PlayTFStatusBean) PlayBackTFActivity.this.deleteList.get(i4)).getGroupPosition());
                            }
                            for (int i5 = 0; i5 < PlayBackTFActivity.this.selectNames.size(); i5++) {
                                NativeCallerTools.SDKAPITransferMessage(PlayBackTFActivity.this.strDID, CommonUtil.SHIX_DelVideoFiles(SystemValue.doorBellAdmin, SystemValue.doorBellPass, (String) PlayBackTFActivity.this.selectNames.get(i5)));
                                PlayBackTFActivity.this.mExAdapter.delChildForFilePath((String) PlayBackTFActivity.this.selectNames.get(i5));
                            }
                            PlayBackTFActivity.this.mExAdapter.setSeleteAllCancel();
                            PlayBackTFActivity.this.deleteList.clear();
                            PlayBackTFActivity.this.selectNames.clear();
                            PlayBackTFActivity.this.isFirstOn = false;
                            Toast.makeText(PlayBackTFActivity.this, R.string.del_sucess, 0).show();
                            niftyDialogBuilder.dismiss();
                        }
                    }).show();
                    break;
                }
            case R.id.play_back_ok /* 2131231301 */:
                if (this.isEditMode) {
                    this.isEditMode = false;
                    this.playBackOk.setText(R.string.main_edit);
                    loadAnimation(CommonUtil.dip2px(this, 50.0f));
                    this.deleteList.clear();
                    this.isFirstOn = false;
                    this.mExAdapter.setSeleteAllCancel();
                } else {
                    this.isEditMode = true;
                    this.playBackOk.setText(R.string.str_cancel);
                    loadAnimation(CommonUtil.dip2px(this, -50.0f));
                }
                this.mExAdapter.setEditMode(this.isEditMode);
                break;
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getDataFromOther();
        setContentView(R.layout.playbacktf);
        findView();
        this.exListView.addHeaderView(new View(this));
        PlaybackTFAdapter playbackTFAdapter = new PlaybackTFAdapter(this);
        this.mExAdapter = playbackTFAdapter;
        this.exListView.setAdapter(playbackTFAdapter);
        this.exListView.setGroupIndicator(null);
        this.exListView.setOnItemLongClickListener(this.onItemLongClickListener);
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.progressDialog = progressDialog;
        progressDialog.setProgressStyle(0);
        this.progressDialog.setMessage(getString(R.string.remote_video_getparams));
        this.progressDialog.show();
        this.mHandler.postDelayed(this.runnable, this.TIMEOUT);
        setListener();
        this.tvTitle.setText(this.strName);
        initDate();
        NUIMainActivity.setSHIXCOMMONInterface(this);
        this.year = Calendar.getInstance().get(1);
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getDeviceSupport(SystemValue.doorBellAdmin, SystemValue.doorBellPass));
        NativeCallerTools.SDKAPITransferMessage(this.strDID, CommonUtil.getRecordDays(SystemValue.doorBellAdmin, SystemValue.doorBellPass, this.year - 1));
        int time = (int) (new Date().getTime() / 1000);
        this.startTime = time - 604800;
        this.endTime = time;
        CommonUtil.Log(1, "SHIX startTime:" + this.startTime + "  endTime:" + this.endTime);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.progressDialog.isShowing()) {
            this.progressDialog.dismiss();
        }
        NativeCallerTools.SDKAPIClosePlayBack(DeviceUtil.INSTANCE.getSdkId(this.strDID));
        super.onDestroy();
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i2, long j) {
        return false;
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public void onGroupCollapse(int i2) {
        this.expandGroup.remove(Integer.valueOf(i2));
        this.exListView.setSelectedGroup(i2);
        this.count_expand = this.expandGroup.size();
        MyLogUtils.d("tag", "count_expand:" + this.count_expand);
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public void onGroupExpand(int i2) {
        this.the_group_expand_position = i2;
        MyLogUtils.d("tag", "the_group_expand_position:" + this.the_group_expand_position);
        this.expandGroup.put(Integer.valueOf(i2), Integer.valueOf(i2));
        MyLogUtils.d("tag", "expandGroup.size:" + this.expandGroup.size());
        this.count_expand = this.expandGroup.size();
        MyLogUtils.d("tag", "count_expand:" + this.count_expand);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        this.mExAdapter.notifyDataSetChanged();
        super.onResume();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        MyLogUtils.d("tag", "onScroll: 1");
        if (i2 == 0) {
            this.floatHeaderView.setVisibility(8);
        }
        MyLogUtils.d("tag", "onScroll: 2");
        int pointToPosition = absListView.pointToPosition(0, 0);
        if (pointToPosition != -1) {
            MyLogUtils.d("tag", "onScroll: 3");
            long expandableListPosition = this.exListView.getExpandableListPosition(pointToPosition);
            int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListPosition);
            int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListPosition);
            if (packedPositionChild == -1) {
                MyLogUtils.d("tag", "onScroll: 4");
                ExpandableListView expandableListView = this.exListView;
                this.indicatorGroupHeight = expandableListView.getChildAt(pointToPosition - expandableListView.getFirstVisiblePosition()).getHeight();
            }
            MyLogUtils.d("tag", "onScroll: 5");
            if (this.indicatorGroupHeight == 0) {
                MyLogUtils.d("tag", "onScroll: 6");
                return;
            }
            MyLogUtils.d("tag", "onScroll: 7");
            if (this.count_expand > 0) {
                MyLogUtils.d("tag", "onScroll: 8");
                this.the_group_expand_position = packedPositionGroup;
                String[] groupTitleAndSum = this.mExAdapter.getGroupTitleAndSum(packedPositionGroup);
                this.headerTitle.setText(groupTitleAndSum[0]);
                this.headerSum.setText(groupTitleAndSum[1]);
                if (this.the_group_expand_position == packedPositionGroup && this.exListView.isGroupExpanded(packedPositionGroup)) {
                    MyLogUtils.d("tag", "onScroll: 10");
                    this.floatHeaderView.setVisibility(0);
                } else {
                    this.floatHeaderView.setVisibility(8);
                    MyLogUtils.d("tag", "onScroll: 9");
                }
            }
            MyLogUtils.d("tag", "onScroll: 11");
            if (this.count_expand == 0) {
                MyLogUtils.d("tag", "onScroll: 12");
                this.floatHeaderView.setVisibility(8);
            }
        }
        MyLogUtils.d("tag", "onScroll: 13");
        if (this.the_group_expand_position == -1) {
            MyLogUtils.d("tag", "onScroll: 14");
            return;
        }
        MyLogUtils.d("tag", "onScroll: 15");
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.floatHeaderView.getLayoutParams();
        marginLayoutParams.topMargin = -(this.indicatorGroupHeight - height);
        this.floatHeaderView.setLayoutParams(marginLayoutParams);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
    }
}
