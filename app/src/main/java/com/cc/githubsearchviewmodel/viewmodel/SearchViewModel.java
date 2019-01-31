package com.cc.githubsearchviewmodel.viewmodel;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.cc.githubsearchviewmodel.Contract.Search.SearchViewModelContract;
import com.cc.githubsearchviewmodel.models.SearchResponse;
import com.cc.githubsearchviewmodel.repository.SearchRepository;

import javax.inject.Inject;

public class SearchViewModel extends ViewModel implements SearchViewModelContract, LifecycleOwner {

    private MutableLiveData<SearchResponse> searchResponse = new MutableLiveData<>();

    private final SearchRepository repository;

    /**
     * SearchRepository injection from SearchViewModel constructor
     * @param searchRepository repository for search module
     */
    @Inject
    public SearchViewModel(SearchRepository searchRepository) {
        this.repository = searchRepository;
    }

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public MutableLiveData<SearchResponse> getSearchResults() {
        return this.searchResponse;
    }


    public void searchGitHubRepos(@Nullable final String query) {

        if (query != null && query.length() > 0) {
            repository.getSearchResults(query, this.searchResponse, this);
            System.out.println();
        }
    }

    @Override
    public void onSearchResultsFetched(SearchResponse searchResponse) {

        postDataToView(searchResponse);

    }

    /**
     * Method to post the altered / filtered / manipulated data to the view
     * @param searchResponse altered / manipulated / filtered response
     */
    private void postDataToView(SearchResponse searchResponse) {

        this.searchResponse.postValue(searchResponse);

    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return null;
    }
}
