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
    //removeDupes(head);
    //System.out.printf("After dedupe: %s\n", head);
    //System.out.printf("Third to last: %s\n", kthToLastNode(node, 3));
    head = new Node("f");
    node = new Node("z");
    head.next = node;
    node.next = new Node("a");
    node = node.next;
    node.next = new Node("c");
    node = node.next;
    node.next = new Node("b");
    node = node.next;
    node.next = new Node("e");
    node = node.next;
    node.next = new Node("f");
    //System.out.printf("Before: %s\n", head);
    //System.out.printf("After: %s\n", removeMiddleNode(head, "c"));
    //System.out.printf("Partitioned: %s\n", partitionList(head, "Z"));
    testSum();
  }

  private static void testSum() {
    Node<Integer> left = new Node<>(7);
    left.next = new Node(1);
    left.next.next = new Node(6);
    Node<Integer> right = new Node<>(5);
    right.next = new Node(9);
    right.next.next = new Node(2);
    System.out.printf("Sum = %s", sumLists(left, right));
  }

  public static Node<Integer> sumLists(Node<Integer> left, Node<Integer> right) {
    int sum = 0, toCarry = 0;
    Node<Integer> leftPointer = left,
                  rightPointer = right,
                  sumHead = null,
                  sumPointer = null;
    sum = leftPointer.value + rightPointer.value;
    sumHead = new Node<>(sum);
    sumPointer = sumHead;
    do {
      sum = leftPointer.value + rightPointer.value;
      sumPointer.next = new Node<>(sum);
      sumPointer = sumPointer.next;
      leftPointer = leftPointer.next;
      rightPointer = rightPointer.next;
    } while (leftPointer != null && rightPointer != null);
    return sumHead;
  }

  public static <T extends Comparable<T>> Node<T> partitionList(Node<T> head, T partitionPoint) {
    if (head == null || partitionPoint == null) return head;
    Node<T> newHead = head,
            current = head,
            previous = null,
            partitionList = null,
            partitionEnd = null;
    do {
      if (current.value.compareTo(partitionPoint) >= 0) {
        // if the head is being partitioned, move the new head
        if (current == newHead) {
          newHead = newHead.next;
        }
        // unhook current node from previous
        if (previous != null) {
          previous.next = current.next;
        }
        // place in partition list
        if (partitionList == null) {
          partitionList = current;
          partitionEnd = current;
        } else {
          partitionEnd.next = current;
          partitionEnd = partitionEnd.next;
        }
        // move current, keeping previous the same
        current = current.next;
        // un-hook the removed node's next
        partitionEnd.next = null;
      } else {
        // move previous
        previous = current;
        // move current
        current = current.next;
      }
    } while (current != null);
    if (previous != null) {
      previous.next = partitionList;
    }

    if (newHead == null) newHead = head;
    return newHead;
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
