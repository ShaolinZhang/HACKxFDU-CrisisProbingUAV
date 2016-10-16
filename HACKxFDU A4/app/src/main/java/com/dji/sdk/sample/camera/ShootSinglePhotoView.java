package com.dji.sdk.sample.camera;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.dji.sdk.sample.R;
import com.dji.sdk.sample.common.BaseThreeBtnView;
import com.dji.sdk.sample.common.DJISampleApplication;
import com.dji.sdk.sample.utils.DJIDialog;

import dji.common.camera.DJICameraSettingsDef;
import dji.common.error.DJIError;
import dji.common.util.DJICommonCallbacks;
import dji.sdk.base.DJIBaseComponent;
import dji.sdk.camera.DJICamera;

/**
 * Class for shooting single photo.
 */
public class ShootSinglePhotoView extends BaseThreeBtnView {
    private DJICameraSettingsDef.CameraMode mCameraMode;

    private static final int ENABLE_LEFT_BTN = 0;
    private static final int DISABLE_LEFT_BTN = 1;

    private Handler mHandler = new Handler(new Handler.Callback() {

        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case ENABLE_LEFT_BTN :
                    leftBtn.setEnabled(true);
                    break;

                case DISABLE_LEFT_BTN:
                    leftBtn.setEnabled(false);
                    break;

                default:
                    break;
            }
            return false;
        }
    });

    public ShootSinglePhotoView(Context context, AttributeSet attrs) {
        super(context, attrs);

        middleBtn.setVisibility(View.GONE);
        rightBtn.setVisibility(View.GONE);
    }

    /**
     * Every commands relative to the shooting photos are only allowed executed in shootphoto work
     * mode.
     */
    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.v("Attached To Window", "onAttachedToWindow");

        if (isModuleAvailable()) {
//            DJISampleApplication.getProductInstance().getCamera().getCameraMode(
//                new DJIBaseComponent.DJICompletionCallbackWith<DJICameraSettingsDef.CameraMode>() {
//                    @Override
//                    public void onSuccess(DJICameraSettingsDef.CameraMode cameraMode) {
//                        mCameraMode = cameraMode;
//                    }
//
//                    @Override
//                    public void onFailure(DJIError djiError) {
//
//                    }
//                }
//            );

            DJISampleApplication.getProductInstance().getCamera().setCameraMode(
                    DJICameraSettingsDef.CameraMode.ShootPhoto,
                    new DJICommonCallbacks.DJICompletionCallback() {
                        @Override
                        public void onResult(DJIError djiError) {

                        }
                    }
            );
        }
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.v("Attached To Window", "onDetachedFromWindow");

        if (isModuleAvailable()) {
//            DJISampleApplication.getProductInstance().getCamera().setCameraMode(mCameraMode,
//                    new DJIBaseComponent.DJICompletionCallback() {
//                        @Override
//                        public void onResult(DJIError djiError) {
//
//                        }
//                    });
        }
    }

    private boolean isModuleAvailable() {
        return (null != DJISampleApplication.getProductInstance())
                && (null != DJISampleApplication.getProductInstance().getCamera());
    }

    @Override
    protected int getLeftBtnTextResourceId() {
        return R.string.shoot_single_photo;
    }

    @Override
    protected int getInfoResourceId() {
        return R.string.shoot_single_photo_descritpion;
    }

    @Override
    protected void getLeftBtnMethod() {
        //Shoot Photo Button
        /**if (isModuleAvailable()) {
            DJISampleApplication.getProductInstance().getCamera().startShootPhoto(
                    DJICameraSettingsDef.CameraShootPhotoMode.Single,
                    new DJICommonCallbacks.DJICompletionCallback() {
                        @Override
                        public void onResult(DJIError djiError) {
                            if (null == djiError)
                                DJIDialog.showDialog(getContext(), R.string.success);
                            else
                                DJIDialog.showDialog(getContext(), djiError.getDescription());
                                mHandler.sendEmptyMessage(ENABLE_LEFT_BTN);
                        }
                    }
            );
            mHandler.sendEmptyMessage(DISABLE_LEFT_BTN);
        }**/

        DJICameraSettingsDef.CameraMode cameraMode = DJICameraSettingsDef.CameraMode.ShootPhoto;

        final DJICamera camera = DJISampleApplication.getCameraInstance();
        if (camera != null) {
            DJICameraSettingsDef.CameraPhotoIntervalParam currentCameraPhotoIntervalParam = new DJICameraSettingsDef.CameraPhotoIntervalParam();
            try {
                currentCameraPhotoIntervalParam.timeIntervalInSeconds = 10;
            } catch (Exception e) {
                currentCameraPhotoIntervalParam.timeIntervalInSeconds = 10;
            }
            if (currentCameraPhotoIntervalParam.timeIntervalInSeconds <= 10 || currentCameraPhotoIntervalParam.timeIntervalInSeconds >= 100) {
                currentCameraPhotoIntervalParam.timeIntervalInSeconds = 10;
            }
            currentCameraPhotoIntervalParam.captureCount = 50; // Set interval count to 50
            DJICameraSettingsDef.CameraShootPhotoMode photoMode = DJICameraSettingsDef.CameraShootPhotoMode.Single; // Set the camera capture mode as Single mode
            camera.startShootPhoto(photoMode, new DJICommonCallbacks.DJICompletionCallback() {

                @Override
                public void onResult(DJIError error) {
                    if (error == null) {
                        //showToast("take photo: success");
                    } else {
                       // showToast(error.getDescription());
                    }
                }

            }); // Execute the startShootPhoto API
        }
    }

    @Override
    protected void getMiddleBtnMethod() {}

    @Override
    protected void getRightBtnMethod() {}

    @Override
    protected int getRightBtnTextResourceId() {return R.string.shoot_single_photo;}

    @Override
    protected int getMiddleBtnTextResourceId() {return R.string.shoot_single_photo;}
}
