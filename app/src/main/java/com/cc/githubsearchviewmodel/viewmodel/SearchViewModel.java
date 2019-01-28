package com.cc.githubsearchviewmodel.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

import com.cc.githubsearchviewmodel.models.SearchResponse;
import com.cc.githubsearchviewmodel.repository.SearchRepository;

import javax.inject.Inject;

public class SearchViewModel extends ViewModel {

    private LiveData<SearchResponse> searchResponse;

    private final SearchRepository repository;

    /**
     * SearchRepository injection from SearchViewModel constructor
     * @param searchRepository repository for search module
     */
    @Inject
    public SearchViewModel(SearchRepository searchRepository) {
        this.repository = searchRepository;
    }


    public void init(String searchQuery) {
        if (this.searchResponse != null) {
            return;
        }
        searchResponse = repository.getSearchResults(searchQuery);
    }

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public LiveData<SearchResponse> getSearchResults() {
        return this.searchResponse;
    }


    public void searchGitHubRepos(@Nullable final String query) {

        if (query != null && query.length() > 0) {
            this.searchResponse = repository.getSearchResults(query, (MutableLiveData<SearchResponse>) this.searchResponse);
        }
    }

}
