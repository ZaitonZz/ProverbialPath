package com.example.proverbialpath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;

public class ReadActivity extends AppCompatActivity {

    private LinkedList<AVLTree> avlTrees;
    private String chapter;
    TextView verses, chapterTitle, chapterNavBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        avlTrees = new LinkedList<>();
        populateLinkedList();
        hideSystemUI();

        verses = findViewById(R.id.proverbs_verse);
        chapterTitle = findViewById(R.id.chapter_title);
        chapterNavBar = findViewById(R.id.navbar_chap_read);

        Intent intent = getIntent();
        chapter = intent.getStringExtra("chapter");

        updateTextViews();
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();

        // Set flags for a transparent status bar
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;

        decorView.setSystemUiVisibility(uiOptions);

        // Set window flags for a transparent status bar
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }

    private void updateTextViews() {
        AVLTree temp = avlTrees.get(Integer.parseInt(chapter) - 1);
        StringBuilder builder = new StringBuilder();
        int j = 1;
        while (temp.findMax().getVerse() > j){
            AVLNode temp2 = temp.searchNode(j);
            builder.append(temp2.getVerse()).append("- ").append(temp2.getFormattedText()).append("\n");
            j++;
        }
        verses.setText(builder.toString());
        chapterTitle.setText("Chapter " + Integer.parseInt(chapter));
        chapterNavBar.setText("Chapter " + Integer.parseInt(chapter));
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
    public void back(View view){
        super.onBackPressed();
    }
}