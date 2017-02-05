package com.company;

import com.company.dataStructures.arrays.BinarySearch;
import com.company.dataStructures.graphs.Graph;
import com.company.dataStructures.graphs.Node;
import com.company.dataStructures.lintCode.BinaryTreePaths;
import com.company.dataStructures.lintCode.Islands;

public class Main {

    public static void main(String[] args) {
        //graphTraversal();
        //lintCode();
        binarySearch();
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
        //BinaryTreePaths.test();
        Islands.scanMatrix();
    }

    private static void binarySearch() {
      int[] list = new int[] {2,4,6,7,9,11,13,44,57,60,67,77,90,99,101,123,127,660};
      //int[] list = new int[] {1,2,3};
      boolean found = BinarySearch.listContains(660, list);
      System.out.printf("\nFound 67: %s", found);
    }

}
