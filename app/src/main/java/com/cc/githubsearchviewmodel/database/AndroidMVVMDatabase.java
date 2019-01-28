package com.cc.githubsearchviewmodel.database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.cc.githubsearchviewmodel.database.dao.SearchResultDao;
import com.cc.githubsearchviewmodel.models.SearchResult;

@Database(entities = {SearchResult.class}, version = 1)
public abstract class AndroidMVVMDatabase extends RoomDatabase {

    // --- SINGLETON ---
    private static volatile AndroidMVVMDatabase DATABASE_INSTANCE;

    // --- DAO ---
    public abstract SearchResultDao searchResultDao();

}
