package com.company.dataStructures.graphs;

import java.util.*;

public class Graph {

    public Set<Node> nodes;

    public Graph() {
        nodes = new HashSet<>();
    }

    public int getSize() {
        return nodes.size();
    }

    public void addEdge(Node from, Node to) {
        assert from != null;
        assert to != null;
        from.neigbors.add(to);
        nodes.add(from);
        nodes.add(to);
    }

    public static void BFS(Node start) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> toVisit = new LinkedList<>();
        toVisit.add(start);
        visited.add(start);
        while (!toVisit.isEmpty()) {
            Node current = toVisit.remove();
            System.out.printf("Visited node: %s\n", current.name);
            for (Node neighbor : current.neigbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    toVisit.add(neighbor);
                }
            }
        }
    }

    public static void DFSLoop(Node start) {
        Set<Node> visited = new HashSet<>();
        Stack<Node> toVisit = new Stack<>();
        toVisit.add(start);
        visited.add(start);
        while (!toVisit.isEmpty()) {
            Node current = toVisit.pop();
            System.out.printf("Visited node: %s\n", current.name);
            for (Node neighbor : current.neigbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    toVisit.add(neighbor);
                }
            }
        }
    }

    public static void DFSRecursive(Node start) {
        Set<Node> visited = new HashSet<>();
        DFSRecurse(start, visited);
    }

    private static void DFSRecurse(Node current, Set<Node> visited) {
        System.out.printf("Visited node: %s\n", current.name);
        for (Node neighbor : current.neigbors) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                DFSRecurse(neighbor, visited);
            }
        }
    }

    public static void DFSFunctional(Node start) {
        Set<Node> visited = new HashSet<>();
        Stack<Node> toVisit = new Stack<>();
        toVisit.add(start);
        visited.add(start);
        while (!toVisit.empty()) {
            Node current = toVisit.pop();
            System.out.printf("Visited node: %s\n", current.name);
            current.neigbors.stream()
                    .filter(node -> !visited.contains(node))
                    .forEach(node -> {
                      visited.add(node);
                      toVisit.add(node);
                    });
        }
    }


}
