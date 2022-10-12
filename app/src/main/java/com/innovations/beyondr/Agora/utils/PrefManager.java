package com.innovations.beyondr.Agora.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.innovations.beyondr.Agora.Constants;


public class PrefManager {
    public static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE);
    }
}
