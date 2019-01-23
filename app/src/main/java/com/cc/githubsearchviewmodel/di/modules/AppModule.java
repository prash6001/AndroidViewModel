package com.cc.githubsearchviewmodel.di.modules;

import com.cc.githubsearchviewmodel.Contract.GitHubService;
import com.cc.githubsearchviewmodel.repository.SearchRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public class AppModule {

    // --- REPOSITORY INJECTION ---

    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Provides
    @Singleton
    SearchRepository provideSearchRepository(GitHubService webservice,Executor executor) {
        return new SearchRepository(webservice,executor);
    }

    // --- NETWORK INJECTION ---

    private static String BASE_URL = "https://api.github.com/";

    @Provides
    Gson provideGson() { return new GsonBuilder().create(); }

    @Provides
    Retrofit provideRetrofit(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    GitHubService provideApiWebservice(Retrofit restAdapter) {
        return restAdapter.create(GitHubService.class);
    }
}
