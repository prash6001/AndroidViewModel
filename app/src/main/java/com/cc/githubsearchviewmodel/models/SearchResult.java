package com.cc.githubsearchviewmodel.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class SearchResult {

    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("private")
    @Expose
    private Boolean _private;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("stargazers_count")
    @Expose
    private Integer stargazersCount;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("has_wiki")
    @Expose
    private Boolean hasWiki;
    @SerializedName("archived")
    @Expose
    private Boolean archived;
    @SerializedName("score")
    @Expose
    private Double score;

    // --- CONSTRUCTORS ---

    public SearchResult() { }

    public SearchResult(@NonNull Integer id, String name, String fullName, Boolean _private, String description, String updatedAt, Integer size,
                        Integer stargazersCount, String language, Boolean hasWiki, Boolean archived, Double score) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this._private = _private;
        this.description = description;
        this.updatedAt = updatedAt;
        this.size = size;
        this.stargazersCount = stargazersCount;
        this.language = language;
        this.hasWiki = hasWiki;
        this.archived = archived;
        this.score = score;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean get_private() {
        return _private;
    }

    public void set_private(Boolean _private) {
        this._private = _private;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStargazersCount() {
        return stargazersCount;
    }

    public void setStargazersCount(Integer stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getHasWiki() {
        return hasWiki;
    }

    public void setHasWiki(Boolean hasWiki) {
        this.hasWiki = hasWiki;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
