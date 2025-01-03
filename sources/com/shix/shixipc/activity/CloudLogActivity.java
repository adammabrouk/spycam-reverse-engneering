package com.shix.shixipc.activity;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import c.e.b.a;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.alibaba.sdk.android.oss.model.DeleteMultipleObjectRequest;
import com.alibaba.sdk.android.oss.model.DeleteMultipleObjectResult;
import com.alibaba.sdk.android.oss.model.GetObjectRequest;
import com.alibaba.sdk.android.oss.model.GetObjectResult;
import com.alibaba.sdk.android.oss.model.ListObjectsRequest;
import com.alibaba.sdk.android.oss.model.ListObjectsResult;
import com.lxj.xpopup.impl.LoadingPopupView;
import com.shix.lookcam.R;
import com.shix.shixipc.BaseActivity;
import com.shix.shixipc.activity.CloudLogActivity;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.adapter.CloudLogAdapter;
import com.shix.shixipc.bean.CloudBean;
import com.shix.shixipc.bean.DeviceOffTimeModel;
import com.shix.shixipc.he.DeviceUtil;
import com.shix.shixipc.he.NativeCallerTools;
import com.shix.shixipc.he.NetWorkUtil;
import com.shix.shixipc.system.ContentCommon;
import com.shix.shixipc.system.SystemValue;
import com.shix.shixipc.utilcode.LogUtils;
import com.shix.shixipc.utilcode.ToastUtils;
import com.shix.shixipc.utils.ActivityTaskManager;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.FileUtil;
import com.shix.shixipc.utils.MyLogUtils;
import com.shix.shixipc.utils.TimeUtil;
import com.shix.shixipc.view.NiftyDialogBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONException;

/* loaded from: classes.dex */
public class CloudLogActivity extends BaseActivity implements View.OnClickListener, NUIMainActivity.SHIXCOMMONInterface {
    public String CloudPath111;
    public String FileName111;
    public CloudLogAdapter adapter;
    public Bitmap bmp;
    public Button btnBack;
    public Button btnDelete;
    public Button btnSeleteAll;
    public Button buttonPlay;
    public String camName;
    public TextView deleteEdit;
    public String did;
    public ImageView imageView;
    public LinearLayout linearLayout_buttom;
    public GridView listView;
    public LinearLayout llBottom;
    public LoadingPopupView mLoadingPopupView;
    public LinearLayout no_data_layout;
    public OSS oss;
    public String pathTest;
    public PopupWindow popupWindow_re;
    public View popv_re;
    public String strDateCreate;
    public String strDateCreate2;
    public String strDateNow;
    public String strDateNow2;
    public String strTitle;
    public String strdata;
    public TextView textView;
    public TextView textView_name;
    public TextView tvNoLog;
    public TextView tv_camera_setting;
    public String Tag = "CloudLogActivity";
    public final int BEND = 1;
    public final int BEND1 = 2;
    public final int BEND2 = 3;
    public int play_tag_log = 0;
    public DeviceOffTimeModel mModel = new DeviceOffTimeModel();
    public Handler mHandler = new Handler() { // from class: com.shix.shixipc.activity.CloudLogActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                String string = message.getData().getString(FileProvider.ATTR_PATH);
                String substring = string.substring(string.lastIndexOf("/") + 1);
                if (substring.length() < 21) {
                    return;
                }
                String str = substring.substring(0, 10) + "  " + substring.substring(11, 19).replace("-", ":");
                String substring2 = substring.substring(substring.lastIndexOf("-") + 1, substring.lastIndexOf("-") + 2);
                CloudLogActivity.this.strDateNow = substring.substring(11, 19).replace("-", "");
                CloudLogActivity.this.strDateNow2 = substring.substring(0, 10).replace("-", "");
                CloudBean cloudBean = new CloudBean();
                cloudBean.setCloudPath(string);
                cloudBean.setStrDid(CloudLogActivity.this.did);
                cloudBean.setFileName(substring);
                cloudBean.setCreateTime(str);
                cloudBean.setType(Integer.parseInt(substring2));
                if (CloudLogActivity.this.adapter != null) {
                    CloudLogActivity.this.adapter.addAlarmLog(cloudBean);
                    return;
                }
                return;
            }
            if (i2 == 2) {
                if (CloudLogActivity.this.adapter.getCount() > 0) {
                    CloudLogActivity.this.no_data_layout.setVisibility(8);
                    CloudLogActivity.this.listView.setVisibility(0);
                    CloudLogActivity.this.tvNoLog.setVisibility(8);
                } else {
                    CloudLogActivity.this.no_data_layout.setVisibility(0);
                    CloudLogActivity.this.listView.setVisibility(8);
                    CloudLogActivity.this.tvNoLog.setVisibility(0);
                }
                if (CloudLogActivity.this.adapter != null) {
                    CloudLogActivity.this.adapter.notifyDataSetChanged();
                    return;
                }
                return;
            }
            if (i2 == 3) {
                CloudLogActivity.this.strDateCreate2 = TimeUtil.getStringDateShort("yyyyMMdd", r12.mModel.getTimedOffTime());
                CloudLogActivity.this.strDateCreate = TimeUtil.getStringDateShort("HHmmss", r12.mModel.getTimedOffTime());
                return;
            }
            if (i2 == 997) {
                CloudLogActivity.this.adapter.notifyDataSetChanged();
                return;
            }
            if (i2 != 998) {
                return;
            }
            if (CloudLogActivity.this.mLoadingPopupView != null && CloudLogActivity.this.mLoadingPopupView.s()) {
                CloudLogActivity.this.mLoadingPopupView.h();
            }
            if (new File(CloudLogActivity.this.pathTest).exists()) {
                CloudLogActivity cloudLogActivity = CloudLogActivity.this;
                cloudLogActivity.startActivityForResultPic(cloudLogActivity.pathTest);
            }
        }
    };
    public FileOutputStream testOS = null;
    public String dateTime = "";
    public int toCloudPhotoViewAtyPosition = -1;
    public Handler BitMapHandler = new Handler() { // from class: com.shix.shixipc.activity.CloudLogActivity.12
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 110) {
                LogUtils.e("biniy", "一脸懵逼- 1");
                CloudLogActivity.this.imageView.setImageBitmap(CloudLogActivity.this.bmp);
                CloudLogActivity.this.takePicture();
            } else {
                LogUtils.e("biniy", "一脸懵逼- 2");
                CloudLogActivity.this.textView_name.setText("/mnt/sdcard/HDWiFiCam/picVisitor/");
                if (CloudLogActivity.this.adapter != null) {
                    CloudLogActivity.this.adapter.notifyDataSetChanged();
                }
                Log.d(ContentCommon.SERVER_STRING, "savePicToSDcard4");
            }
        }
    };
    public boolean isFirstRun = true;

    public class MyAsyncTask extends AsyncTask<String, Integer, String> {
        public long downLen = 0;
        public long allLen = 1;

        public MyAsyncTask() {
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            this.downLen = 0L;
            this.allLen = 1L;
            CloudLogActivity.this.buttonPlay.setVisibility(8);
        }

        @Override // android.os.AsyncTask
        public String doInBackground(String... strArr) {
            String str = strArr[0];
            File file = new File(FileUtil.getRootDir(), "HDWiFiCam/cloud");
            if (!file.exists()) {
                file.mkdirs();
            }
            String substring = str.substring(str.lastIndexOf("/") + 1);
            if (substring.length() < 21) {
                return null;
            }
            File file2 = new File(file, CloudLogActivity.this.did + substring);
            String absolutePath = file2.getAbsolutePath();
            if (file2.exists() && file2.length() > 1000) {
                return absolutePath;
            }
            try {
                CloudLogActivity.this.testOS = new FileOutputStream(file2);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
            try {
                try {
                    GetObjectResult object2 = CloudLogActivity.this.oss.getObject(new GetObjectRequest(ContentCommon.CLOUDBUCKET, str));
                    this.allLen = object2.getContentLength();
                    Log.d(HttpHeaders.CONTENT_LENGTH, "allLen:" + this.allLen);
                    InputStream objectContent = object2.getObjectContent();
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = objectContent.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        Log.d("asyncGetObjectSample", "read length: " + read);
                        CloudLogActivity.this.testOS.write(bArr, 0, read);
                        long j = this.downLen + ((long) read);
                        this.downLen = j;
                        float f2 = j / this.allLen;
                        Log.d(ContentCommon.SERVER_STRING, "process:" + f2 + " downLen:" + this.downLen + "  allLen:" + this.allLen);
                        publishProgress(Integer.valueOf((int) (f2 * 100.0f)));
                    }
                    Log.d("asyncGetObjectSample", "download success.");
                    Log.d("ContentType", object2.getMetadata().getContentType());
                    try {
                        CloudLogActivity.this.testOS.flush();
                        CloudLogActivity.this.testOS.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                } catch (ClientException e4) {
                    e4.printStackTrace();
                    return null;
                } catch (ServiceException e5) {
                    Log.e("RequestId", e5.getRequestId());
                    Log.e("ErrorCode", e5.getErrorCode());
                    Log.e("HostId", e5.getHostId());
                    Log.e("RawMessage", e5.getRawMessage());
                    return null;
                }
            } catch (IOException e6) {
                e6.printStackTrace();
            }
            return absolutePath;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((MyAsyncTask) str);
            Log.d(ContentCommon.SERVER_STRING, "onPostExecute path:" + str);
            if (str == null || str.length() <= 5) {
                ToastUtils.showLong("No video");
            } else {
                CloudLogActivity.this.buttonPlay.setVisibility(8);
            }
        }

        @Override // android.os.AsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            Log.d(ContentCommon.SERVER_STRING, "onProgressUpdate values:" + numArr[0]);
        }
    }

    private void delPic(int i2) {
        if (i2 > this.adapter.getCount() - 1) {
            return;
        }
        CloudBean cloudBean = (CloudBean) this.adapter.getItem(i2);
        LogUtils.e("biniy", "delPic-showPic2-size= " + this.adapter.getCount());
        LogUtils.e("biniy", "delPic-showPic2-position= " + i2);
        LogUtils.e("biniy", "delPic-showPic2-coudpath= " + cloudBean.getCloudPath());
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList.add(cloudBean.getCloudPath());
        arrayList2.add(String.valueOf(i2));
        if (arrayList2.size() < 1) {
            ToastUtils.showLong(getResources().getString(R.string.delete));
        } else {
            deletePics(arrayList, arrayList2);
        }
    }

    private void deletePics(List<String> list, final ArrayList<String> arrayList) {
        if (this.mLoadingPopupView == null) {
            a.C0120a c0120a = new a.C0120a(this);
            c0120a.a((Boolean) false);
            c0120a.b(false);
            this.mLoadingPopupView = c0120a.a("");
        }
        this.mLoadingPopupView.w();
        this.oss.asyncDeleteMultipleObject(this.did.startsWith(ContentCommon.SHIX_APPRE4) ? new DeleteMultipleObjectRequest("lookcam", list, true) : new DeleteMultipleObjectRequest(ContentCommon.CLOUDBUCKET, list, true), new OSSCompletedCallback<DeleteMultipleObjectRequest, DeleteMultipleObjectResult>() { // from class: com.shix.shixipc.activity.CloudLogActivity.3
            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onFailure(DeleteMultipleObjectRequest deleteMultipleObjectRequest, ClientException clientException, ServiceException serviceException) {
                MyLogUtils.d("asyncCopyAndDelObject", "Failed!");
            }

            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onSuccess(DeleteMultipleObjectRequest deleteMultipleObjectRequest, DeleteMultipleObjectResult deleteMultipleObjectResult) {
                LogUtils.e("biniy", "success!-Thead-> " + Thread.currentThread().getName());
                LogUtils.e("biniy", "cloudNum.size()= " + arrayList.size());
                CloudLogActivity.this.runOnUiThread(new Runnable() { // from class: com.shix.shixipc.activity.CloudLogActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LogUtils.e("biniy", "success!-Thead2-> " + Thread.currentThread().getName());
                        CloudLogActivity.this.adapter.clearAlarmLog(arrayList);
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        CloudLogActivity.this.clearData(arrayList);
                        arrayList.clear();
                        if (CloudLogActivity.this.mLoadingPopupView != null && CloudLogActivity.this.mLoadingPopupView.s()) {
                            CloudLogActivity.this.mLoadingPopupView.h();
                        }
                        CloudLogActivity.this.mHandler.sendEmptyMessageDelayed(997, 1000L);
                    }
                });
            }
        });
    }

    private void findView() {
        this.no_data_layout = (LinearLayout) findViewById(R.id.no_data_layout);
        this.btnBack = (Button) findViewById(R.id.back);
        this.listView = (GridView) findViewById(R.id.listView1);
        this.tvNoLog = (TextView) findViewById(R.id.no_log);
        this.deleteEdit = (TextView) findViewById(R.id.tv_alarm_edit);
        this.btnDelete = (Button) findViewById(R.id.tv_alarm_delete);
        this.btnSeleteAll = (Button) findViewById(R.id.tv_alarm_selete);
        this.llBottom = (LinearLayout) findViewById(R.id.tv_alarm_bottoom);
        this.tv_camera_setting = (TextView) findViewById(R.id.tv_camera_setting);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void getDataFromOther() {
        /*
            Method dump skipped, instructions count: 656
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shix.shixipc.activity.CloudLogActivity.getDataFromOther():void");
    }

    private String getFilePathByContentResolver(Context context, Uri uri) {
        String str = null;
        if (uri == null) {
            return null;
        }
        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        if (query == null) {
            throw new IllegalArgumentException("Query on " + uri + " returns null result.");
        }
        try {
            if (query.getCount() == 1 && query.moveToFirst()) {
                str = query.getString(query.getColumnIndexOrThrow("_data"));
            }
            return str;
        } finally {
            query.close();
        }
    }

    private String getStrDate() {
        return new SimpleDateFormat("yyyy-MM-dd_HH_mm").format(new Date());
    }

    private void save2Album() {
        File file = new File(this.pathTest);
        if (file.exists()) {
            FileUtil.save2Album(this, file.getPath());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void savePicToSDcard() {
        Handler handler;
        File file;
        FileOutputStream fileOutputStream = null;
        MyLogUtils.d(ContentCommon.SERVER_STRING, "savePicToSDcard1");
        try {
            try {
                File file2 = new File(FileUtil.getRootDir(), "HDWiFiCam/picVisitor");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                this.dateTime.replace(LogUtils.PLACEHOLDER, "_").replace("-", "_").replace(":", "_");
                file = new File(this.pathTest);
            } catch (Exception e2) {
                e = e2;
            }
            if (file.exists()) {
                return;
            }
            MyLogUtils.d(ContentCommon.SERVER_STRING, "savePicToSDcard1---file:" + file.getAbsolutePath());
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                if (this.bmp != null && this.bmp.compress(Bitmap.CompressFormat.JPEG, 60, fileOutputStream2)) {
                    fileOutputStream2.flush();
                }
                try {
                    fileOutputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                MyLogUtils.d(ContentCommon.SERVER_STRING, "savePicToSDcard3");
                handler = this.BitMapHandler;
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = fileOutputStream2;
                e.printStackTrace();
                MyLogUtils.d(ContentCommon.SERVER_STRING, "savePicToSDcard2");
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    MyLogUtils.d(ContentCommon.SERVER_STRING, "savePicToSDcard3");
                    handler = this.BitMapHandler;
                    handler.sendEmptyMessage(111);
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    MyLogUtils.d(ContentCommon.SERVER_STRING, "savePicToSDcard3");
                    this.BitMapHandler.sendEmptyMessage(111);
                }
                throw th;
            }
            handler.sendEmptyMessage(111);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void setListener() {
        this.btnBack.setOnClickListener(this);
        this.deleteEdit.setOnClickListener(this);
        this.btnDelete.setOnClickListener(this);
        this.btnSeleteAll.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startActivityForResultPic(String str) {
        Intent intent = new Intent(this, (Class<?>) CloudPhotoViewActivity.class);
        intent.putExtra("pic_path", str);
        startActivityForResult(intent, 661);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void takePicture() {
        new Thread() { // from class: com.shix.shixipc.activity.CloudLogActivity.6
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                CloudLogActivity.this.savePicToSDcard();
            }
        }.start();
    }

    private void test() {
        final ListObjectsRequest listObjectsRequest = this.did.startsWith(ContentCommon.SHIX_APPRE4) ? new ListObjectsRequest("lookcam") : new ListObjectsRequest(ContentCommon.CLOUDBUCKET);
        listObjectsRequest.setPrefix(this.did + "/photos/" + this.strdata + "/");
        listObjectsRequest.setMaxKeys(999);
        StringBuilder sb = new StringBuilder();
        sb.append("  prefix=");
        sb.append(listObjectsRequest.getPrefix());
        MyLogUtils.d("tag", sb.toString());
        MyLogUtils.d("OSS AyncListObjects", "OSS---start ");
        this.oss.asyncListObjects(listObjectsRequest, new OSSCompletedCallback<ListObjectsRequest, ListObjectsResult>() { // from class: com.shix.shixipc.activity.CloudLogActivity.4
            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onFailure(ListObjectsRequest listObjectsRequest2, ClientException clientException, ServiceException serviceException) {
                if (clientException != null) {
                    clientException.printStackTrace();
                }
                if (serviceException != null) {
                    MyLogUtils.e("OSS ErrorCode", "OSS " + serviceException.getErrorCode());
                    MyLogUtils.e("OSS RequestId", "OSS " + serviceException.getRequestId());
                    MyLogUtils.e("OSS HostId", "OSS " + serviceException.getHostId());
                    MyLogUtils.e("OSS RawMessage", "OSS " + serviceException.getRawMessage());
                }
                MyLogUtils.d("OSS AyncListObjects", "OSS---end ");
            }

            @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
            public void onSuccess(ListObjectsRequest listObjectsRequest2, ListObjectsResult listObjectsResult) {
                MyLogUtils.d("OSS AyncListObjects", "OSS Success!  size：" + listObjectsResult.getObjectSummaries().size() + "  Prefix=" + listObjectsRequest.getPrefix());
                for (int i2 = 0; i2 < listObjectsResult.getObjectSummaries().size(); i2++) {
                    MyLogUtils.d("OSS AyncListObjects", "OSS object: " + listObjectsResult.getObjectSummaries().get(i2).getKey() + LogUtils.PLACEHOLDER + listObjectsResult.getObjectSummaries().get(i2).getETag() + LogUtils.PLACEHOLDER + listObjectsResult.getObjectSummaries().get(i2).getLastModified());
                    String key = listObjectsResult.getObjectSummaries().get(i2).getKey();
                    Message obtainMessage = CloudLogActivity.this.mHandler.obtainMessage();
                    obtainMessage.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString(FileProvider.ATTR_PATH, key);
                    obtainMessage.setData(bundle);
                    CloudLogActivity.this.mHandler.sendMessage(obtainMessage);
                    if (i2 == listObjectsResult.getObjectSummaries().size() - 1) {
                        CloudLogActivity.this.mHandler.sendEmptyMessage(2);
                    }
                }
            }
        }).waitUntilFinished();
    }

    @Override // com.shix.shixipc.activity.NUIMainActivity.SHIXCOMMONInterface
    public void CallBackSHIXJasonCommon(String str, String str2) {
        if (TextUtils.isEmpty(this.did) || !str.equals(this.did.replace("-", "")) || str2.indexOf("121") <= 0) {
            return;
        }
        try {
            this.mModel = DeviceOffTimeModel.jsonToModel(str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (this.isFirstRun) {
            this.mHandler.sendEmptyMessage(3);
            this.isFirstRun = false;
        }
    }

    public /* synthetic */ void a(NiftyDialogBuilder niftyDialogBuilder, View view) {
        niftyDialogBuilder.dismiss();
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < this.adapter.getCount(); i2++) {
            CloudBean cloudBean = (CloudBean) this.adapter.getItem(i2);
            if (cloudBean.isChecked()) {
                arrayList.add(cloudBean.getCloudPath());
                arrayList2.add(String.valueOf(i2));
            }
        }
        if (arrayList2.size() < 1) {
            Toast.makeText(this, getResources().getString(R.string.delete), 1).show();
        } else {
            deletePics(arrayList, arrayList2);
        }
    }

    public void clearData(List<String> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            int parseInt = Integer.parseInt(list.get(i2)) - i2;
            if (parseInt >= 0 && parseInt < this.adapter.getCount()) {
                this.adapter.remove(parseInt);
            }
        }
    }

    public void getObjectSample(String str, String str2, String str3) {
        MyLogUtils.d("getObjectSample", " strDid:" + str + " fileName:" + str2 + " cloudPath:" + str3);
        File rootDir = FileUtil.getRootDir();
        StringBuilder sb = new StringBuilder();
        sb.append("HDWiFiCam/cloud/");
        sb.append(str);
        File file = new File(rootDir, sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str2);
        LogUtils.e("biniy", "一脸懵逼- 1.0 -> " + this.pathTest);
        LogUtils.e("biniy", "一脸懵逼- 2.0 -> " + file2.getAbsolutePath());
        try {
            this.testOS = new FileOutputStream(file2);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
        try {
            try {
                GetObjectResult object2 = this.oss.getObject(str.startsWith(ContentCommon.SHIX_APPRE4) ? new GetObjectRequest("lookcam", str3) : new GetObjectRequest(ContentCommon.CLOUDBUCKET, str3));
                MyLogUtils.d("getObjectSample", "" + object2.getContentLength());
                InputStream objectContent = object2.getObjectContent();
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = objectContent.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    MyLogUtils.d("getObjectSample", "read length: " + read);
                    if (this.testOS != null) {
                        this.testOS.write(bArr, 0, read);
                    }
                }
                MyLogUtils.d("getObjectSample", "download success.");
                MyLogUtils.d("getObjectSample", object2.getMetadata().getContentType());
                try {
                    if (this.testOS != null) {
                        this.testOS.flush();
                        this.testOS.close();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                LogUtils.e("biniy", "一脸懵逼- 3.0");
            } catch (ClientException e4) {
                e4.printStackTrace();
            } catch (ServiceException e5) {
                MyLogUtils.e("getObjectSample-RequestId", e5.getRequestId());
                MyLogUtils.e("getObjectSample-ErrorCode", e5.getErrorCode());
                MyLogUtils.e("getObjectSample-HostId", e5.getHostId());
                MyLogUtils.e("getObjectSample-RawMessage", e5.getRawMessage());
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    public void initData() {
    }

    public void initExitPopupWindow_re() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.popup_cloud, (ViewGroup) null);
        this.popv_re = inflate;
        this.textView = (TextView) inflate.findViewById(R.id.textView);
        this.textView_name = (TextView) this.popv_re.findViewById(R.id.textView_name);
        this.imageView = (ImageView) this.popv_re.findViewById(R.id.imageView);
        this.buttonPlay = (Button) this.popv_re.findViewById(R.id.buttonPlay);
        PopupWindow popupWindow = new PopupWindow(this.popv_re, -1, -1);
        this.popupWindow_re = popupWindow;
        popupWindow.setAnimationStyle(R.style.AnimationPreview);
        this.popupWindow_re.setFocusable(true);
        this.popupWindow_re.setOutsideTouchable(true);
        this.popupWindow_re.setBackgroundDrawable(new ColorDrawable(0));
        ((Button) this.popv_re.findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.CloudLogActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CloudLogActivity.this.popupWindow_re.dismiss();
            }
        });
        this.popv_re.findViewById(R.id.share).setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.CloudLogActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CloudLogActivity cloudLogActivity = CloudLogActivity.this;
                String str = cloudLogActivity.pathTest;
                if (str != null) {
                    cloudLogActivity.shareImage(str);
                }
            }
        });
        this.buttonPlay.setOnClickListener(new View.OnClickListener() { // from class: com.shix.shixipc.activity.CloudLogActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CloudLogActivity.this.new MyAsyncTask().execute(CloudLogActivity.this.CloudPath111.replace("photos", "records").replace(".jpg", ".h264"));
            }
        });
        this.popupWindow_re.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.shix.shixipc.activity.CloudLogActivity.10
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                CloudLogActivity.this.popupWindow_re.dismiss();
            }
        });
        this.popupWindow_re.setTouchInterceptor(new View.OnTouchListener() { // from class: com.shix.shixipc.activity.CloudLogActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                CloudLogActivity.this.popupWindow_re.dismiss();
                return false;
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 661 && i3 == -1 && intent.getIntExtra("del", 0) > 0) {
            delPic(this.toCloudPhotoViewAtyPosition);
        }
        this.toCloudPhotoViewAtyPosition = -1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back /* 2131230819 */:
                NUIMainActivity.setSHIXCOMMONInterface(null);
                finish();
                break;
            case R.id.tv_alarm_delete /* 2131231579 */:
                final NiftyDialogBuilder niftyDialogBuilder = NiftyDialogBuilder.getInstance(this);
                niftyDialogBuilder.withMessage(getString(R.string.second_fra_tip_again)).withButton1Text(getString(R.string.my_setup_cancel)).withButton2Text(getString(R.string.my_setup_sure)).setButton2Click(new View.OnClickListener() { // from class: c.h.a.a.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        CloudLogActivity.this.a(niftyDialogBuilder, view2);
                    }
                }).setButton1Click(new View.OnClickListener() { // from class: c.h.a.a.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        NiftyDialogBuilder.this.dismiss();
                    }
                }).show();
                break;
            case R.id.tv_alarm_edit /* 2131231580 */:
                if (this.llBottom.getVisibility() != 0) {
                    this.llBottom.setVisibility(0);
                    this.deleteEdit.setText(getResources().getText(R.string.my_setup_cancel));
                    this.adapter.startEdit(true);
                    this.adapter.seleteAllAlarmLog(false);
                    break;
                } else {
                    this.llBottom.setVisibility(8);
                    this.deleteEdit.setText(getResources().getText(R.string.main_edit));
                    this.adapter.startEdit(false);
                    break;
                }
            case R.id.tv_alarm_selete /* 2131231583 */:
                this.adapter.seleteAllAlarmLog(true);
                break;
        }
        CloudLogAdapter cloudLogAdapter = this.adapter;
        if (cloudLogAdapter != null) {
            cloudLogAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.shix.shixipc.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.cloudlog);
        ActivityTaskManager.getInstance().putActivity("CloudLogActivity", this);
        findView();
        setListener();
        this.strdata = getIntent().getStringExtra(ContentCommon.STR_CLOUD_DATE);
        ((TextView) findViewById(R.id.tv_camera_setting)).setText(this.strdata);
        CloudLogAdapter cloudLogAdapter = new CloudLogAdapter(this, this);
        this.adapter = cloudLogAdapter;
        this.listView.setAdapter((ListAdapter) cloudLogAdapter);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.shix.shixipc.activity.CloudLogActivity.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (CloudLogActivity.this.llBottom.getVisibility() == 0 && CloudLogActivity.this.adapter != null) {
                    CloudLogActivity.this.adapter.seleteAlarmLog(i2);
                }
                if (CloudLogActivity.this.adapter != null) {
                    CloudLogActivity.this.adapter.notifyDataSetChanged();
                }
            }
        });
        getDataFromOther();
        if (this.adapter.getCount() > 0) {
            this.no_data_layout.setVisibility(8);
            this.listView.setVisibility(0);
            this.tvNoLog.setVisibility(8);
        } else {
            this.no_data_layout.setVisibility(0);
            this.listView.setVisibility(8);
            this.tvNoLog.setVisibility(0);
        }
        if (this.play_tag_log == 1) {
            this.linearLayout_buttom.setVisibility(0);
            this.btnBack.setVisibility(8);
        }
        initExitPopupWindow_re();
        String str = this.did;
        if (str != null) {
            this.did = str.toUpperCase().replace("-", "");
            NUIMainActivity.setSHIXCOMMONInterface(this);
            NativeCallerTools.SDKAPITransferMessage(DeviceUtil.INSTANCE.getSdkId(this.did), CommonUtil.getDataFromDevice("get_light_param", 121, SystemValue.doorBellAdmin, SystemValue.doorBellPass));
            String str2 = this.did.substring(0, 3) + "-" + this.did.substring(3, 9) + "-" + this.did.substring(9);
            this.did = str2;
            OSSPlainTextAKSKCredentialProvider oSSPlainTextAKSKCredentialProvider = str2.startsWith(ContentCommon.SHIX_APPRE4) ? new OSSPlainTextAKSKCredentialProvider("LTAI4Fvp5vkFic1UxLBmVk41", "E71ud2gGXTGO4DmR3qhYs9eTytcSuL") : new OSSPlainTextAKSKCredentialProvider("LTAI4FuRjQ3yKaiDrhWk7Vxv", "Ncf5q6WIocKiPtPUlyCQxLYKq1tIT1");
            ClientConfiguration clientConfiguration = new ClientConfiguration();
            clientConfiguration.setConnectionTimeout(15000);
            clientConfiguration.setSocketTimeout(15000);
            clientConfiguration.setMaxConcurrentRequest(5);
            clientConfiguration.setMaxErrorRetry(2);
            this.oss = new OSSClient(this, "http://oss-cn-hongkong.aliyuncs.com", oSSPlainTextAKSKCredentialProvider);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.adapter = null;
        ((NotificationManager) getSystemService("notification")).cancel(110);
        this.mHandler.removeCallbacksAndMessages(null);
        LoadingPopupView loadingPopupView = this.mLoadingPopupView;
        if (loadingPopupView == null || !loadingPopupView.s()) {
            return;
        }
        this.mLoadingPopupView.h();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        getDataFromOther();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (CommonUtil.isApModul(getWifiSSID())) {
            return;
        }
        if (NetWorkUtil.isNetworkAvailable(this)) {
            test();
        } else {
            ToastUtils.showShort(getResources().getString(R.string.tip_wlbwd));
        }
    }

    public void shareImage(String str) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/*");
            Uri savePicToSDcard = savePicToSDcard(BitmapFactory.decodeFile(str));
            if (Build.VERSION.SDK_INT > 23) {
                intent.setFlags(1);
            }
            intent.putExtra("android.intent.extra.STREAM", savePicToSDcard);
            startActivity(Intent.createChooser(intent, getResources().getString(R.string.send_title)));
        } catch (Exception unused) {
        }
    }

    public void showPic(int i2, String str, String str2, String str3, String str4, String str5, int i3) {
        CloudLogAdapter cloudLogAdapter;
        LogUtils.e("biniy", "delPic-showPic-size= " + this.adapter.getCount());
        LogUtils.e("biniy", "delPic-showPic-position= " + i2);
        LogUtils.e("biniy", "delPic-showPic-coudpath= " + str4);
        LogUtils.e("biniy", "delPic-showPic-FileName= " + str2);
        this.toCloudPhotoViewAtyPosition = i2;
        MyLogUtils.d("getObjectSample", " FileName:" + str2 + " CreateTime:" + str3 + " coudpath:" + str4);
        this.pathTest = FileUtil.getRootDir() + "/" + ContentCommon.SDCARD_PATH + "/cloud/" + this.did + "/" + str2;
        if (i3 != 1) {
        }
        this.FileName111 = str2;
        this.CloudPath111 = str4;
        if (i3 != 1 && (cloudLogAdapter = this.adapter) != null) {
            cloudLogAdapter.notifyDataSetChanged();
        }
        File file = new File(this.pathTest);
        if (this.mLoadingPopupView == null) {
            a.C0120a c0120a = new a.C0120a(this);
            c0120a.a((Boolean) false);
            c0120a.b(false);
            this.mLoadingPopupView = c0120a.a("");
        }
        this.mLoadingPopupView.w();
        if (!file.exists()) {
            new AsyncTask<Void, Void, Void>() { // from class: com.shix.shixipc.activity.CloudLogActivity.5
                @Override // android.os.AsyncTask
                public Void doInBackground(Void... voidArr) {
                    CloudLogActivity cloudLogActivity = CloudLogActivity.this;
                    String str6 = cloudLogActivity.did;
                    CloudLogActivity cloudLogActivity2 = CloudLogActivity.this;
                    cloudLogActivity.getObjectSample(str6, cloudLogActivity2.FileName111, cloudLogActivity2.CloudPath111);
                    return null;
                }

                @Override // android.os.AsyncTask
                public void onPostExecute(Void r8) {
                    try {
                        LogUtils.e("biniy", "一脸懵逼- 4.1");
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = 1;
                        Bitmap decodeFile = BitmapFactory.decodeFile(CloudLogActivity.this.pathTest, options);
                        if (decodeFile != null) {
                            LogUtils.e("biniy", "一脸懵逼- 4.1.5");
                            CloudLogActivity.this.imageView.setImageBitmap(decodeFile);
                            if (CloudLogActivity.this.adapter != null) {
                                CloudLogActivity.this.adapter.notifyDataSetChanged();
                                LogUtils.e("biniy", "一脸懵逼- 4.2");
                            }
                        } else {
                            CloudLogActivity.this.imageView.setImageResource(R.mipmap.item_device_bg);
                        }
                        CloudLogActivity.this.mHandler.sendEmptyMessage(998);
                    } catch (Exception e2) {
                        LogUtils.e("biniy", "一脸懵逼-Exception e-> " + e2.getMessage());
                        CloudLogActivity.this.imageView.setImageResource(R.mipmap.item_device_bg);
                    }
                }
            }.execute(new Void[0]);
            return;
        }
        try {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 1;
                Bitmap decodeFile = BitmapFactory.decodeFile(this.pathTest, options);
                if (decodeFile != null) {
                    this.imageView.setImageBitmap(decodeFile);
                    startActivityForResultPic(this.pathTest);
                    LogUtils.e("biniy", "一脸懵逼- 5");
                } else {
                    this.imageView.setImageResource(R.mipmap.item_device_bg);
                }
                LoadingPopupView loadingPopupView = this.mLoadingPopupView;
                if (loadingPopupView == null || !loadingPopupView.s()) {
                    return;
                }
            } catch (Exception unused) {
                this.imageView.setImageResource(R.mipmap.item_device_bg);
                LoadingPopupView loadingPopupView2 = this.mLoadingPopupView;
                if (loadingPopupView2 == null || !loadingPopupView2.s()) {
                    return;
                }
            }
            this.mLoadingPopupView.h();
        } catch (Throwable th) {
            LoadingPopupView loadingPopupView3 = this.mLoadingPopupView;
            if (loadingPopupView3 != null && loadingPopupView3.s()) {
                this.mLoadingPopupView.h();
            }
            throw th;
        }
    }

    private synchronized Uri savePicToSDcard(Bitmap bitmap) {
        Uri uri;
        Uri uri2;
        String strDate = getStrDate();
        FileOutputStream fileOutputStream = null;
        uri2 = null;
        uri2 = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File(FileUtil.getRootDir(), "LDDDD/pic");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, strDate + ".jpg");
                FileOutputStream fileOutputStream3 = new FileOutputStream(file2);
                try {
                    if (bitmap.compress(Bitmap.CompressFormat.JPEG, 70, fileOutputStream3)) {
                        fileOutputStream3.flush();
                    }
                    String path = file2.getPath();
                    if (Build.VERSION.SDK_INT <= 23) {
                        String insertImage = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "", "");
                        MyLogUtils.d(ContentCommon.SERVER_STRING, "zhaogenghuai savepath:" + insertImage);
                        if (insertImage != null && insertImage.length() > 0) {
                            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                            uri2 = Uri.fromFile(new File(getFilePathByContentResolver(this, Uri.parse(insertImage))));
                            intent.setData(uri2);
                            sendBroadcast(intent);
                        }
                    } else {
                        uri2 = FileProvider.getUriForFile(this, getPackageName() + ".provider", new File(path));
                    }
                    try {
                        fileOutputStream3.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream3;
                    uri = null;
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    uri2 = uri;
                    return uri2;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream3;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                uri = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return uri2;
    }
}
