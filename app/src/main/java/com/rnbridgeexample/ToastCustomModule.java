package com.rnbridgeexample;

import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import javax.annotation.Nullable;

/**
 * Created by punchh_sahir on 14/01/17.
 */
@ReactModule(name = "ToastCustomModule")
public class ToastCustomModule extends ReactContextBaseJavaModule {

    public ToastCustomModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "ToastCustomModule";
    }

    @ReactMethod
    public void showMessage(String message, Callback successCallback) {

        String finalMsg = message +" Test "+" final message";

        Toast.makeText(getReactApplicationContext(), finalMsg, Toast.LENGTH_LONG).show();
        successCallback.invoke(finalMsg);

        callingActivityMethod();

    }

    public void callingActivityMethod() {
        MainReactActivity activity = (MainReactActivity) getCurrentActivity();
        if (activity != null) {
            activity.activitySendEvent("message");
        }
    }


    private void sendEvent(ReactContext reactContext,
                           String eventName,
                           @Nullable WritableMap params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }


}
