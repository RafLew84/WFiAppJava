package com.example.wfiappjava.data;

import android.app.Activity;
import android.content.res.TypedArray;

import com.example.wfiappjava.R;

import java.util.ArrayList;

public final class DataProvider {

    private DataProvider(){}

    public static final ArrayList<Institute> institutes = new ArrayList<>();

    public static void initializeData(Activity activity){
        String[] instituteList = activity.getResources().getStringArray(R.array.institute_titles);
        String[] instituteInfo = activity.getResources().getStringArray(R.array.institute_info);

        try (TypedArray instituteImageResources = activity.getResources().obtainTypedArray(R.array.institute_images)) {

            for (int i = 0; i < instituteList.length; i++)
                institutes.add(new Institute(
                        instituteList[i],
                        instituteInfo[i],
                        instituteImageResources.getResourceId(i, 0))
                );

            instituteImageResources.recycle();
        }
    }
}
