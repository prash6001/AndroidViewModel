package com.cc.githubsearchviewmodel.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.cc.githubsearchviewmodel.Contract.GitHubService;
import com.cc.githubsearchviewmodel.models.SearchResponse;

import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class SearchRepository {

    private final Executor executor;
    private final GitHubService gitHubService;


    @Inject
    public SearchRepository(GitHubService webservice,Executor executor) {
        this.gitHubService = webservice;
        this.executor = executor;
    }

    public LiveData<SearchResponse> getSearchResults(final String searchQuery) {
        // This isn't an optimal implementation. We'll fix it later.
        final MutableLiveData<SearchResponse> searchResponse = new MutableLiveData<>();

        gitHubService.getSearchResults(searchQuery).enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(@NonNull Call<SearchResponse> call, @NonNull Response<SearchResponse> response) {
                System.out.println("onResponse");
                searchResponse.setValue(response.body());

            }

            @Override
            public void onFailure(@NonNull Call<SearchResponse> call, @NonNull Throwable t) {
                searchResponse.setValue(null);
                System.out.println("onFailure");
            }

        });
        return searchResponse;
    }

    public LiveData<SearchResponse> getSearchResults(final String searchQuery, MutableLiveData<SearchResponse> searchResponse) {
        // This isn't an optimal implementation. We'll fix it later.
        //final MutableLiveData<SearchResponse> searchResponse = new MutableLiveData<>();

        gitHubService.getSearchResults(searchQuery).enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(@NonNull Call<SearchResponse> call, @NonNull Response<SearchResponse> response) {
                System.out.println("onResponse");
                searchResponse.setValue(response.body());

            }

            @Override
            public void onFailure(@NonNull Call<SearchResponse> call, @NonNull Throwable t) {
                searchResponse.setValue(null);
                System.out.println("onFailure");
            }

        });
        return searchResponse;
    }
}
