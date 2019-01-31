package com.cc.githubsearchviewmodel.managers;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class AndroidMVVMSharedPrefManager {

    private final SharedPreferences mSharedPreferences;

    @Inject
    public AndroidMVVMSharedPrefManager(SharedPreferences mSharedPreferences) {
        this.mSharedPreferences = mSharedPreferences;
    }

    public void putData(String key, String data) {
        mSharedPreferences.edit().putString(key,data).apply();
    }

    public String getData(String key) {
        return mSharedPreferences.getString(key,"");
    }
}
