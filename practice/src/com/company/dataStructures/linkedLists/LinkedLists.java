package com.company.dataStructures.linkedLists;

import java.util.Optional;

public class LinkedLists {

  public static class LinkedListNode {
    public String label;
    public Optional<LinkedListNode> next;

    @Override
    public String toString() {
      return "LinkedListNode{" +
        "label='" + label + '\'' +
        ", next=" + next +
        '}';
    }

    public LinkedListNode(String label, Optional<LinkedListNode> next) {
      this.label = label;
      this.next = next;
    }
  }

  public static LinkedListNode reverse(LinkedListNode start) {
    if (!start.next.isPresent()) {
      return start;
    }
    LinkedListNode next = start.next.get();
    start.next = Optional.empty();
    LinkedListNode newStart = reverse(next);
    next.next = Optional.of(start);
    return newStart;
  }


}
