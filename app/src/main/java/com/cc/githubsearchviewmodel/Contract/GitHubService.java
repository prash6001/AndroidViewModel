package com.cc.githubsearchviewmodel.Contract;

import com.cc.githubsearchviewmodel.models.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface GitHubService {

    /**
     * @GET declares an HTTP GET request
     * @Path("user") annotation on the userId parameter marks it as a
     * replacement for the {user} placeholder in the @GET path
     */
    //@GET("/users/{user}")
    //Call<User> getUser(@Path("user") String userId);

    /**
     * Search with topics supported https://developer.github.com/v3/search/
     * @param term search keywords e.g. "testing topic:android"
     * @return
     */
    @Headers({"Accept: application/vnd.github.mercy-preview+json"})
    @GET("search/repositories")
    Call<SearchResponse> getSearchResults(@Query("q") String term);
}
