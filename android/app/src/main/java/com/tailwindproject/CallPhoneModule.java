package com.tailwindproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class CallPhoneModule extends ReactContextBaseJavaModule {

    CallPhoneModule(ReactApplicationContext context) {
        super(context);
    }

    @NonNull
    @Override
    public String getName() {
        return "CallPhoneModule";
    }

    @ReactMethod
    public void callNumber(String phoneNumber){
        Activity currentActivity = getCurrentActivity();
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));

        if (currentActivity != null) {
            currentActivity.startActivity(intent);
        }
    }
}
