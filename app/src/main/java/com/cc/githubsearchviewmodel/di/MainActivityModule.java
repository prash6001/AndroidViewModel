package com.cc.githubsearchviewmodel.di;

import com.cc.githubsearchviewmodel.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {

    abstract MainActivity contributeMainActivity();
}
