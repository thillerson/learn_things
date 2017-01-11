package com.company.dataStructures.graphs;

import java.util.HashSet;
import java.util.Set;

public class Node {
    public Node(String name) {
        this.name = name;
    }

    public String name;
    public Set<Node> neigbors = new HashSet<>();
}
