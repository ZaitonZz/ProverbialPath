package com.example.proverbialpath;

public class SearchItem {
    private int mImageResource;
    private String mText1;
    private String mText2;

    public SearchItem(String text1, String text2) {
        mText1 = text1;
        mText2 = text2;
    }

    public String getText1() {
        return mText1;
    }

    public String getText2() {
        return mText2;
    }
}
