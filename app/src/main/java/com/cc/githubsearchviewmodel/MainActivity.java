package com.cc.githubsearchviewmodel;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.EditorInfo;

import com.cc.githubsearchviewmodel.Contract.Injectable;
import com.cc.githubsearchviewmodel.adapters.SearchResultRvAdapter;
import com.cc.githubsearchviewmodel.applicationpack.GitHubSearchApplication;
import com.cc.githubsearchviewmodel.databinding.ActivityMainBinding;
import com.cc.githubsearchviewmodel.managers.AndroidMVVMSharedPrefManager;
import com.cc.githubsearchviewmodel.viewmodel.SearchViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements Injectable {

    private ActivityMainBinding binding;
    private SearchViewModel viewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    AndroidMVVMSharedPrefManager sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the content view (replacing `setContentView`)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        this.configureDagger();

        this.configureViewModel();

        searchEvent();

        binding.rvRepos.setHasFixedSize(true);

    }


    private void configureViewModel(){
        //String userLogin = getArguments().getString(UID_KEY);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SearchViewModel.class);

        //viewModel.init(binding.etSearchQuery.getText().toString());

        viewModel.getSearchResults().observe(this, searchResponse -> {

            // Update UI here

            if(searchResponse != null && searchResponse.getSearchResults() != null && searchResponse.getSearchResults().size() > 0) {

                SearchResultRvAdapter rvAdapter = new SearchResultRvAdapter(searchResponse.getSearchResults());
                binding.rvRepos.setAdapter(rvAdapter);
            }

        });
    }


    // -----------------
    // CONFIGURATION
    // -----------------

    private void configureDagger(){
        AndroidInjection.inject(this);
    }


    private void searchEvent() {

        // Search Event
        binding.etSearchQuery.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.searchGitHubRepos(binding.etSearchQuery.getText().toString());
                return true;
            }
            return false;
        });


    }
}
