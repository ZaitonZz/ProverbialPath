package com.example.proverbialpath;

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
            mtextView1 = itemView.findViewById(R.id.textView5);
            mtextView2 = itemView.findViewById(R.id.textView6);
        }
    }

    public SearchAdapter(ArrayList<SearchItem> searchList) {
        mSearchList = searchList;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
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
