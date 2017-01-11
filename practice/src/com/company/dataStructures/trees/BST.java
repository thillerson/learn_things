package com.company.dataStructures.trees;

public class BST {
    private Node root;

    public BST(Node root) {
        assert root != null;
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public BST insert(Node node) {
        assert node != null;
        return this;
    }

}
