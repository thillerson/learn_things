package com.company.dataStructures.arrays;

public class BinarySearch {

  public static boolean listContains(int target, int[] list) {
    return listContainsInRange(target, list, 0, list.length - 1);
  }

  private static boolean listContainsInRange(int target, int[] list, int min, int max) {
    int midpoint = (max + min) / 2;
    int candidate = list[midpoint];
    System.out.printf("midpoint: %s, candidate: %s, min: %s, max %s\n", midpoint, candidate, min, max);
    if (candidate == target) {
      return true;
    } else if (min >= max) {
      return  false;
    } else if (target > candidate) {
      System.out.println("Target is greater than candidate, search right");
      return listContainsInRange(target, list, midpoint + 1, max);
    } else if (target < candidate) {
      System.out.println("Target is less than candidate, search left");
      return listContainsInRange(target, list, min, midpoint - 1);
    } else {
      return false;
    }
  }

}
