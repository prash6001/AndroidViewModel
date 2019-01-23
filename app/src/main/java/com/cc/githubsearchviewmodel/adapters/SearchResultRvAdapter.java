package com.cc.githubsearchviewmodel.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cc.githubsearchviewmodel.R;
import com.cc.githubsearchviewmodel.models.SearchResult;

import java.util.ArrayList;
import java.util.List;

import hugo.weaving.DebugLog;

public class SearchResultRvAdapter extends RecyclerView.Adapter<SearchResultRvAdapter
        .SearchResultViewHolder> {
    private List<SearchResult> results;

    public SearchResultRvAdapter(List<SearchResult> list){
        this.results = list;
    }

    @Override
    public SearchResultViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new SearchResultViewHolder(inflater.inflate(R.layout.rv_item_repo, null));
    }

    @Override
    public void onBindViewHolder(SearchResultViewHolder holder,
                                 int position) {
        holder.bind(results.get(position));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    @DebugLog
    void updateResults(@NonNull List<SearchResult> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    static class SearchResultViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvRepoName;

        SearchResultViewHolder(View itemView) {
            super(itemView);

            tvRepoName = itemView.findViewById(R.id.tv_repo_name);
        }

        void bind(SearchResult searchResult) {
            tvRepoName.setText(searchResult.getFullName());
        }
    }
}
