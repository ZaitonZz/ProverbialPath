package com.example.proverbialpath;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    private ArrayList<SearchItem> mSearchList;

    public static class SearchViewHolder extends RecyclerView.ViewHolder {
        public TextView mtextView1;
        public TextView mtextView2;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            mtextView1 = itemView.findViewById(R.id.chapter_num_item);
            mtextView2 = itemView.findViewById(R.id.verse_num_item);
        }
    }

    public SearchAdapter(ArrayList<SearchItem> searchList) {
        mSearchList = searchList;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item, parent, false);
        SearchViewHolder searchViewHolder = new SearchViewHolder(v);
        return searchViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        SearchItem currentItem = mSearchList.get(position);

        holder.mtextView1.setText(currentItem.getText1());
        holder.mtextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mSearchList.size();
    }
}
