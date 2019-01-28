package com.cc.githubsearchviewmodel.di.modules;

import com.cc.githubsearchviewmodel.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();
}