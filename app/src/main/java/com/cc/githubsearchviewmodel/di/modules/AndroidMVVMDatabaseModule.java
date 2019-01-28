package com.cc.githubsearchviewmodel.di.modules;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.cc.githubsearchviewmodel.database.AndroidMVVMDatabase;
import com.cc.githubsearchviewmodel.database.dao.SearchResultDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidMVVMDatabaseModule {

    // --- DATABASE INJECTION ---

    @Provides
    @Singleton
    AndroidMVVMDatabase provideDatabase(Application application) {
        return Room.databaseBuilder(application,
                AndroidMVVMDatabase.class, "AndroidMVVM.db")
                .build();
    }

    @Provides
    @Singleton
    SearchResultDao provideSearchResultDao(AndroidMVVMDatabase database) { return database.searchResultDao(); }
}
