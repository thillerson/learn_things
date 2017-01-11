package com.company;

import com.company.dataStructures.graphs.Graph;
import com.company.dataStructures.graphs.Node;
import com.company.dataStructures.lintCode.BinaryTreePaths;

public class Main {

    public static void main(String[] args) {
        //graphTraversal();
        lintCode();
    }

    private static void graphTraversal() {
        Graph graph = new Graph();
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        graph.addVertex(a, b);
        graph.addVertex(a, c);
        graph.addVertex(b, c);
        graph.addVertex(b, d);
        graph.addVertex(c, e);
        graph.addVertex(d, e);
        System.out.println("Breadth first:");
        Graph.BFS(a);
        System.out.println("\nDepth first loop:");
        Graph.DFSLoop(a);
        System.out.println("\nDepth first recursive:");
        Graph.DFSRecursive(a);
        System.out.println("\nDepth first functional:");
        Graph.DFSFunctional(a);
    }

    private static void lintCode() {
        BinaryTreePaths.test();
    }
}
