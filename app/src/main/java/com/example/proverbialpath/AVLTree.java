package com.example.proverbialpath;

import java.util.ArrayList;
import java.util.List;

public class AVLTree {
    private AVLNode root;

    public AVLTree() {
    }

    public AVLTree(AVLNode root) {
        this.root = root;
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
        return getHeight(root);
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

    public AVLNode searchNode(int lookingFor){
        return searchNode(lookingFor, root);
    }

    public AVLNode searchNode(int lookingFor, AVLNode node) {
        if (node == null) {
            return null;
        }

        if (lookingFor < node.getVerse()) {
            return searchNode(lookingFor, node.getLeftNode());
        } else if (lookingFor > node.getVerse()) {
            return searchNode(lookingFor, node.getRightNode());
        } else {
            return node;
        }
    }

    public void insert(AVLNode newNode) {
        root = insert(root, newNode);
    }
    public List<AVLNode> inOrder() {
        List<AVLNode> verseList = new ArrayList<>();
        inOrderTraverse(root, verseList);
        return verseList;
    }

    public void inOrderTraverse(AVLNode root, List<AVLNode> list) {
        if (root != null) {
            inOrderTraverse(root.getLeftNode(), list);
            list.add(root);
            inOrderTraverse(root.getRightNode(), list);
        }
    }

}
