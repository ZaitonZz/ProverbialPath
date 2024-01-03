package com.example.proverbialpath;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChaptersActivity extends AppCompatActivity {

    private String chapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideSystemUI();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.searchbar_chapters);
        autoCompleteTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    chapter = v.getText().toString();
                    startResults();
                    return true;
                }
                return false;
            }
        });
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();

        // Set flags for a transparent status bar
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;

        decorView.setSystemUiVisibility(uiOptions);

        // Set window flags for a transparent status bar
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }

    public void startResults(){
        Intent intent = new Intent(ChaptersActivity.this, ResultsActivity.class);
        intent.putExtra("query", chapter);
        startActivity(intent);
    }

    public void startRead(){
        Intent intent = new Intent(ChaptersActivity.this, ReadActivity.class);
        intent.putExtra("chapter", chapter);
        startActivity(intent);
    }
    public void button1(View view){
        chapter = "1";
        startRead();
    }
    public void button2(View view) {
        chapter = "2";
        startRead();
    }

    public void button3(View view) {
        chapter = "3";
        startRead();
    }

    public void button4(View view) {
        chapter = "4";
        startRead();
    }

    public void button5(View view) {
        chapter = "5";
        startRead();
    }

    public void button6(View view) {
        chapter = "6";
        startRead();
    }

    public void button7(View view) {
        chapter = "7";
        startRead();
    }

    public void button8(View view) {
        chapter = "8";
        startRead();
    }

    public void button9(View view) {
        chapter = "9";
        startRead();
    }

    public void button10(View view) {
        chapter = "10";
        startRead();
    }

    public void button11(View view) {
        chapter = "11";
        startRead();
    }

    public void button12(View view) {
        chapter = "12";
        startRead();
    }

    public void button13(View view) {
        chapter = "13";
        startRead();
    }

    public void button14(View view) {
        chapter = "14";
        startRead();
    }

    public void button15(View view) {
        chapter = "15";
        startRead();
    }

    public void button16(View view) {
        chapter = "16";
        startRead();
    }

    public void button17(View view) {
        chapter = "17";
        startRead();
    }

    public void button18(View view) {
        chapter = "18";
        startRead();
    }

    public void button19(View view) {
        chapter = "19";
        startRead();
    }

    public void button20(View view) {
        chapter = "20";
        startRead();
    }

    public void button21(View view) {
        chapter = "21";
        startRead();
    }

    public void button22(View view) {
        chapter = "22";
        startRead();
    }

    public void button23(View view) {
        chapter = "23";
        startRead();
    }

    public void button24(View view) {
        chapter = "24";
        startRead();
    }

    public void button25(View view) {
        chapter = "25";
        startRead();
    }

    public void button26(View view) {
        chapter = "26";
        startRead();
    }

    public void button27(View view) {
        chapter = "27";
        startRead();
    }

    public void button28(View view) {
        chapter = "28";
        startRead();
    }

    public void button29(View view) {
        chapter = "29";
        startRead();
    }

    public void button30(View view) {
        chapter = "30";
        startRead();
    }

    public void button31(View view) {
        chapter = "31";
        startRead();
    }

}
