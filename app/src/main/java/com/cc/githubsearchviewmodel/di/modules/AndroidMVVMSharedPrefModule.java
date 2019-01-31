package com.cc.githubsearchviewmodel.di.modules;

import android.content.Context;

import com.cc.githubsearchviewmodel.managers.AndroidMVVMSharedPrefManager;
import com.cc.githubsearchviewmodel.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.cc.githubsearchviewmodel.applicationpack.GitHubSearchApplication.context;

@Module
public class AndroidMVVMSharedPrefModule {

    @Singleton
    @Provides
    public Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    AndroidMVVMSharedPrefManager provideSharedPreferences(){
        return new AndroidMVVMSharedPrefManager(context.getSharedPreferences(AppConstants.MY_PREFS, Context.MODE_PRIVATE));
        //return context.getSharedPreferences(AppConstants.MY_PREFS, Context.MODE_PRIVATE);
    }
}
