package com.siljan.alen.mvpdaggersample.data.prefs;

import android.content.SharedPreferences;

/**
 * Created by Alen Siljan on 21.2.2017..
 * alen.siljan@gmail.com
 */

public class SharedPreferencesManager {
    private SharedPreferences mPreferences;

    public SharedPreferencesManager(SharedPreferences sharedPreferences) {
        this.mPreferences = sharedPreferences;
    }

    public void storeSharedPreferencesInt(String key, int value) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int getSharedPreferencesInt(String key) {
        return mPreferences.getInt(key, 0);
    }

    public void storeSharedPreferencesBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getSharedPreferencesBoolean(String key) {
        return mPreferences.getBoolean(key, true);
    }

    public boolean getSharedPreferencesBooleanFalseDefValue(String key) {
        return mPreferences.getBoolean(key, false);
    }

    public void storeSharedPreferencesString(String key, String value) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getSharedPreferencesString(String key) {
        return mPreferences.getString(key, "");
    }
}
