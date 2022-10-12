package com.innovations.beyondr.Common;


import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    static SharedPreferences sharedPreferences;
    static final String prefFile = App.getContext().getPackageName() + "MyPref";

    public static void setVariableInPreferences(String key, String value) {
        sharedPreferences = App.getContext().getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();

    }

    public static String getVariablesInPreferences(String key) {
        sharedPreferences = App.getContext().getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        String value = sharedPreferences.getString(key, null);
        if (value == null) {
            return "";
        }
        return value;
    }

    public static void setBooleanInPreferences(String key, Boolean value, Context context) {
        sharedPreferences = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();

    }

    public static Boolean getBooleanInPreferences(String key, Context context) {
        sharedPreferences = context.getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        Boolean value = sharedPreferences.getBoolean(key, false);
        return value;
    }


}
