package com.cc.githubsearchviewmodel.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.cc.githubsearchviewmodel.Contract.GitHubService;
import com.cc.githubsearchviewmodel.database.dao.SearchResultDao;
import com.cc.githubsearchviewmodel.models.SearchResponse;
import com.cc.githubsearchviewmodel.models.SearchResult;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class SearchRepository {

    private final Executor executor;
    private final SearchResultDao searchResultDao;
    private final GitHubService gitHubService;


    @Inject
    public SearchRepository(GitHubService webservice,Executor executor, SearchResultDao searchResultDao) {
        this.gitHubService = webservice;
        this.executor = executor;
        this.searchResultDao = searchResultDao;
    }

    public LiveData<SearchResponse> getSearchResults(final String searchQuery) {

        // This isn't an optimal implementation. We'll fix it later.
        final MutableLiveData<SearchResponse> searchResponse = new MutableLiveData<>();

        executor.execute(() -> gitHubService.getSearchResults(searchQuery).enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(@NonNull Call<SearchResponse> call, @NonNull Response<SearchResponse> response) {

                executor.execute(() -> {

                    if(response.isSuccessful()) {

                        if (response.body() != null && response.body().getSearchResults() != null) {

                            searchResultDao.insertAll(response.body().getSearchResults());
                            searchResponse.postValue(response.body());
                        }

                    }

                });

            }

            @Override
            public void onFailure(@NonNull Call<SearchResponse> call, @NonNull Throwable t) {
                searchResponse.setValue(null);
                System.out.println("onFailure");
            }

        }));
        return searchResponse;


    }

    public LiveData<SearchResponse> getSearchResults(final String searchQuery, MutableLiveData<SearchResponse> searchResponse) {
        // This isn't an optimal implementation. We'll fix it later.
        //final MutableLiveData<SearchResponse> searchResponse = new MutableLiveData<>();


        executor.execute(() -> {
            List<SearchResult> list = searchResultDao.getAll();
        });

        executor.execute(() -> gitHubService.getSearchResults(searchQuery).enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(@NonNull Call<SearchResponse> call, @NonNull Response<SearchResponse> response) {

                executor.execute(() -> {

                    if(response.isSuccessful()) {

                        if (response.body() != null && response.body().getSearchResults() != null) {

                            searchResultDao.insertAll(response.body().getSearchResults());

                            searchResponse.postValue(response.body());
                        }

                    }else if(String.valueOf(response.code()).startsWith("4")){


                    }

                });



            }

            @Override
            public void onFailure(@NonNull Call<SearchResponse> call, @NonNull Throwable t) {
                searchResponse.setValue(null);
                System.out.println("onFailure");
            }

        }));

        return searchResponse;
    }
}
