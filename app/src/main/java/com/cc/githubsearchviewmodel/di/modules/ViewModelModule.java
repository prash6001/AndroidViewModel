package com.cc.githubsearchviewmodel.di.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.cc.githubsearchviewmodel.di.key.ViewModelKey;
import com.cc.githubsearchviewmodel.viewmodel.FactoryViewModel;
import com.cc.githubsearchviewmodel.viewmodel.SearchViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel.class)
    abstract ViewModel bindUserProfileViewModel(SearchViewModel repoViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(FactoryViewModel factory);
}
