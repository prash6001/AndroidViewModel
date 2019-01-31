package com.cc.githubsearchviewmodel.viewmodel;

import com.cc.githubsearchviewmodel.repository.SearchRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SearchViewModelTest {

    @Mock
    private SearchRepository repository;
    private SearchViewModel viewModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);// required for the "@Mock" annotations

        // Make viewmodel a mock while using mock repository
        viewModel = Mockito.spy(new SearchViewModel(repository));
    }

    @Test
    public void searchGitHubRepos() {
        String searchQuery = "view";

        // Trigger
        viewModel.searchGitHubRepos(searchQuery);

        // Validation
        Mockito.verify(repository, Mockito.times(1)).getSearchResults(searchQuery, null);
    }

    @Test
    public void searchGitHubRepos_noQuery() {
        String searchQuery = null;

        // Trigger
        viewModel.searchGitHubRepos(searchQuery);

        // Validation
        Mockito.verify(repository, Mockito.never()).getSearchResults(searchQuery);
    }
}
