package com.cc.githubsearchviewmodel.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.cc.githubsearchviewmodel.models.SearchResult;

import java.util.List;

@Dao
public interface SearchResultDao extends BaseDao<SearchResult>{

    @Query("SELECT * FROM searchresult")
    List<SearchResult> getAll();

}
