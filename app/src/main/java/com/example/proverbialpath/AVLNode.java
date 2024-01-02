package com.example.proverbialpath;

public class AVLNode {
    private AVLNode leftNode;
    private AVLNode rightNode;
    private int verse;
    private String unformattedText;
    private String formattedText;
    private String metaWordsKeywords;

    public AVLNode() {
    }

    public AVLNode(int verse, String unformattedText, String formattedText, String metaWordsKeywords) {
        this.verse = verse;
        this.unformattedText = unformattedText;
        this.formattedText = formattedText;
        this.metaWordsKeywords = metaWordsKeywords;
    }

    public AVLNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(AVLNode leftNode) {
        this.leftNode = leftNode;
    }

    public AVLNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(AVLNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getVerse() {
        return verse;
    }

    public void setVerse(int verse) {
        this.verse = verse;
    }

    public String getUnformattedText() {
        return unformattedText;
    }

    public void setUnformattedText(String unformattedText) {
        this.unformattedText = unformattedText;
    }

    public String getFormattedText() {
        return formattedText;
    }

    public void setFormattedText(String formattedText) {
        this.formattedText = formattedText;
    }

    public String getMetaWordsKeywords() {
        return metaWordsKeywords;
    }

    public void setMetaWordsKeywords(String metaWordsKeywords) {
        this.metaWordsKeywords = metaWordsKeywords;
    }
}
