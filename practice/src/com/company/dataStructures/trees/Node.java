package com.company.dataStructures.trees;

import java.util.Optional;

public class Node {

    private Integer value;
    private Optional<Node> left;
    private Optional<Node> right;

    public Node(Integer value) {
        this.value = value;
        this.left = Optional.empty();
        this.right = Optional.empty();
    }

    public Integer getValue() {
        return value;
    }

    public Optional<Node> getLeft() {
        return left;
    }

    public void setLeft(Optional<Node> left) {
        this.left = left;
    }

    public Optional<Node> getRight() {
        return right;
    }

    public void setRight(Optional<Node> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

}
