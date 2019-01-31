package com.cc.githubsearchviewmodel.di.modules;

import android.content.Context;

import com.cc.githubsearchviewmodel.Contract.GitHubService;
import com.cc.githubsearchviewmodel.database.dao.SearchResultDao;
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

import static com.cc.githubsearchviewmodel.applicationpack.GitHubSearchApplication.context;

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Singleton
    @Provides
    public Context provideContext(){
        return context;
    }

    // --- EXECUTOR INJECTION ---
    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    // --- REPOSITORY INJECTION ---
    @Provides
    @Singleton
    SearchRepository provideSearchRepository(GitHubService webservice,Executor executor, SearchResultDao searchResultDao) {
        return new SearchRepository(webservice,executor,searchResultDao);
    }

    // --- NETWORK INJECTION ---

    @Provides
    Gson provideGson() { return new GsonBuilder().create(); }

    @Provides
    Retrofit provideRetrofit(Gson gson) {
        String BASE_URL = "https://api.github.com/";
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
    }

    @Provides
    @Singleton
    GitHubService provideApiWebservice(Retrofit restAdapter) {
        return restAdapter.create(GitHubService.class);
    }

}
