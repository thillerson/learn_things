package com.company.dataStructures.trees;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BSTTest {

    @Test
    public void testGetRoot() throws Exception {
        Node root = new Node(1);
        BST tree = new BST(root);
        assertEquals(root, tree.getRoot(), "Root of tree should be what was set upon tree creation.");
    }

    @Test public void testInsert() throws Exception {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        BST tree = new BST(one);
        tree.insert(two);
        tree.insert(three);

        assertEquals(two, tree.getRoot(), "Expected root node to be two.");
        assertEquals(one, tree.getRoot().getLeft(), "Expected root node's left node to be one.");
        assertEquals(three, tree.getRoot().getRight(), "Expected root node's right node to be three.");
    }

}