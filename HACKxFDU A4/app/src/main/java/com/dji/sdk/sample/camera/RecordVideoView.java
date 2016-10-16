package com.dji.sdk.sample.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.dji.sdk.sample.R;
import com.dji.sdk.sample.common.BaseThreeBtnView;
import com.dji.sdk.sample.common.DJISampleApplication;
import com.dji.sdk.sample.common.Utils;
import com.dji.sdk.sample.utils.DJIModuleVerificationUtil;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import dji.common.camera.DJICameraSettingsDef;
import dji.common.error.DJIError;
import dji.common.util.DJICommonCallbacks;
import dji.sdk.base.DJIBaseComponent;

/**
 * Created by dji on 16/1/6.
 */
public class RecordVideoView extends BaseThreeBtnView {

    Timer timer = new Timer();
    private final Context context;
    private long timeCounter = 0;
    private long hours = 0;
    private long minutes = 0;
    private long seconds = 0;
    String time = "";
    public RecordVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        middleBtn.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        if (DJIModuleVerificationUtil.isCameraModuleAvailable()) {
            DJISampleApplication.getProductInstance().getCamera().setCameraMode(
                    DJICameraSettingsDef.CameraMode.RecordVideo,
                    new DJICommonCallbacks.DJICompletionCallback() {
                        @Override
                        public void onResult(DJIError djiError) {
                            Utils.setResultToToast(getContext(), "SetCameraMode to recordVideo");
                        }
                    }
            );
        }
    }

    protected void onDetachedToWindow() {
        super.onDetachedFromWindow();

        if (DJIModuleVerificationUtil.isCameraModuleAvailable()) {
            DJISampleApplication.getProductInstance().getCamera().setCameraMode(
                    DJICameraSettingsDef.CameraMode.ShootPhoto,
                    new DJICommonCallbacks.DJICompletionCallback() {
                        @Override
                        public void onResult(DJIError djiError) {
                            Utils.setResultToToast(getContext(), "SetCameraMode to shootPhoto");
                        }
                    }
            );
        }
    }

    @Override
    protected int getLeftBtnTextResourceId() {
        return R.string.record_video_start_record;
    }

    @Override
    protected int getRightBtnTextResourceId() {
        return R.string.record_video_stop_record;
    }

    @Override
    protected int getMiddleBtnTextResourceId() {
        return R.string.shoot_single_photo;
    }

    @Override
    protected int getInfoResourceId() {
        return R.string.record_video_initial_time;
    }

    @Override
    protected void getLeftBtnMethod() {

        Utils.setResultToText(context, mTexInfo, "00:00:00");
        if (DJIModuleVerificationUtil.isCameraModuleAvailable()) {
            DJISampleApplication.getProductInstance().getCamera().startRecordVideo(
                    new DJICommonCallbacks.DJICompletionCallback() {
                        @Override
                        public void onResult(DJIError djiError) {
                            //success so, start recording
                            if (null == djiError) {
                                Utils.setResultToToast(getContext(), "Start record");
                                timer = new Timer();
                                timer.schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                                        timeCounter = timeCounter + 1;
                                        hours = TimeUnit.MILLISECONDS.toHours(timeCounter);
                                        minutes = TimeUnit.MILLISECONDS.toMinutes(timeCounter) - (hours * 60);
                                        seconds = TimeUnit.MILLISECONDS.toSeconds(timeCounter) - ((hours * 60 * 60) + (minutes * 60));
                                        time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
                                        Utils.setResultToText(context, mTexInfo, time);
                                    }
                                }, 0, 1);
                            }

                        }
                    }
            );
        }

    }

    @Override
    protected void getRightBtnMethod() {

        if (DJIModuleVerificationUtil.isCameraModuleAvailable()) {
            DJISampleApplication.getProductInstance().getCamera().stopRecordVideo(
                    new DJICommonCallbacks.DJICompletionCallback() {
                        @Override
                        public void onResult(DJIError djiError) {
                            Utils.setResultToToast(getContext(), "StopRecord");
                            Utils.setResultToText(context, mTexInfo, "00:00:00");
                            timer.cancel();
                            timeCounter = 0;
                        }
                    }
            );
        }
    }

    @Override
    protected void getMiddleBtnMethod() {

    }
}
