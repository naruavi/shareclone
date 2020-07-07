package com.sharetest.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.content.ContextCompat;

import com.example.sharingtest.R;
import com.sharetest.design.RationalePermissionRequest;


public class AppUtils {

    public static RationalePermissionRequest.PermissionRequest getReadPermission(Context context) {

        return new RationalePermissionRequest.PermissionRequest(context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                R.string.text_requestPermissionStorage,
                R.string.text_requestPermissionStorageSummary);
    }

    public static boolean checkRequiredPermission(Context context, String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }

//    public static List<RationalePermissionRequest.PermissionRequest> getRequiredPermissions(Context context) {
//        List<RationalePermissionRequest.PermissionRequest> permissionRequests = new ArrayList<>();
//
//        //Make change here with testing.
//        if (Build.VERSION.SDK_INT >= 21) {
//            permissionRequests.add(new RationalePermissionRequest.PermissionRequest(context,
//                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                    R.string.text_requestPermissionStorage,
//                    R.string.text_requestPermissionStorageSummary));
//        }
//
//        if (Build.VERSION.SDK_INT >= 26) {
//            permissionRequests.add(new RationalePermissionRequest.PermissionRequest(context,
//                    Manifest.permission.READ_PHONE_STATE,
//                    R.string.text_requestPermissionReadPhoneState,
//                    R.string.text_requestPermissionReadPhoneStateSummary));
//        }
//
//        return permissionRequests;
//    }
}
