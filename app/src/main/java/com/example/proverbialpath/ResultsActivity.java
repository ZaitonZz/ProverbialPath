package com.example.proverbialpath;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedList;

public class ResultsActivity extends AppCompatActivity {
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String query;
    private LinkedList<AVLTree> avlTrees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        query = intent.getStringExtra("query");
        ArrayList<SearchItem> searchList = new ArrayList<>();
        avlTrees = new LinkedList<>();
        populateLinkedList();
        populateDisplay(searchList);
        hideSystemUI();

        mRecycleView = findViewById(R.id.search_recycle_view);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new SearchAdapter(searchList);

        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();

        // Set flags for a transparent status bar
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        ;

        decorView.setSystemUiVisibility(uiOptions);

        // Set window flags for a transparent status bar
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }

    private void populateDisplay(ArrayList<SearchItem> searchList) {
        for (int i = 0; i < 31; i++) {
            AVLTree temp = avlTrees.get(i);
            int j = 1;
            AVLNode avlNode = temp.searchNode(j);
            while (avlNode != null){
                if (avlNode.contains(query)!= null){
                    searchList.add(new SearchItem("Proverbs " + (i+1)
                            + ":" + avlNode.getVerse(), avlNode.getFormattedText()));
                }
                avlNode = temp.searchNode(j);
                j++;
            }
        }
    }

    private void populateLinkedList() {
        try (InputStream inputStream = getResources().openRawResource(R.raw.proverbsdata);
             Reader reader = new InputStreamReader(inputStream);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {

            for (CSVRecord record : csvParser) {
                if (avlTrees.size() < Integer.parseInt(record.get(0))) {
                    AVLTree temp = new AVLTree();
                    avlTrees.add(temp);
                }
                AVLNode temp = new AVLNode(Integer.parseInt(record.get(1)), record.get(2), record.get(3), record.get(4));
                avlTrees.get(Integer.parseInt(record.get(0)) - 1).insert(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}