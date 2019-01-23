package com.cc.githubsearchviewmodel.models;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse {

    @Nullable
    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @Nullable
    @SerializedName("items")
    @Expose
    private List<SearchResult> searchResults = null;

    @Nullable
    public Integer getTotalCount() {
        return totalCount;
    }

    @Nullable
    public List<SearchResult> getSearchResults() {
        return searchResults;
    }
}
