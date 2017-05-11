package com.company;

import com.company.dataStructures.arrays.*;
import com.company.dataStructures.graphs.Graph;
import com.company.dataStructures.graphs.Node;
import com.company.dataStructures.linkedLists.LinkedLists;
import com.company.dataStructures.lintCode.Islands;
import com.company.khan.recursion.Palindromes;

import java.util.Arrays;
import java.util.Optional;

public class Main {

  public static void main(String[] args) {
    //graphTraversal();
    //lintCode();
    //selectionSort();
    //insertionSort();
    //linkedLists();
    //binarySearch();
    //palindrome();
    //mergeSort();
    quickSort();
  }

  private static void graphTraversal() {
    Graph graph = new Graph();
    Node a = new Node("A");
    Node b = new Node("B");
    Node c = new Node("C");
    Node d = new Node("D");
    Node e = new Node("E");
    graph.addEdge(a, b);
    graph.addEdge(a, c);
    graph.addEdge(b, c);
    graph.addEdge(b, d);
    graph.addEdge(c, e);
    graph.addEdge(d, e);
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
    int[] list = new int[]{2, 4, 6, 7, 9, 11, 13, 44, 57, 60, 67, 77, 90, 99, 101, 123, 127, 660};
    //int[] list = new int[] {1,2,3};
    boolean found = BinarySearch.listContains(660, list);
    System.out.printf("\nFound 67: %s", found);
  }

  private static void selectionSort() {
    int[] list = {9000, 3,7,2,9,23,100};
    SelectionSort.sort(list);
    System.out.printf("[selection] sorted list: %s\n", Arrays.toString(list));
  }

  private static void insertionSort() {
    int[] list = {-9000, 3,7,2,9,23,100};
    InsertionSort.sort(list);
    System.out.printf("[insertion] sorted list: %s\n", Arrays.toString(list));
  }

  private static void mergeSort() {
    int[] list = {-9000, 3,7,2,9,23,100};
    MergeSort.mergeSort(list);
    System.out.printf("[merge] sorted list: %s\n", Arrays.toString(list));
  }

  private static void quickSort() {
    int[] list = {-9000, 3,7,2,9,23,100};
    QuickSort.quickSort(list);
    System.out.printf("[quick] sorted list: %s\n", Arrays.toString(list));
  }

  private static void linkedLists() {
    LinkedLists.LinkedListNode farend = new LinkedLists.LinkedListNode("d", Optional.empty() );
    LinkedLists.LinkedListNode end = new LinkedLists.LinkedListNode("c", Optional.of(farend) );
    LinkedLists.LinkedListNode middle = new LinkedLists.LinkedListNode("b", Optional.of(end));
    LinkedLists.LinkedListNode start = new LinkedLists.LinkedListNode("a", Optional.of(middle));
    System.out.printf("before: %s\n", start);
    LinkedLists.LinkedListNode reversed = LinkedLists.reverse(start);
    System.out.printf("reversed: %s\n", reversed);
  }

  private static void palindrome() {
    System.out.printf("rotor is palindrome? %s\n", Palindromes.test("rotor"));
    System.out.printf("poop is palindrome? %s\n", Palindromes.test("poop"));
    System.out.printf("pothead is palindrome? %s\n", Palindromes.test("pothead"));
    System.out.printf("a is palindrome? %s\n", Palindromes.test("a"));
    System.out.printf("zoom is palindrome? %s\n", Palindromes.test("zoom"));
    System.out.printf("rot is palindrome? %s\n", Palindromes.test("rot"));
  }


}
