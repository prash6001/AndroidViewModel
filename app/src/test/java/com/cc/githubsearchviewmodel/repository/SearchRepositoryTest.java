package com.cc.githubsearchviewmodel.repository;

import com.cc.githubsearchviewmodel.Contract.GitHubService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.Executor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchRepositoryTest {

    private SearchRepository repository;

    @Mock
    private GitHubService gitHubService;

    @Mock
    private Executor executor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        repository = Mockito.spy(new SearchRepository(gitHubService, executor));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void getSearchResults(){

        Call call = Mockito.mock(Call.class);
        String searchQuery = "view";
        Mockito.doReturn(call).when(gitHubService).getSearchResults(searchQuery);
        Mockito.doNothing().when(call).enqueue(Mockito.any(Callback.class));
        //Mockito.doReturn(call).when(gitHubService).getSearchResults(null);

        // trigger
        repository.getSearchResults(searchQuery, null);

        // validation
        Mockito.verify(gitHubService, Mockito.times(1)).getSearchResults(searchQuery);
    }

}
