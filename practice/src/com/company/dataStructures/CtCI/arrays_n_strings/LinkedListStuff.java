package com.company.dataStructures.CtCI.arrays_n_strings;

import java.util.HashSet;
import java.util.Set;

public class LinkedListStuff {

  public static class Node<T> {
    public Node next;
    public T value;

    @Override
    public String toString() {
      return "Node{" +
        "next=" + next +
        ", value=" + value +
        '}';
    }

    public Node(T value) {
      this.value = value;
    }
  }

  public static void main(String[] args) {
    Node<String> node;
    Node<String> head = new Node("first");
    node = new Node("second");
    head.next = node;
    node.next = new Node("second");
    node = node.next;
    node.next = new Node("third");
    node = node.next;
    node.next = new Node("fourth");
    node = node.next;
    node.next = new Node("third");
    removeDupes(head);
    //System.out.printf("After dedupe: %s\n", head);
    //System.out.printf("Third to last: %s\n", kthToLastNode(node, 3));
    head = new Node("a");
    node = new Node("b");
    head.next = node;
    node.next = new Node("c");
    node = node.next;
    node.next = new Node("c");
    node = node.next;
    node.next = new Node("d");
    node = node.next;
    node.next = new Node("e");
    node = node.next;
    node.next = new Node("f");
    //System.out.printf("Before: %s\n", head);
    //System.out.printf("After: %s\n", removeMiddleNode(head, "c"));
  }

  public static <T> Node<T> kthToLastNode(Node<T> head, int k) {

    Node<T> current = head,
            drogue  = null;
    int distance    = 0;
    do {
      distance++;
      if (distance == k) {
        drogue = head;
      } else if (distance > k) {
        drogue = drogue.next;
      }
      current = current.next;
    } while(current != null);

    return drogue;
  }

  public static <T> void removeDupes(Node<T> head) {
    Set<T> existingValues = new HashSet<>();
    Node<T> current = head;
    Node<T> previous = head;
    do {
      if (existingValues.contains(current.value)) {
        previous.next = current.next;
      } else {
        existingValues.add(current.value);
      }
      previous = current;
      current = current.next;
    } while (current != null);
  }

}
