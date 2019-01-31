package com.cc.githubsearchviewmodel.Contract.Search;

import com.cc.githubsearchviewmodel.models.SearchResponse;

/**
 * Contract to pass data from repository to view model
 */
public interface SearchViewModelContract {

    void onSearchResultsFetched(SearchResponse searchResponse);

}
