package com.example.proverbialpath;

import java.util.ArrayList;
import java.util.List;

public class AVLTree {
    private AVLNode rootNode;

    public AVLTree() {
    }

    public AVLTree(AVLNode rootNode) {
        this.rootNode = rootNode;
    }

    public AVLNode insert(AVLNode root, AVLNode newNode){
        if (root == null) {
            root = newNode;
            return root;
        } else if (root.getVerse() > newNode.getVerse()){
            root.setLeftNode(insert(root.getLeftNode(), newNode));
        } else if (root.getVerse() < newNode.getVerse()){
            root.setRightNode(insert(root.getRightNode(), newNode));
        }
        int balanceFactor = getBalanceFactor(root);
        if (balanceFactor > 1 && newNode.getVerse() < root.getLeftNode().getVerse()) {
            return rotateRight(root);
        } else if (balanceFactor < -1 && newNode.getVerse() > root.getRightNode().getVerse()) {
            return rotateLeft(root);
        } else if (balanceFactor > 1 && newNode.getVerse() > root.getLeftNode().getVerse()) {
            root.setLeftNode(rotateLeft(root.getLeftNode()));
            return rotateRight(root);
        } else if (balanceFactor < -1 && newNode.getVerse() < root.getRightNode().getVerse()) {
            root.setRightNode(rotateRight(root.getRightNode()));
            return rotateLeft(root);
        }
        return root;
    }

    private AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.getLeftNode();
        AVLNode T2 = x.getRightNode();

        // Perform rotation
        x.setRightNode(y);
        y.setLeftNode(T2);

        return x;
    }

    private AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.getRightNode();
        AVLNode T2 = y.getLeftNode();

        // Perform rotation
        y.setLeftNode(x);
        x.setRightNode(T2);

        return y;
    }

    private int getBalanceFactor(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeftNode()) - getHeight(node.getRightNode());
    }

    public int getHeight(){
        return getHeight(rootNode);
    }

    public int getHeight(AVLNode node){
        if (node == null) {
            return -1;
        } else{
            return 1 + Math.max(getHeight(node.getLeftNode()), getHeight(node.getRightNode()));
        }
    }

    public boolean isFound(int lookingFor, AVLNode node){
        return searchNode(lookingFor, node) ==  null;
    }

    public AVLNode searchNode(int node){
        return searchNode(node, rootNode);
    }

    public AVLNode searchNode(int node, AVLNode rootNode) {
        if (rootNode == null) {
            return null;
        }

        if (node < rootNode.getVerse()) {
            return searchNode(node, rootNode.getLeftNode());
        } else if (node > rootNode.getVerse()) {
            return searchNode(node, rootNode.getRightNode());
        } else {
            return rootNode;
        }
    }

    public void insert(AVLNode newNode) {
        rootNode = insert(rootNode, newNode);
    }
    public List<AVLNode> inOrder() {
        List<AVLNode> verseList = new ArrayList<>();
        inOrderTraverse(rootNode, verseList);
        return verseList;
    }

    public void inOrderTraverse(AVLNode root, List<AVLNode> list) {
        if (root != null) {
            inOrderTraverse(root.getLeftNode(), list);
            list.add(root);
            inOrderTraverse(root.getRightNode(), list);
        }
    }

    public AVLNode findMax(){
        return findMax(rootNode);
    }

    public AVLNode findMax(AVLNode root){
        if(root==null) return null;
        else if(root.getRightNode()==null) return root;
        return findMax(root.getRightNode());
    }

    public AVLNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(AVLNode rootNode) {
        this.rootNode = rootNode;
    }
}
