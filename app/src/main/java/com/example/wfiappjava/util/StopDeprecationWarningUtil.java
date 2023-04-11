package com.example.wfiappjava.util;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;

public final class StopDeprecationWarningUtil {
    private StopDeprecationWarningUtil(){}

    public static <T extends Parcelable> T parcelable(Bundle bundle, String key, Class<T> type) {
        if (Build.VERSION.SDK_INT >= 33) {
            return bundle.getParcelable(key, type);
        } else {
            @SuppressWarnings("deprecation")
            Parcelable parcelable = bundle.getParcelable(key);
            return parcelable != null ? (T) parcelable : null;
        }
    }
}
