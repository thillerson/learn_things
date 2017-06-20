package com.company.dataStructures.CtCI.arrays_n_strings;

import java.util.*;

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
    //testSum();
    //testPalindrome();
    testIntersection();
  }

  private static void testIntersection() {
    Node<Character> head, node;
    head = new Node('b');
    node = new Node('o');
    head.next = node;
    node.next = new Node('o');
    node = node.next;
    node.next = new Node('z');
    System.out.printf("Intersects at? : %s\n", findIntersection(head, head.next));
  }

  private static void testPalindrome() {
    Node<Character> head, node;
    head = new Node('b');
    node = new Node('o');
    head.next = node;
    node.next = new Node('o');
    node = node.next;
    node.next = new Node('z');
    System.out.printf("Palindrome? : %s\n", isPalindrome(head));
  }

  private static void testSum() {
    Node<Integer> left = new Node<>(7);
    left.next = new Node(1);
    left.next.next = new Node(6);
    Node<Integer> right = new Node<>(5);
    right.next = new Node(9);
    right.next.next = new Node(2);
    System.out.printf("Sum = %s", sumInOrderLists(left, right));
  }

  private static <T> Node<T> findIntersection(Node<T> left, Node<T> right) {
    if (left == null || right == null) return null;
    Node<T> leftPointer = left,
            rightPointer = right;
    int leftLength = listLength(left),
        rightLength = listLength(right);
    if (leftLength > rightLength) {
      leftPointer = nodeAt(left, leftLength - rightLength);
    } else {
      rightPointer = nodeAt(right, rightLength - leftLength);
    }
    do {
      if (leftPointer == rightPointer) {
        return leftPointer;
      }
      if (rightPointer != null) rightPointer = rightPointer.next;
      if (leftPointer != null) leftPointer = leftPointer.next;
    } while(leftPointer != null && rightPointer != null);
    return null;
  }

  private static <T> Node<T> nodeAt(Node<T> list, int index) {
    if (list == null) return list;
    Node<T> pointer = list;
    do {
      if (index == 0) return pointer;
      index--;
      pointer = pointer.next;
    } while(pointer != null);
    return null;
  }

  private static <T> int listLength(Node<T> list) {
    int length = 0;
    Node<T> pointer = list;
    if (pointer != null) {
      do {
        length++;
        pointer = pointer.next;
      } while (pointer != null);
    }
    return length;
  }

  public static boolean isPalindrome(Node<Character> head)  {
    if (head == null || head.next == null) return false;
    Node<Character> pointer = head;
    Stack<Character> reversed = new Stack<>();
    do {
      reversed.push(pointer.value);
      pointer = pointer.next;
    } while (pointer != null);
    pointer = head;
    boolean possibleMiddleReached = false;
    do {
      char  left = pointer.value,
            right = reversed.pop();
      if (left != right) {
        if (possibleMiddleReached) return false;
        possibleMiddleReached = true;
      }
      pointer = pointer.next;
    } while (pointer != null);
    return true;
  }

  public static boolean isPalindromePermutation(Node<Character> head) {
    if (head == null || head.next == null) return false;
    Map<Character, Integer> counts = new HashMap<>();
    Node<Character> pointer = head;
    do {
      if ( !counts.containsKey(pointer.value)) {
        System.out.printf("Setting %s to %s:\n", pointer.value, 1);
        counts.put(pointer.value, 1);
      } else {
        int count = counts.get(pointer.value);
        counts.put(pointer.value, ++count);
        System.out.printf("Setting %s to %s:\n", pointer.value, count);
      }
      pointer = pointer.next;
    } while (pointer != null);

    int countOfOdds = 0;
    for (Integer count : counts.values()) {
      if (count % 2 != 0) {
        countOfOdds++;
        if (countOfOdds > 1) {
          return false;
        }
      }
    }
    return true;
  }

  public static Node<Integer> sumInOrderLists(Node<Integer> left, Node<Integer> right) {
    Stack<Integer> rawSums = new Stack<>();
    Node<Integer> newSumHead = null,
                  newSumPointer = null,
                  newSum = null,
                  leftPointer = left,
                  rightPointer = right;
    int carry = 0, leftSum = 0, rightSum = 0, rawSum;
    do {
      leftSum = (leftPointer == null) ? 0 : leftPointer.value;
      rightSum = (rightPointer == null) ? 0 : rightPointer.value;
      rawSums.push(leftSum + rightSum);
      leftPointer = leftPointer.next;
      rightPointer = rightPointer.next;
    } while (leftPointer != null && rightPointer != null);

    while(!rawSums.empty()) {
      rawSum = rawSums.pop() + carry;
      if (rawSum > 9) {
        rawSum -= 10;
        carry = 1;
      } else {
        carry = 0;
      }
      newSum = new Node<>(rawSum);
      if (newSumHead == null) {
        newSumHead = newSumPointer = newSum;
      } else {
        newSumPointer.next = newSum;
        newSumPointer = newSumPointer.next;
      }
      if (rawSums.empty() && carry == 1) {
        rawSums.push(carry);
        carry = 0;
      }
    }

    return newSumHead;
  }

  public static Node<Integer> sumReverseOrderLists(Node<Integer> left, Node<Integer> right) {
    int sum = 0, toCarry = 0;
    Node<Integer> leftPointer = left,
                  rightPointer = right,
                  sumHead = null,
                  sumPointer = null;
    do {
      if (leftPointer == null && rightPointer == null) {
        sum = toCarry;
      } else {
        sum = leftPointer.value + rightPointer.value + toCarry;
        leftPointer = leftPointer.next;
        rightPointer = rightPointer.next;
      }
      toCarry = 0;
      if (sum > 9) {
        sum -= 10;
        toCarry++;
      }
      Node<Integer> newSumPosition = new Node<>(sum);
      if (sumHead == null) {
        sumHead = sumPointer = newSumPosition;
      } else {
        sumPointer.next = newSumPosition;
        sumPointer = sumPointer.next;
      }
    } while (leftPointer != null && rightPointer != null && toCarry > 0);
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
