package com.company;

import com.company.dataStructures.arrays.MergeSort;
import com.company.dataStructures.graphs.Graph;
import com.company.dataStructures.graphs.Node;
import com.company.dataStructures.lintCode.BinaryTreePaths;
import com.company.dataStructures.lintCode.Islands;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    //graphTraversal();
    //lintCode();
    mergeSortPractice();
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
    //Islands.scanMatrix();
  }

  private static void mergeSortPractice() {
    int[] testData;
    testData = new int[]{1};
    testData = new int[] {};
    testData = new int[] {1,2,3,4};
    //testData = new int[] {3,6,8,2,7,9,0,22,100,5};
    MergeSort.sort(testData);

    System.out.printf("Ordered: %s", Arrays.toString(testData));
  }

}
