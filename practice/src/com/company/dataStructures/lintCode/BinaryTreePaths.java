package com.company.dataStructures.lintCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreePaths {

  public static class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
      this.val = val;
      this.left = this.right = null;
    }
  }

  public class Path {
    private List<TreeNode> pathList = new ArrayList<>();
    public Path copy() {
      Path newPath = new Path();
      newPath.pathList = new ArrayList<>(this.pathList);
      return newPath;
    }
    public void addStep(TreeNode node) {
      pathList.add(node);
    }
    @Override public String toString() {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < pathList.size(); i++) {
        TreeNode node = pathList.get(i);
        sb.append(node.val);
        if (i < pathList.size()-1) {
          sb.append("->");
        }
      }
      return sb.toString();
    }
  }

  public static void test() {
    BinaryTreePaths solution = new BinaryTreePaths();
    TreeNode one = new TreeNode(1);
    one.left = new TreeNode(2);
    one.right = new TreeNode(3);
    one.left.right = new TreeNode(5);

    List<String> paths = solution.binaryTreePaths(one);
    paths.stream().forEach(s -> System.out.println(s));
  }

  public List<String> binaryTreePaths(TreeNode root) {
    List<Path> leafPaths = new ArrayList<>();
    findPathsToLeafFromNode(root, new Path(), leafPaths);

    List<String> pathStrings = leafPaths.stream()
        .map(Path::toString)
        .collect(Collectors.toList());

    return pathStrings;
  }

  private void findPathsToLeafFromNode(TreeNode node, Path parentPath, List<Path> leafPaths) {
    Path currentPath = parentPath.copy();
    currentPath.addStep(node);
    if (isLeaf(node)) {
      leafPaths.add(currentPath);
    } else {
      if (node.left != null) {
        findPathsToLeafFromNode(node.left, currentPath, leafPaths);
      }
      if (node.right != null) {
        findPathsToLeafFromNode(node.right, currentPath, leafPaths);
      }
    }
  }


  private boolean isLeaf(TreeNode candidate) {
    return candidate.left == null && candidate.right == null;
  }
}
