package com.company.dataStructures.arrays;

import java.util.Arrays;

public class MergeSort {

  public static void mergeSort(int[] a) {
    sort(a, 0, a.length - 1);
  }

  private static void sort(int[] a, int left, int right) {
    if (left < right) {
      int midpoint = (right + left)/2;
      sort(a, left, midpoint);
      sort(a, midpoint + 1, right);
      merge(a, left, midpoint, right);
    }
  }

  private static void merge(int[] a, int left, int midpoint, int right) {
    int lowPointer, highPointer, insertPoint = 0;
    int[] temp = new int[right + 1];
    for(; insertPoint <= midpoint; insertPoint++) {
      temp[insertPoint] = a[insertPoint];
    }
    for(; insertPoint <= right; insertPoint++) {
      temp[insertPoint] = a[insertPoint];
    }
    insertPoint = lowPointer = 0;
    highPointer = midpoint + 1;
    while(lowPointer <= midpoint && highPointer <= right) {
      if (temp[lowPointer] < temp[highPointer]) {
        a[insertPoint++] = temp[lowPointer++];
      } else {
        a[insertPoint++] = temp[highPointer++];
      }
    }

    while(lowPointer <= midpoint) {
      a[insertPoint++] = temp[lowPointer++];
    }
    while(highPointer <= right) {
      a[insertPoint++] = temp[highPointer++];
    }
  }

}
