package com.cc.githubsearchviewmodel.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface BaseDao<T> {

    @Insert(onConflict = REPLACE)
    void insert(T object);

    @Insert(onConflict = REPLACE)
    void insertAll(List<T> list);

    @Delete
    void delete(T object);

}
