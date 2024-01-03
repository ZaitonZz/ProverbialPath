package com.example.proverbialpath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ArrayList<SearchItem> searchList = new ArrayList<>();
        searchList.add(new SearchItem("Chapter 1  -", "Verse 1"));
        searchList.add(new SearchItem("Chapter 2  -", "Verse 3"));

        mRecycleView = findViewById(R.id.search_recycle_view);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new SearchAdapter(searchList);

        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);
    }
}